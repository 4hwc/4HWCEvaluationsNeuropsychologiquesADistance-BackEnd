package enad.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import enad.beans.Medecin;
import enad.beans.PropositionSeance;
import enad.dao.DAOFactory;
import enad.dao.MedecinDao;
import enad.dao.PropositionSeanceDao;
import enad.forms.TransitionCreationProp_ListePropForm;

public class TransitionCreationProp_ListeProp extends HttpServlet {

	public static final String CONF_DAO_FACTORY = "daofactory";

	public static final String ATT_PROP_SEANCE = "propseance";

	public static final String ATT_SESSION_MEDECIN = "sessionMedecin";

	public static final String SEANCES_PROP = "/enad/liste_proposition_seances_medecin";

	private PropositionSeanceDao propositionseanceDao;

	private MedecinDao medecinDao;

	public void init() throws ServletException {

		this.propositionseanceDao = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY))
				.getPropositionSeanceDao();

		this.medecinDao = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY)).getMedecinDao();

	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		TransitionCreationProp_ListePropForm form = new TransitionCreationProp_ListePropForm(medecinDao,
				propositionseanceDao);

		HttpSession session = request.getSession();

		session.setAttribute(ATT_SESSION_MEDECIN, (Medecin) session.getAttribute(ATT_SESSION_MEDECIN));

		request.setAttribute("proposition", (PropositionSeance) request.getAttribute(ATT_PROP_SEANCE));

		response.sendRedirect(SEANCES_PROP);

	}

}
