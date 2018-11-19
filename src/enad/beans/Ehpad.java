/**
 * 
 */
package enad.beans;
//EHPAD : Etablissement hospitalier pour personnes âgées dépendantes

/*Chercher liste EHPAD sur le net*/

import java.io.Serializable;
import java.util.ArrayList;

import org.joda.time.DateTime;

/**
 * @author Admin
 *
 */
public class Ehpad implements Serializable {

	/* Propriétés du bean */

	private Long id_ehpad;// bdd
	private String nom_ehpad;// bdd
	private DateTime date_heure_insertion_ehpad;// bdd

	private ArrayList<Ehpad> listeEhpads = new ArrayList<Ehpad>();

	private Patient patient;
	private Carnet_sante carnet_sante;

	/**
	 * @return the date_heure_insertion_ehpad
	 */
	public DateTime getDate_heure_insertion_ehpad() {
		return date_heure_insertion_ehpad;
	}

	/**
	 * @param date_heure_insertion_ehpad
	 *            the date_heure_insertion_ehpad to set
	 */
	public void setDate_heure_insertion_ehpad(DateTime date_heure_insertion_ehpad) {
		this.date_heure_insertion_ehpad = date_heure_insertion_ehpad;
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
	 * @return the id_ehpad
	 */
	public Long getId_ehpad() {
		return id_ehpad;
	}

	/**
	 * @param id_ehpad
	 *            the id_ehpad to set
	 */
	public void setId_ehpad(Long id_ehpad) {
		this.id_ehpad = id_ehpad;
	}

	/**
	 * @return the nom_ehpad
	 */
	public String getNom_ehpad() {
		return nom_ehpad;
	}

	/**
	 * @param nom_ehpad
	 *            the nom_ehpad to set
	 */
	public void setNom_ehpad(String nom_ehpad) {
		this.nom_ehpad = nom_ehpad;
	}

	/**
	 * @return the listeEhpads
	 */
	public ArrayList<Ehpad> getListeEhpads() {
		return listeEhpads;
	}

	/**
	 * @param listeEhpads
	 *            the listeEhpads to set
	 */
	public void setListeEhpads(ArrayList<Ehpad> listeEhpads) {
		this.listeEhpads = listeEhpads;
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

}
