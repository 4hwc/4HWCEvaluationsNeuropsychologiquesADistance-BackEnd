package enad.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import enad.beans.Medecin;
import enad.beans.Patient;
import enad.dao.DAOFactory;
import enad.dao.MedecinDao;
import enad.dao.PatientDao;
import enad.forms.EnadRechercheForm;

public class RecherchesMedecin extends HttpServlet {

	private PatientDao patientDao;

	private MedecinDao medecinDao;

	public static final String CONF_DAO_FACTORY = "daofactory";

	public static final String ATT_FORM = "formi";

	public static final String ATT_PATIENT = "patients";

	public static final String ATT_MEDECIN = "medecins";

	public static final String NOTIF = "/WEB-INF/recherchesMedecin.jsp";

	public void init() throws ServletException {

		/* Récupération d'une instance de notre DAO Patient */

		this.patientDao = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY)).getPatientDao();

		this.medecinDao = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY)).getMedecinDao();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		EnadRechercheForm form = new EnadRechercheForm(patientDao, medecinDao);

		ArrayList<Patient> patients = form.PrenomsNomsPatient(request);

		ArrayList<Medecin> medecins = form.PrenomsNomsMedecin(request);

		request.setAttribute(ATT_FORM, form);

		request.setAttribute(ATT_PATIENT, patients);

		request.setAttribute(ATT_MEDECIN, medecins);

		/*
		 * A la réception d'une requête GET, simple affichage de la page
		 */

		this.getServletContext().getRequestDispatcher(NOTIF).forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		EnadRechercheForm form = new EnadRechercheForm(patientDao, medecinDao);

		ArrayList<Patient> patients = form.PrenomsNomsPatient(request);

		ArrayList<Medecin> medecins = form.PrenomsNomsMedecin(request);

		request.setAttribute(ATT_FORM, form);

		request.setAttribute(ATT_PATIENT, patients);

		request.setAttribute(ATT_MEDECIN, medecins);

		this.getServletContext().getRequestDispatcher(NOTIF).forward(request, response);

	}

}
