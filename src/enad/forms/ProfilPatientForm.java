package enad.forms;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import enad.beans.Medecin;
import enad.beans.Patient;
import enad.dao.MedecinDao;
import enad.dao.PatientDao;

public final class ProfilPatientForm {

	private PatientDao patientDao;

	private MedecinDao medecinDao;

	public String sessionactivee = new String();

	public static final String ATT_SESSION_MEDECIN = "sessionMedecin";

	public static final String ATT_SESSION_PATIENT = "sessionPatient";

	public String liaisonmedtraitantpat = new String();

	public String liaisonmedpat = new String();

	public String demandeliaisonmedt = new String();

	public String demandeliaisonmedtsens = new String();

	public String demandeliaisonmedpat = new String();

	public String demandeliaisonmedpatsens = new String();

	public String action = new String();

	public String massepatientexiste = new String();

	public String taillepatientexiste = new String();

	public Patient patientprofil = new Patient();

	public Patient patientconsulter = new Patient();

	public String avoirmdt = new String();

	public String profil = new String();

	public String erreur_oui_ou_non = new String();

	public String erreur_oui_ou_non_noms = new String();

	public String erreur_oui_ou_non_prenoms = new String();

	public String erreur_oui_ou_non_sexe = new String();

	public String erreur_oui_ou_non_datenaissance = new String();

	public String erreur_espace = new String();

	public String erreur_difference = new String();

	public String erreur_quatre = new String();

	public String erreur_unique = new String();

	public String succes_identifiant = new String();

	public String succes_noms = new String();

	public String succes_prenoms = new String();

	public String succes_sexe = new String();

	public String succes_datenaissance = new String();

	public ProfilPatientForm(PatientDao patientDao, MedecinDao medecinDao) {

		this.patientDao = patientDao;

		this.medecinDao = medecinDao;
	}

	public void Action(HttpServletRequest request) {

		/* Récupération de la session depuis la requête */

		profil = "patient";

		HttpSession session = request.getSession();

		if (session.getAttribute(ATT_SESSION_MEDECIN) != null) {

			sessionactivee = "medecin";

			String identifiantpatprofil = request.getParameter("identifiant");

			patientprofil = patientDao.trouver(identifiantpatprofil);

			String identifiantMedecin = ((Medecin) session.getAttribute(ATT_SESSION_MEDECIN)).getIdentifiant_medecin();

			if (patientDao.trouver_med_pat(identifiantMedecin, identifiantpatprofil) != 0) {

				liaisonmedpat = "oui";

				if (patientDao.trouver_validations_med_pat(identifiantpatprofil, identifiantMedecin) != 0) {

					medecinDao.supprimer_validation_med_pat(identifiantpatprofil, identifiantMedecin);

				}
				if (patientDao.trouver_validations_med_pat(identifiantMedecin, identifiantpatprofil) != 0) {

					medecinDao.supprimer_validation_med_pat(identifiantMedecin, identifiantpatprofil);

				}

				if (patientDao.trouver_medt_pat(identifiantMedecin, identifiantpatprofil) != 0) {

					liaisonmedtraitantpat = "oui";

				} else {

					liaisonmedtraitantpat = "non";

					if (patientDao.trouver_pat(identifiantpatprofil) != 0) {

						avoirmdt = "oui";
					} else {

						avoirmdt = "non";

						if (patientDao.trouver_validations_medt_pat(identifiantpatprofil, identifiantMedecin) != 0
								|| patientDao.trouver_validations_medt_pat(identifiantMedecin,
										identifiantpatprofil) != 0) {

							demandeliaisonmedt = "oui";

							if (patientDao.trouver_validations_medt_pat(identifiantpatprofil,
									identifiantMedecin) != 0) {

								demandeliaisonmedtsens = "gauchedroite";

							}

							if (patientDao.trouver_validations_medt_pat(identifiantMedecin,
									identifiantpatprofil) != 0) {

								demandeliaisonmedtsens = "droitegauche";

							}

						} else {
							demandeliaisonmedt = "non";
						}
					}

				}

			} else {

				liaisonmedpat = "non";

				if (patientDao.trouver_validations_med_pat(identifiantpatprofil, identifiantMedecin) != 0
						|| patientDao.trouver_validations_med_pat(identifiantMedecin, identifiantpatprofil) != 0) {

					demandeliaisonmedpat = "oui";

					if (patientDao.trouver_validations_med_pat(identifiantpatprofil, identifiantMedecin) != 0) {

						demandeliaisonmedpatsens = "gauchedroite";

					}

					if (patientDao.trouver_validations_med_pat(identifiantMedecin, identifiantpatprofil) != 0) {

						demandeliaisonmedpatsens = "droitegauche";

					}

				} else {
					demandeliaisonmedpat = "non";
				}

				if (patientDao.trouver_pat(identifiantpatprofil) != 0) {

					avoirmdt = "oui";
				} else {
					avoirmdt = "non";

					if (patientDao.trouver_validations_medt_pat(identifiantpatprofil, identifiantMedecin) != 0
							|| patientDao.trouver_validations_medt_pat(identifiantMedecin, identifiantpatprofil) != 0) {

						demandeliaisonmedt = "oui";

						if (patientDao.trouver_validations_medt_pat(identifiantpatprofil, identifiantMedecin) != 0) {

							demandeliaisonmedtsens = "gauchedroite";

						}

						if (patientDao.trouver_validations_medt_pat(identifiantMedecin, identifiantpatprofil) != 0) {

							demandeliaisonmedtsens = "droitegauche";

						}

					} else {
						demandeliaisonmedt = "non";
					}

				}

			}

		}

		if (session.getAttribute(ATT_SESSION_PATIENT) != null) {

			sessionactivee = "patient";

			String identifiant = request.getParameter("identifiant");

			String identifiantPatient = ((Patient) session.getAttribute(ATT_SESSION_PATIENT)).getIdentifiant_patient();

			Patient patientsession = (Patient) session.getAttribute(ATT_SESSION_PATIENT);

			double massepatient = patientsession.getMasse_patient();

			double taillepatient = patientsession.getTaille_patient();

			if (identifiant.equals(identifiantPatient)) {

				action = "consulteretmodifier";

				// Gestion des erreurs datenaissance

				String erreur_modif_profil_datenaissance = request.getParameter("erreur_datenaissance");

				if (erreur_modif_profil_datenaissance == null) {

				} else {

					if (erreur_modif_profil_datenaissance.equals("aucune")) {

						// Si pas d'erreur

						erreur_oui_ou_non_datenaissance = "non";

						succes_datenaissance = "Succès de la modification de la date de naissance";

					} else {

					}

				}
				// Gestion des erreurs sexe

				String erreur_modif_profil_sexe = request.getParameter("erreur_sexe");

				if (erreur_modif_profil_sexe == null) {

				} else {

					if (erreur_modif_profil_sexe.equals("aucune")) {

						// Si pas d'erreur

						erreur_oui_ou_non_sexe = "non";

						succes_sexe = "Succès de la modification du sexe";

					} else {

					}

				}

				// Gestion des erreurs prénoms

				String erreur_modif_profil_prenoms = request.getParameter("erreur_prenoms");

				if (erreur_modif_profil_prenoms == null) {

				} else {

					if (erreur_modif_profil_prenoms.equals("aucune")) {

						// Si pas d'erreur

						erreur_oui_ou_non_prenoms = "non";

						succes_prenoms = "Succès de la modification des prénoms";

					} else {

					}

				}

				// Gestion des erreurs noms

				String erreur_modif_profil_noms = request.getParameter("erreur_noms");

				if (erreur_modif_profil_noms == null) {

				} else {

					if (erreur_modif_profil_noms.equals("aucune")) {

						// Si pas d'erreur

						erreur_oui_ou_non_noms = "non";

						succes_noms = "Succès de la modification des noms";

					}

				}

				// Gestion des erreurs identifiant

				String erreur_modif_profil = request.getParameter("erreur_identifiant");

				if (erreur_modif_profil == null) {

				} else {

					if (erreur_modif_profil.equals("aucune")) {

						// Si pas d'erreur

						erreur_oui_ou_non = "non";

						succes_identifiant = "Succès de la modification de l'identifiant";

					} else {

						// Si il existe une erreur

						erreur_oui_ou_non = "oui";

					}

					if (erreur_modif_profil.equals("espace")) {

						erreur_espace = "L'identifiant ne doit pas contenir d'espaces.";

					} else {

						if (erreur_modif_profil.equals("difference")) {

							erreur_difference = "Les identifiants entrés sont différents,merci de les saisir à nouveau.";

						} else {

							if (erreur_modif_profil.equals("quatre")) {

								erreur_quatre = "Les identifiants doivent contenir au moins 4 caractères.";

							} else {

								if (erreur_modif_profil.equals("unique")) {

									erreur_unique = "Cet identifiant est déjà utilisé, merci d'en choisir un autre.";

								} else {

								}

							}

						}

					}

				}

				if (massepatient == 0) {

					massepatientexiste = "non";

				} else {

					massepatientexiste = "oui";

				}

				if (taillepatient == 0) {

					taillepatientexiste = "non";

				} else {

					taillepatientexiste = "oui";

				}

			} else {

				action = "consulter";

			}

			patientconsulter = patientDao.trouver(identifiant);
		}
	}
}
