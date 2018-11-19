/**
 * 
 */
package enad.beans;

import java.io.Serializable;
import java.util.ArrayList;

import org.joda.time.DateTime;

/**
 * @author Admin
 *
 */
public class Diagnostic implements Serializable {

	/* Propriétés du bean */

	private Long id_diagnostic;// bdd
	private String titre_diagnostic;// bdd
	private String contenu_diagnostic;// bdd
	private ArrayList<Diagnostic> listeDiagnostics = new ArrayList<Diagnostic>();
	private DateTime date_heure_realisation_diagnostic;// bdd
	private Patient patient;
	private Medecin medecin;
	private Commentaire commentaire;
	private Test test;
	private Seance seance;
	private Resultat_test resultat_test;

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
	 * @return the id_diagnostic
	 */
	public Long getId_diagnostic() {
		return id_diagnostic;
	}

	/**
	 * @param id_diagnostic
	 *            the id_diagnostic to set
	 */
	public void setId_diagnostic(Long id_diagnostic) {
		this.id_diagnostic = id_diagnostic;
	}

	/**
	 * @return the titre_diagnostic
	 */
	public String getTitre_diagnostic() {
		return titre_diagnostic;
	}

	/**
	 * @param titre_diagnostic
	 *            the titre_diagnostic to set
	 */
	public void setTitre_diagnostic(String titre_diagnostic) {
		this.titre_diagnostic = titre_diagnostic;
	}

	/**
	 * @return the contenu_diagnostic
	 */
	public String getContenu_diagnostic() {
		return contenu_diagnostic;
	}

	/**
	 * @param contenu_diagnostic
	 *            the contenu_diagnostic to set
	 */
	public void setContenu_diagnostic(String contenu_diagnostic) {
		this.contenu_diagnostic = contenu_diagnostic;
	}

	/**
	 * @return the listeDiagnostics
	 */
	public ArrayList<Diagnostic> getListeDiagnostics() {
		return listeDiagnostics;
	}

	/**
	 * @param listeDiagnostics
	 *            the listeDiagnostics to set
	 */
	public void setListeDiagnostics(ArrayList<Diagnostic> listeDiagnostics) {
		this.listeDiagnostics = listeDiagnostics;
	}

	/**
	 * @return the date_realisation_diagnostic
	 */
	public DateTime getDate_realisation_diagnostic() {
		return date_heure_realisation_diagnostic;
	}

	/**
	 * @param date_realisation_diagnostic
	 *            the date_realisation_diagnostic to set
	 */
	public void setDate_realisation_diagnostic(DateTime date_realisation_diagnostic) {
		this.date_heure_realisation_diagnostic = date_realisation_diagnostic;
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
