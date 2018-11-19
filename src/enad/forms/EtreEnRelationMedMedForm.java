package enad.forms;

import javax.servlet.http.HttpServletRequest;

import enad.dao.MedecinDao;

public final class EtreEnRelationMedMedForm {

	private MedecinDao medecinDao;

	public String identifiant = new String();

	public EtreEnRelationMedMedForm(MedecinDao medecinDao) {

		this.medecinDao = medecinDao;
	}

	public void RelationValMedMed(HttpServletRequest request) {

		String identifiant_emetteur = request.getParameter("ide_em");

		String identifiant_destinataire = request.getParameter("ide_dest");

		identifiant = identifiant_destinataire;

		medecinDao.creer_val_relation_med_med(identifiant_emetteur, identifiant_destinataire);

	}

}
