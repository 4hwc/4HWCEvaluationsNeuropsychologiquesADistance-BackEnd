package enad.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import enad.dao.DAOFactory;
import enad.dao.MedecinDao;
import enad.dao.PatientDao;
import enad.forms.EtreEnRelationMedtPatForm;

public class EtreEnRelationMedtPat extends HttpServlet {

	public static final String CONF_DAO_FACTORY = "daofactory";

	private MedecinDao medecinDao;

	private PatientDao patientDao;

	public static final String PROFIL_MED = "/enad/profil_Medecin?identifiant=";

	public void init() throws ServletException {

		this.medecinDao = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY)).getMedecinDao();

		this.patientDao = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY)).getPatientDao();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		EtreEnRelationMedtPatForm form = new EtreEnRelationMedtPatForm(medecinDao, patientDao);

		form.RelationValMedtPat(request);

		System.out.println(form.profil);

		if (form.profil.equals("medecin")) {

			response.sendRedirect("/enad/profil_Medecin?identifiant=" + form.identifiant);

		}

		if (form.profil.equals("patient")) {

			response.sendRedirect("/enad/profil_Patient?identifiant=" + form.identifiant);

		}

	}

}
