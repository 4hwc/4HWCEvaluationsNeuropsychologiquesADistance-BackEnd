/**
 * 
 */
package enad.dao;

import java.util.ArrayList;

import enad.beans.Medecin;
import enad.beans.Patient;

/**
 * @author Admin
 *
 */
public interface PatientDao {

	ArrayList<Patient> TousLesPatients() throws DAOException;

	void uploadphoto(Patient patient) throws DAOException;

	ArrayList<String> trouver_identifiantsmed_relmedpat(String identifiantpat) throws DAOException;

	void creer(Patient patient) throws DAOException;

	Patient trouver(Long idPatient) throws DAOException;

	Patient trouver(String identifiantPatient) throws DAOException;

	void creer_ip(Patient patient) throws DAOException;

	Patient chercher(String ipPatient) throws DAOException;

	void supprimer_ip(Patient patient) throws DAOException;

	ArrayList<Patient> trouver_noms(String nomsPatient) throws DAOException;

	ArrayList<Patient> trouver_prenoms(String prenomsPatient) throws DAOException;

	ArrayList<Medecin> trouver_medecins_pat(String identifiantPatient) throws DAOException;

	int trouver_med_pat(String identifiantMed, String identifiantPat) throws DAOException;

	int trouver_medt_pat(String identifiantMed, String identifiantPat) throws DAOException;

	int trouver_pat(String identifiantPat) throws DAOException;

	int trouver_validations_medt_pat(String identifiantEm, String identifiantDest) throws DAOException;

	int trouver_validations_med_pat(String identifiantEm, String identifiantDest) throws DAOException;

	void modifierNomsPatient(Patient patient) throws DAOException;

	void modifierPrenomsPatient(Patient patient) throws DAOException;

	void modifierIdentifiantPatient(Patient patient) throws DAOException;

	void modifierSexePatient(Patient patient) throws DAOException;

	void modifierMassePatient(Patient patient) throws DAOException;

	void modifierTaillePatient(Patient patient) throws DAOException;

	void modifierDateNaissancePatient(Patient patient) throws DAOException;

	int trouver_pat_connexion_on(Long id_Pat) throws DAOException;
}
