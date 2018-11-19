package enad.forms;

import javax.servlet.http.HttpServletRequest;

import enad.beans.Seance;
import enad.dao.MedecinDao;
import enad.dao.PatientDao;
import enad.dao.SeanceDao;

public final class AttenteTmMedecinDeuxForm {

	private SeanceDao seanceDao;

	private MedecinDao medecinDao;

	private PatientDao patientDao;

	public String clic_pat_tm_deux = "non";

	public Seance seance_tm_deux;

	public String sexe;

	public AttenteTmMedecinDeuxForm(MedecinDao medecinDao, PatientDao patientDao, SeanceDao seanceDao) {

		this.medecinDao = medecinDao;

		this.patientDao = patientDao;

		this.seanceDao = seanceDao;
	}

	// Le médecin a cliqué

	public void ClicMedTmDeux(HttpServletRequest request) {

		String id_seance = request.getParameter("idseance");

		Long id = Long.parseLong(id_seance);

		seanceDao.clic_med_tm_deux(id);

	}

	// Sexe du patient

	public void SexePatient(HttpServletRequest request) {

		String identifiantpatient = request.getParameter("identifiantpatient");

		if (patientDao.trouver(identifiantpatient).getSexe_patient().equals("homme")) {

			sexe = "homme";
		}

		if (patientDao.trouver(identifiantpatient).getSexe_patient().equals("femme")) {

			sexe = "femme";

		}

	}

	// Le patient a cliqué ou pas

	public void ClicPatOuPas(HttpServletRequest request) {

		String id_seance = request.getParameter("idseance");

		Long id = Long.parseLong(id_seance);

		seance_tm_deux = seanceDao.trouver_seance_de_cet_id(id);

		if (seanceDao.clic_patient_ou_pas_tm_deux(id) == 0) {

			// le patient n'a pas cliqué

		} else {

			// le patient a cliqué

			clic_pat_tm_deux = "oui";

		}

	}

}
