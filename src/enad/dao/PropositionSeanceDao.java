package enad.dao;

import java.util.ArrayList;

import enad.beans.Medecin;
import enad.beans.Patient;
import enad.beans.PropositionSeance;
import enad.beans.Seance;

public interface PropositionSeanceDao {

	int nombre_prop_seance(Long id_seance) throws DAOException;

	void creerMed(Seance seance, PropositionSeance propseance, Medecin medecin) throws DAOException;

	void creerPat(Seance seance, PropositionSeance propseance, Patient patient) throws DAOException;

	ArrayList<PropositionSeance> trouver(Long idSeance) throws DAOException;

	String trouver_personne_derniere_prop(Long idSeance) throws DAOException;

	PropositionSeance trouver_derniere_prop(Long idSeance) throws DAOException;

	PropositionSeance trouver_prop(Long idprop) throws DAOException;

	void supprimer_propseance(Long id_seance) throws DAOException;

}
