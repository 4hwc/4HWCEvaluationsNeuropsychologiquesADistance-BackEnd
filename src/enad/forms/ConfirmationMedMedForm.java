package enad.forms;

import javax.servlet.http.HttpServletRequest;

import enad.dao.MedecinDao;

public final class ConfirmationMedMedForm {

	private MedecinDao medecinDao;

	public String identifiant = new String();

	public ConfirmationMedMedForm(MedecinDao medecinDao) {

		this.medecinDao = medecinDao;
	}

	public void ConfirmationRelMedMed(HttpServletRequest request) {

		String identifiant_emetteur = request.getParameter("ide_em");

		identifiant = identifiant_emetteur;

		String identifiant_destinataire = request.getParameter("ide_dest");

		medecinDao.supprimer_validation_med_med(identifiant_emetteur, identifiant_destinataire);

		medecinDao.creer_relation_med_med(identifiant_emetteur, identifiant_destinataire);

	}

}
