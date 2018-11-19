package enad.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import enad.beans.Patient;
import enad.dao.DAOFactory;
import enad.dao.PatientDao;
import enad.forms.ModificationMassePatientForm;

public class ModificationMassePatient extends HttpServlet {

	public static final String CONF_DAO_FACTORY = "daofactory";

	public static final String ATT_SESSION_PATIENT = "sessionPatient";

	public static final String ATT_FORM = "formmasse";

	public static final String ATT_PATIENT = "patient";

	private PatientDao patientDao;

	public void init() throws ServletException {

		this.patientDao = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY)).getPatientDao();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ModificationMassePatientForm formmasse = new ModificationMassePatientForm(patientDao);

		/*
		 * Appel au traitement et à la validation de la requête, et récupération
		 * du bean en résultant
		 */

		Patient patient = formmasse.modifiermassePatient(request);

		/* Stockage du formulaire et du bean dans l'objet request */

		request.setAttribute(ATT_FORM, formmasse);
		request.setAttribute(ATT_PATIENT, patient);

		response.sendRedirect("/enad/profil_Patient?identifiant=" + patient.getIdentifiant_patient());

	}

}
