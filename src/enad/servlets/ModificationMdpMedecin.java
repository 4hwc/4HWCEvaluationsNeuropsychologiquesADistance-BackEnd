package enad.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import enad.beans.Medecin;
import enad.dao.DAOFactory;
import enad.dao.MedecinDao;
import enad.forms.ModificationMdpMedecinForm;

public class ModificationMdpMedecin extends HttpServlet {

	public static final String CONF_DAO_FACTORY = "daofactory";

	public static final String ATT_FORM = "formmdp";

	public static final String ATT_MEDECIN = "medecin";

	private MedecinDao medecinDao;

	public void init() throws ServletException {

		/* Récupération d'une instance de notre DAO Medecin */

		this.medecinDao = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY)).getMedecinDao();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/* Préparation de l'objet formulaire du médecin */

		ModificationMdpMedecinForm formmdp = new ModificationMdpMedecinForm(medecinDao);

		/*
		 * Appel au traitement et à la validation de la requête, et récupération
		 * du bean en résultant
		 */

		Medecin medecin = formmdp.modifiermdpMedecin(request);

		/* Stockage du formulaire et du bean dans l'objet request */

		request.setAttribute(ATT_FORM, formmdp);
		request.setAttribute(ATT_MEDECIN, medecin);

		if (formmdp.getErreurs().isEmpty()) {

			response.sendRedirect(
					"/enad/profil_Medecin?identifiant=" + medecin.getIdentifiant_medecin() + "&erreur_mdp=aucune");

		} else {

			if (formmdp.erreur_difference.isEmpty()) {

				if (formmdp.erreur_quatre.isEmpty()) {

				} else {

					response.sendRedirect("/enad/profil_Medecin?identifiant=" + medecin.getIdentifiant_medecin()
							+ "&erreur_mdp=quatremdp");

				}

			} else {

				response.sendRedirect("/enad/profil_Medecin?identifiant=" + medecin.getIdentifiant_medecin()
						+ "&erreur_mdp=differencemdp");

			}

		}

	}

}
