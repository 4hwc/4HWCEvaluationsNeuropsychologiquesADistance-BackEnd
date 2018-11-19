package enad.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import enad.dao.DAOFactory;
import enad.dao.ImageTestTmBeanDao;
import enad.dao.MedecinDao;
import enad.dao.PatientDao;
import enad.dao.SeanceDao;
import enad.forms.CaptureImageTmForm;

public class CaptureImageTm extends HttpServlet {

	public static final String CONF_DAO_FACTORY = "daofactory";

	public static final String CHEMINTM = "chemintm";

	private SeanceDao seanceDao;

	private PatientDao patientDao;

	private MedecinDao medecinDao;

	private ImageTestTmBeanDao imagetesttmbeanDao;

	public void init() throws ServletException {

		this.seanceDao = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY)).getSeanceDao();

		this.patientDao = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY)).getPatientDao();

		this.medecinDao = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY)).getMedecinDao();

		this.imagetesttmbeanDao = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY))
				.getImageTestTmBeanDao();

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/*
		 * Lecture du paramètre 'chemin' passé à la servlet via la déclaration
		 * dans le web.xml
		 */

		String chemin = this.getServletConfig().getInitParameter(CHEMINTM);

		/* Préparation de l'objet formulaire */
		CaptureImageTmForm form = new CaptureImageTmForm(patientDao, seanceDao, medecinDao, imagetesttmbeanDao);

		form.creerImageTm(request, chemin);

		/* Si aucune erreur */

		if (form.getErreurs().isEmpty()) {

		} else {

			System.out.println("Erreur au niveau de la servlet CaptureImageTm.java");

		}

	}

}
