package enad.dao;

import static enad.dao.DAOUtilitaire.fermeturesSilencieuses;
import static enad.dao.DAOUtilitaire.initialisationRequetePreparee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import enad.beans.ImageTestTdoiBean;

public class ImageTestTdoiBeanDaoImpl implements ImageTestTdoiBeanDao {

	private static final String SQL_INSERT = "INSERT INTO images_tdoi (id_medecin,nom_img_tdoi,url_img_tdoi,date_heure_creation_img_tdoi) VALUES(?,?,?,NOW())";

	private static final String SQL_SELECT_PAR_ID_MED = "SELECT * FROM images_tdoi WHERE  id_medecin = ?";

	private static final String SQL_SELECT_PAR_IDENTIFIANT_MEDECIN = "SELECT *  FROM images_tdoi WHERE id_image_test_tdoi = ?";

	private DAOFactory daoFactory;

	ImageTestTdoiBeanDaoImpl(DAOFactory daoFactory) {
		this.daoFactory = daoFactory;

	}

	/*
	 * Implémentation de la méthode enregistrerImgTdoi() définie dans
	 * l'interface ImageTestTdoiBeanDao
	 */
	@Override
	public void enregistrerImgTdoi(ImageTestTdoiBean imgtdoi) throws IllegalArgumentException, DAOException {

		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet valeursAutoGenerees = null;

		try {

			connexion = daoFactory.getConnection();
			preparedStatement = initialisationRequetePreparee(connexion, SQL_INSERT, true, imgtdoi.getId_medecin(),
					imgtdoi.getNom_img_tdoi(), imgtdoi.getUrl_img_tdoi());

			int statut = preparedStatement.executeUpdate();

			if (statut == 0) {
				throw new DAOException("Échec de la création de l'image tdoi,aucune ligne ajoutée dans la table. ");
			}

			valeursAutoGenerees = preparedStatement.getGeneratedKeys();

			if (valeursAutoGenerees.next()) {

				imgtdoi.setId_image_test_tdoi(valeursAutoGenerees.getLong(1));

			} else {
				throw new DAOException("Échec de la création de l'image tdoi en base,aucun ID auto-généré retourné.");
			}

		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {

			fermeturesSilencieuses(valeursAutoGenerees, preparedStatement, connexion);
		}

	}

	/*
	 * Implémentation de la méthode trouver_images_medecin() définie dans
	 * l'interface SeanceDao
	 */

	@Override
	public ArrayList<ImageTestTdoiBean> trouver_images_medecin(Long id_Medecin) throws DAOException {

		return trouver_images_medecin(SQL_SELECT_PAR_ID_MED, id_Medecin);
	}

	private ArrayList<ImageTestTdoiBean> trouver_images_medecin(String sql, Object objets) throws DAOException {

		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		ArrayList<ImageTestTdoiBean> images = new ArrayList<ImageTestTdoiBean>();

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
				images.add(map(resultSet));
			}

		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			fermeturesSilencieuses(resultSet, preparedStatement, connexion);
		}

		return images;

	}

	/*
	 * Implémentation de la méthode supprimer_img_tdoi() définie dans
	 * l'interface SeanceDao
	 */

	@Override
	public void supprimer_img_tdoi(Long id) throws IllegalArgumentException, DAOException {

		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet valeursAutoGenerees = null;

		try {

			connexion = daoFactory.getConnection();

			preparedStatement = initialisationRequetePreparee(connexion,
					"DELETE FROM images_tdoi WHERE id_image_test_tdoi = '" + id + "'", true);

			int statut = preparedStatement.executeUpdate();

			if (statut == 0) {
				throw new DAOException("Échec de la suppression de l'image ");
			}

		} catch (SQLException e) {

			throw new DAOException(e);

		} finally {

			fermeturesSilencieuses(valeursAutoGenerees, preparedStatement, connexion);

		}

	}

	/*
	 * Implémentation de la méthode trouver() définie dans l'interface
	 * ImageTestTdoiBeanDao
	 */

	@Override
	public ImageTestTdoiBean trouver(Long id) throws DAOException {
		return trouver(SQL_SELECT_PAR_IDENTIFIANT_MEDECIN, id);
	}

	private ImageTestTdoiBean trouver(String sql, Object objets) throws DAOException {

		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		ImageTestTdoiBean img = new ImageTestTdoiBean();

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
				img = map(resultSet);
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {
			fermeturesSilencieuses(resultSet, preparedStatement, connexion);
		}

		return img;
	}

	/*
	 * Simple méthode utilitaire permettant de faire la correspondance (le
	 * mapping) entre une ligne issue de la table des images tdoi (un ResultSet)
	 * et un bean image tdoi.
	 */

	private static ImageTestTdoiBean map(ResultSet resultSet) throws SQLException {

		ImageTestTdoiBean imagetdoi = new ImageTestTdoiBean();

		imagetdoi.setId_image_test_tdoi(resultSet.getLong("id_image_test_tdoi"));

		imagetdoi.setId_medecin(resultSet.getLong("id_medecin"));

		imagetdoi.setNom_img_tdoi(resultSet.getString("nom_img_tdoi"));

		imagetdoi.setUrl_img_tdoi(resultSet.getString("url_img_tdoi"));

		imagetdoi.setDate_heure_creation_img_tdoi(resultSet.getTimestamp("date_heure_creation_img_tdoi"));

		return imagetdoi;
	}

}
