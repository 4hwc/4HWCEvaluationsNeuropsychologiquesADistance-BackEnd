package enad.forms;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.jasypt.util.password.ConfigurablePasswordEncryptor;

import enad.beans.Medecin;
import enad.dao.DAOException;
import enad.dao.MedecinDao;

public final class ModificationMdpMedecinForm {

	private static final String CHAMP_MDP_MEDECIN = "mdpMedecin";

	private static final String CHAMP_CONF_MDP_MEDECIN = "confirmemdpMedecin";

	private static final String ALGO_CHIFFREMENT = "SHA-256";

	public static final String ATT_SESSION_MEDECIN = "sessionMedecin";

	private String resultat;

	public String erreur_difference = new String();

	public String erreur_quatre = new String();

	private Map<String, String> erreurs = new HashMap<String, String>();

	private MedecinDao medecinDao;

	public ModificationMdpMedecinForm(MedecinDao medecinDao) {

		this.medecinDao = medecinDao;
	}

	/**
	 * @return the resultat
	 */
	public String getResultat() {
		return resultat;
	}

	public Medecin modifiermdpMedecin(HttpServletRequest request) {

		Medecin medecin = new Medecin();

		HttpSession session = request.getSession();

		medecin = (Medecin) session.getAttribute(ATT_SESSION_MEDECIN);

		String mdpMedecin = getValeurChamp(request, CHAMP_MDP_MEDECIN);

		String confmdpMedecin = getValeurChamp(request, CHAMP_CONF_MDP_MEDECIN);

		try {

			traiterMdpsMedecin(mdpMedecin, confmdpMedecin, medecin);

			if (erreurs.isEmpty()) {

				medecinDao.modifierMotDePasseMedecin(medecin);

				resultat = "Succès de la modification du mot de passe";

				System.out.println(resultat);

			} else {

				resultat = "Échec de la modification du mot de passe";

				System.out.println(resultat);

			}

		} catch (DAOException e) {
			resultat = "Échec de la modification du mot de passe : une erreur imprévue est survenue,merci de réessayer dans quelques instants.";
			e.printStackTrace();
		}

		return medecin;

	}

	private void traiterMdpsMedecin(String mdpMedecin, String confmdpMedecin, Medecin medecin) {

		try {

			validationMdpsMedecins(mdpMedecin, confmdpMedecin);

		} catch (FormValidationException e) {
			setErreur(CHAMP_MDP_MEDECIN, e.getMessage());
			setErreur(CHAMP_CONF_MDP_MEDECIN, null);
		}

		ConfigurablePasswordEncryptor passwordEncryptor = new ConfigurablePasswordEncryptor();

		passwordEncryptor.setAlgorithm(ALGO_CHIFFREMENT);
		passwordEncryptor.setPlainDigest(false);
		String motDePasseChiffre = passwordEncryptor.encryptPassword(mdpMedecin);

		medecin.setMdp_medecin(motDePasseChiffre);

	}

	private void validationMdpsMedecins(String mdpMedecin, String confmdpMedecin) throws FormValidationException {

		if (mdpMedecin != null && mdpMedecin.trim().length() != 0 && confmdpMedecin != null
				&& confmdpMedecin.trim().length() != 0) {

			if (!mdpMedecin.equals(confmdpMedecin)) {

				erreur_difference = "Les mots de passe entrés sont différents,merci de les saisir à nouveau.";

				throw new FormValidationException(

						"Les mots de passe entrés sont différents,merci de les saisir à nouveau.");
			} else if (mdpMedecin.trim().length() < 4) {

				erreur_quatre = "Les mots de passe doivent contenir au moins 4 caractères.";

				throw new FormValidationException("Les mots de passe doivent contenir au moins 4 caractères.");
			}
		} else {
			throw new FormValidationException("Merci de saisir et confirmer votre mot de passe.");
		}
	}

	/**
	 * @return the erreurs
	 */
	public Map<String, String> getErreurs() {
		return erreurs;
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
