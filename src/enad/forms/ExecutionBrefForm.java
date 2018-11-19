package enad.forms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import enad.beans.Bref;
import enad.beans.Medecin;
import enad.beans.Patient;
import enad.dao.BrefDao;
import enad.dao.DAOException;
import enad.dao.MedecinDao;
import enad.dao.PatientDao;

public final class ExecutionBrefForm {

	private static final String CHAMP_scoreEpreuveSimilitudes = "scoreEpreuveSimilitudes";

	private static final String CHAMP_scoreEpreuveFluenceVerbale = "scoreEpreuveFluenceVerbale";

	private static final String CHAMP_scoreComportementPrehension = "scoreComportementPrehension";

	private static final String CHAMP_scoreSequencesMotricesLuria = "scoreSequencesMotricesLuria";

	private static final String CHAMP_scoreEpreuveConsignesConflictuelles = "scoreEpreuveConsignesConflictuelles";

	private static final String CHAMP_scoreEpreuveGoNoGo = "scoreEpreuveGoNoGo";

	private static final String CHAMP_CHOIX_PATIENT = "choixPatient";

	public static final String ATT_SESSION_MEDECIN = "sessionMedecin";

	private MedecinDao medecinDao;

	private PatientDao patientDao;

	private BrefDao brefDao;

	int scoreEpreuveSimilitudes;

	int scoreEpreuveFluenceVerbale;

	int scoreComportementPrehension;

	int scoreSequencesMotricesLuria;

	int scoreEpreuveConsignesConflictuelles;

	int scoreEpreuveGoNoGo;

	int scoretotal;

	Patient patient;

	Medecin medecin;

	private Map<String, String> erreurs = new HashMap<String, String>();

	private String resultat;

	public ExecutionBrefForm(BrefDao brefDao, MedecinDao medecinDao, PatientDao patientDao) {

		this.brefDao = brefDao;

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

	public ArrayList<Patient> listePatients(HttpServletRequest request) {

		/*
		 * Le patient peut provenir d'une relation medpat et/ou d'une relation
		 * medtpat.
		 * 
		 * Il y'a risque de doublons
		 */

		int occurences_resultats_patients;

		ArrayList<Patient> Patientsmedpat = new ArrayList<Patient>();

		ArrayList<Patient> Patientsmedtraitantpat = new ArrayList<Patient>();

		ArrayList<Patient> listesansdoublons = new ArrayList<Patient>();

		/* Récupération de la session depuis la requête */

		HttpSession session = request.getSession();

		Medecin medecino = (Medecin) session.getAttribute(ATT_SESSION_MEDECIN);

		String identifiant = medecino.getIdentifiant_medecin();

		Patientsmedpat = medecinDao.trouver_patients_med(identifiant, patientDao);

		for (int i = 0; i < Patientsmedpat.size(); i++) {

			listesansdoublons.add(Patientsmedpat.get(i));
		}

		Patientsmedtraitantpat = medecinDao.trouver_patients_medtraitant(identifiant, patientDao);

		for (int j = 0; j < Patientsmedtraitantpat.size(); j++) {

			listesansdoublons.add(Patientsmedtraitantpat.get(j));
		}

		// enlève doublons

		for (int tour1 = 0; tour1 < listesansdoublons.size(); tour1++) {

			occurences_resultats_patients = 0;

			for (int tour2 = 0; tour2 < listesansdoublons.size(); tour2++) {

				if (listesansdoublons.get(tour1).getId_patient() == listesansdoublons.get(tour2).getId_patient()) {

					occurences_resultats_patients++;

					if (occurences_resultats_patients > 1) {

						listesansdoublons.remove(tour2);

					}

				}

			}
		}

		return listesansdoublons;

	}

	public Bref creerBref(HttpServletRequest request) {

		String scoreses = getValeurChamp(request, CHAMP_scoreEpreuveSimilitudes);

		String scoreefv = getValeurChamp(request, CHAMP_scoreEpreuveFluenceVerbale);

		String scorecp = getValeurChamp(request, CHAMP_scoreComportementPrehension);

		String scoresml = getValeurChamp(request, CHAMP_scoreSequencesMotricesLuria);

		String scoreecc = getValeurChamp(request, CHAMP_scoreEpreuveConsignesConflictuelles);

		String scoregonogo = getValeurChamp(request, CHAMP_scoreEpreuveGoNoGo);

		String identifiantPatient = getValeurChamp(request, CHAMP_CHOIX_PATIENT);

		Bref bref = new Bref();

		HttpSession session = request.getSession();

		Medecin medecina = (Medecin) session.getAttribute(ATT_SESSION_MEDECIN);

		try {

			traiterChoixPatient(identifiantPatient, bref);

			traiter_scoreEpreuveSimilitudes(scoreses, bref);

			traiter_scoreEpreuveFluenceVerbale(scoreefv, bref);

			traiter_scoreComportementPrehension(scorecp, bref);

			traiter_scoreSequencesMotricesLuria(scoresml, bref);

			traiter_scoreEpreuveConsignesConflictuelles(scoreecc, bref);

			traiter_scoreEpreuveGoNoGo(scoregonogo, bref);

			scoretotal = scoreEpreuveSimilitudes + scoreEpreuveFluenceVerbale + scoreComportementPrehension
					+ scoreSequencesMotricesLuria + scoreEpreuveConsignesConflictuelles + scoreEpreuveGoNoGo;

			bref.setScoreTotalBref(scoretotal);

			if (erreurs.isEmpty()) {

				bref.setIdentifiant_medecin(medecina.getIdentifiant_medecin());

				bref.setPrenoms_noms_medecin(medecina.getPrenoms_medecin() + " " + medecina.getNoms_medecin());

				bref.setPrenoms_noms_patient(patient.getPrenoms_patient() + " " + patient.getNoms_patient());

				brefDao.creer(bref);

				resultat = "Succès de l'enregistrement du résultat";

			} else {
				resultat = "Échec de l'enregistrement du résultat";

			}

		} catch (DAOException e) {
			resultat = "Échec de l'enregistrement du résultat du BREF : une erreur imprévue est survenue,merci de réessayer dans quelques instants.";
			e.printStackTrace();
		}

		return bref;

	}

	private void validationChoixPatient(String identifiantPatient) throws FormValidationException {

		if (identifiantPatient != null) {

			if (identifiantPatient.trim().length() != 0) {

			}
		} else {
			throw new FormValidationException("Veuillez choisir un patient ou une patiente.");
		}

	}

	private void traiterChoixPatient(String identifiantPatient, Bref bref) {

		try {

			validationChoixPatient(identifiantPatient);

		} catch (FormValidationException e) {

			setErreur(CHAMP_CHOIX_PATIENT, e.getMessage());

		}

		patient = patientDao.trouver(identifiantPatient);

		bref.setIdentifiant_patient(identifiantPatient);

	}

	private void validation_scoreEpreuveSimilitudes(String score) throws FormValidationException {

		int scorereel = Integer.parseInt(score);

		if (scorereel <= 3 && scorereel >= 0) {

			// OK

		} else {

			throw new FormValidationException("Le score est compris entre 0 et 3, merci de  saisir à nouveau.");

		}

	}

	private void traiter_scoreEpreuveSimilitudes(String score, Bref bref) {

		try {
			validation_scoreEpreuveSimilitudes(score);
		} catch (FormValidationException e) {

			setErreur(CHAMP_scoreEpreuveSimilitudes, e.getMessage());

		}

		scoreEpreuveSimilitudes = Integer.parseInt(score);

		bref.setScoreEpreuveSimilitudes(Integer.parseInt(score));

	}

	private void validation_scoreEpreuveFluenceVerbale(String score) throws FormValidationException {

		int scorereel = Integer.parseInt(score);

		if (scorereel <= 3 && scorereel >= 0) {

			// OK

		} else {

			throw new FormValidationException("Le score est compris entre 0 et 3, merci de  saisir à nouveau.");

		}

	}

	private void traiter_scoreEpreuveFluenceVerbale(String score, Bref bref) {

		try {
			validation_scoreEpreuveFluenceVerbale(score);
		} catch (FormValidationException e) {

			setErreur(CHAMP_scoreEpreuveFluenceVerbale, e.getMessage());

		}

		scoreEpreuveFluenceVerbale = Integer.parseInt(score);

		bref.setScoreEpreuveFluenceVerbale(Integer.parseInt(score));

	}

	private void validation_scoreComportementPrehension(String score) throws FormValidationException {

		int scorereel = Integer.parseInt(score);

		if (scorereel <= 3 && scorereel >= 0) {

			// OK

		} else {

			throw new FormValidationException("Le score est compris entre 0 et 3, merci de  saisir à nouveau.");

		}

	}

	private void traiter_scoreComportementPrehension(String score, Bref bref) {

		try {
			validation_scoreComportementPrehension(score);
		} catch (FormValidationException e) {

			setErreur(CHAMP_scoreComportementPrehension, e.getMessage());

		}

		scoreComportementPrehension = Integer.parseInt(score);

		bref.setScoreComportementPrehension(Integer.parseInt(score));

	}

	private void validation_scoreSequencesMotricesLuria(String score) throws FormValidationException {

		int scorereel = Integer.parseInt(score);

		if (scorereel <= 3 && scorereel >= 0) {

			// OK

		} else {

			throw new FormValidationException("Le score est compris entre 0 et 3, merci de  saisir à nouveau.");

		}

	}

	private void traiter_scoreSequencesMotricesLuria(String score, Bref bref) {

		try {
			validation_scoreSequencesMotricesLuria(score);
		} catch (FormValidationException e) {

			setErreur(CHAMP_scoreSequencesMotricesLuria, e.getMessage());

		}

		scoreSequencesMotricesLuria = Integer.parseInt(score);

		bref.setScoreSequencesMotricesLuria(Integer.parseInt(score));

	}

	private void validation_scoreEpreuveConsignesConflictuelles(String score) throws FormValidationException {

		int scorereel = Integer.parseInt(score);

		if (scorereel <= 3 && scorereel >= 0) {

			// OK

		} else {

			throw new FormValidationException("Le score est compris entre 0 et 3, merci de  saisir à nouveau.");

		}

	}

	private void traiter_scoreEpreuveConsignesConflictuelles(String score, Bref bref) {

		try {
			validation_scoreEpreuveConsignesConflictuelles(score);
		} catch (FormValidationException e) {

			setErreur(CHAMP_scoreEpreuveConsignesConflictuelles, e.getMessage());

		}

		scoreEpreuveConsignesConflictuelles = Integer.parseInt(score);

		bref.setScoreEpreuveConsignesConflictuelles(Integer.parseInt(score));

	}

	private void validation_scoreEpreuveGoNoGo(String score) throws FormValidationException {

		int scorereel = Integer.parseInt(score);

		if (scorereel <= 3 && scorereel >= 0) {

			// OK

		} else {

			throw new FormValidationException("Le score est compris entre 0 et 3, merci de  saisir à nouveau.");

		}

	}

	private void traiter_scoreEpreuveGoNoGo(String score, Bref bref) {

		try {
			validation_scoreEpreuveGoNoGo(score);
		} catch (FormValidationException e) {

			setErreur(CHAMP_scoreEpreuveGoNoGo, e.getMessage());

		}

		scoreEpreuveGoNoGo = Integer.parseInt(score);

		bref.setScoreEpreuveGoNoGo(Integer.parseInt(score));

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
