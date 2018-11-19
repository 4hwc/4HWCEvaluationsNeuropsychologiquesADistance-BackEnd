/**
 * 
 */
package enad.beans;

import java.io.Serializable;
import java.util.ArrayList;

import org.joda.time.DateTime;

/*
 * maladie
 * id
 * 
 * Chaque patient a son carnet de santé accessible par un ou plusieurs médécins
 * 
 * Se renseigner sur internet pour voir de quoi est composé un carnet de santé ?
 * 
 * 
 * 
 * 
 * 
 * /

/**
 * @author Admin
 *
 */
public class Carnet_sante implements Serializable {

	/* Propriétés du bean */

	private Long id_carnet_sante; // bdd
	private Patient patient;
	private Commentaire commentaire;
	private Diagnostic diagnostic;
	private Ehpad ehpad;
	private Medecin medecin;
	private Resultat_test resultat_test;
	private Seance seance;
	private Test test;
	private ArrayList<Carnet_sante> listeCarnets_sante = new ArrayList<Carnet_sante>();
	private DateTime date_heure_misajour_carnet_sante;// bdd
	private String nom_carnet_sante; // bdd

	/**
	 * @return the nom_carnet_sante
	 */
	public String getNom_carnet_sante() {
		return nom_carnet_sante;
	}

	/**
	 * @param nom_carnet_sante
	 *            the nom_carnet_sante to set
	 */
	public void setNom_carnet_sante(String nom_carnet_sante) {
		this.nom_carnet_sante = nom_carnet_sante;
	}

	/**
	 * @return the listeCarnets_sante
	 */
	public ArrayList<Carnet_sante> getListeCarnets_sante() {
		return listeCarnets_sante;
	}

	/**
	 * @param listeCarnets_sante
	 *            the listeCarnets_sante to set
	 */
	public void setListeCarnets_sante(ArrayList<Carnet_sante> listeCarnets_sante) {
		this.listeCarnets_sante = listeCarnets_sante;
	}

	/**
	 * @return the date_heure_misajour_carnet_sante
	 */
	public DateTime getDate_heure_misajour_carnet_sante() {
		return date_heure_misajour_carnet_sante;
	}

	/**
	 * @param date_heure_misajour_carnet_sante
	 *            the date_heure_misajour_carnet_sante to set
	 */
	public void setDate_heure_misajour_carnet_sante(DateTime date_heure_misajour_carnet_sante) {
		this.date_heure_misajour_carnet_sante = date_heure_misajour_carnet_sante;
	}

	/**
	 * @return the id_carnet_sante
	 */
	public Long getId_carnet_sante() {
		return id_carnet_sante;
	}

	/**
	 * @param id_carnet_sante
	 *            the id_carnet_sante to set
	 */
	public void setId_carnet_sante(Long id_carnet_sante) {
		this.id_carnet_sante = id_carnet_sante;
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

}
