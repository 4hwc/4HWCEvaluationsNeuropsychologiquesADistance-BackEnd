package enad.dao;

import static enad.dao.DAOUtilitaire.fermeturesSilencieuses;
import static enad.dao.DAOUtilitaire.initialisationRequetePreparee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import enad.beans.Medecin;
import enad.beans.PropositionSeance;
import enad.beans.Seance;

public class SeanceDaoImpl implements SeanceDao {

	private static final String SQL_INSERT = "INSERT INTO seance (titre_seance,plan_seance,date_realisation_seance,identifiant_medecin,prenoms_noms_medecin,identifiant_patient,heure_realisation_seance,heure_fin_seance,prenoms_noms_patient,affichage_date_realisation_seance,valid,date_heure_creation_seance) VALUES(?,?,?,?,?,?,?,?,?,?,'VALIDATION',NOW())";

	private static final String SQL_INSERT_DESSIN = "INSERT INTO testdessinsseancesvalideesjour (id_seancesvalidees) VALUE(?)";

	private static final String SQL_SELECT_PAR_IDENTIFIANTMED_VALIDATION = "SELECT id_seance,titre_seance,plan_seance,date_heure_creation_seance,identifiant_patient,date_realisation_seance,identifiant_medecin,prenoms_noms_medecin,heure_realisation_seance,heure_fin_seance,valid,prenoms_noms_patient,affichage_date_realisation_seance FROM seance WHERE valid ='VALIDATION' AND identifiant_medecin = ?";

	private static final String SQL_SELECT_PAR_IDENTIFIANTPAT_VALIDATION = "SELECT id_seance,titre_seance,plan_seance,date_heure_creation_seance,identifiant_patient,date_realisation_seance,identifiant_medecin,prenoms_noms_medecin,heure_realisation_seance,heure_fin_seance,valid,prenoms_noms_patient,affichage_date_realisation_seance FROM seance WHERE valid ='VALIDATION' AND identifiant_patient = ?";

	private static final String SQL_SELECT_PAR_IDENTIFIANTMED_VALIDEES = "SELECT id_seance,titre_seance,plan_seance,date_heure_creation_seance,identifiant_patient,date_realisation_seance,identifiant_medecin,prenoms_noms_medecin,heure_realisation_seance,heure_fin_seance,valid,prenoms_noms_patient,affichage_date_realisation_seance FROM seance WHERE valid ='VALIDEE' AND identifiant_medecin = ?";

	private static final String SQL_SELECT_PAR_IDENTIFIANTMED_VALIDEESRECENT = "SELECT id_seance,titre_seance,plan_seance,date_heure_creation_seance,identifiant_patient,date_realisation_seance,identifiant_medecin,prenoms_noms_medecin,heure_realisation_seance,heure_fin_seance,valid,prenoms_noms_patient,affichage_date_realisation_seance FROM seance WHERE valid ='VALIDEE' AND identifiant_medecin = ? ORDER BY date_realisation_seance DESC , heure_realisation_seance DESC ";

	private static final String SQL_SELECT_PAR_ID_VALIDEES = "SELECT id_seance,titre_seance,plan_seance,date_heure_creation_seance,identifiant_patient,date_realisation_seance,identifiant_medecin,prenoms_noms_medecin,heure_realisation_seance,heure_fin_seance,valid,prenoms_noms_patient,affichage_date_realisation_seance FROM seance WHERE valid ='VALIDEE' AND id_seance = ?";

	private static final String SQL_SELECT_PAR_IDEMED_IDPAT_VALIDEES = "SELECT id_seance,titre_seance,plan_seance,date_heure_creation_seance,identifiant_patient,date_realisation_seance,identifiant_medecin,prenoms_noms_medecin,heure_realisation_seance,heure_fin_seance,valid,prenoms_noms_patient,affichage_date_realisation_seance FROM seance WHERE valid ='VALIDEE' AND identifiant_medecin = ? AND identifiant_patient=?";

	private static final String SQL_SELECT_PAR_IDENTIFIANTPAT_VALIDEES = "SELECT id_seance,titre_seance,plan_seance,date_heure_creation_seance,identifiant_patient,date_realisation_seance,identifiant_medecin,prenoms_noms_medecin,heure_realisation_seance,heure_fin_seance,valid,prenoms_noms_patient,affichage_date_realisation_seance FROM seance WHERE valid ='VALIDEE' AND identifiant_patient = ?";

	private static final String SQL_SELECT_PAR_IDSEANCE = "SELECT * FROM seance WHERE valid ='VALIDATION' AND id_seance = ?";

	private static final String SQL_SELECT_ID = "SELECT * FROM seance WHERE  id_seance = ?";

	private static final String SQL_SELECT_PAR_IDSEANCE_VALIDEE = "SELECT id_seance,titre_seance,plan_seance,date_heure_creation_seance,identifiant_patient,date_realisation_seance,identifiant_medecin,prenoms_noms_medecin,heure_realisation_seance,heure_fin_seance,valid,prenoms_noms_patient,affichage_date_realisation_seance FROM seance WHERE valid ='VALIDEE' AND id_seance = ?";

	private DAOFactory daoFactory;

	SeanceDaoImpl(DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	/*
	 * Implémentation de la méthode clic_med_fcro() définie dans l'interface
	 * SeanceDao
	 */

	@Override
	public void clic_med_fcro(Long id) throws IllegalArgumentException, DAOException {

		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet valeursAutoGenerees = null;

		try {

			connexion = daoFactory.getConnection();

			preparedStatement = initialisationRequetePreparee(connexion,
					"UPDATE testdessinsseancesvalideesjour SET clic_med ='CLICMED',nom_test='FCRO' WHERE id_seancesvalidees = '"
							+ id + "'",
					true);

			int statut = preparedStatement.executeUpdate();

			if (statut == 0) {
				throw new DAOException(
						"Échec de la modification de null à CLICMED ,aucune ligne modifiée dans la table. ");
			}

		} catch (SQLException e) {

			throw new DAOException(e);

		} finally {

			fermeturesSilencieuses(valeursAutoGenerees, preparedStatement, connexion);

		}

	}

	/*
	 * Implémentation de la méthode clic_med_tm_un() définie dans l'interface
	 * SeanceDao
	 */

	@Override
	public void clic_med_tm_un(Long id) throws IllegalArgumentException, DAOException {

		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet valeursAutoGenerees = null;

		try {

			connexion = daoFactory.getConnection();

			preparedStatement = initialisationRequetePreparee(connexion,
					"UPDATE testdessinsseancesvalideesjour SET clic_med ='CLICMED',nom_test='TMUN' WHERE id_seancesvalidees = '"
							+ id + "'",
					true);

			int statut = preparedStatement.executeUpdate();

			if (statut == 0) {
				throw new DAOException(
						"Échec de la modification de null à CLICMED ,aucune ligne modifiée dans la table. ");
			}

		} catch (SQLException e) {

			throw new DAOException(e);

		} finally {

			fermeturesSilencieuses(valeursAutoGenerees, preparedStatement, connexion);

		}

	}

	/*
	 * Implémentation de la méthode clic_med_tm_deux() définie dans l'interface
	 * SeanceDao
	 */

	@Override
	public void clic_med_tm_deux(Long id) throws IllegalArgumentException, DAOException {

		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet valeursAutoGenerees = null;

		try {

			connexion = daoFactory.getConnection();

			preparedStatement = initialisationRequetePreparee(connexion,
					"UPDATE testdessinsseancesvalideesjour SET clic_med ='CLICMED',nom_test='TMDEUX' WHERE id_seancesvalidees = '"
							+ id + "'",
					true);

			int statut = preparedStatement.executeUpdate();

			if (statut == 0) {
				throw new DAOException(
						"Échec de la modification de null à CLICMED ,aucune ligne modifiée dans la table. ");
			}

		} catch (SQLException e) {

			throw new DAOException(e);

		} finally {

			fermeturesSilencieuses(valeursAutoGenerees, preparedStatement, connexion);

		}

	}

	/*
	 * Implémentation de la méthode clic_pat_fcro() définie dans l'interface
	 * SeanceDao
	 */

	@Override
	public void clic_pat_fcro(Long id) throws IllegalArgumentException, DAOException {

		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet valeursAutoGenerees = null;

		try {

			connexion = daoFactory.getConnection();

			preparedStatement = initialisationRequetePreparee(connexion,
					"UPDATE testdessinsseancesvalideesjour SET clic_pat ='CLICPAT' WHERE nom_test='FCRO' AND id_seancesvalidees = '"
							+ id + "'",
					true);

			int statut = preparedStatement.executeUpdate();

			if (statut == 0) {
				throw new DAOException(
						"Échec de la modification de null à CLICPAT ,aucune ligne modifiée dans la table. ");
			}

		} catch (SQLException e) {

			throw new DAOException(e);

		} finally {

			fermeturesSilencieuses(valeursAutoGenerees, preparedStatement, connexion);

		}

	}

	/*
	 * Implémentation de la méthode clic_pat_tm_un() définie dans l'interface
	 * SeanceDao
	 */

	@Override
	public void clic_pat_tm_un(Long id) throws IllegalArgumentException, DAOException {

		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet valeursAutoGenerees = null;

		try {

			connexion = daoFactory.getConnection();

			preparedStatement = initialisationRequetePreparee(connexion,
					"UPDATE testdessinsseancesvalideesjour SET clic_pat ='CLICPAT' WHERE nom_test='TMUN' AND id_seancesvalidees = '"
							+ id + "'",
					true);

			int statut = preparedStatement.executeUpdate();

			if (statut == 0) {
				throw new DAOException(
						"Échec de la modification de null à CLICPAT ,aucune ligne modifiée dans la table. ");
			}

		} catch (SQLException e) {

			throw new DAOException(e);

		} finally {

			fermeturesSilencieuses(valeursAutoGenerees, preparedStatement, connexion);

		}

	}

	/*
	 * Implémentation de la méthode clic_pat_tm_deux() définie dans l'interface
	 * SeanceDao
	 */

	@Override
	public void clic_pat_tm_deux(Long id) throws IllegalArgumentException, DAOException {

		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet valeursAutoGenerees = null;

		try {

			connexion = daoFactory.getConnection();

			preparedStatement = initialisationRequetePreparee(connexion,
					"UPDATE testdessinsseancesvalideesjour SET clic_pat ='CLICPAT' WHERE nom_test='TMDEUX' AND id_seancesvalidees = '"
							+ id + "'",
					true);

			int statut = preparedStatement.executeUpdate();

			if (statut == 0) {
				throw new DAOException(
						"Échec de la modification de null à CLICPAT ,aucune ligne modifiée dans la table. ");
			}

		} catch (SQLException e) {

			throw new DAOException(e);

		} finally {

			fermeturesSilencieuses(valeursAutoGenerees, preparedStatement, connexion);

		}

	}

	/*
	 * Implémentation de la méthode validee_ou_pas() définie dans l'interface
	 * SeanceDao
	 */

	@Override
	public int validee_ou_pas(Long id) throws DAOException {

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
					"SELECT id_seance,titre_seance,plan_seance,date_heure_creation_seance,identifiant_patient,date_realisation_seance,identifiant_medecin,prenoms_noms_medecin,heure_realisation_seance,heure_fin_seance,valid,prenoms_noms_patient,affichage_date_realisation_seance FROM seance WHERE valid ='VALIDEE' AND id_seance = '"
							+ id + "'",
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
	 * Implémentation de la méthode clic_patient_ou_pas() définie dans
	 * l'interface SeanceDao
	 */

	@Override
	public int clic_patient_ou_pas(Long id) throws DAOException {

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
					"SELECT * FROM testdessinsseancesvalideesjour WHERE clic_pat ='CLICPAT' AND nom_test='FCRO' AND id_seancesvalidees = '"
							+ id + "'",
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
	 * Implémentation de la méthode clic_patient_ou_pas_tm_un() définie dans
	 * l'interface SeanceDao
	 */

	@Override
	public int clic_patient_ou_pas_tm_un(Long id) throws DAOException {

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
					"SELECT * FROM testdessinsseancesvalideesjour WHERE clic_pat ='CLICPAT' AND nom_test='TMUN' AND id_seancesvalidees = '"
							+ id + "'",
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
	 * Implémentation de la méthode clic_patient_ou_pas_tm_deux() définie dans
	 * l'interface SeanceDao
	 */

	@Override
	public int clic_patient_ou_pas_tm_deux(Long id) throws DAOException {

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
					"SELECT * FROM testdessinsseancesvalideesjour WHERE clic_pat ='CLICPAT' AND nom_test='TMDEUX' AND id_seancesvalidees = '"
							+ id + "'",
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
	 * Implémentation de la méthode clic_med_fcro_ou_pas() définie dans
	 * l'interface SeanceDao
	 */

	@Override
	public int clic_med_fcro_ou_pas(Long id) throws DAOException {

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
					"SELECT * FROM testdessinsseancesvalideesjour WHERE clic_med ='CLICMED' AND nom_test='FCRO' AND id_seancesvalidees = '"
							+ id + "'",
					true);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				compteur++;// 1 car id unique

			}

		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			fermeturesSilencieuses(resultSet, preparedStatement, connexion);
		}

		return compteur;

	}

	/*
	 * Implémentation de la méthode clic_med_tm_un_ou_pas() définie dans
	 * l'interface SeanceDao
	 */

	@Override
	public int clic_med_tm_un_ou_pas(Long id) throws DAOException {

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
					"SELECT * FROM testdessinsseancesvalideesjour WHERE clic_med ='CLICMED' AND nom_test='TMUN' AND id_seancesvalidees = '"
							+ id + "'",
					true);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				compteur++;// 1 car id unique

			}

		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			fermeturesSilencieuses(resultSet, preparedStatement, connexion);
		}

		return compteur;

	}

	/*
	 * Implémentation de la méthode clic_med_tm_deux_ou_pas() définie dans
	 * l'interface SeanceDao
	 */

	@Override
	public int clic_med_tm_deux_ou_pas(Long id) throws DAOException {

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
					"SELECT * FROM testdessinsseancesvalideesjour WHERE clic_med ='CLICMED' AND nom_test='TMDEUX' AND id_seancesvalidees = '"
							+ id + "'",
					true);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				compteur++;// 1 car id unique

			}

		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			fermeturesSilencieuses(resultSet, preparedStatement, connexion);
		}

		return compteur;

	}

	/*
	 * Implémentation de la méthode creer() définie dans l'interface SeanceDao
	 */

	@Override
	public void creer(Medecin medecin, Seance seance, PatientDao patientDao)
			throws IllegalArgumentException, DAOException {

		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet valeursAutoGenerees = null;

		try {

			connexion = daoFactory.getConnection();
			preparedStatement = initialisationRequetePreparee(connexion, SQL_INSERT, true, seance.getTitre_seance(),
					seance.getPlan_seance(), seance.getDate_realisation_seance(), medecin.getIdentifiant_medecin(),
					medecin.getPrenoms_medecin() + " " + medecin.getNoms_medecin(), seance.getIdentifiant_patient(),
					seance.getHeure_realisation_seance(), seance.getHeure_fin_seance(),
					patientDao.trouver(seance.getIdentifiant_patient()).getPrenoms_patient() + " "
							+ patientDao.trouver(seance.getIdentifiant_patient()).getNoms_patient(),
					seance.getAffichage_date_realisation_seance());

			int statut = preparedStatement.executeUpdate();

			if (statut == 0) {
				throw new DAOException("Échec de la création de la séance,aucune ligne ajoutée dans la table. ");
			}

			valeursAutoGenerees = preparedStatement.getGeneratedKeys();

			if (valeursAutoGenerees.next()) {

				seance.setId_seance(valeursAutoGenerees.getLong(1));

			} else {
				throw new DAOException("Échec de la création de la séance  en base,aucun ID auto-généré retourné.");
			}

		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {

			fermeturesSilencieuses(valeursAutoGenerees, preparedStatement, connexion);
		}

	}

	/*
	 * Implémentation de la méthode realisationdessinjour() définie dans
	 * l'interface SeanceDao
	 */

	@Override
	public void realisationdessinjour(Seance seance) throws IllegalArgumentException, DAOException {

		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet valeursAutoGenerees = null;

		try {

			connexion = daoFactory.getConnection();
			preparedStatement = initialisationRequetePreparee(connexion, SQL_INSERT_DESSIN, true,
					seance.getId_seance());

			int statut = preparedStatement.executeUpdate();

			if (statut == 0) {
				throw new DAOException(
						"Échec de la création de la séance validée,aucune ligne ajoutée dans la table. ");
			}

			valeursAutoGenerees = preparedStatement.getGeneratedKeys();

			if (valeursAutoGenerees.next()) {

			} else {
				throw new DAOException(
						"Échec de la création de la séance validée  en base,aucun ID auto-généré retourné.");
			}

		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {

			fermeturesSilencieuses(valeursAutoGenerees, preparedStatement, connexion);
		}

	}

	/*
	 * Implémentation de la méthode DeValidationAValidee() définie dans
	 * l'interface SeanceDao
	 */

	@Override
	public void DeValidationAValidee(PropositionSeance propseance, Long id)
			throws IllegalArgumentException, DAOException {

		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet valeursAutoGenerees = null;

		try {

			connexion = daoFactory.getConnection();

			preparedStatement = initialisationRequetePreparee(connexion,
					"UPDATE seance SET date_heure_creation_seance = '"
							+ propseance.getDate_heure_creation_seance_proposition() + "' , date_realisation_seance = '"
							+ propseance.getDate_realisation_seance_proposition() + "',heure_realisation_seance = '"
							+ propseance.getHeure_realisation_seance_proposition() + "',heure_fin_seance = '"
							+ propseance.getHeure_fin_seance_proposition() + "',affichage_date_realisation_seance = '"
							+ propseance.getAffichage_date_realisation_seance_proposition()
							+ "',valid = 'VALIDEE' WHERE id_seance = '" + id + "'",
					true);

			int statut = preparedStatement.executeUpdate();

			if (statut == 0) {
				throw new DAOException(
						"Échec du passage de validation à validée,aucune ligne modifiée dans la table. ");
			}

		} catch (SQLException e) {

			throw new DAOException(e);

		} finally {

			fermeturesSilencieuses(valeursAutoGenerees, preparedStatement, connexion);

		}

	}

	/*
	 * Implémentation de la méthode DeValidationAValidee() définie dans
	 * l'interface SeanceDao
	 */

	@Override
	public void DeValidationAValidee(Long id) throws IllegalArgumentException, DAOException {

		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet valeursAutoGenerees = null;

		try {

			connexion = daoFactory.getConnection();

			preparedStatement = initialisationRequetePreparee(connexion,
					"UPDATE seance SET valid = 'VALIDEE' WHERE id_seance = '" + id + "'",

					true);

			int statut = preparedStatement.executeUpdate();

			if (statut == 0) {
				throw new DAOException(
						"Échec du passage de validation à validée,aucune ligne modifiée dans la table. ");
			}

		} catch (SQLException e) {

			throw new DAOException(e);

		} finally {

			fermeturesSilencieuses(valeursAutoGenerees, preparedStatement, connexion);

		}

	}

	/*
	 * Implémentation de la méthode supprimer() définie dans l'interface
	 * SeanceDao
	 */

	@Override
	public void supprimer(Long id) throws IllegalArgumentException, DAOException {

		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet valeursAutoGenerees = null;

		try {

			connexion = daoFactory.getConnection();

			preparedStatement = initialisationRequetePreparee(connexion,
					"DELETE FROM seance WHERE id_seance = '" + id + "'", true);

			int statut = preparedStatement.executeUpdate();

			if (statut == 0) {
				throw new DAOException("Échec de la suppression de la séance ");
			}

		} catch (SQLException e) {

			throw new DAOException(e);

		} finally {

			fermeturesSilencieuses(valeursAutoGenerees, preparedStatement, connexion);

		}

	}

	/*
	 * Implémentation de la méthode supprimer_dessin() définie dans l'interface
	 * SeanceDao
	 */

	@Override
	public void supprimer_dessin(Long id_seance) throws IllegalArgumentException, DAOException {

		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet valeursAutoGenerees = null;

		try {

			connexion = daoFactory.getConnection();

			preparedStatement = initialisationRequetePreparee(connexion,
					"DELETE FROM testdessinsseancesvalideesjour WHERE id_seancesvalidees = '" + id_seance + "'", true);

			int statut = preparedStatement.executeUpdate();

			if (statut == 0) {
				throw new DAOException("Échec de la suppression de la séance validée ");
			}

		} catch (SQLException e) {

			throw new DAOException(e);

		} finally {

			fermeturesSilencieuses(valeursAutoGenerees, preparedStatement, connexion);

		}

	}

	/*
	 * Implémentation de la méthode trouver_medecin_validation() définie dans
	 * l'interface SeanceDao
	 */

	@Override
	public ArrayList<Seance> trouver_medecin_validation(String identifiantMedecin) throws DAOException {

		return trouver_medecin_validation(SQL_SELECT_PAR_IDENTIFIANTMED_VALIDATION, identifiantMedecin);
	}

	private ArrayList<Seance> trouver_medecin_validation(String sql, Object objets) throws DAOException {

		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		ArrayList<Seance> seances = new ArrayList<Seance>();

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
				seances.add(map(resultSet));
			}

		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			fermeturesSilencieuses(resultSet, preparedStatement, connexion);
		}

		return seances;

	}

	/*
	 * Implémentation de la méthode trouver_patient_validation() définie dans
	 * l'interface SeanceDao
	 */

	@Override
	public ArrayList<Seance> trouver_patient_validation(String identifiantPatient) throws DAOException {

		return trouver_patient_validation(SQL_SELECT_PAR_IDENTIFIANTPAT_VALIDATION, identifiantPatient);
	}

	private ArrayList<Seance> trouver_patient_validation(String sql, Object objets) throws DAOException {

		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		ArrayList<Seance> seances = new ArrayList<Seance>();

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
				seances.add(map(resultSet));
			}

		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			fermeturesSilencieuses(resultSet, preparedStatement, connexion);
		}

		return seances;

	}

	/*
	 * Implémentation de la méthode trouver_medecin_validees() définie dans
	 * l'interface SeanceDao
	 */

	@Override
	public ArrayList<Seance> trouver_medecin_validees(String identifiantMedecin) throws DAOException {

		return trouver_medecin_validees(SQL_SELECT_PAR_IDENTIFIANTMED_VALIDEES, identifiantMedecin);
	}

	/*
	 * Implémentation de la méthode
	 * trouver_medecin_validees_recent_auplusvieux() définie dans l'interface
	 * SeanceDao
	 */

	@Override
	public ArrayList<Seance> trouver_medecin_validees_recent_auplusvieux(String identifiantMedecin)
			throws DAOException {

		return trouver_medecin_validees(SQL_SELECT_PAR_IDENTIFIANTMED_VALIDEESRECENT, identifiantMedecin);
	}

	private ArrayList<Seance> trouver_medecin_validees(String sql, Object objets) throws DAOException {

		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		ArrayList<Seance> seances = new ArrayList<Seance>();

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
				seances.add(map(resultSet));
			}

		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			fermeturesSilencieuses(resultSet, preparedStatement, connexion);
		}

		return seances;

	}

	/*
	 * Implémentation de la méthode trouver_validees() définie dans l'interface
	 * SeanceDao
	 */

	@Override
	public Seance trouver_validees(Long id) throws DAOException {

		return trouver_validees(SQL_SELECT_PAR_ID_VALIDEES, id);
	}

	private Seance trouver_validees(String sql, Object objets) throws DAOException {

		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		Seance seance = new Seance();

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
				seance = map(resultSet);
			}

		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			fermeturesSilencieuses(resultSet, preparedStatement, connexion);
		}

		return seance;

	}

	/*
	 * Implémentation de la méthode trouver_seances_validees() définie dans
	 * l'interface SeanceDao
	 */

	@Override
	public ArrayList<Seance> trouver_seances_validees(String identifiantMedecin, String identifiantPatient)
			throws DAOException {

		return trouver_seances_validees(SQL_SELECT_PAR_IDEMED_IDPAT_VALIDEES, identifiantMedecin, identifiantPatient);
	}

	private ArrayList<Seance> trouver_seances_validees(String sql, Object... objets) throws DAOException {

		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		ArrayList<Seance> seances = new ArrayList<Seance>();

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
				seances.add(map(resultSet));
			}

		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			fermeturesSilencieuses(resultSet, preparedStatement, connexion);
		}

		return seances;

	}

	/*
	 * Implémentation de la méthode trouver_patient_validees() définie dans
	 * l'interface SeanceDao
	 */

	@Override
	public ArrayList<Seance> trouver_patient_validees(String identifiantPatient) throws DAOException {

		return trouver_patient_validees(SQL_SELECT_PAR_IDENTIFIANTPAT_VALIDEES, identifiantPatient);
	}

	private ArrayList<Seance> trouver_patient_validees(String sql, Object objets) throws DAOException {

		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		ArrayList<Seance> seances = new ArrayList<Seance>();

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
				seances.add(map(resultSet));
			}

		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			fermeturesSilencieuses(resultSet, preparedStatement, connexion);
		}

		return seances;

	}

	/*
	 * Implémentation de la méthode trouver() définie dans l'interface SeanceDao
	 */

	@Override
	public Seance trouver(Long idSeance) throws DAOException {

		return trouver(SQL_SELECT_PAR_IDSEANCE, idSeance);

	}

	private Seance trouver(String sql, Object objets) throws DAOException {

		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		Seance seance = new Seance();

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
				seance = map(resultSet);
			}

		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			fermeturesSilencieuses(resultSet, preparedStatement, connexion);
		}

		return seance;

	}

	/*
	 * Implémentation de la méthode trouver_seance_de_cet_id() définie dans
	 * l'interface SeanceDao
	 */

	@Override
	public Seance trouver_seance_de_cet_id(Long idSeance) throws DAOException {

		return trouver_seance_de_cet_id(SQL_SELECT_ID, idSeance);

	}

	private Seance trouver_seance_de_cet_id(String sql, Object objets) throws DAOException {

		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		Seance seance = new Seance();

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
				seance = map(resultSet);
			}

		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			fermeturesSilencieuses(resultSet, preparedStatement, connexion);
		}

		return seance;

	}

	/*
	 * Implémentation de la méthode trouverValidee() définie dans l'interface
	 * SeanceDao
	 */

	@Override
	public Seance trouverValidee(Long idSeance) throws DAOException {

		return trouverValidee(SQL_SELECT_PAR_IDSEANCE_VALIDEE, idSeance);

	}

	private Seance trouverValidee(String sql, Object objets) throws DAOException {

		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		Seance seance = new Seance();

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
				seance = map(resultSet);
			}

		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			fermeturesSilencieuses(resultSet, preparedStatement, connexion);
		}

		return seance;

	}

	/*
	 * Simple méthode utilitaire permettant de faire la correspondance (le
	 * mapping) entre une ligne issue de la table des séances (un ResultSet) et
	 * un bean Seance.
	 */

	private static Seance map(ResultSet resultSet) throws SQLException {

		Seance seance = new Seance();

		seance.setId_seance(resultSet.getLong("id_seance"));

		seance.setTitre_seance(resultSet.getString("titre_seance"));

		seance.setPlan_seance(resultSet.getString("plan_seance"));

		seance.setDate_heure_creation_seance(resultSet.getTimestamp("date_heure_creation_seance"));

		seance.setIdentifiant_patient(resultSet.getString("identifiant_patient"));

		seance.setIdentifiant_medecin(resultSet.getString("identifiant_medecin"));

		seance.setDate_realisation_seance(resultSet.getDate("date_realisation_seance"));

		seance.setHeure_realisation_seance(resultSet.getTime("heure_realisation_seance"));

		seance.setHeure_fin_seance(resultSet.getTime("heure_fin_seance"));

		seance.setValid(resultSet.getString("valid"));

		seance.setAffichage_date_realisation_seance(resultSet.getString("affichage_date_realisation_seance"));

		seance.setPrenoms_noms_patient(resultSet.getString("prenoms_noms_patient"));

		seance.setPrenoms_noms_medecin(resultSet.getString("prenoms_noms_medecin"));

		return seance;

	}

}
