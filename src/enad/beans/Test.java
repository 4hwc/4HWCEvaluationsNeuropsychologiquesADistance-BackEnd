/**
 * 
 */
package enad.beans;

import java.io.Serializable;
import java.util.ArrayList;

import org.joda.time.DateTime;

/*Serializable : stockage des données dans la bdd
 * Ptés d'un test:
 * *nom
 * *description
 * id
 * photo pour icône
 * courte description = definition
 * longue description = description
 * résultats du patient
 * commentaires du médécin/détermination de l'affection dont souffre le patient
 *   types de commentaires: - commentaire/test
 *                          - commentaire/séance
 * traitement proposé
 * Date d'insertion du test dans l'appli
 * Date(s) de réalisation du test par le patient
 * 
 * IMPORTANT: un test peut être réalisé plusieurs fois
 * 
 * AJOUTER DUREE DE CHAQUE TEST !!!!!
 * 
 * */

/**
 * @author Admin
 *
 */
public class Test implements Serializable {

	/* Propriétés du bean */

	private Long id_test; // bdd
	private String nom_test; // bdd
	private String definition_test;// bdd
	private String description_test;// bdd
	private DateTime date_heure_insertion_test;// bdd
	private ArrayList<DateTime> dates_heures_realisation_test = new ArrayList<DateTime>();
	private Medecin medecin;
	private Patient patient;
	private ArrayList<String> commentaires_test = new ArrayList<String>();
	private ArrayList<Test> listeTests = new ArrayList<Test>();
	private Seance seance;
	private Resultat_test resultat_test;
	private Commentaire commentaire;
	private Diagnostic diagnostic;

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
	 * @return the id_test
	 */
	public Long getId_test() {
		return id_test;
	}

	/**
	 * @param id_test
	 *            the id_test to set
	 */
	public void setId_test(Long id_test) {
		this.id_test = id_test;
	}

	/**
	 * @return the nom_test
	 */
	public String getNom_test() {
		return nom_test;
	}

	/**
	 * @param nom_test
	 *            the nom_test to set
	 */
	public void setNom_test(String nom_test) {
		this.nom_test = nom_test;
	}

	/**
	 * @return the definition_test
	 */
	public String getDefinition_test() {
		return definition_test;
	}

	/**
	 * @param definition_test
	 *            the definition_test to set
	 */
	public void setDefinition_test(String definition_test) {
		this.definition_test = definition_test;
	}

	/**
	 * @return the description_test
	 */
	public String getDescription_test() {
		return description_test;
	}

	/**
	 * @param description_test
	 *            the description_test to set
	 */
	public void setDescription_test(String description_test) {
		this.description_test = description_test;
	}

	/**
	 * @return the date_insertion_test
	 */
	public DateTime getDate_insertion_test() {
		return date_heure_insertion_test;
	}

	/**
	 * @param date_insertion_test
	 *            the date_insertion_test to set
	 */
	public void setDate_insertion_test(DateTime date_insertion_test) {
		this.date_heure_insertion_test = date_insertion_test;
	}

	/**
	 * @return the dates_realisation_test
	 */
	public ArrayList<DateTime> getDates_realisation_test() {
		return dates_heures_realisation_test;
	}

	/**
	 * @param dates_realisation_test
	 *            the dates_realisation_test to set
	 */
	public void setDates_realisation_test(ArrayList<DateTime> dates_realisation_test) {
		this.dates_heures_realisation_test = dates_realisation_test;
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
	 * @return the commentaires_test
	 */
	public ArrayList<String> getCommentaires_test() {
		return commentaires_test;
	}

	/**
	 * @param commentaires_test
	 *            the commentaires_test to set
	 */
	public void setCommentaires_test(ArrayList<String> commentaires_test) {
		this.commentaires_test = commentaires_test;
	}

	/**
	 * @return the listeTests
	 */
	public ArrayList<Test> getListeTests() {
		return listeTests;
	}

	/**
	 * @param listeTests
	 *            the listeTests to set
	 */
	public void setListeTests(ArrayList<Test> listeTests) {
		this.listeTests = listeTests;
	}

}
