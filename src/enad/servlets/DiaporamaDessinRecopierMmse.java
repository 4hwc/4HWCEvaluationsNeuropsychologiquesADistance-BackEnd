package enad.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import enad.dao.DAOFactory;
import enad.dao.ImageMmsePraxiesConstructivesBeanDao;
import enad.dao.MedecinDao;
import enad.dao.MmseDao;
import enad.dao.PatientDao;
import enad.forms.DiaporamaDessinRecopierMmseForm;

public class DiaporamaDessinRecopierMmse extends HttpServlet {

	private PatientDao patientDao;

	private MedecinDao medecinDao;

	private MmseDao mmseDao;

	private ImageMmsePraxiesConstructivesBeanDao imagemmsepraxiesconstructivesbeanDao;

	public static final String CONF_DAO_FACTORY = "daofactory";

	public static final String DIAPORAMA_Dessin_recopier_mmse = "/WEB-INF/diaporamaDessinRecopierMmse.jsp";

	public void init() throws ServletException {

		this.mmseDao = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY)).getMmseDao();

		this.patientDao = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY)).getPatientDao();

		this.medecinDao = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY)).getMedecinDao();

		this.imagemmsepraxiesconstructivesbeanDao = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY))
				.getImageMmsePraxiesConstructivesBeanDao();

	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		DiaporamaDessinRecopierMmseForm form = new DiaporamaDessinRecopierMmseForm(patientDao, mmseDao, medecinDao,
				imagemmsepraxiesconstructivesbeanDao);

		form.ListeDesImagesMmsePC(request);

		request.setAttribute("imagesdiaporama", form.liste);

		this.getServletContext().getRequestDispatcher(DIAPORAMA_Dessin_recopier_mmse).forward(request, response);

	}
}
