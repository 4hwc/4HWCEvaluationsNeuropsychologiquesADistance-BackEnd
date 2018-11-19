package enad.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import enad.dao.DAOFactory;
import enad.dao.MmseDao;
import enad.dao.PatientDao;
import enad.forms.AttenteDessinRecopierForm;

public class AttenteDessinRecopier extends HttpServlet {

	public static final String ATTENTE_DESSIN_RECOPIER = "/WEB-INF/AttenteDessinRecopier.jsp";

	private MmseDao mmseDao;

	private PatientDao patientDao;

	public static final String CONF_DAO_FACTORY = "daofactory";

	public void init() throws ServletException {

		this.mmseDao = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY)).getMmseDao();

		this.patientDao = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY)).getPatientDao();

	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		AttenteDessinRecopierForm form = new AttenteDessinRecopierForm(patientDao, mmseDao);

		form.ClicMedDessinRecopier(request);

		form.ClicPatOuPas(request);

		form.SexePatient(request);

		request.setAttribute("clic_pat", form.clic_pat_dessin_recopier);

		request.setAttribute("sexe", form.sexe);

		request.setAttribute("id_aleatoiremmse", form.id_aleatoire_mmse);

		request.setAttribute("prenomsnomspatient", form.prenoms_noms_patient);

		request.setAttribute("identifiantpatient", form.identifiant_patient);

		this.getServletContext().getRequestDispatcher(ATTENTE_DESSIN_RECOPIER).forward(request, response);

	}

}
