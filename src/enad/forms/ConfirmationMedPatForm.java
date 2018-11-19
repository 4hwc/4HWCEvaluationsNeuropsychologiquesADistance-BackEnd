package enad.forms;

import javax.servlet.http.HttpServletRequest;

import enad.dao.MedecinDao;
import enad.dao.PatientDao;

public final class ConfirmationMedPatForm {

	private MedecinDao medecinDao;

	private PatientDao patientDao;

	public String identifiant = new String();

	public String profil = new String();

	public ConfirmationMedPatForm(MedecinDao medecinDao, PatientDao patientDao) {

		this.medecinDao = medecinDao;

		this.patientDao = patientDao;
	}

	public void ConfirmationRelMedPat(HttpServletRequest request) {

		String identifiant_emetteur = request.getParameter("ide_em");

		identifiant = identifiant_emetteur;

		profil = request.getParameter("page");

		String identifiant_destinataire = request.getParameter("ide_dest");

		medecinDao.supprimer_validation_med_pat(identifiant_emetteur, identifiant_destinataire);

		if (profil.equals("medecin")) {

			medecinDao.creer_relation_med_pat(identifiant_emetteur, identifiant_destinataire);

		}

		if (profil.equals("patient")) {

			medecinDao.creer_relation_med_pat(identifiant_destinataire, identifiant_emetteur);

		}

	}

}
