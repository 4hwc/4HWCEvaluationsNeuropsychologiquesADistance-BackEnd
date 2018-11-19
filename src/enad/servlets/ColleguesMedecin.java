package enad.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import enad.dao.DAOFactory;
import enad.dao.MedecinDao;
import enad.forms.ColleguesMedecinForm;

public class ColleguesMedecin extends HttpServlet {

	public static final String CONF_DAO_FACTORY = "daofactory";

	private MedecinDao medecinDao;

	public static final String INFORMATIONS_TM = "/WEB-INF/collegues.jsp";

	public void init() throws ServletException {

		this.medecinDao = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY)).getMedecinDao();

	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ColleguesMedecinForm form = new ColleguesMedecinForm(medecinDao);

		request.setAttribute("collegues", form.Collegues(request));

		/*
		 * A la réception d'une requête GET, simple affichage de la page
		 */

		this.getServletContext().getRequestDispatcher(INFORMATIONS_TM).forward(request, response);
	}

}
