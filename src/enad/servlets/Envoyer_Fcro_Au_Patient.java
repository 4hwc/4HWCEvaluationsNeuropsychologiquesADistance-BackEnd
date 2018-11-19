package enad.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import enad.beans.Patient;
import enad.beans.Seance;
import enad.dao.DAOFactory;
import enad.dao.PatientDao;
import enad.dao.SeanceDao;
import enad.forms.Envoyer_Fcro_Au_PatientForm;

public class Envoyer_Fcro_Au_Patient extends HttpServlet {

	public static final String CONF_DAO_FACTORY = "daofactory";

	private SeanceDao seanceDao;

	private PatientDao patientDao;

	public static final String ATT_PATIENT = "patients";

	public static final String ATT_SEANCE = "seances";

	public static final String ENVOYER_FCRO = "/WEB-INF/envoyerFcroAuPatient.jsp";

	public void init() throws ServletException {

		/* Récupération d'une instance de nos DAO Medecin , Patient, Seance */

		this.seanceDao = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY)).getSeanceDao();

		this.patientDao = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY)).getPatientDao();

	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Envoyer_Fcro_Au_PatientForm form = new Envoyer_Fcro_Au_PatientForm(seanceDao, patientDao);

		ArrayList<Patient> Patients = form.listePatientsJour(request);

		ArrayList<Seance> Seances = form.listeSeancesJour(request);

		request.setAttribute(ATT_PATIENT, Patients);

		request.setAttribute(ATT_SEANCE, Seances);

		/*
		 * A la réception d'une requête GET, simple affichage de la page
		 */

		this.getServletContext().getRequestDispatcher(ENVOYER_FCRO).forward(request, response);
	}

}
