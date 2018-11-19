package enad.forms;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import enad.beans.ImageMmsePraxiesConstructivesBean;
import enad.dao.ImageMmsePraxiesConstructivesBeanDao;
import enad.dao.MedecinDao;
import enad.dao.MmseDao;
import enad.dao.PatientDao;

public final class DiaporamaDessinRecopierMmseForm {

	private PatientDao patientDao;

	private MedecinDao medecinDao;

	private MmseDao mmseDao;

	public ArrayList<ImageMmsePraxiesConstructivesBean> liste = new ArrayList<ImageMmsePraxiesConstructivesBean>();

	private ImageMmsePraxiesConstructivesBeanDao imagemmsepraxiesconstructivesbeanDao;

	public DiaporamaDessinRecopierMmseForm(PatientDao patientDao, MmseDao mmseDao, MedecinDao medecinDao,
			ImageMmsePraxiesConstructivesBeanDao imagemmsepraxiesconstructivesbeanDao) {

		this.mmseDao = mmseDao;

		this.imagemmsepraxiesconstructivesbeanDao = imagemmsepraxiesconstructivesbeanDao;

		this.patientDao = patientDao;

		this.medecinDao = medecinDao;

	}

	public void ListeDesImagesMmsePC(HttpServletRequest request) {

		liste = imagemmsepraxiesconstructivesbeanDao
				.ImageMmsePraxiesConstructivesBean_liste(Long.parseLong(request.getParameter("id_aleatoire")));

	}
}
