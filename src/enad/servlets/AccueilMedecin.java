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
import javax.servlet.http.HttpSession;

import enad.beans.Seance;
import enad.dao.DAOFactory;
import enad.dao.SeanceDao;
import enad.forms.AccueilMedecinForm;

/**
 * @author Admin
 *
 */
public class AccueilMedecin extends HttpServlet {

	public static final String CONF_DAO_FACTORY = "daofactory";

	public static final String ATT_SESSION_MEDECIN = "sessionMedecin";

	public static final String ATT_MEDECIN = "medecin";

	public static final String ATT_SEANCE = "seances";

	public static final String VUE_ACCUEILLIR_MEDECIN = "/WEB-INF/accueillirMedecin.jsp";

	private SeanceDao seanceDao;

	// public void init() throws ServletException {

	/* Récupération d'une instance de notre DAO Medecin */

	// this.medecinDao = ((DAOFactory)
	// getServletContext().getAttribute(CONF_DAO_FACTORY)).getMedecinDao();
	// }

	public void init() throws ServletException {

		this.seanceDao = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY)).getSeanceDao();

	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// response.setIntHeader("Refresh", 1);

		AccueilMedecinForm form = new AccueilMedecinForm(seanceDao);

		ArrayList<Seance> Seances = form.listeSeancesValideesJour(request);

		request.setAttribute(ATT_SEANCE, Seances);

		HttpSession session = request.getSession();

		int f = (int) session.getAttribute("occurence_accueil") + 1;

		session.setAttribute("occurence_accueil", f);

		// System.out.println("occfj : " +
		// session.getAttribute("occurence_accueil"));

		/*
		 * A la réception d'une requête GET, simple affichage de la page
		 */

		this.getServletContext().getRequestDispatcher(VUE_ACCUEILLIR_MEDECIN).forward(request, response);
	}

}
