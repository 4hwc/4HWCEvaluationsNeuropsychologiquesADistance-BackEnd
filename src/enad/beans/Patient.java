/**
 * 
 */
package enad.beans;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;

import org.joda.time.DateTime;
/*Serializable : stockage des données dans la bdd
 * Ptés d'un patient:
 * *noms
 * *prénoms
 * id
 * photo
 * date de naissance / âge
 * date inscription
 * date(s) connexion
 * prise de rdv
 * Pourquoi pas classer les patients par EHPAD ?
 * */

/**
 * @author Admin
 *
 */
public class Patient implements Serializable {

	/*
	 * Pour minimiser les oublis, je permets à l'usateur de download ses infos
	 * persos
	 */

	/*
	 * Mettre un carroussel des photos de l'appli au niveau de l'inscription
	 * pour capter l'attention des utilisateurs
	 */

	/*
	 * Formulaire inscription
	 * 
	 * Noms Prénoms date naissance sexe identifiant
	 * 
	 */

	/*
	 * Formulaire connexion
	 * 
	 * Liste déroulante choix du patient / moteur recherche du nom
	 * 
	 * si 2 pers ont la même appelation (prénoms+noms), je gère les identifiants
	 */

	/* Propriétés du bean */

	private Long id_patient; // bdd
	private String ip_patient;// bdd
	private String identifiant_patient; // bdd
	private String noms_patient; // inscription //bdd
	private String prenoms_patient;// inscription //bdd

	private String photo_patient;// donnée à fournir plus tard //bdd
	private String url_photo_patient;// donnée à fournir plus tard //bdd
	private int age_patient;// inscription //bdd
	// private List<String> diagnostic_patient_fait_par_medecin;
	private Test test;
	private Medecin medecin;
	private ArrayList<Patient> listePatients = new ArrayList<Patient>();
	private Date date_naissance_patient;// inscription //bdd
	private String affichage_date_naissance;
	private Timestamp date_heure_inscription_patient;// inscription // bdd
	private ArrayList<DateTime> dates_heures_connexion_patient = new ArrayList<DateTime>(); // bdd

	private ArrayList<DateTime> dates_heures_deconnexion_patient = new ArrayList<DateTime>();// Profil
																								// //
																								// bdd

	private ArrayList<DateTime> dates_heures_rdv_patient = new ArrayList<DateTime>(); // bdd
	private Ehpad ehpad; // inscription
	private Diagnostic diagnostic;
	private Commentaire commentaire;
	private Resultat_test resultat_test;
	private Seance seance;
	private Carnet_sante carnet_sante;
	private String sexe_patient;// inscription //bdd

	private double masse_patient;// donnée à fournir plus tard //bdd
	private double taille_patient;// donnée à fournir plus tard //bdd

	/*
	 * Connexion : liste déroulante prénoms+noms; Si prénoms+noms similaires, je
	 * propose à l'utilisateur de chosir le profil en fonction des autres infos
	 */

	/**
	 * @return the affichage_date_naissance
	 */
	public String getAffichage_date_naissance() {
		return affichage_date_naissance;
	}

	/**
	 * @return the url_photo_patient
	 */
	public String getUrl_photo_patient() {
		return url_photo_patient;
	}

	/**
	 * @param url_photo_patient
	 *            the url_photo_patient to set
	 */
	public void setUrl_photo_patient(String url_photo_patient) {
		this.url_photo_patient = url_photo_patient;
	}

	/**
	 * @param affichage_date_naissance
	 *            the affichage_date_naissance to set
	 */
	public void setAffichage_date_naissance(String affichage_date_naissance) {
		this.affichage_date_naissance = affichage_date_naissance;
	}

	/**
	 * @return the ip_patient
	 */
	public String getIp_patient() {
		return ip_patient;
	}

	/**
	 * @param ip_patient
	 *            the ip_patient to set
	 */
	public void setIp_patient(String ip_patient) {
		this.ip_patient = ip_patient;
	}

	/**
	 * @return the dates_heures_deconnexion_patient
	 */
	public ArrayList<DateTime> getDates_heures_deconnexion_patient() {
		return dates_heures_deconnexion_patient;
	}

	/**
	 * @param dates_heures_deconnexion_patient
	 *            the dates_heures_deconnexion_patient to set
	 */
	public void setDates_heures_deconnexion_patient(ArrayList<DateTime> dates_heures_deconnexion_patient) {
		this.dates_heures_deconnexion_patient = dates_heures_deconnexion_patient;
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
	 * @return the masse_patient
	 */
	public double getMasse_patient() {
		return masse_patient;
	}

	/**
	 * @param masse_patient
	 *            the masse_patient to set
	 */
	public void setMasse_patient(double masse_patient) {
		this.masse_patient = masse_patient;
	}

	/**
	 * @return the taille_patient
	 */
	public double getTaille_patient() {
		return taille_patient;
	}

	/**
	 * @param taille_patient
	 *            the taille_patient to set
	 */
	public void setTaille_patient(double taille_patient) {
		this.taille_patient = taille_patient;
	}

	/**
	 * @return the sexe_patient
	 */
	public String getSexe_patient() {
		return sexe_patient;
	}

	/**
	 * @param sexe_patient
	 *            the sexe_patient to set
	 */
	public void setSexe_patient(String sexe_patient) {
		this.sexe_patient = sexe_patient;
	}

	/**
	 * @return the carnet_sante
	 */
	public Carnet_sante getCarnet_sante() {
		return carnet_sante;
	}

	/**
	 * @param carnet_sante
	 *            the carnet_sante to set
	 */
	public void setCarnet_sante(Carnet_sante carnet_sante) {
		this.carnet_sante = carnet_sante;
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
	 * @return the seance
	 */
	public Seance getSeance() {
		return seance;
	}

	/**
	 * @param seance
	 *            the seance to set
	 */
	public void setSeance(Seance seance) {
		this.seance = seance;
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
	 * @return the ehpad
	 */
	public Ehpad getEhpad() {
		return ehpad;
	}

	/**
	 * @param ehpad
	 *            the ehpad to set
	 */
	public void setEhpad(Ehpad ehpad) {
		this.ehpad = ehpad;
	}

	/**
	 * @return the id_patient
	 */
	public Long getId_patient() {
		return id_patient;
	}

	/**
	 * @param id_patient
	 *            the id_patient to set
	 */
	public void setId_patient(Long id_patient) {
		this.id_patient = id_patient;
	}

	/**
	 * @return the noms_patient
	 */
	public String getNoms_patient() {
		return noms_patient;
	}

	/**
	 * @param noms_patient
	 *            the noms_patient to set
	 */
	public void setNoms_patient(String noms_patient) {
		this.noms_patient = noms_patient;
	}

	/**
	 * @return the prenoms_patient
	 */
	public String getPrenoms_patient() {
		return prenoms_patient;
	}

	/**
	 * @param prenoms_patient
	 *            the prenoms_patient to set
	 */
	public void setPrenoms_patient(String prenoms_patient) {
		this.prenoms_patient = prenoms_patient;
	}

	/**
	 * @return the photo_patient
	 */
	public String getPhoto_patient() {
		return photo_patient;
	}

	/**
	 * @param photo_patient
	 *            the photo_patient to set
	 */
	public void setPhoto_patient(String photo_patient) {
		this.photo_patient = photo_patient;
	}

	/**
	 * @return the age_patient
	 */
	public int getAge_patient() {
		return age_patient;
	}

	/**
	 * @param age_patient
	 *            the age_patient to set
	 */
	public void setAge_patient(int age_patient) {
		this.age_patient = age_patient;
	}

	/**
	 * @return the diagnostic_patient_fait_par_medecin
	 */
	// public List<String> getDiagnostic_patient_fait_par_medecin() {
	// return diagnostic_patient_fait_par_medecin;
	// }

	/**
	 * @param diagnostic_patient_fait_par_medecin
	 *            the diagnostic_patient_fait_par_medecin to set
	 */
	// public void setDiagnostic_patient_fait_par_medecin(List<String>
	// diagnostic_patient_fait_par_medecin) {
	// this.diagnostic_patient_fait_par_medecin =
	// diagnostic_patient_fait_par_medecin;
	// }

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
	 * @return the listePatients
	 */
	public ArrayList<Patient> getListePatients() {
		return listePatients;
	}

	/**
	 * @param listePatients
	 *            the listePatients to set
	 */
	public void setListePatients(ArrayList<Patient> listePatients) {
		this.listePatients = listePatients;
	}

	/**
	 * @return the date_naissance_patient
	 */
	public Date getDate_naissance_patient() {
		return date_naissance_patient;
	}

	/**
	 * @param date_naissance_patient
	 *            the date_naissance_patient to set
	 */
	public void setDate_naissance_patient(Date date_naissance_patient) {
		this.date_naissance_patient = date_naissance_patient;
	}

	/**
	 * @return the date_heure_inscription_patient
	 */
	public Timestamp getDate_heure_inscription_patient() {
		return date_heure_inscription_patient;
	}

	/**
	 * @param date_heure_inscription_patient
	 *            the date_heure_inscription_patient to set
	 */
	public void setDate_heure_inscription_patient(Timestamp date_heure_inscription_patient) {
		this.date_heure_inscription_patient = date_heure_inscription_patient;
	}

	/**
	 * @return the dates_heures_connexion_patient
	 */
	public ArrayList<DateTime> getDates_heures_connexion_patient() {
		return dates_heures_connexion_patient;
	}

	/**
	 * @param dates_heures_connexion_patient
	 *            the dates_heures_connexion_patient to set
	 */
	public void setDates_heures_connexion_patient(ArrayList<DateTime> dates_heures_connexion_patient) {
		this.dates_heures_connexion_patient = dates_heures_connexion_patient;
	}

	/**
	 * @return the dates_heures_rdv_patient
	 */
	public ArrayList<DateTime> getDates_heures_rdv_patient() {
		return dates_heures_rdv_patient;
	}

	/**
	 * @param dates_heures_rdv_patient
	 *            the dates_heures_rdv_patient to set
	 */
	public void setDates_heures_rdv_patient(ArrayList<DateTime> dates_heures_rdv_patient) {
		this.dates_heures_rdv_patient = dates_heures_rdv_patient;
	}

}
