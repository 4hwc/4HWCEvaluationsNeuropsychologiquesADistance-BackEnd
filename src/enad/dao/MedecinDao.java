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
public interface MedecinDao {

	void creer(Medecin medecin) throws DAOException;

	void uploadphoto(Medecin medecin) throws DAOException;

	ArrayList<Medecin> trouver_noms(String nomsMedecin) throws DAOException;

	ArrayList<String> trouver_identifiantspat_relmedpat(String identifiantmed) throws DAOException;

	ArrayList<String> trouver_identifiantmedun(String identifiantmeddeux) throws DAOException;

	ArrayList<String> trouver_identifiantmeddeux(String identifiantmedun) throws DAOException;

	ArrayList<Medecin> trouver_prenoms(String prenomsMedecin) throws DAOException;

	ArrayList<Medecin> TousLesMedecins() throws DAOException;

	void modifierMotDePasse(Medecin medecin, String identifiant) throws DAOException;

	void modifierNomsMedecin(Medecin medecin) throws DAOException;

	void modifierPrenomsMedecin(Medecin medecin) throws DAOException;

	void modifierIdentifiantMedecin(Medecin medecin) throws DAOException;

	void modifierMotDePasseMedecin(Medecin medecin) throws DAOException;

	Medecin trouver(String identifiantMedecin) throws DAOException;

	void creer_ip(Medecin medecin) throws DAOException;

	Medecin chercher(String ipMedecin) throws DAOException;

	void supprimer_ip(Medecin medecin) throws DAOException;

	ArrayList<Patient> trouver_patients_med(String identifiantMedecin, PatientDao patientDao) throws DAOException;

	ArrayList<Patient> trouver_patients_medtraitant(String identifiantMedecin, PatientDao patientDao)
			throws DAOException;

	int trouver_med_med(String identifiantMed1, String identifiantMed2) throws DAOException;

	int trouver_med_pat(String identifiantMed, String identifiantPat) throws DAOException;

	int trouver_validations_med_med(String identifiantMed1Em, String identifiantMed2Dest) throws DAOException;

	int trouver_validations_med_pat(String identifiantEm, String identifiantDest) throws DAOException;

	int trouver_validations_medt_pat(String identifiantEm, String identifiantDest) throws DAOException;

	int trouver_medt_pat(String identifiantMed, String identifiantPat) throws DAOException;

	int trouver_pat(String identifiantPat) throws DAOException;

	void supprimer_validation_med_med(String ide_em, String ide_dest) throws DAOException;

	void supprimer_validation_medt_pat(String ide_em, String ide_dest) throws DAOException;

	void supprimer_validation_med_pat(String ide_em, String ide_dest) throws DAOException;

	void creer_relation_med_med(String identifiant1, String identifiant2) throws DAOException;

	void creer_relation_medt_pat(String identifiantmed, String identifiantpat) throws DAOException;

	void creer_relation_med_pat(String identifiantmed, String identifiantpat) throws DAOException;

	void creer_val_relation_med_med(String identifiant_em, String identifiant_dest) throws DAOException;

	void creer_val_relation_medt_pat(String identifiant_em, String identifiant_dest) throws DAOException;

	void creer_val_relation_med_pat(String identifiant_em, String identifiant_dest) throws DAOException;

}
