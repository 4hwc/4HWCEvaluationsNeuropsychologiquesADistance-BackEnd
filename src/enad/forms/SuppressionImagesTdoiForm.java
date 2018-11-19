package enad.forms;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import enad.beans.ImageTestTdoiBean;
import enad.dao.ImageTestTdoiBeanDao;

public final class SuppressionImagesTdoiForm {

	private ImageTestTdoiBeanDao imagetesttdoibeanDao;

	public SuppressionImagesTdoiForm(ImageTestTdoiBeanDao imagetesttdoibeanDao) {

		this.imagetesttdoibeanDao = imagetesttdoibeanDao;

	}

	public void SupprimerImagesTdoi(HttpServletRequest request) {

		String id_img_tdoi = request.getParameter("idtdoi");

		Long id = Long.parseLong(id_img_tdoi);

		ImageTestTdoiBean img = new ImageTestTdoiBean();

		img = imagetesttdoibeanDao.trouver(id);

		String path = "C:\\fichiers\\imagestdoi\\" + img.getNom_img_tdoi();

		try {

			File file = new File(path);

			if (file.delete()) {
				System.out.println(file.getName() + " is deleted!");
			} else {
				System.out.println("Delete operation is failed.");
			}

		} catch (Exception e) {

			e.printStackTrace();

		}

		imagetesttdoibeanDao.supprimer_img_tdoi(id);

	}
}
