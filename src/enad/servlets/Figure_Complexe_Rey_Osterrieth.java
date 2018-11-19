package enad.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Figure_Complexe_Rey_Osterrieth extends HttpServlet {

	public static final String FCRO = "/WEB-INF/figure_complexe_de_Rey_Osterrieth.jsp";

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/*
		 * A la réception d'une requête GET, simple affichage de la page
		 */

		this.getServletContext().getRequestDispatcher(FCRO).forward(request, response);
	}

}
