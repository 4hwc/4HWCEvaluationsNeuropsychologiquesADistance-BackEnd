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
public class Enad_admin_connexion extends HttpServlet {

	public static final String VUE_ENAD_ADMIN_CONNEXION = "/WEB-INF/enad_admin_connexion.jsp";

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/*
		 * A la réception d'une requête GET, simple affichage de la page
		 * 
		 * 
		 */

		this.getServletContext().getRequestDispatcher(VUE_ENAD_ADMIN_CONNEXION).forward(request, response);

	}

}
