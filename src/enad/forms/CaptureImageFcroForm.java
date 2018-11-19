package enad.forms;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import enad.beans.ImageTestFcroBean;
import enad.dao.DAOException;
import enad.dao.ImageTestFcroBeanDao;
import enad.dao.MedecinDao;
import enad.dao.PatientDao;
import enad.dao.SeanceDao;
import eu.medsea.mimeutil.MimeUtil;

public final class CaptureImageFcroForm {

	private static final String IMAGEFCRO = "upload_img_fcro";

	private static final int TAILLE_TAMPON = 10240; // 10Ko A verifier

	private Map<String, String> erreurs = new HashMap<String, String>();

	public Map<String, String> getErreurs() {
		return erreurs;
	}

	private SeanceDao seanceDao;

	private PatientDao patientDao;

	private MedecinDao medecinDao;

	private ImageTestFcroBeanDao imagetestfcrobeanDao;

	public CaptureImageFcroForm(PatientDao patientDao, SeanceDao seanceDao, MedecinDao medecinDao,
			ImageTestFcroBeanDao imagetestfcrobeanDao) {

		this.imagetestfcrobeanDao = imagetestfcrobeanDao;

		this.seanceDao = seanceDao;

		this.patientDao = patientDao;

		this.medecinDao = medecinDao;

	}

	public void creerImageFcro(HttpServletRequest request, String chemin) {

		ImageTestFcroBean imgfcro = new ImageTestFcroBean();

		traiterImage(imgfcro, request, chemin);

		try {
			if (erreurs.isEmpty()) {

				String id_seance = request.getParameter("idseance");

				Long idseance = Long.parseLong(id_seance);

				imgfcro.setId_seance(idseance);

				imagetestfcrobeanDao.enregistrerImgFcro(imgfcro);

				System.out.println("Succès de l'enregistrement de l'image fcro");
			} else {
				System.out.println("Echec de l'enregistrement de l'image fcro");
			}
		} catch (DAOException e) {
			setErreur("imprévu", "Erreur imprévue lors de la création.");

			System.out.println(
					"Echec de la création de l'image fcro : une erreur imprévue est survenue,merci de réessayer dans quelques instants.");
			e.printStackTrace();
		}

	}

	private void traiterImage(ImageTestFcroBean imgfcro, HttpServletRequest request, String chemin) {
		String image = null;
		try {
			image = validationImage(request, chemin);
		} catch (FormValidationException e) {
			setErreur(IMAGEFCRO, e.getMessage());
		}

		// client.setImage(image);

		imgfcro.setNom_img_fcro(image);

		imgfcro.setUrl_img_fcro("/imagesdutestfcro/" + image);

	}

	private String validationImage(HttpServletRequest request, String chemin) throws FormValidationException {
		/*
		 * Récupération du contenu du champ image du formulaire. Il faut ici
		 * utiliser la méthode getPart().
		 */

		String nomFichier = null;
		InputStream contenuFichier = null;

		try {
			Part part = request.getPart(IMAGEFCRO);
			nomFichier = getNomFichier(part);

			/*
			 * Si la méthode getNomFichier() a renvoyé quelque chose, il s'agit
			 * donc d'un champ de type fichier (input type="file").
			 */

			if (nomFichier != null && !nomFichier.isEmpty()) {
				/*
				 * Antibug pour Internet Explorer, qui transmet pour une raison
				 * mystique le chemin du fichier local à la machine du client...
				 * 
				 * Ex: C:/dossier/sous-dossier/fichier.ext
				 * 
				 * On doit donc faire en sorte de ne sélectionner que le nom et
				 * l'extension du fichier, et de se débarasser du superflu.
				 */

				nomFichier = nomFichier.substring(nomFichier.lastIndexOf('/') + 1)
						.substring(nomFichier.lastIndexOf('\\') + 1);

				/* Récupération du contenu du fichier */

				contenuFichier = part.getInputStream();

				/* Extraction du type MIME du fichier depuis l'InputStream */

				MimeUtil.registerMimeDetector("eu.medsea.mimeutil.detector.MagicMimeMimeDetector");
				Collection<?> mimeTypes = MimeUtil.getMimeTypes(contenuFichier);

				/*
				 * Si le fichier est bien une image , alors son en-tête MIME
				 * commence par la chaîne "image"
				 */

				if (mimeTypes.toString().startsWith("image")) {
					/* Ecriture du fichier sur le disque */
					ecrireFichier(contenuFichier, nomFichier, chemin);
				} else {
					throw new FormValidationException("Le fichier envoyé doit être une image.");
				}

			}
		} catch (IllegalStateException e) {

			/*
			 * Expression retournée si la taille des données dépasse les limites
			 * définies dans la section <multipart-config> de la déclaration de
			 * notre servlet d'upload dans le fichier web.xml
			 */

			e.printStackTrace();
			throw new FormValidationException("Le fichier envoyé ne doit pas dépasser 1Mo.");

		} catch (IOException e) {

			/*
			 * Exception retournée si une erreur au niveau des répertoires de
			 * stockage survient (répertoire inexistant,droits d'accès
			 * insuffisants,etc.
			 */

			e.printStackTrace();

			throw new FormValidationException("Erreur de configuration du serveur.");
		} catch (ServletException e) {
			/*
			 * Exception retournée si la requête n'est pas de type
			 * multipart/form-data.
			 */

			e.printStackTrace();

			throw new FormValidationException(
					"Ce type de requête n'est pas supporté, merci d'utiliser le formulaire prévu pour envoyer votre fichier");
		}

		return nomFichier;
	}

	/* Ajoute un message correspondant au champ spécifié à la map des erreurs */

	private void setErreur(String champ, String message) {
		erreurs.put(champ, message);

	}

	/*
	 * Méthode utilitaire qui a pour but unique d'analyser l'en-tête
	 * "content-disposition", et de vérifier si le paramètre "filename" y est
	 * présent. Si oui, alors le champ traité est de type File et la méthode
	 * retourne son nom, sinon il s'agit d'un champ de formulaire classique et
	 * la méthode retourne null
	 */

	private static String getNomFichier(Part part) {
		/*
		 * Boucle sur chacun des paramètres de l'en-ête "content-disposition".
		 */

		for (String contentDisposition : part.getHeader("content-disposition").split(";")) {
			/* Recherche de l'éventuelle présence du paramètre "filename". */

			if (contentDisposition.trim().startsWith("filename")) {
				/*
				 * Si "filename" est présent, alors renvoi de sa valeur,
				 * c'est-à-dire du nom de fichier sans guillemets.
				 */

				return contentDisposition.substring(contentDisposition.indexOf('=') + 1).trim().replace("\"", "");
			}
		}

		/* Et pour terminer, si rien n'a été trouvé... */
		return null;
	}

	/*
	 * Méthode utilitaire qui a pour but d'écrire le fichier passé en paramètre
	 * sur le disque, dans le répertoire donné et avec le nom donné.
	 */

	private void ecrireFichier(InputStream contenuFichier, String nomFichier, String chemin)
			throws FormValidationException {
		/* Prépare les flux */

		BufferedInputStream entree = null;
		BufferedOutputStream sortie = null;

		try {
			/* Ouvre les flux */

			entree = new BufferedInputStream(contenuFichier, TAILLE_TAMPON);
			sortie = new BufferedOutputStream(new FileOutputStream(new File(chemin + nomFichier)), TAILLE_TAMPON);

			/*
			 * Lit le fichier reçu et écrit son contenu dans un fichier sur le
			 * disque
			 */

			byte[] tampon = new byte[TAILLE_TAMPON];
			int longueur = 0;

			while ((longueur = entree.read(tampon)) > 0) {
				sortie.write(tampon, 0, longueur);
			}
		} catch (Exception e) {
			throw new FormValidationException("Erreur lors de l'écriture du fichier sur le disque.");
		} finally {
			try {
				sortie.close();
			} catch (IOException ignore) {

			}
			try {
				entree.close();
			} catch (IOException ignore) {

			}
		}
	}

}
