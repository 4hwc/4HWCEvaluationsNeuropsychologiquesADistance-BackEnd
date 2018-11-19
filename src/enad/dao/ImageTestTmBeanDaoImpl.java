package enad.dao;

import static enad.dao.DAOUtilitaire.fermeturesSilencieuses;
import static enad.dao.DAOUtilitaire.initialisationRequetePreparee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import enad.beans.ImageTestTmBean;

public class ImageTestTmBeanDaoImpl implements ImageTestTmBeanDao {

	private static final String SQL_SELECT_PAR_ID_SEANCE_UN = "SELECT * FROM images_tm WHERE id_seance = ? AND version_tm='un'";

	private static final String SQL_SELECT_PAR_ID_SEANCE_DEUX = "SELECT * FROM images_tm WHERE id_seance = ? AND version_tm='deux'";

	private static final String SQL_INSERT = "INSERT INTO images_tm (nom_img_tm,id_seance,url_img_tm,version_tm,date_heure_creation_img_tm) VALUES(?,?,?,?,NOW())";

	private DAOFactory daoFactory;

	ImageTestTmBeanDaoImpl(DAOFactory daoFactory) {
		this.daoFactory = daoFactory;

	}

	/*
	 * Implémentation de la méthode enregistrerImgTm() définie dans l'interface
	 * MedecinDao
	 */
	@Override
	public void enregistrerImgTm(ImageTestTmBean imgtm) throws IllegalArgumentException, DAOException {

		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet valeursAutoGenerees = null;

		try {

			connexion = daoFactory.getConnection();
			preparedStatement = initialisationRequetePreparee(connexion, SQL_INSERT, true, imgtm.getNom_img_tm(),
					imgtm.getId_seance(), imgtm.getUrl_img_tm(), imgtm.getVersion_tm());

			int statut = preparedStatement.executeUpdate();

			if (statut == 0) {
				throw new DAOException("Échec de la création de l'image tm,aucune ligne ajoutée dans la table. ");
			}

			valeursAutoGenerees = preparedStatement.getGeneratedKeys();

			if (valeursAutoGenerees.next()) {

				imgtm.setId_image_test_tm(valeursAutoGenerees.getLong(1));

			} else {
				throw new DAOException("Échec de la création de l'image tm en base,aucun ID auto-généré retourné.");
			}

		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {

			fermeturesSilencieuses(valeursAutoGenerees, preparedStatement, connexion);
		}

	}

	/*
	 * Implémentation de la méthode occurences_idseance_tm_un() définie dans
	 * l'interface ImageTestFcroBeanDao
	 */

	@Override
	public int occurences_idseance_tm_un(Long id) throws DAOException {

		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		int compteur = 0;

		try {

			/* Récupération d'une connexion depuis la Factory */
			connexion = daoFactory.getConnection();

			preparedStatement = initialisationRequetePreparee(connexion,
					"SELECT id_image_test_tm FROM images_tm WHERE  id_seance = '" + id + "' AND version_tm = 'un'",
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
	 * Implémentation de la méthode occurences_idseance_tm_deux() définie dans
	 * l'interface ImageTestFcroBeanDao
	 */

	@Override
	public int occurences_idseance_tm_deux(Long id) throws DAOException {

		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		int compteur = 0;

		try {

			/* Récupération d'une connexion depuis la Factory */
			connexion = daoFactory.getConnection();

			preparedStatement = initialisationRequetePreparee(connexion,
					"SELECT id_image_test_tm FROM images_tm WHERE  id_seance = '" + id + "' AND version_tm = 'deux'",
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
	 * Implémentation de la méthode ImageTestTmUnBean_seance() définie dans
	 * l'interface ImageTestTmBeanDao
	 */

	@Override
	public ArrayList<ImageTestTmBean> ImageTestTmUnBean_seance(Long idseance) throws DAOException {
		return trouverListeImagesTM(SQL_SELECT_PAR_ID_SEANCE_UN, idseance);
	}

	/*
	 * Implémentation de la méthode ImageTestTmDeuxBean_seance() définie dans
	 * l'interface ImageTestTmBeanDao
	 */

	@Override
	public ArrayList<ImageTestTmBean> ImageTestTmDeuxBean_seance(Long idseance) throws DAOException {
		return trouverListeImagesTM(SQL_SELECT_PAR_ID_SEANCE_DEUX, idseance);
	}

	private ArrayList<ImageTestTmBean> trouverListeImagesTM(String sql, Object objets) throws DAOException {

		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		ArrayList<ImageTestTmBean> liste = new ArrayList<ImageTestTmBean>();

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
	 * et un bean image tm.
	 */

	private static ImageTestTmBean map(ResultSet resultSet) throws SQLException {

		ImageTestTmBean imagetm = new ImageTestTmBean();

		imagetm.setId_image_test_tm(resultSet.getLong("id_image_test_tm"));

		imagetm.setId_seance(resultSet.getLong("id_seance"));

		imagetm.setNom_img_tm(resultSet.getString("nom_img_tm"));

		imagetm.setUrl_img_tm(resultSet.getString("url_img_tm"));

		imagetm.setVersion_tm(resultSet.getString("version_tm"));

		imagetm.setDate_heure_creation_img_tm(resultSet.getTimestamp("date_heure_creation_img_tm"));

		return imagetm;
	}

}
