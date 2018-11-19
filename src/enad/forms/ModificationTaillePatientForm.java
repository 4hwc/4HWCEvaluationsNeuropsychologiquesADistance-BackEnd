package enad.forms;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import enad.beans.Patient;
import enad.dao.DAOException;
import enad.dao.PatientDao;

public final class ModificationTaillePatientForm {

	private static final String CHAMP_TAILLE_PATIENT = "taillePatient";

	public static final String ATT_SESSION_PATIENT = "sessionPatient";

	private String resultat;

	private String taillecorrecte = new String();

	private Map<String, String> erreurs = new HashMap<String, String>();

	private PatientDao patientDao;

	public ModificationTaillePatientForm(PatientDao patientDao) {

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

	public Patient modifiertaillePatient(HttpServletRequest request) {

		Patient patient = new Patient();

		HttpSession session = request.getSession();

		patient = (Patient) session.getAttribute(ATT_SESSION_PATIENT);

		String taillePatient = getValeurChamp(request, CHAMP_TAILLE_PATIENT);

		try {

			traiterTaillePatient(taillePatient, patient);

			if (erreurs.isEmpty()) {

				patientDao.modifierTaillePatient(patient);

				resultat = "Succès de la modification de la taille";

			} else {

				resultat = "Échec de la modification de la taille";

			}

		} catch (DAOException e) {
			resultat = "Échec de la modification de la taille : une erreur imprévue est survenue,merci de réessayer dans quelques instants.";
			e.printStackTrace();
		}

		return patient;

	}

	private void validationTaillePatient(String taillePatient) throws FormValidationException {

		if (taillePatient != null) {

			if (taillePatient.trim().length() != 0) {

				if (taillePatient.matches("^[0-9]+$") || taillePatient.matches("^[0-9]+[.][0-9]+$")) {

					taillecorrecte = "oui";

				} else {

					taillecorrecte = "non";

					throw new FormValidationException("Veuillez entrer votre taille  correctement.");

				}

			}
		} else {
			throw new FormValidationException("Veuillez entrer votre taille.");
		}

	}

	private void traiterTaillePatient(String taillePatient, Patient patient) {

		try {
			validationTaillePatient(taillePatient);
		} catch (FormValidationException e) {

			setErreur(CHAMP_TAILLE_PATIENT, e.getMessage());
		}

		if (taillecorrecte.equals("oui")) {

			patient.setMasse_patient(Double.parseDouble(taillePatient));

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
