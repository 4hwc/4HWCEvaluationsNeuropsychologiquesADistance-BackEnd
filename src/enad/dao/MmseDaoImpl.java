package enad.dao;

import static enad.dao.DAOUtilitaire.fermeturesSilencieuses;
import static enad.dao.DAOUtilitaire.initialisationRequetePreparee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import enad.beans.Mmse;

public class MmseDaoImpl implements MmseDao {

	private static final String SQL_SELECT_IDENTIFIANT_MED_PHRASE_ECRIRE = "SELECT identifiant_med FROM mmse_phrase_ecrire_traitement WHERE id_aleatoire_mmse =?";

	private static final String SQL_SELECT_IDENTIFIANT_MED_DESSIN_RECOPIER = "SELECT identifiant_med FROM mmse_dessin_recopier_traitement WHERE id_aleatoire_mmse =?";

	private static final String SQL_SELECT_IDALEATOIRE_RECENT_PATIENT_PHRASE_ECRIRE = "SELECT id_aleatoire_mmse FROM mmse_phrase_ecrire_traitement WHERE identifiant_pat =? ORDER BY date_heure_pre_traitement_mmse DESC LIMIT 1 OFFSET 0";

	private static final String SQL_SELECT_IDALEATOIRE_RECENT_PATIENT_DESSIN_RECOPIER = "SELECT id_aleatoire_mmse FROM mmse_dessin_recopier_traitement WHERE identifiant_pat =? ORDER BY date_heure_pre_traitement_mmse DESC LIMIT 1 OFFSET 0";

	private static final String SQL_INSERT = "INSERT INTO mmse (scoreOrientation,scoreApprentissage,scoreAttentionEtCalcul,scoreRappel,scoreLangage,scorePraxiesConstructives,scoreTotalMmse,identifiant_medecin,identifiant_patient,prenoms_noms_patient,prenoms_noms_medecin,id_aleatoire_mmse,imageLangage_oui_non,imagePraxiesConstructives_oui_non,date_heure_resultat_mmse) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,NOW())";

	private static final String SQL_INSERT_PRE_TRAITEMENT_MMSE = "INSERT INTO mmse_phrase_ecrire_traitement (id_aleatoire_mmse,identifiant_med,identifiant_pat,date_heure_pre_traitement_mmse) VALUES(?,?,?,NOW())";

	private static final String SQL_INSERT_PRE_TRAITEMENT_MMSE_DESSIN = "INSERT INTO mmse_dessin_recopier_traitement (id_aleatoire_mmse,identifiant_med,identifiant_pat,date_heure_pre_traitement_mmse) VALUES(?,?,?,NOW())";

	private static final String SQL_SELECT_CHRONO_ASC = "SELECT * FROM mmse WHERE  identifiant_medecin = ? ORDER BY date_heure_resultat_mmse ASC";

	private static final String SQL_SELECT_CHRONO_ASC_UNIQUE = "SELECT * FROM mmse WHERE  identifiant_medecin = ? AND identifiant_patient = ? ORDER BY date_heure_resultat_mmse ASC";

	private static final String SQL_SELECT_CHRONO_DESC = "SELECT * FROM mmse WHERE  identifiant_medecin = ? ORDER BY date_heure_resultat_mmse DESC";

	private static final String SQL_SELECT_CHRONO_DESC_UNIQUE = "SELECT * FROM mmse WHERE  identifiant_medecin = ? AND identifiant_patient = ? ORDER BY date_heure_resultat_mmse DESC";

	private static final String SQL_SELECT_SCORE_DESC = "SELECT * FROM mmse WHERE  identifiant_medecin = ? ORDER BY scoreTotalMmse DESC";

	private static final String SQL_SELECT_SCORE_DESC_UNIQUE = "SELECT * FROM mmse WHERE  identifiant_medecin = ? AND identifiant_patient = ? ORDER BY scoreTotalMmse DESC";

	private static final String SQL_SELECT_SCORE_ASC = "SELECT * FROM mmse WHERE  identifiant_medecin = ? ORDER BY scoreTotalMmse ASC";

	private static final String SQL_SELECT_SCORE_ASC_UNIQUE = "SELECT * FROM mmse WHERE  identifiant_medecin = ? AND identifiant_patient = ? ORDER BY scoreTotalMmse ASC";

	private DAOFactory daoFactory;

	MmseDaoImpl(DAOFactory daoFactory) {
		this.daoFactory = daoFactory;

	}

	/*
	 * Implémentation de la méthode identifiant_med_dessin_recopier() définie
	 * dans l'interface MmseDao
	 */

	@Override
	public String identifiant_med_dessin_recopier(Long id) throws DAOException {

		return identifiant_med_dessin_recopier(SQL_SELECT_IDENTIFIANT_MED_DESSIN_RECOPIER, id);
	}

	private String identifiant_med_dessin_recopier(String sql, Object objets) throws DAOException {

		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		String identifiant_med = new String();

		try {

			/* Récupération d'une connexion depuis la Factory */
			connexion = daoFactory.getConnection();

			/*
			 * Préparation de la requête avec les objets passés en arguments
			 * (ici,uniquement un identifiant_medecin) et exécution.
			 */

			preparedStatement = initialisationRequetePreparee(connexion, sql, true, objets);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				identifiant_med = resultSet.getString("identifiant_med");

			}

		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			fermeturesSilencieuses(resultSet, preparedStatement, connexion);
		}

		return identifiant_med;

	}

	/*
	 * Implémentation de la méthode identifiant_med_phrase_ecrire() définie dans
	 * l'interface MmseDao
	 */

	@Override
	public String identifiant_med_phrase_ecrire(Long id) throws DAOException {

		return identifiant_med_phrase_ecrire(SQL_SELECT_IDENTIFIANT_MED_PHRASE_ECRIRE, id);
	}

	private String identifiant_med_phrase_ecrire(String sql, Object objets) throws DAOException {

		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		String identifiant_med = new String();

		try {

			/* Récupération d'une connexion depuis la Factory */
			connexion = daoFactory.getConnection();

			/*
			 * Préparation de la requête avec les objets passés en arguments
			 * (ici,uniquement un identifiant_medecin) et exécution.
			 */

			preparedStatement = initialisationRequetePreparee(connexion, sql, true, objets);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				identifiant_med = resultSet.getString("identifiant_med");

			}

		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			fermeturesSilencieuses(resultSet, preparedStatement, connexion);
		}

		return identifiant_med;

	}

	/*
	 * Implémentation de la méthode
	 * id_aleatoire_recent_patient_dessin_recopier() définie dans l'interface
	 * MmseDao
	 */

	@Override
	public Long id_aleatoire_recent_patient_dessin_recopier(String identifiantpat) throws DAOException {

		return id_aleatoire_recent_patient_dessin_recopier(SQL_SELECT_IDALEATOIRE_RECENT_PATIENT_DESSIN_RECOPIER,
				identifiantpat);
	}

	private Long id_aleatoire_recent_patient_dessin_recopier(String sql, Object objets) throws DAOException {

		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		Long id = 0L;

		try {

			/* Récupération d'une connexion depuis la Factory */
			connexion = daoFactory.getConnection();

			/*
			 * Préparation de la requête avec les objets passés en arguments
			 * (ici,uniquement un identifiant_medecin) et exécution.
			 */

			preparedStatement = initialisationRequetePreparee(connexion, sql, true, objets);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				id = resultSet.getLong("id_aleatoire_mmse");

			}

		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			fermeturesSilencieuses(resultSet, preparedStatement, connexion);
		}

		return id;

	}

	/*
	 * Implémentation de la méthode id_aleatoire_recent_patient_phrase_ecrire()
	 * définie dans l'interface MmseDao
	 */

	@Override
	public Long id_aleatoire_recent_patient_phrase_ecrire(String identifiantpat) throws DAOException {

		return id_aleatoire_recent_patient_phrase_ecrire(SQL_SELECT_IDALEATOIRE_RECENT_PATIENT_PHRASE_ECRIRE,
				identifiantpat);
	}

	private Long id_aleatoire_recent_patient_phrase_ecrire(String sql, Object objets) throws DAOException {

		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		Long id = 0L;

		try {

			/* Récupération d'une connexion depuis la Factory */
			connexion = daoFactory.getConnection();

			/*
			 * Préparation de la requête avec les objets passés en arguments
			 * (ici,uniquement un identifiant_medecin) et exécution.
			 */

			preparedStatement = initialisationRequetePreparee(connexion, sql, true, objets);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				id = resultSet.getLong("id_aleatoire_mmse");

			}

		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			fermeturesSilencieuses(resultSet, preparedStatement, connexion);
		}

		return id;

	}

	/*
	 * Implémentation de la méthode clic_patient_ou_pas_phrase_ecrire() définie
	 * dans l'interface MmseDao
	 */

	@Override
	public int clic_patient_ou_pas_phrase_ecrire(Long id, String identifiantmed) throws DAOException {

		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		int compteur = 0;

		try {

			/* Récupération d'une connexion depuis la Factory */
			connexion = daoFactory.getConnection();

			preparedStatement = initialisationRequetePreparee(connexion,
					"SELECT * FROM mmse_phrase_ecrire_traitement WHERE clic_pat ='PAT'  AND id_aleatoire_mmse ='" + id
							+ "' AND identifiant_med='" + identifiantmed + "'",
					true);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				compteur++;

			}

		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			fermeturesSilencieuses(resultSet, preparedStatement, connexion);
		}

		return compteur;

	}

	/*
	 * Implémentation de la méthode clic_patient_ou_pas_dessin_recopier()
	 * définie dans l'interface MmseDao
	 */

	@Override
	public int clic_patient_ou_pas_dessin_recopier(Long id, String identifiantmed) throws DAOException {

		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		int compteur = 0;

		try {

			/* Récupération d'une connexion depuis la Factory */
			connexion = daoFactory.getConnection();

			preparedStatement = initialisationRequetePreparee(connexion,
					"SELECT * FROM mmse_dessin_recopier_traitement WHERE clic_pat ='PAT'  AND id_aleatoire_mmse ='" + id
							+ "' AND identifiant_med='" + identifiantmed + "'",
					true);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				compteur++;

			}

		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			fermeturesSilencieuses(resultSet, preparedStatement, connexion);
		}

		return compteur;

	}

	/*
	 * Implémentation de la méthode clic_medecin_ou_pas_phrase_ecrire() définie
	 * dans l'interface MmseDao
	 */

	@Override
	public int clic_medecin_ou_pas_phrase_ecrire(Long id) throws DAOException {

		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		int compteur = 0;

		try {

			/* Récupération d'une connexion depuis la Factory */
			connexion = daoFactory.getConnection();

			preparedStatement = initialisationRequetePreparee(connexion,
					"SELECT * FROM mmse_phrase_ecrire_traitement WHERE clic_med ='MED'  AND id_aleatoire_mmse ='" + id
							+ "'",
					true);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				compteur++;

			}

		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			fermeturesSilencieuses(resultSet, preparedStatement, connexion);
		}

		return compteur;

	}

	/*
	 * Implémentation de la méthode clic_medecin_ou_pas_dessin_recopier()
	 * définie dans l'interface MmseDao
	 */

	@Override
	public int clic_medecin_ou_pas_dessin_recopier(Long id) throws DAOException {

		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		int compteur = 0;

		try {

			/* Récupération d'une connexion depuis la Factory */
			connexion = daoFactory.getConnection();

			preparedStatement = initialisationRequetePreparee(connexion,
					"SELECT * FROM mmse_dessin_recopier_traitement WHERE clic_med ='MED'  AND id_aleatoire_mmse ='" + id
							+ "'",
					true);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				compteur++;

			}

		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			fermeturesSilencieuses(resultSet, preparedStatement, connexion);
		}

		return compteur;

	}

	/*
	 * Implémentation de la méthode clic_med_phrase_ecrire() définie dans
	 * l'interface MmseDao
	 */

	@Override
	public void clic_med_phrase_ecrire(Long id_aleatoire) throws IllegalArgumentException, DAOException {

		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet valeursAutoGenerees = null;

		try {

			connexion = daoFactory.getConnection();

			preparedStatement = initialisationRequetePreparee(connexion,
					"UPDATE mmse_phrase_ecrire_traitement SET clic_med ='MED' WHERE id_aleatoire_mmse = '"
							+ id_aleatoire + "'",
					true);

			int statut = preparedStatement.executeUpdate();

			if (statut == 0) {
				throw new DAOException("Échec de la modification de null à MED ,aucune ligne modifiée dans la table. ");
			}

		} catch (SQLException e) {

			throw new DAOException(e);

		} finally {

			fermeturesSilencieuses(valeursAutoGenerees, preparedStatement, connexion);

		}

	}

	/*
	 * Implémentation de la méthode clic_med_dessin_recopier() définie dans
	 * l'interface MmseDao
	 */

	@Override
	public void clic_med_dessin_recopier(Long id_aleatoire) throws IllegalArgumentException, DAOException {

		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet valeursAutoGenerees = null;

		try {

			connexion = daoFactory.getConnection();

			preparedStatement = initialisationRequetePreparee(connexion,
					"UPDATE mmse_dessin_recopier_traitement SET clic_med ='MED' WHERE id_aleatoire_mmse = '"
							+ id_aleatoire + "'",
					true);

			int statut = preparedStatement.executeUpdate();

			if (statut == 0) {
				throw new DAOException("Échec de la modification de null à MED ,aucune ligne modifiée dans la table. ");
			}

		} catch (SQLException e) {

			throw new DAOException(e);

		} finally {

			fermeturesSilencieuses(valeursAutoGenerees, preparedStatement, connexion);

		}

	}

	/*
	 * Implémentation de la méthode clic_pat_phrase_ecrire() définie dans
	 * l'interface MmseDao
	 */

	@Override
	public void clic_pat_phrase_ecrire(Long id_aleatoire) throws IllegalArgumentException, DAOException {

		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet valeursAutoGenerees = null;

		try {

			connexion = daoFactory.getConnection();

			preparedStatement = initialisationRequetePreparee(connexion,
					"UPDATE mmse_phrase_ecrire_traitement SET clic_pat ='PAT' WHERE id_aleatoire_mmse = '"
							+ id_aleatoire + "'",
					true);

			int statut = preparedStatement.executeUpdate();

			if (statut == 0) {
				throw new DAOException("Échec de la modification de null à PAT ,aucune ligne modifiée dans la table. ");
			}

		} catch (SQLException e) {

			throw new DAOException(e);

		} finally {

			fermeturesSilencieuses(valeursAutoGenerees, preparedStatement, connexion);

		}

	}

	/*
	 * Implémentation de la méthode clic_pat_dessin_recopier() définie dans
	 * l'interface MmseDao
	 */

	@Override
	public void clic_pat_dessin_recopier(Long id_aleatoire) throws IllegalArgumentException, DAOException {

		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet valeursAutoGenerees = null;

		try {

			connexion = daoFactory.getConnection();

			preparedStatement = initialisationRequetePreparee(connexion,
					"UPDATE mmse_dessin_recopier_traitement SET clic_pat ='PAT' WHERE id_aleatoire_mmse = '"
							+ id_aleatoire + "'",
					true);

			int statut = preparedStatement.executeUpdate();

			if (statut == 0) {
				throw new DAOException("Échec de la modification de null à PAT ,aucune ligne modifiée dans la table. ");
			}

		} catch (SQLException e) {

			throw new DAOException(e);

		} finally {

			fermeturesSilencieuses(valeursAutoGenerees, preparedStatement, connexion);

		}

	}

	/*
	 * Implémentation de la méthode creer() définie dans l'interface MmseDao
	 */

	@Override
	public void creer(Mmse mmse) throws IllegalArgumentException, DAOException {

		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet valeursAutoGenerees = null;

		try {

			connexion = daoFactory.getConnection();
			preparedStatement = initialisationRequetePreparee(connexion, SQL_INSERT, true,

					mmse.getScoreOrientation(), mmse.getScoreApprentissage(), mmse.getScoreAttentionEtCalcul(),
					mmse.getScoreRappel(), mmse.getScoreLangage(), mmse.getScorePraxiesConstructives(),
					mmse.getScoreTotalMmse(), mmse.getIdentifiant_medecin(), mmse.getIdentifiant_patient(),
					mmse.getPrenoms_noms_patient(), mmse.getPrenoms_noms_medecin(), mmse.getId_aleatoire_mmse(),
					mmse.getImageLangage_oui_non(), mmse.getImagePraxiesConstructives_oui_non());

			int statut = preparedStatement.executeUpdate();

			if (statut == 0) {
				throw new DAOException(
						"Échec de l'enregistrement des résultats mmse,aucune ligne ajoutée dans la table. ");
			}

			valeursAutoGenerees = preparedStatement.getGeneratedKeys();

			if (valeursAutoGenerees.next()) {

				mmse.setId_mmse(valeursAutoGenerees.getLong(1));

			} else {
				throw new DAOException(
						"Échec de l'enregistrement des résultats mmse  en base,aucun ID auto-généré retourné.");
			}

		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {

			fermeturesSilencieuses(valeursAutoGenerees, preparedStatement, connexion);
		}

	}

	/*
	 * Implémentation de la méthode creerPreTraitementPhraseEcrireMmse() définie
	 * dans l'interface MmseDao
	 */

	@Override
	public void creerPreTraitementPhraseEcrireMmse(Long id_aleatoire, String identifiantmed, String identifiantpat)
			throws IllegalArgumentException, DAOException {

		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet valeursAutoGenerees = null;

		try {

			connexion = daoFactory.getConnection();
			preparedStatement = initialisationRequetePreparee(connexion, SQL_INSERT_PRE_TRAITEMENT_MMSE, true,
					id_aleatoire, identifiantmed, identifiantpat

			);

			int statut = preparedStatement.executeUpdate();

			if (statut == 0) {
				throw new DAOException(
						"Échec de l'enregistrement du pré traitement mmse,aucune ligne ajoutée dans la table. ");
			}

			valeursAutoGenerees = preparedStatement.getGeneratedKeys();

			if (valeursAutoGenerees.next()) {

			} else {
				throw new DAOException(
						"Échec de l'enregistrement du pré traitement mmse  en base,aucun ID auto-généré retourné.");
			}

		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {

			fermeturesSilencieuses(valeursAutoGenerees, preparedStatement, connexion);
		}

	}

	/*
	 * Implémentation de la méthode creerPreTraitementDessinRecopierMmse()
	 * définie dans l'interface MmseDao
	 */

	@Override
	public void creerPreTraitementDessinRecopierMmse(Long id_aleatoire, String identifiantmed, String identifiantpat)
			throws IllegalArgumentException, DAOException {

		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet valeursAutoGenerees = null;

		try {

			connexion = daoFactory.getConnection();
			preparedStatement = initialisationRequetePreparee(connexion, SQL_INSERT_PRE_TRAITEMENT_MMSE_DESSIN, true,
					id_aleatoire, identifiantmed, identifiantpat

			);

			int statut = preparedStatement.executeUpdate();

			if (statut == 0) {
				throw new DAOException(
						"Échec de l'enregistrement du pré traitement mmse dessin,aucune ligne ajoutée dans la table. ");
			}

			valeursAutoGenerees = preparedStatement.getGeneratedKeys();

			if (valeursAutoGenerees.next()) {

			} else {
				throw new DAOException(
						"Échec de l'enregistrement du pré traitement mmse dessin en base,aucun ID auto-généré retourné.");
			}

		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {

			fermeturesSilencieuses(valeursAutoGenerees, preparedStatement, connexion);
		}

	}

	/*
	 * Implémentation de la méthode supprimerPreTraitementPhraseEcrireMmse()
	 * définie dans l'interface MmseDao
	 */

	@Override
	public void supprimerPreTraitementPhraseEcrireMmse(Long id_aleatoire, String identifiantmed, String identifiantpat)
			throws IllegalArgumentException, DAOException {

		Connection connexion = null;
		PreparedStatement preparedStatement1 = null;
		ResultSet valeursAutoGenerees1 = null;

		try {

			connexion = daoFactory.getConnection();

			preparedStatement1 = initialisationRequetePreparee(connexion,
					"DELETE FROM mmse_phrase_ecrire_traitement  WHERE id_aleatoire_mmse ='" + id_aleatoire
							+ "' AND identifiant_med='" + identifiantmed + "' AND identifiant_pat = '" + identifiantpat
							+ "'",
					true);

			int statut1 = preparedStatement1.executeUpdate();

			if (statut1 == 0) {
				throw new DAOException(
						"Échec de la suppression PreTraitementPhraseEcrireMmse ,aucune ligne supprimée dans la table. ");
			}

		} catch (SQLException e) {

			throw new DAOException(e);

		} finally {

			fermeturesSilencieuses(valeursAutoGenerees1, preparedStatement1, connexion);

		}

	}

	/*
	 * Implémentation de la méthode supprimerPreTraitementDessinRecopierMmse()
	 * définie dans l'interface MmseDao
	 */

	@Override
	public void supprimerPreTraitementDessinRecopierMmse(Long id_aleatoire, String identifiantmed,
			String identifiantpat) throws IllegalArgumentException, DAOException {

		Connection connexion = null;
		PreparedStatement preparedStatement1 = null;
		ResultSet valeursAutoGenerees1 = null;

		try {

			connexion = daoFactory.getConnection();

			preparedStatement1 = initialisationRequetePreparee(connexion,
					"DELETE FROM mmse_dessin_recopier_traitement  WHERE id_aleatoire_mmse ='" + id_aleatoire
							+ "' AND identifiant_med='" + identifiantmed + "' AND identifiant_pat = '" + identifiantpat
							+ "'",
					true);

			int statut1 = preparedStatement1.executeUpdate();

			if (statut1 == 0) {
				throw new DAOException(
						"Échec de la suppression PreTraitementDessinRecopierMmse ,aucune ligne supprimée dans la table. ");
			}

		} catch (SQLException e) {

			throw new DAOException(e);

		} finally {

			fermeturesSilencieuses(valeursAutoGenerees1, preparedStatement1, connexion);

		}

	}

	/*
	 * Implémentation de la méthode CompteurPreTraitementPhraseEcrireMmse()
	 * définie dans l'interface SeanceDao
	 */

	@Override
	public int CompteurPreTraitementPhraseEcrireMmse(Long id_aleatoire, String identifiantmed, String identifiantpat)
			throws DAOException {

		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		int compteur = 0;

		try {

			/* Récupération d'une connexion depuis la Factory */
			connexion = daoFactory.getConnection();

			/*
			 * Préparation de la requête avec les objets passés en arguments
			 * (ici,uniquement un identifiant_medecin) et exécution.
			 */

			preparedStatement = initialisationRequetePreparee(connexion,
					"SELECT * FROM mmse_phrase_ecrire_traitement WHERE id_aleatoire_mmse ='" + id_aleatoire
							+ "' AND identifiant_med='" + identifiantmed + "' AND identifiant_pat = '" + identifiantpat
							+ "'",
					true);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				compteur++;

			}

		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			fermeturesSilencieuses(resultSet, preparedStatement, connexion);
		}

		return compteur;

	}

	/*
	 * Implémentation de la méthode CompteurPreTraitementDessinRecopierMmse()
	 * définie dans l'interface MmseDao
	 */

	@Override
	public int CompteurPreTraitementDessinRecopierMmse(Long id_aleatoire, String identifiantmed, String identifiantpat)
			throws DAOException {

		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		int compteur = 0;

		try {

			/* Récupération d'une connexion depuis la Factory */
			connexion = daoFactory.getConnection();

			/*
			 * Préparation de la requête avec les objets passés en arguments
			 * (ici,uniquement un identifiant_medecin) et exécution.
			 */

			preparedStatement = initialisationRequetePreparee(connexion,
					"SELECT * FROM mmse_dessin_recopier_traitement WHERE id_aleatoire_mmse ='" + id_aleatoire
							+ "' AND identifiant_med='" + identifiantmed + "' AND identifiant_pat = '" + identifiantpat
							+ "'",
					true);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				compteur++;

			}

		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			fermeturesSilencieuses(resultSet, preparedStatement, connexion);
		}

		return compteur;

	}

	/*
	 * Implémentation de la méthode trouver_mmse_chrono_croissant_unique()
	 * définie dans l'interface MmseDao
	 */

	@Override
	public ArrayList<Mmse> trouver_mmse_chrono_croissant_unique(String identifiantMedecin, String identifiantPatient)
			throws DAOException {

		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		ArrayList<Mmse> mmses = new ArrayList<Mmse>();

		try {

			/* Récupération d'une connexion depuis la Factory */
			connexion = daoFactory.getConnection();

			/*
			 * Préparation de la requête avec les objets passés en arguments
			 * (ici,uniquement un identifiant_medecin) et exécution.
			 */

			preparedStatement = initialisationRequetePreparee(connexion, SQL_SELECT_CHRONO_ASC_UNIQUE, true,
					identifiantMedecin, identifiantPatient);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				mmses.add(map(resultSet));
			}

		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			fermeturesSilencieuses(resultSet, preparedStatement, connexion);
		}

		return mmses;
	}

	/*
	 * Implémentation de la méthode trouver_mmse_chrono_decroissant_unique()
	 * définie dans l'interface MmseDao
	 */

	@Override
	public ArrayList<Mmse> trouver_mmse_chrono_decroissant_unique(String identifiantMedecin, String identifiantPatient)
			throws DAOException {

		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		ArrayList<Mmse> mmses = new ArrayList<Mmse>();

		try {

			/* Récupération d'une connexion depuis la Factory */
			connexion = daoFactory.getConnection();

			/*
			 * Préparation de la requête avec les objets passés en arguments
			 * (ici,uniquement un identifiant_medecin) et exécution.
			 */

			preparedStatement = initialisationRequetePreparee(connexion, SQL_SELECT_CHRONO_DESC_UNIQUE, true,
					identifiantMedecin, identifiantPatient);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				mmses.add(map(resultSet));
			}

		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			fermeturesSilencieuses(resultSet, preparedStatement, connexion);
		}

		return mmses;
	}

	/*
	 * Implémentation de la méthode trouver_mmse_decroissant_unique() définie
	 * dans l'interface MmseDao
	 */

	@Override
	public ArrayList<Mmse> trouver_mmse_decroissant_unique(String identifiantMedecin, String identifiantPatient)
			throws DAOException {

		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		ArrayList<Mmse> mmses = new ArrayList<Mmse>();

		try {

			/* Récupération d'une connexion depuis la Factory */
			connexion = daoFactory.getConnection();

			/*
			 * Préparation de la requête avec les objets passés en arguments
			 * (ici,uniquement un identifiant_medecin) et exécution.
			 */

			preparedStatement = initialisationRequetePreparee(connexion, SQL_SELECT_SCORE_DESC_UNIQUE, true,
					identifiantMedecin, identifiantPatient);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				mmses.add(map(resultSet));
			}

		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			fermeturesSilencieuses(resultSet, preparedStatement, connexion);
		}

		return mmses;
	}

	/*
	 * Implémentation de la méthode trouver_mmse_croissant_unique() définie dans
	 * l'interface MmseDao
	 */

	@Override
	public ArrayList<Mmse> trouver_mmse_croissant_unique(String identifiantMedecin, String identifiantPatient)
			throws DAOException {

		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		ArrayList<Mmse> mmses = new ArrayList<Mmse>();

		try {

			/* Récupération d'une connexion depuis la Factory */
			connexion = daoFactory.getConnection();

			/*
			 * Préparation de la requête avec les objets passés en arguments
			 * (ici,uniquement un identifiant_medecin) et exécution.
			 */

			preparedStatement = initialisationRequetePreparee(connexion, SQL_SELECT_SCORE_ASC_UNIQUE, true,
					identifiantMedecin, identifiantPatient);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				mmses.add(map(resultSet));
			}

		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			fermeturesSilencieuses(resultSet, preparedStatement, connexion);
		}

		return mmses;
	}

	/*
	 * Implémentation de la méthode trouver_mmse_chrono_croissant() définie dans
	 * l'interface MmseDao
	 */

	@Override
	public ArrayList<Mmse> trouver_mmse_chrono_croissant(String identifiantMedecin) throws DAOException {

		return trouver_mmse(SQL_SELECT_CHRONO_ASC, identifiantMedecin);
	}

	/*
	 * Implémentation de la méthode trouver_mmse_chrono_decroissant() définie
	 * dans l'interface MmseDao
	 */

	@Override
	public ArrayList<Mmse> trouver_mmse_chrono_decroissant(String identifiantMedecin) throws DAOException {

		return trouver_mmse(SQL_SELECT_CHRONO_DESC, identifiantMedecin);
	}

	/*
	 * Implémentation de la méthode trouver_mmse_decroissant() définie dans
	 * l'interface MmseDao
	 */

	@Override
	public ArrayList<Mmse> trouver_mmse_decroissant(String identifiantMedecin) throws DAOException {

		return trouver_mmse(SQL_SELECT_SCORE_DESC, identifiantMedecin);
	}

	/*
	 * Implémentation de la méthode trouver_mmse_croissant() définie dans
	 * l'interface MmseDao
	 */

	@Override
	public ArrayList<Mmse> trouver_mmse_croissant(String identifiantMedecin) throws DAOException {

		return trouver_mmse(SQL_SELECT_SCORE_ASC, identifiantMedecin);
	}

	private ArrayList<Mmse> trouver_mmse(String sql, Object objets) throws DAOException {

		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		ArrayList<Mmse> mmses = new ArrayList<Mmse>();

		try {

			/* Récupération d'une connexion depuis la Factory */
			connexion = daoFactory.getConnection();

			/*
			 * Préparation de la requête avec les objets passés en arguments
			 * (ici,uniquement un identifiant_medecin) et exécution.
			 */

			preparedStatement = initialisationRequetePreparee(connexion, sql, true, objets);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				mmses.add(map(resultSet));
			}

		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			fermeturesSilencieuses(resultSet, preparedStatement, connexion);
		}

		return mmses;

	}

	/*
	 * Simple méthode utilitaire permettant de faire la correspondance (le
	 * mapping) entre une ligne issue de la table des mmse (un ResultSet) et un
	 * bean mmse.
	 */

	private static Mmse map(ResultSet resultSet) throws SQLException {

		Mmse mmse = new Mmse();

		mmse.setId_mmse(resultSet.getLong("id_mmse"));

		mmse.setId_aleatoire_mmse(resultSet.getLong("id_aleatoire_mmse"));

		mmse.setIdentifiant_medecin(resultSet.getString("identifiant_medecin"));

		mmse.setIdentifiant_patient(resultSet.getString("identifiant_patient"));

		mmse.setPrenoms_noms_medecin(resultSet.getString("prenoms_noms_medecin"));

		mmse.setPrenoms_noms_patient(resultSet.getString("prenoms_noms_patient"));

		mmse.setScoreOrientation(resultSet.getInt("scoreOrientation"));

		mmse.setScoreApprentissage(resultSet.getInt("scoreApprentissage"));

		mmse.setScoreAttentionEtCalcul(resultSet.getInt("scoreAttentionEtCalcul"));

		mmse.setScoreRappel(resultSet.getInt("scoreRappel"));

		mmse.setScoreLangage(resultSet.getInt("scoreLangage"));

		mmse.setImageLangage_oui_non(resultSet.getString("imageLangage_oui_non"));

		mmse.setScorePraxiesConstructives(resultSet.getInt("scorePraxiesConstructives"));

		mmse.setImagePraxiesConstructives_oui_non(resultSet.getString("imagePraxiesConstructives_oui_non"));

		mmse.setScoreTotalMmse(resultSet.getInt("scoreTotalMmse"));

		mmse.setDate_heure_resultat_mmse(resultSet.getTimestamp("date_heure_resultat_mmse"));

		return mmse;

	}

}
