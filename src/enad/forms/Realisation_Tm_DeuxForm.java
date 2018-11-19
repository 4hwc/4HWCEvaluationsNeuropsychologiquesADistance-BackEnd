package enad.forms;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import enad.dao.MedecinDao;
import enad.dao.PatientDao;
import enad.dao.SeanceDao;

public final class Realisation_Tm_DeuxForm {

	private PatientDao patientDao;

	private MedecinDao medecinDao;

	private SeanceDao seanceDao;

	public String sessionuser;

	public Long ID_seance;

	public Long idmed;

	public Long idpat;

	public String noms_prenoms_medpat;

	public static final String ATT_SESSION_MEDECIN = "sessionMedecin";

	public static final String ATT_SESSION_PATIENT = "sessionPatient";

	public Realisation_Tm_DeuxForm(MedecinDao medecinDao, PatientDao patientDao, SeanceDao seanceDao) {

		this.medecinDao = medecinDao;

		this.patientDao = patientDao;

		this.seanceDao = seanceDao;

	}

	public void Action(HttpServletRequest request) {

		HttpSession session = request.getSession();

		if (session.getAttribute(ATT_SESSION_MEDECIN) != null) {

			sessionuser = "medecin";

		}

		if (session.getAttribute(ATT_SESSION_PATIENT) != null) {

			sessionuser = "patient";

			String id_seance = request.getParameter("idseance");

			Long id = Long.parseLong(id_seance);

			ID_seance = id;

			seanceDao.clic_pat_tm_deux(id);

			// Noms et prénoms du mde et pat pour constituer le nom de la
			// capture
			// ecran

			noms_prenoms_medpat = "m_" + seanceDao.trouver_seance_de_cet_id(id).getPrenoms_noms_medecin() + " " + "p_"
					+ seanceDao.trouver_seance_de_cet_id(id).getPrenoms_noms_patient();

			String identifiantpat = seanceDao.trouver_seance_de_cet_id(id).getIdentifiant_patient();

			String identifiantmed = seanceDao.trouver_seance_de_cet_id(id).getIdentifiant_medecin();

			idmed = medecinDao.trouver(identifiantmed).getId_medecin();

			idpat = patientDao.trouver(identifiantpat).getId_patient();

		}

	}

}
