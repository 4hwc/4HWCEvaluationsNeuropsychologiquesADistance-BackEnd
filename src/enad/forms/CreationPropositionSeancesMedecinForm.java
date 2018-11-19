package enad.forms;

import java.sql.Date;
import java.sql.Time;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import enad.beans.Medecin;
import enad.beans.PropositionSeance;
import enad.beans.Seance;
import enad.dao.DAOException;
import enad.dao.MedecinDao;
import enad.dao.PropositionSeanceDao;
import enad.dao.SeanceDao;

public final class CreationPropositionSeancesMedecinForm {

	private static final String CHAMP_CHOIX_DATE = "choixDate";

	private static final String CHAMP_CHOIX_HEURE_DEBUT = "choixHeureDebut";

	private static final String CHAMP_CHOIX_MIN_DEBUT = "choixMinDebut";

	private static final String CHAMP_CHOIX_HEURE_FIN = "choixHeureFin";

	private static final String CHAMP_CHOIX_MIN_FIN = "choixMinFin";

	private static final String IDSEANCE = "IdSeance";

	public static final String ATT_SESSION_MEDECIN = "sessionMedecin";

	private String resultat;

	private String affichage_date_realisation_propseance;

	private int capteur_date_correcte = 0;

	@SuppressWarnings("deprecation")
	private Time debut = new Time(0, 0, 0);

	@SuppressWarnings("deprecation")
	private Time fin = new Time(0, 0, 0);

	@SuppressWarnings("deprecation")
	private Date dateseance = new Date(0, 0, 0);

	private Map<String, String> erreurs = new HashMap<String, String>();

	private SeanceDao seanceDao;

	private PropositionSeanceDao propositionseanceDao;

	private MedecinDao medecinDao;

	private int jour_seance;

	private int mois_seance;

	private int annee_seance;

	private int heure_debut = -1;

	private int minute_debut = -1;

	private Calendar cal;

	public Long ideseance;

	public CreationPropositionSeancesMedecinForm(SeanceDao seanceDao, PropositionSeanceDao propositionseanceDao,
			MedecinDao medecinDao) {

		this.seanceDao = seanceDao;

		this.propositionseanceDao = propositionseanceDao;

		this.medecinDao = medecinDao;

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

	public PropositionSeance creerPropositionSeance(HttpServletRequest request) {

		String dateSeance = getValeurChamp(request, CHAMP_CHOIX_DATE);

		String heureDebut = getValeurChamp(request, CHAMP_CHOIX_HEURE_DEBUT);

		String minDebut = getValeurChamp(request, CHAMP_CHOIX_MIN_DEBUT);

		String heureFin = getValeurChamp(request, CHAMP_CHOIX_HEURE_FIN);

		String minFin = getValeurChamp(request, CHAMP_CHOIX_MIN_FIN);

		String IdSeance = getValeurChamp(request, IDSEANCE);

		ideseance = validationIdSeance(IdSeance);

		Long id = validationIdSeance(IdSeance);

		Seance seance = new Seance();

		seance = seanceDao.trouver(id);

		PropositionSeance propseance = new PropositionSeance();

		Medecin medecin = new Medecin();

		/* Récupération de la session depuis la requête */

		HttpSession session = request.getSession();

		medecin = (Medecin) session.getAttribute(ATT_SESSION_MEDECIN);

		try {

			traiterDatePropSeance(dateSeance, propseance);

			traiterDebutPropSeance(heureDebut, minDebut, propseance);

			traiterFinPropSeance(heureFin, minFin, propseance);

			propseance.setAffichage_date_realisation_seance_proposition(affichage_date_realisation_propseance);

			if (erreurs.isEmpty()) {

				propositionseanceDao.creerMed(seance, propseance, medecin);

				resultat = "Succès de la création de la proposition";

			} else {
				resultat = "Échec de la création de la proposition";

			}

		} catch (DAOException e) {
			resultat = "Échec de la création de la proposition : une erreur imprévue est survenue,merci de réessayer dans quelques instants.";
			e.printStackTrace();
		}

		return propseance;

	}

	private Long validationIdSeance(String ida) {

		Long id = Long.parseLong(ida);

		return id;

	}

	private void validationDatePropSeance(String datedeseance) throws FormValidationException {

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

					affichage_date_realisation_propseance = "le " + jour_int + " " + mois_naissance + " " + annee_int;

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

					mois_seance = mois_int;

					jour_seance = jour_int;

					annee_seance = annee_int;

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

					affichage_date_realisation_propseance = "le " + jour_int + " " + mois_naissance + " " + annee_int;

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

						mois_seance = mois_int;

						jour_seance = jour_int;

						annee_seance = annee_int;

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

						affichage_date_realisation_propseance = "le " + jour_int + " " + mois_naissance + " "
								+ annee_int;

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

						mois_seance = mois_int;

						jour_seance = jour_int;

						annee_seance = annee_int;

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

						affichage_date_realisation_propseance = "le " + jour_int + " " + mois_naissance + " "
								+ annee_int;

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

	private void traiterDatePropSeance(String dateSeance, PropositionSeance propseance) {

		try {

			validationDatePropSeance(dateSeance);

		} catch (FormValidationException e) {

			setErreur(CHAMP_CHOIX_DATE, e.getMessage());

		}

		propseance.setDate_realisation_seance_proposition(dateseance);

	}

	private void validationDebutPropSeance(String heureDebut, String minDebut) throws FormValidationException {

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

				}

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

	private void traiterDebutPropSeance(String heureDebut, String minDebut, PropositionSeance propseance) {

		try {
			validationDebutPropSeance(heureDebut, minDebut);
		} catch (FormValidationException e) {

			setErreur(CHAMP_CHOIX_HEURE_DEBUT, e.getMessage());

			setErreur(CHAMP_CHOIX_MIN_DEBUT, e.getMessage());
		}

		propseance.setHeure_realisation_seance_proposition(debut);

	}

	private void validationFinPropSeance(String heureFin, String minFin) throws FormValidationException {

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

	private void traiterFinPropSeance(String heureFin, String minFin, PropositionSeance propseance) {

		try {
			validationFinPropSeance(heureFin, minFin);
		} catch (FormValidationException e) {

			setErreur(CHAMP_CHOIX_HEURE_FIN, e.getMessage());

			setErreur(CHAMP_CHOIX_MIN_FIN, e.getMessage());
		}

		propseance.setHeure_fin_seance_proposition(fin);

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
