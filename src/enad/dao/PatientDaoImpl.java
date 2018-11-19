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
public class PatientDaoImpl implements PatientDao {

	private static final String SQL_REL_MED = "SELECT identifiant_med FROM relations_med_pat WHERE identifiant_pat = ? ";

	private static final String SQL_INSERT = "INSERT INTO patient (identifiant_patient,noms_patient,prenoms_patient,date_naissance_patient,sexe_patient,affichage_date_naissance,date_heure_inscription_patient) VALUES(?,?,?,?,?,?,NOW());";

	private static final String SQL_INSERT_IP = "INSERT INTO patient_ip (id_pat,ip_pat) VALUES(?,?)";

	private static final String SQL_SELECT_PAR_IDENTIFIANT_PATIENT_MED_PAT = "SELECT identifiant_med FROM relations_med_pat WHERE identifiant_pat = ?";

	// private static final String SQL_INSERT = "INSERT INTO patient
	// (identifiant_patient,noms_patient,prenoms_patient,date_naissance_patient,sexe_patient,date_heure_inscription_patient,affichage_date_naissance)
	// VALUES(?,?,?,?,?,NOW(),DATE_FORMAT(date_naissance_patient,'le %W %e %M
	// %Y'));";

	private static final String SQL_PATIENTS = "SELECT id_patient,identifiant_patient,noms_patient,prenoms_patient,date_heure_inscription_patient,date_naissance_patient,sexe_patient,affichage_date_naissance,main  FROM patient";

	private static final String SQL_SELECT_PAR_IDENTIFIANT_PATIENT = "SELECT id_patient,identifiant_patient,noms_patient,prenoms_patient,date_heure_inscription_patient,date_naissance_patient,sexe_patient,affichage_date_naissance,main,url_photo_patient FROM patient WHERE identifiant_patient = ?";

	private static final String SQL_SELECT_PAR_ID_PATIENT = "SELECT id_patient,identifiant_patient,noms_patient,prenoms_patient,date_heure_inscription_patient,date_naissance_patient,sexe_patient,affichage_date_naissance FROM patient WHERE id_patient = ?";

	private static final String SQL_SELECT_PAR_NOMS_PATIENT = "SELECT id_patient,identifiant_patient,noms_patient,prenoms_patient,date_heure_inscription_patient,date_naissance_patient,sexe_patient,main,affichage_date_naissance,main FROM patient WHERE noms_patient = ?";

	private static final String SQL_SELECT_PAR_PRENOMS_PATIENT = "SELECT id_patient,identifiant_patient,noms_patient,prenoms_patient,date_heure_inscription_patient,date_naissance_patient,sexe_patient,affichage_date_naissance,main FROM patient WHERE prenoms_patient = ?";

	private static final String SQL_SELECT_PAR_IP_PATIENT = "SELECT id_user_ip,id_user,ip_user,type_user FROM utilisateur_ip WHERE ip_user = ?";

	private static final String SQL_INSERT_IP_USER = "INSERT INTO utilisateur_ip (id_user,ip_user,type_user) VALUES(?,?,'P')";

	private DAOFactory daoFactory;

	private MedecinDao medecinDao;

	PatientDaoImpl(DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	/*
	 * Implémentation de la méthode uploadphoto() définie dans l'interface
	 * PatientDao
	 */

	@Override
	public void uploadphoto(Patient patient) throws IllegalArgumentException, DAOException {

		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet valeursAutoGenerees = null;

		try {

			connexion = daoFactory.getConnection();

			preparedStatement = initialisationRequetePreparee(connexion,
					"UPDATE patient SET photo_patient ='" + patient.getPhoto_patient() + "',url_photo_patient ='"
							+ patient.getUrl_photo_patient() + "' WHERE identifiant_patient = '"
							+ patient.getIdentifiant_patient() + "'",
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
	 * Implémentation de la méthode trouver_identifiantsmed_relmedpat() définie
	 * dans l'interface MedecinDao
	 */

	@Override
	public ArrayList<String> trouver_identifiantsmed_relmedpat(String identifiantpat) throws DAOException {

		return trouver_identifiantsmed_relmedpat(SQL_REL_MED, identifiantpat);
	}

	private ArrayList<String> trouver_identifiantsmed_relmedpat(String sql, Object objets) throws DAOException {

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
				identifiants.add(resultSet.getString("identifiant_med"));
			}

		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			fermeturesSilencieuses(resultSet, preparedStatement, connexion);
		}

		return identifiants;

	}

	/*
	 * Implémentation de la méthode trouver_pat_connexion_on() définie dans
	 * l'interface PatientDao
	 */

	@Override
	public int trouver_pat_connexion_on(Long id_Pat) throws DAOException {

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
					"SELECT * FROM patient_ip WHERE id_pat ='" + id_Pat + "'", true);
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
	 * Implémentation de la méthode TousLesPatients() définie dans l'interface
	 * PatientDao
	 */

	@Override
	public ArrayList<Patient> TousLesPatients() throws DAOException {

		return tousLesPatients(SQL_PATIENTS);
	}

	private ArrayList<Patient> tousLesPatients(String sql) throws DAOException {

		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		ArrayList<Patient> patients = new ArrayList<Patient>();

		try {

			/* Récupération d'une connexion depuis la Factory */
			connexion = daoFactory.getConnection();

			preparedStatement = initialisationRequetePreparee(connexion, sql, true);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				patients.add(map(resultSet));
			}

		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			fermeturesSilencieuses(resultSet, preparedStatement, connexion);
		}

		return patients;

	}

	/*
	 * Implémentation de la méthode creer() définie dans l'interface PatientDao
	 */

	@Override

	public void creer(Patient patient) throws IllegalArgumentException, DAOException {

		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet valeursAutoGenerees = null;

		try {

			connexion = daoFactory.getConnection();
			preparedStatement = initialisationRequetePreparee(connexion, SQL_INSERT, true,
					patient.getIdentifiant_patient(), patient.getNoms_patient(), patient.getPrenoms_patient(),
					patient.getDate_naissance_patient(), patient.getSexe_patient(),
					patient.getAffichage_date_naissance());

			int statut = preparedStatement.executeUpdate();

			if (statut == 0) {
				throw new DAOException("Échec de la création du patient,aucune ligne ajoutée dans la table. ");
			}

			valeursAutoGenerees = preparedStatement.getGeneratedKeys();

			if (valeursAutoGenerees.next()) {
				patient.setId_patient(valeursAutoGenerees.getLong(1));
			} else {
				throw new DAOException("Échec de la création du patient en base, aucun ID auto-généré retourné. ");
			}

		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			fermeturesSilencieuses(valeursAutoGenerees, preparedStatement, connexion);
		}

	}

	/*
	 * Implémentation de la méthode modifierNomsPatient() définie dans
	 * l'interface PatientDao
	 */

	@Override
	public void modifierNomsPatient(Patient patient) throws IllegalArgumentException, DAOException {

		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet valeursAutoGenerees = null;

		try {

			connexion = daoFactory.getConnection();

			preparedStatement = initialisationRequetePreparee(connexion,
					"UPDATE patient SET noms_patient ='" + patient.getNoms_patient() + "' WHERE identifiant_patient = '"
							+ patient.getIdentifiant_patient() + "'",
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
	 * Implémentation de la méthode modifierPrenomsPatient() définie dans
	 * l'interface PatientDao
	 */

	@Override
	public void modifierPrenomsPatient(Patient patient) throws IllegalArgumentException, DAOException {

		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet valeursAutoGenerees = null;

		try {

			connexion = daoFactory.getConnection();

			preparedStatement = initialisationRequetePreparee(connexion,
					"UPDATE patient SET prenoms_patient ='" + patient.getPrenoms_patient()
							+ "' WHERE identifiant_patient = '" + patient.getIdentifiant_patient() + "'",
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
	 * Implémentation de la méthode modifierSexePatient() définie dans
	 * l'interface PatientDao
	 */

	@Override
	public void modifierSexePatient(Patient patient) throws IllegalArgumentException, DAOException {

		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet valeursAutoGenerees = null;

		try {

			connexion = daoFactory.getConnection();

			preparedStatement = initialisationRequetePreparee(connexion,
					"UPDATE patient SET sexe_patient ='" + patient.getSexe_patient() + "' WHERE identifiant_patient = '"
							+ patient.getIdentifiant_patient() + "'",
					true);

			int statut = preparedStatement.executeUpdate();

			if (statut == 0) {
				throw new DAOException("Échec de la modification du sexe,aucune ligne modifiée dans la table. ");
			}

		} catch (SQLException e) {

			throw new DAOException(e);

		} finally {

			fermeturesSilencieuses(valeursAutoGenerees, preparedStatement, connexion);

		}

	}

	/*
	 * Implémentation de la méthode modifierMassePatient() définie dans
	 * l'interface PatientDao
	 */

	@Override
	public void modifierMassePatient(Patient patient) throws IllegalArgumentException, DAOException {

		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet valeursAutoGenerees = null;

		try {

			connexion = daoFactory.getConnection();

			preparedStatement = initialisationRequetePreparee(connexion,
					"UPDATE patient SET masse_patient ='" + patient.getMasse_patient()
							+ "' WHERE identifiant_patient = '" + patient.getIdentifiant_patient() + "'",
					true);

			int statut = preparedStatement.executeUpdate();

			if (statut == 0) {
				throw new DAOException("Échec de la modification de la masse,aucune ligne modifiée dans la table. ");
			}

		} catch (SQLException e) {

			throw new DAOException(e);

		} finally {

			fermeturesSilencieuses(valeursAutoGenerees, preparedStatement, connexion);

		}

	}

	/*
	 * Implémentation de la méthode modifierDateNaissancePatient() définie dans
	 * l'interface PatientDao
	 */

	@Override
	public void modifierDateNaissancePatient(Patient patient) throws IllegalArgumentException, DAOException {

		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet valeursAutoGenerees = null;

		try {

			connexion = daoFactory.getConnection();

			preparedStatement = initialisationRequetePreparee(connexion,
					"UPDATE patient SET date_naissance_patient ='" + patient.getDate_naissance_patient()
							+ "',affichage_date_naissance ='" + patient.getAffichage_date_naissance()
							+ "'  WHERE identifiant_patient = '" + patient.getIdentifiant_patient() + "'",
					true);

			int statut = preparedStatement.executeUpdate();

			if (statut == 0) {
				throw new DAOException(
						"Échec de la modification de la date de naissance,aucune ligne modifiée dans la table. ");
			}

		} catch (SQLException e) {

			throw new DAOException(e);

		} finally {

			fermeturesSilencieuses(valeursAutoGenerees, preparedStatement, connexion);

		}

	}

	/*
	 * Implémentation de la méthode modifierTaillePatient() définie dans
	 * l'interface PatientDao
	 */

	@Override
	public void modifierTaillePatient(Patient patient) throws IllegalArgumentException, DAOException {

		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet valeursAutoGenerees = null;

		try {

			connexion = daoFactory.getConnection();

			preparedStatement = initialisationRequetePreparee(connexion,
					"UPDATE patient SET taille_patient ='" + patient.getTaille_patient()
							+ "' WHERE identifiant_patient = '" + patient.getIdentifiant_patient() + "'",
					true);

			int statut = preparedStatement.executeUpdate();

			if (statut == 0) {
				throw new DAOException("Échec de la modification de la taille,aucune ligne modifiée dans la table. ");
			}

		} catch (SQLException e) {

			throw new DAOException(e);

		} finally {

			fermeturesSilencieuses(valeursAutoGenerees, preparedStatement, connexion);

		}

	}

	/*
	 * Implémentation de la méthode modifierIdentifiantPatient() définie dans
	 * l'interface PatientDao
	 */

	@Override
	public void modifierIdentifiantPatient(Patient patient) throws IllegalArgumentException, DAOException {

		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet valeursAutoGenerees = null;

		try {

			connexion = daoFactory.getConnection();

			preparedStatement = initialisationRequetePreparee(connexion, "UPDATE patient SET identifiant_patient ='"
					+ patient.getIdentifiant_patient() + "' WHERE id_patient = '" + patient.getId_patient() + "'",
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
	 * Implémentation de la méthode creer_ip() définie dans l'interface
	 * PatientDao
	 */

	@Override

	public void creer_ip(Patient patient) throws IllegalArgumentException, DAOException {

		Connection connexion = null;
		PreparedStatement preparedStatement1 = null;
		ResultSet valeursAutoGenerees1 = null;
		PreparedStatement preparedStatement2 = null;
		ResultSet valeursAutoGenerees2 = null;

		try {

			connexion = daoFactory.getConnection();
			preparedStatement1 = initialisationRequetePreparee(connexion, SQL_INSERT_IP, true, patient.getId_patient(),
					patient.getIp_patient());

			preparedStatement2 = initialisationRequetePreparee(connexion, SQL_INSERT_IP_USER, true,
					patient.getId_patient(), patient.getIp_patient());

			int statut1 = preparedStatement1.executeUpdate();

			int statut2 = preparedStatement2.executeUpdate();

			if (statut1 == 0) {
				throw new DAOException("Échec de la création de l'ip du patient,aucune ligne ajoutée dans la table. ");
			}

			if (statut2 == 0) {
				throw new DAOException(
						"Échec de l'ajout de l'ip du patient,aucune ligne ajoutée dans la table utilisateur. ");
			}

			valeursAutoGenerees1 = preparedStatement1.getGeneratedKeys();

			valeursAutoGenerees2 = preparedStatement2.getGeneratedKeys();

			if (valeursAutoGenerees1.next()) {

			} else {
				throw new DAOException(
						"Échec de l'attribution de l'ip au patient en base, aucun ID auto-généré retourné. ");
			}

			if (valeursAutoGenerees2.next()) {

			} else {
				throw new DAOException(
						"Échec de l'attribution de l'ip au patient en base utilisateur_ip, aucun ID auto-généré retourné. ");
			}

		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			fermeturesSilencieuses(valeursAutoGenerees1, preparedStatement1, connexion);

			fermeturesSilencieuses(valeursAutoGenerees2, preparedStatement2, connexion);
		}

	}

	/*
	 * Implémentation de la méthode supprimer_ip() définie dans l'interface
	 * PatientDao
	 */

	@Override
	public void supprimer_ip(Patient patient) throws IllegalArgumentException, DAOException {

		Connection connexion = null;
		PreparedStatement preparedStatement1 = null;
		ResultSet valeursAutoGenerees1 = null;
		PreparedStatement preparedStatement2 = null;
		ResultSet valeursAutoGenerees2 = null;

		try {

			connexion = daoFactory.getConnection();

			preparedStatement1 = initialisationRequetePreparee(connexion,
					"DELETE FROM patient_ip  WHERE id_pat = '" + patient.getId_patient() + "'", true);

			preparedStatement2 = initialisationRequetePreparee(connexion,
					"DELETE FROM utilisateur_ip  WHERE id_user = '" + patient.getId_patient() + "'AND type_user='P'",
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
	 * Implémentation de la méthode trouver_med_pat() définie dans l'interface
	 * PatientDao
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
	 * PatientDao
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
	 * PatientDao
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
	 * Implémentation de la méthode trouver_validations_medt_pat() définie dans
	 * l'interface PatientDao
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
	 * Implémentation de la méthode trouver_validations_med_pat() définie dans
	 * l'interface PatientDao
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
	 * Implémentation de la méthode chercher() définie dans l'interface
	 * PatientDao
	 */

	@Override
	public Patient chercher(String ipPatient) throws DAOException {
		return trouver_ip(SQL_SELECT_PAR_IP_PATIENT, ipPatient);
	}

	/*
	 * Simple méthode utilitaire permettant de faire la correspondance (le
	 * mapping) entre une ligne issue de la table des patients (un ResultSet) et
	 * un bean Patient.
	 */

	private static Patient map(ResultSet resultSet) throws SQLException {

		Patient patient = new Patient();

		patient.setId_patient(resultSet.getLong("id_patient"));
		patient.setIdentifiant_patient(resultSet.getString("identifiant_patient"));
		patient.setNoms_patient(resultSet.getString("noms_patient"));
		patient.setPrenoms_patient(resultSet.getString("prenoms_patient"));
		patient.setDate_heure_inscription_patient(resultSet.getTimestamp("date_heure_inscription_patient"));
		patient.setSexe_patient(resultSet.getString("sexe_patient"));

		patient.setDate_naissance_patient(resultSet.getDate("date_naissance_patient"));
		patient.setAffichage_date_naissance(resultSet.getString("affichage_date_naissance"));

		return patient;

	}

	private static Patient mapurlphoto(ResultSet resultSet) throws SQLException {

		Patient patient = new Patient();

		patient.setId_patient(resultSet.getLong("id_patient"));
		patient.setIdentifiant_patient(resultSet.getString("identifiant_patient"));
		patient.setNoms_patient(resultSet.getString("noms_patient"));
		patient.setPrenoms_patient(resultSet.getString("prenoms_patient"));
		patient.setDate_heure_inscription_patient(resultSet.getTimestamp("date_heure_inscription_patient"));
		patient.setSexe_patient(resultSet.getString("sexe_patient"));
		patient.setUrl_photo_patient(resultSet.getString("url_photo_patient"));

		patient.setDate_naissance_patient(resultSet.getDate("date_naissance_patient"));
		patient.setAffichage_date_naissance(resultSet.getString("affichage_date_naissance"));

		return patient;

	}

	/*
	 * Simple méthode utilitaire permettant de faire la correspondance (le
	 * mapping) entre une ligne issue de la table patient_ip (un ResultSet) et
	 * un bean Patient.
	 */

	private static Patient map_ip(ResultSet resultSet) throws SQLException {

		Patient patient = new Patient();

		patient.setId_patient(resultSet.getLong("id_user"));

		patient.setIp_patient(resultSet.getString("ip_user"));

		return patient;

	}

	/*
	 * Implémentation de la méthode trouver()id définie dans l'interface
	 * PatientDao
	 */

	@Override
	public Patient trouver(Long idPatient) throws DAOException {

		return trouver_id(SQL_SELECT_PAR_ID_PATIENT, idPatient);
	}

	private Patient trouver_id(String sql, Object objets) throws DAOException {

		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		Patient patient = null;

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

				patient = map(resultSet);
			}

		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			fermeturesSilencieuses(resultSet, preparedStatement, connexion);
		}

		return patient;

	}

	/*
	 * Implémentation de la méthode trouver()identifiant définie dans
	 * l'interface PatientDao
	 */

	@Override
	public Patient trouver(String identifiantPatient) throws DAOException {

		return trouver(SQL_SELECT_PAR_IDENTIFIANT_PATIENT, identifiantPatient);
	}

	private Patient trouver(String sql, Object objets) throws DAOException {

		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		Patient patient = null;

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

				patient = mapurlphoto(resultSet);
			}

		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			fermeturesSilencieuses(resultSet, preparedStatement, connexion);
		}

		return patient;

	}

	private Patient trouver_ip(String sql, Object objets) throws DAOException {

		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		Patient patient = null;

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

				patient = map_ip(resultSet);
			}

		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			fermeturesSilencieuses(resultSet, preparedStatement, connexion);
		}

		return patient;

	}

	/*
	 * Implémentation de la méthode trouver_noms() définie dans l'interface
	 * PatientDao
	 */

	@Override
	public ArrayList<Patient> trouver_noms(String nomsPatient) throws DAOException {

		return trouver_noms(SQL_SELECT_PAR_NOMS_PATIENT, nomsPatient);
	}

	private ArrayList<Patient> trouver_noms(String sql, Object objets) throws DAOException {

		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		ArrayList<Patient> patients = new ArrayList<Patient>();

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
				patients.add(map(resultSet));
			}

		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			fermeturesSilencieuses(resultSet, preparedStatement, connexion);
		}

		return patients;

	}

	/*
	 * Implémentation de la méthode trouver_prenoms() définie dans l'interface
	 * PatientDao
	 */

	@Override
	public ArrayList<Patient> trouver_prenoms(String prenomsPatient) throws DAOException {

		return trouver_prenoms(SQL_SELECT_PAR_PRENOMS_PATIENT, prenomsPatient);
	}

	private ArrayList<Patient> trouver_prenoms(String sql, Object objets) throws DAOException {

		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		ArrayList<Patient> patients = new ArrayList<Patient>();

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
				patients.add(map(resultSet));
			}

		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			fermeturesSilencieuses(resultSet, preparedStatement, connexion);
		}

		return patients;

	}

	/*
	 * Implémentation de la méthode trouver_medecins_pat() définie dans
	 * l'interface PatientDao
	 */

	@Override
	public ArrayList<Medecin> trouver_medecins_pat(String identifiantPatient) throws DAOException {

		ArrayList<Medecin> medecins = new ArrayList<Medecin>();

		for (int i = 0; i < trouver_identifiantsmedecins_pat(SQL_SELECT_PAR_IDENTIFIANT_PATIENT_MED_PAT,
				identifiantPatient).size(); i++) {

			medecins.add(medecinDao.trouver(
					trouver_identifiantsmedecins_pat(SQL_SELECT_PAR_IDENTIFIANT_PATIENT_MED_PAT, identifiantPatient)
							.get(i)));

		}

		return medecins;

	}

	private ArrayList<String> trouver_identifiantsmedecins_pat(String sql, Object objets) throws DAOException {

		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		ArrayList<String> listeidentifiantsmedecins = new ArrayList<String>();

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
				listeidentifiantsmedecins.add(map_identifiant_medecin(resultSet));
			}

		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			fermeturesSilencieuses(resultSet, preparedStatement, connexion);
		}

		return listeidentifiantsmedecins;

	}

	/*
	 * Simple méthode utilitaire permettant de faire la correspondance (le
	 * mapping) entre une ligne issue de la table relations_med_pat (un
	 * ResultSet) et un objet String.
	 */

	private static String map_identifiant_medecin(ResultSet resultSet) throws SQLException {

		String identifiant = new String();

		identifiant = resultSet.getString("identifiant_med");

		return identifiant;
	}

}
