package enad.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import enad.dao.DAOFactory;
import enad.dao.ImageTestTdoiBeanDao;
import enad.dao.MedecinDao;
import enad.forms.UploadImagesTdoiForm;

public class UploadImagesTdoi extends HttpServlet {

	public static final String CONF_DAO_FACTORY = "daofactory";

	public static final String CHEMINTDOI = "chemintdoi";

	private MedecinDao medecinDao;

	private ImageTestTdoiBeanDao imagetesttdoibeanDao;

	public void init() throws ServletException {

		this.medecinDao = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY)).getMedecinDao();

		this.imagetesttdoibeanDao = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY))
				.getImageTestTdoiBeanDao();

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/*
		 * Lecture du paramètre 'chemin' passé à la servlet via la déclaration
		 * dans le web.xml
		 */

		String chemin = this.getServletConfig().getInitParameter(CHEMINTDOI);

		/* Préparation de l'objet formulaire */
		UploadImagesTdoiForm form = new UploadImagesTdoiForm(medecinDao, imagetesttdoibeanDao);

		form.creerImageTdoi(request, chemin);

		/* Si aucune erreur */

		if (form.getErreurs().isEmpty()) {

			System.out.println("Pas Erreur au niveau de la servlet UploadImagesTdoi.java");

		} else {

			System.out.println("Erreur au niveau de la servlet UploadImagesTdoi.java");

		}

	}

}
