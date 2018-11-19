/**
 * 
 */
package enad.forms;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import enad.beans.Patient;
import enad.dao.DAOException;
import enad.dao.PatientDao;
import enad.ip.PatientIp;

/**
 * @author Admin
 *
 */
public final class RechercheParIdentifiantsPatientForm {

	private static final String CHAMP_IDENTIFIANT_PATIENT = "rechercheparidentifiantsPatients";

	private Map<String, String> erreurs = new HashMap<String, String>();

	private String resultat;

	private String identifiant_correct = null;

	private PatientDao patientDao;

	public RechercheParIdentifiantsPatientForm(PatientDao patientDao) {

		this.patientDao = patientDao;
	}

	/**
	 * @return the erreurs
	 */
	public Map<String, String> getErreurs() {
		return erreurs;
	}

	public Patient connecterIdentifiantsPatient(HttpServletRequest request) {

		String identifiantPatient = getValeurChamp(request, CHAMP_IDENTIFIANT_PATIENT);

		Patient patient = new Patient();

		try {
			traiterIdentifiantPatient(identifiantPatient, patient);

		} catch (DAOException e) {

			resultat = "Échec de la connexion : une erreur imprévue est survenue,merci de réessayer dans quelques instants.";
			e.printStackTrace();
		}

		if (identifiant_correct != null) {

			patientDao.creer_ip(patient);

			return patientDao.trouver(identifiant_correct);

		} else {
			return patient;
		}

	}

	private void validationIdentifiantPatient(String identifiantPatient) throws FormValidationException {

		if (identifiantPatient != null && identifiantPatient.trim().length() != 0) {

			if (identifiantPatient.trim().length() < 4) {

				throw new FormValidationException("L'identifiant doit contenir au moins 4 caractères.");

			} else {

				if (patientDao.trouver(identifiantPatient) != null) {

					// cas bon

					identifiant_correct = identifiantPatient;

				} else {
					throw new FormValidationException(
							"Cet identifiant est inexistant, veuillez corriger l'identifiant ou vous inscrire.");

				}
			}
		}

	}

	private void traiterIdentifiantPatient(String identifiantPatient, Patient patient) {

		try {

			validationIdentifiantPatient(identifiantPatient);

		} catch (FormValidationException e) {
			setErreur(CHAMP_IDENTIFIANT_PATIENT, e.getMessage());
		}

		if (identifiant_correct != null) {

			patient.setId_patient(patientDao.trouver(identifiant_correct).getId_patient());

			PatientIp distribuer_ip = new PatientIp(patientDao);

			patient.setIp_patient(distribuer_ip.genererIpPatient());

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
