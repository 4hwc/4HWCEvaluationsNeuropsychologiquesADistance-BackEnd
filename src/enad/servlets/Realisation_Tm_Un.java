package enad.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import enad.dao.DAOFactory;
import enad.dao.MedecinDao;
import enad.dao.PatientDao;
import enad.dao.SeanceDao;
import enad.forms.Realisation_Tm_UnForm;

public class Realisation_Tm_Un extends HttpServlet {

	private PatientDao patientDao;

	private MedecinDao medecinDao;

	private SeanceDao seanceDao;

	public static final String CONF_DAO_FACTORY = "daofactory";

	public static final String REALISATION_FCRO = "/WEB-INF/RealisationTmUn.jsp";

	public void init() throws ServletException {

		this.seanceDao = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY)).getSeanceDao();

		this.medecinDao = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY)).getMedecinDao();

		this.patientDao = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY)).getPatientDao();

	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Realisation_Tm_UnForm form = new Realisation_Tm_UnForm(medecinDao, patientDao, seanceDao);

		form.Action(request);

		request.setAttribute("sessionuser", form.sessionuser);

		request.setAttribute("id_seance", form.ID_seance);

		request.setAttribute("noms_prenoms_medpat", form.noms_prenoms_medpat);

		request.setAttribute("idmed", form.idmed);

		request.setAttribute("idpat", form.idpat);

		request.setAttribute("type_tm", "un");

		this.getServletContext().getRequestDispatcher(REALISATION_FCRO).forward(request, response);

	}

}
