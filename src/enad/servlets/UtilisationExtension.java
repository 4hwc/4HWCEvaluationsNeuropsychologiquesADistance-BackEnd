package enad.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UtilisationExtension extends HttpServlet {

	public static final String VUE_NOTICE = "/WEB-INF/utilisation_extension.jsp";

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/*
		 * A la réception d'une requête GET, simple affichage de la page
		 * 
		 * 
		 */

		this.getServletContext().getRequestDispatcher(VUE_NOTICE).forward(request, response);

	}

}
