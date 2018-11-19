package enad.dao;

import java.util.ArrayList;

import enad.beans.ImageMmseLangageBean;

public interface ImageMmseLangageBeanDao {

	void enregistrerImgMmseLangage(ImageMmseLangageBean imgmmselangage) throws DAOException;

	ArrayList<ImageMmseLangageBean> ImageMmseLangageBean_liste(Long id_aleatoire) throws DAOException;

}
