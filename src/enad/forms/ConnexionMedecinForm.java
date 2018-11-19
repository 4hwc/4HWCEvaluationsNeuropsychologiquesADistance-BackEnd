/**
 * 
 */
package enad.forms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.jasypt.util.password.ConfigurablePasswordEncryptor;

import enad.beans.Medecin;
import enad.dao.DAOException;
import enad.dao.MedecinDao;
import enad.ip.MedecinIp;

/**
 * @author Admin
 *
 */
public final class ConnexionMedecinForm {

	private static final String CHAMP_IDENTIFIANT_MEDECIN = "identifiantMedecin";

	private static final String CHAMP_MDP_MEDECIN = "mdpMedecin";

	private static final String ALGO_CHIFFREMENT = "SHA-256";

	private String resultat;

	private Map<String, String> erreurs = new HashMap<String, String>();

	private MedecinDao medecinDao;

	private int capteur_identifiant_correct = 0;

	private String identifiant_correct = null;

	public ConnexionMedecinForm(MedecinDao medecinDao) {

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

	public Medecin connecterMedecin(HttpServletRequest request) {

		String identifiantMedecin = getValeurChamp(request, CHAMP_IDENTIFIANT_MEDECIN);

		String mdpMedecin = getValeurChamp(request, CHAMP_MDP_MEDECIN);

		Medecin medecin = new Medecin();

		try {

			/* Important de traiter identifiant avant mdp */

			traiterIdentifiantMedecin(identifiantMedecin, medecin);

			traiterMdpMedecin(mdpMedecin, medecin);

			if (erreurs.isEmpty()) {

				medecinDao.creer_ip(medecin);

				resultat = "Succès de la connexion";

			} else {
				resultat = "Échec de la connexion";

			}

		} catch (DAOException e) {

			resultat = "Échec de la connexion : une erreur imprévue est survenue,merci de réessayer dans quelques instants.";
			e.printStackTrace();
		}

		if (identifiant_correct != null) {

			return medecinDao.trouver(identifiant_correct);

		} else {
			return medecin;
		}

	}

	private void validationIdentifiantMedecin(String identifiantMedecin) throws FormValidationException {

		if (identifiantMedecin != null && identifiantMedecin.trim().length() != 0) {

			int nombre = MotAMot(identifiantMedecin).size();

			if (nombre > 1) {

				throw new FormValidationException("L'identifiant ne doit pas contenir d'espaces.");

			} else {

				if (identifiantMedecin.trim().length() < 4) {

					throw new FormValidationException("L'identifiant doit contenir au moins 4 caractères.");

				} else {

					if (medecinDao.trouver(identifiantMedecin) != null) {

						// cas bon

						capteur_identifiant_correct = 1;

						identifiant_correct = identifiantMedecin;

					} else {
						throw new FormValidationException(
								"Cet identifiant est inexistant, veuillez corriger l'identifiant ou vous inscrire.");

					}
				}

			}

		}

	}

	private void traiterIdentifiantMedecin(String identifiantMedecin, Medecin medecin) {

		try {

			validationIdentifiantMedecin(identifiantMedecin);

		} catch (FormValidationException e) {
			setErreur(CHAMP_IDENTIFIANT_MEDECIN, e.getMessage());
		}

		if (identifiant_correct != null) {

			medecin.setId_medecin(medecinDao.trouver(identifiant_correct).getId_medecin());

			MedecinIp distribuer_ip = new MedecinIp(medecinDao);

			medecin.setIp_medecin(distribuer_ip.genererIpMedecin());

		}

	}

	private void validationMdpMedecin(String mdpMedecin) throws FormValidationException {

		if (mdpMedecin != null && mdpMedecin.trim().length() != 0) {

			if (mdpMedecin.trim().length() < 4) {

				throw new FormValidationException("Le mot de passe doit contenir au moins 4 caractères.");

			} else {

				if (capteur_identifiant_correct == 1) {

					ConfigurablePasswordEncryptor passwordEncryptor = new ConfigurablePasswordEncryptor();

					passwordEncryptor.setAlgorithm(ALGO_CHIFFREMENT);

					passwordEncryptor.setPlainDigest(false);

					String motDePasseLieAIdentifiant_bdd = medecinDao.trouver(identifiant_correct).getMdp_medecin();

					if (passwordEncryptor.checkPassword(mdpMedecin, motDePasseLieAIdentifiant_bdd)) {

						// correct
					} else {

						throw new FormValidationException("Le mot de passe ne correspond pas à  cet identifiant.");

					}

				}

			}

		}

	}

	private void traiterMdpMedecin(String mdpMedecin, Medecin medecin) {

		try {

			validationMdpMedecin(mdpMedecin);
		} catch (FormValidationException e) {

			setErreur(CHAMP_MDP_MEDECIN, e.getMessage());

		}

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
