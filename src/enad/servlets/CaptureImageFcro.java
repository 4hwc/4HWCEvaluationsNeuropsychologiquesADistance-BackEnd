package enad.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import enad.dao.DAOFactory;
import enad.dao.ImageTestFcroBeanDao;
import enad.dao.MedecinDao;
import enad.dao.PatientDao;
import enad.dao.SeanceDao;
import enad.forms.CaptureImageFcroForm;

public class CaptureImageFcro extends HttpServlet {

	public static final String CONF_DAO_FACTORY = "daofactory";

	public static final String CHEMINFCRO = "cheminfcro";

	private SeanceDao seanceDao;

	private PatientDao patientDao;

	private MedecinDao medecinDao;

	private ImageTestFcroBeanDao imagetestfcrobeanDao;

	public void init() throws ServletException {

		this.seanceDao = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY)).getSeanceDao();

		this.patientDao = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY)).getPatientDao();

		this.medecinDao = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY)).getMedecinDao();

		this.imagetestfcrobeanDao = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY))
				.getImageTestFcroBeanDao();

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/*
		 * Lecture du paramètre 'chemin' passé à la servlet via la déclaration
		 * dans le web.xml
		 */

		String chemin = this.getServletConfig().getInitParameter(CHEMINFCRO);

		/* Préparation de l'objet formulaire */
		CaptureImageFcroForm form = new CaptureImageFcroForm(patientDao, seanceDao, medecinDao, imagetestfcrobeanDao);

		form.creerImageFcro(request, chemin);

		/* Si aucune erreur */

		if (form.getErreurs().isEmpty()) {

		} else {

			System.out.println("Erreur au niveau de la servlet CaptureImageFcro.java");

		}

	}

}
