package enad.forms;

import javax.servlet.http.HttpServletRequest;

import enad.dao.MedecinDao;
import enad.dao.PatientDao;

public final class ConfirmationMedtPatForm {

	private MedecinDao medecinDao;

	private PatientDao patientDao;

	public String identifiant = new String();

	public String profil = new String();

	public ConfirmationMedtPatForm(MedecinDao medecinDao, PatientDao patientDao) {

		this.medecinDao = medecinDao;

		this.patientDao = patientDao;
	}

	public void ConfirmationRelMedtPat(HttpServletRequest request) {

		profil = request.getParameter("page");

		String identifiant_emetteur = request.getParameter("ide_em");

		identifiant = identifiant_emetteur;

		String identifiant_destinataire = request.getParameter("ide_dest");

		medecinDao.supprimer_validation_medt_pat(identifiant_emetteur, identifiant_destinataire);

		if (profil.equals("medecin")) {

			if (medecinDao.trouver_med_pat(identifiant_emetteur, identifiant_destinataire) == 0) {

				medecinDao.creer_relation_med_pat(identifiant_emetteur, identifiant_destinataire);

			}

			medecinDao.creer_relation_medt_pat(identifiant_emetteur, identifiant_destinataire);

		}

		if (profil.equals("patient")) {

			if (medecinDao.trouver_med_pat(identifiant_destinataire, identifiant_emetteur) == 0) {

				medecinDao.creer_relation_med_pat(identifiant_destinataire, identifiant_emetteur);

			}

			medecinDao.creer_relation_medt_pat(identifiant_destinataire, identifiant_emetteur);

		}

	}

}
