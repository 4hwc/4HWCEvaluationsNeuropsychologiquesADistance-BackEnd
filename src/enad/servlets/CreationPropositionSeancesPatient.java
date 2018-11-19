package enad.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import enad.beans.PropositionSeance;
import enad.dao.DAOFactory;
import enad.dao.PatientDao;
import enad.dao.PropositionSeanceDao;
import enad.dao.SeanceDao;
import enad.forms.CreationPropositionSeancesPatientForm;

public class CreationPropositionSeancesPatient extends HttpServlet {

	public static final String CONF_DAO_FACTORY = "daofactory";

	public static final String ATT_PROP_SEANCE = "propseance";

	public static final String ATT_FORM = "form";

	private SeanceDao seanceDao;

	private PropositionSeanceDao propositionseanceDao;

	private PatientDao patientDao;

	public void init() throws ServletException {

		this.propositionseanceDao = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY))
				.getPropositionSeanceDao();

		this.patientDao = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY)).getPatientDao();

		this.seanceDao = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY)).getSeanceDao();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		CreationPropositionSeancesPatientForm form = new CreationPropositionSeancesPatientForm(seanceDao,
				propositionseanceDao, patientDao);

		/*
		 * Appel au traitement et à la validation de la requête, et récupération
		 * du bean en résultant
		 */

		PropositionSeance propseance = form.creerPropositionSeance(request);

		/* Stockage du formulaire et du bean dans l'objet request */

		request.setAttribute(ATT_FORM, form);

		request.setAttribute("idseance", form.ideseance);

		request.setAttribute(ATT_PROP_SEANCE, propseance);

		response.sendRedirect("/enad/liste_proposition_seances_patient?idSeance=" + form.ideseance);

	}

}
