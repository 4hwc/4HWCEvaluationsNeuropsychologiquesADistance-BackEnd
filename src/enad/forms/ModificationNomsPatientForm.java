package enad.forms;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import enad.beans.Patient;
import enad.dao.DAOException;
import enad.dao.PatientDao;

public final class ModificationNomsPatientForm {

	private static final String CHAMP_NOMS_PATIENT = "nomsPatient";

	public static final String ATT_SESSION_PATIENT = "sessionPatient";

	private String resultat;

	private Map<String, String> erreurs = new HashMap<String, String>();

	private PatientDao patientDao;

	public ModificationNomsPatientForm(PatientDao patientDao) {

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

	public Patient modifiernomsPatient(HttpServletRequest request) {

		Patient patient = new Patient();

		HttpSession session = request.getSession();

		patient = (Patient) session.getAttribute(ATT_SESSION_PATIENT);

		String nomsPatient = getValeurChamp(request, CHAMP_NOMS_PATIENT);

		try {

			traiterNomsPatients(nomsPatient, patient);

			if (erreurs.isEmpty()) {

				// medecinDao.modifierNomsMedecin(medecin);

				patientDao.modifierNomsPatient(patient);

				resultat = "Succès de la modification du nom";

			} else {

				resultat = "Échec de la modification du nom";

			}

		} catch (DAOException e) {
			resultat = "Échec de la modification du nom : une erreur imprévue est survenue,merci de réessayer dans quelques instants.";
			e.printStackTrace();
		}

		return patient;

	}

	private void validationNomsPatients(String nomsPatient) throws FormValidationException {

		if (nomsPatient != null) {

			if (nomsPatient.trim().length() != 0) {

			}
		} else {
			throw new FormValidationException("Veuillez entrer un ou des noms.");
		}

	}

	private void traiterNomsPatients(String nomsPatient, Patient patient) {

		try {
			validationNomsPatients(nomsPatient);
		} catch (FormValidationException e) {

			setErreur(CHAMP_NOMS_PATIENT, e.getMessage());
		}

		patient.setNoms_patient(nomsPatient);

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
