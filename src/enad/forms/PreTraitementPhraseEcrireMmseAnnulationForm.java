package enad.forms;

import javax.servlet.http.HttpServletRequest;

import enad.dao.MmseDao;

public final class PreTraitementPhraseEcrireMmseAnnulationForm {

	private MmseDao mmseDao;

	public PreTraitementPhraseEcrireMmseAnnulationForm(MmseDao mmseDao) {

		this.mmseDao = mmseDao;
	}

	public void Action(HttpServletRequest request) {

		String identifiantmed = request.getParameter("identifiantmed");

		String identifiantpat = request.getParameter("identifiantpat");

		Long id_aleatoire = Long.parseLong(request.getParameter("id_aleatoire"));

		if (mmseDao.CompteurPreTraitementPhraseEcrireMmse(id_aleatoire, identifiantmed, identifiantpat) > 0) {

			mmseDao.supprimerPreTraitementPhraseEcrireMmse(id_aleatoire, identifiantmed, identifiantpat);

		}

	}

}
