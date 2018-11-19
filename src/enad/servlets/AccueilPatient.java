/**
 * 
 */
package enad.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import enad.beans.Seance;
import enad.dao.DAOFactory;
import enad.dao.MmseDao;
import enad.dao.PatientDao;
import enad.dao.SeanceDao;
import enad.forms.AccueilPatientForm;

/**
 * @author Admin
 *
 */
public class AccueilPatient extends HttpServlet {

	public static final String CONF_DAO_FACTORY = "daofactory";

	public static final String ATT_SESSION_PATIENT = "sessionPatient";

	public static final String ATT_PATIENT = "patient";

	public static final String ATT_SEANCE = "seances";

	private SeanceDao seanceDao;

	private PatientDao patientDao;

	private MmseDao mmseDao;

	public static final String VUE_ACCUEILLIR_PATIENT = "/WEB-INF/accueillirPatient.jsp";

	public void init() throws ServletException {

		this.seanceDao = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY)).getSeanceDao();

		this.patientDao = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY)).getPatientDao();

		this.mmseDao = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY)).getMmseDao();

	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		AccueilPatientForm form = new AccueilPatientForm(seanceDao, patientDao, mmseDao);

		ArrayList<Seance> Seances = form.listeSeancesValideesJour(request);

		form.RubriqueMmseDessinRecopier(request);

		form.RubriqueMmsePhraseEcrire(request);

		form.RubriqueFcro(request);

		form.RubriqueTmUn(request);

		form.RubriqueTmDeux(request);

		request.setAttribute(ATT_SEANCE, Seances);

		request.setAttribute("clic_med_dessin_recopier", form.clic_med_dessin_recopier);

		request.setAttribute("identifiantmed_dessin_recopier", form.identifiantmed_dessin_recopier);

		request.setAttribute("idaleatoire_dessin_recopier", form.idaleatoire_dessin_recopier);

		request.setAttribute("clic_med_phrase_ecrire", form.clic_med_phrase_ecrire);

		request.setAttribute("identifiantmed_phrase_ecrire", form.identifiantmed_phrase_ecrire);

		request.setAttribute("idaleatoire_phrase_ecrire", form.idaleatoire_phrase_ecrire);

		request.setAttribute("clic_med_fcro", form.clic_med_fcro);

		request.setAttribute("seance_fcro", form.seance);

		request.setAttribute("clic_med_tm_un", form.clic_med_tm_un);

		request.setAttribute("seance_tm_un", form.seance_tm_un);

		request.setAttribute("clic_med_tm_deux", form.clic_med_tm_deux);

		request.setAttribute("seance_tm_deux", form.seance_tm_deux);

		HttpSession session = request.getSession();

		int f = (int) session.getAttribute("occurence_accueil") + 1;

		session.setAttribute("occurence_accueil", f);

		/*
		 * A la réception d'une requête GET, simple affichage de la page
		 */

		this.getServletContext().getRequestDispatcher(VUE_ACCUEILLIR_PATIENT).forward(request, response);

	}

}
