package enad.forms;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import enad.beans.Patient;
import enad.dao.DAOException;
import enad.dao.PatientDao;

public final class ModificationMassePatientForm {

	private static final String CHAMP_MASSE_PATIENT = "massePatient";

	public static final String ATT_SESSION_PATIENT = "sessionPatient";

	private String resultat;

	private String massecorrecte = new String();

	private Map<String, String> erreurs = new HashMap<String, String>();

	private PatientDao patientDao;

	public ModificationMassePatientForm(PatientDao patientDao) {

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

	public Patient modifiermassePatient(HttpServletRequest request) {

		Patient patient = new Patient();

		HttpSession session = request.getSession();

		patient = (Patient) session.getAttribute(ATT_SESSION_PATIENT);

		String massePatient = getValeurChamp(request, CHAMP_MASSE_PATIENT);

		try {

			traiterMassePatient(massePatient, patient);

			if (erreurs.isEmpty()) {

				patientDao.modifierMassePatient(patient);

				resultat = "Succès de la modification de la masse";

			} else {

				resultat = "Échec de la modification de la masse";

			}

		} catch (DAOException e) {
			resultat = "Échec de la modification de la masse : une erreur imprévue est survenue,merci de réessayer dans quelques instants.";
			e.printStackTrace();
		}

		return patient;

	}

	private void validationMassePatient(String massePatient) throws FormValidationException {

		if (massePatient != null) {

			if (massePatient.trim().length() != 0) {

				if (massePatient.matches("^[0-9]+$") || massePatient.matches("^[0-9]+[.][0-9]+$")) {

					massecorrecte = "oui";

				} else {

					massecorrecte = "non";

					throw new FormValidationException("Veuillez entrer votre masse corporelle correctement.");

				}

			}
		} else {
			throw new FormValidationException("Veuillez entrer votre masse corporelle.");
		}

	}

	private void traiterMassePatient(String massePatient, Patient patient) {

		try {
			validationMassePatient(massePatient);
		} catch (FormValidationException e) {

			setErreur(CHAMP_MASSE_PATIENT, e.getMessage());
		}

		if (massecorrecte.equals("oui")) {

			patient.setMasse_patient(Double.parseDouble(massePatient));

		}

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
