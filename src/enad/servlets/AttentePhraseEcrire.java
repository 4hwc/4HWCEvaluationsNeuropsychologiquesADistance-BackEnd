package enad.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import enad.dao.DAOFactory;
import enad.dao.MmseDao;
import enad.dao.PatientDao;
import enad.forms.AttentePhraseEcrireForm;

public class AttentePhraseEcrire extends HttpServlet {

	public static final String ATTENTE_PHRASE_ECRIRE = "/WEB-INF/AttentePhraseEcrire.jsp";

	private MmseDao mmseDao;

	private PatientDao patientDao;

	public static final String CONF_DAO_FACTORY = "daofactory";

	public void init() throws ServletException {

		this.mmseDao = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY)).getMmseDao();

		this.patientDao = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY)).getPatientDao();

	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		AttentePhraseEcrireForm form = new AttentePhraseEcrireForm(patientDao, mmseDao);

		form.ClicMedPhraseEcrire(request);

		form.ClicPatOuPas(request);

		form.SexePatient(request);

		request.setAttribute("clic_pat", form.clic_pat_phrase_ecrire);

		request.setAttribute("sexe", form.sexe);

		request.setAttribute("id_aleatoiremmse", form.id_aleatoire_mmse);

		request.setAttribute("identifiantpatient", form.identifiant_patient);

		request.setAttribute("prenomsnomspatient", form.prenoms_noms_patient);

		this.getServletContext().getRequestDispatcher(ATTENTE_PHRASE_ECRIRE).forward(request, response);

	}

}
