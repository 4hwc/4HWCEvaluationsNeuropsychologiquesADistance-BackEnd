package enad.forms;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;

import enad.beans.PropositionSeance;
import enad.beans.Seance;
import enad.dao.PatientDao;
import enad.dao.PropositionSeanceDao;
import enad.dao.SeanceDao;

public final class ValidationPropositionSeancePatientForm {

	private PropositionSeanceDao propositionseanceDao;

	private PatientDao patientDao;

	private SeanceDao seanceDao;

	private Calendar cal;

	public Seance seance = new Seance();

	public String typeredirection;

	public ValidationPropositionSeancePatientForm(PatientDao patientDao, PropositionSeanceDao propositionseanceDao,
			SeanceDao seanceDao) {

		this.patientDao = patientDao;

		this.propositionseanceDao = propositionseanceDao;

		this.seanceDao = seanceDao;

	}

	public void ValidationSeance(HttpServletRequest request) {

		PropositionSeance propseance = new PropositionSeance();

		String id_seance = request.getParameter("idseance");

		Long id = Long.parseLong(id_seance);

		propseance = propositionseanceDao.trouver_derniere_prop(id);

		seanceDao.DeValidationAValidee(propseance, id);

		propositionseanceDao.supprimer_propseance(id);

		seance = seanceDao.trouverValidee(id);

		seanceDao.realisationdessinjour(seance);

		cal = Calendar.getInstance();

		int d = seance.getDate_realisation_seance().getDate();
		int month = seance.getDate_realisation_seance().getMonth();
		int year = seance.getDate_heure_creation_seance().getYear();

		int m = month + 1;

		int y = year + 1900;

		int moisactuel = cal.get(Calendar.MONTH) + 1;

		if (d == cal.get(Calendar.DAY_OF_MONTH) && m == cal.get(Calendar.MONTH) && y == cal.get(Calendar.YEAR)) {

			typeredirection = "jour";

		} else {

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

				typeredirection = "suivantes";

			} else {

				typeredirection = "precedentes";

			}
		}

	}

}
