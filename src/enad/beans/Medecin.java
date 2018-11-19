/**
 * 
 */
package enad.beans;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;

import org.joda.time.DateTime;
/*Serializable : stockage des données dans la bdd
 * Ptés d'un médécin:
 * *noms
 * *prénoms
 * id
 * photo
 * date inscription
 * date(s) connexion
 * prise de rdv
 * 
 * permettre à plusieurs médécins de collaborer ensemble pour traiter un patient
 * */

/**
 * @author Admin
 *
 */
public class Medecin implements Serializable {

	/*
	 * Pour minimiser les oublis, je permets à l'usateur de download ses infos
	 * persos
	 */

	/*
	 * Mettre un carroussel des photos de l'appli au niveau de l'inscription
	 * pour capter l'attention des utilisateurs
	 * 
	 * dans la notice
	 */

	/*
	 * Formulaire inscription
	 * 
	 * Noms prénoms mdp identifiant
	 * 
	 */

	/*
	 * Formulaire connexion
	 * 
	 * identifiant mdp
	 * 
	 * S'il oublie son mdp, je use son identifiant
	 */

	/* Propriétés du bean */

	private Long id_medecin; // bdd
	private String ip_medecin;// bdd
	private String identifiant_medecin; // bdd
	private String noms_medecin; // Profil // inscription //bdd
	private String prenoms_medecin;// Profil // inscription //bdd
	private String photo_medecin;// Profil // donnée à fournir plus tard //bdd
	private String url_photo_medecin;
	private String mdp_medecin; // inscription //bdd

	private Timestamp date_heure_inscription_medecin;// Profil // inscription
														// //bdd

	private ArrayList<DateTime> dates_heures_connexion_medecin = new ArrayList<DateTime>();// Profil
																							// //bdd

	private ArrayList<DateTime> dates_heures_deconnexion_medecin = new ArrayList<DateTime>();// Profil
																								// //bdd

	private ArrayList<DateTime> dates_heures_rdv_medecin = new ArrayList<DateTime>();// Seances
																						// //bdd
	private Test test;// Tests et Résultats
	private Patient patient;
	private ArrayList<Medecin> listeColleguesMedecins = new ArrayList<Medecin>();// Echanger
																					// avec
																					// les
																					// médecins
	// en relation avec lui
	private ArrayList<Patient> listePatientsEnRelationAvecMedecin = new ArrayList<Patient>();// Echanger
																								// avec
	// les patients
	// en relation
	// avec lui
	private ArrayList<Medecin> listeMedecins = new ArrayList<Medecin>();
	private Diagnostic diagnostic;// Diagnostics
	private Commentaire commentaire; // Commentaires
	private Resultat_test resultat_test;// Tests et Résultats
	private Seance seance;// Seances
	private Carnet_sante carnet_sante;

	/*
	 * Connexion : liste déroulante prénoms+noms; Si prénoms+noms similaires, je
	 * propose à l'utilisateur de chosir le profil en fonction des autres infos
	 * 
	 * mdp ok mais s'il oublie le mdp, on fait quoi ?
	 * 
	 * on lui demande de créer ou choisir une question pour se souvenir de son
	 * âge ?
	 * 
	 * Je peux aussi faire genre:
	 * 
	 * vous vous êtes connectés pour la première fois le JJ/MM/YYYY, vrai ou
	 * faux ?
	 * 
	 * chercher sur internet des moyens pour identifier des utilisateurs sans
	 * utiliser mdp oublié
	 * 
	 * au départ proposer un mdp : prénom+nom+dateinscription+age+enad
	 */

	/**
	 * @return the ip_medecin
	 */
	public String getIp_medecin() {
		return ip_medecin;
	}

	/**
	 * @return the url_photo_medecin
	 */
	public String getUrl_photo_medecin() {
		return url_photo_medecin;
	}

	/**
	 * @param url_photo_medecin
	 *            the url_photo_medecin to set
	 */
	public void setUrl_photo_medecin(String url_photo_medecin) {
		this.url_photo_medecin = url_photo_medecin;
	}

	/**
	 * @param ip_medecin
	 *            the ip_medecin to set
	 */
	public void setIp_medecin(String ip_medecin) {
		this.ip_medecin = ip_medecin;
	}

	/**
	 * @return the date_heure_inscription_medecin
	 */
	public Timestamp getDate_heure_inscription_medecin() {
		return date_heure_inscription_medecin;
	}

	/**
	 * @param date_heure_inscription_medecin
	 *            the date_heure_inscription_medecin to set
	 */
	public void setDate_heure_inscription_medecin(Timestamp date_heure_inscription_medecin) {
		this.date_heure_inscription_medecin = date_heure_inscription_medecin;
	}

	/**
	 * @return the dates_heures_deconnexion_medecin
	 */
	public ArrayList<DateTime> getDates_heures_deconnexion_medecin() {
		return dates_heures_deconnexion_medecin;
	}

	/**
	 * @param dates_heures_deconnexion_medecin
	 *            the dates_heures_deconnexion_medecin to set
	 */
	public void setDates_heures_deconnexion_medecin(ArrayList<DateTime> dates_heures_deconnexion_medecin) {
		this.dates_heures_deconnexion_medecin = dates_heures_deconnexion_medecin;
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
	 * @return the mdp_medecin
	 */
	public String getMdp_medecin() {
		return mdp_medecin;
	}

	/**
	 * @param mdp_medecin
	 *            the mdp_medecin to set
	 */
	public void setMdp_medecin(String mdp_medecin) {
		this.mdp_medecin = mdp_medecin;
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
	 * @return the listePatientsEnRelationAvecMedecin
	 */
	public ArrayList<Patient> getListePatientsEnRelationAvecMedecin() {
		return listePatientsEnRelationAvecMedecin;
	}

	/**
	 * @param listePatientsEnRelationAvecMedecin
	 *            the listePatientsEnRelationAvecMedecin to set
	 */
	public void setListePatientsEnRelationAvecMedecin(ArrayList<Patient> listePatientsEnRelationAvecMedecin) {
		this.listePatientsEnRelationAvecMedecin = listePatientsEnRelationAvecMedecin;
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
	 * @return the id_medecin
	 */
	public Long getId_medecin() {
		return id_medecin;
	}

	/**
	 * @param id_medecin
	 *            the id_medecin to set
	 */
	public void setId_medecin(Long id_medecin) {
		this.id_medecin = id_medecin;
	}

	/**
	 * @return the noms_medecin
	 */
	public String getNoms_medecin() {
		return noms_medecin;
	}

	/**
	 * @param noms_medecin
	 *            the noms_medecin to set
	 */
	public void setNoms_medecin(String noms_medecin) {
		this.noms_medecin = noms_medecin;
	}

	/**
	 * @return the prenoms_medecin
	 */
	public String getPrenoms_medecin() {
		return prenoms_medecin;
	}

	/**
	 * @param prenoms_medecin
	 *            the prenoms_medecin to set
	 */
	public void setPrenoms_medecin(String prenoms_medecin) {
		this.prenoms_medecin = prenoms_medecin;
	}

	/**
	 * @return the photo_medecin
	 */
	public String getPhoto_medecin() {
		return photo_medecin;
	}

	/**
	 * @param photo_medecin
	 *            the photo_medecin to set
	 */
	public void setPhoto_medecin(String photo_medecin) {
		this.photo_medecin = photo_medecin;
	}

	/**
	 * @return the dates_heures_connexion_medecin
	 */
	public ArrayList<DateTime> getDates_heures_connexion_medecin() {
		return dates_heures_connexion_medecin;
	}

	/**
	 * @param dates_heures_connexion_medecin
	 *            the dates_heures_connexion_medecin to set
	 */
	public void setDates_heures_connexion_medecin(ArrayList<DateTime> dates_heures_connexion_medecin) {
		this.dates_heures_connexion_medecin = dates_heures_connexion_medecin;
	}

	/**
	 * @return the dates_heures_rdv_medecin
	 */
	public ArrayList<DateTime> getDates_heures_rdv_medecin() {
		return dates_heures_rdv_medecin;
	}

	/**
	 * @param dates_heures_rdv_medecin
	 *            the dates_heures_rdv_medecin to set
	 */
	public void setDates_heures_rdv_medecin(ArrayList<DateTime> dates_heures_rdv_medecin) {
		this.dates_heures_rdv_medecin = dates_heures_rdv_medecin;
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
	 * @return the listeColleguesMedecins
	 */
	public ArrayList<Medecin> getListeColleguesMedecins() {
		return listeColleguesMedecins;
	}

	/**
	 * @param listeColleguesMedecins
	 *            the listeColleguesMedecins to set
	 */
	public void setListeColleguesMedecins(ArrayList<Medecin> listeColleguesMedecins) {
		this.listeColleguesMedecins = listeColleguesMedecins;
	}

	/**
	 * @return the listeMedecins
	 */
	public ArrayList<Medecin> getListeMedecins() {
		return listeMedecins;
	}

	/**
	 * @param listeMedecins
	 *            the listeMedecins to set
	 */
	public void setListeMedecins(ArrayList<Medecin> listeMedecins) {
		this.listeMedecins = listeMedecins;
	}

}
