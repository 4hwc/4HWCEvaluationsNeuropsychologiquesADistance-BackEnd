package enad.dao;

import static enad.dao.DAOUtilitaire.fermeturesSilencieuses;
import static enad.dao.DAOUtilitaire.initialisationRequetePreparee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import enad.beans.ImageMmseLangageBean;

public class ImageMmseLangageBeanDaoImpl implements ImageMmseLangageBeanDao {

	private static final String SQL_INSERT = "INSERT INTO images_mmse_langage (nom_image_langage_mmse,id_image_langage_aleatoire_mmse,url_image_langage_mmse,date_heure_creation_image_langage_mmse) VALUES(?,?,?,NOW())";

	private static final String SQL_SELECT_IMAGES_LANGAGE_PAR_ID_ALEATOIRE = "SELECT * FROM images_mmse_langage WHERE id_image_langage_aleatoire_mmse = ?";

	private DAOFactory daoFactory;

	ImageMmseLangageBeanDaoImpl(DAOFactory daoFactory) {
		this.daoFactory = daoFactory;

	}

	/*
	 * Implémentation de la méthode enregistrerImgMmseLangage() définie dans
	 * l'interface ImageMmseLangageBeanDao
	 */
	@Override
	public void enregistrerImgMmseLangage(ImageMmseLangageBean imgmmselangage)
			throws IllegalArgumentException, DAOException {

		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet valeursAutoGenerees = null;

		try {

			connexion = daoFactory.getConnection();
			preparedStatement = initialisationRequetePreparee(connexion, SQL_INSERT, true,
					imgmmselangage.getNom_image_langage_mmse(), imgmmselangage.getId_image_langage_aleatoire_mmse(),
					imgmmselangage.getUrl_image_langage_mmse());

			int statut = preparedStatement.executeUpdate();

			if (statut == 0) {
				throw new DAOException(
						"Échec de la création de l'image mmselangage,aucune ligne ajoutée dans la table. ");
			}

			valeursAutoGenerees = preparedStatement.getGeneratedKeys();

			if (valeursAutoGenerees.next()) {

				imgmmselangage.setId_mmse_langage(valeursAutoGenerees.getLong(1));

			} else {
				throw new DAOException(
						"Échec de la création de l'image mmselangage en base,aucun ID auto-généré retourné.");
			}

		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {

			fermeturesSilencieuses(valeursAutoGenerees, preparedStatement, connexion);
		}

	}

	/*
	 * Implémentation de la méthode ImageMmseLangageBean_liste() définie dans
	 * l'interface ImageMmseLangageBeanDao
	 */

	@Override
	public ArrayList<ImageMmseLangageBean> ImageMmseLangageBean_liste(Long id_aleatoire) throws DAOException {
		return trouverListeImagesMmseLangage(SQL_SELECT_IMAGES_LANGAGE_PAR_ID_ALEATOIRE, id_aleatoire);
	}

	private ArrayList<ImageMmseLangageBean> trouverListeImagesMmseLangage(String sql, Object objets)
			throws DAOException {

		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		ArrayList<ImageMmseLangageBean> liste = new ArrayList<ImageMmseLangageBean>();

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
	 * et un bean image mmse langage.
	 */

	private static ImageMmseLangageBean map(ResultSet resultSet) throws SQLException {

		ImageMmseLangageBean image_mmse_langage = new ImageMmseLangageBean();

		image_mmse_langage.setId_mmse_langage(resultSet.getLong("id_mmse_langage"));

		image_mmse_langage.setId_image_langage_aleatoire_mmse(resultSet.getLong("id_image_langage_aleatoire_mmse"));

		image_mmse_langage.setNom_image_langage_mmse(resultSet.getString("nom_image_langage_mmse"));

		image_mmse_langage.setUrl_image_langage_mmse(resultSet.getString("url_image_langage_mmse"));

		image_mmse_langage.setDate_heure_creation_image_langage_mmse(
				resultSet.getTimestamp("date_heure_creation_image_langage_mmse"));

		return image_mmse_langage;

	}

}
