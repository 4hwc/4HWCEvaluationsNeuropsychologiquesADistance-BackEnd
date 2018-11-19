package enad.forms;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;

import enad.beans.Seance;
import enad.dao.PatientDao;
import enad.dao.SeanceDao;

public final class ValidationSeancePatientForm {

	private SeanceDao seanceDao;

	private PatientDao patientDao;

	public String typeredirection;

	private Calendar cal;

	private Seance seance = new Seance();

	public ValidationSeancePatientForm(SeanceDao seanceDao, PatientDao patientDao) {

		this.seanceDao = seanceDao;

		this.patientDao = patientDao;

	}

	public void ValidationSeance(HttpServletRequest request) {

		String id_seance = request.getParameter("idSeance");

		Long id = Long.parseLong(id_seance);

		seanceDao.DeValidationAValidee(id);

		seance = seanceDao.trouverValidee(id);

		seanceDao.realisationdessinjour(seance);

		cal = Calendar.getInstance();

		int d = seance.getDate_realisation_seance().getDate();
		int month = seance.getDate_realisation_seance().getMonth();
		int year = seance.getDate_realisation_seance().getYear();

		int m = month + 1;

		int y = year + 1900;

		int moisactuel = cal.get(Calendar.MONTH) + 1;

		System.out.println("BDD");

		System.out.println("d");

		System.out.println(d);

		System.out.println("month");

		System.out.println(month);//

		System.out.println("year");

		System.out.println(year);//

		System.out.println("ACTUEL");

		System.out.println("jour");

		System.out.println(cal.get(Calendar.DAY_OF_MONTH));

		System.out.println("mois");

		System.out.println(cal.get(Calendar.MONTH));//

		System.out.println("année");

		System.out.println(cal.get(Calendar.YEAR));

		if (d == cal.get(Calendar.DAY_OF_MONTH) && m == moisactuel && y == cal.get(Calendar.YEAR)) {

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
