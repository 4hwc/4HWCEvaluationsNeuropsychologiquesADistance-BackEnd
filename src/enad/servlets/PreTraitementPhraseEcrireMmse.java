package enad.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import enad.dao.DAOFactory;
import enad.dao.MmseDao;
import enad.forms.PreTraitementPhraseEcrireMmseForm;

public class PreTraitementPhraseEcrireMmse extends HttpServlet {

	private MmseDao mmseDao;

	public static final String CONF_DAO_FACTORY = "daofactory";

	public void init() throws ServletException {

		this.mmseDao = ((DAOFactory) getServletContext().getAttribute(CONF_DAO_FACTORY)).getMmseDao();

	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PreTraitementPhraseEcrireMmseForm form = new PreTraitementPhraseEcrireMmseForm(mmseDao);

		form.Action(request);

	}

}
