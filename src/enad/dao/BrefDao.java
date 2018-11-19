package enad.dao;

import java.util.ArrayList;

import enad.beans.Bref;

public interface BrefDao {

	void creer(Bref bref) throws DAOException;

	ArrayList<Bref> trouver_bref_chrono_croissant(String identifiantMedecin) throws DAOException;

	ArrayList<Bref> trouver_bref_chrono_croissant_unique(String identifiantMedecin, String identifiantPatient)
			throws DAOException;

	ArrayList<Bref> trouver_bref_croissant(String identifiantMedecin) throws DAOException;

	ArrayList<Bref> trouver_bref_croissant_unique(String identifiantMedecin, String identifiantPatient)
			throws DAOException;

	ArrayList<Bref> trouver_bref_chrono_decroissant(String identifiantMedecin) throws DAOException;

	ArrayList<Bref> trouver_bref_chrono_decroissant_unique(String identifiantMedecin, String identifiantPatient)
			throws DAOException;

	ArrayList<Bref> trouver_bref_decroissant(String identifiantMedecin) throws DAOException;

	ArrayList<Bref> trouver_bref_decroissant_unique(String identifiantMedecin, String identifiantPatient)
			throws DAOException;

}
