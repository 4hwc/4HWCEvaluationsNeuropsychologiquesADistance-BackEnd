package enad.forms;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import enad.beans.Patient;
import enad.beans.Seance;
import enad.dao.PatientDao;
import enad.dao.PropositionSeanceDao;
import enad.dao.SeanceDao;

public final class ListeSeancesValidationPatientForm {

	private SeanceDao seanceDao;

	private PatientDao patientDao;

	private PropositionSeanceDao propositionseanceDao;

	public static final String ATT_SESSION_PATIENT = "sessionPatient";

	// public String presenceprop;

	public ArrayList<Seance> Seances = new ArrayList<Seance>();

	public ArrayList<String> PresenceProp = new ArrayList<String>();

	public ListeSeancesValidationPatientForm(SeanceDao seanceDao, PatientDao patientDao,
			PropositionSeanceDao propositionseanceDao) {

		this.seanceDao = seanceDao;

		this.patientDao = patientDao;

		this.propositionseanceDao = propositionseanceDao;

	}

	public void listeSeancesValidation(HttpServletRequest request) {

		/* Récupération de la session depuis la requête */

		HttpSession session = request.getSession();

		Patient patient = (Patient) session.getAttribute(ATT_SESSION_PATIENT);

		String identifiantPatient = patient.getIdentifiant_patient();

		Seances = seanceDao.trouver_patient_validation(identifiantPatient);

	}

}
