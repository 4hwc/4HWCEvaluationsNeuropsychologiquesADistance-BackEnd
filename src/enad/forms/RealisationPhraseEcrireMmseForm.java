package enad.forms;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import enad.beans.Medecin;
import enad.beans.Patient;
import enad.dao.MedecinDao;
import enad.dao.MmseDao;
import enad.dao.PatientDao;

public final class RealisationPhraseEcrireMmseForm {

	private PatientDao patientDao;

	private MedecinDao medecinDao;

	private MmseDao mmseDao;

	public String sessionuser;

	public Long idmed;

	public Long idpat;

	public String noms_prenoms_medpat;

	public String identifiant_med;

	public String identifiant_pat;

	public Long id_aleatoire_mmse;

	public static final String ATT_SESSION_MEDECIN = "sessionMedecin";

	public static final String ATT_SESSION_PATIENT = "sessionPatient";

	public RealisationPhraseEcrireMmseForm(MedecinDao medecinDao, PatientDao patientDao, MmseDao mmseDao) {

		this.medecinDao = medecinDao;

		this.patientDao = patientDao;

		this.mmseDao = mmseDao;

	}

	public void Action(HttpServletRequest request) {

		HttpSession session = request.getSession();

		if (session.getAttribute(ATT_SESSION_MEDECIN) != null) {

			sessionuser = "medecin";

		}

		if (session.getAttribute(ATT_SESSION_PATIENT) != null) {

			sessionuser = "patient";

			identifiant_pat = request.getParameter("identifiantpatient");

			identifiant_med = request.getParameter("identifiantmedecin");

			id_aleatoire_mmse = Long.parseLong(request.getParameter("id_aleatoire"));

			mmseDao.clic_pat_phrase_ecrire(id_aleatoire_mmse);

			Medecin medecin = medecinDao.trouver(identifiant_med);

			Patient patient = patientDao.trouver(identifiant_pat);

			idmed = medecin.getId_medecin();

			idpat = patient.getId_patient();

			noms_prenoms_medpat = "m_" + medecin.getPrenoms_medecin() + " " + medecin.getNoms_medecin() + " " + "p_"
					+ patient.getPrenoms_patient() + " " + patient.getNoms_patient();

		}

	}

}
