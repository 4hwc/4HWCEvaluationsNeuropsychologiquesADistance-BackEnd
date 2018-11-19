package enad.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import enad.beans.Seance;
import enad.dao.DAOFactory;
import enad.dao.PatientDao;
import enad.dao.SeanceDao;
import enad.forms.ListeSeancesValideesSuivantesPatientForm;

public class ListeSeancesValideesSuivantesPatient extends HttpServlet {

	public static final String LISTE_SEANCES_VALIDEES_SUIV_PATIENT = "/WEB-INF/listeSeancesValideesSuivantesPatient.jsp";

	public static final String ATT_SEANCE = "seances";

	public static final String CONF_DAO_FACTORY = "daofactory";

	private PatientDao patientDao;

	private SeanceDao seanceDao;

	public void init() throws ServletException {

		/* Récupération d'une instance de nos DAO Medecin , Seance */

		this.patientDao = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY)).getPatientDao();

		this.seanceDao = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY)).getSeanceDao();

	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ListeSeancesValideesSuivantesPatientForm form = new ListeSeancesValideesSuivantesPatientForm(seanceDao,
				patientDao);

		ArrayList<Seance> Seances = form.listeSeancesValideesSuiv(request);

		request.setAttribute(ATT_SEANCE, Seances);

		/*
		 * A la réception d'une requête GET, simple affichage de la page
		 */

		this.getServletContext().getRequestDispatcher(LISTE_SEANCES_VALIDEES_SUIV_PATIENT).forward(request, response);
	}

}
