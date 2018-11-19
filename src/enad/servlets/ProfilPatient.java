/**
 * 
 */
package enad.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import enad.dao.DAOFactory;
import enad.dao.MedecinDao;
import enad.dao.PatientDao;
import enad.forms.ProfilPatientForm;

/**
 * @author Admin
 *
 */
public class ProfilPatient extends HttpServlet {

	public static final String CONF_DAO_FACTORY = "daofactory";

	public static final String PROFIL_PATIENT = "/WEB-INF/profilPatientAlertPopUp.jsp";

	private PatientDao patientDao;

	private MedecinDao medecinDao;

	public void init() throws ServletException {

		this.patientDao = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY)).getPatientDao();

		this.medecinDao = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY)).getMedecinDao();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ProfilPatientForm form = new ProfilPatientForm(patientDao, medecinDao);

		form.Action(request);

		if (form.erreur_oui_ou_non_datenaissance.equals("non")) {

			request.setAttribute("succes_datenaissance", form.succes_datenaissance);
		}

		if (form.erreur_oui_ou_non_prenoms.equals("non")) {

			request.setAttribute("succes_prenoms", form.succes_prenoms);
		}

		if (form.erreur_oui_ou_non_sexe.equals("non")) {

			request.setAttribute("succes_sexe", form.succes_sexe);
		}

		if (form.erreur_oui_ou_non_noms.equals("non")) {

			request.setAttribute("succes_noms", form.succes_noms);
		}

		if (form.erreur_oui_ou_non.equals("non")) {

			request.setAttribute("succes_identifiant", form.succes_identifiant);
		}

		if (form.erreur_oui_ou_non.equals("oui")) {

			if (form.erreur_espace.isEmpty()) {

				if (form.erreur_difference.isEmpty()) {

					if (form.erreur_quatre.isEmpty()) {

						if (form.erreur_unique.isEmpty()) {

						} else {

							request.setAttribute("unique", form.erreur_unique);
						}

					} else {

						request.setAttribute("quatre", form.erreur_quatre);

					}

				} else {

					request.setAttribute("difference", form.erreur_difference);

				}

			} else {

				request.setAttribute("espace", form.erreur_espace);

			}

		}

		request.setAttribute("liaisonmedpat", form.liaisonmedpat);

		request.setAttribute("profil", form.profil);

		request.setAttribute("massepatientexiste", form.massepatientexiste);

		request.setAttribute("taillepatientexiste", form.taillepatientexiste);

		request.setAttribute("avoirmdt", form.avoirmdt);

		request.setAttribute("liaisonmedtraitantpat", form.liaisonmedtraitantpat);

		request.setAttribute("demandeliaisonmedt", form.demandeliaisonmedt);

		request.setAttribute("demandeliaisonmedtsens", form.demandeliaisonmedtsens);

		request.setAttribute("demandeliaisonmedpat", form.demandeliaisonmedpat);

		request.setAttribute("demandeliaisonmedpatsens", form.demandeliaisonmedpatsens);

		request.setAttribute("actif", form.sessionactivee);

		request.setAttribute("patientconsulter", form.patientconsulter);

		request.setAttribute("patientprofil", form.patientprofil);

		request.setAttribute("action", form.action);

		/*
		 * A la réception d'une requête GET, simple affichage de la page
		 */

		this.getServletContext().getRequestDispatcher(PROFIL_PATIENT).forward(request, response);
	}

}
