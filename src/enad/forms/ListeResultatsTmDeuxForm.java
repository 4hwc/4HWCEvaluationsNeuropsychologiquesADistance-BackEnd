package enad.forms;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import enad.beans.Medecin;
import enad.beans.Seance;
import enad.dao.ImageTestTmBeanDao;
import enad.dao.MedecinDao;
import enad.dao.PatientDao;
import enad.dao.SeanceDao;

public final class ListeResultatsTmDeuxForm {

	private SeanceDao seanceDao;

	private PatientDao patientDao;

	private MedecinDao medecinDao;

	private ImageTestTmBeanDao imagetesttmbeanDao;

	public static final String ATT_SESSION_MEDECIN = "sessionMedecin";

	public ListeResultatsTmDeuxForm(PatientDao patientDao, SeanceDao seanceDao, MedecinDao medecinDao,
			ImageTestTmBeanDao imagetesttmbeanDao) {

		this.imagetesttmbeanDao = imagetesttmbeanDao;

		this.seanceDao = seanceDao;

		this.patientDao = patientDao;

		this.medecinDao = medecinDao;

	}

	public ArrayList<Seance> ListeDesSeancesTmDeuxDuMed(HttpServletRequest request) {

		HttpSession session = request.getSession();

		ArrayList<Seance> SeancesDansDossierImagesTmDeux = new ArrayList<Seance>();

		ArrayList<Seance> SeancesValideesMed = new ArrayList<Seance>();

		String identifiantMedecin = ((Medecin) session.getAttribute(ATT_SESSION_MEDECIN)).getIdentifiant_medecin();

		SeancesValideesMed = seanceDao.trouver_medecin_validees_recent_auplusvieux(identifiantMedecin);// sans
		// doublons

		if (SeancesValideesMed.isEmpty()) {

			// le med n'a aucun résultat dans le dossier

		} else {

			for (int i = 0; i < SeancesValideesMed.size(); i++) {

				int n = imagetesttmbeanDao.occurences_idseance_tm_deux(SeancesValideesMed.get(i).getId_seance());

				if (n == 0) {
					// la séance actuelle n'a pas de résultats dans le dossier
					// fcro
				} else {

					// au moins une photo de cette séance dans le dossier image
					// tm

					SeancesDansDossierImagesTmDeux.add(SeancesValideesMed.get(i));

				}

			}
		}

		return SeancesDansDossierImagesTmDeux;

	}

}
