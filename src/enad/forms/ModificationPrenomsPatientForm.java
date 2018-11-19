package enad.forms;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import enad.beans.Patient;
import enad.dao.DAOException;
import enad.dao.PatientDao;

public final class ModificationPrenomsPatientForm {

	private static final String CHAMP_PRENOMS_PATIENT = "prenomsPatient";

	public static final String ATT_SESSION_PATIENT = "sessionPatient";

	private String resultat;

	private Map<String, String> erreurs = new HashMap<String, String>();

	private PatientDao patientDao;

	public ModificationPrenomsPatientForm(PatientDao patientDao) {

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

	public Patient modifierprenomsPatient(HttpServletRequest request) {

		Patient patient = new Patient();

		HttpSession session = request.getSession();

		patient = (Patient) session.getAttribute(ATT_SESSION_PATIENT);

		String prenomsPatient = getValeurChamp(request, CHAMP_PRENOMS_PATIENT);

		try {

			traiterPrenomsPatients(prenomsPatient, patient);

			if (erreurs.isEmpty()) {

				patientDao.modifierPrenomsPatient(patient);

				resultat = "Succès de la modification du prénom";

			} else {

				resultat = "Échec de la modification du prénom";

			}

		} catch (DAOException e) {
			resultat = "Échec de la modification du prénom : une erreur imprévue est survenue,merci de réessayer dans quelques instants.";
			e.printStackTrace();
		}

		return patient;

	}

	private void validationPrenomsPatients(String prenomsPatient) throws FormValidationException {

		if (prenomsPatient != null) {

			if (prenomsPatient.trim().length() != 0) {

			}
		} else {
			// Ne rien faire car le champ prénoms n'est pas obligatoire
		}

	}

	private void traiterPrenomsPatients(String prenomsPatient, Patient patient) {

		try {
			validationPrenomsPatients(prenomsPatient);
		} catch (FormValidationException e) {

			setErreur(CHAMP_PRENOMS_PATIENT, e.getMessage());

		}

		patient.setPrenoms_patient(prenomsPatient);

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
