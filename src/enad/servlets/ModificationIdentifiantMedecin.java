package enad.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import enad.beans.Medecin;
import enad.dao.DAOFactory;
import enad.dao.MedecinDao;
import enad.dao.PatientDao;
import enad.forms.ModificationIdentifiantMedecinForm;

public class ModificationIdentifiantMedecin extends HttpServlet {

	public static final String CONF_DAO_FACTORY = "daofactory";

	public static final String ATT_FORM = "formidentifiant";

	public static final String ATT_MEDECIN = "medecin";

	private MedecinDao medecinDao;

	private PatientDao patientDao;

	public void init() throws ServletException {

		this.patientDao = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY)).getPatientDao();

		this.medecinDao = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY)).getMedecinDao();

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/* Préparation de l'objet formulaire du médecin */

		ModificationIdentifiantMedecinForm formidentifiant = new ModificationIdentifiantMedecinForm(medecinDao,
				patientDao);

		/*
		 * Appel au traitement et à la validation de la requête, et récupération
		 * du bean en résultant
		 */

		Medecin medecin = formidentifiant.modifieridentifiantMedecin(request);

		/* Stockage du formulaire et du bean dans l'objet request */

		request.setAttribute(ATT_FORM, formidentifiant);
		request.setAttribute(ATT_MEDECIN, medecin);

		if (formidentifiant.getErreurs().isEmpty()) {

			response.sendRedirect("/enad/profil_Medecin?identifiant=" + medecin.getIdentifiant_medecin()
					+ "&erreur_identifiant=aucune");

		} else {

			if (formidentifiant.erreur_espace.isEmpty()) {

				if (formidentifiant.erreur_difference.isEmpty()) {

					if (formidentifiant.erreur_quatre.isEmpty()) {

						if (formidentifiant.erreur_unique.isEmpty()) {

						} else {

							response.sendRedirect("/enad/profil_Medecin?identifiant="
									+ formidentifiant.ancienidentifiant + "&erreur_identifiant=unique");

						}

					} else {

						response.sendRedirect("/enad/profil_Medecin?identifiant=" + formidentifiant.ancienidentifiant
								+ "&erreur_identifiant=quatre");

					}

				} else {

					response.sendRedirect("/enad/profil_Medecin?identifiant=" + formidentifiant.ancienidentifiant
							+ "&erreur_identifiant=difference");

				}

			} else {

				response.sendRedirect("/enad/profil_Medecin?identifiant=" + formidentifiant.ancienidentifiant
						+ "&erreur_identifiant=espace");

			}

		}

	}

}
