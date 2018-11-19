/**
 * 
 */
package enad.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import enad.dao.DAOFactory;
import enad.dao.MedecinDao;

/**
 * @author Admin
 *
 */
public class DeconnexionMedecin extends HttpServlet {

	public static final String CONF_DAO_FACTORY = "daofactory";

	public static final String REMERCIEMENTS = "/enad/enad";

	public static final String ATT_SESSION_MEDECIN = "sessionMedecin";

	private MedecinDao medecinDao;

	public void init() throws ServletException {

		/* Récupération d'une instance de notre DAO */

		this.medecinDao = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY)).getMedecinDao();

	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/* Récupération et destruction de la session en cours */

		HttpSession session = request.getSession();

		if (session.getAttribute(ATT_SESSION_MEDECIN) != null) {

			String identifiantmed = request.getParameter("identifiant");

			medecinDao.supprimer_ip(medecinDao.trouver(identifiantmed));

			session.invalidate();

		}

		/*
		 * Redirection vers la page de remerciements
		 */

		response.sendRedirect(REMERCIEMENTS);

	}

}
