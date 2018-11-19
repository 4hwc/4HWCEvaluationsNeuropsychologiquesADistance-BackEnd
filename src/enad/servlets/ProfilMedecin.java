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
import enad.forms.ProfilMedecinForm;

/**
 * @author Admin
 *
 */
public class ProfilMedecin extends HttpServlet {

	public static final String CONF_DAO_FACTORY = "daofactory";

	public static final String PROFIL_MEDECIN = "/WEB-INF/profilMedecinAlertPopUp.jsp";

	private MedecinDao medecinDao;

	private PatientDao patientDao;

	public void init() throws ServletException {

		this.patientDao = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY)).getPatientDao();

		this.medecinDao = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY)).getMedecinDao();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ProfilMedecinForm form = new ProfilMedecinForm(medecinDao, patientDao);

		form.Action(request);

		if (form.erreur_oui_ou_non_noms.equals("non")) {

			request.setAttribute("succes_noms", form.succes_noms);
		}

		if (form.erreur_oui_ou_non_prenoms.equals("non")) {

			request.setAttribute("succes_prenoms", form.succes_prenoms);
		}

		if (form.erreur_oui_ou_non_identifiant.equals("oui")) {

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

		if (form.erreur_oui_ou_non_identifiant.equals("non")) {

			request.setAttribute("succes_identifiant", form.succes_identifiant);

		}

		if (form.erreur_oui_ou_non_mdp.equals("non")) {

			request.setAttribute("succes_mdp", form.succes_mdp);

		}

		if (form.erreur_oui_ou_non_mdp.equals("oui")) {

			if (form.erreur_difference_mdp.isEmpty()) {

				if (form.erreur_quatre_mdp.isEmpty()) {

				} else {

					request.setAttribute("quatremdp", form.erreur_quatre_mdp);

				}

			} else {

				request.setAttribute("differencemdp", form.erreur_difference_mdp);

			}

		}

		request.setAttribute("liaison", form.liaison);

		request.setAttribute("profil", form.profil);

		request.setAttribute("liaisonmedpat", form.liaisonmedpat);

		request.setAttribute("avoirmdt", form.avoirmdt);

		request.setAttribute("liaisonmedtraitantpat", form.liaisonmedtraitantpat);

		request.setAttribute("demandeliaison", form.demandeliaison);

		request.setAttribute("demandeliaisonmedt", form.demandeliaisonmedt);

		request.setAttribute("demandeliaisonmedtsens", form.demandeliaisonmedtsens);

		request.setAttribute("demandeliaisonmedpat", form.demandeliaisonmedpat);

		request.setAttribute("demandeliaisonmedpatsens", form.demandeliaisonmedpatsens);

		request.setAttribute("demandeliaisonsens", form.demandeliaisonsens);

		request.setAttribute("actif", form.sessionactivee);

		request.setAttribute("medecinconsulter", form.medecinconsulter);

		request.setAttribute("medecinprofil", form.medecinprofil);

		request.setAttribute("action", form.action);

		/*
		 * A la réception d'une requête GET, simple affichage de la page
		 */

		this.getServletContext().getRequestDispatcher(PROFIL_MEDECIN).forward(request, response);
	}

}
