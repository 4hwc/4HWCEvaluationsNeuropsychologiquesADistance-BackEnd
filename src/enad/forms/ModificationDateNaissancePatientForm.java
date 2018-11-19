package enad.forms;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import enad.beans.Patient;
import enad.dao.DAOException;
import enad.dao.PatientDao;

public final class ModificationDateNaissancePatientForm {

	private static final String CHAMP_DATE_NAISSANCE_PATIENT = "datedenaissance";

	public static final String ATT_SESSION_PATIENT = "sessionPatient";

	private String resultat;

	private int capteur_date_correcte = 0;

	private String affichage_date_naissance;

	@SuppressWarnings("deprecation")
	private Date datenaiss = new Date(0, 0, 0);

	private Map<String, String> erreurs = new HashMap<String, String>();

	private PatientDao patientDao;

	public ModificationDateNaissancePatientForm(PatientDao patientDao) {

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

	public Patient modifierdatenaissancePatient(HttpServletRequest request) {

		Patient patient = new Patient();

		HttpSession session = request.getSession();

		patient = (Patient) session.getAttribute(ATT_SESSION_PATIENT);

		String datedenaissance = getValeurChamp(request, CHAMP_DATE_NAISSANCE_PATIENT);

		try {

			traiterDateNaissance(datedenaissance, patient);

			patient.setAffichage_date_naissance(affichage_date_naissance);

			if (erreurs.isEmpty()) {

				patientDao.modifierDateNaissancePatient(patient);

				resultat = "Succès de la modification de la date de naissance ";

			} else {

				resultat = "Échec de la modification de la date de naissance ";

			}

		} catch (DAOException e) {
			resultat = "Échec de la modification de la date de naissance : une erreur imprévue est survenue,merci de réessayer dans quelques instants.";
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
