package enad.forms;

import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import enad.beans.Medecin;
import enad.beans.Seance;
import enad.dao.MedecinDao;
import enad.dao.SeanceDao;

public final class ListeSeancesValideesPrecedentesMedecinForm {

	private SeanceDao seanceDao;

	private MedecinDao medecinDao;

	private Calendar cal;

	public static final String ATT_SESSION_MEDECIN = "sessionMedecin";

	public ListeSeancesValideesPrecedentesMedecinForm(SeanceDao seanceDao, MedecinDao medecinDao) {

		this.seanceDao = seanceDao;

		this.medecinDao = medecinDao;

	}

	public ArrayList<Seance> listeSeancesValideesPrec(HttpServletRequest request) {

		ArrayList<Seance> Seances = new ArrayList<Seance>();

		ArrayList<Seance> SeancesPrec = new ArrayList<Seance>();

		/* Récupération de la session depuis la requête */

		HttpSession session = request.getSession();

		Medecin medecin = (Medecin) session.getAttribute(ATT_SESSION_MEDECIN);

		String identifiantMedecin = medecin.getIdentifiant_medecin();

		Seances = seanceDao.trouver_medecin_validees(identifiantMedecin);

		cal = Calendar.getInstance();

		for (int i = 0; i < Seances.size(); i++) {

			int d = Seances.get(i).getDate_realisation_seance().getDate();

			int month = Seances.get(i).getDate_realisation_seance().getMonth();

			int year = Seances.get(i).getDate_realisation_seance().getYear();

			int m = month + 1;

			int y = year + 1900;

			int moisactuel = cal.get(Calendar.MONTH) + 1;

			if ((d == cal.get(Calendar.DAY_OF_MONTH) && m == moisactuel && y == cal.get(Calendar.YEAR))
					|| (d == cal.get(Calendar.DAY_OF_MONTH) && m == moisactuel && y > cal.get(Calendar.YEAR))
					|| (d == cal.get(Calendar.DAY_OF_MONTH) && m < moisactuel && y > cal.get(Calendar.YEAR))
					|| (d == cal.get(Calendar.DAY_OF_MONTH) && m > moisactuel && y == cal.get(Calendar.YEAR))
					|| (d == cal.get(Calendar.DAY_OF_MONTH) && m > moisactuel && y > cal.get(Calendar.YEAR))
					|| (d < cal.get(Calendar.DAY_OF_MONTH) && m == moisactuel && y > cal.get(Calendar.YEAR))
					|| (d < cal.get(Calendar.DAY_OF_MONTH) && m < moisactuel && y > cal.get(Calendar.YEAR))
					|| (d < cal.get(Calendar.DAY_OF_MONTH) && m > moisactuel && y == cal.get(Calendar.YEAR))
					|| (d < cal.get(Calendar.DAY_OF_MONTH) && m > moisactuel && y > cal.get(Calendar.YEAR))
					|| (d > cal.get(Calendar.DAY_OF_MONTH) && m == moisactuel && y == cal.get(Calendar.YEAR))
					|| (d > cal.get(Calendar.DAY_OF_MONTH) && m == moisactuel && y > cal.get(Calendar.YEAR))
					|| (d > cal.get(Calendar.DAY_OF_MONTH) && m < moisactuel && y > cal.get(Calendar.YEAR))
					|| (d > cal.get(Calendar.DAY_OF_MONTH) && m > moisactuel && y == cal.get(Calendar.YEAR))
					|| (d > cal.get(Calendar.DAY_OF_MONTH) && m > moisactuel && y > cal.get(Calendar.YEAR))) {

			} else {

				SeancesPrec.add(Seances.get(i));

			}

		}

		return SeancesPrec;

	}

}
