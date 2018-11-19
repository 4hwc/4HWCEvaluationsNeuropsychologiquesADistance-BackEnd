/**
 * 
 */
package enad.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Admin
 *
 */
public class ListeSeancesValideesMedecin extends HttpServlet {

	public static final String LISTE_SEANCES_VALIDEES_MEDECIN = "/WEB-INF/listeSeancesValideesMedecin.jsp";

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/*
		 * A la réception d'une requête GET, simple affichage de la page
		 */

		this.getServletContext().getRequestDispatcher(LISTE_SEANCES_VALIDEES_MEDECIN).forward(request, response);
	}

}
