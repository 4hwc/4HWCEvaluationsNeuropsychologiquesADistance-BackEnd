/**
 * 
 */
package enad.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


import org.joda.time.DateTime;

/**
 * @author Admin
 *
 */
public class Groupe implements Serializable {

	/* Propriétés du bean */

	private Long id_groupe; // bdd
	private String nom_groupe; // bdd
	private DateTime date_heure_creation_groupe;// bdd
	private String photo_groupe;
	private ArrayList<Groupe> listeGroupes = new ArrayList<Groupe>();
	private Patient patient;
	private Medecin medecin;
	private Carnet_sante carnet_sante;
	private Diagnostic diagnostic;
	private Resultat_test resultat_test;
	private Seance seance;
	private Test test;
	private ArrayList listeMembres = new ArrayList();

	/**
	 * @return the id_groupe
	 */
	public Long getId_groupe() {
		return id_groupe;
	}

	/**
	 * @param id_groupe
	 *            the id_groupe to set
	 */
	public void setId_groupe(Long id_groupe) {
		this.id_groupe = id_groupe;
	}

	/**
	 * @return the nom_groupe
	 */
	public String getNom_groupe() {
		return nom_groupe;
	}

	/**
	 * @param nom_groupe
	 *            the nom_groupe to set
	 */
	public void setNom_groupe(String nom_groupe) {
		this.nom_groupe = nom_groupe;
	}

	/**
	 * @return the date_heure_creation_groupe
	 */
	public DateTime getDate_heure_creation_groupe() {
		return date_heure_creation_groupe;
	}

	/**
	 * @param date_heure_creation_groupe
	 *            the date_heure_creation_groupe to set
	 */
	public void setDate_heure_creation_groupe(DateTime date_heure_creation_groupe) {
		this.date_heure_creation_groupe = date_heure_creation_groupe;
	}

	/**
	 * @return the photo_groupe
	 */
	public String getPhoto_groupe() {
		return photo_groupe;
	}

	/**
	 * @param photo_groupe
	 *            the photo_groupe to set
	 */
	public void setPhoto_groupe(String photo_groupe) {
		this.photo_groupe = photo_groupe;
	}

	/**
	 * @return the listeGroupes
	 */
	public ArrayList<Groupe> getListeGroupes() {
		return listeGroupes;
	}

	/**
	 * @param listeGroupes
	 *            the listeGroupes to set
	 */
	public void setListeGroupes(ArrayList<Groupe> listeGroupes) {
		this.listeGroupes = listeGroupes;
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
	 * @return the listeMembres
	 */
	public List getListeMembres() {
		return listeMembres;
	}

	/**
	 * @param listeMembres
	 *            the listeMembres to set
	 */
	public void setListeMembres(ArrayList listeMembres) {
		this.listeMembres = listeMembres;
	}

}
