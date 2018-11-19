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
public class InscriptionConnexionPatient extends HttpServlet {

	public static final String VUE_INSCRIRE_CONNECTER_PATIENT = "/WEB-INF/inscrireconnecterPatient.jsp";

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/*
		 * A la réception d'une requête GET, simple affichage de la page
		 */

		this.getServletContext().getRequestDispatcher(VUE_INSCRIRE_CONNECTER_PATIENT).forward(request, response);
	}

}
