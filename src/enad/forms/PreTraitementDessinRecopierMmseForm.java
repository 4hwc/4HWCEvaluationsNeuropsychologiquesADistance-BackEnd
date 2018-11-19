package enad.forms;

import javax.servlet.http.HttpServletRequest;

import enad.dao.MmseDao;

public final class PreTraitementDessinRecopierMmseForm {

	private MmseDao mmseDao;

	public PreTraitementDessinRecopierMmseForm(MmseDao mmseDao) {

		this.mmseDao = mmseDao;
	}

	public void Action(HttpServletRequest request) {

		String identifiantmed = request.getParameter("identifiantmed");

		String identifiantpat = request.getParameter("identifiantpat");

		Long id_aleatoire = Long.parseLong(request.getParameter("id_aleatoire"));

		if (mmseDao.CompteurPreTraitementDessinRecopierMmse(id_aleatoire, identifiantmed, identifiantpat) == 0) {

			mmseDao.creerPreTraitementDessinRecopierMmse(id_aleatoire, identifiantmed, identifiantpat);

		}

	}

}
