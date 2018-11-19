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
import enad.dao.DAOFactory;
import enad.dao.PatientDao;
import enad.forms.RechercheParPrenomsEtNomsPatientForm;

/**
 * @author Admin
 *
 */
public class RechercheParPrenomsEtNomsPatient extends HttpServlet {

	public static final String CONF_DAO_FACTORY = "daofactory";

	public static final String ATT_SESSION_PATIENT = "sessionPatient";

	public static final String ATT_FORM = "form";

	public static final String ATT_PATIENT = "patients";

	public static final String ACCUEIL_PATIENT = "/enad/accueil_Patient";

	public static final String VUE_RECHERCHE_PRENOMS_NOMS = "/WEB-INF/rechercheparprenomsetnomsPatient.jsp";

	private PatientDao patientDao;

	public void init() throws ServletException {

		/* Récupération d'une instance de notre DAO Patient */

		this.patientDao = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY)).getPatientDao();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/*
		 * A la réception d'une requête GET, simple affichage de la page
		 */

		this.getServletContext().getRequestDispatcher(VUE_RECHERCHE_PRENOMS_NOMS).forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/* Préparation de l'objet formulaire recherche du patient */

		RechercheParPrenomsEtNomsPatientForm form = new RechercheParPrenomsEtNomsPatientForm(patientDao);

		/*
		 * Appel au traitement et à la validation de la requête, et récupération
		 * de la liste des beans en résultant
		 */

		ArrayList<Patient> patients = form.connecterPrenomsNomsPatient(request);

		/* Récupération de la session depuis la requête */

		// HttpSession session = request.getSession();

		/*
		 * Si aucune erreur de validation n'a eu lieu, alors ajout du bean
		 * Patient à la session, sinon suppression du bean de la session.
		 */

		/*
		 * 
		 * if (form.getErreurs().isEmpty()) {
		 * 
		 * session.setAttribute(ATT_SESSION_PATIENT, patients);
		 * 
		 * } else {
		 * 
		 * session.setAttribute(ATT_SESSION_PATIENT, null);
		 * 
		 * }
		 * 
		 */

		/* Stockage du formulaire et la liste de beans dans l'objet request */

		request.setAttribute(ATT_FORM, form);

		request.setAttribute(ATT_PATIENT, patients);

		this.getServletContext().getRequestDispatcher(VUE_RECHERCHE_PRENOMS_NOMS).forward(request, response);

	}

}
