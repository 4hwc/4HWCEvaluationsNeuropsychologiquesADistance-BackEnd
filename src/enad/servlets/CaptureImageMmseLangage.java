package enad.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import enad.dao.DAOFactory;
import enad.dao.ImageMmseLangageBeanDao;
import enad.dao.MedecinDao;
import enad.dao.MmseDao;
import enad.dao.PatientDao;
import enad.forms.CaptureImageMmseLangageForm;

public class CaptureImageMmseLangage extends HttpServlet {

	private MmseDao mmseDao;

	private PatientDao patientDao;

	private MedecinDao medecinDao;

	private ImageMmseLangageBeanDao imagemmselangagebeanDao;

	public static final String CONF_DAO_FACTORY = "daofactory";

	public static final String CHEMINLANGAGE = "cheminmmselangage";

	public void init() throws ServletException {

		this.mmseDao = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY)).getMmseDao();

		this.patientDao = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY)).getPatientDao();

		this.medecinDao = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY)).getMedecinDao();

		this.imagemmselangagebeanDao = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY))
				.getImageMmseLangageBeanDao();

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String chemin = this.getServletConfig().getInitParameter(CHEMINLANGAGE);

		CaptureImageMmseLangageForm form = new CaptureImageMmseLangageForm(patientDao, mmseDao, medecinDao,
				imagemmselangagebeanDao);

		form.creerImageMmseLangage(request, chemin);

		/* Si aucune erreur */

		if (form.getErreurs().isEmpty()) {

		} else {

			System.out.println("Erreur au niveau de la servlet CaptureImageMmseLangage.java");

		}
	}

}
