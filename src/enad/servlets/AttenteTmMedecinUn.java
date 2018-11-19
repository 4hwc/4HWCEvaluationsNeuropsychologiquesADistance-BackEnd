package enad.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import enad.dao.DAOFactory;
import enad.dao.MedecinDao;
import enad.dao.PatientDao;
import enad.dao.SeanceDao;
import enad.forms.AttenteTmMedecinUnForm;

public class AttenteTmMedecinUn extends HttpServlet {

	public static final String ATTENTE_TM_UN_MEDECIN = "/WEB-INF/AttenteTmMedecinUn.jsp";

	private SeanceDao seanceDao;

	private MedecinDao medecinDao;

	private PatientDao patientDao;

	public static final String CONF_DAO_FACTORY = "daofactory";

	public void init() throws ServletException {

		this.seanceDao = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY)).getSeanceDao();

		this.medecinDao = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY)).getMedecinDao();

		this.patientDao = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY)).getPatientDao();

	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		AttenteTmMedecinUnForm form = new AttenteTmMedecinUnForm(medecinDao, patientDao, seanceDao);

		form.ClicMedTmUn(request);

		form.ClicPatOuPas(request);

		form.SexePatient(request);

		request.setAttribute("clic_pat", form.clic_pat_tm_un);

		request.setAttribute("seance", form.seance_tm_un);

		request.setAttribute("sexe", form.sexe);

		/*
		 * A la réception d'une requête GET, simple affichage de la page
		 */

		this.getServletContext().getRequestDispatcher(ATTENTE_TM_UN_MEDECIN).forward(request, response);

	}

}
