package enad.dao;

import java.util.ArrayList;

import enad.beans.Mmse;

public interface MmseDao {

	void clic_med_phrase_ecrire(Long id_aleatoire) throws DAOException;

	void clic_med_dessin_recopier(Long id_aleatoire) throws DAOException;

	void clic_pat_phrase_ecrire(Long id_aleatoire) throws DAOException;

	void clic_pat_dessin_recopier(Long id_aleatoire) throws DAOException;

	Long id_aleatoire_recent_patient_phrase_ecrire(String identifiantpat) throws DAOException;

	Long id_aleatoire_recent_patient_dessin_recopier(String identifiantpat) throws DAOException;

	String identifiant_med_phrase_ecrire(Long id) throws DAOException;

	String identifiant_med_dessin_recopier(Long id) throws DAOException;

	int clic_patient_ou_pas_phrase_ecrire(Long id_aleatoire, String identifiantmed) throws DAOException;

	int clic_patient_ou_pas_dessin_recopier(Long id_aleatoire, String identifiantmed) throws DAOException;

	int clic_medecin_ou_pas_phrase_ecrire(Long id_aleatoire) throws DAOException;

	int clic_medecin_ou_pas_dessin_recopier(Long id_aleatoire) throws DAOException;

	void creer(Mmse mmse) throws DAOException;

	int CompteurPreTraitementPhraseEcrireMmse(Long id_aleatoire, String identifiantmed, String identifiantpat)
			throws DAOException;

	int CompteurPreTraitementDessinRecopierMmse(Long id_aleatoire, String identifiantmed, String identifiantpat)
			throws DAOException;

	void creerPreTraitementPhraseEcrireMmse(Long id_aleatoire, String identifiantmed, String identifiantpat)
			throws DAOException;

	void creerPreTraitementDessinRecopierMmse(Long id_aleatoire, String identifiantmed, String identifiantpat)
			throws DAOException;

	void supprimerPreTraitementPhraseEcrireMmse(Long id_aleatoire, String identifiantmed, String identifiantpat)
			throws DAOException;

	void supprimerPreTraitementDessinRecopierMmse(Long id_aleatoire, String identifiantmed, String identifiantpat)
			throws DAOException;

	ArrayList<Mmse> trouver_mmse_chrono_croissant(String identifiantMedecin) throws DAOException;

	ArrayList<Mmse> trouver_mmse_croissant(String identifiantMedecin) throws DAOException;

	ArrayList<Mmse> trouver_mmse_chrono_decroissant(String identifiantMedecin) throws DAOException;

	ArrayList<Mmse> trouver_mmse_decroissant(String identifiantMedecin) throws DAOException;

	ArrayList<Mmse> trouver_mmse_chrono_croissant_unique(String identifiantMedecin, String identifiantPatient)
			throws DAOException;

	ArrayList<Mmse> trouver_mmse_croissant_unique(String identifiantMedecin, String identifiantPatient)
			throws DAOException;

	ArrayList<Mmse> trouver_mmse_chrono_decroissant_unique(String identifiantMedecin, String identifiantPatient)
			throws DAOException;

	ArrayList<Mmse> trouver_mmse_decroissant_unique(String identifiantMedecin, String identifiantPatient)
			throws DAOException;

}
