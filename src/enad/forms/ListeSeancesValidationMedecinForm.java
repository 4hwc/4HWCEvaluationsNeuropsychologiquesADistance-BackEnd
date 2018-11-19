package enad.forms;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import enad.beans.Medecin;
import enad.beans.Seance;
import enad.dao.MedecinDao;
import enad.dao.SeanceDao;

public final class ListeSeancesValidationMedecinForm {

	private SeanceDao seanceDao;

	private MedecinDao medecinDao;

	public static final String ATT_SESSION_MEDECIN = "sessionMedecin";

	public ListeSeancesValidationMedecinForm(SeanceDao seanceDao, MedecinDao medecinDao) {

		this.seanceDao = seanceDao;

		this.medecinDao = medecinDao;

	}

	public ArrayList<Seance> listeSeancesValidation(HttpServletRequest request) {

		ArrayList<Seance> Seances = new ArrayList<Seance>();

		/* Récupération de la session depuis la requête */

		HttpSession session = request.getSession();

		Medecin medecin = (Medecin) session.getAttribute(ATT_SESSION_MEDECIN);

		String identifiantMedecin = medecin.getIdentifiant_medecin();

		Seances = seanceDao.trouver_medecin_validation(identifiantMedecin);

		return Seances;

	}

}
