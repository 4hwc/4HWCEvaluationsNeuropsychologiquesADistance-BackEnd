package enad.forms;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import enad.beans.Medecin;
import enad.beans.Patient;
import enad.dao.MedecinDao;
import enad.dao.PatientDao;

public final class EnChargeMedecinForm {

	private MedecinDao medecinDao;

	private PatientDao patientDao;

	ArrayList<String> identifiants = new ArrayList<String>();

	ArrayList<Patient> pats = new ArrayList<Patient>();

	public static final String ATT_SESSION_MEDECIN = "sessionMedecin";

	public EnChargeMedecinForm(MedecinDao medecinDao, PatientDao patientDao) {

		this.medecinDao = medecinDao;

		this.patientDao = patientDao;
	}

	public ArrayList<Patient> EnCharge(HttpServletRequest request) {

		HttpSession session = request.getSession();

		Medecin medecin = (Medecin) (session.getAttribute(ATT_SESSION_MEDECIN));

		String identifiant = medecin.getIdentifiant_medecin();

		if (medecinDao.trouver_identifiantspat_relmedpat(identifiant).isEmpty()) {

		} else {

			for (int i = 0; i < medecinDao.trouver_identifiantspat_relmedpat(identifiant).size(); i++) {

				identifiants.add(medecinDao.trouver_identifiantspat_relmedpat(identifiant).get(i));

			}

		}

		if (identifiants.isEmpty()) {

		} else {

			for (int k = 0; k < identifiants.size(); k++) {

				pats.add(patientDao.trouver(identifiants.get(k)));
			}

		}

		return pats;

	}

}
