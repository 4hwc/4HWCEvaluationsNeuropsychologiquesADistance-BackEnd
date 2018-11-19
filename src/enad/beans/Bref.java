package enad.beans;

import java.io.Serializable;
import java.sql.Timestamp;

public class Bref implements Serializable {

	private Long id_bref;
	private String identifiant_medecin;
	private String identifiant_patient;
	private String prenoms_noms_patient;
	private String prenoms_noms_medecin;
	private int scoreEpreuveSimilitudes;
	private int scoreEpreuveFluenceVerbale;
	private int scoreComportementPrehension;
	private int scoreSequencesMotricesLuria;
	private int scoreEpreuveConsignesConflictuelles;
	private int scoreEpreuveGoNoGo;
	private int scoreTotalBref;
	private Timestamp date_heure_resultat_bref;

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
	 * @return the id_bref
	 */
	public Long getId_bref() {
		return id_bref;
	}

	/**
	 * @param id_bref
	 *            the id_bref to set
	 */
	public void setId_bref(Long id_bref) {
		this.id_bref = id_bref;
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
	 * @return the scoreEpreuveSimilitudes
	 */
	public int getScoreEpreuveSimilitudes() {
		return scoreEpreuveSimilitudes;
	}

	/**
	 * @param scoreEpreuveSimilitudes
	 *            the scoreEpreuveSimilitudes to set
	 */
	public void setScoreEpreuveSimilitudes(int scoreEpreuveSimilitudes) {
		this.scoreEpreuveSimilitudes = scoreEpreuveSimilitudes;
	}

	/**
	 * @return the scoreEpreuveFluenceVerbale
	 */
	public int getScoreEpreuveFluenceVerbale() {
		return scoreEpreuveFluenceVerbale;
	}

	/**
	 * @param scoreEpreuveFluenceVerbale
	 *            the scoreEpreuveFluenceVerbale to set
	 */
	public void setScoreEpreuveFluenceVerbale(int scoreEpreuveFluenceVerbale) {
		this.scoreEpreuveFluenceVerbale = scoreEpreuveFluenceVerbale;
	}

	/**
	 * @return the scoreComportementPrehension
	 */
	public int getScoreComportementPrehension() {
		return scoreComportementPrehension;
	}

	/**
	 * @param scoreComportementPrehension
	 *            the scoreComportementPrehension to set
	 */
	public void setScoreComportementPrehension(int scoreComportementPrehension) {
		this.scoreComportementPrehension = scoreComportementPrehension;
	}

	/**
	 * @return the scoreSequencesMotricesLuria
	 */
	public int getScoreSequencesMotricesLuria() {
		return scoreSequencesMotricesLuria;
	}

	/**
	 * @param scoreSequencesMotricesLuria
	 *            the scoreSequencesMotricesLuria to set
	 */
	public void setScoreSequencesMotricesLuria(int scoreSequencesMotricesLuria) {
		this.scoreSequencesMotricesLuria = scoreSequencesMotricesLuria;
	}

	/**
	 * @return the scoreEpreuveConsignesConflictuelles
	 */
	public int getScoreEpreuveConsignesConflictuelles() {
		return scoreEpreuveConsignesConflictuelles;
	}

	/**
	 * @param scoreEpreuveConsignesConflictuelles
	 *            the scoreEpreuveConsignesConflictuelles to set
	 */
	public void setScoreEpreuveConsignesConflictuelles(int scoreEpreuveConsignesConflictuelles) {
		this.scoreEpreuveConsignesConflictuelles = scoreEpreuveConsignesConflictuelles;
	}

	/**
	 * @return the scoreEpreuveGoNoGo
	 */
	public int getScoreEpreuveGoNoGo() {
		return scoreEpreuveGoNoGo;
	}

	/**
	 * @param scoreEpreuveGoNoGo
	 *            the scoreEpreuveGoNoGo to set
	 */
	public void setScoreEpreuveGoNoGo(int scoreEpreuveGoNoGo) {
		this.scoreEpreuveGoNoGo = scoreEpreuveGoNoGo;
	}

	/**
	 * @return the scoreTotalBref
	 */
	public int getScoreTotalBref() {
		return scoreTotalBref;
	}

	/**
	 * @param scoreTotalBref
	 *            the scoreTotalBref to set
	 */
	public void setScoreTotalBref(int scoreTotalBref) {
		this.scoreTotalBref = scoreTotalBref;
	}

	/**
	 * @return the date_heure_resultat_bref
	 */
	public Timestamp getDate_heure_resultat_bref() {
		return date_heure_resultat_bref;
	}

	/**
	 * @param date_heure_resultat_bref
	 *            the date_heure_resultat_bref to set
	 */
	public void setDate_heure_resultat_bref(Timestamp date_heure_resultat_bref) {
		this.date_heure_resultat_bref = date_heure_resultat_bref;
	}

}
