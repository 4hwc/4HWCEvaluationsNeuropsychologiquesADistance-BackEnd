package enad.dao;

import java.util.ArrayList;

import enad.beans.ImageTestTdoiBean;

public interface ImageTestTdoiBeanDao {

	void enregistrerImgTdoi(ImageTestTdoiBean imgtdoi) throws DAOException;

	ArrayList<ImageTestTdoiBean> trouver_images_medecin(Long id_Medecin) throws DAOException;

	void supprimer_img_tdoi(Long id) throws DAOException;

	ImageTestTdoiBean trouver(Long id) throws DAOException;

}
