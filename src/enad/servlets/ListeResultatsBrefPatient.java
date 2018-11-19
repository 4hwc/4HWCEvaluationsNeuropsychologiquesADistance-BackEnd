package enad.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import enad.dao.DAOFactory;
import enad.dao.MedecinDao;
import enad.dao.PatientDao;
import enad.forms.EnChargeMedecinForm;

public class ListeResultatsBrefPatient extends HttpServlet {

	public static final String RESULTATS_BREF = "/WEB-INF/listeResultatsBrefPatient.jsp";

	public static final String CONF_DAO_FACTORY = "daofactory";

	private MedecinDao medecinDao;

	private PatientDao patientDao;

	public void init() throws ServletException {

		this.medecinDao = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY)).getMedecinDao();

		this.patientDao = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY)).getPatientDao();

	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		EnChargeMedecinForm form = new EnChargeMedecinForm(medecinDao, patientDao);

		request.setAttribute("patients", form.EnCharge(request));

		/*
		 * A la réception d'une requête GET, simple affichage de la page
		 */

		this.getServletContext().getRequestDispatcher(RESULTATS_BREF).forward(request, response);
	}

}
