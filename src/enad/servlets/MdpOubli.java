/**
 * 
 */
package enad.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import enad.beans.Medecin;
import enad.dao.DAOFactory;
import enad.dao.MedecinDao;
import enad.forms.MdpOubliForm;

/**
 * @author Admin
 *
 */
public class MdpOubli extends HttpServlet {

	public static final String CONF_DAO_FACTORY = "daofactory";

	public static final String ATT_FORM = "form";

	public static final String ATT_MEDECIN = "medecin";

	private MedecinDao medecinDao;

	public static final String VUE_MDP_OUBLI = "/WEB-INF/mdpoubli.jsp";

	public void init() throws ServletException {

		/* Récupération d'une instance de notre DAO Medecin */

		this.medecinDao = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY)).getMedecinDao();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/*
		 * A la réception d'une requête GET, simple affichage du formulaire
		 * 
		 * 
		 */

		this.getServletContext().getRequestDispatcher(VUE_MDP_OUBLI).forward(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/* Préparation de l'objet formulaire omdp du médecin */

		MdpOubliForm form = new MdpOubliForm(medecinDao);

		/*
		 * Appel au traitement et à la validation de la requête, et récupération
		 * du bean en résultant
		 */

		Medecin medecin = form.mdpMedecin(request);

		/* Stockage du formulaire et du bean dans l'objet request */

		request.setAttribute(ATT_FORM, form);
		request.setAttribute(ATT_MEDECIN, medecin);

		if (form.getErreurs().isEmpty()) {

			this.getServletContext().getRequestDispatcher(VUE_MDP_OUBLI).forward(request, response);

		} else {

			request.setAttribute("echec", "Échec de la modification du mot de passe");

			this.getServletContext().getRequestDispatcher(VUE_MDP_OUBLI).forward(request, response);

		}

	}

}
