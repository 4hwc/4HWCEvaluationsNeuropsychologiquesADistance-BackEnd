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

import enad.beans.Medecin;
import enad.dao.DAOFactory;
import enad.dao.MedecinDao;
import enad.forms.ConnexionMedecinForm;

/**
 * @author Admin
 *
 */
public class ConnexionMedecin extends HttpServlet {

	public static final String CONF_DAO_FACTORY = "daofactory";

	public static final String VUE_CONNECTER_MEDECIN = "/WEB-INF/connecterMedecin.jsp";

	public static final String ATT_SESSION_MEDECIN = "sessionMedecin";

	public static final String ATT_FORM = "form";

	public static final String ATT_MEDECIN = "medecin";

	public static final String ACCUEIL_MEDECIN = "/enad/accueil_Medecin";

	public static final String acc_med = "/WEB-INF/accueillirMedecin.jsp";

	private MedecinDao medecinDao;

	public void init() throws ServletException {

		/* Récupération d'une instance de notre DAO Medecin */

		this.medecinDao = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY)).getMedecinDao();

	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/*
		 * A la réception d'une requête GET, simple affichage du formulaire
		 */

		this.getServletContext().getRequestDispatcher(VUE_CONNECTER_MEDECIN).forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/* Préparation de l'objet formulaire du médecin */

		ConnexionMedecinForm form = new ConnexionMedecinForm(medecinDao);

		/*
		 * Appel au traitement et à la validation de la requête, et récupération
		 * du bean en résultant
		 */

		Medecin medecin = form.connecterMedecin(request);

		/* Récupération de la session depuis la requête */

		HttpSession session = request.getSession();

		/*
		 * Si aucune erreur de validation n'a eu lieu, alors ajout du bean
		 * Medecin à la session, sinon suppression du bean de la session.
		 */

		if (form.getErreurs().isEmpty()) {

			session.setAttribute(ATT_SESSION_MEDECIN, medecin);

			session.setAttribute("occurence_accueil", 0);

			session.setAttribute("adresseserveur", request.getServerName());

		} else {

			session.setAttribute(ATT_SESSION_MEDECIN, null);

			request.setAttribute("echec", "Échec de la connexion");

		}

		/* Stockage du formulaire et du bean dans l'objet request */

		request.setAttribute(ATT_FORM, form);
		request.setAttribute(ATT_MEDECIN, medecin);

		if (form.getErreurs().isEmpty()) {

			response.sendRedirect(ACCUEIL_MEDECIN);

			// this.getServletContext().getRequestDispatcher(ACCUEIL_MEDECIN).forward(request,
			// response);

		} else {

			this.getServletContext().getRequestDispatcher(VUE_CONNECTER_MEDECIN).forward(request, response);

		}

	}

}
