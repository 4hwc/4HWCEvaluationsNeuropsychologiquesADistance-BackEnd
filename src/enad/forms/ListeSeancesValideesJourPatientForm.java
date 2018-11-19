package enad.forms;

import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import enad.beans.Patient;
import enad.beans.Seance;
import enad.dao.PatientDao;
import enad.dao.SeanceDao;

public final class ListeSeancesValideesJourPatientForm {

	private SeanceDao seanceDao;

	private PatientDao patientDao;

	private Calendar cal;

	public static final String ATT_SESSION_PATIENT = "sessionPatient";

	public ListeSeancesValideesJourPatientForm(SeanceDao seanceDao, PatientDao patientDao) {

		this.seanceDao = seanceDao;

		this.patientDao = patientDao;

	}

	public ArrayList<Seance> listeSeancesValideesJour(HttpServletRequest request) {

		ArrayList<Seance> Seances = new ArrayList<Seance>();

		ArrayList<Seance> SeancesJour = new ArrayList<Seance>();

		/* Récupération de la session depuis la requête */

		HttpSession session = request.getSession();

		Patient patient = (Patient) session.getAttribute(ATT_SESSION_PATIENT);

		String identifiantPatient = patient.getIdentifiant_patient();

		Seances = seanceDao.trouver_patient_validees(identifiantPatient);

		cal = Calendar.getInstance();

		for (int i = 0; i < Seances.size(); i++) {

			int d = Seances.get(i).getDate_realisation_seance().getDate();

			int month = Seances.get(i).getDate_realisation_seance().getMonth();

			int year = Seances.get(i).getDate_realisation_seance().getYear();

			int m = month + 1;

			int y = year + 1900;

			int moisactuel = cal.get(Calendar.MONTH) + 1;

			if ((d == cal.get(Calendar.DAY_OF_MONTH) && m == moisactuel && y == cal.get(Calendar.YEAR))

			) {

				SeancesJour.add(Seances.get(i));

			}

		}

		return SeancesJour;

	}

}
