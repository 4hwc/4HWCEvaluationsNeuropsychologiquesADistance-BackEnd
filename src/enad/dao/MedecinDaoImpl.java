/**
 * 
 */
package enad.dao;

import static enad.dao.DAOUtilitaire.fermeturesSilencieuses;
import static enad.dao.DAOUtilitaire.initialisationRequetePreparee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import enad.beans.Medecin;
import enad.beans.Patient;

/**
 * @author Admin
 *
 */
public class MedecinDaoImpl implements MedecinDao {

	private static final String SQL_REL_PAT = "SELECT identifiant_pat FROM relations_med_pat WHERE identifiant_med = ? ";

	private static final String SQL_REL_MED1 = "SELECT identifiant_med1 FROM relations_med_med WHERE identifiant_med2 = ? ";

	private static final String SQL_REL_MED2 = "SELECT identifiant_med2 FROM relations_med_med WHERE identifiant_med1 = ?";

	private static final String SQL_MEDECINS = "SELECT id_medecin,identifiant_medecin,noms_medecin,prenoms_medecin,mdp_medecin,date_heure_inscription_medecin  FROM medecin";

	private static final String SQL_INSERT = "INSERT INTO medecin (identifiant_medecin,noms_medecin,prenoms_medecin,mdp_medecin,date_heure_inscription_medecin) VALUES(?,?,?,?,NOW())";

	private static final String SQL_INSERT_IP = "INSERT INTO medecin_ip (id_med,ip_med) VALUES(?,?)";

	private static final String SQL_INSERT_MED_MED = "INSERT INTO relations_med_med (identifiant_med1,identifiant_med2,date_heure_relation) VALUES(?,?,NOW())";

	private static final String SQL_INSERT_MEDT_PAT = "INSERT INTO relations_medtraitant_patient (identifiant_med,identifiant_pat,date_heure_mise_en_relation) VALUES(?,?,NOW())";

	private static final String SQL_INSERT_MED_PAT = "INSERT INTO relations_med_pat (identifiant_med,identifiant_pat,date_heure_relation) VALUES(?,?,NOW())";

	private static final String SQL_INSERT_VAL_MED_MED = "INSERT INTO validations_relations_med_med (ide_em,ide_dest,date_heure_relation) VALUES(?,?,NOW())";

	private static final String SQL_INSERT_VAL_MEDT_PAT = "INSERT INTO validations_relations_medtraitant_patient (ide_em,ide_dest,date_heure,type_em,type_dest) VALUES(?,?,NOW(),'P','M')";

	private static final String SQL_INSERT_VAL_MED_PAT = "INSERT INTO validations_relations_med_pat (identifiant_em,identifiant_dest,date_heure_creation,type_em,type_dest) VALUES(?,?,NOW(),'P','M')";

	private static final String SQL_INSERT_IP_USER = "INSERT INTO utilisateur_ip (id_user,ip_user,type_user) VALUES(?,?,'M')";

	private static final String SQL_SELECT_PAR_IDENTIFIANT_MEDECIN = "SELECT id_medecin,identifiant_medecin,noms_medecin,prenoms_medecin,mdp_medecin,url_photo_medecin,date_heure_inscription_medecin FROM medecin WHERE identifiant_medecin = ?";

	private static final String SQL_SELECT_PAR_IP_MEDECIN = "SELECT id_user_ip,id_user,ip_user,type_user FROM utilisateur_ip WHERE ip_user = ?";

	private static final String SQL_SELECT_PAR_IDENTIFIANT_MEDECIN_MED_PAT = "SELECT identifiant_pat FROM relations_med_pat WHERE identifiant_med = ?";

	private static final String SQL_SELECT_PAR_IDENTIFIANT_MEDECIN_MEDTRAITANT_PAT = "SELECT identifiant_pat FROM relations_medtraitant_patient WHERE identifiant_med = ?";

	private static final String SQL_SELECT_PAR_NOMS_MEDECIN = "SELECT id_medecin,identifiant_medecin,noms_medecin,prenoms_medecin,mdp_medecin,date_heure_inscription_medecin  FROM medecin WHERE noms_medecin = ?";

	private static final String SQL_SELECT_PAR_PRENOMS_MEDECIN = "SELECT id_medecin,identifiant_medecin,noms_medecin,prenoms_medecin,mdp_medecin,date_heure_inscription_medecin FROM medecin WHERE prenoms_medecin = ?";

	private DAOFactory daoFactory;

	MedecinDaoImpl(DAOFactory daoFactory) {
		this.daoFactory = daoFactory;

	}

	/*
	 * Implémentation de la méthode trouver_identifiantspat_relmedpat() définie
	 * dans l'interface MedecinDao
	 */

	@Override
	public ArrayList<String> trouver_identifiantspat_relmedpat(String identifiantmed) throws DAOException {

		return trouver_identifiantspat_relmedpat(SQL_REL_PAT, identifiantmed);
	}

	private ArrayList<String> trouver_identifiantspat_relmedpat(String sql, Object objets) throws DAOException {

		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		ArrayList<String> identifiants = new ArrayList<String>();

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
				identifiants.add(resultSet.getString("identifiant_pat"));
			}

		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			fermeturesSilencieuses(resultSet, preparedStatement, connexion);
		}

		return identifiants;

	}

	/*
	 * Implémentation de la méthode trouver_identifiantmeddeux() définie dans
	 * l'interface MedecinDao
	 */

	@Override
	public ArrayList<String> trouver_identifiantmeddeux(String identifiantmedun) throws DAOException {

		return trouver_identifiantmeddeux(SQL_REL_MED2, identifiantmedun);
	}

	private ArrayList<String> trouver_identifiantmeddeux(String sql, Object objets) throws DAOException {

		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		ArrayList<String> identifiants = new ArrayList<String>();

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
				identifiants.add(resultSet.getString("identifiant_med2"));
			}

		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			fermeturesSilencieuses(resultSet, preparedStatement, connexion);
		}

		return identifiants;

	}

	/*
	 * Implémentation de la méthode trouver_identifiantmedun() définie dans
	 * l'interface MedecinDao
	 */

	@Override
	public ArrayList<String> trouver_identifiantmedun(String identifiantmeddeux) throws DAOException {

		return trouver_identifiantmedun(SQL_REL_MED1, identifiantmeddeux);
	}

	private ArrayList<String> trouver_identifiantmedun(String sql, Object objets) throws DAOException {

		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		ArrayList<String> identifiants = new ArrayList<String>();

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
				identifiants.add(resultSet.getString("identifiant_med1"));
			}

		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			fermeturesSilencieuses(resultSet, preparedStatement, connexion);
		}

		return identifiants;

	}

	/*
	 * Implémentation de la méthode trouver_noms() définie dans l'interface
	 * MedecinDao
	 */

	@Override
	public ArrayList<Medecin> trouver_noms(String nomsMedecin) throws DAOException {

		return trouver_noms(SQL_SELECT_PAR_NOMS_MEDECIN, nomsMedecin);
	}

	private ArrayList<Medecin> trouver_noms(String sql, Object objets) throws DAOException {

		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		ArrayList<Medecin> medecins = new ArrayList<Medecin>();

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
				medecins.add(map(resultSet));
			}

		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			fermeturesSilencieuses(resultSet, preparedStatement, connexion);
		}

		return medecins;

	}

	/*
	 * Implémentation de la méthode trouver_prenoms() définie dans l'interface
	 * MedecinDao
	 */

	@Override
	public ArrayList<Medecin> trouver_prenoms(String prenomsMedecin) throws DAOException {

		return trouver_prenoms(SQL_SELECT_PAR_PRENOMS_MEDECIN, prenomsMedecin);
	}

	private ArrayList<Medecin> trouver_prenoms(String sql, Object objets) throws DAOException {

		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		ArrayList<Medecin> medecins = new ArrayList<Medecin>();

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
				medecins.add(map(resultSet));
			}

		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			fermeturesSilencieuses(resultSet, preparedStatement, connexion);
		}

		return medecins;

	}

	/*
	 * Implémentation de la méthode TousLesMedecins() définie dans l'interface
	 * MedecinDao
	 */

	@Override
	public ArrayList<Medecin> TousLesMedecins() throws DAOException {

		return tousLesMedecins(SQL_MEDECINS);
	}

	private ArrayList<Medecin> tousLesMedecins(String sql) throws DAOException {

		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		ArrayList<Medecin> medecins = new ArrayList<Medecin>();

		try {

			/* Récupération d'une connexion depuis la Factory */
			connexion = daoFactory.getConnection();

			preparedStatement = initialisationRequetePreparee(connexion, sql, true);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				medecins.add(map(resultSet));
			}

		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			fermeturesSilencieuses(resultSet, preparedStatement, connexion);
		}

		return medecins;

	}

	/*
	 * Implémentation de la méthode creer_ip() définie dans l'interface
	 * MedecinDao
	 */
	@Override
	public void creer_ip(Medecin medecin) throws IllegalArgumentException, DAOException {

		Connection connexion = null;
		PreparedStatement preparedStatement1 = null;
		ResultSet valeursAutoGenerees1 = null;
		PreparedStatement preparedStatement2 = null;
		ResultSet valeursAutoGenerees2 = null;

		try {

			connexion = daoFactory.getConnection();
			preparedStatement1 = initialisationRequetePreparee(connexion, SQL_INSERT_IP, true, medecin.getId_medecin(),
					medecin.getIp_medecin());

			preparedStatement2 = initialisationRequetePreparee(connexion, SQL_INSERT_IP_USER, true,
					medecin.getId_medecin(), medecin.getIp_medecin());

			int statut1 = preparedStatement1.executeUpdate();

			int statut2 = preparedStatement2.executeUpdate();

			if (statut1 == 0) {
				throw new DAOException("Échec de la création de l'ip du médecin,aucune ligne ajoutée dans la table. ");
			}

			if (statut2 == 0) {
				throw new DAOException(
						"Échec de l'ajout de l'ip du médecin dans la table utilisateur_ip,aucune ligne ajoutée dans la table. ");
			}

			valeursAutoGenerees1 = preparedStatement1.getGeneratedKeys();

			valeursAutoGenerees2 = preparedStatement2.getGeneratedKeys();

			if (valeursAutoGenerees1.next()) {

			} else {
				throw new DAOException(
						"Échec de l'attribution de l'ip au médecin en base,aucun ID auto-généré retourné.");
			}

			if (valeursAutoGenerees2.next()) {

			} else {
				throw new DAOException(
						"Échec de l'attribution de l'ip au médecin en base utilisateur_ip,aucun ID auto-généré retourné.");
			}

		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {

			fermeturesSilencieuses(valeursAutoGenerees1, preparedStatement1, connexion);
			fermeturesSilencieuses(valeursAutoGenerees2, preparedStatement2, connexion);
		}

	}

	/*
	 * Implémentation de la méthode creer_relation_med_med() définie dans
	 * l'interface MedecinDao
	 */
	@Override
	public void creer_relation_med_med(String identifiant1, String identifiant2)
			throws IllegalArgumentException, DAOException {

		Connection connexion = null;
		PreparedStatement preparedStatement1 = null;
		ResultSet valeursAutoGenerees1 = null;

		try {

			connexion = daoFactory.getConnection();
			preparedStatement1 = initialisationRequetePreparee(connexion, SQL_INSERT_MED_MED, true, identifiant1,
					identifiant2);

			int statut1 = preparedStatement1.executeUpdate();

			if (statut1 == 0) {
				throw new DAOException(
						"Échec de la création de la relation med med,aucune ligne ajoutée dans la table. ");
			}

			valeursAutoGenerees1 = preparedStatement1.getGeneratedKeys();

			if (valeursAutoGenerees1.next()) {

			} else {
				throw new DAOException("Échec ,aucun ID auto-généré retourné.");
			}

		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {

			fermeturesSilencieuses(valeursAutoGenerees1, preparedStatement1, connexion);

		}

	}

	/*
	 * Implémentation de la méthode creer_relation_medt_pat() définie dans
	 * l'interface MedecinDao
	 */
	@Override
	public void creer_relation_medt_pat(String identifiantmed, String identifiantpat)
			throws IllegalArgumentException, DAOException {

		Connection connexion = null;
		PreparedStatement preparedStatement1 = null;
		ResultSet valeursAutoGenerees1 = null;

		try {

			connexion = daoFactory.getConnection();
			preparedStatement1 = initialisationRequetePreparee(connexion, SQL_INSERT_MEDT_PAT, true, identifiantmed,
					identifiantpat);

			int statut1 = preparedStatement1.executeUpdate();

			if (statut1 == 0) {
				throw new DAOException(
						"Échec de la création de la relation medt pat,aucune ligne ajoutée dans la table. ");
			}

			valeursAutoGenerees1 = preparedStatement1.getGeneratedKeys();

			if (valeursAutoGenerees1.next()) {

			} else {
				throw new DAOException("Échec ,aucun ID auto-généré retourné.");
			}

		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {

			fermeturesSilencieuses(valeursAutoGenerees1, preparedStatement1, connexion);

		}

	}

	/*
	 * Implémentation de la méthode creer_relation_med_pat() définie dans
	 * l'interface MedecinDao
	 */
	@Override
	public void creer_relation_med_pat(String identifiantmed, String identifiantpat)
			throws IllegalArgumentException, DAOException {

		Connection connexion = null;
		PreparedStatement preparedStatement1 = null;
		ResultSet valeursAutoGenerees1 = null;

		try {

			connexion = daoFactory.getConnection();
			preparedStatement1 = initialisationRequetePreparee(connexion, SQL_INSERT_MED_PAT, true, identifiantmed,
					identifiantpat);

			int statut1 = preparedStatement1.executeUpdate();

			if (statut1 == 0) {
				throw new DAOException(
						"Échec de la création de la relation med pat,aucune ligne ajoutée dans la table. ");
			}

			valeursAutoGenerees1 = preparedStatement1.getGeneratedKeys();

			if (valeursAutoGenerees1.next()) {

			} else {
				throw new DAOException("Échec ,aucun ID auto-généré retourné.");
			}

		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {

			fermeturesSilencieuses(valeursAutoGenerees1, preparedStatement1, connexion);

		}

	}

	/*
	 * Implémentation de la méthode creer_val_relation_med_med() définie dans
	 * l'interface MedecinDao
	 */
	@Override
	public void creer_val_relation_med_med(String identifiant_em, String identifiant_dest)
			throws IllegalArgumentException, DAOException {

		Connection connexion = null;
		PreparedStatement preparedStatement1 = null;
		ResultSet valeursAutoGenerees1 = null;

		try {

			connexion = daoFactory.getConnection();
			preparedStatement1 = initialisationRequetePreparee(connexion, SQL_INSERT_VAL_MED_MED, true, identifiant_em,
					identifiant_dest);

			int statut1 = preparedStatement1.executeUpdate();

			if (statut1 == 0) {
				throw new DAOException(
						"Échec de la création de la validation med med,aucune ligne ajoutée dans la table. ");
			}

			valeursAutoGenerees1 = preparedStatement1.getGeneratedKeys();

			if (valeursAutoGenerees1.next()) {

			} else {
				throw new DAOException("Échec ,aucun ID auto-généré retourné.");
			}

		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {

			fermeturesSilencieuses(valeursAutoGenerees1, preparedStatement1, connexion);

		}

	}

	/*
	 * Implémentation de la méthode creer_val_relation_medt_pat() définie dans
	 * l'interface MedecinDao
	 */
	@Override
	public void creer_val_relation_medt_pat(String identifiant_em, String identifiant_dest)
			throws IllegalArgumentException, DAOException {

		Connection connexion = null;
		PreparedStatement preparedStatement1 = null;
		ResultSet valeursAutoGenerees1 = null;

		try {

			connexion = daoFactory.getConnection();
			preparedStatement1 = initialisationRequetePreparee(connexion, SQL_INSERT_VAL_MEDT_PAT, true, identifiant_em,
					identifiant_dest);

			int statut1 = preparedStatement1.executeUpdate();

			if (statut1 == 0) {
				throw new DAOException(
						"Échec de la création de la validation medt pat,aucune ligne ajoutée dans la table. ");
			}

			valeursAutoGenerees1 = preparedStatement1.getGeneratedKeys();

			if (valeursAutoGenerees1.next()) {

			} else {
				throw new DAOException("Échec ,aucun ID auto-généré retourné.");
			}

		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {

			fermeturesSilencieuses(valeursAutoGenerees1, preparedStatement1, connexion);

		}

	}

	/*
	 * Implémentation de la méthode creer_val_relation_med_pat() définie dans
	 * l'interface MedecinDao
	 */
	@Override
	public void creer_val_relation_med_pat(String identifiant_em, String identifiant_dest)
			throws IllegalArgumentException, DAOException {

		Connection connexion = null;
		PreparedStatement preparedStatement1 = null;
		ResultSet valeursAutoGenerees1 = null;

		try {

			connexion = daoFactory.getConnection();
			preparedStatement1 = initialisationRequetePreparee(connexion, SQL_INSERT_VAL_MED_PAT, true, identifiant_em,
					identifiant_dest);

			int statut1 = preparedStatement1.executeUpdate();

			if (statut1 == 0) {
				throw new DAOException(
						"Échec de la création de la validation med pat,aucune ligne ajoutée dans la table. ");
			}

			valeursAutoGenerees1 = preparedStatement1.getGeneratedKeys();

			if (valeursAutoGenerees1.next()) {

			} else {
				throw new DAOException("Échec ,aucun ID auto-généré retourné.");
			}

		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {

			fermeturesSilencieuses(valeursAutoGenerees1, preparedStatement1, connexion);

		}

	}

	/*
	 * Implémentation de la méthode chercher() définie dans l'interface
	 * MedecinDao
	 */

	@Override
	public Medecin chercher(String ipMedecin) throws DAOException {
		return trouver_ip(SQL_SELECT_PAR_IP_MEDECIN, ipMedecin);
	}

	/*
	 * Implémentation de la méthode supprimer_ip() définie dans l'interface
	 * MedecinDao
	 */

	@Override
	public void supprimer_ip(Medecin medecin) throws IllegalArgumentException, DAOException {

		Connection connexion = null;
		PreparedStatement preparedStatement1 = null;
		ResultSet valeursAutoGenerees1 = null;
		PreparedStatement preparedStatement2 = null;
		ResultSet valeursAutoGenerees2 = null;

		try {

			connexion = daoFactory.getConnection();

			preparedStatement1 = initialisationRequetePreparee(connexion,
					"DELETE FROM medecin_ip  WHERE id_med = '" + medecin.getId_medecin() + "'", true);

			preparedStatement2 = initialisationRequetePreparee(connexion,
					"DELETE FROM utilisateur_ip  WHERE id_user = '" + medecin.getId_medecin() + "' AND type_user='M'",
					true);

			int statut1 = preparedStatement1.executeUpdate();

			int statut2 = preparedStatement2.executeUpdate();

			if (statut1 == 0) {
				throw new DAOException(
						"Échec de la suppression de l'ip de l'utilisateur,aucune ligne supprimée dans la table. ");
			}

			if (statut2 == 0) {
				throw new DAOException(
						"Échec de la suppression de l'ip de l'utilisateur,aucune ligne supprimée dans la table utilisateur. ");
			}

		} catch (SQLException e) {

			throw new DAOException(e);

		} finally {

			fermeturesSilencieuses(valeursAutoGenerees1, preparedStatement1, connexion);
			fermeturesSilencieuses(valeursAutoGenerees2, preparedStatement2, connexion);

		}

	}

	/*
	 * Implémentation de la méthode supprimervalidation_med_med() définie dans
	 * l'interface MedecinDao
	 */

	@Override
	public void supprimer_validation_med_med(String ide_em, String ide_dest)
			throws IllegalArgumentException, DAOException {

		Connection connexion = null;
		PreparedStatement preparedStatement1 = null;
		ResultSet valeursAutoGenerees1 = null;

		try {

			connexion = daoFactory.getConnection();

			preparedStatement1 = initialisationRequetePreparee(connexion,
					"DELETE FROM validations_relations_med_med  WHERE ide_em = '" + ide_em + "' AND ide_dest = '"
							+ ide_dest + "'",
					true);

			int statut1 = preparedStatement1.executeUpdate();

			if (statut1 == 0) {
				throw new DAOException("Échec de la suppression ,aucune ligne supprimée dans la table. ");
			}

		} catch (SQLException e) {

			throw new DAOException(e);

		} finally {

			fermeturesSilencieuses(valeursAutoGenerees1, preparedStatement1, connexion);

		}

	}

	/*
	 * Implémentation de la méthode supprimervalidation_medt_pat() définie dans
	 * l'interface MedecinDao
	 */

	@Override
	public void supprimer_validation_medt_pat(String ide_em, String ide_dest)
			throws IllegalArgumentException, DAOException {

		Connection connexion = null;
		PreparedStatement preparedStatement1 = null;
		ResultSet valeursAutoGenerees1 = null;

		try {

			connexion = daoFactory.getConnection();

			preparedStatement1 = initialisationRequetePreparee(connexion,
					"DELETE FROM validations_relations_medtraitant_patient  WHERE ide_em = '" + ide_em
							+ "' AND ide_dest = '" + ide_dest + "'",
					true);

			int statut1 = preparedStatement1.executeUpdate();

			if (statut1 == 0) {
				throw new DAOException("Échec de la suppression ,aucune ligne supprimée dans la table. ");
			}

		} catch (SQLException e) {

			throw new DAOException(e);

		} finally {

			fermeturesSilencieuses(valeursAutoGenerees1, preparedStatement1, connexion);

		}

	}

	/*
	 * Implémentation de la méthode supprimervalidation_med_pat() définie dans
	 * l'interface MedecinDao
	 */

	@Override
	public void supprimer_validation_med_pat(String ide_em, String ide_dest)
			throws IllegalArgumentException, DAOException {

		Connection connexion = null;
		PreparedStatement preparedStatement1 = null;
		ResultSet valeursAutoGenerees1 = null;

		try {

			connexion = daoFactory.getConnection();

			preparedStatement1 = initialisationRequetePreparee(connexion,
					"DELETE FROM validations_relations_med_pat  WHERE identifiant_em = '" + ide_em
							+ "' AND identifiant_dest = '" + ide_dest + "'",
					true);

			int statut1 = preparedStatement1.executeUpdate();

			if (statut1 == 0) {
				throw new DAOException("Échec de la suppression ,aucune ligne supprimée dans la table. ");
			}

		} catch (SQLException e) {

			throw new DAOException(e);

		} finally {

			fermeturesSilencieuses(valeursAutoGenerees1, preparedStatement1, connexion);

		}

	}

	/*
	 * Implémentation de la méthode trouver() définie dans l'interface
	 * MedecinDao
	 */

	@Override
	public Medecin trouver(String identifiantMedecin) throws DAOException {
		return trouver(SQL_SELECT_PAR_IDENTIFIANT_MEDECIN, identifiantMedecin);
	}

	/*
	 * Implémentation de la méthode creer() définie dans l'interface MedecinDao
	 */
	@Override
	public void creer(Medecin medecin) throws IllegalArgumentException, DAOException {

		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet valeursAutoGenerees = null;

		try {

			connexion = daoFactory.getConnection();
			preparedStatement = initialisationRequetePreparee(connexion, SQL_INSERT, true,
					medecin.getIdentifiant_medecin(), medecin.getNoms_medecin(), medecin.getPrenoms_medecin(),
					medecin.getMdp_medecin());

			int statut = preparedStatement.executeUpdate();

			if (statut == 0) {
				throw new DAOException("Échec de la création du médecin,aucune ligne ajoutée dans la table. ");
			}

			valeursAutoGenerees = preparedStatement.getGeneratedKeys();

			if (valeursAutoGenerees.next()) {
				medecin.setId_medecin(valeursAutoGenerees.getLong(1));
			} else {
				throw new DAOException("Échec de la création du médecin en base,aucun ID auto-généré retourné.");
			}

		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {

			fermeturesSilencieuses(valeursAutoGenerees, preparedStatement, connexion);
		}

	}

	/*
	 * Implémentation de la méthode modifierMotDePasse() définie dans
	 * l'interface MedecinDao
	 */

	@Override
	public void modifierMotDePasse(Medecin medecin, String identifiant) throws IllegalArgumentException, DAOException {

		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet valeursAutoGenerees = null;

		try {

			connexion = daoFactory.getConnection();

			preparedStatement = initialisationRequetePreparee(connexion, "UPDATE medecin SET mdp_medecin ='"
					+ medecin.getMdp_medecin() + "' WHERE identifiant_medecin = '" + identifiant + "'", true);

			int statut = preparedStatement.executeUpdate();

			if (statut == 0) {
				throw new DAOException(
						"Échec de la modification du mot de passe,aucune ligne modifiée dans la table. ");
			}

		} catch (SQLException e) {

			throw new DAOException(e);

		} finally {

			fermeturesSilencieuses(valeursAutoGenerees, preparedStatement, connexion);

		}

	}

	/*
	 * Implémentation de la méthode modifierNomsMedecin() définie dans
	 * l'interface MedecinDao
	 */

	@Override
	public void modifierNomsMedecin(Medecin medecin) throws IllegalArgumentException, DAOException {

		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet valeursAutoGenerees = null;

		try {

			connexion = daoFactory.getConnection();

			preparedStatement = initialisationRequetePreparee(connexion,
					"UPDATE medecin SET noms_medecin ='" + medecin.getNoms_medecin() + "' WHERE identifiant_medecin = '"
							+ medecin.getIdentifiant_medecin() + "'",
					true);

			int statut = preparedStatement.executeUpdate();

			if (statut == 0) {
				throw new DAOException("Échec de la modification des noms,aucune ligne modifiée dans la table. ");
			}

		} catch (SQLException e) {

			throw new DAOException(e);

		} finally {

			fermeturesSilencieuses(valeursAutoGenerees, preparedStatement, connexion);

		}

	}

	/*
	 * Implémentation de la méthode uploadphoto() définie dans l'interface
	 * MedecinDao
	 */

	@Override
	public void uploadphoto(Medecin medecin) throws IllegalArgumentException, DAOException {

		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet valeursAutoGenerees = null;

		try {

			connexion = daoFactory.getConnection();

			preparedStatement = initialisationRequetePreparee(connexion,
					"UPDATE medecin SET photo_medecin ='" + medecin.getPhoto_medecin() + "',url_photo_medecin ='"
							+ medecin.getUrl_photo_medecin() + "' WHERE identifiant_medecin = '"
							+ medecin.getIdentifiant_medecin() + "'",
					true);

			int statut = preparedStatement.executeUpdate();

			if (statut == 0) {
				throw new DAOException("Échec de la modification de la photo,aucune ligne modifiée dans la table. ");
			}

		} catch (SQLException e) {

			throw new DAOException(e);

		} finally {

			fermeturesSilencieuses(valeursAutoGenerees, preparedStatement, connexion);

		}

	}

	/*
	 * Implémentation de la méthode modifierPrenomsMedecin() définie dans
	 * l'interface MedecinDao
	 */

	@Override
	public void modifierPrenomsMedecin(Medecin medecin) throws IllegalArgumentException, DAOException {

		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet valeursAutoGenerees = null;

		try {

			connexion = daoFactory.getConnection();

			preparedStatement = initialisationRequetePreparee(connexion,
					"UPDATE medecin SET prenoms_medecin ='" + medecin.getPrenoms_medecin()
							+ "' WHERE identifiant_medecin = '" + medecin.getIdentifiant_medecin() + "'",
					true);

			int statut = preparedStatement.executeUpdate();

			if (statut == 0) {
				throw new DAOException("Échec de la modification des prénoms,aucune ligne modifiée dans la table. ");
			}

		} catch (SQLException e) {

			throw new DAOException(e);

		} finally {

			fermeturesSilencieuses(valeursAutoGenerees, preparedStatement, connexion);

		}

	}

	/*
	 * Implémentation de la méthode modifierIdentifiantMedecin() définie dans
	 * l'interface MedecinDao
	 */

	@Override
	public void modifierIdentifiantMedecin(Medecin medecin) throws IllegalArgumentException, DAOException {

		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet valeursAutoGenerees = null;

		try {

			connexion = daoFactory.getConnection();

			preparedStatement = initialisationRequetePreparee(connexion, "UPDATE medecin SET identifiant_medecin ='"
					+ medecin.getIdentifiant_medecin() + "' WHERE id_medecin = '" + medecin.getId_medecin() + "'",
					true);

			int statut = preparedStatement.executeUpdate();

			if (statut == 0) {
				throw new DAOException(
						"Échec de la modification de l'identifiant,aucune ligne modifiée dans la table. ");
			}

		} catch (SQLException e) {

			throw new DAOException(e);

		} finally {

			fermeturesSilencieuses(valeursAutoGenerees, preparedStatement, connexion);

		}

	}

	/*
	 * Implémentation de la méthode modifierMotDePasseMedecin() définie dans
	 * l'interface MedecinDao
	 */

	@Override
	public void modifierMotDePasseMedecin(Medecin medecin) throws IllegalArgumentException, DAOException {

		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet valeursAutoGenerees = null;

		try {

			connexion = daoFactory.getConnection();

			preparedStatement = initialisationRequetePreparee(connexion, "UPDATE medecin SET mdp_medecin ='"
					+ medecin.getMdp_medecin() + "' WHERE id_medecin = '" + medecin.getId_medecin() + "'", true);

			int statut = preparedStatement.executeUpdate();

			if (statut == 0) {
				throw new DAOException(
						"Échec de la modification de l'identifiant,aucune ligne modifiée dans la table. ");
			}

		} catch (SQLException e) {

			throw new DAOException(e);

		} finally {

			fermeturesSilencieuses(valeursAutoGenerees, preparedStatement, connexion);

		}

	}

	/*
	 * Implémentation de la méthode trouver_patients_med() définie dans
	 * l'interface MedecinDao
	 */

	@Override
	public ArrayList<Patient> trouver_patients_med(String identifiantMedecin, PatientDao patientDao)
			throws DAOException {

		ArrayList<Patient> patients = new ArrayList<Patient>();

		ArrayList<String> listeidentifiantspat = new ArrayList<String>();

		listeidentifiantspat = trouver_identifiantspatients_med(SQL_SELECT_PAR_IDENTIFIANT_MEDECIN_MED_PAT,
				identifiantMedecin);

		for (int i = 0; i < listeidentifiantspat.size(); i++) {

			System.out.println(listeidentifiantspat.get(i));

			Patient pat = patientDao.trouver(listeidentifiantspat.get(i));

			if (pat == null) {
				System.out.println("azerty");
			} else {

				System.out.println("azer");

			}

			System.out.println("anormal");

			patients.add(pat);

		}

		return patients;

	}

	/*
	 * Implémentation de la méthode trouver_patients_medtraitant() définie dans
	 * l'interface MedecinDao
	 */

	@Override
	public ArrayList<Patient> trouver_patients_medtraitant(String identifiantMedecin, PatientDao patientDao)
			throws DAOException {

		ArrayList<Patient> patients = new ArrayList<Patient>();

		for (int i = 0; i < trouver_identifiantspatients_med(SQL_SELECT_PAR_IDENTIFIANT_MEDECIN_MEDTRAITANT_PAT,
				identifiantMedecin).size(); i++) {

			patients.add(patientDao
					.trouver(trouver_identifiantspatients_med(SQL_SELECT_PAR_IDENTIFIANT_MEDECIN_MEDTRAITANT_PAT,
							identifiantMedecin).get(i)));

		}

		return patients;

	}

	private ArrayList<String> trouver_identifiantspatients_med(String sql, Object objets) throws DAOException {

		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		ArrayList<String> listeidentifiantspatients = new ArrayList<String>();

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
				listeidentifiantspatients.add(map_identifiant_patient(resultSet));
			}

		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			fermeturesSilencieuses(resultSet, preparedStatement, connexion);
		}

		return listeidentifiantspatients;

	}

	/*
	 * Implémentation de la méthode trouver_med_med() définie dans l'interface
	 * MedecinDao
	 */

	@Override
	public int trouver_med_med(String identifiantMed1, String identifiantMed2) throws DAOException {

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
					"SELECT * FROM relations_med_med WHERE identifiant_med1 ='" + identifiantMed1
							+ "' AND identifiant_med2 ='" + identifiantMed2 + "' OR identifiant_med1 ='"
							+ identifiantMed2 + "' AND identifiant_med2 ='" + identifiantMed1 + "'",
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
	 * Implémentation de la méthode trouver_med_pat() définie dans l'interface
	 * MedecinDao
	 */

	@Override
	public int trouver_med_pat(String identifiantMed, String identifiantPat) throws DAOException {

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
					"SELECT * FROM relations_med_pat WHERE identifiant_med ='" + identifiantMed
							+ "' AND identifiant_pat ='" + identifiantPat + "'",
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
	 * Implémentation de la méthode trouver_medt_pat() définie dans l'interface
	 * MedecinDao
	 */

	@Override
	public int trouver_medt_pat(String identifiantMed, String identifiantPat) throws DAOException {

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
					"SELECT * FROM relations_medtraitant_patient WHERE identifiant_med ='" + identifiantMed
							+ "' AND identifiant_pat ='" + identifiantPat + "'",
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
	 * Implémentation de la méthode trouver_pat() définie dans l'interface
	 * MedecinDao
	 */

	@Override
	public int trouver_pat(String identifiantPat) throws DAOException {

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
					"SELECT * FROM relations_medtraitant_patient WHERE identifiant_pat ='" + identifiantPat + "'",
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
	 * Implémentation de la méthode trouver_validations_med_med() définie dans
	 * l'interface MedecinDao
	 */

	@Override
	public int trouver_validations_med_med(String identifiantMed1Em, String identifiantMed2Dest) throws DAOException {

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
					"SELECT * FROM validations_relations_med_med WHERE ide_em ='" + identifiantMed1Em
							+ "' AND ide_dest ='" + identifiantMed2Dest + "'",
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
	 * Implémentation de la méthode trouver_validations_med_pat() définie dans
	 * l'interface MedecinDao
	 */

	@Override
	public int trouver_validations_med_pat(String identifiantEm, String identifiantDest) throws DAOException {

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
					"SELECT * FROM validations_relations_med_pat WHERE identifiant_em ='" + identifiantEm
							+ "' AND identifiant_dest ='" + identifiantDest + "'",
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
	 * Implémentation de la méthode trouver_validations_medt_pat() définie dans
	 * l'interface MedecinDao
	 */

	@Override
	public int trouver_validations_medt_pat(String identifiantEm, String identifiantDest) throws DAOException {

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
					"SELECT * FROM validations_relations_medtraitant_patient WHERE ide_em ='" + identifiantEm
							+ "' AND ide_dest ='" + identifiantDest + "'",
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
	 * Simple méthode utilitaire permettant de faire la correspondance (le
	 * mapping) entre une ligne issue de la table relations_med_pat (un
	 * ResultSet) et un objet String.
	 */

	private static String map_identifiant_patient(ResultSet resultSet) throws SQLException {

		String identifiant = new String();

		identifiant = resultSet.getString("identifiant_pat");

		return identifiant;
	}

	/*
	 * Simple méthode utilitaire permettant de faire la correspondance (le
	 * mapping) entre une ligne issue de la table medecin_ip (un ResultSet) et
	 * un bean Médecin.
	 */

	private static Medecin map_ip(ResultSet resultSet) throws SQLException {

		Medecin medecin = new Medecin();

		medecin.setId_medecin(resultSet.getLong("id_user"));

		medecin.setIp_medecin(resultSet.getString("ip_user"));

		return medecin;
	}

	/*
	 * Simple méthode utilitaire permettant de faire la correspondance (le
	 * mapping) entre une ligne issue de la table des médecins (un ResultSet) et
	 * un bean Médecin.
	 */

	private static Medecin mapurlphoto(ResultSet resultSet) throws SQLException {

		Medecin medecin = new Medecin();
		medecin.setId_medecin(resultSet.getLong("id_medecin"));
		medecin.setIdentifiant_medecin(resultSet.getString("identifiant_medecin"));
		medecin.setNoms_medecin(resultSet.getString("noms_medecin"));
		medecin.setPrenoms_medecin(resultSet.getString("prenoms_medecin"));
		medecin.setMdp_medecin(resultSet.getString("mdp_medecin"));
		medecin.setUrl_photo_medecin(resultSet.getString("url_photo_medecin"));
		medecin.setDate_heure_inscription_medecin(resultSet.getTimestamp("date_heure_inscription_medecin"));

		return medecin;
	}

	private static Medecin map(ResultSet resultSet) throws SQLException {

		Medecin medecin = new Medecin();
		medecin.setId_medecin(resultSet.getLong("id_medecin"));
		medecin.setIdentifiant_medecin(resultSet.getString("identifiant_medecin"));
		medecin.setNoms_medecin(resultSet.getString("noms_medecin"));
		medecin.setPrenoms_medecin(resultSet.getString("prenoms_medecin"));
		medecin.setMdp_medecin(resultSet.getString("mdp_medecin"));

		medecin.setDate_heure_inscription_medecin(resultSet.getTimestamp("date_heure_inscription_medecin"));

		return medecin;
	}

	private Medecin trouver(String sql, Object objets) throws DAOException {

		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		Medecin medecin = null;

		try {
			/* Récupération d'une connexion depuis la Factory */
			connexion = daoFactory.getConnection();

			/*
			 * Préparation de la requête avec les objets passés en arguments
			 * (ici,uniquement un identifiant_medecin) et exécution.
			 */

			preparedStatement = initialisationRequetePreparee(connexion, sql, false, objets);
			resultSet = preparedStatement.executeQuery();

			/* Parcours de la ligne de données retournée dans le ResultSet */

			if (resultSet.next()) {
				medecin = mapurlphoto(resultSet);
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			fermeturesSilencieuses(resultSet, preparedStatement, connexion);
		}

		return medecin;
	}

	private Medecin trouver_ip(String sql, Object objets) throws DAOException {

		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		Medecin medecin = null;

		try {
			/* Récupération d'une connexion depuis la Factory */
			connexion = daoFactory.getConnection();

			/*
			 * Préparation de la requête avec les objets passés en arguments
			 * (ici,uniquement un identifiant_medecin) et exécution.
			 */

			preparedStatement = initialisationRequetePreparee(connexion, sql, false, objets);
			resultSet = preparedStatement.executeQuery();

			/* Parcours de la ligne de données retournée dans le ResultSet */

			if (resultSet.next()) {
				medecin = map_ip(resultSet);
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			fermeturesSilencieuses(resultSet, preparedStatement, connexion);
		}

		return medecin;
	}

}
