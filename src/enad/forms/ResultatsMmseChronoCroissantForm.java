package enad.forms;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import enad.beans.Medecin;
import enad.beans.Mmse;
import enad.dao.MmseDao;

public final class ResultatsMmseChronoCroissantForm {

	private MmseDao mmseDao;

	public ArrayList<Mmse> liste = new ArrayList<Mmse>();

	public static final String ATT_SESSION_MEDECIN = "sessionMedecin";

	public ResultatsMmseChronoCroissantForm(MmseDao mmseDao) {

		this.mmseDao = mmseDao;
	}

	public void ListeDesResMmse(HttpServletRequest request) {

		HttpSession session = request.getSession();

		Medecin medecin = (Medecin) session.getAttribute(ATT_SESSION_MEDECIN);

		String identimed = medecin.getIdentifiant_medecin();

		liste = mmseDao.trouver_mmse_chrono_croissant(identimed);

	}

}
