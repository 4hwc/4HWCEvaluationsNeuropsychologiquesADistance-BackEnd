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
import enad.dao.PatientDao;
import enad.forms.TransitionRpnApForm;

/**
 * @author Admin
 *
 */
public class TransitionRpnAp extends HttpServlet {

	public static final String ATT_SESSION_PATIENT = "sessionPatient";

	public static final String ATT_PATIENT = "patient";

	public static final String ACCUEIL_PATIENT = "/enad/accueil_Patient";

	public static final String CONF_DAO_FACTORY = "daofactory";

	private PatientDao patientDao;

	public void init() throws ServletException {

		/* Récupération d'une instance de notre DAO Patient */

		this.patientDao = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY)).getPatientDao();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		TransitionRpnApForm form = new TransitionRpnApForm(patientDao);

		Patient patient = form.connecterPatient(request);

		/* Récupération de la session depuis la requête */

		HttpSession session = request.getSession();

		session.setAttribute(ATT_SESSION_PATIENT, patient);

		session.setAttribute("adresseserveur", request.getServerName());

		session.setAttribute("occurence_accueil", 0);

		response.sendRedirect(ACCUEIL_PATIENT);

	}

}
