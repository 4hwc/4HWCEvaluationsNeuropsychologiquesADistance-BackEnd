package enad.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Batterie_Rapide_Efficience_Frontale extends HttpServlet {

	public static final String BREF = "/WEB-INF/Batterie_Rapide_Efficience_Frontale.jsp";

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/*
		 * A la réception d'une requête GET, simple affichage de la page
		 */

		this.getServletContext().getRequestDispatcher(BREF).forward(request, response);
	}

}
