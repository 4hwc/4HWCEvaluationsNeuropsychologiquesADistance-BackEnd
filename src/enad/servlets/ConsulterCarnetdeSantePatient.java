package enad.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ConsulterCarnetdeSantePatient extends HttpServlet {

	public static final String C_CARNET_PATIENT = "/WEB-INF/c_carnetdesantePatient.jsp";

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/*
		 * A la réception d'une requête GET, simple affichage de la page
		 */

		this.getServletContext().getRequestDispatcher(C_CARNET_PATIENT).forward(request, response);
	}

}
