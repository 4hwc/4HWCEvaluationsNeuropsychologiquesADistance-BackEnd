package enad.forms;

import javax.servlet.http.HttpServletRequest;

import enad.dao.PropositionSeanceDao;
import enad.dao.SeanceDao;

public final class SuppressionSeanceForm {

	private SeanceDao seanceDao;

	private PropositionSeanceDao propositionseanceDao;

	public String destinationapressuppression = new String();

	public SuppressionSeanceForm(SeanceDao seanceDao, PropositionSeanceDao propositionseanceDao) {

		this.seanceDao = seanceDao;

		this.propositionseanceDao = propositionseanceDao;
	}

	public void suppressionSeances(HttpServletRequest request) {

		destinationapressuppression = request.getParameter("page");

		String id_seance = request.getParameter("idSeance");

		Long id = Long.parseLong(id_seance);

		if (seanceDao.validee_ou_pas(id) != 0) {

			// supression seance validée table testdessinsseancesvalideesjour

			seanceDao.supprimer_dessin(id);
		}

		// supression seance validée ou pas table testdessinsseancesvalideesjour

		seanceDao.supprimer(id);

		int nbre = propositionseanceDao.nombre_prop_seance(id);

		System.out.println(nbre);

		if (nbre == 0) {

		} else {

			propositionseanceDao.supprimer_propseance(id);

		}

	}
}
