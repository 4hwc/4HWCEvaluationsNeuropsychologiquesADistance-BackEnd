package enad.dao;

import static enad.dao.DAOUtilitaire.fermeturesSilencieuses;
import static enad.dao.DAOUtilitaire.initialisationRequetePreparee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import enad.beans.ImageMmsePraxiesConstructivesBean;

public class ImageMmsePraxiesConstructivesBeanDaoImpl implements ImageMmsePraxiesConstructivesBeanDao {

	private static final String SQL_INSERT = "INSERT INTO images_mmse_praxies_constructives (nom_image_praxiesconstructives_mmse,id_image_praxiesconstructives_aleatoire_mmse,url_image_praxiesconstructives_mmse,date_heure_creation_image_praxiesconstructives_mmse) VALUES(?,?,?,NOW())";

	private static final String SQL_SELECT_IMAGES_PC_PAR_ID_ALEATOIRE = "SELECT * FROM images_mmse_praxies_constructives WHERE 	id_image_praxiesconstructives_aleatoire_mmse = ?";

	private DAOFactory daoFactory;

	ImageMmsePraxiesConstructivesBeanDaoImpl(DAOFactory daoFactory) {
		this.daoFactory = daoFactory;

	}

	/*
	 * Implémentation de la méthode enregistrerImgMmsePraxiesConstructives()
	 * définie dans l'interface ImageMmsePraxiesConstructivesBeanDao
	 */
	@Override
	public void enregistrerImgMmsePraxiesConstructives(ImageMmsePraxiesConstructivesBean imgmmsepraxiesconstructives)
			throws IllegalArgumentException, DAOException {

		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet valeursAutoGenerees = null;

		try {

			connexion = daoFactory.getConnection();
			preparedStatement = initialisationRequetePreparee(connexion, SQL_INSERT, true,
					imgmmsepraxiesconstructives.getNom_image_PraxiesConstructives_mmse(),
					imgmmsepraxiesconstructives.getId_image_PraxiesConstructives_aleatoire_mmse(),
					imgmmsepraxiesconstructives.getUrl_image_PraxiesConstructives_mmse());

			int statut = preparedStatement.executeUpdate();

			if (statut == 0) {
				throw new DAOException(
						"Échec de la création de l'image mmsepraxiesconstructives,aucune ligne ajoutée dans la table. ");
			}

			valeursAutoGenerees = preparedStatement.getGeneratedKeys();

			if (valeursAutoGenerees.next()) {

				imgmmsepraxiesconstructives.setId_mmse_PraxiesConstructives(valeursAutoGenerees.getLong(1));

			} else {
				throw new DAOException(
						"Échec de la création de l'image mmsepraxiesconstructives en base,aucun ID auto-généré retourné.");
			}

		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {

			fermeturesSilencieuses(valeursAutoGenerees, preparedStatement, connexion);
		}

	}

	/*
	 * Implémentation de la méthode ImageMmsePraxiesConstructivesBean_liste()
	 * définie dans l'interface ImageMmseLangageBeanDao
	 */

	@Override
	public ArrayList<ImageMmsePraxiesConstructivesBean> ImageMmsePraxiesConstructivesBean_liste(Long id_aleatoire)
			throws DAOException {
		return trouverListeImagesMmsePC(SQL_SELECT_IMAGES_PC_PAR_ID_ALEATOIRE, id_aleatoire);
	}

	private ArrayList<ImageMmsePraxiesConstructivesBean> trouverListeImagesMmsePC(String sql, Object objets)
			throws DAOException {

		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		ArrayList<ImageMmsePraxiesConstructivesBean> liste = new ArrayList<ImageMmsePraxiesConstructivesBean>();

		try {
			/* Récupération d'une connexion depuis la Factory */
			connexion = daoFactory.getConnection();

			preparedStatement = initialisationRequetePreparee(connexion, sql, false, objets);
			resultSet = preparedStatement.executeQuery();

			/* Parcours de la ligne de données retournée dans le ResultSet */

			while (resultSet.next()) {

				liste.add(map(resultSet));

			}
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			fermeturesSilencieuses(resultSet, preparedStatement, connexion);
		}

		return liste;
	}

	/*
	 * Simple méthode utilitaire permettant de faire la correspondance (le
	 * mapping) entre une ligne issue de la table des images tm (un ResultSet)
	 * et un bean image mmse pc.
	 */

	private static ImageMmsePraxiesConstructivesBean map(ResultSet resultSet) throws SQLException {

		ImageMmsePraxiesConstructivesBean image_mmse_pc = new ImageMmsePraxiesConstructivesBean();

		image_mmse_pc.setId_mmse_PraxiesConstructives(resultSet.getLong("id_mmse_praxiesconstructives"));

		image_mmse_pc.setId_image_PraxiesConstructives_aleatoire_mmse(
				resultSet.getLong("id_image_praxiesconstructives_aleatoire_mmse"));

		image_mmse_pc
				.setNom_image_PraxiesConstructives_mmse(resultSet.getString("nom_image_praxiesconstructives_mmse"));

		image_mmse_pc
				.setUrl_image_PraxiesConstructives_mmse(resultSet.getString("url_image_praxiesconstructives_mmse"));

		image_mmse_pc.setDate_heure_creation_image_PraxiesConstructives_mmse(
				resultSet.getTimestamp("date_heure_creation_image_praxiesconstructives_mmse"));

		return image_mmse_pc;

	}

}
