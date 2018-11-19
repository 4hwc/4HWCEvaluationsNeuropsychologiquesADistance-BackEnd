package enad.forms;

import enad.dao.MedecinDao;
import enad.dao.PropositionSeanceDao;

public final class TransitionCreationProp_ListePropForm {

	private MedecinDao medecinDao;

	private PropositionSeanceDao propositionseanceDao;

	public TransitionCreationProp_ListePropForm(MedecinDao medecinDao, PropositionSeanceDao propositionseanceDao) {

		this.medecinDao = medecinDao;

		this.propositionseanceDao = propositionseanceDao;
	}

}
