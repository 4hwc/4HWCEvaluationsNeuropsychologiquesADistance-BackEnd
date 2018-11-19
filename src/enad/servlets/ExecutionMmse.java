package enad.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import enad.beans.Mmse;
import enad.beans.Patient;
import enad.dao.DAOFactory;
import enad.dao.MedecinDao;
import enad.dao.MmseDao;
import enad.dao.PatientDao;
import enad.forms.ExecutionMmseForm;

public class ExecutionMmse extends HttpServlet {

	private MedecinDao medecinDao;

	private PatientDao patientDao;

	public static final String ATT_FORM = "form";

	public static final String CONF_DAO_FACTORY = "daofactory";

	private MmseDao mmseDao;

	public static final String ATT_PATIENT = "patients";

	private ArrayList<Patient> listepatients = new ArrayList<Patient>();

	public static final String TEST_MMSE = "/WEB-INF/test_mmse.jsp";

	public void init() throws ServletException {

		this.medecinDao = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY)).getMedecinDao();

		this.patientDao = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY)).getPatientDao();

		this.mmseDao = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY)).getMmseDao();

	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ExecutionMmseForm form = new ExecutionMmseForm(mmseDao, medecinDao, patientDao);

		ArrayList<Patient> Patients = form.listePatients(request);

		listepatients = Patients;

		request.setAttribute(ATT_PATIENT, Patients);

		/*
		 * A la réception d'une requête GET, simple affichage de la page
		 */

		this.getServletContext().getRequestDispatcher(TEST_MMSE).forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ExecutionMmseForm formmmse = new ExecutionMmseForm(mmseDao, medecinDao, patientDao);

		Mmse mmse = formmmse.creerMmse(request);

		request.setAttribute(ATT_FORM, formmmse);

		request.setAttribute("mmse", mmse);

		request.setAttribute(ATT_PATIENT, formmmse.listePatients(request));

		request.setAttribute("total", mmse.getScoreTotalMmse());

		request.setAttribute("nomsprenomspat", mmse.getPrenoms_noms_patient());

		request.setAttribute("succes", "Succès de l'enregistrement du résultat");

		request.setAttribute("echec", "Échec de l'enregistrement du résultat");

		this.getServletContext().getRequestDispatcher(TEST_MMSE).forward(request, response);

	}

}
