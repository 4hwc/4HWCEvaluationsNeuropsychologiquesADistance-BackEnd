/**
 * 
 */
package enad.forms;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import enad.beans.Patient;
import enad.dao.DAOException;
import enad.dao.MedecinDao;
import enad.dao.PatientDao;
import enad.ip.PatientIp;

/**
 * @author Admin
 *
 */
public final class InscriptionPatientForm {

	private static final String CHAMP_PRENOMS_PATIENT = "prenomsPatient";

	private static final String CHAMP_NOMS_PATIENT = "nomsPatient";

	private static final String CHAMP_SEXE_PATIENT = "sexe";

	private static final String CHAMP_DATE_NAISSANCE_PATIENT = "datedenaissance";

	private static final String CHAMP_IDENTIFIANT_PATIENT = "identifiantPatient";

	private static final String CHAMP_CONF_IDENTIFIANT_PATIENT = "confirmeidentifiantPatient";

	private String resultat;

	private int capteur_date_correcte = 0;

	private Map<String, String> erreurs = new HashMap<String, String>();

	private PatientDao patientDao;

	private MedecinDao medecinDao;

	private String affichage_date_naissance;

	@SuppressWarnings("deprecation")
	private Date datenaiss = new Date(0, 0, 0);

	public InscriptionPatientForm(PatientDao patientDao, MedecinDao medecinDao) {

		this.patientDao = patientDao;

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

	public Patient inscrirePatient(HttpServletRequest request) {

		String prenomsPatient = getValeurChamp(request, CHAMP_PRENOMS_PATIENT);

		String nomsPatient = getValeurChamp(request, CHAMP_NOMS_PATIENT);

		String identifiantPatient = getValeurChamp(request, CHAMP_IDENTIFIANT_PATIENT);

		String confidentifiantPatient = getValeurChamp(request, CHAMP_CONF_IDENTIFIANT_PATIENT);

		String sexe = getValeurChamp(request, CHAMP_SEXE_PATIENT);

		String datedenaissance = getValeurChamp(request, CHAMP_DATE_NAISSANCE_PATIENT);

		Patient patient = new Patient();

		try {

			traiterPrenomsPatients(prenomsPatient, patient);
			traiterNomsPatients(nomsPatient, patient);
			traiterIdentifiantsPatients(identifiantPatient, confidentifiantPatient, patient);
			traiterSexesPatients(sexe, patient);

			traiterDateNaissance(datedenaissance, patient);

			patient.setAffichage_date_naissance(affichage_date_naissance);

			if (erreurs.isEmpty()) {

				patientDao.creer(patient);

				PatientIp distribuer_ip = new PatientIp(patientDao);

				patient.setIp_patient(distribuer_ip.genererIpPatient());

				patientDao.creer_ip(patient);

				resultat = "Succès de l'inscription";

			} else {

				resultat = "Échec de l'inscription";

			}

		} catch (DAOException e) {

			resultat = "Échec de l'inscription : une erreur imprévue est survenue,merci de réessayer dans quelques instants.";
			e.printStackTrace();

		}

		return patient;
	}

	@SuppressWarnings("deprecation")
	private void validationDateNaissancePatient(String datedenaissance) throws FormValidationException {

		String jour_string;

		String mois_string;

		String annee_string;

		String mois_naissance = null;

		int jour_int;
		int mois_int;
		int annee_int;

		if (datedenaissance != null) {

			if (datedenaissance.trim().length() != 0) {

				if (datedenaissance.trim().length() == 10) {

					capteur_date_correcte++;

					jour_string = datedenaissance.substring(0, 2);

					jour_int = Integer.parseInt(jour_string);

					System.out.println(jour_string);

					System.out.println(jour_int);

					mois_string = datedenaissance.substring(3, 5);

					mois_int = Integer.parseInt(mois_string);

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
					System.out.println(mois_string);

					System.out.println(mois_int);

					annee_string = datedenaissance.substring(6, 10);

					annee_int = Integer.parseInt(annee_string);

					affichage_date_naissance = "le " + jour_int + " " + mois_naissance + " " + annee_int;

					System.out.println(annee_string);

					System.out.println(annee_int);

					// date_string = annee_string + "-" + mois_string + "-" +
					// jour_string;

					datenaiss.setDate(jour_int);

					if (mois_int == 12) {

						datenaiss.setMonth(11);

					} else {

						datenaiss.setMonth(mois_int - 1);

					}

					datenaiss.setYear(annee_int - 1900);

					System.out.println(datenaiss.getDate());

					System.out.println(datenaiss.getMonth());

					System.out.println(datenaiss.getYear());

					// DateTimeFormatter formatter =
					// DateTimeFormat.forPattern("yyyy-MM-dd");

					// datenaiss = datenaiss.parse(date_string, formatter);

				}

				if (datedenaissance.trim().length() == 8) {

					capteur_date_correcte++;

					jour_string = datedenaissance.substring(0, 1);

					jour_int = Integer.valueOf(jour_string).intValue();

					mois_string = datedenaissance.substring(2, 3);

					mois_int = Integer.valueOf(mois_string).intValue();

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

					annee_string = datedenaissance.substring(4, 8);

					annee_int = Integer.valueOf(annee_string).intValue();

					affichage_date_naissance = "le " + jour_int + " " + mois_naissance + " " + annee_int;

					// date_string = annee_string + "-" + mois_string + "-" +
					// jour_string;

					datenaiss.setDate(jour_int);

					if (mois_int == 12) {

						datenaiss.setMonth(11);

					} else {

						datenaiss.setMonth(mois_int - 1);

					}

					datenaiss.setYear(annee_int - 1900);
					// DateTimeFormatter formatter =
					// DateTimeFormat.forPattern("yyyy-MM-d");

					// datenaiss = formatter.parseDateTime(date_string);

				}

				if (datedenaissance.trim().length() == 9) {

					capteur_date_correcte++;

					if (datedenaissance.substring(1, 2).equals("/")) {

						jour_string = datedenaissance.substring(0, 1);

						jour_int = Integer.valueOf(jour_string).intValue();

						mois_string = datedenaissance.substring(2, 4);

						mois_int = Integer.valueOf(mois_string).intValue();

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

						annee_string = datedenaissance.substring(5, 9);

						annee_int = Integer.valueOf(annee_string).intValue();

						affichage_date_naissance = "le " + jour_int + " " + mois_naissance + " " + annee_int;

						// date_string = annee_string + "-" + mois_string + "-"
						// + jour_string;

						datenaiss.setDate(jour_int);

						if (mois_int == 12) {

							datenaiss.setMonth(11);

						} else {

							datenaiss.setMonth(mois_int - 1);

						}

						datenaiss.setYear(annee_int - 1900);
						// DateTimeFormatter formatter =
						// DateTimeFormat.forPattern("yyyy-MM-d");

						// datenaiss = datenaiss.parse(date_string, formatter);

					} else {

						jour_string = datedenaissance.substring(0, 2);

						jour_int = Integer.valueOf(jour_string).intValue();

						mois_string = datedenaissance.substring(3, 4);

						mois_int = Integer.valueOf(mois_string).intValue();

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

						annee_string = datedenaissance.substring(5, 9);

						annee_int = Integer.valueOf(annee_string).intValue();

						affichage_date_naissance = "le " + jour_int + " " + mois_naissance + " " + annee_int;

						// date_string = annee_string + "-" + mois_string + "-"
						// + jour_string;

						datenaiss.setDate(jour_int);

						if (mois_int == 12) {

							datenaiss.setMonth(11);

						} else {

							datenaiss.setMonth(mois_int - 1);

						}

						datenaiss.setYear(annee_int - 1900);
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

	private void traiterDateNaissance(String datedenaissance, Patient patient) {

		try {

			validationDateNaissancePatient(datedenaissance);

		} catch (FormValidationException e) {

			setErreur(CHAMP_DATE_NAISSANCE_PATIENT, e.getMessage());

		}

		patient.setDate_naissance_patient(datenaiss);

	}

	private void validationPrenomsPatients(String prenomsPatient) throws FormValidationException {

		if (prenomsPatient != null) {

			if (prenomsPatient.trim().length() != 0) {

			}
		} else {
			// Ne rien faire car le champ prénoms n'est pas obligatoire
		}

	}

	private void traiterPrenomsPatients(String prenomsPatient, Patient patient) {

		try {
			validationPrenomsPatients(prenomsPatient);
		} catch (FormValidationException e) {

			setErreur(CHAMP_PRENOMS_PATIENT, e.getMessage());

		}

		patient.setPrenoms_patient(prenomsPatient);

	}

	private void validationNomsPatients(String nomsPatient) throws FormValidationException {

		if (nomsPatient != null) {

			if (nomsPatient.trim().length() != 0) {

			}
		} else {
			throw new FormValidationException("Veuillez entrer un ou des noms.");
		}

	}

	private void traiterNomsPatients(String nomsPatient, Patient patient) {

		try {
			validationNomsPatients(nomsPatient);
		} catch (FormValidationException e) {

			setErreur(CHAMP_NOMS_PATIENT, e.getMessage());
		}

		patient.setNoms_patient(nomsPatient);

	}

	private void validationIdentifiantsPatients(String identifiantPatient, String confidentifiantPatient)
			throws FormValidationException {

		if (identifiantPatient != null && identifiantPatient.trim().length() != 0 && confidentifiantPatient != null
				&& confidentifiantPatient.trim().length() != 0) {

			int nombre = MotAMot(identifiantPatient).size();

			if (nombre > 1) {

				throw new FormValidationException("L'identifiant ne doit pas contenir d'espaces.");

			} else {

				if (!identifiantPatient.equals(confidentifiantPatient)) {

					throw new FormValidationException(
							"Les identifiants entrés sont différents,merci de les saisir à nouveau.");
				} else {

					if (identifiantPatient.trim().length() < 4) {
						throw new FormValidationException("Les identifiants doivent contenir au moins 4 caractères.");
					} else {

						if (patientDao.trouver(identifiantPatient) != null
								|| medecinDao.trouver(identifiantPatient) != null) {

							throw new FormValidationException(
									"Cet identifiant est déjà utilisé, merci d'en choisir un autre.");
						}
					}

				}

			}

		} else {
			throw new FormValidationException("Merci de saisir et confirmer votre identifiant.");
		}

	}

	private void traiterIdentifiantsPatients(String identifiantPatient, String confidentifiantPatient,
			Patient patient) {

		try {
			validationIdentifiantsPatients(identifiantPatient, confidentifiantPatient);
		} catch (FormValidationException e) {
			setErreur(CHAMP_IDENTIFIANT_PATIENT, e.getMessage());
			setErreur(CHAMP_CONF_IDENTIFIANT_PATIENT, null);
		}

		patient.setIdentifiant_patient(identifiantPatient);

	}

	private void validationSexesPatients(String sexe) throws FormValidationException {

		if (sexe != null) {

			if (sexe.trim().length() != 0) {

			}
		} else {
			throw new FormValidationException("S'il vous plaît, veuillez choisir votre sexe.");
		}

	}

	private void traiterSexesPatients(String sexe, Patient patient) {

		try {

			validationSexesPatients(sexe);

		} catch (FormValidationException e) {

			setErreur(CHAMP_SEXE_PATIENT, e.getMessage());

		}

		patient.setSexe_patient(sexe);

	}

	private ArrayList<String> MotAMot(String recherche) {

		ArrayList<String> DecoupeMot = new ArrayList<String>();

		String mot = null;

		String recherche_trim = recherche.trim();

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
