-- phpMyAdmin SQL Dump
-- version 4.5.4.1
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Lun 19 Novembre 2018 à 11:05
-- Version du serveur :  5.6.17-log
-- Version de PHP :  7.0.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `bdd_enad`
--

-- --------------------------------------------------------

--
-- Structure de la table `admin`
--

DROP TABLE IF EXISTS `admin`;
CREATE TABLE IF NOT EXISTS `admin` (
  `id_admin` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id_admin`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `bref`
--

DROP TABLE IF EXISTS `bref`;
CREATE TABLE IF NOT EXISTS `bref` (
  `id_bref` int(11) NOT NULL AUTO_INCREMENT,
  `scoreEpreuveSimilitudes` tinyint(1) NOT NULL,
  `scoreEpreuveFluenceVerbale` tinyint(1) NOT NULL,
  `scoreComportementPrehension` tinyint(1) NOT NULL,
  `scoreSequencesMotricesLuria` tinyint(1) NOT NULL,
  `scoreEpreuveConsignesConflictuelles` tinyint(1) NOT NULL,
  `scoreEpreuveGoNoGo` tinyint(1) NOT NULL,
  `scoreTotalBref` tinyint(1) NOT NULL,
  `identifiant_medecin` varchar(60) NOT NULL,
  `identifiant_patient` varchar(60) NOT NULL,
  `prenoms_noms_patient` varchar(130) NOT NULL,
  `prenoms_noms_medecin` varchar(130) NOT NULL,
  `date_heure_resultat_bref` datetime NOT NULL,
  PRIMARY KEY (`id_bref`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `carnet_sante`
--

DROP TABLE IF EXISTS `carnet_sante`;
CREATE TABLE IF NOT EXISTS `carnet_sante` (
  `id_carnet_sante` int(11) NOT NULL AUTO_INCREMENT,
  `nom_carnet_sante;` varchar(60) NOT NULL,
  `date_heure_misajour_carnet_sante` datetime NOT NULL,
  `id_pat` int(11) NOT NULL,
  `id_med` int(11) NOT NULL,
  PRIMARY KEY (`id_carnet_sante`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `commentaire`
--

DROP TABLE IF EXISTS `commentaire`;
CREATE TABLE IF NOT EXISTS `commentaire` (
  `id_com` int(11) NOT NULL AUTO_INCREMENT,
  `titre_com` varchar(200) NOT NULL,
  `contenu_com` longtext NOT NULL,
  `date_heure_realisation_com` datetime NOT NULL,
  PRIMARY KEY (`id_com`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `dates_heures_connexion_deconnexion_medecin`
--

DROP TABLE IF EXISTS `dates_heures_connexion_deconnexion_medecin`;
CREATE TABLE IF NOT EXISTS `dates_heures_connexion_deconnexion_medecin` (
  `id_dhcdm` int(11) NOT NULL AUTO_INCREMENT,
  `dhcm` datetime(6) NOT NULL,
  `id_med` int(11) NOT NULL,
  `dhdcm` datetime(6) NOT NULL,
  PRIMARY KEY (`id_dhcdm`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `dates_heures_connexion_deconnexion_patient`
--

DROP TABLE IF EXISTS `dates_heures_connexion_deconnexion_patient`;
CREATE TABLE IF NOT EXISTS `dates_heures_connexion_deconnexion_patient` (
  `id_dhcdp` int(11) NOT NULL AUTO_INCREMENT,
  `dhcp` datetime(6) NOT NULL,
  `dhdp` datetime(6) NOT NULL,
  `id_pat` int(11) NOT NULL,
  PRIMARY KEY (`id_dhcdp`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `dates_heures_finals_rdv_medecin_patient`
--

DROP TABLE IF EXISTS `dates_heures_finals_rdv_medecin_patient`;
CREATE TABLE IF NOT EXISTS `dates_heures_finals_rdv_medecin_patient` (
  `id_rdv_med_pat` int(11) NOT NULL AUTO_INCREMENT COMMENT 'dfgh',
  `id_pat` int(11) NOT NULL,
  `id_med` int(11) NOT NULL,
  `date_heure_rdv_final` datetime NOT NULL,
  PRIMARY KEY (`id_rdv_med_pat`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `dates_heures_rdv_medecin`
--

DROP TABLE IF EXISTS `dates_heures_rdv_medecin`;
CREATE TABLE IF NOT EXISTS `dates_heures_rdv_medecin` (
  `id_rdv_medecin` int(11) NOT NULL AUTO_INCREMENT,
  `id_med` int(11) NOT NULL,
  `dates_heures_rdv` datetime NOT NULL,
  PRIMARY KEY (`id_rdv_medecin`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `dates_heures_rdv_patient`
--

DROP TABLE IF EXISTS `dates_heures_rdv_patient`;
CREATE TABLE IF NOT EXISTS `dates_heures_rdv_patient` (
  `id_rdv_pat` int(11) NOT NULL AUTO_INCREMENT,
  `id_pat` int(11) NOT NULL,
  `dates_heures _rdv` datetime NOT NULL,
  PRIMARY KEY (`id_rdv_pat`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `diagnostic`
--

DROP TABLE IF EXISTS `diagnostic`;
CREATE TABLE IF NOT EXISTS `diagnostic` (
  `id_diagnostic` int(11) NOT NULL AUTO_INCREMENT,
  `titre_diagnostic` varchar(60) NOT NULL,
  `contenu_diagnostic` longtext NOT NULL,
  `date_heure_realisation_diagnostic` datetime NOT NULL,
  PRIMARY KEY (`id_diagnostic`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `ehpad`
--

DROP TABLE IF EXISTS `ehpad`;
CREATE TABLE IF NOT EXISTS `ehpad` (
  `id_ehpad` int(11) NOT NULL AUTO_INCREMENT,
  `nom_ehpad` varchar(60) NOT NULL,
  `date_heure_insertion_ehpad` datetime NOT NULL,
  PRIMARY KEY (`id_ehpad`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `ehpad_patient`
--

DROP TABLE IF EXISTS `ehpad_patient`;
CREATE TABLE IF NOT EXISTS `ehpad_patient` (
  `id_ehpad_patient` int(11) NOT NULL AUTO_INCREMENT,
  `id_ehpad` int(11) NOT NULL,
  `id_patient` int(11) NOT NULL,
  PRIMARY KEY (`id_ehpad_patient`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `groupe`
--

DROP TABLE IF EXISTS `groupe`;
CREATE TABLE IF NOT EXISTS `groupe` (
  `id_grpe` int(11) NOT NULL AUTO_INCREMENT,
  `nom_grpe` varchar(200) NOT NULL,
  `date_heure_creation_grpe` datetime(6) NOT NULL,
  PRIMARY KEY (`id_grpe`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `groupe_medecin`
--

DROP TABLE IF EXISTS `groupe_medecin`;
CREATE TABLE IF NOT EXISTS `groupe_medecin` (
  `id_grpe_med` int(11) NOT NULL AUTO_INCREMENT,
  `id_grpe` int(11) NOT NULL,
  `id_med` int(11) NOT NULL,
  `date_heure_med_rejoint_groupe` datetime NOT NULL,
  PRIMARY KEY (`id_grpe_med`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `groupe_patient`
--

DROP TABLE IF EXISTS `groupe_patient`;
CREATE TABLE IF NOT EXISTS `groupe_patient` (
  `id_grpe_pat` int(11) NOT NULL AUTO_INCREMENT,
  `id_pat` int(11) NOT NULL,
  `id_grpe` int(11) NOT NULL,
  `date_heure_pat_rejoint_grpe` datetime NOT NULL,
  PRIMARY KEY (`id_grpe_pat`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `images_fcro`
--

DROP TABLE IF EXISTS `images_fcro`;
CREATE TABLE IF NOT EXISTS `images_fcro` (
  `id_image_test_fcro` int(11) NOT NULL AUTO_INCREMENT,
  `id_seance` int(11) NOT NULL,
  `nom_img_fcro` varchar(255) NOT NULL,
  `url_img_fcro` varchar(500) NOT NULL,
  `date_heure_creation_img_fcro` datetime NOT NULL,
  PRIMARY KEY (`id_image_test_fcro`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

--
-- Contenu de la table `images_fcro`
--

INSERT INTO `images_fcro` (`id_image_test_fcro`, `id_seance`, `nom_img_fcro`, `url_img_fcro`, `date_heure_creation_img_fcro`) VALUES
(1, 7, 'fcro_dateheure_2018_9_20_10_24_56_709_s_7_m_9_p_6_.png', '/imagesdutestfcro/fcro_dateheure_2018_9_20_10_24_56_709_s_7_m_9_p_6_.png', '2018-09-20 10:24:59'),
(2, 7, 'fcro_dateheure_2018_9_20_10_25_23_720_s_7_m_9_p_6_.png', '/imagesdutestfcro/fcro_dateheure_2018_9_20_10_25_23_720_s_7_m_9_p_6_.png', '2018-09-20 10:25:23'),
(3, 7, 'fcro_dateheure_2018_9_20_10_25_28_941_s_7_m_9_p_6_.png', '/imagesdutestfcro/fcro_dateheure_2018_9_20_10_25_28_941_s_7_m_9_p_6_.png', '2018-09-20 10:25:28'),
(4, 7, 'fcro_dateheure_2018_9_20_10_25_43_404_s_7_m_9_p_6_.png', '/imagesdutestfcro/fcro_dateheure_2018_9_20_10_25_43_404_s_7_m_9_p_6_.png', '2018-09-20 10:25:43'),
(5, 8, 'fcro_dateheure_2018_10_3_10_44_17_514_s_8_m_9_p_6_.png', '/imagesdutestfcro/fcro_dateheure_2018_10_3_10_44_17_514_s_8_m_9_p_6_.png', '2018-10-03 10:44:19'),
(6, 8, 'fcro_dateheure_2018_10_3_10_44_31_726_s_8_m_9_p_6_.png', '/imagesdutestfcro/fcro_dateheure_2018_10_3_10_44_31_726_s_8_m_9_p_6_.png', '2018-10-03 10:44:31'),
(7, 8, 'fcro_dateheure_2018_10_3_10_44_43_162_s_8_m_9_p_6_.png', '/imagesdutestfcro/fcro_dateheure_2018_10_3_10_44_43_162_s_8_m_9_p_6_.png', '2018-10-03 10:44:43'),
(8, 8, 'fcro_dateheure_2018_10_3_10_44_43_309_s_8_m_9_p_6_.png', '/imagesdutestfcro/fcro_dateheure_2018_10_3_10_44_43_309_s_8_m_9_p_6_.png', '2018-10-03 10:44:43'),
(9, 8, 'fcro_dateheure_2018_10_3_10_44_49_517_s_8_m_9_p_6_.png', '/imagesdutestfcro/fcro_dateheure_2018_10_3_10_44_49_517_s_8_m_9_p_6_.png', '2018-10-03 10:44:49'),
(10, 8, 'fcro_dateheure_2018_10_3_10_44_59_959_s_8_m_9_p_6_.png', '/imagesdutestfcro/fcro_dateheure_2018_10_3_10_44_59_959_s_8_m_9_p_6_.png', '2018-10-03 10:45:00'),
(11, 9, 'fcro_dateheure_2018_10_4_16_25_22_462_s_9_m_9_p_6_.png', '/imagesdutestfcro/fcro_dateheure_2018_10_4_16_25_22_462_s_9_m_9_p_6_.png', '2018-10-04 16:25:24'),
(12, 9, 'fcro_dateheure_2018_10_4_16_25_38_314_s_9_m_9_p_6_.png', '/imagesdutestfcro/fcro_dateheure_2018_10_4_16_25_38_314_s_9_m_9_p_6_.png', '2018-10-04 16:25:38'),
(13, 9, 'fcro_dateheure_2018_10_4_16_25_41_943_s_9_m_9_p_6_.png', '/imagesdutestfcro/fcro_dateheure_2018_10_4_16_25_41_943_s_9_m_9_p_6_.png', '2018-10-04 16:25:42'),
(14, 9, 'fcro_dateheure_2018_10_4_16_25_49_581_s_9_m_9_p_6_.png', '/imagesdutestfcro/fcro_dateheure_2018_10_4_16_25_49_581_s_9_m_9_p_6_.png', '2018-10-04 16:25:49');

-- --------------------------------------------------------

--
-- Structure de la table `images_mmse_langage`
--

DROP TABLE IF EXISTS `images_mmse_langage`;
CREATE TABLE IF NOT EXISTS `images_mmse_langage` (
  `id_mmse_langage` int(11) NOT NULL AUTO_INCREMENT,
  `id_image_langage_aleatoire_mmse` bigint(16) UNSIGNED NOT NULL,
  `nom_image_langage_mmse` varchar(255) NOT NULL,
  `url_image_langage_mmse` varchar(500) NOT NULL,
  `date_heure_creation_image_langage_mmse` datetime NOT NULL,
  PRIMARY KEY (`id_mmse_langage`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `images_mmse_praxies_constructives`
--

DROP TABLE IF EXISTS `images_mmse_praxies_constructives`;
CREATE TABLE IF NOT EXISTS `images_mmse_praxies_constructives` (
  `id_mmse_praxiesconstructives` int(11) NOT NULL AUTO_INCREMENT,
  `id_image_praxiesconstructives_aleatoire_mmse` bigint(16) NOT NULL,
  `nom_image_praxiesconstructives_mmse` varchar(255) NOT NULL,
  `url_image_praxiesconstructives_mmse` varchar(500) NOT NULL,
  `date_heure_creation_image_praxiesconstructives_mmse` datetime NOT NULL,
  PRIMARY KEY (`id_mmse_praxiesconstructives`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `images_tdoi`
--

DROP TABLE IF EXISTS `images_tdoi`;
CREATE TABLE IF NOT EXISTS `images_tdoi` (
  `id_image_test_tdoi` int(11) NOT NULL AUTO_INCREMENT,
  `id_medecin` int(11) NOT NULL,
  `nom_img_tdoi` varchar(255) NOT NULL,
  `url_img_tdoi` varchar(500) NOT NULL,
  `date_heure_creation_img_tdoi` datetime NOT NULL,
  PRIMARY KEY (`id_image_test_tdoi`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `images_tm`
--

DROP TABLE IF EXISTS `images_tm`;
CREATE TABLE IF NOT EXISTS `images_tm` (
  `id_image_test_tm` int(11) NOT NULL AUTO_INCREMENT,
  `id_seance` int(11) NOT NULL,
  `version_tm` varchar(10) NOT NULL,
  `nom_img_tm` varchar(255) NOT NULL,
  `date_heure_creation_img_tm` datetime NOT NULL,
  `url_img_tm` varchar(500) NOT NULL,
  PRIMARY KEY (`id_image_test_tm`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `medecin`
--

DROP TABLE IF EXISTS `medecin`;
CREATE TABLE IF NOT EXISTS `medecin` (
  `id_medecin` int(11) NOT NULL AUTO_INCREMENT,
  `identifiant_medecin` varchar(60) NOT NULL,
  `noms_medecin` varchar(60) NOT NULL,
  `prenoms_medecin` varchar(60) DEFAULT NULL,
  `photo_medecin` varchar(255) DEFAULT NULL,
  `url_photo_medecin` varchar(500) DEFAULT NULL,
  `mdp_medecin` char(56) NOT NULL,
  `date_heure_inscription_medecin` datetime NOT NULL,
  PRIMARY KEY (`id_medecin`),
  UNIQUE KEY `identifiant_medecin` (`identifiant_medecin`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

--
-- Contenu de la table `medecin`
--

INSERT INTO `medecin` (`id_medecin`, `identifiant_medecin`, `noms_medecin`, `prenoms_medecin`, `photo_medecin`, `url_photo_medecin`, `mdp_medecin`, `date_heure_inscription_medecin`) VALUES
(9, 'Clara', 'PICQ', 'Clara', '1537423496784_chu f.jpg', '/imagesphotoprofilmedecin/1537423496784_chu f.jpg', 'kmW3WTRjXJr266aOt1AXeenq2HIrBi3DeqZU15FB4lSotpUgz70EVQ==', '2018-09-20 08:04:29');

-- --------------------------------------------------------

--
-- Structure de la table `medecin_ip`
--

DROP TABLE IF EXISTS `medecin_ip`;
CREATE TABLE IF NOT EXISTS `medecin_ip` (
  `id_med_ip` int(11) NOT NULL AUTO_INCREMENT,
  `id_med` int(11) NOT NULL,
  `ip_med` varchar(20) NOT NULL,
  PRIMARY KEY (`id_med_ip`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `mmse`
--

DROP TABLE IF EXISTS `mmse`;
CREATE TABLE IF NOT EXISTS `mmse` (
  `id_mmse` int(11) NOT NULL AUTO_INCREMENT,
  `scoreOrientation` tinyint(1) NOT NULL,
  `scoreApprentissage` tinyint(1) NOT NULL,
  `scoreAttentionEtCalcul` tinyint(1) NOT NULL,
  `scoreRappel` tinyint(1) NOT NULL,
  `scoreLangage` tinyint(1) NOT NULL,
  `imageLangage_oui_non` varchar(3) NOT NULL,
  `scorePraxiesConstructives` tinyint(1) NOT NULL,
  `imagePraxiesConstructives_oui_non` varchar(3) NOT NULL,
  `scoreTotalMmse` tinyint(1) NOT NULL,
  `identifiant_medecin` varchar(60) NOT NULL,
  `identifiant_patient` varchar(60) NOT NULL,
  `prenoms_noms_patient` varchar(130) NOT NULL,
  `prenoms_noms_medecin` varchar(130) NOT NULL,
  `date_heure_resultat_mmse` datetime NOT NULL,
  `id_aleatoire_mmse` bigint(16) UNSIGNED NOT NULL,
  PRIMARY KEY (`id_mmse`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `mmse_dessin_recopier_traitement`
--

DROP TABLE IF EXISTS `mmse_dessin_recopier_traitement`;
CREATE TABLE IF NOT EXISTS `mmse_dessin_recopier_traitement` (
  `id_mmse_dessin_recopier_traitement` int(11) NOT NULL AUTO_INCREMENT,
  `id_aleatoire_mmse` bigint(16) NOT NULL,
  `identifiant_med` varchar(60) NOT NULL,
  `identifiant_pat` varchar(60) NOT NULL,
  `clic_med` varchar(3) DEFAULT NULL,
  `clic_pat` varchar(3) DEFAULT NULL,
  `date_heure_pre_traitement_mmse` datetime NOT NULL,
  PRIMARY KEY (`id_mmse_dessin_recopier_traitement`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `mmse_phrase_ecrire_traitement`
--

DROP TABLE IF EXISTS `mmse_phrase_ecrire_traitement`;
CREATE TABLE IF NOT EXISTS `mmse_phrase_ecrire_traitement` (
  `id_mmse_phrase_ecrire_traitement` int(11) NOT NULL AUTO_INCREMENT,
  `id_aleatoire_mmse` bigint(16) UNSIGNED NOT NULL,
  `identifiant_med` varchar(60) NOT NULL,
  `identifiant_pat` varchar(60) NOT NULL,
  `clic_med` varchar(3) DEFAULT NULL,
  `clic_pat` varchar(3) DEFAULT NULL,
  `date_heure_pre_traitement_mmse` datetime NOT NULL,
  PRIMARY KEY (`id_mmse_phrase_ecrire_traitement`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `patient`
--

DROP TABLE IF EXISTS `patient`;
CREATE TABLE IF NOT EXISTS `patient` (
  `id_patient` int(11) NOT NULL AUTO_INCREMENT,
  `identifiant_patient` varchar(60) NOT NULL,
  `noms_patient` varchar(60) NOT NULL,
  `prenoms_patient` varchar(60) DEFAULT NULL,
  `age_patient` int(11) DEFAULT NULL,
  `photo_patient` varchar(255) DEFAULT NULL,
  `url_photo_patient` varchar(500) DEFAULT NULL,
  `date_heure_inscription_patient` datetime NOT NULL,
  `date_naissance_patient` date NOT NULL,
  `affichage_date_naissance` varchar(40) NOT NULL COMMENT 'affichage spéciale de la date de naissance d''un patient',
  `sexe_patient` varchar(7) NOT NULL,
  `masse_patient` double DEFAULT NULL,
  `taille_patient` double DEFAULT NULL,
  `ip_patient` varchar(15) DEFAULT NULL,
  `main` varchar(6) DEFAULT NULL,
  PRIMARY KEY (`id_patient`),
  UNIQUE KEY `identifiant_patient` (`identifiant_patient`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

--
-- Contenu de la table `patient`
--

INSERT INTO `patient` (`id_patient`, `identifiant_patient`, `noms_patient`, `prenoms_patient`, `age_patient`, `photo_patient`, `url_photo_patient`, `date_heure_inscription_patient`, `date_naissance_patient`, `affichage_date_naissance`, `sexe_patient`, `masse_patient`, `taille_patient`, `ip_patient`, `main`) VALUES
(6, 'Fanon', 'JUPKWO', 'Fanon', NULL, '1537423372702_fanon jupkwo.jpg', '/imagesphotoprofilpatient/1537423372702_fanon jupkwo.jpg', '2018-09-20 08:00:30', '1993-10-06', 'le 6 Octobre 1993', 'homme', NULL, NULL, NULL, NULL),
(7, '1234', 'klop', 'Julie', NULL, NULL, NULL, '2018-10-19 18:25:22', '1998-10-06', 'le 6 Octobre 1998', 'femme', NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `patient_ip`
--

DROP TABLE IF EXISTS `patient_ip`;
CREATE TABLE IF NOT EXISTS `patient_ip` (
  `id_pat_ip` int(11) NOT NULL AUTO_INCREMENT,
  `id_pat` int(11) NOT NULL,
  `ip_pat` varchar(20) NOT NULL,
  PRIMARY KEY (`id_pat_ip`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `proposition_seance`
--

DROP TABLE IF EXISTS `proposition_seance`;
CREATE TABLE IF NOT EXISTS `proposition_seance` (
  `id_seance_proposition` int(11) NOT NULL AUTO_INCREMENT,
  `id_seance` int(11) NOT NULL,
  `date_realisation_seance_proposition` date NOT NULL,
  `heure_fin_seance_proposition` time NOT NULL,
  `heure_realisation_seance_proposition` time NOT NULL,
  `affichage_date_realisation_seance_proposition` varchar(40) NOT NULL,
  `identifiant_medecin_proposition` varchar(60) NOT NULL,
  `identifiant_patient_proposition` varchar(60) NOT NULL,
  `prenoms_noms_patient_proposition` varchar(130) NOT NULL,
  `prenoms_noms_medecin_proposition` varchar(130) NOT NULL,
  `date_heure_creation_seance_proposition` datetime NOT NULL,
  `identifiant_emission` varchar(60) NOT NULL,
  `prenoms_noms_emission` varchar(130) NOT NULL,
  PRIMARY KEY (`id_seance_proposition`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `relations_medtraitant_patient`
--

DROP TABLE IF EXISTS `relations_medtraitant_patient`;
CREATE TABLE IF NOT EXISTS `relations_medtraitant_patient` (
  `id_rel_medt_pat` int(11) NOT NULL AUTO_INCREMENT,
  `identifiant_med` varchar(60) NOT NULL,
  `identifiant_pat` varchar(60) NOT NULL,
  `date_heure_mise_en_relation` datetime NOT NULL,
  PRIMARY KEY (`id_rel_medt_pat`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `relations_med_med`
--

DROP TABLE IF EXISTS `relations_med_med`;
CREATE TABLE IF NOT EXISTS `relations_med_med` (
  `id_rel_med_med` int(11) NOT NULL AUTO_INCREMENT,
  `identifiant_med1` varchar(60) NOT NULL,
  `identifiant_med2` varchar(60) NOT NULL,
  `date_heure_relation` datetime NOT NULL,
  PRIMARY KEY (`id_rel_med_med`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `relations_med_pat`
--

DROP TABLE IF EXISTS `relations_med_pat`;
CREATE TABLE IF NOT EXISTS `relations_med_pat` (
  `id_rel_med_pat` int(11) NOT NULL AUTO_INCREMENT,
  `identifiant_med` varchar(60) NOT NULL,
  `identifiant_pat` varchar(60) NOT NULL,
  `date_heure_relation` datetime NOT NULL,
  PRIMARY KEY (`id_rel_med_pat`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

--
-- Contenu de la table `relations_med_pat`
--

INSERT INTO `relations_med_pat` (`id_rel_med_pat`, `identifiant_med`, `identifiant_pat`, `date_heure_relation`) VALUES
(9, 'Clara', 'Fanon', '2018-09-20 08:06:49');

-- --------------------------------------------------------

--
-- Structure de la table `resultat_test`
--

DROP TABLE IF EXISTS `resultat_test`;
CREATE TABLE IF NOT EXISTS `resultat_test` (
  `id_rt` int(11) NOT NULL AUTO_INCREMENT,
  `nom_rt_test` varchar(200) NOT NULL,
  `duree_rt_test` time NOT NULL,
  PRIMARY KEY (`id_rt`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `seance`
--

DROP TABLE IF EXISTS `seance`;
CREATE TABLE IF NOT EXISTS `seance` (
  `id_seance` int(11) NOT NULL AUTO_INCREMENT,
  `titre_seance` varchar(200) NOT NULL,
  `resume_seance` text,
  `plan_seance` text NOT NULL,
  `date_realisation_seance` date NOT NULL,
  `identifiant_medecin` varchar(60) NOT NULL,
  `identifiant_patient` varchar(60) NOT NULL,
  `heure_realisation_seance` time NOT NULL,
  `date_heure_creation_seance` datetime NOT NULL,
  `heure_fin_seance` time NOT NULL,
  `valid` varchar(10) NOT NULL,
  `prenoms_noms_patient` varchar(130) NOT NULL,
  `affichage_date_realisation_seance` varchar(40) NOT NULL,
  `prenoms_noms_medecin` varchar(130) NOT NULL,
  PRIMARY KEY (`id_seance`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

--
-- Contenu de la table `seance`
--

INSERT INTO `seance` (`id_seance`, `titre_seance`, `resume_seance`, `plan_seance`, `date_realisation_seance`, `identifiant_medecin`, `identifiant_patient`, `heure_realisation_seance`, `date_heure_creation_seance`, `heure_fin_seance`, `valid`, `prenoms_noms_patient`, `affichage_date_realisation_seance`, `prenoms_noms_medecin`) VALUES
(7, 'Evaluation générale', NULL, 'Dans un premier temps, connaître précisément votre état de santé actuel puis faire les tests.', '2018-09-20', 'Clara', 'Fanon', '10:20:00', '2018-09-20 08:09:38', '10:50:00', 'VALIDEE', 'Fanon JUPKWO', 'le 20 Septembre 2018', 'Clara PICQ'),
(8, 'sssss', NULL, 'sxcccfvefrt', '2018-10-03', 'Clara', 'Fanon', '10:50:00', '2018-10-03 10:41:51', '11:00:00', 'VALIDEE', 'Fanon JUPKWO', 'le 3 Octobre 2018', 'Clara PICQ'),
(9, 'Evaluation générale des capacités de mémoire', NULL, 'Figure complexe de Rey Osterrieth', '2018-10-04', 'Clara', 'Fanon', '16:30:00', '2018-10-04 12:02:31', '17:00:00', 'VALIDEE', 'Fanon JUPKWO', 'le 4 Octobre 2018', 'Clara PICQ'),
(10, 'Evaluation cognitive', NULL, 'Tous les 5 tests', '2018-11-02', 'Clara', 'Fanon', '09:00:00', '2018-11-02 08:04:34', '10:00:00', 'VALIDEE', 'Fanon JUPKWO', 'le 2 Novembre 2018', 'Clara PICQ');

-- --------------------------------------------------------

--
-- Structure de la table `test`
--

DROP TABLE IF EXISTS `test`;
CREATE TABLE IF NOT EXISTS `test` (
  `id_test` int(11) NOT NULL AUTO_INCREMENT,
  `nom_test` varchar(200) NOT NULL,
  `definition_test` text NOT NULL,
  `description_test` longtext NOT NULL,
  `date_heure_insertion_test` datetime NOT NULL,
  PRIMARY KEY (`id_test`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `testdessinsseancesvalideesjour`
--

DROP TABLE IF EXISTS `testdessinsseancesvalideesjour`;
CREATE TABLE IF NOT EXISTS `testdessinsseancesvalideesjour` (
  `id_tdvj` int(11) NOT NULL AUTO_INCREMENT,
  `id_seancesvalidees` int(11) NOT NULL,
  `clic_med` varchar(8) DEFAULT NULL,
  `clic_pat` varchar(8) DEFAULT NULL,
  `nom_test` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id_tdvj`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

--
-- Contenu de la table `testdessinsseancesvalideesjour`
--

INSERT INTO `testdessinsseancesvalideesjour` (`id_tdvj`, `id_seancesvalidees`, `clic_med`, `clic_pat`, `nom_test`) VALUES
(7, 7, 'CLICMED', 'CLICPAT', 'FCRO'),
(8, 8, 'CLICMED', 'CLICPAT', 'FCRO'),
(9, 9, 'CLICMED', 'CLICPAT', 'FCRO'),
(10, 10, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur_ip`
--

DROP TABLE IF EXISTS `utilisateur_ip`;
CREATE TABLE IF NOT EXISTS `utilisateur_ip` (
  `id_user_ip` int(11) NOT NULL AUTO_INCREMENT,
  `id_user` int(11) NOT NULL,
  `ip_user` varchar(20) NOT NULL,
  `type_user` varchar(2) NOT NULL,
  PRIMARY KEY (`id_user_ip`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `validations_relations_medtraitant_patient`
--

DROP TABLE IF EXISTS `validations_relations_medtraitant_patient`;
CREATE TABLE IF NOT EXISTS `validations_relations_medtraitant_patient` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ide_em` varchar(60) NOT NULL,
  `ide_dest` varchar(60) NOT NULL,
  `date_heure` datetime NOT NULL,
  `type_em` varchar(2) NOT NULL,
  `type_dest` varchar(2) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `validations_relations_med_med`
--

DROP TABLE IF EXISTS `validations_relations_med_med`;
CREATE TABLE IF NOT EXISTS `validations_relations_med_med` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ide_em` varchar(60) NOT NULL,
  `ide_dest` varchar(60) NOT NULL,
  `date_heure_relation` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `validations_relations_med_pat`
--

DROP TABLE IF EXISTS `validations_relations_med_pat`;
CREATE TABLE IF NOT EXISTS `validations_relations_med_pat` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `identifiant_em` varchar(60) NOT NULL,
  `identifiant_dest` varchar(60) NOT NULL,
  `type_em` varchar(2) NOT NULL,
  `type_dest` varchar(2) NOT NULL,
  `date_heure_creation` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
