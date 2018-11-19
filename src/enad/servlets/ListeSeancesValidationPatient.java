package enad.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import enad.dao.DAOFactory;
import enad.dao.PatientDao;
import enad.dao.PropositionSeanceDao;
import enad.dao.SeanceDao;
import enad.forms.ListeSeancesValidationPatientForm;

public class ListeSeancesValidationPatient extends HttpServlet {

	public static final String LISTE_SEANCES_VALIDATION_PATIENT = "/WEB-INF/listeSeancesValidationPatient.jsp";

	public static final String ATT_SEANCE = "seances";

	public static final String CONF_DAO_FACTORY = "daofactory";

	private PatientDao patientDao;

	private SeanceDao seanceDao;

	private PropositionSeanceDao propositionseanceDao;

	public void init() throws ServletException {

		/* Récupération d'une instance de nos DAO Patient, Seance */

		this.patientDao = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY)).getPatientDao();

		this.seanceDao = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY)).getSeanceDao();

		this.propositionseanceDao = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY))
				.getPropositionSeanceDao();

	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ListeSeancesValidationPatientForm form = new ListeSeancesValidationPatientForm(seanceDao, patientDao,
				propositionseanceDao);

		form.listeSeancesValidation(request);

		request.setAttribute(ATT_SEANCE, form.Seances);

		/*
		 * A la réception d'une requête GET, simple affichage de la page
		 */

		this.getServletContext().getRequestDispatcher(LISTE_SEANCES_VALIDATION_PATIENT).forward(request, response);
	}

}
