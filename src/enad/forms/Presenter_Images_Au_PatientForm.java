package enad.forms;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import enad.beans.ImageTestTdoiBean;
import enad.beans.Medecin;
import enad.dao.ImageTestTdoiBeanDao;

public final class Presenter_Images_Au_PatientForm {

	private ImageTestTdoiBeanDao imagetesttdoibeanDao;

	public ArrayList<ImageTestTdoiBean> liste = new ArrayList<ImageTestTdoiBean>();

	public static final String ATT_SESSION_MEDECIN = "sessionMedecin";

	public Presenter_Images_Au_PatientForm(ImageTestTdoiBeanDao imagetesttdoibeanDao) {

		this.imagetesttdoibeanDao = imagetesttdoibeanDao;

	}

	public void ListeDesImagesTdoi(HttpServletRequest request) {

		HttpSession session = request.getSession();

		Long id_med = ((Medecin) session.getAttribute(ATT_SESSION_MEDECIN)).getId_medecin();

		liste = imagetesttdoibeanDao.trouver_images_medecin(id_med);

	}

}
