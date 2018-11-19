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

/**
 * @author Admin
 *
 */
public class DeconnexionPatient extends HttpServlet {

	public static final String CONF_DAO_FACTORY = "daofactory";

	public static final String REMERCIEMENTS = "/enad/enad";

	public static final String ATT_SESSION_PATIENT = "sessionPatient";

	private PatientDao patientDao;

	public void init() throws ServletException {

		/* Récupération d'une instance de notre DAO */

		this.patientDao = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY)).getPatientDao();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/* Récupération et destruction de la session en cours */

		HttpSession session = request.getSession();

		Patient patient = (Patient) (session.getAttribute(ATT_SESSION_PATIENT));

		String aurevoir = "Merci de m'avoir utilisé. Je suis à votre service " + patient.getPrenoms_patient();

		request.setAttribute("aurevoir", aurevoir);

		if (session.getAttribute(ATT_SESSION_PATIENT) != null) {

			String identifiantp = request.getParameter("identifiant");

			patientDao.supprimer_ip(patientDao.trouver(identifiantp));

			session.invalidate();

		}

		/*
		 * Redirection vers la page de remerciements
		 */

		response.sendRedirect(REMERCIEMENTS);

	}

}
