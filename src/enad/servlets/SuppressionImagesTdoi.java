package enad.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import enad.dao.DAOFactory;
import enad.dao.ImageTestTdoiBeanDao;
import enad.forms.SuppressionImagesTdoiForm;

public class SuppressionImagesTdoi extends HttpServlet {

	public static final String CONF_DAO_FACTORY = "daofactory";

	private ImageTestTdoiBeanDao imagetesttdoibeanDao;

	// public static final String PRESENTER_IMAGES =
	// "/WEB-INF/presenter_images_au_patient.jsp";

	public void init() throws ServletException {

		this.imagetesttdoibeanDao = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY))
				.getImageTestTdoiBeanDao();

	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		SuppressionImagesTdoiForm form = new SuppressionImagesTdoiForm(imagetesttdoibeanDao);

		form.SupprimerImagesTdoi(request);

		response.sendRedirect("/enad/imagesTdoiMiniature");

	}

}
