package enad.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import enad.dao.DAOFactory;
import enad.dao.PropositionSeanceDao;
import enad.dao.SeanceDao;
import enad.forms.SuppressionSeanceForm;

public class SuppressionSeance extends HttpServlet {

	private SeanceDao seanceDao;

	private PropositionSeanceDao propositionseanceDao;

	public static final String CONF_DAO_FACTORY = "daofactory";

	public static final String SEANCEV = "/enad/liste_seances_validation_Medecin";

	public static final String SEANCES = "/enad/liste_seances_validees_suiv_Medecin";

	public static final String SEANCEP = "/enad/liste_seances_validees_prec_Medecin";

	public static final String SEANCEJ = "/enad/liste_seances_validees_jour_Medecin";

	public void init() throws ServletException {

		this.seanceDao = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY)).getSeanceDao();

		this.propositionseanceDao = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY))
				.getPropositionSeanceDao();

	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		SuppressionSeanceForm form = new SuppressionSeanceForm(seanceDao, propositionseanceDao);

		form.suppressionSeances(request);

		if (form.destinationapressuppression.equals("liste_seances_validation_Medecin")) {

			response.sendRedirect(SEANCEV);

		}

		if (form.destinationapressuppression.equals("liste_seances_validees_suiv_Medecin")) {

			response.sendRedirect(SEANCES);

		}

		if (form.destinationapressuppression.equals("liste_seances_validees_prec_Medecin")) {

			response.sendRedirect(SEANCEP);

		}

		if (form.destinationapressuppression.equals("liste_seances_validees_jour_Medecin")) {

			response.sendRedirect(SEANCEJ);

		}

	}

}
