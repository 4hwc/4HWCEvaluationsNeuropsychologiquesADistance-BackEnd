package enad.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import enad.dao.DAOFactory;
import enad.dao.MedecinDao;
import enad.dao.PropositionSeanceDao;
import enad.dao.SeanceDao;
import enad.forms.ValidationPropositionSeanceMedecinForm;

public class ValidationPropositionSeanceMedecin extends HttpServlet {

	private MedecinDao medecinDao;

	private SeanceDao seanceDao;

	private PropositionSeanceDao propositionseanceDao;

	public static final String CONF_DAO_FACTORY = "daofactory";

	public static final String JOUR = "/enad/liste_seances_validees_jour_Medecin";

	public static final String PREC = "/enad/liste_seances_validees_prec_Medecin";

	public static final String SUIV = "/enad/liste_seances_validees_suiv_Medecin";

	public void init() throws ServletException {

		/* Récupération d'une instance de nos DAO Medecin , Patient, Seance */

		this.medecinDao = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY)).getMedecinDao();

		this.propositionseanceDao = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY))
				.getPropositionSeanceDao();

		this.seanceDao = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY)).getSeanceDao();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ValidationPropositionSeanceMedecinForm form = new ValidationPropositionSeanceMedecinForm(medecinDao,
				propositionseanceDao, seanceDao);

		form.ValidationSeance(request);

		request.setAttribute("seance", form.seance);

		if (form.typeredirection == "jour") {

			response.sendRedirect(JOUR);

		} else {

			if (form.typeredirection == "precedentes") {

				response.sendRedirect(PREC);

			}

			if (form.typeredirection == "suivantes") {

				response.sendRedirect(SUIV);

			}
		}

	}

}
