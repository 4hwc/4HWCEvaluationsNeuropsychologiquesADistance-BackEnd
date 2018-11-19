/**
 * 
 */
package enad.filters;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import enad.dao.BrefDao;
import enad.dao.DAOFactory;
import enad.dao.ImageMmseLangageBeanDao;
import enad.dao.ImageMmsePraxiesConstructivesBeanDao;
import enad.dao.ImageTestFcroBeanDao;
import enad.dao.ImageTestTdoiBeanDao;
import enad.dao.ImageTestTmBeanDao;
import enad.dao.MedecinDao;
import enad.dao.MmseDao;
import enad.dao.PatientDao;
import enad.dao.PropositionSeanceDao;
import enad.dao.SeanceDao;

/**
 * @author Admin
 *
 */
public class RestrictionFilter implements Filter {

	// Pages publiques

	public static final String MEDECIN = "/enad/inscription_connexion_Medecin";

	public static final String ADMIN = "/enad/enad_admin_connexion";

	public static final String PATIENT = "/enad/inscription_connexion_Patient";

	public static final String MEDECIN_PATIENT = "/enad/enad";

	public static final String ACCUEIL_PATIENT = "/enad/accueil_Patient";

	public static final String ACCUEIL_MEDECIN = "/enad/accueil_Medecin";

	public static final String ACCUEIL_ADMIN = "/enad/accueil_Admin";

	// Sessions medecin ; patient ; admin

	public static final String ATT_SESSION_MEDECIN = "sessionMedecin";

	public static final String ATT_SESSION_PATIENT = "sessionPatient";

	public static final String ATT_SESSION_ADMIN = "sessionAdmin";

	private PatientDao patientDao;

	private MedecinDao medecinDao;

	private SeanceDao seanceDao;

	private PropositionSeanceDao propositionseanceDao;

	private ImageTestFcroBeanDao imagetestfcrobeanDao;

	private ImageTestTmBeanDao imagetesttmbeanDao;

	private ImageTestTdoiBeanDao imagetesttdoibeanDao;

	private BrefDao brefDao;

	private MmseDao mmseDao;

	private ImageMmseLangageBeanDao imagemmselangagebeanDao;

	private ImageMmsePraxiesConstructivesBeanDao imagemmsepraxiesconstructivesbeanDao;

	public static final String CONF_DAO_FACTORY = "daofactory";

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#destroy()
	 */
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest,
	 * javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub

		ArrayList<String> urls_medecin = new ArrayList<String>();

		ArrayList<String> urls_patient = new ArrayList<String>();

		ArrayList<String> urls_admin = new ArrayList<String>();

		ArrayList<String> urls_medecin_patient = new ArrayList<String>();

		int capteur_urls_medecin = 0;
		int capteur_urls_patient = 0;
		int capteur_urls_admin = 0;
		int capteur_urls_medecin_patient = 0;

		/* Liste des urls avec session réservés au médecin et patient */

		urls_medecin_patient.add("/profil_Medecin");

		urls_medecin_patient.add("/profil_Patient");

		urls_medecin_patient.add("/etreenrelation_med_med");

		urls_medecin_patient.add("/confirmation_medt_pat");

		urls_medecin_patient.add("/confirmation_med_pat");

		urls_medecin_patient.add("/etreenrelation_medt_pat");

		urls_medecin_patient.add("/etreenrelation_med_pat");

		urls_medecin_patient.add("/realisation_fcro");

		urls_medecin_patient.add("/realisation_tm_un");

		urls_medecin_patient.add("/realisation_tm_deux");

		urls_medecin_patient.add("/realisation_phrase_ecrire_mmse");

		urls_medecin_patient.add("/realisation_dessin_recopier_mmse");

		urls_medecin_patient.add("/imagesphotoprofilpatient/");

		urls_medecin_patient.add("/imagesphotoprofilmedecin/");//

		/* Liste des urls avec session réservés de médecin */

		urls_medecin.add("/diaporama_dessin_recopier_mmse");

		urls_medecin.add("/diaporama_phrase_ecrire_mmse");

		urls_medecin.add("/attente_dessin_recopier");

		urls_medecin.add("/pre_traitement_dessin_recopier_mmse_annulation");

		urls_medecin.add("/pre_traitement_dessin_recopier_mmse");

		urls_medecin.add("/attente_phrase_ecrire");

		urls_medecin.add("/pre_traitement_phrase_ecrire_mmse_annulation");

		urls_medecin.add("/pre_traitement_phrase_ecrire_mmse");

		urls_medecin.add("/diaporama_fcro");

		urls_medecin.add("/resultats_bref_patient");

		urls_medecin.add("/resultats_bref_patient_unique");

		urls_medecin.add("/resultats_mmse_patient_unique");

		urls_medecin.add("/photoMedecin");

		urls_medecin.add("/encharge_Medecin");

		urls_medecin.add("/collegues_Medecin");

		urls_medecin.add("/recherches_Medecin");

		urls_medecin.add("/resultats_bref_chrono_croissant");

		urls_medecin.add("/resultats_bref_chrono_croissant_unique");

		urls_medecin.add("/resultats_bref_chrono_decroissant");

		urls_medecin.add("/resultats_bref_chrono_decroissant_unique");

		urls_medecin.add("/resultats_mmse_chrono_croissant");

		urls_medecin.add("/resultats_mmse_chrono_decroissant");

		urls_medecin.add("/resultats_mmse_croissant");

		urls_medecin.add("/resultats_mmse_decroissant");

		urls_medecin.add("/resultats_mmse_chrono_croissant_unique");

		urls_medecin.add("/resultats_mmse_chrono_decroissant_unique");

		urls_medecin.add("/resultats_mmse_croissant_unique");

		urls_medecin.add("/resultats_mmse_decroissant_unique");

		urls_medecin.add("/imagesTdoiMiniature");

		urls_medecin.add("/suppression_imagesTdoi");

		urls_medecin.add("/resultats_trail_making_deux");

		urls_medecin.add("/resultats_trail_making_un");

		urls_medecin.add("/diaporama_tm_un");

		urls_medecin.add("/diaporama_tm_deux");

		urls_medecin.add("/accueil_Medecin");

		urls_medecin.add("/testsetresultats_Medecin");

		urls_medecin.add("/fc_Rey_Osterrieth");

		urls_medecin.add("/envoyer_fc_Rey_Osterrieth");

		urls_medecin.add("/informations_fc_Rey_Osterrieth");

		urls_medecin.add("/resultats_fc_Rey_Osterrieth");

		urls_medecin.add("/commentaires_fc_Rey_Osterrieth");

		urls_medecin.add("/diagnostics_fc_Rey_Osterrieth");

		urls_medecin.add("/trail_making");

		urls_medecin.add("/envoyer_trail_making");

		urls_medecin.add("/envoyer_trail_making_un");

		urls_medecin.add("/envoyer_trail_making_deux");

		urls_medecin.add("/informations_trail_making");

		urls_medecin.add("/resultats_trail_making");

		urls_medecin.add("/commentaires_trail_making");

		urls_medecin.add("/diagnostics_trail_making");

		urls_medecin.add("/test_denomination_orale_images");

		urls_medecin.add("/presenter_images");

		urls_medecin.add("/telecharger_classer_images");

		urls_medecin.add("/informations_tdoi");

		urls_medecin.add("/resultats_tdoi");

		urls_medecin.add("/diagnostics_tdoi");

		urls_medecin.add("/commentaires_tdoi");

		urls_medecin.add("/batterie_rapide_efficience_frontale");

		urls_medecin.add("/formulaire_batterie_rapide_efficience_frontale");

		urls_medecin.add("/informations_batterie_rapide_efficience_frontale");

		urls_medecin.add("/resultats_batterie_rapide_efficience_frontale");

		urls_medecin.add("/commentaires_batterie_rapide_efficience_frontale");

		urls_medecin.add("/diagnostics_batterie_rapide_efficience_frontale");

		urls_medecin.add("/mmse");

		urls_medecin.add("/formulaire_mmse");

		urls_medecin.add("/informations_mmse");

		urls_medecin.add("/resultats_mmse");

		urls_medecin.add("/commentaires_mmse");

		urls_medecin.add("/diagnostics_mmse");

		urls_medecin.add("/carnetsdesante_Medecin");

		urls_medecin.add("/commentaires_Medecin");

		urls_medecin.add("/creation_commentaires_Medecin");

		urls_medecin.add("/liste_commentaires_Medecin");

		urls_medecin.add("/diagnostics_Medecin");

		urls_medecin.add("/creation_diagnostics_Medecin");

		urls_medecin.add("/liste_diagnostics_Medecin");

		urls_medecin.add("/liste_proposition_seances_medecin");

		urls_medecin.add("/groupes_Medecin");

		urls_medecin.add("/creation_groupes_Medecin");

		urls_medecin.add("/liste_groupes_Medecin");

		urls_medecin.add("/seances_Medecin");

		urls_medecin.add("/suppressionSeance");

		urls_medecin.add("/creation_seances_Medecin");

		urls_medecin.add("/liste_seances_Medecin");

		urls_medecin.add("/liste_seances_validation_Medecin");

		urls_medecin.add("/liste_seances_validees_Medecin");

		urls_medecin.add("/liste_seances_validees_suiv_Medecin");

		urls_medecin.add("/liste_seances_validees_prec_Medecin");

		urls_medecin.add("/liste_seances_validees_jour_Medecin");

		urls_medecin.add("/creation_proposition_seances_Medecin");

		urls_medecin.add("/validation_proposition_seance_Medecin");

		urls_medecin.add("/transitionCreationProp_ListePropMedecin");

		urls_medecin.add("/confirmation_med_med");

		urls_medecin.add("/modification_noms_Medecin");

		urls_medecin.add("/modification_prenoms_Medecin");

		urls_medecin.add("/modification_identifiant_Medecin");

		urls_medecin.add("/modification_mdp_Medecin");

		urls_medecin.add("/attente_Fcro_Medecin");

		urls_medecin.add("/attente_tm_Medecin_un");

		urls_medecin.add("/attente_tm_Medecin_deux");

		urls_medecin.add("/deconnexionMedecin");

		urls_medecin.add("/imagesdutestfcro/");

		urls_medecin.add("/imagesdutesttm/");

		urls_medecin.add("/imagestdoi/");

		urls_medecin.add("/imagesmmselangage/");

		urls_medecin.add("/imagesmmsepraxiesconstructives/");

		urls_medecin.add("/uploadimagesphotoprofilmedecin");

		urls_medecin.add("/uploadimagestdoi");

		urls_medecin.add("/resultats_bref_croissant");

		urls_medecin.add("/resultats_mmse_patient");

		urls_medecin.add("/resultats_bref_croissant_unique");

		urls_medecin.add("/resultats_bref_decroissant");

		urls_medecin.add("/resultats_bref_decroissant_unique");

		/* Liste des urls avec session réservés de patient */

		urls_patient.add("/photoPatient");

		urls_patient.add("/uploadimagesphotoprofilpatient");

		urls_patient.add("/recherches_Patient");

		// urls_patient.add("/profil_Medecin");

		urls_patient.add("/accueil_Patient");

		urls_patient.add("/seances_Patient");

		urls_patient.add("/liste_seances_validees_Patient");

		urls_patient.add("/liste_seances_validation_Patient");

		urls_patient.add("/liste_seances_validees_prec_Patient");

		urls_patient.add("/liste_seances_validees_suiv_Patient");

		urls_patient.add("/liste_seances_validees_jour_Patient");

		urls_patient.add("/carnetdesante_Patient");

		urls_patient.add("/telecharger_carnetdesante_Patient");

		urls_patient.add("/consulter_carnetdesante_Patient");

		urls_patient.add("/liste_proposition_seances_patient");

		urls_patient.add("/validation_seance_Patient");

		urls_patient.add("/creation_proposition_seances_patient");

		urls_patient.add("/validation_proposition_seance_Patient");

		urls_patient.add("/modification_noms_Patient");

		urls_patient.add("/modification_prenoms_Patient");

		urls_patient.add("/modification_identifiant_Patient");

		urls_patient.add("/modification_sexe_Patient");

		urls_patient.add("/modification_masse_Patient");

		urls_patient.add("/modification_taille_Patient");

		urls_patient.add("/modification_datenaissance_Patient");

		urls_patient.add("/deconnexionPatient");

		urls_patient.add("/captureimagefcro");

		urls_patient.add("/captureimagetm");

		urls_patient.add("/captureimagemmselangage");

		urls_patient.add("/captureimagemmsepraxiesconstructives");

		urls_patient.add("/medecinsduPatient");

		/* Liste des urls avec session réservés d'admin */

		urls_admin.add("/accueil_Admin");

		/* Cast des objets request et response */

		HttpServletRequest request = (HttpServletRequest) req;

		HttpServletResponse response = (HttpServletResponse) resp;

		/* Récupération de la session depuis la requête */

		HttpSession session = request.getSession();

		/* Non filtrage des ressources statiques */

		String urio = request.getRequestURI();

		if (urio.contains("/imagesfileupload/")) {

			chain.doFilter(request, response);

		}

		String chemin = request.getRequestURI().substring(request.getContextPath().length());

		// sessions actives ou pas

		if (chemin.startsWith("/inc") || chemin.startsWith("/notice") || chemin.startsWith("/realisationSlider")
				|| chemin.startsWith("/fileupload") || chemin.startsWith("/dragndrop")
				|| chemin.startsWith("/facebookcustomdialog") || chemin.startsWith("/voicerecognition")
				|| chemin.startsWith("/canvasMachinesVortex") || chemin.startsWith("/williammaloneDrawing")
				|| chemin.startsWith("/drawingOnCanvas") || chemin.startsWith("/realtime")
				|| chemin.startsWith("/realisationSlider") || chemin.startsWith("/screencapture_un")
				|| chemin.startsWith("/googlebouncingballs") || chemin.startsWith("/fichiertest")
				|| chemin.startsWith("/digitalclockfrench") || chemin.startsWith("/weather")
				|| chemin.startsWith("/canvasgears") || chemin.startsWith("/screenshots")
				|| chemin.startsWith("/htmltocanvas") || chemin.startsWith("/canvastoimage")
				|| chemin.startsWith("/screensharing") || chemin.startsWith("/getusermedia")
				|| chemin.startsWith("/screencapture") || chemin.startsWith("/divhauteur")
				|| chemin.startsWith("/paintapplication") || chemin.startsWith("/colorpicker")
				|| chemin.startsWith("/digitalclock") || chemin.startsWith("/countdownclock")
				|| chemin.startsWith("/facebookchat") || chemin.startsWith("/essai")
				|| chemin.startsWith("/essaiTailleFenetre") || chemin.startsWith("/refresh")
				|| chemin.startsWith("/webrtcimages") || chemin.startsWith("/noticePatient_e")
				|| chemin.startsWith("/noticeMedecin") || chemin.startsWith("/noticeMedecin_Inscription")
				|| chemin.startsWith("/noticeMedecin_Connexion") || chemin.startsWith("/noticeMedecin_Menu")
				|| chemin.startsWith("/noticeMedecin_Navigation") || chemin.startsWith("/noticePatient_Inscription")
				|| chemin.startsWith("/noticePatient_Connexion") || chemin.startsWith("/noticePatient_Menu")
				|| chemin.startsWith("/noticePatient_Navigation")
				|| chemin.startsWith("/installation_Utilisation_Extension_Images")
				|| chemin.startsWith("/utilisation_extension")) {

			chain.doFilter(request, response);

		}

		// sessions pas actives

		if (chemin.startsWith("/Bienvenue_Sur_ENAD") || chemin.startsWith("/inscription_connexion_Patient")
				|| chemin.startsWith("/inscription_connexion_Medecin") || chemin.startsWith("/enad_accueil")
				|| chemin.startsWith("/enad") || chemin.startsWith("/inscription_Medecin")
				|| chemin.startsWith("/connexion_Medecin") || chemin.startsWith("/inscription_Patient")
				|| chemin.startsWith("/connexion_Patient") || chemin.startsWith("/enad_admin")
				|| chemin.startsWith("/enad_admin_connexion") || chemin.startsWith("/remerciements")
				|| chemin.startsWith("/notif") || chemin.startsWith("/jauge")
				|| chemin.startsWith("/recherche_par_identifiants_Patient")
				|| chemin.startsWith("/recherche_par_prenoms_noms_Patient") || chemin.startsWith("/oubli_Motdepasse")
				|| chemin.startsWith("/transitionRpnAp")

		) {

			if ((session.getAttribute(ATT_SESSION_MEDECIN) != null)
					|| (session.getAttribute(ATT_SESSION_PATIENT) != null)
					|| (session.getAttribute(ATT_SESSION_ADMIN) != null)) {

				if (session.getAttribute(ATT_SESSION_MEDECIN) != null) {

					response.sendRedirect(ACCUEIL_MEDECIN);

				}

				if (session.getAttribute(ATT_SESSION_PATIENT) != null) {

					response.sendRedirect(ACCUEIL_PATIENT);

				}

				if (session.getAttribute(ATT_SESSION_ADMIN) != null) {

					response.sendRedirect(ACCUEIL_ADMIN);

				}

			} else {

				chain.doFilter(request, response);

			}

		}

		/*
		 * Si l'objet utilisateur (medecin ou patient ou admin) n'existe pas
		 * dans la session en cours,
		 * 
		 * alors l'utilisateur n'est pas connecté
		 */

		String uri = request.getRequestURI();

		if (capteur_urls_medecin_patient == 0) {

			for (int i = 0; i < urls_medecin_patient.size(); i++) {

				if (uri.contains(urls_medecin_patient.get(i))) {

					capteur_urls_medecin_patient++;

					break;

				}

			}

			if (capteur_urls_medecin_patient == 1) {

				if (session.getAttribute(ATT_SESSION_MEDECIN) != null
						|| session.getAttribute(ATT_SESSION_PATIENT) != null) {

					chain.doFilter(request, response);

				} else {

					response.sendRedirect(MEDECIN_PATIENT);

				}

			}

		}

		if (capteur_urls_medecin == 0) {

			for (int i = 0; i < urls_medecin.size(); i++) {

				if (uri.contains(urls_medecin.get(i))) {

					capteur_urls_medecin++;

					break;

				}

			}

			if (capteur_urls_medecin == 1) {

				if (session.getAttribute(ATT_SESSION_MEDECIN) != null) {

					chain.doFilter(request, response);

				} else {

					response.sendRedirect(MEDECIN);

				}

			}

		}

		if (capteur_urls_patient == 0) {

			for (int i = 0; i < urls_patient.size(); i++) {

				if (uri.contains(urls_patient.get(i))) {

					capteur_urls_patient++;

					break;

				}

			}

			if (capteur_urls_patient == 1) {

				if (session.getAttribute(ATT_SESSION_PATIENT) != null) {

					chain.doFilter(request, response);

				} else {

					response.sendRedirect(PATIENT);

				}

			}

		}

		if (capteur_urls_admin == 0) {

			for (int i = 0; i < urls_admin.size(); i++) {

				if (uri.contains(urls_admin.get(i))) {

					capteur_urls_admin++;

					break;

				}

			}

			if (capteur_urls_admin == 1) {

				if (session.getAttribute(ATT_SESSION_ADMIN) != null) {

					chain.doFilter(request, response);

				} else {

					response.sendRedirect(ADMIN);

				}

			}

		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	@Override
	public void init(FilterConfig config) throws ServletException {
		// TODO Auto-generated method stub

		/* Récupération d'une instance de nos DAO */

		this.medecinDao = ((DAOFactory) config.getServletContext().getAttribute(CONF_DAO_FACTORY)).getMedecinDao();

		this.patientDao = ((DAOFactory) config.getServletContext().getAttribute(CONF_DAO_FACTORY)).getPatientDao();

		this.seanceDao = ((DAOFactory) config.getServletContext().getAttribute(CONF_DAO_FACTORY)).getSeanceDao();

		this.propositionseanceDao = ((DAOFactory) config.getServletContext().getAttribute(CONF_DAO_FACTORY))
				.getPropositionSeanceDao();

		this.imagetestfcrobeanDao = ((DAOFactory) config.getServletContext().getAttribute(CONF_DAO_FACTORY))
				.getImageTestFcroBeanDao();

		this.imagetesttmbeanDao = ((DAOFactory) config.getServletContext().getAttribute(CONF_DAO_FACTORY))
				.getImageTestTmBeanDao();

		this.imagetesttdoibeanDao = ((DAOFactory) config.getServletContext().getAttribute(CONF_DAO_FACTORY))
				.getImageTestTdoiBeanDao();

		this.brefDao = ((DAOFactory) config.getServletContext().getAttribute(CONF_DAO_FACTORY)).getBrefDao();

		this.mmseDao = ((DAOFactory) config.getServletContext().getAttribute(CONF_DAO_FACTORY)).getMmseDao();

		this.imagemmselangagebeanDao = ((DAOFactory) config.getServletContext().getAttribute(CONF_DAO_FACTORY))
				.getImageMmseLangageBeanDao();

		this.imagemmsepraxiesconstructivesbeanDao = ((DAOFactory) config.getServletContext()
				.getAttribute(CONF_DAO_FACTORY)).getImageMmsePraxiesConstructivesBeanDao();

	}

}
