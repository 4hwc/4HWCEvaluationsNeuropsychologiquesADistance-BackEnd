/**
 * 
 */
package enad.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/*AJOUTER DUREE DE CHAQUE TEST !!!!!*/

/**
 * @author Admin
 *
 */
public class Resultat_test implements Serializable {

	/* Propriétés du bean */

	private Test test;
	private Long id_resultat_test; // bdd
	private String nom_resultat_test; // bdd
	// Déjà présent dans Test : private String definition_test;
	// Déjà présent dans Test : private String description_test;
	// Déjà présent dans Test : private DateTime date_insertion_test;
	// Déjà présent dans Test : private List<DateTime> dates_realisation_test;
	private Medecin medecin;
	private Patient patient;
	// private List<String> commentaires_resultat_test;
	private ArrayList<Resultat_test> listeResultats_tests = new ArrayList<Resultat_test>();
	private Seance seance;
	private Commentaire commentaire;
	private Diagnostic diagnostic;

	// durée

	private long duree_resultat_test; // bdd

	// liste de durées

	private List liste_durees_resultats_tests;

	/**
	 * @return the duree_resultat_test
	 */
	public long getDuree_resultat_test() {
		return duree_resultat_test;
	}

	/**
	 * @param duree_resultat_test
	 *            the duree_resultat_test to set
	 */
	public void setDuree_resultat_test(long duree_resultat_test) {
		this.duree_resultat_test = duree_resultat_test;
	}

	/**
	 * @return the liste_durees_resultats_tests
	 */
	public List getListe_durees_resultats_tests() {
		return liste_durees_resultats_tests;
	}

	/**
	 * @param liste_durees_resultats_tests
	 *            the liste_durees_resultats_tests to set
	 */
	public void setListe_durees_resultats_tests(List liste_durees_resultats_tests) {
		this.liste_durees_resultats_tests = liste_durees_resultats_tests;
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
	 * @return the id_resultat_test
	 */
	public Long getId_resultat_test() {
		return id_resultat_test;
	}

	/**
	 * @param id_resultat_test
	 *            the id_resultat_test to set
	 */
	public void setId_resultat_test(Long id_resultat_test) {
		this.id_resultat_test = id_resultat_test;
	}

	/**
	 * @return the nom_resultat_test
	 */
	public String getNom_resultat_test() {
		return nom_resultat_test;
	}

	/**
	 * @param nom_resultat_test
	 *            the nom_resultat_test to set
	 */
	public void setNom_resultat_test(String nom_resultat_test) {
		this.nom_resultat_test = nom_resultat_test;
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
	 * @return the listeResultats_tests
	 */
	public ArrayList<Resultat_test> getListeResultats_tests() {
		return listeResultats_tests;
	}

	/**
	 * @param listeResultats_tests
	 *            the listeResultats_tests to set
	 */
	public void setListeResultats_tests(ArrayList<Resultat_test> listeResultats_tests) {
		this.listeResultats_tests = listeResultats_tests;
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

}
