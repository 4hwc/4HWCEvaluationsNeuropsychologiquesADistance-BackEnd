package enad.forms;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import enad.beans.Bref;
import enad.beans.Medecin;
import enad.dao.BrefDao;

public final class ResultatsBrefCroissantUniqueForm {

	private BrefDao brefDao;

	public ArrayList<Bref> liste = new ArrayList<Bref>();

	public static final String ATT_SESSION_MEDECIN = "sessionMedecin";

	public ResultatsBrefCroissantUniqueForm(BrefDao brefDao) {

		this.brefDao = brefDao;
	}

	public void ListeDesResBrefUnique(HttpServletRequest request) {

		HttpSession session = request.getSession();

		Medecin medecin = (Medecin) session.getAttribute(ATT_SESSION_MEDECIN);

		String identimed = medecin.getIdentifiant_medecin();

		String identipat = request.getParameter("identifiant");

		liste = brefDao.trouver_bref_croissant_unique(identimed, identipat);

	}

}
