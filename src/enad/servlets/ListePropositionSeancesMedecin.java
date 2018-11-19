package enad.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import enad.beans.PropositionSeance;
import enad.dao.DAOFactory;
import enad.dao.MedecinDao;
import enad.dao.PropositionSeanceDao;
import enad.forms.ListePropositionSeancesMedecinForm;

public class ListePropositionSeancesMedecin extends HttpServlet {

	public static final String LISTE_PROPOSITION_SEANCES_MEDECIN = "/WEB-INF/listePropositionSeancesMedecin.jsp";

	private MedecinDao medecinDao;

	public static final String CONF_DAO_FACTORY = "daofactory";

	public static final String ATT_PROP_SEANCE = "propseances";

	public static final String ATT_IDENTIFIANT_EMISSION = "identifiantemission";

	public static final String ATT_SESSION_MEDECIN = "sessionMedecin";

	private PropositionSeanceDao propositionseanceDao;

	public void init() throws ServletException {

		/* Récupération d'une instance de nos DAO */

		this.medecinDao = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY)).getMedecinDao();

		this.propositionseanceDao = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY))
				.getPropositionSeanceDao();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ListePropositionSeancesMedecinForm form = new ListePropositionSeancesMedecinForm(medecinDao,
				propositionseanceDao);

		ArrayList<PropositionSeance> propSeances = form.listeSeancesProposition(request);

		form.identifiant_emission(request);

		form.ValidationDerniereProp(request);

		form.egalidentifiant(request);

		request.setAttribute(ATT_PROP_SEANCE, propSeances);

		request.setAttribute(ATT_IDENTIFIANT_EMISSION, form.identifiantemission);

		request.setAttribute("egal", form.egal);

		request.setAttribute("idseance", form.idseance);

		request.setAttribute("validation", form.validation);

		/*
		 * A la réception d'une requête GET, simple affichage de la page
		 */

		this.getServletContext().getRequestDispatcher(LISTE_PROPOSITION_SEANCES_MEDECIN).forward(request, response);
	}

}
