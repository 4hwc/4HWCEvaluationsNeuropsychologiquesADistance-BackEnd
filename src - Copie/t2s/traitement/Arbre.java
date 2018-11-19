/*  
 * SI VOX Copyright (C) 2004 - 2005
 *
 * Author :
 *   ESSI2 school project (2004) : Affouard, Lemonnier, Fournols ,Lizzul
 *   Tutor                (2004) : Hélène Collavizza   [ helen@essi.fr    ] 
 *                                 Jean-Paul Stromboni [ strombon@essi.fr ]
 *
 * Contributor :
 *   (2004) : Louis Parisot [ parisot@essi.fr ]
 *   (2005) : Sébastien Mosser  [ mosser@essi.fr ]
 *
 * Institute : 
 *    Polytechnich school, University of Nice - Sophia Antipolis (FRANCE)
 *
 * This program is free software. It uses mbrola speech synthesizers system.
 * 
 * You can redistribute it and/or modify it under the terms of the MBROLA 
 * Licenses  { http://tcts.fpms.ac.be/synthesis/mbrola.html }.
 *
 */

package t2s.traitement;

import java.io.*;
import java.util.*;
import t2s.util.*;



/** Un arbre <i>(préfixe)</i> des règles pour retrouver les phonèmes correspondant à des groupes de lettres.
 */
public class Arbre {

    private Arbre frere;        // le frere de l'arbre
    private Arbre fils;         // le fils de l'arbre
    private String lettre;      // la lettre
    private ListeRegles regles; // la liste des règles de l'arbre

    /**
     * Constructeurs
     */
    
    /** Constructeur d'arbre à partir d'un repertoire contenant des fichiers de règles.
     * <p> <b>Organisation du repertoire de règles</b> : </p>
     * <p>
     *   <ul>
     *     <li> fichier <code>preposition.txt</code> contenant les prépositions (pour couper les phrases)</li>
     *     <li> fichier <code>regle.txt</code> contenant les règles de prononciation </li>
     *     <li> fichier <code>exception.txt</code> contenant les exceptions de prononciations </li>
     *     <li> fichier <code>acronymes.txt</code> contenant les acronymes de la langue française </li>
     *   </ul>
     * </p>
     * @param path le chemin d'accès au fichiers de règles
     */
    public Arbre(String path) throws AnalyseException {
	this();
	// charge les prépositions qui permettent de couper les phrases
	GenerateurPreposition prop = new GenerateurPreposition(path + ConfigFile.rechercher("PREPOSITIONS"));
	Regle p = prop.nouvellePreposition();

	while (!prop.vide()) {
	    this.ajouter(p);
	    p = prop.nouvellePreposition();
	}
	prop.close();

	// charge les règles de traduction, les exceptions et les abbréviations
	creerLexique(path + ConfigFile.rechercher("REGLES"));
	creerLexique(path + ConfigFile.rechercher("EXCEPTIONS"));
	creerLexique(path + ConfigFile.rechercher("ACCRONYMES"));
    }
    
    /** Constructeur d'arbre vide.
     * <p><b>Définition</b> : Un arbre vide contient uniquement la lettre 'a'</p>
     */
    private Arbre() {
	frere = null;
	fils = null;
	lettre = "a";
	regles = new ListeRegles();
    }

    /** Construction d'arbre par copie
     * @param a l'arbre poréfixe que l'on souhaite copier dans this.
     */
    private Arbre(Arbre a) {
	this.frere = a.frere;
	this.fils = a.fils;
	this.lettre = a.lettre;
	this.regles = a.regles;
    }
    
    /**
     * Méthodes publiques 
     */
    
    /** Pour trouver les phonèmes associé à une phrase
     * @param phrase la phrase que l'on veut transformer en phonèmes
     * @return la liste des phonemes qui va bien ^_^.
     */
    public String trouverPhoneme(String phrase) {
	Indice i = new Indice();
	String res = "";
	String tmp = "";
    	while (i.val() < phrase.length()) {
	    tmp =  trouverPhoneme(phrase, i);
	    if (!vide(tmp)) {
		res += tmp;
	    }
	    else {
		// on n'a pas su traiter l'indice courant; on le saute
		i.inc();
	    }
	}
	return res;
    }

    /** Méthode d'affichage standart (affichage en largeur).
     * <p><b>Précondition</b> : L'arbre n'est pas vide.</p>
     * @return une chaine de caractère représentant l'arbre
     */ 
    public String toString() {
	// affichage en largeur
	FileArbre f = new FileArbre();
	f.ajouter(this);
	String s = "";
	while (!f.vide()) {
	    Arbre a = f.retirer();
	    s += a.getRegles().toString() + "\n";
	    Arbre cour = a.getFrere();
	    while (cour != null) {
		f.ajouter(cour);
		cour = cour.getFrere();
	    }
	    if (a.getFils()!=null) f.ajouter(a.getFils());
	}
	return s;
    }

    /**
     * Méthodes privées 
     */

    /** Méthode de remplissage de l'arbre
     * @param s le fichier à analyser
     */
    private void creerLexique(String s) throws AnalyseException {
	GenerateurRegle ana = new GenerateurRegle(s);
	Regle a = ana.nouvelleRegle();
	while (!ana.vide()) {
	    this.ajouter(a);
	    a = ana.nouvelleRegle();
	}
	ana.close();
    }

    /** Pour obtenir le frêre de l'arbre
     * @return l'arbre frêre
     */
    private Arbre getFrere() {
	return this.frere;
    }

    /** Pour obtenir le fils de l'arbre
     * @return l'arbre fils
     */
    private Arbre getFils() {
	return this.fils;
    }

    /** Pour obtenir la lettre présente à la racine
     * @return la lettre en question
     */
    private String getLettre() {
	return this.lettre;
    }

    /** Pour obtenir la liste de règles de l'arbre
     * @return une instance de <code>ListeRegles</code> ad'hoc.
     */
    private ListeRegles getRegles() {
	return this.regles;
    }

    /** Pour modifier le frêre d'un arbre
     * @param l la lettre présente à la racine de nouveau frêre
     */
    private void ajouterFrere(String l) {
	Arbre ar = new Arbre();
	ar.lettre = l;
	this.frere = ar;
    }

    /** Pour modifier le fils d'un arbre
     * @param l la lettre présente à la racine de nouveau fils
     */
    private void ajouterFils(String l) {
	Arbre ar = new Arbre();
	ar.lettre = l;
	this.fils = ar;
    }

    /** Pour ajouter en tête de l'arbre
     * @param l la 
     */
    private void ajouterDebut(String l) {
	Arbre f = new Arbre(this);
	this.frere = f;
	this.fils = null;
	this.lettre = l;
	this.regles = new ListeRegles();
    }

    /** Pour savoir si un arbre est vide
     * @return true si c'est le cas, false sinon.
     */
    private boolean estVide() {
	return getLettre().equals("");
    }

    /** Ajouter une regle a la liste de regles de <code>this</code>.
     * @param regle la règle que l'on veut ajouter
     */
    private void ajouter(Regle regle) {
	ajouter(regle.getRacine(), regle);
    }

    /** ajoute une regle a la liste de regles, par rapport à une chaine de caractère.
     * @param mot la chaine de caractère 'racine'.
     * @param regle la règle a ajouter.
     */
    private void ajouter(String mot, Regle regle) {
	String lettre = mot.substring(0, 1);
	String fin = mot.substring(1);
	if (lettre.equals(getLettre())) {
	    //la lettre existe
	    if (fin.length() == 0) {
		//c'est la derniere lettre
		regles.ajouter(regle);
	    }
	    else {
		//lettre du mot
		if (getFils() == null) 
		    ajouterFils(fin.substring(0, 1));
		getFils().ajouter(fin, regle);
	    }
	}
	else if (lettre.compareTo(getLettre()) > 0) {
	    //la lettre est lexicographiquement apres
	    if (getFrere() == null) 
		ajouterFrere(lettre);
	    getFrere().ajouter(mot, regle);
	}
	else {
	    //la lettre n'existe pas
	    ajouterDebut(lettre);
	    ajouter(mot, regle);
	}
    }  

    /** Pour trouver la liste de phonème correspondant à un mot à partir d'un indice
     * <p><b>Remarque</b> : on choisit la règle qui permet d'unifier  la plus grande chaine commençant à l'indice i.</p> 
     * <p><b>Postcondition</b> : i désigne la prochaine lettre à analyser</p>
     * @param mot le mot à analyser
     * @param i l'indice à partir duquel on analyse
     * @return la liste des phoneme qui va bien(à partir de l'indice i)
     */
    private String trouverPhoneme(String mot, Indice i) {
	// la chaine résultat
	String res = ListeRegles.PAS_DE_REGLE; 
	// la lettre courante
	String lettre = mot.substring(i.val(), i.val() + 1);

	if (lettre.equals(getLettre())) {
	    //la lettre existe
	    i.inc();
	    // on applique les règles de plus grande racine d'abord
	    // s'il y a un fils et qu'on a encore des lettres
	    // on cherche à appliquer une règle sur le fils
	    if (!i.egal(mot.length()) && getFils()!=null) {
		int saveInd = i.val();
		String resFils = getFils().trouverPhoneme(mot, i);
		if (!vide(resFils)) {
		    // on a trouvé un plus grand unificateur
		    res = resFils;
		}
		else { // pas d'unification avec le fils, 
		    // on doit revenir sur la lettre courante
		    i.val(saveInd);
		    res = getRegles().trouverPhoneme(mot, i.val());
		}
	    }
	    // pas de fils ou plus d'autres lettres : on applique
	    // la règle courante
	    else  res = getRegles().trouverPhoneme(mot, i.val());
	}
	else 
	    if (lettre.compareTo(getLettre()) > 0) {
		//la lettre est lexicographiquement apres
		if (getFrere() != null) {
		    int saveInd = i.val();
		    String resFrere = getFrere().trouverPhoneme(mot, i);
		    if (!vide(resFrere)) {
			res = resFrere;
		    }
		    else i.val(saveInd);
		}
	    }
	    else res = ListeRegles.PAS_DE_REGLE;
	return res;
    }
    
    /** Pour savoir si une chaine de caractère est égale au tag "PAS DE REGLES".
     * @param s la chaine a tester
     * @return true si c'est le cas, false sinon
     */
    private static boolean vide(String s) {
	return s.equals(ListeRegles.PAS_DE_REGLE);
    }

    /**
     * Classes privée, utilisée pour l'affichage de l'arbre (débuggage)
     */

    private class FileArbre{
	private ChaineArbre entree;
	private ChaineArbre sortie; 

	public FileArbre() {
	    entree = null;
	    sortie = null;
	}

	private FileArbre(FileArbre f) {
	    entree = f.entree;
	    sortie = f.sortie;
	}
	/**
	 * Ajoute un nouvel objet dans la file.
	 */
	public void ajouter(Arbre objet) {
	    if ( vide() ) {
		entree = new ChaineArbre(objet);
		sortie = entree;
	    }
	    else {
		if (!dejaMis(objet,new FileArbre(this))) {
		    entree.suiv = new ChaineArbre(objet);
		    entree = entree.suiv;
		}
	    }
	}

	private boolean dejaMis(Arbre a,FileArbre f) {
	    if (f.vide()) return false;
	    else {
		Arbre af = f.retirer();
		if ((af.getRegles().toString()).equals(a.getRegles().toString()))
		    return true; 
		else return dejaMis(a,f);
	    }
	}
  
	/**
	 * Retire un objet de la file et retourne cet objet.
	 * Précondition : la file n'est pas vide.
	 */
	public Arbre retirer() {
	    Arbre x = sortie.a;
	    sortie = sortie.suiv;
	    if ( sortie == null ) {
		entree = null;
	    }
	    return x;
	}

	/**
	 * Retourne l'objet situé en tête de la file.
	 * Précondition : la file n'est pas vide.
	 */
	public Arbre suivant() {
	    return sortie.a;
	}


	/**
	 * Teste si la file est vide.
	 */
	public boolean vide() {
	    return entree == null;
	}

	/**
	 * Teste si la file est pleine.
	 */
	public boolean pleine() {
	    return false;
	}
    }
    
    private class ChaineArbre{
	private Arbre a;
	private ChaineArbre suiv; 
	    
	public ChaineArbre(Arbre a) {
	    this.a = a;
	}

	public ChaineArbre(Arbre a, ChaineArbre s) {
	    this.a = a;
	    suiv = s;
	}
    }

} 

