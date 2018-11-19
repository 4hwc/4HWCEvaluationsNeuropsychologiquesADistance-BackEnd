package enad.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import enad.dao.DAOFactory;
import enad.dao.MedecinDao;
import enad.dao.MmseDao;
import enad.dao.PatientDao;
import enad.forms.RealisationDessinRecopierMmseForm;

public class RealisationDessinRecopierMmse extends HttpServlet {

	private PatientDao patientDao;

	private MedecinDao medecinDao;

	private MmseDao mmseDao;

	public static final String CONF_DAO_FACTORY = "daofactory";

	public static final String REALISATION_DESSIN_RECOPIER = "/WEB-INF/RealisationDessinRecopierMmse.jsp";

	public void init() throws ServletException {

		this.mmseDao = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY)).getMmseDao();

		this.medecinDao = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY)).getMedecinDao();

		this.patientDao = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY)).getPatientDao();

	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RealisationDessinRecopierMmseForm form = new RealisationDessinRecopierMmseForm(medecinDao, patientDao, mmseDao);

		form.Action(request);

		request.setAttribute("sessionuser", form.sessionuser);

		request.setAttribute("idmed", form.idmed);

		request.setAttribute("idpat", form.idpat);

		request.setAttribute("identifiant_med", form.identifiant_med);

		request.setAttribute("identifiant_pat", form.identifiant_pat);

		request.setAttribute("id_aleatoire_mmse", form.id_aleatoire_mmse);

		request.setAttribute("noms_prenoms_medpat", form.noms_prenoms_medpat);

		this.getServletContext().getRequestDispatcher(REALISATION_DESSIN_RECOPIER).forward(request, response);

	}

}
