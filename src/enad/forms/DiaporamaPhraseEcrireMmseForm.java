package enad.forms;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import enad.beans.ImageMmseLangageBean;
import enad.dao.ImageMmseLangageBeanDao;
import enad.dao.MedecinDao;
import enad.dao.MmseDao;
import enad.dao.PatientDao;

public final class DiaporamaPhraseEcrireMmseForm {

	private PatientDao patientDao;

	private MedecinDao medecinDao;

	private MmseDao mmseDao;

	private ImageMmseLangageBeanDao imagemmselangagebeanDao;

	public ArrayList<ImageMmseLangageBean> liste = new ArrayList<ImageMmseLangageBean>();

	public DiaporamaPhraseEcrireMmseForm(PatientDao patientDao, MmseDao mmseDao, MedecinDao medecinDao,
			ImageMmseLangageBeanDao imagemmselangagebeanDao) {

		this.mmseDao = mmseDao;

		this.imagemmselangagebeanDao = imagemmselangagebeanDao;

		this.patientDao = patientDao;

		this.medecinDao = medecinDao;

	}

	public void ListeDesImagesMmseLangage(HttpServletRequest request) {

		liste = imagemmselangagebeanDao
				.ImageMmseLangageBean_liste(Long.parseLong(request.getParameter("id_aleatoire")));

	}

}
