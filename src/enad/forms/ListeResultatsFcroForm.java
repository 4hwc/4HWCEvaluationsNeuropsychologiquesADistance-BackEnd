package enad.forms;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import enad.beans.Medecin;
import enad.beans.Seance;
import enad.dao.ImageTestFcroBeanDao;
import enad.dao.MedecinDao;
import enad.dao.PatientDao;
import enad.dao.SeanceDao;

public final class ListeResultatsFcroForm {

	private SeanceDao seanceDao;

	private PatientDao patientDao;

	private MedecinDao medecinDao;

	private ImageTestFcroBeanDao imagetestfcrobeanDao;

	public static final String ATT_SESSION_MEDECIN = "sessionMedecin";

	public ListeResultatsFcroForm(PatientDao patientDao, SeanceDao seanceDao, MedecinDao medecinDao,
			ImageTestFcroBeanDao imagetestfcrobeanDao) {

		this.imagetestfcrobeanDao = imagetestfcrobeanDao;

		this.seanceDao = seanceDao;

		this.patientDao = patientDao;

		this.medecinDao = medecinDao;

	}

	public ArrayList<Seance> ListeDesSeancesFcroDuMed(HttpServletRequest request) {

		HttpSession session = request.getSession();

		ArrayList<Seance> SeancesDansDossierImagesFcro = new ArrayList<Seance>();

		ArrayList<Seance> SeancesValideesMed = new ArrayList<Seance>();

		String identifiantMedecin = ((Medecin) session.getAttribute(ATT_SESSION_MEDECIN)).getIdentifiant_medecin();

		SeancesValideesMed = seanceDao.trouver_medecin_validees_recent_auplusvieux(identifiantMedecin);// sans
		// doublons

		if (SeancesValideesMed.isEmpty()) {

			// le med n'a aucun résultat dans le dossier

		} else {

			for (int i = 0; i < SeancesValideesMed.size(); i++) {

				int n = imagetestfcrobeanDao.occurences_idseance(SeancesValideesMed.get(i).getId_seance());

				if (n == 0) {
					// la séance actuelle n'a pas de résultats dans le dossier
					// fcro
				} else {

					// au moins une photo de cette séance dans le dossier image
					// fcro

					SeancesDansDossierImagesFcro.add(SeancesValideesMed.get(i));

				}
			}

		}

		return SeancesDansDossierImagesFcro;

		// Classer du plus récent au plus vieux par rapport à réalisation

	}

}
