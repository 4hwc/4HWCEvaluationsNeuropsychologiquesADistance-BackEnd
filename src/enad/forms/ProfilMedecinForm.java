package enad.forms;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import enad.beans.Medecin;
import enad.beans.Patient;
import enad.dao.MedecinDao;
import enad.dao.PatientDao;

public final class ProfilMedecinForm {

	private MedecinDao medecinDao;

	private PatientDao patientDao;

	public String action = new String();

	public String liaisonmedpat = new String();

	public String liaisonmedtraitantpat = new String();

	public String sessionactivee = new String();

	public String liaison = new String();

	public String avoirmdt = new String();

	public String demandeliaison = new String();

	public String profil = new String();

	public String demandeliaisonmedt = new String();

	public String demandeliaisonmedpat = new String();

	public String demandeliaisonmedpatsens = new String();

	public String demandeliaisonmedtsens = new String();

	public String demandeliaisonsens = new String();

	public Medecin medecinconsulter = new Medecin();

	public Medecin medecinprofil = new Medecin();

	public String erreur_oui_ou_non_noms = new String();

	public String succes_noms = new String();

	public String erreur_oui_ou_non_prenoms = new String();

	public String succes_prenoms = new String();

	public String erreur_oui_ou_non_identifiant = new String();

	public String erreur_espace = new String();

	public String erreur_difference = new String();

	public String erreur_quatre = new String();

	public String erreur_unique = new String();

	public String succes_identifiant = new String();

	public String erreur_oui_ou_non_mdp = new String();

	public String erreur_difference_mdp = new String();

	public String erreur_quatre_mdp = new String();

	public String succes_mdp = new String();

	public static final String ATT_SESSION_MEDECIN = "sessionMedecin";

	public static final String ATT_SESSION_PATIENT = "sessionPatient";

	public ProfilMedecinForm(MedecinDao medecinDao, PatientDao patientDao) {

		this.medecinDao = medecinDao;

		this.patientDao = patientDao;
	}

	public void Action(HttpServletRequest request) {

		/* Récupération de la session depuis la requête */

		profil = "medecin";

		HttpSession session = request.getSession();

		if (session.getAttribute(ATT_SESSION_MEDECIN) != null) {

			sessionactivee = "medecin";

			String identifiant = request.getParameter("identifiant");

			String identifiantMedecin = ((Medecin) session.getAttribute(ATT_SESSION_MEDECIN)).getIdentifiant_medecin();

			if (identifiant.equals(identifiantMedecin)) {

				action = "consulteretmodifier";

				// Gestion des erreurs mdp

				String erreur_modif_profil_mdp = request.getParameter("erreur_mdp");

				if (erreur_modif_profil_mdp == null) {

				} else {

					if (erreur_modif_profil_mdp.equals("aucune")) {

						// Si pas d'erreur

						erreur_oui_ou_non_mdp = "non";

						succes_mdp = "Succès de la modification du mot de passe";

					} else {

						// Si il existe une erreur

						erreur_oui_ou_non_mdp = "oui";

					}

					if (erreur_modif_profil_mdp.equals("differencemdp")) {

						erreur_difference_mdp = "Les mots de passe entrés sont différents,merci de les saisir à nouveau.";

					} else {

						if (erreur_modif_profil_mdp.equals("quatremdp")) {

							erreur_quatre_mdp = "Les mots de passe doivent contenir au moins 4 caractères.";

						} else {

						}

					}

				}
				// Gestion des erreurs identifiant

				String erreur_modif_profil_identifiant = request.getParameter("erreur_identifiant");

				if (erreur_modif_profil_identifiant == null) {

				} else {

					if (erreur_modif_profil_identifiant.equals("aucune")) {

						// Si pas d'erreur

						erreur_oui_ou_non_identifiant = "non";

						succes_identifiant = "Succès de la modification de l'identifiant";

					} else {

						// Si il existe une erreur

						erreur_oui_ou_non_identifiant = "oui";

					}

					if (erreur_modif_profil_identifiant.equals("espace")) {

						erreur_espace = "L'identifiant ne doit pas contenir d'espaces.";

					} else {

						if (erreur_modif_profil_identifiant.equals("difference")) {

							erreur_difference = "Les identifiants entrés sont différents,merci de les saisir à nouveau.";

						} else {

							if (erreur_modif_profil_identifiant.equals("quatre")) {

								erreur_quatre = "Les identifiants doivent contenir au moins 4 caractères.";

							} else {

								if (erreur_modif_profil_identifiant.equals("unique")) {

									erreur_unique = "Cet identifiant est déjà utilisé, merci d'en choisir un autre.";

								} else {

								}

							}

						}

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

			} else {

				action = "consulter";

			}

			medecinconsulter = medecinDao.trouver(identifiant);

			if (medecinDao.trouver_med_med(identifiant, identifiantMedecin) != 0) {

				// les 2 médecins sont liés

				liaison = "oui";

			} else {

				// les 2 médecins ne sont pas liés

				liaison = "non";

				if (medecinDao.trouver_validations_med_med(identifiant, identifiantMedecin) != 0
						|| medecinDao.trouver_validations_med_med(identifiantMedecin, identifiant) != 0) {

					// au moins une personne a fait la demande

					demandeliaison = "oui";

					if (medecinDao.trouver_validations_med_med(identifiant, identifiantMedecin) != 0) {

						demandeliaisonsens = "gauchedroite";

					}

					if (medecinDao.trouver_validations_med_med(identifiantMedecin, identifiant) != 0) {

						demandeliaisonsens = "droitegauche";

					}

				} else {

					// aucune demande

					demandeliaison = "non";

				}

			}

		}

		if (session.getAttribute(ATT_SESSION_PATIENT) != null) {

			sessionactivee = "patient";

			String identifiantmedprofil = request.getParameter("identifiant");

			medecinprofil = medecinDao.trouver(identifiantmedprofil);

			String identifiantPatient = ((Patient) session.getAttribute(ATT_SESSION_PATIENT)).getIdentifiant_patient();

			if (medecinDao.trouver_med_pat(identifiantmedprofil, identifiantPatient) != 0) {

				// le médecin et le patient sont liés

				liaisonmedpat = "oui";

				if (patientDao.trouver_validations_med_pat(identifiantmedprofil, identifiantPatient) != 0) {

					medecinDao.supprimer_validation_med_pat(identifiantmedprofil, identifiantPatient);

				}
				if (patientDao.trouver_validations_med_pat(identifiantPatient, identifiantmedprofil) != 0) {

					medecinDao.supprimer_validation_med_pat(identifiantPatient, identifiantmedprofil);

				}

				if (medecinDao.trouver_medt_pat(identifiantmedprofil, identifiantPatient) != 0) {

					// med traitant et son patient
					liaisonmedtraitantpat = "oui";

				} else {

					liaisonmedtraitantpat = "non";

					// ce med n'est pas medt de ce patient

					if (medecinDao.trouver_pat(identifiantPatient) != 0) {

						avoirmdt = "oui";

						// ce patient a déjà un mdt

					} else {

						avoirmdt = "non";

						// ce patient n'a pas de mdt, alors il est possible de
						// demander

						if (medecinDao.trouver_validations_medt_pat(identifiantmedprofil, identifiantPatient) != 0
								|| medecinDao.trouver_validations_medt_pat(identifiantPatient,
										identifiantmedprofil) != 0) {

							demandeliaisonmedt = "oui";

							if (medecinDao.trouver_validations_medt_pat(identifiantmedprofil,
									identifiantPatient) != 0) {

								demandeliaisonmedtsens = "gauchedroite";

							}

							if (medecinDao.trouver_validations_medt_pat(identifiantPatient,
									identifiantmedprofil) != 0) {

								demandeliaisonmedtsens = "droitegauche";

							}

						} else {
							// aucune demande

							demandeliaisonmedt = "non";
						}

					}

				}

			} else {

				// le médecin et le patient ne sont pas liés

				liaisonmedpat = "non";

				if (medecinDao.trouver_validations_med_pat(identifiantmedprofil, identifiantPatient) != 0
						|| medecinDao.trouver_validations_med_pat(identifiantPatient, identifiantmedprofil) != 0) {

					// au moins une personne a fait la demande

					demandeliaisonmedpat = "oui";

					if (medecinDao.trouver_validations_med_pat(identifiantmedprofil, identifiantPatient) != 0) {

						demandeliaisonmedpatsens = "gauchedroite";
					}

					if (medecinDao.trouver_validations_med_pat(identifiantPatient, identifiantmedprofil) != 0) {

						demandeliaisonmedpatsens = "droitegauche";
					}

				} else {

					// aucune demande

					demandeliaisonmedpat = "non";
				}

				if (medecinDao.trouver_pat(identifiantPatient) != 0) {

					avoirmdt = "oui";

					// ce patient a déjà un mdt

				} else {

					avoirmdt = "non";

					// ce patient n'a pas de mdt, alors il est possible de
					// demander

					if (medecinDao.trouver_validations_medt_pat(identifiantmedprofil, identifiantPatient) != 0
							|| medecinDao.trouver_validations_medt_pat(identifiantPatient, identifiantmedprofil) != 0) {

						demandeliaisonmedt = "oui";

						if (medecinDao.trouver_validations_medt_pat(identifiantmedprofil, identifiantPatient) != 0) {

							demandeliaisonmedtsens = "gauchedroite";

						}

						if (medecinDao.trouver_validations_medt_pat(identifiantPatient, identifiantmedprofil) != 0) {

							demandeliaisonmedtsens = "droitegauche";

						}

					} else {
						// aucune demande

						demandeliaisonmedt = "non";
					}

				}

			}
		}

	}

}
