package enad.forms;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import enad.beans.Medecin;
import enad.dao.DAOException;
import enad.dao.MedecinDao;

public final class ModificationPrenomsMedecinForm {

	private static final String CHAMP_PRENOMS_MEDECIN = "prenomsMedecin";

	public static final String ATT_SESSION_MEDECIN = "sessionMedecin";

	private String resultat;

	private Map<String, String> erreurs = new HashMap<String, String>();

	private MedecinDao medecinDao;

	public ModificationPrenomsMedecinForm(MedecinDao medecinDao) {

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

	public Medecin modifierprenomsMedecin(HttpServletRequest request) {

		Medecin medecin = new Medecin();

		HttpSession session = request.getSession();

		medecin = (Medecin) session.getAttribute(ATT_SESSION_MEDECIN);

		String prenomsMedecin = getValeurChamp(request, CHAMP_PRENOMS_MEDECIN);

		try {

			traiterPrenomsMedecin(prenomsMedecin, medecin);

			if (erreurs.isEmpty()) {

				medecinDao.modifierPrenomsMedecin(medecin);

				resultat = "Succès de la modification du prénom";

			} else {

				resultat = "Échec de la modification du prénom";

			}

		} catch (DAOException e) {
			resultat = "Échec de la modification du prénom : une erreur imprévue est survenue,merci de réessayer dans quelques instants.";
			e.printStackTrace();
		}

		return medecin;

	}

	private void validationPrenomsMedecins(String prenomsMedecin) throws FormValidationException {

		if (prenomsMedecin != null) {

			if (prenomsMedecin.trim().length() != 0) {

				// if (nomsMedecin.matches("#[a-zéèçàêâùûA-Z0-9_. -]+#")) {

				// } else {

				// throw new Exception("Veuillez entrer un ou des noms
				// valides.");

				// }

			}

		} else {

			// throw new FormValidationException("Veuillez entrer un ou des
			// noms.");

		}
	}

	private void traiterPrenomsMedecin(String prenomsMedecin, Medecin medecin) {

		try {
			validationPrenomsMedecins(prenomsMedecin);

		} catch (FormValidationException e) {
			setErreur(CHAMP_PRENOMS_MEDECIN, e.getMessage());
		}

		medecin.setPrenoms_medecin(prenomsMedecin);

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
