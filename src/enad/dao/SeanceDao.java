package enad.dao;

import java.util.ArrayList;

import enad.beans.Medecin;
import enad.beans.PropositionSeance;
import enad.beans.Seance;

public interface SeanceDao {

	int validee_ou_pas(Long id) throws DAOException;

	int clic_patient_ou_pas(Long id) throws DAOException;

	int clic_patient_ou_pas_tm_un(Long id) throws DAOException;

	int clic_patient_ou_pas_tm_deux(Long id) throws DAOException;

	int clic_med_fcro_ou_pas(Long id) throws DAOException;

	int clic_med_tm_un_ou_pas(Long id) throws DAOException;

	int clic_med_tm_deux_ou_pas(Long id) throws DAOException;

	void creer(Medecin medecin, Seance seance, PatientDao patientDao) throws DAOException;

	void clic_med_fcro(Long id) throws DAOException;

	void clic_med_tm_un(Long id) throws DAOException;

	void clic_med_tm_deux(Long id) throws DAOException;

	void clic_pat_fcro(Long id) throws DAOException;

	void clic_pat_tm_un(Long id) throws DAOException;

	void clic_pat_tm_deux(Long id) throws DAOException;

	void realisationdessinjour(Seance seance) throws DAOException;

	ArrayList<Seance> trouver_medecin_validation(String identifiantMedecin) throws DAOException;

	ArrayList<Seance> trouver_patient_validation(String identifiantPatient) throws DAOException;

	Seance trouver_validees(Long id) throws DAOException;

	ArrayList<Seance> trouver_seances_validees(String identifiantMedecin, String identifiantPatient)
			throws DAOException;

	ArrayList<Seance> trouver_medecin_validees(String identifiantMedecin) throws DAOException;

	ArrayList<Seance> trouver_medecin_validees_recent_auplusvieux(String identifiantMedecin) throws DAOException;

	ArrayList<Seance> trouver_patient_validees(String identifiantPatient) throws DAOException;

	void supprimer(Long id) throws DAOException;

	void supprimer_dessin(Long id_seance) throws DAOException;

	Seance trouver(Long idSeance) throws DAOException;

	Seance trouver_seance_de_cet_id(Long idSeance) throws DAOException;

	Seance trouverValidee(Long idSeance) throws DAOException;

	void DeValidationAValidee(PropositionSeance propseance, Long id) throws DAOException;

	void DeValidationAValidee(Long id) throws DAOException;

}
