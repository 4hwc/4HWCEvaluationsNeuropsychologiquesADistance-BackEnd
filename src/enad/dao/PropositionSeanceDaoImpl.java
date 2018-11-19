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
import enad.beans.PropositionSeance;
import enad.beans.Seance;

public class PropositionSeanceDaoImpl implements PropositionSeanceDao {

	private static final String SQL_INSERT = "INSERT INTO proposition_seance (date_realisation_seance_proposition,heure_realisation_seance_proposition,heure_fin_seance_proposition,affichage_date_realisation_seance_proposition,id_seance,identifiant_medecin_proposition,identifiant_patient_proposition,prenoms_noms_patient_proposition,prenoms_noms_medecin_proposition,identifiant_emission,prenoms_noms_emission,date_heure_creation_seance_proposition) VALUES(?,?,?,?,?,?,?,?,?,?,?,NOW())";

	private static final String SQL_SELECT_PAR_IDSEANCE = "SELECT * FROM proposition_seance WHERE id_seance =?";

	private static final String SQL_SELECT_DERNIERE_PERSONNE_PAR_IDSEANCE = "SELECT * FROM proposition_seance WHERE id_seance =? ORDER BY date_heure_creation_seance_proposition DESC LIMIT 1 OFFSET 0";

	private static final String SQL_SELECT_DERNIERE_PROP_PAR_IDSEANCE = "SELECT * FROM proposition_seance WHERE id_seance =? ORDER BY date_heure_creation_seance_proposition DESC LIMIT 1 OFFSET 0";

	private static final String SQL_SELECT_PROP_PAR_IDPROP = "SELECT * FROM proposition_seance WHERE id_seance_proposition =?";

	private DAOFactory daoFactory;

	PropositionSeanceDaoImpl(DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	/*
	 * Implémentation de la méthode nombre_prop_seance() définie dans
	 * l'interface PropositionSeanceDao
	 */

	@Override
	public int nombre_prop_seance(Long idSeance) throws DAOException {

		return trouver_nombre_propseance(SQL_SELECT_PAR_IDSEANCE, idSeance);
	}

	private int trouver_nombre_propseance(String sql, Object objets) throws DAOException {

		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		int compteur = 0;

		try {

			/* Récupération d'une connexion depuis la Factory */
			connexion = daoFactory.getConnection();

			preparedStatement = initialisationRequetePreparee(connexion, sql, true, objets);
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
	 * Implémentation de la méthode creerMed() définie dans l'interface
	 * PropositionSeanceDao
	 */

	@Override
	public void creerMed(Seance seance, PropositionSeance propseance, Medecin medecin)
			throws IllegalArgumentException, DAOException {

		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet valeursAutoGenerees = null;

		try {

			connexion = daoFactory.getConnection();
			preparedStatement = initialisationRequetePreparee(connexion, SQL_INSERT, true,
					propseance.getDate_realisation_seance_proposition(),
					propseance.getHeure_realisation_seance_proposition(), propseance.getHeure_fin_seance_proposition(),
					propseance.getAffichage_date_realisation_seance_proposition(), seance.getId_seance(),
					seance.getIdentifiant_medecin(), seance.getIdentifiant_patient(), seance.getPrenoms_noms_patient(),
					seance.getPrenoms_noms_medecin(), medecin.getIdentifiant_medecin(),
					medecin.getPrenoms_medecin() + " " + medecin.getNoms_medecin()

			);

			int statut = preparedStatement.executeUpdate();

			if (statut == 0) {
				throw new DAOException(
						"Échec de la création de la proposition de séance,aucune ligne ajoutée dans la table. ");
			}

			valeursAutoGenerees = preparedStatement.getGeneratedKeys();

			if (valeursAutoGenerees.next()) {

				propseance.setId_seance_proposition(valeursAutoGenerees.getLong(1));

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
	 * Implémentation de la méthode creerPat() définie dans l'interface
	 * PropositionSeanceDao
	 */

	@Override
	public void creerPat(Seance seance, PropositionSeance propseance, Patient patient)
			throws IllegalArgumentException, DAOException {

		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet valeursAutoGenerees = null;

		try {

			connexion = daoFactory.getConnection();
			preparedStatement = initialisationRequetePreparee(connexion, SQL_INSERT, true,
					propseance.getDate_realisation_seance_proposition(),
					propseance.getHeure_realisation_seance_proposition(), propseance.getHeure_fin_seance_proposition(),
					propseance.getAffichage_date_realisation_seance_proposition(), seance.getId_seance(),
					seance.getIdentifiant_medecin(), seance.getIdentifiant_patient(), seance.getPrenoms_noms_patient(),
					seance.getPrenoms_noms_medecin(), patient.getIdentifiant_patient(),
					patient.getPrenoms_patient() + " " + patient.getNoms_patient()

			);

			int statut = preparedStatement.executeUpdate();

			if (statut == 0) {
				throw new DAOException(
						"Échec de la création de la proposition de séance,aucune ligne ajoutée dans la table. ");
			}

			valeursAutoGenerees = preparedStatement.getGeneratedKeys();

			if (valeursAutoGenerees.next()) {

				propseance.setId_seance_proposition(valeursAutoGenerees.getLong(1));

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
	 * Implémentation de la méthode trouver() définie dans l'interface
	 * PropositionSeanceDao
	 */

	@Override
	public ArrayList<PropositionSeance> trouver(Long idSeance) throws DAOException {

		return trouver(SQL_SELECT_PAR_IDSEANCE, idSeance);
	}

	private ArrayList<PropositionSeance> trouver(String sql, Object objets) throws DAOException {

		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		ArrayList<PropositionSeance> propseances = new ArrayList<PropositionSeance>();

		try {

			/* Récupération d'une connexion depuis la Factory */
			connexion = daoFactory.getConnection();

			preparedStatement = initialisationRequetePreparee(connexion, sql, true, objets);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				propseances.add(map(resultSet));
			}

		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			fermeturesSilencieuses(resultSet, preparedStatement, connexion);
		}

		return propseances;

	}

	/*
	 * Implémentation de la méthode trouver_personne_derniere_prop() définie
	 * dans l'interface PropositionSeanceDao
	 */

	@Override
	public String trouver_personne_derniere_prop(Long idSeance) throws DAOException {

		return trouver_personne_derniere_prop(SQL_SELECT_DERNIERE_PERSONNE_PAR_IDSEANCE, idSeance);
	}

	private String trouver_personne_derniere_prop(String sql, Object objets) throws DAOException {

		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		String identifiant_emission = new String();

		try {

			/* Récupération d'une connexion depuis la Factory */
			connexion = daoFactory.getConnection();

			preparedStatement = initialisationRequetePreparee(connexion, sql, true, objets);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				identifiant_emission = map(resultSet).getIdentifiant_emission();
			}

		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			fermeturesSilencieuses(resultSet, preparedStatement, connexion);
		}

		return identifiant_emission;

	}

	/*
	 * Implémentation de la méthode trouver_personne_derniere_prop() définie
	 * dans l'interface PropositionSeanceDao
	 */

	@Override
	public PropositionSeance trouver_derniere_prop(Long idSeance) throws DAOException {

		return trouver_derniere_prop(SQL_SELECT_DERNIERE_PROP_PAR_IDSEANCE, idSeance);
	}

	private PropositionSeance trouver_derniere_prop(String sql, Object objets) throws DAOException {

		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		PropositionSeance propseance = new PropositionSeance();

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
				propseance = map(resultSet);
			}

		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			fermeturesSilencieuses(resultSet, preparedStatement, connexion);
		}

		return propseance;

	}

	/*
	 * Implémentation de la méthode trouver_prop() définie dans l'interface
	 * PropositionSeanceDao
	 */

	@Override
	public PropositionSeance trouver_prop(Long idprop) throws DAOException {

		return trouver_prop(SQL_SELECT_PROP_PAR_IDPROP, idprop);
	}

	private PropositionSeance trouver_prop(String sql, Object objets) throws DAOException {

		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		PropositionSeance propseance = new PropositionSeance();

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
				propseance = map(resultSet);
			}

		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			fermeturesSilencieuses(resultSet, preparedStatement, connexion);
		}

		return propseance;

	}

	/*
	 * Implémentation de la méthode supprimer_propseance() définie dans
	 * l'interface MedecinDao
	 */

	@Override
	public void supprimer_propseance(Long id_seance) throws IllegalArgumentException, DAOException {

		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet valeursAutoGenerees = null;

		try {

			connexion = daoFactory.getConnection();

			preparedStatement = initialisationRequetePreparee(connexion,
					"DELETE FROM proposition_seance  WHERE id_seance = '" + id_seance + "'", true);

			int statut = preparedStatement.executeUpdate();

			if (statut == 0) {
				throw new DAOException(
						"Échec de la suppression de la proposition,aucune ligne supprimée dans la table proposition seance. ");
			}

		} catch (SQLException e) {

			throw new DAOException(e);

		} finally {

			fermeturesSilencieuses(valeursAutoGenerees, preparedStatement, connexion);

		}

	}

	/*
	 * Simple méthode utilitaire permettant de faire la correspondance (le
	 * mapping) entre une ligne issue de la table des propositions de séances
	 * (un ResultSet) et un bean Seance.
	 */

	private static PropositionSeance map(ResultSet resultSet) throws SQLException {

		PropositionSeance propseance = new PropositionSeance();

		propseance.setId_seance_proposition(resultSet.getLong("id_seance_proposition"));

		propseance.setId_seance(resultSet.getLong("id_seance"));

		propseance.setDate_heure_creation_seance_proposition(
				resultSet.getTimestamp("date_heure_creation_seance_proposition"));

		propseance.setDate_realisation_seance_proposition(resultSet.getDate("date_realisation_seance_proposition"));

		propseance.setHeure_fin_seance_proposition(resultSet.getTime("heure_fin_seance_proposition"));

		propseance.setHeure_realisation_seance_proposition(resultSet.getTime("heure_realisation_seance_proposition"));

		propseance.setAffichage_date_realisation_seance_proposition(
				resultSet.getString("affichage_date_realisation_seance_proposition"));

		propseance.setIdentifiant_medecin_proposition(resultSet.getString("identifiant_medecin_proposition"));

		propseance.setIdentifiant_patient_proposition(resultSet.getString("Identifiant_patient_proposition"));

		propseance.setPrenoms_noms_patient_proposition(resultSet.getString("prenoms_noms_patient_proposition"));

		propseance.setPrenoms_noms_medecin_proposition(resultSet.getString("prenoms_noms_medecin_proposition"));

		propseance.setIdentifiant_emission(resultSet.getString("identifiant_emission"));

		propseance.setPrenoms_noms_emission(resultSet.getString("prenoms_noms_emission"));

		return propseance;

	}

}
