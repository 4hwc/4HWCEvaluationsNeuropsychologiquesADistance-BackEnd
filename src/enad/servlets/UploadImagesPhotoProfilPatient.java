package enad.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import enad.dao.DAOFactory;
import enad.dao.PatientDao;
import enad.forms.UploadImagesPhotoProfilPatientForm;

public class UploadImagesPhotoProfilPatient extends HttpServlet {

	public static final String CONF_DAO_FACTORY = "daofactory";

	public static final String CHEMINPHOTOPATIENT = "cheminphotopatient";

	private PatientDao patientDao;

	public void init() throws ServletException {

		this.patientDao = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY)).getPatientDao();

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/*
		 * Lecture du paramètre 'chemin' passé à la servlet via la déclaration
		 * dans le web.xml
		 */

		String chemin = this.getServletConfig().getInitParameter(CHEMINPHOTOPATIENT);

		/* Préparation de l'objet formulaire */
		UploadImagesPhotoProfilPatientForm form = new UploadImagesPhotoProfilPatientForm(patientDao);

		form.creerImagePatient(request, chemin);

		/* Si aucune erreur */

		if (form.getErreurs().isEmpty()) {

		} else {

			System.out.println("Erreur au niveau de la servlet UploadImagesPhotoProfilPatient.java");

		}

	}

}
