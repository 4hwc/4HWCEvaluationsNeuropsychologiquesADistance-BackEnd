package enad.forms;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import enad.beans.Medecin;
import enad.beans.Patient;
import enad.dao.MedecinDao;
import enad.dao.PatientDao;

public final class MedecinsDuPatientForm {

	private MedecinDao medecinDao;

	private PatientDao patientDao;

	ArrayList<String> identifiants = new ArrayList<String>();

	ArrayList<Medecin> meds = new ArrayList<Medecin>();

	public static final String ATT_SESSION_PATIENT = "sessionPatient";

	public MedecinsDuPatientForm(MedecinDao medecinDao, PatientDao patientDao) {

		this.medecinDao = medecinDao;

		this.patientDao = patientDao;
	}

	public ArrayList<Medecin> Medecins(HttpServletRequest request) {

		HttpSession session = request.getSession();

		Patient patient = (Patient) (session.getAttribute(ATT_SESSION_PATIENT));

		String identifiant = patient.getIdentifiant_patient();

		if (patientDao.trouver_identifiantsmed_relmedpat(identifiant).isEmpty()) {

		} else {

			for (int i = 0; i < patientDao.trouver_identifiantsmed_relmedpat(identifiant).size(); i++) {

				identifiants.add(patientDao.trouver_identifiantsmed_relmedpat(identifiant).get(i));

			}

		}

		if (identifiants.isEmpty()) {

		} else {

			for (int k = 0; k < identifiants.size(); k++) {

				meds.add(medecinDao.trouver(identifiants.get(k)));
			}

		}

		return meds;

	}

}
