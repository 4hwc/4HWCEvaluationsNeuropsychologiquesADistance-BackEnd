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
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import enad.beans.Medecin;
import enad.dao.DAOException;
import enad.dao.MedecinDao;
import eu.medsea.mimeutil.MimeUtil;

public final class UploadImagesPhotoProfilMedecinForm {

	private static final String IMAGEPHOTOMEDECIN = "upload_img_photomedecin";

	private static final int TAILLE_TAMPON = 10240; // 10Ko A verifier

	private Map<String, String> erreurs = new HashMap<String, String>();

	String nom_photo_medecin;

	String url_nom_photo_medecin;

	public static final String ATT_SESSION_MEDECIN = "sessionMedecin";

	public Map<String, String> getErreurs() {
		return erreurs;
	}

	private MedecinDao medecinDao;

	public UploadImagesPhotoProfilMedecinForm(MedecinDao medecinDao) {

		this.medecinDao = medecinDao;

	}

	public void creerImageMedecin(HttpServletRequest request, String chemin) {

		HttpSession session = request.getSession();

		Medecin medecin = (Medecin) (session.getAttribute(ATT_SESSION_MEDECIN));

		traiterImage(medecin, request, chemin);

		try {
			if (erreurs.isEmpty()) {

				String nom = new String();

				nom = medecin.getPhoto_medecin();

				if (nom == null) {

					System.out.println("nom null");

					// Le médecin n'a pas de photo enregistrée

				} else {

					String path = "C:\\fichiers\\imagesphotoprofilmedecin\\" + nom;

					try {

						File file = new File(path);

						if (file.delete()) {
							System.out.println(file.getName() + " is deleted!");
						} else {
							System.out.println("Delete operation is failed.");
						}

					} catch (Exception e) {

						e.printStackTrace();

					}

				}

				// updatebdd

				medecin.setPhoto_medecin(nom_photo_medecin);

				medecin.setUrl_photo_medecin(url_nom_photo_medecin);

				medecinDao.uploadphoto(medecin);

				System.out.println("Succès de l'enregistrement de l'image du médecin");
			} else {
				System.out.println("Echec de l'enregistrement de l'image du médecin");
			}
		} catch (DAOException e) {
			setErreur("imprévu", "Erreur imprévue lors de la création.");

			System.out.println(
					"Echec de la création de l'image medecin : une erreur imprévue est survenue,merci de réessayer dans quelques instants.");
			e.printStackTrace();
		}

	}

	private void traiterImage(Medecin medecin, HttpServletRequest request, String chemin) {
		String image = null;

		try {
			image = validationImage(request, chemin);
		} catch (FormValidationException e) {
			setErreur(IMAGEPHOTOMEDECIN, e.getMessage());
		}

		nom_photo_medecin = image;

		url_nom_photo_medecin = "/imagesphotoprofilmedecin/" + image;

	}

	private String validationImage(HttpServletRequest request, String chemin) throws FormValidationException {
		/*
		 * Récupération du contenu du champ image du formulaire. Il faut ici
		 * utiliser la méthode getPart().
		 */

		String nomFichier = null;
		String nomfinal = null;
		InputStream contenuFichier = null;
		String nom_supplementaire = null;
		long chrono2;

		try {
			Part part = request.getPart(IMAGEPHOTOMEDECIN);
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

				chrono2 = java.lang.System.currentTimeMillis();

				nom_supplementaire = chrono2 + "_";

				nomfinal = nom_supplementaire + nomFichier;

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
					ecrireFichier(contenuFichier, nomfinal, chemin);
				} else {
					System.out.println("Le fichier envoyé ne doit pas dépasser 1Mo.");

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
			System.out.println("Le fichier envoyé ne doit pas dépasser 1Mo.");

			throw new FormValidationException("Le fichier envoyé ne doit pas dépasser 1Mo.");

		} catch (IOException e) {

			/*
			 * Exception retournée si une erreur au niveau des répertoires de
			 * stockage survient (répertoire inexistant,droits d'accès
			 * insuffisants,etc.
			 */

			e.printStackTrace();

			System.out.println("Erreur de configuration du serveur.");

			throw new FormValidationException("Erreur de configuration du serveur.");
		} catch (ServletException e) {
			/*
			 * Exception retournée si la requête n'est pas de type
			 * multipart/form-data.
			 */

			e.printStackTrace();

			System.out.println(
					"Ce type de requête n'est pas supporté, merci d'utiliser le formulaire prévu pour envoyer votre fichier");

			throw new FormValidationException(
					"Ce type de requête n'est pas supporté, merci d'utiliser le formulaire prévu pour envoyer votre fichier");
		}

		return nomfinal;
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

			System.out.println("Erreur lors de l'écriture du fichier sur le disque.");

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
