package enad.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import enad.dao.BrefDao;
import enad.dao.DAOFactory;
import enad.forms.ResultatsBrefChronoDecroissantForm;

public class ResultatsBrefChronoDecroissant extends HttpServlet {

	private BrefDao brefDao;

	public static final String CONF_DAO_FACTORY = "daofactory";

	public static final String RESULTATS_BREF = "/WEB-INF/listeResultatsBrefChronoDecroissant.jsp";

	public void init() throws ServletException {

		this.brefDao = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY)).getBrefDao();

	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ResultatsBrefChronoDecroissantForm form = new ResultatsBrefChronoDecroissantForm(brefDao);

		form.ListeDesResBref(request);

		request.setAttribute("listebref", form.liste);

		/*
		 * A la réception d'une requête GET, simple affichage de la page
		 */

		this.getServletContext().getRequestDispatcher(RESULTATS_BREF).forward(request, response);
	}

}
