package enad.dao;

import java.util.ArrayList;

import enad.beans.ImageTestFcroBean;

public interface ImageTestFcroBeanDao {

	void enregistrerImgFcro(ImageTestFcroBean imgfcro) throws DAOException;

	int occurences_idseance(Long id) throws DAOException;

	ArrayList<ImageTestFcroBean> ImageTestFcroBean_seance(Long idseance) throws DAOException;

}
