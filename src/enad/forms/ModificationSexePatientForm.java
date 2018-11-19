package enad.forms;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import enad.beans.Patient;
import enad.dao.DAOException;
import enad.dao.PatientDao;

public final class ModificationSexePatientForm {

	private static final String CHAMP_SEXE_PATIENT = "sexe";

	public static final String ATT_SESSION_PATIENT = "sessionPatient";

	private String resultat;

	private Map<String, String> erreurs = new HashMap<String, String>();

	private PatientDao patientDao;

	public ModificationSexePatientForm(PatientDao patientDao) {

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

	public Patient modifiersexePatient(HttpServletRequest request) {

		Patient patient = new Patient();

		HttpSession session = request.getSession();

		patient = (Patient) session.getAttribute(ATT_SESSION_PATIENT);

		String sexe = getValeurChamp(request, CHAMP_SEXE_PATIENT);

		try {

			traiterSexesPatients(sexe, patient);

			if (erreurs.isEmpty()) {

				patientDao.modifierSexePatient(patient);

				resultat = "Succès de la modification du sexe";

			} else {

				resultat = "Échec de la modification du sexe";

			}

		} catch (DAOException e) {
			resultat = "Échec de la modification du sexe : une erreur imprévue est survenue,merci de réessayer dans quelques instants.";
			e.printStackTrace();
		}

		return patient;

	}

	private void validationSexesPatients(String sexe) throws FormValidationException {

		if (sexe != null) {

			if (sexe.trim().length() != 0) {

			}
		} else {
			throw new FormValidationException("Veuillez choisir votre sexe.");
		}

	}

	private void traiterSexesPatients(String sexe, Patient patient) {

		try {

			validationSexesPatients(sexe);

		} catch (FormValidationException e) {

			setErreur(CHAMP_SEXE_PATIENT, e.getMessage());

		}

		patient.setSexe_patient(sexe);

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
