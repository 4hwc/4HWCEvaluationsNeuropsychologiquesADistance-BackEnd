package enad.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import enad.dao.DAOFactory;
import enad.dao.ImageTestTdoiBeanDao;
import enad.forms.Presenter_Images_Au_PatientForm;

public class Presenter_Images_Au_Patient extends HttpServlet {

	public static final String CONF_DAO_FACTORY = "daofactory";

	private ImageTestTdoiBeanDao imagetesttdoibeanDao;

	public static final String PRESENTER_IMAGES = "/WEB-INF/tdoi_timer.jsp";

	public void init() throws ServletException {

		this.imagetesttdoibeanDao = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY))
				.getImageTestTdoiBeanDao();

	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Presenter_Images_Au_PatientForm form = new Presenter_Images_Au_PatientForm(imagetesttdoibeanDao);

		form.ListeDesImagesTdoi(request);

		request.setAttribute("imagesdiaporama", form.liste);

		/*
		 * A la réception d'une requête GET, simple affichage de la page
		 */

		this.getServletContext().getRequestDispatcher(PRESENTER_IMAGES).forward(request, response);
	}

}
