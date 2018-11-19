package enad.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import enad.dao.DAOFactory;
import enad.dao.ImageMmseLangageBeanDao;
import enad.dao.MedecinDao;
import enad.dao.MmseDao;
import enad.dao.PatientDao;
import enad.forms.DiaporamaPhraseEcrireMmseForm;

public class DiaporamaPhraseEcrireMmse extends HttpServlet {

	private PatientDao patientDao;

	private MedecinDao medecinDao;

	private MmseDao mmseDao;

	private ImageMmseLangageBeanDao imagemmselangagebeanDao;

	public static final String CONF_DAO_FACTORY = "daofactory";

	public static final String DIAPORAMA_Phrase_ecrire_mmse = "/WEB-INF/diaporamaPhraseEcrireMmse.jsp";

	public void init() throws ServletException {

		this.mmseDao = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY)).getMmseDao();

		this.patientDao = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY)).getPatientDao();

		this.medecinDao = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY)).getMedecinDao();

		this.imagemmselangagebeanDao = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY))
				.getImageMmseLangageBeanDao();

	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		DiaporamaPhraseEcrireMmseForm form = new DiaporamaPhraseEcrireMmseForm(patientDao, mmseDao, medecinDao,
				imagemmselangagebeanDao);

		form.ListeDesImagesMmseLangage(request);

		request.setAttribute("imagesdiaporama", form.liste);

		this.getServletContext().getRequestDispatcher(DIAPORAMA_Phrase_ecrire_mmse).forward(request, response);
	}
}
