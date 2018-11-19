/**
 * 
 */
package enad.forms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import enad.beans.Patient;
import enad.dao.DAOException;
import enad.dao.PatientDao;

/**
 * @author Admin
 *
 */
public final class RechercheParPrenomsEtNomsPatientForm {

	private static final String CHAMP_PRENOMS_NOMS_PATIENT = "rechercheparprenomsnomsPatients";

	private Map<String, String> erreurs = new HashMap<String, String>();

	private ArrayList<Patient> PatientsBdd = new ArrayList<Patient>();

	private String resultat;

	private String champ_recherche;

	private ArrayList<String> ListeDeMots = new ArrayList<String>();

	private ArrayList<Patient> TousLesResultats = new ArrayList<Patient>();

	private PatientDao patientDao;

	public RechercheParPrenomsEtNomsPatientForm(PatientDao patientDao) {

		this.patientDao = patientDao;
	}

	/**
	 * @return the champ_recherche
	 */
	public String getChamp_recherche() {
		return champ_recherche;
	}

	/**
	 * @param champ_recherche
	 *            the champ_recherche to set
	 */
	public void setChamp_recherche(String champ_recherche) {
		this.champ_recherche = champ_recherche;
	}

	/**
	 * @return the erreurs
	 */
	public Map<String, String> getErreurs() {
		return erreurs;
	}

	public ArrayList<Patient> connecterPrenomsNomsPatient(HttpServletRequest request) {

		String prenomsnomsPatient = getValeurChamp(request, CHAMP_PRENOMS_NOMS_PATIENT);

		Patient patient = new Patient();

		try {
			traiterPrenomsNomsPatient(prenomsnomsPatient, patient);

		} catch (DAOException e) {

			resultat = "Échec de la connexion : une erreur imprévue est survenue,merci de réessayer dans quelques instants.";
			e.printStackTrace();
		}

		return TousLesResultats;

	}

	private void validationPrenomsNomsPatient(String prenomsnomsPatient) throws FormValidationException {

		int occurences_resultats_patients;

		setChamp_recherche(prenomsnomsPatient);

		if (prenomsnomsPatient != null && prenomsnomsPatient.trim().length() != 0) {

			ListeDeMots = MotAMot(prenomsnomsPatient);

			PatientsBdd = patientDao.TousLesPatients();

			for (int i = 0; i < ListeDeMots.size(); i++) {

				for (int pat = 0; pat < PatientsBdd.size(); pat++) {

					// prénoms

					// exact

					if (PatientsBdd.get(pat).getPrenoms_patient().contains(ListeDeMots.get(i))
							|| PatientsBdd.get(pat).getPrenoms_patient().toLowerCase().contains(ListeDeMots.get(i))
							|| PatientsBdd.get(pat).getPrenoms_patient().toUpperCase().contains(ListeDeMots.get(i))) {

						TousLesResultats.add(PatientsBdd.get(pat));

					}

					// maj

					if (PatientsBdd.get(pat).getPrenoms_patient().contains(ListeDeMots.get(i).toUpperCase())
							|| PatientsBdd.get(pat).getPrenoms_patient().toLowerCase()
									.contains(ListeDeMots.get(i).toUpperCase())
							|| PatientsBdd.get(pat).getPrenoms_patient().toUpperCase()
									.contains(ListeDeMots.get(i).toUpperCase())) {

						TousLesResultats.add(PatientsBdd.get(pat));

					}

					// min

					if (PatientsBdd.get(pat).getPrenoms_patient().contains(ListeDeMots.get(i).toLowerCase())
							|| PatientsBdd.get(pat).getPrenoms_patient().toLowerCase()
									.contains(ListeDeMots.get(i).toLowerCase())
							|| PatientsBdd.get(pat).getPrenoms_patient().toUpperCase()
									.contains(ListeDeMots.get(i).toLowerCase())) {

						TousLesResultats.add(PatientsBdd.get(pat));

					}

					// noms

					// exact

					if (PatientsBdd.get(pat).getNoms_patient().contains(ListeDeMots.get(i))
							|| PatientsBdd.get(pat).getNoms_patient().toUpperCase().contains(ListeDeMots.get(i))
							|| PatientsBdd.get(pat).getNoms_patient().toLowerCase().contains(ListeDeMots.get(i))) {

						TousLesResultats.add(PatientsBdd.get(pat));

					}

					// maj

					if (PatientsBdd.get(pat).getNoms_patient().contains(ListeDeMots.get(i).toUpperCase())
							|| PatientsBdd.get(pat).getNoms_patient().toLowerCase()
									.contains(ListeDeMots.get(i).toUpperCase())
							|| PatientsBdd.get(pat).getNoms_patient().toUpperCase()
									.contains(ListeDeMots.get(i).toUpperCase())) {

						TousLesResultats.add(PatientsBdd.get(pat));

					}

					// min

					if (PatientsBdd.get(pat).getNoms_patient().contains(ListeDeMots.get(i).toLowerCase())
							|| PatientsBdd.get(pat).getNoms_patient().toLowerCase()
									.contains(ListeDeMots.get(i).toLowerCase())
							|| PatientsBdd.get(pat).getNoms_patient().toUpperCase()
									.contains(ListeDeMots.get(i).toLowerCase())) {

						TousLesResultats.add(PatientsBdd.get(pat));

					}

				} // patfor

				// exact

				ArrayList<Patient> Res_prenoms = patientDao.trouver_prenoms(ListeDeMots.get(i));

				for (int y = 0; y < Res_prenoms.size(); y++) {

					TousLesResultats.add(Res_prenoms.get(y));

				}

				ArrayList<Patient> Res_noms = patientDao.trouver_noms(ListeDeMots.get(i));

				for (int w = 0; w < Res_noms.size(); w++) {

					TousLesResultats.add(Res_noms.get(w));

				}

				// min

				ArrayList<Patient> Res_prenomsmin = patientDao.trouver_prenoms(ListeDeMots.get(i).toLowerCase());

				for (int y = 0; y < Res_prenomsmin.size(); y++) {

					TousLesResultats.add(Res_prenomsmin.get(y));

				}

				ArrayList<Patient> Res_nomsmin = patientDao.trouver_noms(ListeDeMots.get(i).toLowerCase());

				for (int w = 0; w < Res_nomsmin.size(); w++) {

					TousLesResultats.add(Res_nomsmin.get(w));

				}

				// maj

				ArrayList<Patient> Res_prenomsmaj = patientDao.trouver_prenoms(ListeDeMots.get(i).toUpperCase());

				for (int y = 0; y < Res_prenomsmaj.size(); y++) {

					TousLesResultats.add(Res_prenomsmaj.get(y));

				}

				ArrayList<Patient> Res_nomsmaj = patientDao.trouver_noms(ListeDeMots.get(i).toUpperCase());

				for (int w = 0; w < Res_nomsmaj.size(); w++) {

					TousLesResultats.add(Res_nomsmaj.get(w));

				}

			}

			// Aucun résultat trouvé

			if (TousLesResultats.isEmpty()) {

				throw new FormValidationException(
						"Désolé, ENAD n'a rien trouvé concernant votre recherche. S'il vous plaît, veuillez recommencer. ");

			} else {

				// Enlève doublons pas très précis

				for (int tour1 = 0; tour1 < TousLesResultats.size(); tour1++) {

					occurences_resultats_patients = 0;

					for (int tour2 = 0; tour2 < TousLesResultats.size(); tour2++) {

						if (TousLesResultats.get(tour1).getId_patient() == TousLesResultats.get(tour2)
								.getId_patient()) {

							occurences_resultats_patients++;
							if (occurences_resultats_patients > 1) {

								TousLesResultats.remove(tour2);

								System.out.println(TousLesResultats.size());

								occurences_resultats_patients--;

							} // if (occurences_resultats_patients > 1)

						} // if (TousLesResultats.get(tour1).getId_patient()
							// == TousLesResultats.get(tour2)
							// .getId_patient())

					} // for 2

				} // for 1

				// vérification importante en passant 2 fois ça fonctionne c est
				// précis

				for (int tour1 = 0; tour1 < TousLesResultats.size(); tour1++) {

					occurences_resultats_patients = 0;

					for (int tour2 = 0; tour2 < TousLesResultats.size(); tour2++) {

						if (TousLesResultats.get(tour1).getId_patient() == TousLesResultats.get(tour2)
								.getId_patient()) {

							occurences_resultats_patients++;
							if (occurences_resultats_patients > 1) {

								TousLesResultats.remove(tour2);

								occurences_resultats_patients--;

							} // if (occurences_resultats_patients > 1)

						} // if (TousLesResultats.get(tour1).getId_patient()
							// == TousLesResultats.get(tour2)
							// .getId_patient())

					} // for 2

				} // for 1

			} // else

		} // if 1

	}

	private void traiterPrenomsNomsPatient(String prenomsnomsPatient, Patient patient) {

		try {

			validationPrenomsNomsPatient(prenomsnomsPatient);

		} catch (FormValidationException e) {
			setErreur(CHAMP_PRENOMS_NOMS_PATIENT, e.getMessage());
		}

	}

	/*
	 * Fonction retournant une liste de mots (sans espaces) issus d'un mot
	 * initial contenant des espaces ou non
	 */

	// Eliminer les doublons

	private ArrayList<String> MotAMot(String recherche) {

		ArrayList<String> DecoupeMot = new ArrayList<String>();

		String mot = null;

		String recherche_trim = recherche.trim();

		int occurences;

		for (int i = 0; i < recherche_trim.length(); i++) {

			if (recherche_trim.charAt(i) != ' ') {

				mot = mot + recherche_trim.charAt(i);

				// Je récupère le dernier mot

				if (i == recherche_trim.length() - 1) {

					DecoupeMot.add(mot);

				}

			} else {

				if (recherche_trim.charAt(i - 1) != ' ') {

					DecoupeMot.add(mot);

					// Initialisation pour rechercher d'autres mots

					mot = null;
				} else {
					/*
					 * Rien à faire car les espaces n'ont pas d'intérêt pour
					 * être conservés. Ce sont juste des repères.
					 */
				}

			}

		}

		// ***************eliminer doublons
		for (int a = 0; a < DecoupeMot.size(); a++) {

			occurences = 0;

			for (int b = 0; b < DecoupeMot.size(); b++) {

				if (DecoupeMot.get(a).equals(DecoupeMot.get(b))) {

					occurences++;
					if (occurences > 1) {

						DecoupeMot.remove(b);

					}

				}

			}

		}

		// ***************

		for (int j = 0; j < DecoupeMot.size(); j++) {

			DecoupeMot.set(j, DecoupeMot.get(j).substring(4)); // Enlever
																// null(4)
		}

		return DecoupeMot;
	}

	/*
	 * Ajoute un message correspondant au champ spécifié à la map des erreurs.
	 */

	private void setErreur(String champ, String message) {
		erreurs.put(champ, message);
	}

	/*
	 * Méthode utilitaire qui retourne null si un champ est vide, et son contenu
	 * sinon.
	 */

	private static String getValeurChamp(HttpServletRequest request, String nomChamp) {
		String valeur = request.getParameter(nomChamp);
		if (valeur == null || valeur.trim().length() == 0) {
			return null;
		} else
			return valeur.trim();
	}

}
