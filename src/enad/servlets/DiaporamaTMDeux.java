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
import enad.forms.DiaporamaTMDeuxForm;

public class DiaporamaTMDeux extends HttpServlet {

	public static final String CONF_DAO_FACTORY = "daofactory";

	private SeanceDao seanceDao;

	private PatientDao patientDao;

	private MedecinDao medecinDao;

	private ImageTestTmBeanDao imagetesttmbeanDao;

	public static final String INFORMATIONS_TM = "/WEB-INF/diaporamaTMDeux.jsp";

	public void init() throws ServletException {

		this.seanceDao = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY)).getSeanceDao();

		this.patientDao = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY)).getPatientDao();

		this.medecinDao = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY)).getMedecinDao();

		this.imagetesttmbeanDao = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY))
				.getImageTestTmBeanDao();

	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		DiaporamaTMDeuxForm form = new DiaporamaTMDeuxForm(patientDao, seanceDao, medecinDao, imagetesttmbeanDao);

		form.ListeDesImagesTm(request);

		request.setAttribute("seancediaporama", form.seance);

		request.setAttribute("imagesdiaporama", form.liste);

		/*
		 * A la réception d'une requête GET, simple affichage de la page
		 */

		this.getServletContext().getRequestDispatcher(INFORMATIONS_TM).forward(request, response);
	}
}
