/**
 * 
 */
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
import enad.dao.MedecinDao;
import enad.dao.PatientDao;
import enad.dao.SeanceDao;
import enad.forms.CreationSeancesMedecinForm;

/**
 * @author Admin
 *
 */
public class CreationSeancesMedecin extends HttpServlet {

	public static final String CREATION_SEANCES_MEDECIN = "/WEB-INF/creerSeancesMedecin.jsp";

	public static final String CONF_DAO_FACTORY = "daofactory";

	public static final String ATT_MEDECIN = "medecin";

	public static final String ATT_SEANCE = "seance";

	public static final String ATT_SESSION_MEDECIN = "sessionMedecin";

	public static final String ATT_SESSION_SEANCE = "sessionSeance";

	public static final String ATT_FORM = "form";

	public static final String ATT_PATIENT = "patients";

	public static final String SEANCES_VALIDATION = "/enad/liste_seances_validation_Medecin";

	private SeanceDao seanceDao;

	private MedecinDao medecinDao;

	private PatientDao patientDao;

	private ArrayList<Patient> listepatients = new ArrayList<Patient>();

	public void init() throws ServletException {

		this.seanceDao = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY)).getSeanceDao();

		this.medecinDao = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY)).getMedecinDao();

		this.patientDao = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY)).getPatientDao();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		CreationSeancesMedecinForm formliste = new CreationSeancesMedecinForm(seanceDao, medecinDao, patientDao);

		ArrayList<Patient> Patients = formliste.listePatients(request);

		listepatients = Patients;

		request.setAttribute(ATT_PATIENT, Patients);

		String creationseance = "creationseance";

		request.setAttribute("creationseance", creationseance);

		/*
		 * A la réception d'une requête GET, simple affichage de la page
		 */

		this.getServletContext().getRequestDispatcher(CREATION_SEANCES_MEDECIN).forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/* Préparation de l'objet formulaire */

		CreationSeancesMedecinForm form = new CreationSeancesMedecinForm(seanceDao, medecinDao, patientDao);

		/*
		 * Appel au traitement et à la validation de la requête, et récupération
		 * du bean en résultant
		 */

		Seance seance = form.creerSeance(request);

		/*
		 * if (form.getErreurs().isEmpty()) {
		 * 
		 * // session.setAttribute(ATT_SESSION_MEDECIN, (Medecin) //
		 * session.getAttribute(ATT_SESSION_MEDECIN));
		 * 
		 * session.setAttribute(ATT_SESSION_SEANCE, seance);
		 * 
		 * } else {
		 * 
		 * session.setAttribute(ATT_SESSION_SEANCE, null);
		 * 
		 * }
		 */

		/* Stockage du formulaire et du bean dans l'objet request */

		request.setAttribute(ATT_FORM, form);
		request.setAttribute(ATT_SEANCE, seance);

		if (form.getErreurs().isEmpty()) {
			response.sendRedirect(SEANCES_VALIDATION);
		} else {

			request.setAttribute(ATT_PATIENT, form.listePatients(request));

			String creationseance = "creationseance";

			request.setAttribute("creationseance", creationseance);

			this.getServletContext().getRequestDispatcher(CREATION_SEANCES_MEDECIN).forward(request, response);

		}

	}

}
