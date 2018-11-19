package enad.forms;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import enad.beans.Medecin;
import enad.beans.Patient;
import enad.beans.Seance;
import enad.dao.DAOException;
import enad.dao.MedecinDao;
import enad.dao.PatientDao;
import enad.dao.SeanceDao;

public final class CreationSeancesMedecinForm {

	private static final String CHAMP_TITRE_SEANCE = "titreSeance";

	private static final String CHAMP_PLAN_SEANCE = "planSeance";

	private static final String CHAMP_CHOIX_PATIENT = "choixPatient";

	private static final String CHAMP_CHOIX_DATE = "choixDate";

	private static final String CHAMP_CHOIX_HEURE_DEBUT = "choixHeureDebut";

	private static final String CHAMP_CHOIX_MIN_DEBUT = "choixMinDebut";

	private static final String CHAMP_CHOIX_HEURE_FIN = "choixHeureFin";

	private static final String CHAMP_CHOIX_MIN_FIN = "choixMinFin";

	public static final String ATT_SESSION_MEDECIN = "sessionMedecin";

	private String resultat;

	private String affichage_date_realisation_seance;

	private int capteur_date_correcte = 0;

	@SuppressWarnings("deprecation")
	private Time debut = new Time(0, 0, 0);

	@SuppressWarnings("deprecation")
	private Time fin = new Time(0, 0, 0);

	@SuppressWarnings("deprecation")
	private Date dateseance = new Date(0, 0, 0);

	private Map<String, String> erreurs = new HashMap<String, String>();

	private SeanceDao seanceDao;

	private int jour_seance;

	private int mois_seance;

	private int annee_seance;

	private int heure_debut = -1;

	private int minute_debut = -1;

	private Calendar cal;

	private MedecinDao medecinDao;

	private PatientDao patientDao;

	public CreationSeancesMedecinForm(SeanceDao seanceDao, MedecinDao medecinDao, PatientDao patientDao) {

		this.seanceDao = seanceDao;

		this.medecinDao = medecinDao;

		this.patientDao = patientDao;

	}

	/**
	 * @return the resultat
	 */
	public String getResultat() {
		return resultat;
	}

	/**
	 * @return the erreurs
	 */
	public Map<String, String> getErreurs() {
		return erreurs;
	}

	public ArrayList<Patient> listePatients(HttpServletRequest request) {

		/*
		 * Le patient peut provenir d'une relation medpat et/ou d'une relation
		 * medtpat.
		 * 
		 * Il y'a risque de doublons
		 */

		int occurences_resultats_patients;

		ArrayList<Patient> Patientsmedpat = new ArrayList<Patient>();

		ArrayList<Patient> Patientsmedtraitantpat = new ArrayList<Patient>();

		ArrayList<Patient> listesansdoublons = new ArrayList<Patient>();

		String identifiant = request.getParameter("identifiant");

		Patientsmedpat = medecinDao.trouver_patients_med(identifiant, patientDao);

		for (int i = 0; i < Patientsmedpat.size(); i++) {

			listesansdoublons.add(Patientsmedpat.get(i));
		}

		Patientsmedtraitantpat = medecinDao.trouver_patients_medtraitant(identifiant, patientDao);

		for (int j = 0; j < Patientsmedtraitantpat.size(); j++) {

			listesansdoublons.add(Patientsmedtraitantpat.get(j));
		}

		// enlève doublons

		for (int tour1 = 0; tour1 < listesansdoublons.size(); tour1++) {

			occurences_resultats_patients = 0;

			for (int tour2 = 0; tour2 < listesansdoublons.size(); tour2++) {

				if (listesansdoublons.get(tour1).getId_patient() == listesansdoublons.get(tour2).getId_patient()) {

					occurences_resultats_patients++;

					if (occurences_resultats_patients > 1) {

						listesansdoublons.remove(tour2);

					}

				}

			}
		}

		return listesansdoublons;

	}

	public Seance creerSeance(HttpServletRequest request) {

		String titreSeance = getValeurChamp(request, CHAMP_TITRE_SEANCE);

		String planSeance = getValeurChamp(request, CHAMP_PLAN_SEANCE);

		String identifiantPatient = getValeurChamp(request, CHAMP_CHOIX_PATIENT);

		String dateSeance = getValeurChamp(request, CHAMP_CHOIX_DATE);

		String heureDebut = getValeurChamp(request, CHAMP_CHOIX_HEURE_DEBUT);

		String minDebut = getValeurChamp(request, CHAMP_CHOIX_MIN_DEBUT);

		String heureFin = getValeurChamp(request, CHAMP_CHOIX_HEURE_FIN);

		String minFin = getValeurChamp(request, CHAMP_CHOIX_MIN_FIN);

		Seance seance = new Seance();

		Medecin medecin = new Medecin();

		/* Récupération de la session depuis la requête */

		HttpSession session = request.getSession();

		medecin = (Medecin) session.getAttribute(ATT_SESSION_MEDECIN);

		try {

			traiterTitreSeance(titreSeance, seance);

			traiterPlanSeance(planSeance, seance);

			traiterChoixPatient(identifiantPatient, seance);

			traiterDateSeance(dateSeance, seance);

			traiterDebutSeance(heureDebut, minDebut, seance);

			traiterFinSeance(heureFin, minFin, seance);

			seance.setAffichage_date_realisation_seance(affichage_date_realisation_seance);

			if (erreurs.isEmpty()) {

				seanceDao.creer(medecin, seance, patientDao);

				resultat = "Succès de la création de la séance";

			} else {
				resultat = "Échec de la création de la séance";

			}

		} catch (DAOException e) {
			resultat = "Échec de la création de la séance : une erreur imprévue est survenue,merci de réessayer dans quelques instants.";
			e.printStackTrace();
		}

		return seance;

	}

	private void validationTitreSeance(String titreSeance) throws FormValidationException {

		if (titreSeance != null) {

			if (titreSeance.trim().length() != 0) {

			}

		} else {
			throw new FormValidationException("Veuillez entrer le titre de la séance.");
		}

	}

	private void traiterTitreSeance(String titreSeance, Seance seance) {

		try {
			validationTitreSeance(titreSeance);
		} catch (FormValidationException e) {

			setErreur(CHAMP_TITRE_SEANCE, e.getMessage());
		}

		seance.setTitre_seance(titreSeance);

	}

	private void validationPlanSeance(String planSeance) throws FormValidationException {

		if (planSeance != null) {

			if (planSeance.trim().length() != 0) {

			}

		} else {
			throw new FormValidationException("Veuillez entrer le plan de la séance.");
		}

	}

	private void traiterPlanSeance(String planSeance, Seance seance) {

		try {
			validationPlanSeance(planSeance);
		} catch (FormValidationException e) {

			setErreur(CHAMP_PLAN_SEANCE, e.getMessage());
		}

		seance.setPlan_seance(planSeance);

	}

	private void validationChoixPatient(String identifiantPatient) throws FormValidationException {

		if (identifiantPatient != null) {

			if (identifiantPatient.trim().length() != 0) {

			}
		} else {
			throw new FormValidationException("Veuillez choisir un patient ou une patiente.");
		}

	}

	private void traiterChoixPatient(String identifiantPatient, Seance seance) {

		try {

			validationChoixPatient(identifiantPatient);

		} catch (FormValidationException e) {

			setErreur(CHAMP_CHOIX_PATIENT, e.getMessage());

		}

		seance.setIdentifiant_patient(identifiantPatient);

	}

	private void validationDateSeance(String datedeseance) throws FormValidationException {

		String jour_string;

		String mois_string;

		String annee_string;

		String mois_naissance = null;

		int jour_int;
		int mois_int;
		int annee_int;

		if (datedeseance != null) {

			if (datedeseance.trim().length() != 0) {

				if (datedeseance.trim().length() == 10) {

					capteur_date_correcte++;

					jour_string = datedeseance.substring(0, 2);

					jour_int = Integer.parseInt(jour_string);

					jour_seance = jour_int;

					System.out.println(jour_string);

					System.out.println(jour_int);

					mois_string = datedeseance.substring(3, 5);

					mois_int = Integer.parseInt(mois_string);

					mois_seance = mois_int;

					System.out.println(mois_string);

					System.out.println(mois_int);

					annee_string = datedeseance.substring(6, 10);

					annee_int = Integer.parseInt(annee_string);

					if (mois_int == 1) {

						mois_naissance = "Janvier";
					}

					if (mois_int == 2) {

						mois_naissance = "Février";
					}

					if (mois_int == 3) {

						mois_naissance = "Mars";
					}

					if (mois_int == 4) {

						mois_naissance = "Avril";
					}

					if (mois_int == 5) {

						mois_naissance = "Mai";
					}

					if (mois_int == 6) {

						mois_naissance = "Juin";
					}

					if (mois_int == 7) {

						mois_naissance = "Juillet";
					}

					if (mois_int == 8) {

						mois_naissance = "Août";
					}

					if (mois_int == 9) {

						mois_naissance = "Septembre";
					}

					if (mois_int == 10) {

						mois_naissance = "Octobre";
					}

					if (mois_int == 11) {

						mois_naissance = "Novembre";
					}

					if (mois_int == 12) {

						mois_naissance = "Décembre";
					}

					affichage_date_realisation_seance = "le " + jour_int + " " + mois_naissance + " " + annee_int;

					annee_seance = annee_int;

					System.out.println(annee_string);

					System.out.println(annee_int);

					// date_string = annee_string + "-" + mois_string + "-" +
					// jour_string;

					dateseance.setDate(jour_int);

					if (mois_int == 12) {

						dateseance.setMonth(11);

					} else {

						dateseance.setMonth(mois_int - 1);

					}

					dateseance.setYear(annee_int - 1900);

					System.out.println(dateseance.getDate());

					System.out.println(dateseance.getMonth());

					System.out.println(dateseance.getYear());

					// DateTimeFormatter formatter =
					// DateTimeFormat.forPattern("yyyy-MM-dd");

					// datenaiss = datenaiss.parse(date_string, formatter);

				}

				if (datedeseance.trim().length() == 8) {

					capteur_date_correcte++;

					jour_string = datedeseance.substring(0, 1);

					jour_int = Integer.valueOf(jour_string).intValue();

					mois_string = datedeseance.substring(2, 3);

					mois_int = Integer.valueOf(mois_string).intValue();

					annee_string = datedeseance.substring(4, 8);

					annee_int = Integer.valueOf(annee_string).intValue();

					if (mois_int == 1) {

						mois_naissance = "Janvier";
					}

					if (mois_int == 2) {

						mois_naissance = "Février";
					}

					if (mois_int == 3) {

						mois_naissance = "Mars";
					}

					if (mois_int == 4) {

						mois_naissance = "Avril";
					}

					if (mois_int == 5) {

						mois_naissance = "Mai";
					}

					if (mois_int == 6) {

						mois_naissance = "Juin";
					}

					if (mois_int == 7) {

						mois_naissance = "Juillet";
					}

					if (mois_int == 8) {

						mois_naissance = "Août";
					}

					if (mois_int == 9) {

						mois_naissance = "Septembre";
					}

					if (mois_int == 10) {

						mois_naissance = "Octobre";
					}

					if (mois_int == 11) {

						mois_naissance = "Novembre";
					}

					if (mois_int == 12) {

						mois_naissance = "Décembre";
					}

					mois_seance = mois_int;

					jour_seance = jour_int;

					annee_seance = annee_int;

					affichage_date_realisation_seance = "le " + jour_int + " " + mois_naissance + " " + annee_int;

					dateseance.setDate(jour_int);

					if (mois_int == 12) {

						dateseance.setMonth(11);

					} else {

						dateseance.setMonth(mois_int - 1);

					}

					dateseance.setYear(annee_int - 1900);
					// DateTimeFormatter formatter =
					// DateTimeFormat.forPattern("yyyy-MM-d");

					// datenaiss = formatter.parseDateTime(date_string);

				}

				if (datedeseance.trim().length() == 9) {

					capteur_date_correcte++;

					if (datedeseance.substring(1, 2).equals("/")) {

						jour_string = datedeseance.substring(0, 1);

						jour_int = Integer.valueOf(jour_string).intValue();

						mois_string = datedeseance.substring(2, 4);

						mois_int = Integer.valueOf(mois_string).intValue();

						annee_string = datedeseance.substring(5, 9);

						annee_int = Integer.valueOf(annee_string).intValue();

						if (mois_int == 1) {

							mois_naissance = "Janvier";
						}

						if (mois_int == 2) {

							mois_naissance = "Février";
						}

						if (mois_int == 3) {

							mois_naissance = "Mars";
						}

						if (mois_int == 4) {

							mois_naissance = "Avril";
						}

						if (mois_int == 5) {

							mois_naissance = "Mai";
						}

						if (mois_int == 6) {

							mois_naissance = "Juin";
						}

						if (mois_int == 7) {

							mois_naissance = "Juillet";
						}

						if (mois_int == 8) {

							mois_naissance = "Août";
						}

						if (mois_int == 9) {

							mois_naissance = "Septembre";
						}

						if (mois_int == 10) {

							mois_naissance = "Octobre";
						}

						if (mois_int == 11) {

							mois_naissance = "Novembre";
						}

						if (mois_int == 12) {

							mois_naissance = "Décembre";
						}

						mois_seance = mois_int;

						jour_seance = jour_int;

						annee_seance = annee_int;

						affichage_date_realisation_seance = "le " + jour_int + " " + mois_naissance + " " + annee_int;

						dateseance.setDate(jour_int);

						if (mois_int == 12) {

							dateseance.setMonth(11);

						} else {

							dateseance.setMonth(mois_int - 1);

						}

						dateseance.setYear(annee_int - 1900);
						// DateTimeFormatter formatter =
						// DateTimeFormat.forPattern("yyyy-MM-d");

						// datenaiss = datenaiss.parse(date_string, formatter);

					} else {

						jour_string = datedeseance.substring(0, 2);

						jour_int = Integer.valueOf(jour_string).intValue();

						mois_string = datedeseance.substring(3, 4);

						mois_int = Integer.valueOf(mois_string).intValue();

						annee_string = datedeseance.substring(5, 9);

						annee_int = Integer.valueOf(annee_string).intValue();

						if (mois_int == 1) {

							mois_naissance = "Janvier";
						}

						if (mois_int == 2) {

							mois_naissance = "Février";
						}

						if (mois_int == 3) {

							mois_naissance = "Mars";
						}

						if (mois_int == 4) {

							mois_naissance = "Avril";
						}

						if (mois_int == 5) {

							mois_naissance = "Mai";
						}

						if (mois_int == 6) {

							mois_naissance = "Juin";
						}

						if (mois_int == 7) {

							mois_naissance = "Juillet";
						}

						if (mois_int == 8) {

							mois_naissance = "Août";
						}

						if (mois_int == 9) {

							mois_naissance = "Septembre";
						}

						if (mois_int == 10) {

							mois_naissance = "Octobre";
						}

						if (mois_int == 11) {

							mois_naissance = "Novembre";
						}

						if (mois_int == 12) {

							mois_naissance = "Décembre";
						}

						mois_seance = mois_int;

						jour_seance = jour_int;

						annee_seance = annee_int;

						affichage_date_realisation_seance = "le " + jour_int + " " + mois_naissance + " " + annee_int;

						dateseance.setDate(jour_int);

						if (mois_int == 12) {

							dateseance.setMonth(11);

						} else {

							dateseance.setMonth(mois_int - 1);

						}

						dateseance.setYear(annee_int - 1900);
						// DateTimeFormatter formatter =
						// DateTimeFormat.forPattern("yyyy-M-dd");

						// datenaiss = datenaiss.parse(date_string, formatter);

					}

				}

				if (capteur_date_correcte == 0) {

					throw new FormValidationException("Date incorrecte");

				} else {
					// bon cas
				}

			}

		}

	}

	private void traiterDateSeance(String dateSeance, Seance seance) {

		try {

			validationDateSeance(dateSeance);

		} catch (FormValidationException e) {

			setErreur(CHAMP_CHOIX_DATE, e.getMessage());

		}

		seance.setDate_realisation_seance(dateseance);

	}

	private void validationDebutSeance(String heureDebut, String minDebut) throws FormValidationException {

		int heureDebut_int = Integer.parseInt(heureDebut);

		int minDebut_int = Integer.parseInt(minDebut);

		if (heureDebut_int <= 23 && heureDebut_int >= 0) {

			// OK

		} else {

			// mauvais cas

			throw new FormValidationException(
					"L'heure de début est comprise entre 0 et 23, merci de la saisir à nouveau.");

		}

		if (minDebut_int <= 59 && minDebut_int >= 0) {

			// OK

		} else {

			// mauvais cas

			throw new FormValidationException(
					"La minute de début est comprise entre 0 et 59, merci de la saisir à nouveau.");

		}

		cal = Calendar.getInstance();

		int moisactuel = cal.get(Calendar.MONTH) + 1;

		if (jour_seance == cal.get(Calendar.DAY_OF_MONTH) && mois_seance == moisactuel
				&& annee_seance == cal.get(Calendar.YEAR)) {

			if (heureDebut_int <= 23 && heureDebut_int >= 0 && minDebut_int <= 59 && minDebut_int >= 0) {

				// Le jour de réalisation est le jour actuel

				if (heureDebut_int == cal.get(Calendar.HOUR_OF_DAY)) {

					if (minDebut_int == cal.get(Calendar.MINUTE)) {

						throw new FormValidationException(
								"Vous avez choisi ce jour pour effectuer la séance. Mais, la minute de début est identique à la minute actuelle. Veuillez choisir une autre. Merci de votre compréhension.");

					}

					if (minDebut_int > cal.get(Calendar.MINUTE)) {

						// OK

						debut.setHours(heureDebut_int);

						heure_debut = heureDebut_int;

						System.out.println(debut.getHours());

						debut.setMinutes(minDebut_int);

						minute_debut = minDebut_int;

						System.out.println(debut.getMinutes());

					}

					if (minDebut_int < cal.get(Calendar.MINUTE)) {

						throw new FormValidationException(
								"Vous avez choisi ce jour pour effectuer la séance. L'heure de début est identique à l'heure actuelle. Mais, la minute de début est dépassée. Veuillez choisir une autre. Merci de votre compréhension.");

					}

				} // heureDebut_int == cal.get(Calendar.HOUR_OF_DAY)

				if (heureDebut_int > cal.get(Calendar.HOUR_OF_DAY)) {

					// OK

					debut.setHours(heureDebut_int);

					heure_debut = heureDebut_int;

					System.out.println(debut.getHours());

					debut.setMinutes(minDebut_int);

					minute_debut = minDebut_int;

					System.out.println(debut.getMinutes());
				}

				if (heureDebut_int < cal.get(Calendar.HOUR_OF_DAY)) {

					throw new FormValidationException(
							"Vous avez choisi ce jour pour effectuer la séance. Mais, l'heure de début est dépassée. Veuillez choisir une autre. Merci de votre compréhension.");

				}

			} else {
				// Ne rien faire

			}

		} else {

			// contraire de (jour_seance == cal.get(Calendar.DAY_OF_MONTH) &&
			// mois_seance == moisactuel
			// && annee_seance == cal.get(Calendar.YEAR))

			if (heureDebut_int <= 23 && heureDebut_int >= 0 && minDebut_int <= 59 && minDebut_int >= 0) {

				// Pas de contrainte car le jour de réalisation est après le
				// jour actuel

				debut.setHours(heureDebut_int);

				heure_debut = heureDebut_int;

				System.out.println(debut.getHours());

				debut.setMinutes(minDebut_int);

				minute_debut = minDebut_int;

				System.out.println(debut.getMinutes());

			} else {

				// Ne rien faire

			}

		}

	}

	private void traiterDebutSeance(String heureDebut, String minDebut, Seance seance) {

		try {
			validationDebutSeance(heureDebut, minDebut);
		} catch (FormValidationException e) {

			setErreur(CHAMP_CHOIX_HEURE_DEBUT, e.getMessage());

			setErreur(CHAMP_CHOIX_MIN_DEBUT, e.getMessage());
		}

		seance.setHeure_realisation_seance(debut);

	}

	private void validationFinSeance(String heureFin, String minFin) throws FormValidationException {

		int heureFin_int = Integer.parseInt(heureFin);

		int minFin_int = Integer.parseInt(minFin);

		if (heureFin_int <= 23 && heureFin_int >= 0) {

			// OK

		} else {

			// mauvais cas

			throw new FormValidationException(
					"L'heure de fin est comprise entre 0 et 23, merci de la saisir à nouveau.");

		}

		if (minFin_int <= 59 && minFin_int >= 0) {

			// OK

		} else {

			// mauvais cas

			throw new FormValidationException(
					"La minute de fin est comprise entre 0 et 59, merci de la saisir à nouveau.");

		}

		if (heureFin_int <= 23 && heureFin_int >= 0 && minFin_int <= 59 && minFin_int >= 0) {

			if (heure_debut != -1 && minute_debut != -1) {

				// OK

				if (heureFin_int == heure_debut) {

					if (minFin_int == minute_debut) {

						throw new FormValidationException(
								"L'heure de fin est identique à l'heure de début, de même pour la minute. Veuillez corriger. Merci de votre compréhension.");

					}

					if (minFin_int > minute_debut) {

						// OK

						fin.setHours(heureFin_int);

						fin.setMinutes(minFin_int);

					}

					if (minFin_int < minute_debut) {

						throw new FormValidationException(
								"L'heure de fin est identique à l'heure de début. Mais, la minute de début est supérieure à la minute de fin. Veuillez corriger. Merci de votre compréhension.");

					}

				}

				if (heureFin_int > heure_debut) {

					// OK

					fin.setHours(heureFin_int);

					fin.setMinutes(minFin_int);

				}

				if (heureFin_int < heure_debut) {

					throw new FormValidationException(
							"L'heure de fin est inférieure à l'heure de début. Veuillez corriger. Merci de votre compréhension.");

				}

			} else {

				// mauvais cas car debut mauvais

			}

		}

	}

	private void traiterFinSeance(String heureFin, String minFin, Seance seance) {

		try {
			validationFinSeance(heureFin, minFin);
		} catch (FormValidationException e) {

			setErreur(CHAMP_CHOIX_HEURE_FIN, e.getMessage());

			setErreur(CHAMP_CHOIX_MIN_FIN, e.getMessage());
		}

		seance.setHeure_fin_seance(fin);

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
