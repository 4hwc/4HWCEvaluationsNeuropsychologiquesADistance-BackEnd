package enad.forms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import enad.beans.Patient;
import enad.dao.DAOException;
import enad.dao.MedecinDao;
import enad.dao.PatientDao;

public final class ModificationIdentifiantPatientForm {

	private static final String CHAMP_IDENTIFIANT_PATIENT = "identifiantPatient";

	private static final String CHAMP_CONF_IDENTIFIANT_PATIENT = "confirmeidentifiantPatient";

	public static final String ATT_SESSION_PATIENT = "sessionPatient";

	private String resultat;

	public String erreur_espace = new String();

	public String erreur_difference = new String();

	public String erreur_quatre = new String();

	public String erreur_unique = new String();

	private Map<String, String> erreurs = new HashMap<String, String>();

	private PatientDao patientDao;

	private MedecinDao medecinDao;

	public String ancienidentifiant;

	public ModificationIdentifiantPatientForm(PatientDao patientDao, MedecinDao medecinDao) {

		this.patientDao = patientDao;

		this.medecinDao = medecinDao;
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

	public Patient modifieridentifiantPatient(HttpServletRequest request) {

		Patient patient = new Patient();

		HttpSession session = request.getSession();

		patient = (Patient) session.getAttribute(ATT_SESSION_PATIENT);

		ancienidentifiant = patient.getIdentifiant_patient();

		String identifiantPatient = getValeurChamp(request, CHAMP_IDENTIFIANT_PATIENT);

		String confidentifiantPatient = getValeurChamp(request, CHAMP_CONF_IDENTIFIANT_PATIENT);

		try {

			traiterIdentifiantsPatients(identifiantPatient, confidentifiantPatient, patient);

			if (erreurs.isEmpty()) {

				patient.setIdentifiant_patient(identifiantPatient);

				patientDao.modifierIdentifiantPatient(patient);

				resultat = "Succès de la modification de l'identifiant";

				System.out.println(resultat);

			} else {

				resultat = "Échec de la modification de l'identifiant";

				System.out.println(resultat);

			}

		} catch (DAOException e) {
			resultat = "Échec de la modification de l'identifiant : une erreur imprévue est survenue,merci de réessayer dans quelques instants.";
			e.printStackTrace();
		}

		return patient;

	}

	private void validationIdentifiantsPatients(String identifiantPatient, String confidentifiantPatient)
			throws FormValidationException {

		if (identifiantPatient != null && identifiantPatient.trim().length() != 0 && confidentifiantPatient != null
				&& confidentifiantPatient.trim().length() != 0) {

			int nombre = MotAMot(identifiantPatient).size();

			if (nombre > 1) {

				erreur_espace = "L'identifiant ne doit pas contenir d'espaces.";

				throw new FormValidationException("L'identifiant ne doit pas contenir d'espaces.");

			} else {

				if (!identifiantPatient.equals(confidentifiantPatient)) {

					erreur_difference = "Les identifiants entrés sont différents,merci de les saisir à nouveau.";

					throw new FormValidationException(
							"Les identifiants entrés sont différents,merci de les saisir à nouveau.");
				} else {

					if (identifiantPatient.trim().length() < 4) {

						erreur_quatre = "Les identifiants doivent contenir au moins 4 caractères.";

						throw new FormValidationException("Les identifiants doivent contenir au moins 4 caractères.");
					} else {

						if (patientDao.trouver(identifiantPatient) != null
								|| medecinDao.trouver(identifiantPatient) != null) {

							erreur_unique = "Cet identifiant est déjà utilisé, merci d'en choisir un autre.";

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

	private void traiterIdentifiantsPatients(String identifiantPatient, String confidentifiantPatient,
			Patient patient) {

		try {
			validationIdentifiantsPatients(identifiantPatient, confidentifiantPatient);
		} catch (FormValidationException e) {
			setErreur(CHAMP_IDENTIFIANT_PATIENT, e.getMessage());
			setErreur(CHAMP_CONF_IDENTIFIANT_PATIENT, null);
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
