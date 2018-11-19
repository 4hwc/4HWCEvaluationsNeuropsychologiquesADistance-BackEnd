package enad.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import enad.beans.PropositionSeance;
import enad.dao.DAOFactory;
import enad.dao.PatientDao;
import enad.dao.PropositionSeanceDao;
import enad.forms.ListePropositionSeancesPatientForm;

public class ListePropositionSeancesPatient extends HttpServlet {

	public static final String LISTE_PROPOSITION_SEANCES_PATIENT = "/WEB-INF/listePropositionSeancesPatient.jsp";

	private PatientDao patientDao;

	public static final String CONF_DAO_FACTORY = "daofactory";

	public static final String ATT_PROP_SEANCE = "propseances";

	public static final String ATT_IDENTIFIANT_EMISSION = "identifiantemission";

	public static final String ATT_SESSION_PATIENT = "sessionPatient";

	private PropositionSeanceDao propositionseanceDao;

	public void init() throws ServletException {

		/* Récupération d'une instance de nos DAO */

		this.patientDao = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY)).getPatientDao();

		this.propositionseanceDao = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY))
				.getPropositionSeanceDao();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ListePropositionSeancesPatientForm form = new ListePropositionSeancesPatientForm(patientDao,
				propositionseanceDao);

		ArrayList<PropositionSeance> propSeances = form.listeSeancesProposition(request);

		form.identifiant_emission(request);

		form.ValidationDerniereProp(request);

		form.egalidentifiant(request);

		request.setAttribute(ATT_PROP_SEANCE, propSeances);

		request.setAttribute(ATT_IDENTIFIANT_EMISSION, form.identifiantemission);

		request.setAttribute("egal", form.egal);

		request.setAttribute("idseance", form.idseance);

		request.setAttribute("validation", form.validation);

		/*
		 * A la réception d'une requête GET, simple affichage de la page
		 */

		this.getServletContext().getRequestDispatcher(LISTE_PROPOSITION_SEANCES_PATIENT).forward(request, response);
	}

}
