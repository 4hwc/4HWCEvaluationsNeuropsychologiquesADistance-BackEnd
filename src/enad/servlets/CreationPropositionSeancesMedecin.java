package enad.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import enad.beans.PropositionSeance;
import enad.dao.DAOFactory;
import enad.dao.MedecinDao;
import enad.dao.PropositionSeanceDao;
import enad.dao.SeanceDao;
import enad.forms.CreationPropositionSeancesMedecinForm;

public class CreationPropositionSeancesMedecin extends HttpServlet {

	public static final String CONF_DAO_FACTORY = "daofactory";

	public static final String ATT_PROP_SEANCE = "propseance";

	public static final String ATT_FORM = "form";

	public static final String SEANCES_PROP = "/enad/liste_proposition_seances_medecin";

	private SeanceDao seanceDao;

	private PropositionSeanceDao propositionseanceDao;

	private MedecinDao medecinDao;

	public void init() throws ServletException {

		this.propositionseanceDao = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY))
				.getPropositionSeanceDao();

		this.medecinDao = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY)).getMedecinDao();

		this.seanceDao = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY)).getSeanceDao();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/* Préparation de l'objet formulaire */

		CreationPropositionSeancesMedecinForm form = new CreationPropositionSeancesMedecinForm(seanceDao,
				propositionseanceDao, medecinDao);

		/*
		 * Appel au traitement et à la validation de la requête, et récupération
		 * du bean en résultant
		 */

		PropositionSeance propseance = form.creerPropositionSeance(request);

		/* Stockage du formulaire et du bean dans l'objet request */

		request.setAttribute(ATT_FORM, form);

		request.setAttribute("idseance", form.ideseance);

		request.setAttribute(ATT_PROP_SEANCE, propseance);

		response.sendRedirect("/enad/liste_proposition_seances_medecin?idSeance=" + form.ideseance);

	}

}
