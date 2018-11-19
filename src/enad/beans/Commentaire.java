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
public class Commentaire implements Serializable {

	/* Propriétés du bean */

	private Long id_commentaire; // bdd
	private String titre_commentaire;// bdd
	private String contenu_commentaire;// bdd
	private ArrayList<Commentaire> listeCommentaires = new ArrayList<Commentaire>();
	private DateTime date_heure_realisation_commentaire; // bdd
	private Diagnostic diagnostic;
	private Medecin medecin;
	private Patient patient;
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
	 * @return the id_commentaire
	 */
	public Long getId_commentaire() {
		return id_commentaire;
	}

	/**
	 * @param id_commentaire
	 *            the id_commentaire to set
	 */
	public void setId_commentaire(Long id_commentaire) {
		this.id_commentaire = id_commentaire;
	}

	/**
	 * @return the titre_commentaire
	 */
	public String getTitre_commentaire() {
		return titre_commentaire;
	}

	/**
	 * @param titre_commentaire
	 *            the titre_commentaire to set
	 */
	public void setTitre_commentaire(String titre_commentaire) {
		this.titre_commentaire = titre_commentaire;
	}

	/**
	 * @return the contenu_commentaire
	 */
	public String getContenu_commentaire() {
		return contenu_commentaire;
	}

	/**
	 * @param contenu_commentaire
	 *            the contenu_commentaire to set
	 */
	public void setContenu_commentaire(String contenu_commentaire) {
		this.contenu_commentaire = contenu_commentaire;
	}

	/**
	 * @return the listeCommentaires
	 */
	public ArrayList<Commentaire> getListeCommentaires() {
		return listeCommentaires;
	}

	/**
	 * @param listeCommentaires
	 *            the listeCommentaires to set
	 */
	public void setListeCommentaires(ArrayList<Commentaire> listeCommentaires) {
		this.listeCommentaires = listeCommentaires;
	}

	/**
	 * @return the date_heure_realisation_commentaire
	 */
	public DateTime getDate_heure_realisation_commentaire() {
		return date_heure_realisation_commentaire;
	}

	/**
	 * @param date_heure_realisation_commentaire
	 *            the date_heure_realisation_commentaire to set
	 */
	public void setDate_heure_realisation_commentaire(DateTime date_heure_realisation_commentaire) {
		this.date_heure_realisation_commentaire = date_heure_realisation_commentaire;
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
