package enad.beans;

import java.io.Serializable;
import java.sql.Timestamp;

public class Mmse implements Serializable {

	private Long id_mmse;
	private Long id_aleatoire_mmse;//
	private String identifiant_medecin;
	private String identifiant_patient;
	private String prenoms_noms_patient;
	private String prenoms_noms_medecin;
	private int scoreOrientation;
	private int scoreApprentissage;
	private int scoreAttentionEtCalcul;
	private int scoreRappel;
	private int scoreLangage;
	private String imageLangage_oui_non;//
	private int scorePraxiesConstructives;
	private String imagePraxiesConstructives_oui_non;//
	private int scoreTotalMmse;
	private Timestamp date_heure_resultat_mmse;

	/**
	 * @return the id_aleatoire_mmse
	 */
	public Long getId_aleatoire_mmse() {
		return id_aleatoire_mmse;
	}

	/**
	 * @param id_aleatoire_mmse
	 *            the id_aleatoire_mmse to set
	 */
	public void setId_aleatoire_mmse(Long id_aleatoire_mmse) {
		this.id_aleatoire_mmse = id_aleatoire_mmse;
	}

	/**
	 * @return the imageLangage_oui_non
	 */
	public String getImageLangage_oui_non() {
		return imageLangage_oui_non;
	}

	/**
	 * @param imageLangage_oui_non
	 *            the imageLangage_oui_non to set
	 */
	public void setImageLangage_oui_non(String imageLangage_oui_non) {
		this.imageLangage_oui_non = imageLangage_oui_non;
	}

	/**
	 * @return the imagePraxiesConstructives_oui_non
	 */
	public String getImagePraxiesConstructives_oui_non() {
		return imagePraxiesConstructives_oui_non;
	}

	/**
	 * @param imagePraxiesConstructives_oui_non
	 *            the imagePraxiesConstructives_oui_non to set
	 */
	public void setImagePraxiesConstructives_oui_non(String imagePraxiesConstructives_oui_non) {
		this.imagePraxiesConstructives_oui_non = imagePraxiesConstructives_oui_non;
	}

	/**
	 * @return the id_mmse
	 */
	public Long getId_mmse() {
		return id_mmse;
	}

	/**
	 * @param id_mmse
	 *            the id_mmse to set
	 */
	public void setId_mmse(Long id_mmse) {
		this.id_mmse = id_mmse;
	}

	/**
	 * @return the identifiant_medecin
	 */
	public String getIdentifiant_medecin() {
		return identifiant_medecin;
	}

	/**
	 * @param identifiant_medecin
	 *            the identifiant_medecin to set
	 */
	public void setIdentifiant_medecin(String identifiant_medecin) {
		this.identifiant_medecin = identifiant_medecin;
	}

	/**
	 * @return the identifiant_patient
	 */
	public String getIdentifiant_patient() {
		return identifiant_patient;
	}

	/**
	 * @param identifiant_patient
	 *            the identifiant_patient to set
	 */
	public void setIdentifiant_patient(String identifiant_patient) {
		this.identifiant_patient = identifiant_patient;
	}

	/**
	 * @return the prenoms_noms_patient
	 */
	public String getPrenoms_noms_patient() {
		return prenoms_noms_patient;
	}

	/**
	 * @param prenoms_noms_patient
	 *            the prenoms_noms_patient to set
	 */
	public void setPrenoms_noms_patient(String prenoms_noms_patient) {
		this.prenoms_noms_patient = prenoms_noms_patient;
	}

	/**
	 * @return the prenoms_noms_medecin
	 */
	public String getPrenoms_noms_medecin() {
		return prenoms_noms_medecin;
	}

	/**
	 * @param prenoms_noms_medecin
	 *            the prenoms_noms_medecin to set
	 */
	public void setPrenoms_noms_medecin(String prenoms_noms_medecin) {
		this.prenoms_noms_medecin = prenoms_noms_medecin;
	}

	/**
	 * @return the scoreOrientation
	 */
	public int getScoreOrientation() {
		return scoreOrientation;
	}

	/**
	 * @param scoreOrientation
	 *            the scoreOrientation to set
	 */
	public void setScoreOrientation(int scoreOrientation) {
		this.scoreOrientation = scoreOrientation;
	}

	/**
	 * @return the scoreApprentissage
	 */
	public int getScoreApprentissage() {
		return scoreApprentissage;
	}

	/**
	 * @param scoreApprentissage
	 *            the scoreApprentissage to set
	 */
	public void setScoreApprentissage(int scoreApprentissage) {
		this.scoreApprentissage = scoreApprentissage;
	}

	/**
	 * @return the scoreAttentionEtCalcul
	 */
	public int getScoreAttentionEtCalcul() {
		return scoreAttentionEtCalcul;
	}

	/**
	 * @param scoreAttentionEtCalcul
	 *            the scoreAttentionEtCalcul to set
	 */
	public void setScoreAttentionEtCalcul(int scoreAttentionEtCalcul) {
		this.scoreAttentionEtCalcul = scoreAttentionEtCalcul;
	}

	/**
	 * @return the scoreRappel
	 */
	public int getScoreRappel() {
		return scoreRappel;
	}

	/**
	 * @param scoreRappel
	 *            the scoreRappel to set
	 */
	public void setScoreRappel(int scoreRappel) {
		this.scoreRappel = scoreRappel;
	}

	/**
	 * @return the scoreLangage
	 */
	public int getScoreLangage() {
		return scoreLangage;
	}

	/**
	 * @param scoreLangage
	 *            the scoreLangage to set
	 */
	public void setScoreLangage(int scoreLangage) {
		this.scoreLangage = scoreLangage;
	}

	/**
	 * @return the scorePraxiesConstructives
	 */
	public int getScorePraxiesConstructives() {
		return scorePraxiesConstructives;
	}

	/**
	 * @param scorePraxiesConstructives
	 *            the scorePraxiesConstructives to set
	 */
	public void setScorePraxiesConstructives(int scorePraxiesConstructives) {
		this.scorePraxiesConstructives = scorePraxiesConstructives;
	}

	/**
	 * @return the scoreTotalMmse
	 */
	public int getScoreTotalMmse() {
		return scoreTotalMmse;
	}

	/**
	 * @param scoreTotalMmse
	 *            the scoreTotalMmse to set
	 */
	public void setScoreTotalMmse(int scoreTotalMmse) {
		this.scoreTotalMmse = scoreTotalMmse;
	}

	/**
	 * @return the date_heure_resultat_mmse
	 */
	public Timestamp getDate_heure_resultat_mmse() {
		return date_heure_resultat_mmse;
	}

	/**
	 * @param date_heure_resultat_mmse
	 *            the date_heure_resultat_mmse to set
	 */
	public void setDate_heure_resultat_mmse(Timestamp date_heure_resultat_mmse) {
		this.date_heure_resultat_mmse = date_heure_resultat_mmse;
	}

}
