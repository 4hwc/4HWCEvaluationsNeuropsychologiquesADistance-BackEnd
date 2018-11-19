package enad.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import enad.dao.DAOFactory;
import enad.dao.MmseDao;
import enad.forms.ResultatsMmseChronoDecroissantForm;

public class ResultatsMmseChronoDecroissant extends HttpServlet {

	private MmseDao mmseDao;

	public static final String CONF_DAO_FACTORY = "daofactory";

	public static final String RESULTATS_MMSE = "/WEB-INF/listeResultatsMmseChronoDecroissant.jsp";

	public void init() throws ServletException {

		this.mmseDao = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY)).getMmseDao();

	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ResultatsMmseChronoDecroissantForm form = new ResultatsMmseChronoDecroissantForm(mmseDao);

		form.ListeDesResMmse(request);

		request.setAttribute("listebref", form.liste);

		/*
		 * A la réception d'une requête GET, simple affichage de la page
		 */

		this.getServletContext().getRequestDispatcher(RESULTATS_MMSE).forward(request, response);
	}

}
