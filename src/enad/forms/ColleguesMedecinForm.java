package enad.forms;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import enad.beans.Medecin;
import enad.dao.MedecinDao;

public final class ColleguesMedecinForm {

	private MedecinDao medecinDao;

	ArrayList<String> identifiants = new ArrayList<String>();

	ArrayList<Medecin> meds = new ArrayList<Medecin>();

	public static final String ATT_SESSION_MEDECIN = "sessionMedecin";

	public ColleguesMedecinForm(MedecinDao medecinDao) {

		this.medecinDao = medecinDao;
	}

	public ArrayList<Medecin> Collegues(HttpServletRequest request) {

		HttpSession session = request.getSession();

		Medecin medecin = (Medecin) (session.getAttribute(ATT_SESSION_MEDECIN));

		String identifiant = medecin.getIdentifiant_medecin();

		if (medecinDao.trouver_identifiantmeddeux(identifiant).isEmpty()) {

		} else {

			for (int i = 0; i < medecinDao.trouver_identifiantmeddeux(identifiant).size(); i++) {

				identifiants.add(medecinDao.trouver_identifiantmeddeux(identifiant).get(i));

			}

		}

		if (medecinDao.trouver_identifiantmedun(identifiant).isEmpty()) {

		} else {

			for (int j = 0; j < medecinDao.trouver_identifiantmedun(identifiant).size(); j++) {

				identifiants.add(medecinDao.trouver_identifiantmedun(identifiant).get(j));

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
