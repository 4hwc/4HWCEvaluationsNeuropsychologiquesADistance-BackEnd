package enad.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import enad.dao.BrefDao;
import enad.dao.DAOFactory;
import enad.forms.ResultatsBrefDecroissantUniqueForm;

public class ResultatsBrefDecroissantUnique extends HttpServlet {

	private BrefDao brefDao;

	public static final String CONF_DAO_FACTORY = "daofactory";

	public static final String RESULTATS_BREF = "/WEB-INF/listeResultatsBrefDecroissantUnique.jsp";

	public void init() throws ServletException {

		this.brefDao = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY)).getBrefDao();

	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ResultatsBrefDecroissantUniqueForm form = new ResultatsBrefDecroissantUniqueForm(brefDao);

		form.ListeDesResBrefUnique(request);

		request.setAttribute("listebref", form.liste);

		/*
		 * A la réception d'une requête GET, simple affichage de la page
		 */

		this.getServletContext().getRequestDispatcher(RESULTATS_BREF).forward(request, response);
	}

}
