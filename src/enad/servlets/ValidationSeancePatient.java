package enad.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import enad.dao.DAOFactory;
import enad.dao.PatientDao;
import enad.dao.SeanceDao;
import enad.forms.ValidationSeancePatientForm;

public class ValidationSeancePatient extends HttpServlet {

	private SeanceDao seanceDao;

	private PatientDao patientDao;

	public static final String CONF_DAO_FACTORY = "daofactory";

	public static final String JOUR = "/enad/liste_seances_validees_jour_Patient";

	public static final String PREC = "/enad/liste_seances_validees_prec_Patient";

	public static final String SUIV = "/enad/liste_seances_validees_suiv_Patient";

	public void init() throws ServletException {

		this.patientDao = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY)).getPatientDao();

		this.seanceDao = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY)).getSeanceDao();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ValidationSeancePatientForm form = new ValidationSeancePatientForm(seanceDao, patientDao);

		form.ValidationSeance(request);

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
