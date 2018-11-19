/**
 * 
 */
package enad.beans;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;

/*AJOUTER DUREE DE CHAQUE SEANCE !!!!!*/
/**
 * @author Admin
 *
 */
public class Seance implements Serializable {

	/* Propriétés du bean */

	private Long id_seance; // bdd
	private String titre_seance;// bdd
	private String resume_seance;// bdd
	private String plan_seance;// bdd
	private ArrayList<Seance> listeSeances = new ArrayList<Seance>();
	private Date date_realisation_seance; // bdd
	private String affichage_date_realisation_seance;

	private Time heure_realisation_seance; // bdd
	private Time heure_fin_seance; // bdd
	private String identifiant_medecin;
	private String identifiant_patient;
	private String prenoms_noms_patient;
	private String prenoms_noms_medecin;
	private Medecin medecin;
	private Patient patient;
	private Test test;
	private Resultat_test resultat_test;
	private Diagnostic diagnostic;
	private Commentaire commentaire;

	private Timestamp date_heure_creation_seance;

	private String valid;

	// durée

	private long duree_seance;

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
	 * @return the affichage_date_realisation_seance
	 */
	public String getAffichage_date_realisation_seance() {
		return affichage_date_realisation_seance;
	}

	/**
	 * @param affichage_date_realisation_seance
	 *            the affichage_date_realisation_seance to set
	 */
	public void setAffichage_date_realisation_seance(String affichage_date_realisation_seance) {
		this.affichage_date_realisation_seance = affichage_date_realisation_seance;
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
	 * @return the valid
	 */
	public String getValid() {
		return valid;
	}

	/**
	 * @param valid
	 *            the valid to set
	 */
	public void setValid(String valid) {
		this.valid = valid;
	}

	/**
	 * @return the date_heure_creation_seance
	 */
	public Timestamp getDate_heure_creation_seance() {
		return date_heure_creation_seance;
	}

	/**
	 * @param date_heure_creation_seance
	 *            the date_heure_creation_seance to set
	 */
	public void setDate_heure_creation_seance(Timestamp date_heure_creation_seance) {
		this.date_heure_creation_seance = date_heure_creation_seance;
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
	 * @return the date_realisation_seance
	 */
	public Date getDate_realisation_seance() {
		return date_realisation_seance;
	}

	/**
	 * @param date_realisation_seance
	 *            the date_realisation_seance to set
	 */
	public void setDate_realisation_seance(Date date_realisation_seance) {
		this.date_realisation_seance = date_realisation_seance;
	}

	/**
	 * @return the heure_realisation_seance
	 */
	public Time getHeure_realisation_seance() {
		return heure_realisation_seance;
	}

	/**
	 * @param heure_realisation_seance
	 *            the heure_realisation_seance to set
	 */
	public void setHeure_realisation_seance(Time heure_realisation_seance) {
		this.heure_realisation_seance = heure_realisation_seance;
	}

	/**
	 * @return the heure_fin_seance
	 */
	public Time getHeure_fin_seance() {
		return heure_fin_seance;
	}

	/**
	 * @param heure_fin_seance
	 *            the heure_fin_seance to set
	 */
	public void setHeure_fin_seance(Time heure_fin_seance) {
		this.heure_fin_seance = heure_fin_seance;
	}

	/**
	 * @return the plan_seance
	 */
	public String getPlan_seance() {
		return plan_seance;
	}

	/**
	 * @param plan_seance
	 *            the plan_seance to set
	 */
	public void setPlan_seance(String plan_seance) {
		this.plan_seance = plan_seance;
	}

	/**
	 * @return the duree_seance
	 */
	public long getDuree_seance() {
		return duree_seance;
	}

	/**
	 * @param duree_seance
	 *            the duree_seance to set
	 */
	public void setDuree_seance(long duree_seance) {
		this.duree_seance = duree_seance;
	}

	/**
	 * @return the resultat_test
	 */
	public Resultat_test getResultat_test() {
		return resultat_test;
	}

	/**
	 * @param resultat_test
	 *            the resultat_test to set
	 */
	public void setResultat_test(Resultat_test resultat_test) {
		this.resultat_test = resultat_test;
	}

	/**
	 * @return the diagnostic
	 */
	public Diagnostic getDiagnostic() {
		return diagnostic;
	}

	/**
	 * @param diagnostic
	 *            the diagnostic to set
	 */
	public void setDiagnostic(Diagnostic diagnostic) {
		this.diagnostic = diagnostic;
	}

	/**
	 * @return the commentaire
	 */
	public Commentaire getCommentaire() {
		return commentaire;
	}

	/**
	 * @param commentaire
	 *            the commentaire to set
	 */
	public void setCommentaire(Commentaire commentaire) {
		this.commentaire = commentaire;
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
	 * @return the titre_seance
	 */
	public String getTitre_seance() {
		return titre_seance;
	}

	/**
	 * @param titre_seance
	 *            the titre_seance to set
	 */
	public void setTitre_seance(String titre_seance) {
		this.titre_seance = titre_seance;
	}

	/**
	 * @return the resume_seance
	 */
	public String getResume_seance() {
		return resume_seance;
	}

	/**
	 * @param resume_seance
	 *            the resume_seance to set
	 */
	public void setResume_seance(String resume_seance) {
		this.resume_seance = resume_seance;
	}

	/**
	 * @return the listeSeances
	 */
	public ArrayList<Seance> getListeSeances() {
		return listeSeances;
	}

	/**
	 * @param listeSeances
	 *            the listeSeances to set
	 */
	public void setListeSeances(ArrayList<Seance> listeSeances) {
		this.listeSeances = listeSeances;
	}

	/**
	 * @return the medecin
	 */
	public Medecin getMedecin() {
		return medecin;
	}

	/**
	 * @param medecin
	 *            the medecin to set
	 */
	public void setMedecin(Medecin medecin) {
		this.medecin = medecin;
	}

	/**
	 * @return the patient
	 */
	public Patient getPatient() {
		return patient;
	}

	/**
	 * @param patient
	 *            the patient to set
	 */
	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	/**
	 * @return the test
	 */
	public Test getTest() {
		return test;
	}

	/**
	 * @param test
	 *            the test to set
	 */
	public void setTest(Test test) {
		this.test = test;
	}

}
