/**
 * 
 */
package enad.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import enad.beans.Patient;
import enad.dao.DAOFactory;
import enad.dao.MedecinDao;
import enad.dao.PatientDao;
import enad.forms.InscriptionPatientForm;

/**
 * @author Admin
 *
 */
public class InscriptionPatient extends HttpServlet {

	public static final String CONF_DAO_FACTORY = "daofactory";

	public static final String ATT_PATIENT = "patient";

	public static final String ATT_SESSION_PATIENT = "sessionPatient";

	public static final String ATT_FORM = "form";

	public static final String VUE_INSCRIRE_PATIENT = "/WEB-INF/inscrirePatient.jsp";

	public static final String ACCUEIL_PATIENT = "/enad/accueil_Patient";

	private PatientDao patientDao;

	private MedecinDao medecinDao;

	public void init() throws ServletException {

		this.medecinDao = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY)).getMedecinDao();

		this.patientDao = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY)).getPatientDao();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/*
		 * A la réception d'une requête GET, simple affichage de la page
		 * d'inscription du patient
		 */

		this.getServletContext().getRequestDispatcher(VUE_INSCRIRE_PATIENT).forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/* Préparation de l'objet formulaire du patient */

		InscriptionPatientForm form = new InscriptionPatientForm(patientDao, medecinDao);

		/*
		 * Appel au traitement et à la validation de la requête, et récupération
		 * du bean en résultant
		 */

		Patient patient = form.inscrirePatient(request);

		/* Récupération de la session depuis la requête */

		HttpSession session = request.getSession();
		/*
		 * Si aucune erreur de validation n'a eu lieu, alors ajout du bean
		 * Patient à la session, sinon suppression du bean de la session.
		 */

		if (form.getErreurs().isEmpty()) {

			session.setAttribute(ATT_SESSION_PATIENT, patient);

			session.setAttribute("occurence_accueil", 0);

			session.setAttribute("adresseserveur", request.getServerName());

		} else {

			session.setAttribute(ATT_SESSION_PATIENT, null);

			request.setAttribute("echec", "Échec de l'inscription");

		}

		/* Stockage du formulaire et du bean dans l'objet request */

		request.setAttribute(ATT_FORM, form);

		request.setAttribute(ATT_PATIENT, patient);

		if (form.getErreurs().isEmpty()) {

			response.sendRedirect(ACCUEIL_PATIENT);

		} else {

			this.getServletContext().getRequestDispatcher(VUE_INSCRIRE_PATIENT).forward(request, response);

		}

	}

}
