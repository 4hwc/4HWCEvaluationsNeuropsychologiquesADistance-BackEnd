package enad.forms;

import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import enad.beans.Medecin;
import enad.beans.PropositionSeance;
import enad.dao.MedecinDao;
import enad.dao.PropositionSeanceDao;

public final class ListePropositionSeancesMedecinForm {

	private PropositionSeanceDao propositionseanceDao;

	private MedecinDao medecinDao;

	private Calendar cal;

	public Long idseance;

	public String validation;

	public String identifiantemission;

	public String egal;

	public static final String ATT_SESSION_MEDECIN = "sessionMedecin";

	public ListePropositionSeancesMedecinForm(MedecinDao medecinDao, PropositionSeanceDao propositionseanceDao) {

		this.propositionseanceDao = propositionseanceDao;

		this.medecinDao = medecinDao;

	}

	public ArrayList<PropositionSeance> listeSeancesProposition(HttpServletRequest request) {

		ArrayList<PropositionSeance> propSeances = new ArrayList<PropositionSeance>();

		String id_seance = request.getParameter("idSeance");

		Long id = Long.parseLong(id_seance);

		propSeances = propositionseanceDao.trouver(id);

		return propSeances;

	}

	public void identifiant_emission(HttpServletRequest request) {

		String id_seance = request.getParameter("idSeance");

		Long id = Long.parseLong(id_seance);

		idseance = id;

		System.out.println("idseance");

		System.out.println(id);

		identifiantemission = propositionseanceDao.trouver_personne_derniere_prop(id);

		System.out.println("identifiantemission");

		System.out.println(identifiantemission);

	}

	public void ValidationDerniereProp(HttpServletRequest request) {

		PropositionSeance propseance = new PropositionSeance();

		ArrayList<PropositionSeance> propSeances = new ArrayList<PropositionSeance>();

		propSeances = propositionseanceDao.trouver(idseance);

		if (propSeances.isEmpty()) {

		} else {

			propseance = propositionseanceDao.trouver_derniere_prop(idseance);

			cal = Calendar.getInstance();

			int d = propseance.getDate_realisation_seance_proposition().getDate();

			int month = propseance.getDate_realisation_seance_proposition().getMonth();

			int m = month + 1;

			int moisactuel = cal.get(Calendar.MONTH) + 1;

			int year = propseance.getDate_realisation_seance_proposition().getYear();

			int y = year + 1900;

			int hd = propseance.getHeure_realisation_seance_proposition().getHours();

			System.out.println(hd);

			int md = propseance.getHeure_realisation_seance_proposition().getMinutes();

			System.out.println(md);

			if (d == cal.get(Calendar.DAY_OF_MONTH) && m == moisactuel && y == cal.get(Calendar.YEAR)) {

				if (hd == cal.get(Calendar.HOUR_OF_DAY)) {

					if (md == cal.get(Calendar.MINUTE)) {

						// mauvais

						validation = "non";

					}

					if (md > cal.get(Calendar.MINUTE)) {

						// ok

						validation = "oui";

					}

					if (md < cal.get(Calendar.MINUTE)) {

						// mauvais

						validation = "non";

					}

				}

				if (hd > cal.get(Calendar.HOUR_OF_DAY)) {

					// ok

					validation = "oui";

				}

				if (hd < cal.get(Calendar.HOUR_OF_DAY)) {

					// mauvais

					validation = "non";

				}

			} else {

				// d bdd > d actuel

				if ((d == cal.get(Calendar.DAY_OF_MONTH) && m == moisactuel && y > cal.get(Calendar.YEAR))
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

					validation = "oui";

				} else {

					// mauvais cas

					validation = "non";

				}

			}

		}

		System.out.println("validation");

		System.out.println(validation);

	}

	public void egalidentifiant(HttpServletRequest req) {

		HttpSession session = req.getSession();

		Medecin medecinsession = (Medecin) session.getAttribute(ATT_SESSION_MEDECIN);

		if (!medecinsession.getIdentifiant_medecin().equals(identifiantemission)) {

			egal = "non";

		}

	}

}
