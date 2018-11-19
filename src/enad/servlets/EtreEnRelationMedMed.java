package enad.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import enad.dao.DAOFactory;
import enad.dao.MedecinDao;
import enad.forms.EtreEnRelationMedMedForm;

public class EtreEnRelationMedMed extends HttpServlet {

	public static final String CONF_DAO_FACTORY = "daofactory";

	private MedecinDao medecinDao;

	public void init() throws ServletException {

		/* Récupération d'une instance de notre DAO Medecin */

		this.medecinDao = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY)).getMedecinDao();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		EtreEnRelationMedMedForm form = new EtreEnRelationMedMedForm(medecinDao);

		form.RelationValMedMed(request);

		response.sendRedirect("/enad/profil_Medecin?identifiant=" + form.identifiant);
	}

}
