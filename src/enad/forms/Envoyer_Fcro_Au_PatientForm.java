package enad.forms;

import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import enad.beans.Medecin;
import enad.beans.Patient;
import enad.beans.Seance;
import enad.dao.PatientDao;
import enad.dao.SeanceDao;

public final class Envoyer_Fcro_Au_PatientForm {

	private PatientDao patientDao;

	private SeanceDao seanceDao;

	private Calendar cal;

	public static final String ATT_SESSION_MEDECIN = "sessionMedecin";

	public Envoyer_Fcro_Au_PatientForm(SeanceDao seanceDao, PatientDao patientDao) {

		this.seanceDao = seanceDao;

		this.patientDao = patientDao;

	}

	public ArrayList<Patient> listePatientsJour(HttpServletRequest request) {

		int occurences_resultats_patients;

		ArrayList<Seance> Seances = new ArrayList<Seance>();

		ArrayList<Seance> SeancesJour = new ArrayList<Seance>();

		ArrayList<Patient> PatientsJour = new ArrayList<Patient>();

		/* Récupération de la session depuis la requête */

		HttpSession session = request.getSession();

		Medecin medecin = (Medecin) session.getAttribute(ATT_SESSION_MEDECIN);

		String identifiantMedecin = medecin.getIdentifiant_medecin();

		Seances = seanceDao.trouver_medecin_validees(identifiantMedecin);

		cal = Calendar.getInstance();

		if (Seances.isEmpty()) {

			return PatientsJour;

		} else {

			for (int i = 0; i < Seances.size(); i++) {

				int d = Seances.get(i).getDate_realisation_seance().getDate();

				int month = Seances.get(i).getDate_realisation_seance().getMonth();

				int year = Seances.get(i).getDate_realisation_seance().getYear();

				int m = month + 1;

				int y = year + 1900;

				int moisactuel = cal.get(Calendar.MONTH) + 1;

				if ((d == cal.get(Calendar.DAY_OF_MONTH) && m == moisactuel && y == cal.get(Calendar.YEAR))

				) {

					String identifiant_patient = Seances.get(i).getIdentifiant_patient();

					Long id_patient = patientDao.trouver(identifiant_patient).getId_patient();

					if (patientDao.trouver_pat_connexion_on(id_patient) != 0) {

						// Patient(e) connecté(e)

						SeancesJour.add(Seances.get(i));

					} else {

						// Patient(e) pas connecté(e)donc rien à afficher

					}

				} else {

				}

			}

			for (int j = 0; j < SeancesJour.size(); j++) {

				PatientsJour.add(patientDao.trouver(SeancesJour.get(j).getIdentifiant_patient()));

			}

			// peut être enlever doublons car un patient peut avoir 2 séances

			// Enlever les doublons

			for (int tour1 = 0; tour1 < PatientsJour.size(); tour1++) {

				occurences_resultats_patients = 0;

				for (int tour2 = 0; tour2 < PatientsJour.size(); tour2++) {

					if (PatientsJour.get(tour1).getId_patient() == PatientsJour.get(tour2).getId_patient()) {

						occurences_resultats_patients++;

						if (occurences_resultats_patients > 1) {

							PatientsJour.remove(tour2);

						}

					}

				}
			}

			// Enlever doublons une fois de plus mesure de sécurité

			for (int tour1 = 0; tour1 < PatientsJour.size(); tour1++) {

				occurences_resultats_patients = 0;

				for (int tour2 = 0; tour2 < PatientsJour.size(); tour2++) {

					if (PatientsJour.get(tour1).getId_patient() == PatientsJour.get(tour2).getId_patient()) {

						occurences_resultats_patients++;

						if (occurences_resultats_patients > 1) {

							PatientsJour.remove(tour2);

						}

					}

				}
			}

			return PatientsJour;

		}

	}

	public ArrayList<Seance> listeSeancesJour(HttpServletRequest request) {

		int occurences_resultats_seances;

		ArrayList<Seance> SeancesJourFinal = new ArrayList<Seance>();

		ArrayList<Seance> SeancesJour = new ArrayList<Seance>();

		ArrayList<Patient> PatientsJour = listePatientsJour(request);

		HttpSession session = request.getSession();

		Medecin medecin = (Medecin) session.getAttribute(ATT_SESSION_MEDECIN);

		String identifiantMedecin = medecin.getIdentifiant_medecin();

		for (int i = 0; i < PatientsJour.size(); i++) {

			for (int j = 0; j < seanceDao
					.trouver_seances_validees(identifiantMedecin, PatientsJour.get(i).getIdentifiant_patient())
					.size(); j++) {

				SeancesJour.add(seanceDao
						.trouver_seances_validees(identifiantMedecin, PatientsJour.get(i).getIdentifiant_patient())
						.get(j));

			}

		}

		// Enlever les doublons

		for (int tour1 = 0; tour1 < SeancesJour.size(); tour1++) {

			occurences_resultats_seances = 0;

			for (int tour2 = 0; tour2 < SeancesJour.size(); tour2++) {

				if (SeancesJour.get(tour1).getId_seance() == SeancesJour.get(tour2).getId_seance()) {

					occurences_resultats_seances++;

					if (occurences_resultats_seances > 1) {

						SeancesJour.remove(tour2);

					}

				}

			}
		}

		// Enlever doublons une fois de plus mesure de sécurité

		for (int tour1 = 0; tour1 < SeancesJour.size(); tour1++) {

			occurences_resultats_seances = 0;

			for (int tour2 = 0; tour2 < SeancesJour.size(); tour2++) {

				if (SeancesJour.get(tour1).getId_seance() == SeancesJour.get(tour2).getId_seance()) {

					occurences_resultats_seances++;

					if (occurences_resultats_seances > 1) {

						SeancesJour.remove(tour2);

					}

				}

			}
		}

		cal = Calendar.getInstance();

		for (int i = 0; i < SeancesJour.size(); i++) {

			int d = SeancesJour.get(i).getDate_realisation_seance().getDate();

			int month = SeancesJour.get(i).getDate_realisation_seance().getMonth();

			int year = SeancesJour.get(i).getDate_heure_creation_seance().getYear();

			int m = month + 1;

			int y = year + 1900;

			int moisactuel = cal.get(Calendar.MONTH) + 1;

			if ((d == cal.get(Calendar.DAY_OF_MONTH) && m == moisactuel && y == cal.get(Calendar.YEAR))

			) {

				SeancesJourFinal.add(SeancesJour.get(i));

			}

		}

		return SeancesJourFinal;

	}

}
