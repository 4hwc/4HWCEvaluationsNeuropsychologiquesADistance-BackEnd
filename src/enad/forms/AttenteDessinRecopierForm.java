package enad.forms;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import enad.beans.Medecin;
import enad.dao.MmseDao;
import enad.dao.PatientDao;

public final class AttenteDessinRecopierForm {

	private PatientDao patientDao;

	private MmseDao mmseDao;

	public String sexe;

	public Long id_aleatoire_mmse;

	public String identifiant_patient;

	public String prenoms_noms_patient;

	public String clic_pat_dessin_recopier = "non";

	public static final String ATT_SESSION_MEDECIN = "sessionMedecin";

	public AttenteDessinRecopierForm(PatientDao patientDao, MmseDao mmseDao) {

		this.mmseDao = mmseDao;

		this.patientDao = patientDao;

	}

	// Le médecin a cliqué

	public void ClicMedDessinRecopier(HttpServletRequest request) {

		id_aleatoire_mmse = Long.parseLong(request.getParameter("id_aleatoire"));

		mmseDao.clic_med_dessin_recopier(id_aleatoire_mmse);

	}

	// Sexe du patient

	public void SexePatient(HttpServletRequest request) {

		String identifiantpatient = request.getParameter("identifiantpat");

		prenoms_noms_patient = patientDao.trouver(identifiantpatient).getPrenoms_patient() + " "
				+ patientDao.trouver(identifiantpatient).getNoms_patient();

		identifiant_patient = identifiantpatient;

		if (patientDao.trouver(identifiantpatient).getSexe_patient().equals("homme")) {

			sexe = "homme";
		}

		if (patientDao.trouver(identifiantpatient).getSexe_patient().equals("femme")) {

			sexe = "femme";

		}

	}

	// Le patient a cliqué ou pas

	public void ClicPatOuPas(HttpServletRequest request) {

		HttpSession session = request.getSession();

		Medecin medecin = (Medecin) session.getAttribute(ATT_SESSION_MEDECIN);

		if (mmseDao.clic_patient_ou_pas_dessin_recopier(Long.parseLong(request.getParameter("id_aleatoire")),
				medecin.getIdentifiant_medecin()) == 0) {

			// le patient n'a pas cliqué

		} else {

			// le patient a cliqué

			clic_pat_dessin_recopier = "oui";

		}
	}

}
