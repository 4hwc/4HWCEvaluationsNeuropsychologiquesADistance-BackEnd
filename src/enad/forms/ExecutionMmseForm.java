package enad.forms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import enad.beans.Medecin;
import enad.beans.Mmse;
import enad.beans.Patient;
import enad.dao.DAOException;
import enad.dao.MedecinDao;
import enad.dao.MmseDao;
import enad.dao.PatientDao;

public final class ExecutionMmseForm {

	private static final String CHAMP_scoreOrientation = "scoreOrientation";

	private static final String CHAMP_scoreApprentissage = "scoreApprentissage";

	private static final String CHAMP_scoreAttentionEtCalcul = "scoreAttentionEtCalcul";

	private static final String CHAMP_scoreRappel = "scoreRappel";

	private static final String CHAMP_scoreLangage = "scoreLangage";

	private static final String CHAMP_imageLangage_oui_non = "phrase_ecrire";

	private static final String CHAMP_scorePraxiesConstructives = "scorePraxiesConstructives";

	private static final String CHAMP_imagePraxiesConstructives_oui_non = "dessin_recopier";

	private static final String CHAMP_CHOIX_PATIENT = "choixPatient";

	private static final String CHAMP_INVISIBLE = "name_champ_aleatoire";

	public static final String ATT_SESSION_MEDECIN = "sessionMedecin";

	private MedecinDao medecinDao;

	private PatientDao patientDao;

	private MmseDao mmseDao;

	int scoreOrientation;

	int scoreApprentissage;

	int scoreAttentionEtCalcul;

	int scoreRappel;

	int scoreLangage;

	int scorePraxiesConstructives;

	int scoretotal;

	Patient patient;

	Medecin medecin;

	private Map<String, String> erreurs = new HashMap<String, String>();

	private String resultat;

	public ExecutionMmseForm(MmseDao mmseDao, MedecinDao medecinDao, PatientDao patientDao) {

		this.mmseDao = mmseDao;

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

	public Mmse creerMmse(HttpServletRequest request) {

		String scoreo = getValeurChamp(request, CHAMP_scoreOrientation);

		String scorea = getValeurChamp(request, CHAMP_scoreApprentissage);

		String scoreaec = getValeurChamp(request, CHAMP_scoreAttentionEtCalcul);

		String scorer = getValeurChamp(request, CHAMP_scoreRappel);

		String scorel = getValeurChamp(request, CHAMP_scoreLangage);

		String imageLangage_oui_non = getValeurChamp(request, CHAMP_imageLangage_oui_non);

		String scorepc = getValeurChamp(request, CHAMP_scorePraxiesConstructives);

		String imagePraxiesConstructives_oui_non = getValeurChamp(request, CHAMP_imagePraxiesConstructives_oui_non);

		String identifiantPatient = getValeurChamp(request, CHAMP_CHOIX_PATIENT);

		String champinvisible = getValeurChamp(request, CHAMP_INVISIBLE);

		Mmse mmse = new Mmse();

		HttpSession session = request.getSession();

		Medecin medecina = (Medecin) session.getAttribute(ATT_SESSION_MEDECIN);

		try {

			traiterChoixPatient(identifiantPatient, mmse);

			traiter_scoreOrientation(scoreo, mmse);

			traiter_scoreApprentissage(scorea, mmse);

			traiter_scoreAttentionEtCalcul(scoreaec, mmse);

			traiter_scoreRappel(scorer, mmse);

			traiter_scoreLangage(scorel, mmse);

			traiter_imageLangage_oui_non(imageLangage_oui_non, mmse);

			traiter_scorePraxiesConstructives(scorepc, mmse);

			traiter_imagePraxiesConstructives_oui_non(imagePraxiesConstructives_oui_non, mmse);

			scoretotal = scoreOrientation + scoreApprentissage + scoreAttentionEtCalcul + scoreRappel + scoreLangage
					+ scorePraxiesConstructives;

			mmse.setScoreTotalMmse(scoretotal);

			if (erreurs.isEmpty()) {

				mmse.setIdentifiant_medecin(medecina.getIdentifiant_medecin());

				mmse.setPrenoms_noms_medecin(medecina.getPrenoms_medecin() + " " + medecina.getNoms_medecin());

				mmse.setPrenoms_noms_patient(patient.getPrenoms_patient() + " " + patient.getNoms_patient());

				mmse.setId_aleatoire_mmse(Long.parseLong(champinvisible));

				mmseDao.creer(mmse);

				resultat = "Succès de l'enregistrement du résultat";

			} else {
				resultat = "Échec de l'enregistrement du résultat";

			}

		} catch (DAOException e) {
			resultat = "Échec de l'enregistrement du résultat du MMSE : une erreur imprévue est survenue,merci de réessayer dans quelques instants.";
			e.printStackTrace();
		}

		return mmse;

	}

	private void validationChoixPatient(String identifiantPatient) throws FormValidationException {

		if (identifiantPatient != null) {

			if (identifiantPatient.trim().length() != 0) {

			}
		} else {
			throw new FormValidationException("Veuillez choisir un patient ou une patiente.");
		}

	}

	private void traiterChoixPatient(String identifiantPatient, Mmse mmse) {

		try {

			validationChoixPatient(identifiantPatient);

		} catch (FormValidationException e) {

			setErreur(CHAMP_CHOIX_PATIENT, e.getMessage());

		}

		patient = patientDao.trouver(identifiantPatient);

		mmse.setIdentifiant_patient(identifiantPatient);

	}

	private void validation_scoreOrientation(String score) throws FormValidationException {

		int scorereel = Integer.parseInt(score);

		if (scorereel <= 10 && scorereel >= 0) {

			// OK

		} else {

			throw new FormValidationException("Le score est compris entre 0 et 10, merci de  saisir à nouveau.");

		}

	}

	private void traiter_scoreOrientation(String score, Mmse mmse) {

		try {
			validation_scoreOrientation(score);
		} catch (FormValidationException e) {

			setErreur(CHAMP_scoreOrientation, e.getMessage());

		}

		scoreOrientation = Integer.parseInt(score);

		mmse.setScoreOrientation(scoreOrientation);

	}

	private void validation_scoreApprentissage(String score) throws FormValidationException {

		int scorereel = Integer.parseInt(score);

		if (scorereel <= 3 && scorereel >= 0) {

			// OK

		} else {

			throw new FormValidationException("Le score est compris entre 0 et 3, merci de  saisir à nouveau.");

		}

	}

	private void traiter_scoreApprentissage(String score, Mmse mmse) {

		try {
			validation_scoreApprentissage(score);
		} catch (FormValidationException e) {

			setErreur(CHAMP_scoreApprentissage, e.getMessage());

		}

		scoreApprentissage = Integer.parseInt(score);

		mmse.setScoreApprentissage(scoreApprentissage);

	}

	private void validation_scoreAttentionEtCalcul(String score) throws FormValidationException {

		int scorereel = Integer.parseInt(score);

		if (scorereel <= 5 && scorereel >= 0) {

			// OK

		} else {

			throw new FormValidationException("Le score est compris entre 0 et 5, merci de  saisir à nouveau.");

		}

	}

	private void traiter_scoreAttentionEtCalcul(String score, Mmse mmse) {

		try {
			validation_scoreAttentionEtCalcul(score);
		} catch (FormValidationException e) {

			setErreur(CHAMP_scoreAttentionEtCalcul, e.getMessage());

		}

		scoreAttentionEtCalcul = Integer.parseInt(score);

		mmse.setScoreAttentionEtCalcul(scoreAttentionEtCalcul);

	}

	private void validation_scoreRappel(String score) throws FormValidationException {

		int scorereel = Integer.parseInt(score);

		if (scorereel <= 3 && scorereel >= 0) {

			// OK

		} else {

			throw new FormValidationException("Le score est compris entre 0 et 3, merci de  saisir à nouveau.");

		}

	}

	private void traiter_scoreRappel(String score, Mmse mmse) {

		try {
			validation_scoreRappel(score);
		} catch (FormValidationException e) {

			setErreur(CHAMP_scoreRappel, e.getMessage());

		}

		scoreRappel = Integer.parseInt(score);

		mmse.setScoreRappel(scoreRappel);

	}

	private void validation_scoreLangage(String score) throws FormValidationException {

		int scorereel = Integer.parseInt(score);

		if (scorereel <= 8 && scorereel >= 0) {

			// OK

		} else {

			throw new FormValidationException("Le score est compris entre 0 et 8, merci de  saisir à nouveau.");

		}

	}

	private void traiter_scoreLangage(String score, Mmse mmse) {

		try {
			validation_scoreLangage(score);
		} catch (FormValidationException e) {

			setErreur(CHAMP_scoreLangage, e.getMessage());

		}

		scoreLangage = Integer.parseInt(score);

		mmse.setScoreLangage(scoreLangage);

	}

	private void validation_imageLangage_oui_non(String imageLangage_oui_non) throws FormValidationException {

		if (imageLangage_oui_non != null) {

			if (imageLangage_oui_non.trim().length() != 0) {

			}
		} else {
			throw new FormValidationException("S'il vous plaît, veuillez choisir oui ou non .");
		}

	}

	private void traiter_imageLangage_oui_non(String imageLangage_oui_non, Mmse mmse) {

		try {

			validation_imageLangage_oui_non(imageLangage_oui_non);

		} catch (FormValidationException e) {

			setErreur(CHAMP_imageLangage_oui_non, e.getMessage());

		}

		mmse.setImageLangage_oui_non(imageLangage_oui_non);

	}

	private void validation_scorePraxiesConstructives(String score) throws FormValidationException {

		int scorereel = Integer.parseInt(score);

		if (scorereel <= 1 && scorereel >= 0) {

			// OK

		} else {

			throw new FormValidationException("Le score est compris entre 0 et 1, merci de  saisir à nouveau.");

		}

	}

	private void traiter_scorePraxiesConstructives(String score, Mmse mmse) {

		try {
			validation_scorePraxiesConstructives(score);
		} catch (FormValidationException e) {

			setErreur(CHAMP_scorePraxiesConstructives, e.getMessage());

		}

		scorePraxiesConstructives = Integer.parseInt(score);

		mmse.setScorePraxiesConstructives(scorePraxiesConstructives);

	}

	private void validation_imagePraxiesConstructives_oui_non(String imagePraxiesConstructives_oui_non)
			throws FormValidationException {

		if (imagePraxiesConstructives_oui_non != null) {

			if (imagePraxiesConstructives_oui_non.trim().length() != 0) {

			}
		} else {
			throw new FormValidationException("S'il vous plaît, veuillez choisir oui ou non .");
		}

	}

	private void traiter_imagePraxiesConstructives_oui_non(String imagePraxiesConstructives_oui_non, Mmse mmse) {

		try {

			validation_imagePraxiesConstructives_oui_non(imagePraxiesConstructives_oui_non);

		} catch (FormValidationException e) {

			setErreur(CHAMP_imagePraxiesConstructives_oui_non, e.getMessage());

		}

		mmse.setImagePraxiesConstructives_oui_non(imagePraxiesConstructives_oui_non);

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
