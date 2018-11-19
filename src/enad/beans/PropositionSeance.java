package enad.beans;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

public class PropositionSeance implements Serializable {

	private Long id_seance_proposition;

	private String identifiant_emission;

	private String prenoms_noms_emission;

	private Long id_seance;

	private Time heure_realisation_seance_proposition; // bdd

	private Time heure_fin_seance_proposition; // bdd

	private String affichage_date_realisation_seance_proposition;

	private Timestamp date_heure_creation_seance_proposition;

	private Date date_realisation_seance_proposition; // bdd

	private String identifiant_medecin_proposition;
	private String identifiant_patient_proposition;
	private String prenoms_noms_patient_proposition;
	private String prenoms_noms_medecin_proposition;

	/**
	 * @return the prenoms_noms_emission
	 */
	public String getPrenoms_noms_emission() {
		return prenoms_noms_emission;
	}

	/**
	 * @param prenoms_noms_emission
	 *            the prenoms_noms_emission to set
	 */
	public void setPrenoms_noms_emission(String prenoms_noms_emission) {
		this.prenoms_noms_emission = prenoms_noms_emission;
	}

	/**
	 * @return the identifiant_emission
	 */
	public String getIdentifiant_emission() {
		return identifiant_emission;
	}

	/**
	 * @param identifiant_emission
	 *            the identifiant_emission to set
	 */
	public void setIdentifiant_emission(String identifiant_emission) {
		this.identifiant_emission = identifiant_emission;
	}

	/**
	 * @return the identifiant_medecin_proposition
	 */
	public String getIdentifiant_medecin_proposition() {
		return identifiant_medecin_proposition;
	}

	/**
	 * @param identifiant_medecin_proposition
	 *            the identifiant_medecin_proposition to set
	 */
	public void setIdentifiant_medecin_proposition(String identifiant_medecin_proposition) {
		this.identifiant_medecin_proposition = identifiant_medecin_proposition;
	}

	/**
	 * @return the identifiant_patient_proposition
	 */
	public String getIdentifiant_patient_proposition() {
		return identifiant_patient_proposition;
	}

	/**
	 * @param identifiant_patient_proposition
	 *            the identifiant_patient_proposition to set
	 */
	public void setIdentifiant_patient_proposition(String identifiant_patient_proposition) {
		this.identifiant_patient_proposition = identifiant_patient_proposition;
	}

	/**
	 * @return the prenoms_noms_patient_proposition
	 */
	public String getPrenoms_noms_patient_proposition() {
		return prenoms_noms_patient_proposition;
	}

	/**
	 * @param prenoms_noms_patient_proposition
	 *            the prenoms_noms_patient_proposition to set
	 */
	public void setPrenoms_noms_patient_proposition(String prenoms_noms_patient_proposition) {
		this.prenoms_noms_patient_proposition = prenoms_noms_patient_proposition;
	}

	/**
	 * @return the prenoms_noms_medecin_proposition
	 */
	public String getPrenoms_noms_medecin_proposition() {
		return prenoms_noms_medecin_proposition;
	}

	/**
	 * @param prenoms_noms_medecin_proposition
	 *            the prenoms_noms_medecin_proposition to set
	 */
	public void setPrenoms_noms_medecin_proposition(String prenoms_noms_medecin_proposition) {
		this.prenoms_noms_medecin_proposition = prenoms_noms_medecin_proposition;
	}

	/**
	 * @return the id_seance_proposition
	 */
	public Long getId_seance_proposition() {
		return id_seance_proposition;
	}

	/**
	 * @param id_seance_proposition
	 *            the id_seance_proposition to set
	 */
	public void setId_seance_proposition(Long id_seance_proposition) {
		this.id_seance_proposition = id_seance_proposition;
	}

	/**
	 * @return the id_seance
	 */
	public Long getId_seance() {
		return id_seance;
	}

	/**
	 * @param id_seance
	 *            the id_seance to set
	 */
	public void setId_seance(Long id_seance) {
		this.id_seance = id_seance;
	}

	/**
	 * @return the heure_realisation_seance_proposition
	 */
	public Time getHeure_realisation_seance_proposition() {
		return heure_realisation_seance_proposition;
	}

	/**
	 * @param heure_realisation_seance_proposition
	 *            the heure_realisation_seance_proposition to set
	 */
	public void setHeure_realisation_seance_proposition(Time heure_realisation_seance_proposition) {
		this.heure_realisation_seance_proposition = heure_realisation_seance_proposition;
	}

	/**
	 * @return the heure_fin_seance_proposition
	 */
	public Time getHeure_fin_seance_proposition() {
		return heure_fin_seance_proposition;
	}

	/**
	 * @param heure_fin_seance_proposition
	 *            the heure_fin_seance_proposition to set
	 */
	public void setHeure_fin_seance_proposition(Time heure_fin_seance_proposition) {
		this.heure_fin_seance_proposition = heure_fin_seance_proposition;
	}

	/**
	 * @return the affichage_date_realisation_seance_proposition
	 */
	public String getAffichage_date_realisation_seance_proposition() {
		return affichage_date_realisation_seance_proposition;
	}

	/**
	 * @param affichage_date_realisation_seance_proposition
	 *            the affichage_date_realisation_seance_proposition to set
	 */
	public void setAffichage_date_realisation_seance_proposition(String affichage_date_realisation_seance_proposition) {
		this.affichage_date_realisation_seance_proposition = affichage_date_realisation_seance_proposition;
	}

	/**
	 * @return the date_heure_creation_seance_proposition
	 */
	public Timestamp getDate_heure_creation_seance_proposition() {
		return date_heure_creation_seance_proposition;
	}

	/**
	 * @param date_heure_creation_seance_proposition
	 *            the date_heure_creation_seance_proposition to set
	 */
	public void setDate_heure_creation_seance_proposition(Timestamp date_heure_creation_seance_proposition) {
		this.date_heure_creation_seance_proposition = date_heure_creation_seance_proposition;
	}

	/**
	 * @return the date_realisation_seance_proposition
	 */
	public Date getDate_realisation_seance_proposition() {
		return date_realisation_seance_proposition;
	}

	/**
	 * @param date_realisation_seance_proposition
	 *            the date_realisation_seance_proposition to set
	 */
	public void setDate_realisation_seance_proposition(Date date_realisation_seance_proposition) {
		this.date_realisation_seance_proposition = date_realisation_seance_proposition;
	}

}
