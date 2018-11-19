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
public class ConnexionPatient extends HttpServlet {

	public static final String VUE_CONNECTER_PATIENT = "/WEB-INF/connecterPatient.jsp";

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/*
		 * A la réception d'une requête GET, simple affichage du formulaire
		 */

		this.getServletContext().getRequestDispatcher(VUE_CONNECTER_PATIENT).forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/* Traitement des données du formulaire de connexion du patient */

	}

}
