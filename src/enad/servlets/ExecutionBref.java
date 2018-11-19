package enad.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import enad.beans.Bref;
import enad.beans.Patient;
import enad.dao.BrefDao;
import enad.dao.DAOFactory;
import enad.dao.MedecinDao;
import enad.dao.PatientDao;
import enad.forms.ExecutionBrefForm;

public class ExecutionBref extends HttpServlet {

	private MedecinDao medecinDao;

	private PatientDao patientDao;

	public static final String ATT_FORM = "form";

	public static final String CONF_DAO_FACTORY = "daofactory";

	private BrefDao brefDao;

	public static final String ATT_PATIENT = "patients";

	private ArrayList<Patient> listepatients = new ArrayList<Patient>();

	public static final String TEST_BREF = "/WEB-INF/test_bref.jsp";

	public void init() throws ServletException {

		this.medecinDao = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY)).getMedecinDao();

		this.patientDao = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY)).getPatientDao();

		this.brefDao = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY)).getBrefDao();

	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ExecutionBrefForm form = new ExecutionBrefForm(brefDao, medecinDao, patientDao);

		ArrayList<Patient> Patients = form.listePatients(request);

		listepatients = Patients;

		request.setAttribute(ATT_PATIENT, Patients);

		/*
		 * A la réception d'une requête GET, simple affichage de la page
		 */

		this.getServletContext().getRequestDispatcher(TEST_BREF).forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ExecutionBrefForm formbref = new ExecutionBrefForm(brefDao, medecinDao, patientDao);

		Bref bref = formbref.creerBref(request);

		request.setAttribute(ATT_FORM, formbref);

		request.setAttribute("bref", bref);

		request.setAttribute(ATT_PATIENT, formbref.listePatients(request));

		request.setAttribute("total", bref.getScoreTotalBref());

		request.setAttribute("nomsprenomspat", bref.getPrenoms_noms_patient());

		request.setAttribute("succes", "Succès de l'enregistrement du résultat");

		request.setAttribute("echec", "Échec de l'enregistrement du résultat");

		this.getServletContext().getRequestDispatcher(TEST_BREF).forward(request, response);

	}

}
