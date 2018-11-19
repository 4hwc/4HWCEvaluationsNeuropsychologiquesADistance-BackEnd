package enad.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import enad.dao.DAOFactory;
import enad.dao.ImageMmsePraxiesConstructivesBeanDao;
import enad.dao.MedecinDao;
import enad.dao.MmseDao;
import enad.dao.PatientDao;
import enad.forms.CaptureImageMmsePraxiesConstructivesForm;

public class CaptureImageMmsePraxiesConstructives extends HttpServlet {

	private MmseDao mmseDao;

	private PatientDao patientDao;

	private MedecinDao medecinDao;

	private ImageMmsePraxiesConstructivesBeanDao imagemmsepraxiesconstructivesbeanDao;

	public static final String CONF_DAO_FACTORY = "daofactory";

	public static final String CHEMINPRAXIESCONSTRUCTIVES = "cheminmmsepraxiesconstructives";

	public void init() throws ServletException {

		this.mmseDao = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY)).getMmseDao();

		this.patientDao = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY)).getPatientDao();

		this.medecinDao = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY)).getMedecinDao();

		this.imagemmsepraxiesconstructivesbeanDao = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY))
				.getImageMmsePraxiesConstructivesBeanDao();

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String chemin = this.getServletConfig().getInitParameter(CHEMINPRAXIESCONSTRUCTIVES);

		CaptureImageMmsePraxiesConstructivesForm form = new CaptureImageMmsePraxiesConstructivesForm(patientDao,
				mmseDao, medecinDao, imagemmsepraxiesconstructivesbeanDao);

		form.creerImageMmsePraxiesConstructives(request, chemin);

		/* Si aucune erreur */

		if (form.getErreurs().isEmpty()) {

			System.out.println("azersssdd");

		} else {

			System.out.println("Erreur au niveau de la servlet CaptureImageMmsePraxiesConstructives.java");

		}
	}

}
