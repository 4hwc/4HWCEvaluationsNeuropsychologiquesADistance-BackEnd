package enad.forms;

import javax.servlet.http.HttpServletRequest;

import enad.dao.MmseDao;

public final class PreTraitementDessinRecopierMmseAnnulationForm {

	private MmseDao mmseDao;

	public PreTraitementDessinRecopierMmseAnnulationForm(MmseDao mmseDao) {

		this.mmseDao = mmseDao;
	}

	public void Action(HttpServletRequest request) {

		String identifiantmed = request.getParameter("identifiantmed");

		String identifiantpat = request.getParameter("identifiantpat");

		Long id_aleatoire = Long.parseLong(request.getParameter("id_aleatoire"));

		if (mmseDao.CompteurPreTraitementDessinRecopierMmse(id_aleatoire, identifiantmed, identifiantpat) > 0) {

			mmseDao.supprimerPreTraitementDessinRecopierMmse(id_aleatoire, identifiantmed, identifiantpat);

		}

	}

}
