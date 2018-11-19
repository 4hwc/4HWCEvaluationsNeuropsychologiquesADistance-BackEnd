package enad.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import enad.beans.Medecin;
import enad.dao.DAOFactory;
import enad.dao.MedecinDao;
import enad.forms.ModificationPrenomsMedecinForm;

public class ModificationPrenomsMedecin extends HttpServlet {

	public static final String CONF_DAO_FACTORY = "daofactory";

	public static final String ATT_SESSION_MEDECIN = "sessionMedecin";

	public static final String ATT_FORM = "formprenoms";

	public static final String ATT_MEDECIN = "medecin";

	private MedecinDao medecinDao;

	private String identifiant = new String();

	public void init() throws ServletException {

		/* Récupération d'une instance de notre DAO Medecin */

		this.medecinDao = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY)).getMedecinDao();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/* Préparation de l'objet formulaire du médecin */

		ModificationPrenomsMedecinForm formprenoms = new ModificationPrenomsMedecinForm(medecinDao);

		/*
		 * Appel au traitement et à la validation de la requête, et récupération
		 * du bean en résultant
		 */

		Medecin medecin = formprenoms.modifierprenomsMedecin(request);

		/* Stockage du formulaire et du bean dans l'objet request */

		request.setAttribute(ATT_FORM, formprenoms);
		request.setAttribute(ATT_MEDECIN, medecin);

		if (formprenoms.getErreurs().isEmpty()) {

			response.sendRedirect(
					"/enad/profil_Medecin?identifiant=" + medecin.getIdentifiant_medecin() + "&erreur_prenoms=aucune");

		}

	}

}
