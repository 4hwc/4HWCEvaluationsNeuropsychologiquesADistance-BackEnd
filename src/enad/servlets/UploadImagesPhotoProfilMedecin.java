package enad.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import enad.dao.DAOFactory;
import enad.dao.MedecinDao;
import enad.forms.UploadImagesPhotoProfilMedecinForm;

public class UploadImagesPhotoProfilMedecin extends HttpServlet {

	public static final String CONF_DAO_FACTORY = "daofactory";

	public static final String CHEMINPHOTOMEDECIN = "cheminphotomedecin";

	private MedecinDao medecinDao;

	public void init() throws ServletException {

		this.medecinDao = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY)).getMedecinDao();

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/*
		 * Lecture du paramètre 'chemin' passé à la servlet via la déclaration
		 * dans le web.xml
		 */

		String chemin = this.getServletConfig().getInitParameter(CHEMINPHOTOMEDECIN);

		/* Préparation de l'objet formulaire */
		UploadImagesPhotoProfilMedecinForm form = new UploadImagesPhotoProfilMedecinForm(medecinDao);

		form.creerImageMedecin(request, chemin);

		/* Si aucune erreur */

		if (form.getErreurs().isEmpty()) {

		} else {

			System.out.println("Erreur au niveau de la servlet UploadImagesPhotoProfilMedecin.java");

		}

	}

}
