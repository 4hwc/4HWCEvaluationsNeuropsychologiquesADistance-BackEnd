/**
 * 
 */
package enad.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import enad.beans.Seance;
import enad.dao.DAOFactory;
import enad.dao.MedecinDao;
import enad.dao.SeanceDao;
import enad.forms.ListeSeancesValideesSuivantesMedecinForm;

/**
 * @author Admin
 *
 */
public class ListeSeancesValideesSuivantesMedecin extends HttpServlet {

	public static final String ATT_SEANCE = "seances";

	public static final String CONF_DAO_FACTORY = "daofactory";

	private MedecinDao medecinDao;

	private SeanceDao seanceDao;

	public static final String LISTE_SEANCES_VALIDEES_SUIV_MEDECIN = "/WEB-INF/listeSeancesValideesSuivantesMedecin.jsp";

	public void init() throws ServletException {

		/* Récupération d'une instance de nos DAO Medecin , Seance */

		this.medecinDao = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY)).getMedecinDao();

		this.seanceDao = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY)).getSeanceDao();

	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ListeSeancesValideesSuivantesMedecinForm form = new ListeSeancesValideesSuivantesMedecinForm(seanceDao,
				medecinDao);

		ArrayList<Seance> Seances = form.listeSeancesValideesSuiv(request);

		String destinationapressuppression = "liste_seances_validees_suiv_Medecin";

		request.setAttribute("destinationapressuppression", destinationapressuppression);

		request.setAttribute(ATT_SEANCE, Seances);

		/*
		 * A la réception d'une requête GET, simple affichage de la page
		 */

		this.getServletContext().getRequestDispatcher(LISTE_SEANCES_VALIDEES_SUIV_MEDECIN).forward(request, response);
	}

}
