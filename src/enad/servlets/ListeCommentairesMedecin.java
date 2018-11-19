package enad.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListeCommentairesMedecin extends HttpServlet {

	public static final String LISTE_COMMENTAIRES_MEDECIN = "/WEB-INF/listeCommentairesMedecin.jsp";

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/*
		 * A la réception d'une requête GET, simple affichage de la page
		 */

		this.getServletContext().getRequestDispatcher(LISTE_COMMENTAIRES_MEDECIN).forward(request, response);
	}

}
