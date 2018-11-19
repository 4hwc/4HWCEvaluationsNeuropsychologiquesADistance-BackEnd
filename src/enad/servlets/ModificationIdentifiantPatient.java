package enad.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import enad.beans.Patient;
import enad.dao.DAOFactory;
import enad.dao.MedecinDao;
import enad.dao.PatientDao;
import enad.forms.ModificationIdentifiantPatientForm;

public class ModificationIdentifiantPatient extends HttpServlet {

	public static final String CONF_DAO_FACTORY = "daofactory";

	public static final String ATT_FORM = "formidentifiant";

	public static final String ATT = "formulaire_activee";

	public static final String ATT_PATIENT = "patient";

	private PatientDao patientDao;

	private MedecinDao medecinDao;

	public void init() throws ServletException {

		this.medecinDao = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY)).getMedecinDao();

		this.patientDao = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY)).getPatientDao();

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ModificationIdentifiantPatientForm form = new ModificationIdentifiantPatientForm(patientDao, medecinDao);

		/*
		 * Appel au traitement et à la validation de la requête, et récupération
		 * du bean en résultant
		 */

		Patient patient = form.modifieridentifiantPatient(request);

		/* Stockage du formulaire et du bean dans l'objet request */

		request.setAttribute(ATT_PATIENT, patient);

		request.setAttribute(ATT_FORM, form);

		if (form.getErreurs().isEmpty()) {

			response.sendRedirect("/enad/profil_Patient?identifiant=" + patient.getIdentifiant_patient()
					+ "&erreur_identifiant=aucune");

		} else {

			if (form.erreur_espace.isEmpty()) {

				if (form.erreur_difference.isEmpty()) {

					if (form.erreur_quatre.isEmpty()) {

						if (form.erreur_unique.isEmpty()) {

						} else {

							response.sendRedirect("/enad/profil_Patient?identifiant=" + form.ancienidentifiant
									+ "&erreur_identifiant=unique");

						}

					} else {

						response.sendRedirect("/enad/profil_Patient?identifiant=" + form.ancienidentifiant
								+ "&erreur_identifiant=quatre");

					}

				} else {

					response.sendRedirect("/enad/profil_Patient?identifiant=" + form.ancienidentifiant
							+ "&erreur_identifiant=difference");

				}

			} else {

				response.sendRedirect(
						"/enad/profil_Patient?identifiant=" + form.ancienidentifiant + "&erreur_identifiant=espace");

			}

		}

	}

}
