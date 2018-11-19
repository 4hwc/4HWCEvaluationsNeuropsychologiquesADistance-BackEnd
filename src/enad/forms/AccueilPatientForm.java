package enad.forms;

import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import enad.beans.Patient;
import enad.beans.Seance;
import enad.dao.MmseDao;
import enad.dao.PatientDao;
import enad.dao.SeanceDao;

public final class AccueilPatientForm {

	private SeanceDao seanceDao;

	private PatientDao patientDao;

	private MmseDao mmseDao;

	private Calendar cal;

	public String clic_med_fcro;

	public String clic_med_tm_un;

	public String clic_med_tm_deux;

	public String clic_med_phrase_ecrire;

	public String clic_med_dessin_recopier;

	public String identifiantmed_phrase_ecrire;

	public String identifiantmed_dessin_recopier;

	public Long idaleatoire_phrase_ecrire;

	public Long idaleatoire_dessin_recopier;

	public Seance seance;

	public Seance seance_tm_un;

	public Seance seance_tm_deux;

	public static final String ATT_SESSION_PATIENT = "sessionPatient";

	public AccueilPatientForm(SeanceDao seanceDao, PatientDao patientDao, MmseDao mmseDao) {

		this.seanceDao = seanceDao;

		this.patientDao = patientDao;

		this.mmseDao = mmseDao;

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

	public void RubriqueMmseDessinRecopier(HttpServletRequest request) {

		HttpSession session = request.getSession();

		Patient patient = (Patient) session.getAttribute(ATT_SESSION_PATIENT);

		if (patientDao.trouver_pat_connexion_on(patient.getId_patient()) != 0) {

			// Patient(e) connecté(e)

			// id aleatoire le plus récent pour ce patient ou patiente

			idaleatoire_dessin_recopier = mmseDao
					.id_aleatoire_recent_patient_dessin_recopier(patient.getIdentifiant_patient());

			// identifiant du med correspondant

			identifiantmed_dessin_recopier = mmseDao.identifiant_med_dessin_recopier(idaleatoire_dessin_recopier);

			if (mmseDao.clic_medecin_ou_pas_dessin_recopier(idaleatoire_dessin_recopier) != 0) {

				// Il faut que le patient n'est pas encore cliqué

				if (mmseDao.clic_patient_ou_pas_dessin_recopier(idaleatoire_dessin_recopier,
						identifiantmed_dessin_recopier) == 0) {

					clic_med_dessin_recopier = "oui";

				}

			}

		}

	}

	public void RubriqueMmsePhraseEcrire(HttpServletRequest request) {

		HttpSession session = request.getSession();

		Patient patient = (Patient) session.getAttribute(ATT_SESSION_PATIENT);

		if (patientDao.trouver_pat_connexion_on(patient.getId_patient()) != 0) {

			// Patient(e) connecté(e)

			// id aleatoire le plus récent pour ce patient ou patiente

			idaleatoire_phrase_ecrire = mmseDao
					.id_aleatoire_recent_patient_phrase_ecrire(patient.getIdentifiant_patient());

			// identifiant du med correspondant

			identifiantmed_phrase_ecrire = mmseDao.identifiant_med_phrase_ecrire(idaleatoire_phrase_ecrire);

			if (mmseDao.clic_medecin_ou_pas_phrase_ecrire(idaleatoire_phrase_ecrire) != 0) {

				// Il faut que le patient n'est pas encore cliqué

				if (mmseDao.clic_patient_ou_pas_phrase_ecrire(idaleatoire_phrase_ecrire,
						identifiantmed_phrase_ecrire) == 0) {

					clic_med_phrase_ecrire = "oui";

				}

			}

		}

	}

	public void RubriqueFcro(HttpServletRequest request) {

		ArrayList<Seance> SeancesJour = listeSeancesValideesJour(request);

		HttpSession session = request.getSession();

		Patient patient = (Patient) session.getAttribute(ATT_SESSION_PATIENT);

		for (int i = 0; i < SeancesJour.size(); i++) {

			if (patientDao.trouver_pat_connexion_on(patient.getId_patient()) != 0) {

				// Patient(e) connecté(e)

				if (seanceDao.clic_med_fcro_ou_pas(SeancesJour.get(i).getId_seance()) != 0) {

					clic_med_fcro = "oui";

					seance = SeancesJour.get(i);

				} else {

				}

			} else {

			}

		}

	}

	public void RubriqueTmUn(HttpServletRequest request) {

		ArrayList<Seance> SeancesJour = listeSeancesValideesJour(request);

		HttpSession session = request.getSession();

		Patient patient = (Patient) session.getAttribute(ATT_SESSION_PATIENT);

		for (int i = 0; i < SeancesJour.size(); i++) {

			if (patientDao.trouver_pat_connexion_on(patient.getId_patient()) != 0) {

				// Patient(e) connecté(e)

				if (seanceDao.clic_med_tm_un_ou_pas(SeancesJour.get(i).getId_seance()) != 0) {

					clic_med_tm_un = "oui";

					seance_tm_un = SeancesJour.get(i);

				} else {

				}

			} else {

			}

		}

	}

	public void RubriqueTmDeux(HttpServletRequest request) {

		ArrayList<Seance> SeancesJour = listeSeancesValideesJour(request);

		HttpSession session = request.getSession();

		Patient patient = (Patient) session.getAttribute(ATT_SESSION_PATIENT);

		for (int i = 0; i < SeancesJour.size(); i++) {

			if (patientDao.trouver_pat_connexion_on(patient.getId_patient()) != 0) {

				// Patient(e) connecté(e)

				if (seanceDao.clic_med_tm_deux_ou_pas(SeancesJour.get(i).getId_seance()) != 0) {

					clic_med_tm_deux = "oui";

					seance_tm_deux = SeancesJour.get(i);

				} else {

				}

			} else {

			}

		}

	}

}
