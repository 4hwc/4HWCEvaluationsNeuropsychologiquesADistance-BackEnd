package enad.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListeDiagnosticsFcro extends HttpServlet {

	public static final String DIAGNOSTICS_FCRO = "/WEB-INF/listeDiagnosticsFcro.jsp";

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/*
		 * A la réception d'une requête GET, simple affichage de la page
		 */

		this.getServletContext().getRequestDispatcher(DIAGNOSTICS_FCRO).forward(request, response);
	}

}
