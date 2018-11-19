package enad.dao;

import java.util.ArrayList;

import enad.beans.ImageMmsePraxiesConstructivesBean;

public interface ImageMmsePraxiesConstructivesBeanDao {

	void enregistrerImgMmsePraxiesConstructives(ImageMmsePraxiesConstructivesBean imgmmsepraxiesconstructives)
			throws DAOException;

	ArrayList<ImageMmsePraxiesConstructivesBean> ImageMmsePraxiesConstructivesBean_liste(Long id_aleatoire)
			throws DAOException;

}
