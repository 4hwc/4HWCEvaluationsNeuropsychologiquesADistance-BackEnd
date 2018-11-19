/**
 * 
 */
package enad.forms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.jasypt.util.password.ConfigurablePasswordEncryptor;

import enad.beans.Medecin;
import enad.dao.DAOException;
import enad.dao.MedecinDao;
import enad.dao.PatientDao;
import enad.ip.MedecinIp;

/**
 * @author Admin
 *
 */
public final class InscriptionMedecinForm {

	private static final String CHAMP_PRENOMS_MEDECIN = "prenomsMedecin";

	private static final String CHAMP_NOMS_MEDECIN = "nomsMedecin";

	private static final String CHAMP_IDENTIFIANT_MEDECIN = "identifiantMedecin";

	private static final String CHAMP_CONF_IDENTIFIANT_MEDECIN = "confirmeidentifiantMedecin";

	private static final String CHAMP_MDP_MEDECIN = "mdpMedecin";

	private static final String CHAMP_CONF_MDP_MEDECIN = "confirmemdpMedecin";

	private static final String ALGO_CHIFFREMENT = "SHA-256";

	private String resultat;

	private Map<String, String> erreurs = new HashMap<String, String>();

	private MedecinDao medecinDao;

	private PatientDao patientDao;

	public InscriptionMedecinForm(MedecinDao medecinDao, PatientDao patientDao) {

		this.medecinDao = medecinDao;

		this.patientDao = patientDao;
	}

	/**
	 * @return the resultat
	 */
	public String getResultat() {
		return resultat;
	}

	/**
	 * @return the erreurs
	 */
	public Map<String, String> getErreurs() {
		return erreurs;
	}

	public Medecin inscrireMedecin(HttpServletRequest request) {

		String prenomsMedecin = getValeurChamp(request, CHAMP_PRENOMS_MEDECIN);

		String nomsMedecin = getValeurChamp(request, CHAMP_NOMS_MEDECIN);

		String identifiantMedecin = getValeurChamp(request, CHAMP_IDENTIFIANT_MEDECIN);

		String confidentifiantMedecin = getValeurChamp(request, CHAMP_CONF_IDENTIFIANT_MEDECIN);

		String mdpMedecin = getValeurChamp(request, CHAMP_MDP_MEDECIN);

		String confmdpMedecin = getValeurChamp(request, CHAMP_CONF_MDP_MEDECIN);

		Medecin medecin = new Medecin();

		try {

			traiterPrenomsMedecin(prenomsMedecin, medecin);
			traiterNomsMedecin(nomsMedecin, medecin);
			traiterIdentifiantsMedecin(identifiantMedecin, confidentifiantMedecin, medecin);
			traiterMdpsMedecin(mdpMedecin, confmdpMedecin, medecin);

			if (erreurs.isEmpty()) {

				medecinDao.creer(medecin);

				MedecinIp distribuer_ip = new MedecinIp(medecinDao);

				medecin.setIp_medecin(distribuer_ip.genererIpMedecin());

				medecinDao.creer_ip(medecin);

				resultat = "Succès de l'inscription";
			} else {
				resultat = "Échec de l'inscription";

			}

		} catch (DAOException e) {
			resultat = "Échec de l'inscription : une erreur imprévue est survenue,merci de réessayer dans quelques instants.";
			e.printStackTrace();
		}

		return medecin;

	}

	private void traiterPrenomsMedecin(String prenomsMedecin, Medecin medecin) {

		try {
			validationPrenomsMedecins(prenomsMedecin);

		} catch (FormValidationException e) {
			setErreur(CHAMP_PRENOMS_MEDECIN, e.getMessage());
		}

		medecin.setPrenoms_medecin(prenomsMedecin);

	}

	private void traiterNomsMedecin(String nomsMedecin, Medecin medecin) {

		try {
			validationNomsMedecins(nomsMedecin);

		} catch (FormValidationException e) {
			setErreur(CHAMP_NOMS_MEDECIN, e.getMessage());
		}

		medecin.setNoms_medecin(nomsMedecin);

	}

	private void traiterIdentifiantsMedecin(String identifiantMedecin, String confidentifiantMedecin, Medecin medecin) {

		try {
			validationIdentifiantsMedecins(identifiantMedecin, confidentifiantMedecin);

		} catch (FormValidationException e) {
			setErreur(CHAMP_IDENTIFIANT_MEDECIN, e.getMessage());
			setErreur(CHAMP_CONF_IDENTIFIANT_MEDECIN, null);
		}

		medecin.setIdentifiant_medecin(identifiantMedecin);

	}

	private void traiterMdpsMedecin(String mdpMedecin, String confmdpMedecin, Medecin medecin) {

		try {

			validationMdpsMedecins(mdpMedecin, confmdpMedecin);

		} catch (FormValidationException e) {
			setErreur(CHAMP_MDP_MEDECIN, e.getMessage());
			setErreur(CHAMP_CONF_MDP_MEDECIN, null);
		}

		ConfigurablePasswordEncryptor passwordEncryptor = new ConfigurablePasswordEncryptor();

		passwordEncryptor.setAlgorithm(ALGO_CHIFFREMENT);
		passwordEncryptor.setPlainDigest(false);
		String motDePasseChiffre = passwordEncryptor.encryptPassword(mdpMedecin);

		medecin.setMdp_medecin(motDePasseChiffre);

	}

	/* P 199 */

	/* Valide les prénoms saisis région france */

	/*
	 * Vérifier instantanément, ne pas forcément attendre que l'utilisateur
	 * clique sur submit
	 */

	/*
	 * Critères de validation des prénoms
	 * 
	 * 1) Ne doit pas commencer par un espace 2) Ne doit pas contenir uniquement
	 * des espaces 3) Se renseigner sur le net pour connaître les critères de
	 * validation des noms / prénoms / identifiants
	 */

	private void validationPrenomsMedecins(String prenomsMedecin) throws FormValidationException {

		if (prenomsMedecin != null) {

			if (prenomsMedecin.trim().length() != 0) {

				// if (prenomsMedecin.matches("#[a-zéèçàêâùûA-Z0-9_. -]+#")) {

				// } else {

				// throw new Exception("Veuillez entrer un ou des prénoms
				// valides.");

				// }

			}

		} else {
			// Ne rien faire car le champ prénoms n'est pas obligatoire
		}

	}

	private void validationNomsMedecins(String nomsMedecin) throws FormValidationException {

		if (nomsMedecin != null) {

			if (nomsMedecin.trim().length() != 0) {

				// if (nomsMedecin.matches("#[a-zéèçàêâùûA-Z0-9_. -]+#")) {

				// } else {

				// throw new Exception("Veuillez entrer un ou des noms
				// valides.");

				// }

			}

		} else {

			throw new FormValidationException("Veuillez entrer un ou des noms.");

		}
	}

	private void validationIdentifiantsMedecins(String identifiantMedecin, String confidentifiantMedecin)
			throws FormValidationException {

		if (identifiantMedecin != null && identifiantMedecin.trim().length() != 0 && confidentifiantMedecin != null
				&& confidentifiantMedecin.trim().length() != 0) {

			int nombre = MotAMot(identifiantMedecin).size();

			if (nombre > 1) {

				throw new FormValidationException("L'identifiant ne doit pas contenir d'espaces.");

			} else {

				if (!identifiantMedecin.equals(confidentifiantMedecin)) {

					throw new FormValidationException(
							"Les identifiants entrés sont différents,merci de les saisir à nouveau.");
				} else {

					if (identifiantMedecin.trim().length() < 4) {
						throw new FormValidationException("Les identifiants doivent contenir au moins 4 caractères.");
					} else {

						if (medecinDao.trouver(identifiantMedecin) != null
								|| patientDao.trouver(identifiantMedecin) != null) {
							throw new FormValidationException(
									"Cet identifiant est déjà utilisé, merci d'en choisir un autre.");
						}
					}
				}

			}

		} else {
			throw new FormValidationException("Merci de saisir et confirmer votre identifiant.");
		}
	}

	private void validationMdpsMedecins(String mdpMedecin, String confmdpMedecin) throws FormValidationException {

		if (mdpMedecin != null && mdpMedecin.trim().length() != 0 && confmdpMedecin != null
				&& confmdpMedecin.trim().length() != 0) {

			if (!mdpMedecin.equals(confmdpMedecin)) {

				throw new FormValidationException(
						"Les mots de passe entrés sont différents,merci de les saisir à nouveau.");
			} else if (mdpMedecin.trim().length() < 4) {
				throw new FormValidationException("Les mots de passe doivent contenir au moins 4 caractères.");
			}
		} else {
			throw new FormValidationException("Merci de saisir et confirmer votre mot de passe.");
		}
	}

	private ArrayList<String> MotAMot(String recherche) {

		ArrayList<String> DecoupeMot = new ArrayList<String>();

		String mot = null;

		String recherche_trim = recherche.trim();

		for (int i = 0; i < recherche_trim.length(); i++) {

			if (recherche_trim.charAt(i) != ' ') {

				mot = mot + recherche_trim.charAt(i);

				// Je récupère le dernier mot

				if (i == recherche_trim.length() - 1) {

					DecoupeMot.add(mot);

				}

			} else {

				if (recherche_trim.charAt(i - 1) != ' ') {

					DecoupeMot.add(mot);

					// Initialisation pour rechercher d'autres mots

					mot = null;
				} else {
					/*
					 * Rien à faire car les espaces n'ont pas d'intérêt pour
					 * être conservés. Ce sont juste des repères.
					 */
				}

			}

		}

		for (int j = 0; j < DecoupeMot.size(); j++) {

			DecoupeMot.set(j, DecoupeMot.get(j).substring(4)); // Enlever
																// null(4)
		}

		return DecoupeMot;
	}

	/*
	 * Ajoute un message correspondant au champ spécifié à la map des erreurs.
	 */

	private void setErreur(String champ, String message) {
		erreurs.put(champ, message);
	}

	/*
	 * Méthode utilitaire qui retourne null si un champ est vide, et son contenu
	 * sinon.
	 */

	private static String getValeurChamp(HttpServletRequest request, String nomChamp) {
		String valeur = request.getParameter(nomChamp);
		if (valeur == null || valeur.trim().length() == 0) {
			return null;
		} else
			return valeur.trim();
	}
}
