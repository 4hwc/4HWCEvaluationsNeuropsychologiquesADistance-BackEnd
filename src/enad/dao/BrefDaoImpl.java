package enad.dao;

import static enad.dao.DAOUtilitaire.fermeturesSilencieuses;
import static enad.dao.DAOUtilitaire.initialisationRequetePreparee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import enad.beans.Bref;

public class BrefDaoImpl implements BrefDao {

	private static final String SQL_INSERT = "INSERT INTO bref (scoreEpreuveSimilitudes,scoreEpreuveFluenceVerbale,scoreComportementPrehension,scoreSequencesMotricesLuria,scoreEpreuveConsignesConflictuelles,scoreEpreuveGoNoGo,scoreTotalBref,identifiant_medecin,identifiant_patient,prenoms_noms_patient,prenoms_noms_medecin,date_heure_resultat_bref) VALUES(?,?,?,?,?,?,?,?,?,?,?,NOW())";

	private static final String SQL_SELECT_CHRONO_ASC = "SELECT * FROM bref WHERE  identifiant_medecin = ? ORDER BY date_heure_resultat_bref ASC";

	private static final String SQL_SELECT_CHRONO_ASC_UNIQUE = "SELECT * FROM bref WHERE  identifiant_medecin = ? AND identifiant_patient = ?  ORDER BY date_heure_resultat_bref ASC";

	private static final String SQL_SELECT_CHRONO_DESC = "SELECT * FROM bref WHERE  identifiant_medecin = ? ORDER BY date_heure_resultat_bref DESC";

	private static final String SQL_SELECT_CHRONO_DESC_UNIQUE = "SELECT * FROM bref WHERE  identifiant_medecin = ? AND identifiant_patient = ? ORDER BY date_heure_resultat_bref DESC";

	private static final String SQL_SELECT_SCORE_DESC = "SELECT * FROM bref WHERE  identifiant_medecin = ? ORDER BY scoreTotalBref DESC";

	private static final String SQL_SELECT_SCORE_DESC_UNIQUE = "SELECT * FROM bref WHERE  identifiant_medecin = ? AND identifiant_patient = ? ORDER BY scoreTotalBref DESC";

	private static final String SQL_SELECT_SCORE_ASC = "SELECT * FROM bref WHERE  identifiant_medecin = ? ORDER BY scoreTotalBref ASC";

	private static final String SQL_SELECT_SCORE_ASC_UNIQUE = "SELECT * FROM bref WHERE  identifiant_medecin = ? AND identifiant_patient = ?  ORDER BY scoreTotalBref ASC";

	private DAOFactory daoFactory;

	BrefDaoImpl(DAOFactory daoFactory) {
		this.daoFactory = daoFactory;

	}

	/*
	 * Implémentation de la méthode creer() définie dans l'interface BrefDao
	 */

	@Override
	public void creer(Bref bref) throws IllegalArgumentException, DAOException {

		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet valeursAutoGenerees = null;

		try {

			connexion = daoFactory.getConnection();
			preparedStatement = initialisationRequetePreparee(connexion, SQL_INSERT, true,
					bref.getScoreEpreuveSimilitudes(), bref.getScoreEpreuveFluenceVerbale(),
					bref.getScoreComportementPrehension(), bref.getScoreSequencesMotricesLuria(),
					bref.getScoreEpreuveConsignesConflictuelles(), bref.getScoreEpreuveGoNoGo(),
					bref.getScoreTotalBref(), bref.getIdentifiant_medecin(), bref.getIdentifiant_patient(),
					bref.getPrenoms_noms_patient(), bref.getPrenoms_noms_medecin());

			int statut = preparedStatement.executeUpdate();

			if (statut == 0) {
				throw new DAOException(
						"Échec de l'enregistrement des résultats bref,aucune ligne ajoutée dans la table. ");
			}

			valeursAutoGenerees = preparedStatement.getGeneratedKeys();

			if (valeursAutoGenerees.next()) {

				bref.setId_bref(valeursAutoGenerees.getLong(1));

			} else {
				throw new DAOException(
						"Échec de l'enregistrement des résultats bref  en base,aucun ID auto-généré retourné.");
			}

		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {

			fermeturesSilencieuses(valeursAutoGenerees, preparedStatement, connexion);
		}

	}

	/*
	 * Implémentation de la méthode trouver_bref_chrono_croissant_unique()
	 * définie dans l'interface BrefDao
	 */

	@Override
	public ArrayList<Bref> trouver_bref_chrono_croissant_unique(String identifiantMedecin, String identifiantPatient)
			throws DAOException {

		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		ArrayList<Bref> brefs = new ArrayList<Bref>();

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
				brefs.add(map(resultSet));
			}

		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			fermeturesSilencieuses(resultSet, preparedStatement, connexion);
		}

		return brefs;
	}

	/*
	 * Implémentation de la méthode trouver_bref_croissant_unique() définie dans
	 * l'interface BrefDao
	 */

	@Override
	public ArrayList<Bref> trouver_bref_croissant_unique(String identifiantMedecin, String identifiantPatient)
			throws DAOException {

		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		ArrayList<Bref> brefs = new ArrayList<Bref>();

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
				brefs.add(map(resultSet));
			}

		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			fermeturesSilencieuses(resultSet, preparedStatement, connexion);
		}

		return brefs;
	}

	/*
	 * Implémentation de la méthode trouver_bref_decroissant_unique() définie
	 * dans l'interface BrefDao
	 */

	@Override
	public ArrayList<Bref> trouver_bref_decroissant_unique(String identifiantMedecin, String identifiantPatient)
			throws DAOException {

		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		ArrayList<Bref> brefs = new ArrayList<Bref>();

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
				brefs.add(map(resultSet));
			}

		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			fermeturesSilencieuses(resultSet, preparedStatement, connexion);
		}

		return brefs;
	}

	/*
	 * Implémentation de la méthode trouver_bref_chrono_decroissant_unique()
	 * définie dans l'interface BrefDao
	 */

	@Override
	public ArrayList<Bref> trouver_bref_chrono_decroissant_unique(String identifiantMedecin, String identifiantPatient)
			throws DAOException {

		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		ArrayList<Bref> brefs = new ArrayList<Bref>();

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
				brefs.add(map(resultSet));
			}

		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			fermeturesSilencieuses(resultSet, preparedStatement, connexion);
		}

		return brefs;
	}

	/*
	 * Implémentation de la méthode trouver_bref_chrono_croissant() définie dans
	 * l'interface BrefDao
	 */

	@Override
	public ArrayList<Bref> trouver_bref_chrono_croissant(String identifiantMedecin) throws DAOException {

		return trouver_bref(SQL_SELECT_CHRONO_ASC, identifiantMedecin);
	}

	/*
	 * Implémentation de la méthode trouver_bref_chrono_decroissant() définie
	 * dans l'interface BrefDao
	 */

	@Override
	public ArrayList<Bref> trouver_bref_chrono_decroissant(String identifiantMedecin) throws DAOException {

		return trouver_bref(SQL_SELECT_CHRONO_DESC, identifiantMedecin);
	}

	/*
	 * Implémentation de la méthode trouver_bref_decroissant() définie dans
	 * l'interface BrefDao
	 */

	@Override
	public ArrayList<Bref> trouver_bref_decroissant(String identifiantMedecin) throws DAOException {

		return trouver_bref(SQL_SELECT_SCORE_DESC, identifiantMedecin);
	}

	/*
	 * Implémentation de la méthode trouver_bref_croissant() définie dans
	 * l'interface BrefDao
	 */

	@Override
	public ArrayList<Bref> trouver_bref_croissant(String identifiantMedecin) throws DAOException {

		return trouver_bref(SQL_SELECT_SCORE_ASC, identifiantMedecin);
	}

	private ArrayList<Bref> trouver_bref(String sql, Object objets) throws DAOException {

		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		ArrayList<Bref> brefs = new ArrayList<Bref>();

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
				brefs.add(map(resultSet));
			}

		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			fermeturesSilencieuses(resultSet, preparedStatement, connexion);
		}

		return brefs;

	}

	/*
	 * Simple méthode utilitaire permettant de faire la correspondance (le
	 * mapping) entre une ligne issue de la table des bref (un ResultSet) et un
	 * bean bref.
	 */

	private static Bref map(ResultSet resultSet) throws SQLException {

		Bref bref = new Bref();

		bref.setId_bref(resultSet.getLong("id_bref"));

		bref.setIdentifiant_medecin(resultSet.getString("identifiant_medecin"));

		bref.setIdentifiant_patient(resultSet.getString("identifiant_patient"));

		bref.setPrenoms_noms_medecin(resultSet.getString("prenoms_noms_medecin"));

		bref.setPrenoms_noms_patient(resultSet.getString("prenoms_noms_patient"));

		bref.setScoreEpreuveSimilitudes(resultSet.getInt("scoreEpreuveSimilitudes"));

		bref.setScoreEpreuveFluenceVerbale(resultSet.getInt("scoreEpreuveFluenceVerbale"));

		bref.setScoreComportementPrehension(resultSet.getInt("scoreComportementPrehension"));

		bref.setScoreSequencesMotricesLuria(resultSet.getInt("scoreSequencesMotricesLuria"));

		bref.setScoreEpreuveConsignesConflictuelles(resultSet.getInt("scoreEpreuveConsignesConflictuelles"));

		bref.setScoreEpreuveGoNoGo(resultSet.getInt("scoreEpreuveGoNoGo"));

		bref.setScoreTotalBref(resultSet.getInt("scoreTotalBref"));

		bref.setDate_heure_resultat_bref(resultSet.getTimestamp("date_heure_resultat_bref"));

		return bref;

	}

}
