/**
 * 
 */
package enad.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Admin
 *
 */
public class DAOUtilitaire {

	/*
	 * Constructeur caché par défaut (car c'est une classe finale utilitaire,
	 * contenant uniquement des méthodes appelées de manière statique)
	 */

	/* Fermeture silencieuse du resultset */
	public static void fermetureSilencieuse(ResultSet resultSet) {
		if (resultSet != null) {
			try {
				resultSet.close();

			} catch (SQLException e) {
				System.out.println("Échec de la fermeture du ResultSet : " + e.getMessage());
			}
		}
	}

	/* Fermeture silencieuse du statement */
	public static void fermetureSilencieuse(Statement statement) {
		if (statement != null) {
			try {
				statement.close();

			} catch (SQLException e) {
				System.out.println("Échec de la fermeture du Statement : " + e.getMessage());
			}
		}
	}

	/* Fermeture silencieuse de la connexion */

	public static void fermetureSilencieuse(Connection connexion) {
		if (connexion != null) {
			try {
				connexion.close();

			} catch (SQLException e) {
				System.out.println("Échec de la fermeture de la connexion : " + e.getMessage());
			}
		}
	}

	/* Fermetures silencieuses du statement et de la connexion */

	public static void fermeturesSilencieuses(Statement statement, Connection connexion) {
		fermetureSilencieuse(statement);
		fermetureSilencieuse(connexion);
	}

	/* Fermetures silencieuses du resultset,du statement et de la connexion */
	public static void fermeturesSilencieuses(ResultSet resultset, Statement statement, Connection connexion) {
		fermetureSilencieuse(resultset);
		fermetureSilencieuse(statement);
		fermetureSilencieuse(connexion);
	}

	/*
	 * Initialise la requête préparée basée sur la connexion pazsée en argument,
	 * avec la requête SQL et les objets donnés.
	 */

	public static PreparedStatement initialisationRequetePreparee(Connection connexion, String sql,
			boolean returnGeneratedKeys, Object... objets) throws SQLException {

		PreparedStatement preparedStatement = connexion.prepareStatement(sql,
				returnGeneratedKeys ? Statement.RETURN_GENERATED_KEYS : Statement.NO_GENERATED_KEYS);

		for (int i = 0; i < objets.length; i++) {
			preparedStatement.setObject(i + 1, objets[i]);
		}
		return preparedStatement;
	}

}
