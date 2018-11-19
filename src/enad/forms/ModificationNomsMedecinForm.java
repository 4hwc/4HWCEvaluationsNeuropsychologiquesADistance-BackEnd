package enad.forms;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import enad.beans.Medecin;
import enad.dao.DAOException;
import enad.dao.MedecinDao;

public final class ModificationNomsMedecinForm {

	private static final String CHAMP_NOMS_MEDECIN = "nomsMedecin";

	public static final String ATT_SESSION_MEDECIN = "sessionMedecin";

	private String resultat;

	private Map<String, String> erreurs = new HashMap<String, String>();

	private MedecinDao medecinDao;

	public ModificationNomsMedecinForm(MedecinDao medecinDao) {

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

	public Medecin modifiernomsMedecin(HttpServletRequest request) {

		Medecin medecin = new Medecin();

		HttpSession session = request.getSession();

		medecin = (Medecin) session.getAttribute(ATT_SESSION_MEDECIN);

		String nomsMedecin = getValeurChamp(request, CHAMP_NOMS_MEDECIN);

		try {

			traiterNomsMedecin(nomsMedecin, medecin);

			if (erreurs.isEmpty()) {

				medecinDao.modifierNomsMedecin(medecin);

				resultat = "Succès de la modification du nom";

			} else {

				resultat = "Échec de la modification du nom";

			}

		} catch (DAOException e) {
			resultat = "Échec de la modification du nom : une erreur imprévue est survenue,merci de réessayer dans quelques instants.";
			e.printStackTrace();
		}

		return medecin;

	}

	private void validationNomsMedecins(String nomsMedecin) throws FormValidationException {

		if (nomsMedecin != null) {

			if (nomsMedecin.trim().length() != 0) {

				// if (nomsMedecin.matches("#[a-zéèçàêâùûA-Z0-9_. -]+#")) {

				// } else {

				// throw new Exception("Veuillez entrer un ou des noms
				// valides.");

				// }

			}

		} else {

			throw new FormValidationException("Veuillez entrer un ou des noms.");

		}
	}

	private void traiterNomsMedecin(String nomsMedecin, Medecin medecin) {

		try {
			validationNomsMedecins(nomsMedecin);

		} catch (FormValidationException e) {
			setErreur(CHAMP_NOMS_MEDECIN, e.getMessage());
		}

		medecin.setNoms_medecin(nomsMedecin);

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
