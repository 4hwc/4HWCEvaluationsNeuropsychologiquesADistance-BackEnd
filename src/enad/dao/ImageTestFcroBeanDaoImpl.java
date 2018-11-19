package enad.dao;

import static enad.dao.DAOUtilitaire.fermeturesSilencieuses;
import static enad.dao.DAOUtilitaire.initialisationRequetePreparee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import enad.beans.ImageTestFcroBean;

public class ImageTestFcroBeanDaoImpl implements ImageTestFcroBeanDao {

	private static final String SQL_SELECT_PAR_ID_SEANCE = "SELECT * FROM images_fcro WHERE id_seance = ?";

	private static final String SQL_INSERT = "INSERT INTO images_fcro (id_seance,nom_img_fcro,url_img_fcro,date_heure_creation_img_fcro) VALUES(?,?,?,NOW())";

	private DAOFactory daoFactory;

	ImageTestFcroBeanDaoImpl(DAOFactory daoFactory) {
		this.daoFactory = daoFactory;

	}

	/*
	 * Implémentation de la méthode enregistrerImgFcro() définie dans
	 * l'interface ImageTestFcroBeanDao
	 */
	@Override
	public void enregistrerImgFcro(ImageTestFcroBean imgfcro) throws IllegalArgumentException, DAOException {

		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet valeursAutoGenerees = null;

		try {

			connexion = daoFactory.getConnection();
			preparedStatement = initialisationRequetePreparee(connexion, SQL_INSERT, true, imgfcro.getId_seance(),
					imgfcro.getNom_img_fcro(), imgfcro.getUrl_img_fcro());

			int statut = preparedStatement.executeUpdate();

			if (statut == 0) {
				throw new DAOException("Échec de la création de l'image fcro,aucune ligne ajoutée dans la table. ");
			}

			valeursAutoGenerees = preparedStatement.getGeneratedKeys();

			if (valeursAutoGenerees.next()) {

				imgfcro.setId_image_test_fcro(valeursAutoGenerees.getLong(1));
			} else {
				throw new DAOException("Échec de la création de l'image fcro en base,aucun ID auto-généré retourné.");
			}

		} catch (SQLException e) {
			throw new DAOException(e);
		} finally {

			fermeturesSilencieuses(valeursAutoGenerees, preparedStatement, connexion);
		}

	}

	/*
	 * Implémentation de la méthode occurences_id() définie dans l'interface
	 * ImageTestFcroBeanDao
	 */

	@Override
	public int occurences_idseance(Long id) throws DAOException {

		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		int compteur = 0;

		try {

			/* Récupération d'une connexion depuis la Factory */
			connexion = daoFactory.getConnection();

			preparedStatement = initialisationRequetePreparee(connexion,
					"SELECT id_image_test_fcro FROM images_fcro WHERE  id_seance = '" + id + "'", true);
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
	 * Implémentation de la méthode ImageTestFcroBean_seance() définie dans
	 * l'interface ImageTestFcroBeanDao
	 */

	@Override
	public ArrayList<ImageTestFcroBean> ImageTestFcroBean_seance(Long idseance) throws DAOException {
		return trouverListeImagesFCRO(SQL_SELECT_PAR_ID_SEANCE, idseance);
	}

	private ArrayList<ImageTestFcroBean> trouverListeImagesFCRO(String sql, Object objets) throws DAOException {

		Connection connexion = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		ArrayList<ImageTestFcroBean> liste = new ArrayList<ImageTestFcroBean>();

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
	 * mapping) entre une ligne issue de la table des images fcro (un ResultSet)
	 * et un bean image fcro.
	 */

	private static ImageTestFcroBean map(ResultSet resultSet) throws SQLException {

		ImageTestFcroBean imagefcro = new ImageTestFcroBean();

		imagefcro.setId_image_test_fcro(resultSet.getLong("id_image_test_fcro"));

		imagefcro.setId_seance(resultSet.getLong("id_seance"));

		imagefcro.setNom_img_fcro(resultSet.getString("nom_img_fcro"));

		imagefcro.setUrl_img_fcro(resultSet.getString("url_img_fcro"));

		imagefcro.setDate_heure_creation_img_fcro(resultSet.getTimestamp("date_heure_creation_img_fcro"));

		return imagefcro;
	}

}
