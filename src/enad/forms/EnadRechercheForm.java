package enad.forms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import enad.beans.Medecin;
import enad.beans.Patient;
import enad.dao.DAOException;
import enad.dao.MedecinDao;
import enad.dao.PatientDao;

public final class EnadRechercheForm {

	private static final String CHAMP_BARRE_RECHERCHE = "barre_recherche";

	private Map<String, String> erreurs = new HashMap<String, String>();

	private ArrayList<Patient> PatientsBdd = new ArrayList<Patient>();

	private ArrayList<Medecin> MedecinsBdd = new ArrayList<Medecin>();

	private String resultat_pat;

	private String resultat_med;

	private String champ_recherche;

	private ArrayList<String> ListeDeMotsPat = new ArrayList<String>();

	private ArrayList<String> ListeDeMotsMed = new ArrayList<String>();

	private ArrayList<Patient> TousLesResultatsPat = new ArrayList<Patient>();

	private ArrayList<Medecin> TousLesResultatsMed = new ArrayList<Medecin>();

	private PatientDao patientDao;

	private MedecinDao medecinDao;

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

	public EnadRechercheForm(PatientDao patientDao, MedecinDao medecinDao) {

		this.patientDao = patientDao;

		this.medecinDao = medecinDao;
	}

	//////////////////// MEDECIN/////////////////////////

	public ArrayList<Medecin> PrenomsNomsMedecin(HttpServletRequest request) {

		String prenomsnomsMedecin = getValeurChamp(request, CHAMP_BARRE_RECHERCHE);

		Medecin medecin = new Medecin();

		try {
			traiterPrenomsNomsMedecin(prenomsnomsMedecin, medecin);

		} catch (DAOException e) {

			resultat_med = "Échec de la connexion : une erreur imprévue est survenue,merci de réessayer dans quelques instants.";
			e.printStackTrace();
		}

		return TousLesResultatsMed;

	}

	private void validationPrenomsNomsMedecin(String prenomsnomsMedecin) throws FormValidationException {

		int occurences_resultats_medecins;

		setChamp_recherche(prenomsnomsMedecin);

		if (prenomsnomsMedecin != null && prenomsnomsMedecin.trim().length() != 0) {

			ListeDeMotsMed = MotAMot(prenomsnomsMedecin);

			MedecinsBdd = medecinDao.TousLesMedecins();

			for (int i = 0; i < ListeDeMotsMed.size(); i++) {

				for (int pat = 0; pat < MedecinsBdd.size(); pat++) {

					// prénoms

					// exact

					if (MedecinsBdd.get(pat).getPrenoms_medecin().contains(ListeDeMotsMed.get(i))
							|| MedecinsBdd.get(pat).getPrenoms_medecin().toLowerCase().contains(ListeDeMotsMed.get(i))
							|| MedecinsBdd.get(pat).getPrenoms_medecin().toUpperCase()
									.contains(ListeDeMotsMed.get(i))) {

						TousLesResultatsMed.add(MedecinsBdd.get(pat));

					}

					// maj

					if (MedecinsBdd.get(pat).getPrenoms_medecin().contains(ListeDeMotsMed.get(i).toUpperCase())
							|| MedecinsBdd.get(pat).getPrenoms_medecin().toLowerCase()
									.contains(ListeDeMotsMed.get(i).toUpperCase())
							|| MedecinsBdd.get(pat).getPrenoms_medecin().toUpperCase()
									.contains(ListeDeMotsMed.get(i).toUpperCase())) {

						TousLesResultatsMed.add(MedecinsBdd.get(pat));

					}

					// min ICI

					if (MedecinsBdd.get(pat).getPrenoms_medecin().contains(ListeDeMotsMed.get(i).toLowerCase())
							|| MedecinsBdd.get(pat).getPrenoms_medecin().toLowerCase()
									.contains(ListeDeMotsMed.get(i).toLowerCase())
							|| MedecinsBdd.get(pat).getPrenoms_medecin().toUpperCase()
									.contains(ListeDeMotsMed.get(i).toLowerCase())) {

						TousLesResultatsMed.add(MedecinsBdd.get(pat));

					}

					// noms

					// exact

					if (MedecinsBdd.get(pat).getNoms_medecin().contains(ListeDeMotsMed.get(i))
							|| MedecinsBdd.get(pat).getNoms_medecin().toUpperCase().contains(ListeDeMotsMed.get(i))
							|| MedecinsBdd.get(pat).getNoms_medecin().toLowerCase().contains(ListeDeMotsMed.get(i))) {

						TousLesResultatsMed.add(MedecinsBdd.get(pat));

					}

					// maj

					if (MedecinsBdd.get(pat).getNoms_medecin().contains(ListeDeMotsMed.get(i).toUpperCase())
							|| MedecinsBdd.get(pat).getNoms_medecin().toLowerCase()
									.contains(ListeDeMotsMed.get(i).toUpperCase())
							|| MedecinsBdd.get(pat).getNoms_medecin().toUpperCase()
									.contains(ListeDeMotsMed.get(i).toUpperCase())) {

						TousLesResultatsMed.add(MedecinsBdd.get(pat));

					}

					// min

					if (MedecinsBdd.get(pat).getNoms_medecin().contains(ListeDeMotsMed.get(i).toLowerCase())
							|| MedecinsBdd.get(pat).getNoms_medecin().toLowerCase()
									.contains(ListeDeMotsMed.get(i).toLowerCase())
							|| MedecinsBdd.get(pat).getNoms_medecin().toUpperCase()
									.contains(ListeDeMotsMed.get(i).toLowerCase())) {

						TousLesResultatsMed.add(MedecinsBdd.get(pat));

					}

				} // patfor

				// exact

				ArrayList<Medecin> Res_prenoms = medecinDao.trouver_prenoms(ListeDeMotsMed.get(i)); // ICI

				for (int y = 0; y < Res_prenoms.size(); y++) {

					TousLesResultatsMed.add(Res_prenoms.get(y));

				}

				ArrayList<Medecin> Res_noms = medecinDao.trouver_noms(ListeDeMotsMed.get(i));

				for (int w = 0; w < Res_noms.size(); w++) {

					TousLesResultatsMed.add(Res_noms.get(w));

				}

				// min

				ArrayList<Medecin> Res_prenomsmin = medecinDao.trouver_prenoms(ListeDeMotsMed.get(i).toLowerCase());

				for (int y = 0; y < Res_prenomsmin.size(); y++) {

					TousLesResultatsMed.add(Res_prenomsmin.get(y));

				}

				ArrayList<Medecin> Res_nomsmin = medecinDao.trouver_noms(ListeDeMotsMed.get(i).toLowerCase());

				for (int w = 0; w < Res_nomsmin.size(); w++) {

					TousLesResultatsMed.add(Res_nomsmin.get(w));

				}

				// maj

				ArrayList<Medecin> Res_prenomsmaj = medecinDao.trouver_prenoms(ListeDeMotsMed.get(i).toUpperCase());

				for (int y = 0; y < Res_prenomsmaj.size(); y++) {

					TousLesResultatsMed.add(Res_prenomsmaj.get(y));

				}

				ArrayList<Medecin> Res_nomsmaj = medecinDao.trouver_noms(ListeDeMotsMed.get(i).toUpperCase());

				for (int w = 0; w < Res_nomsmaj.size(); w++) {

					TousLesResultatsMed.add(Res_nomsmaj.get(w));

				}

			}

			// Aucun résultat trouvé

			if (TousLesResultatsMed.isEmpty()) {

				throw new FormValidationException(
						"Désolé, ENAD n'a rien trouvé concernant votre recherche. S'il vous plaît, veuillez recommencer. ");

			} else {

				// Enlève doublons pas très précis

				for (int tour1 = 0; tour1 < TousLesResultatsMed.size(); tour1++) {

					occurences_resultats_medecins = 0;

					for (int tour2 = 0; tour2 < TousLesResultatsMed.size(); tour2++) {

						if (TousLesResultatsMed.get(tour1).getId_medecin() == TousLesResultatsMed.get(tour2)
								.getId_medecin()) {

							occurences_resultats_medecins++;
							if (occurences_resultats_medecins > 1) {

								TousLesResultatsMed.remove(tour2);

								occurences_resultats_medecins--;

							} // if (occurences_resultats_medecins > 1)

						} // if (TousLesResultats.get(tour1).getId_patient()
							// == TousLesResultats.get(tour2)
							// .getId_patient())

					} // for 2

				} // for 1

				// vérification importante en passant 2 fois ça fonctionne c est
				// précis

				for (int tour1 = 0; tour1 < TousLesResultatsMed.size(); tour1++) {

					occurences_resultats_medecins = 0;

					for (int tour2 = 0; tour2 < TousLesResultatsMed.size(); tour2++) {

						if (TousLesResultatsMed.get(tour1).getId_medecin() == TousLesResultatsMed.get(tour2)
								.getId_medecin()) {

							occurences_resultats_medecins++;
							if (occurences_resultats_medecins > 1) {

								TousLesResultatsMed.remove(tour2);

								occurences_resultats_medecins--;

							} // if (occurences_resultats_patients > 1)

						} // if (TousLesResultats.get(tour1).getId_patient()
							// == TousLesResultats.get(tour2)
							// .getId_patient())

					} // for 2

				} // for 1

			} // else

		} // if 1

	}

	private void traiterPrenomsNomsMedecin(String prenomsnomsMedecin, Medecin medecin) {

		try {

			validationPrenomsNomsMedecin(prenomsnomsMedecin);

		} catch (FormValidationException e) {
			setErreur(CHAMP_BARRE_RECHERCHE, e.getMessage());
		}

	}

	/////// MED fin /////////////////////

	public ArrayList<Patient> PrenomsNomsPatient(HttpServletRequest request) {

		String prenomsnomsPatient = getValeurChamp(request, CHAMP_BARRE_RECHERCHE);

		Patient patient = new Patient();

		try {
			traiterPrenomsNomsPatient(prenomsnomsPatient, patient);

		} catch (DAOException e) {

			resultat_pat = "Échec de la connexion : une erreur imprévue est survenue,merci de réessayer dans quelques instants.";
			e.printStackTrace();
		}

		return TousLesResultatsPat;

	}

	private void validationPrenomsNomsPatient(String prenomsnomsPatient) throws FormValidationException {

		int occurences_resultats_patients;

		setChamp_recherche(prenomsnomsPatient);

		if (prenomsnomsPatient != null && prenomsnomsPatient.trim().length() != 0) {

			ListeDeMotsPat = MotAMot(prenomsnomsPatient);

			PatientsBdd = patientDao.TousLesPatients();

			for (int i = 0; i < ListeDeMotsPat.size(); i++) {

				for (int pat = 0; pat < PatientsBdd.size(); pat++) {

					// prénoms

					// exact

					if (PatientsBdd.get(pat).getPrenoms_patient().contains(ListeDeMotsPat.get(i))
							|| PatientsBdd.get(pat).getPrenoms_patient().toLowerCase().contains(ListeDeMotsPat.get(i))
							|| PatientsBdd.get(pat).getPrenoms_patient().toUpperCase()
									.contains(ListeDeMotsPat.get(i))) {

						TousLesResultatsPat.add(PatientsBdd.get(pat));

					}

					// maj

					if (PatientsBdd.get(pat).getPrenoms_patient().contains(ListeDeMotsPat.get(i).toUpperCase())
							|| PatientsBdd.get(pat).getPrenoms_patient().toLowerCase()
									.contains(ListeDeMotsPat.get(i).toUpperCase())
							|| PatientsBdd.get(pat).getPrenoms_patient().toUpperCase()
									.contains(ListeDeMotsPat.get(i).toUpperCase())) {

						TousLesResultatsPat.add(PatientsBdd.get(pat));

					}

					// min

					if (PatientsBdd.get(pat).getPrenoms_patient().contains(ListeDeMotsPat.get(i).toLowerCase())
							|| PatientsBdd.get(pat).getPrenoms_patient().toLowerCase()
									.contains(ListeDeMotsPat.get(i).toLowerCase())
							|| PatientsBdd.get(pat).getPrenoms_patient().toUpperCase()
									.contains(ListeDeMotsPat.get(i).toLowerCase())) {

						TousLesResultatsPat.add(PatientsBdd.get(pat));

					}

					// noms

					// exact

					if (PatientsBdd.get(pat).getNoms_patient().contains(ListeDeMotsPat.get(i))
							|| PatientsBdd.get(pat).getNoms_patient().toUpperCase().contains(ListeDeMotsPat.get(i))
							|| PatientsBdd.get(pat).getNoms_patient().toLowerCase().contains(ListeDeMotsPat.get(i))) {

						TousLesResultatsPat.add(PatientsBdd.get(pat));

					}

					// maj

					if (PatientsBdd.get(pat).getNoms_patient().contains(ListeDeMotsPat.get(i).toUpperCase())
							|| PatientsBdd.get(pat).getNoms_patient().toLowerCase()
									.contains(ListeDeMotsPat.get(i).toUpperCase())
							|| PatientsBdd.get(pat).getNoms_patient().toUpperCase()
									.contains(ListeDeMotsPat.get(i).toUpperCase())) {

						TousLesResultatsPat.add(PatientsBdd.get(pat));

					}

					// min

					if (PatientsBdd.get(pat).getNoms_patient().contains(ListeDeMotsPat.get(i).toLowerCase())
							|| PatientsBdd.get(pat).getNoms_patient().toLowerCase()
									.contains(ListeDeMotsPat.get(i).toLowerCase())
							|| PatientsBdd.get(pat).getNoms_patient().toUpperCase()
									.contains(ListeDeMotsPat.get(i).toLowerCase())) {

						TousLesResultatsPat.add(PatientsBdd.get(pat));

					}

				} // patfor

				// exact

				ArrayList<Patient> Res_prenoms = patientDao.trouver_prenoms(ListeDeMotsPat.get(i));

				for (int y = 0; y < Res_prenoms.size(); y++) {

					TousLesResultatsPat.add(Res_prenoms.get(y));

				}

				ArrayList<Patient> Res_noms = patientDao.trouver_noms(ListeDeMotsPat.get(i));

				for (int w = 0; w < Res_noms.size(); w++) {

					TousLesResultatsPat.add(Res_noms.get(w));

				}

				// min

				ArrayList<Patient> Res_prenomsmin = patientDao.trouver_prenoms(ListeDeMotsPat.get(i).toLowerCase());

				for (int y = 0; y < Res_prenomsmin.size(); y++) {

					TousLesResultatsPat.add(Res_prenomsmin.get(y));

				}

				ArrayList<Patient> Res_nomsmin = patientDao.trouver_noms(ListeDeMotsPat.get(i).toLowerCase());

				for (int w = 0; w < Res_nomsmin.size(); w++) {

					TousLesResultatsPat.add(Res_nomsmin.get(w));

				}

				// maj

				ArrayList<Patient> Res_prenomsmaj = patientDao.trouver_prenoms(ListeDeMotsPat.get(i).toUpperCase());

				for (int y = 0; y < Res_prenomsmaj.size(); y++) {

					TousLesResultatsPat.add(Res_prenomsmaj.get(y));

				}

				ArrayList<Patient> Res_nomsmaj = patientDao.trouver_noms(ListeDeMotsPat.get(i).toUpperCase());

				for (int w = 0; w < Res_nomsmaj.size(); w++) {

					TousLesResultatsPat.add(Res_nomsmaj.get(w));

				}

			}

			// Aucun résultat trouvé

			if (TousLesResultatsPat.isEmpty()) {

				throw new FormValidationException(
						"Désolé, ENAD n'a rien trouvé concernant votre recherche. S'il vous plaît, veuillez recommencer. ");

			} else {

				// Enlève doublons pas très précis

				for (int tour1 = 0; tour1 < TousLesResultatsPat.size(); tour1++) {

					occurences_resultats_patients = 0;

					for (int tour2 = 0; tour2 < TousLesResultatsPat.size(); tour2++) {

						if (TousLesResultatsPat.get(tour1).getId_patient() == TousLesResultatsPat.get(tour2)
								.getId_patient()) {

							occurences_resultats_patients++;
							if (occurences_resultats_patients > 1) {

								TousLesResultatsPat.remove(tour2);

								occurences_resultats_patients--;

							} // if (occurences_resultats_patients > 1)

						} // if (TousLesResultats.get(tour1).getId_patient()
							// == TousLesResultats.get(tour2)
							// .getId_patient())

					} // for 2

				} // for 1

				// vérification importante en passant 2 fois ça fonctionne c est
				// précis

				for (int tour1 = 0; tour1 < TousLesResultatsPat.size(); tour1++) {

					occurences_resultats_patients = 0;

					for (int tour2 = 0; tour2 < TousLesResultatsPat.size(); tour2++) {

						if (TousLesResultatsPat.get(tour1).getId_patient() == TousLesResultatsPat.get(tour2)
								.getId_patient()) {

							occurences_resultats_patients++;
							if (occurences_resultats_patients > 1) {

								TousLesResultatsPat.remove(tour2);

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
			setErreur(CHAMP_BARRE_RECHERCHE, e.getMessage());
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
