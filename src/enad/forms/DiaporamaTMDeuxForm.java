package enad.forms;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import enad.beans.ImageTestTmBean;
import enad.beans.Seance;
import enad.dao.ImageTestTmBeanDao;
import enad.dao.MedecinDao;
import enad.dao.PatientDao;
import enad.dao.SeanceDao;

public final class DiaporamaTMDeuxForm {

	private SeanceDao seanceDao;

	private PatientDao patientDao;

	private MedecinDao medecinDao;

	private ImageTestTmBeanDao imagetesttmbeanDao;

	public Seance seance = new Seance();

	public ArrayList<ImageTestTmBean> liste = new ArrayList<ImageTestTmBean>();

	public static final String ATT_SESSION_MEDECIN = "sessionMedecin";

	public DiaporamaTMDeuxForm(PatientDao patientDao, SeanceDao seanceDao, MedecinDao medecinDao,
			ImageTestTmBeanDao imagetesttmbeanDao) {

		this.imagetesttmbeanDao = imagetesttmbeanDao;

		this.seanceDao = seanceDao;

		this.patientDao = patientDao;

		this.medecinDao = medecinDao;

	}

	public void ListeDesImagesTm(HttpServletRequest request) {

		String id_seance = request.getParameter("idseance");

		Long id = Long.parseLong(id_seance);

		seance = seanceDao.trouver_validees(id);

		liste = imagetesttmbeanDao.ImageTestTmDeuxBean_seance(id);

	}

}
