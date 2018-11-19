package enad.forms;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import enad.beans.ImageTestFcroBean;
import enad.beans.Seance;
import enad.dao.ImageTestFcroBeanDao;
import enad.dao.MedecinDao;
import enad.dao.PatientDao;
import enad.dao.SeanceDao;

public final class DiaporamaFCROForm {

	private SeanceDao seanceDao;

	private PatientDao patientDao;

	private MedecinDao medecinDao;

	private ImageTestFcroBeanDao imagetestfcrobeanDao;

	public Seance seance = new Seance();

	public ArrayList<ImageTestFcroBean> liste = new ArrayList<ImageTestFcroBean>();

	public static final String ATT_SESSION_MEDECIN = "sessionMedecin";

	public DiaporamaFCROForm(PatientDao patientDao, SeanceDao seanceDao, MedecinDao medecinDao,
			ImageTestFcroBeanDao imagetestfcrobeanDao) {

		this.imagetestfcrobeanDao = imagetestfcrobeanDao;

		this.seanceDao = seanceDao;

		this.patientDao = patientDao;

		this.medecinDao = medecinDao;

	}

	public void ListeDesImagesFcro(HttpServletRequest request) {

		String id_seance = request.getParameter("idseance");

		Long id = Long.parseLong(id_seance);

		seance = seanceDao.trouver_validees(id);

		liste = imagetestfcrobeanDao.ImageTestFcroBean_seance(id);

	}

}
