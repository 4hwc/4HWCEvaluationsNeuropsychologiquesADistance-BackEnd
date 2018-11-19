package enad.forms;

import javax.servlet.http.HttpServletRequest;

import enad.dao.MedecinDao;
import enad.dao.PatientDao;

public final class EtreEnRelationMedPatForm {
	private MedecinDao medecinDao;

	private PatientDao patientDao;

	public String identifiant = new String();

	public String profil = new String();

	public EtreEnRelationMedPatForm(MedecinDao medecinDao, PatientDao patientDao) {

		this.medecinDao = medecinDao;

		this.patientDao = patientDao;
	}

	public void RelationValMedPat(HttpServletRequest request) {

		profil = request.getParameter("page");

		String identifiant_emetteur = request.getParameter("ide_em");

		String identifiant_destinataire = request.getParameter("ide_dest");

		identifiant = identifiant_destinataire;

		medecinDao.creer_val_relation_med_pat(identifiant_emetteur, identifiant_destinataire);

	}

}
