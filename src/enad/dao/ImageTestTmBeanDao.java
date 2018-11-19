package enad.dao;

import java.util.ArrayList;

import enad.beans.ImageTestTmBean;

public interface ImageTestTmBeanDao {

	void enregistrerImgTm(ImageTestTmBean imgtm) throws DAOException;

	int occurences_idseance_tm_un(Long id) throws DAOException;

	int occurences_idseance_tm_deux(Long id) throws DAOException;

	ArrayList<ImageTestTmBean> ImageTestTmUnBean_seance(Long idseance) throws DAOException;

	ArrayList<ImageTestTmBean> ImageTestTmDeuxBean_seance(Long idseance) throws DAOException;

}
