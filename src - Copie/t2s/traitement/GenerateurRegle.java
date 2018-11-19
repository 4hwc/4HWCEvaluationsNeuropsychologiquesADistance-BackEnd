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
import java.util.regex.*;
import t2s.util.ConfigFile;
/** Un générateur de Règles, écrites au format PERL dans un fichier texte.
 */
public class GenerateurRegle {

    // le buffer qui est lu
    private BufferedReader br;
    // une hashtable qui contient les classes lexicales
    private Hashtable ensembles;
    // le numéro de ligne courante dans le fichier
    private  int noLigne ; 
    // pour savoir s'il reste encore des règles
    private boolean vide;

    /** Construction standart d'un générateur de règles à partir d'un fichier.
     * @param path le chemin d'accès au fichier utilisé (encodage <code>ISO-8859-1</code>)
     */
    public GenerateurRegle(String path) {
	try {
	    // pour avoir le jeu de caractères ISO
	    FileInputStream fos = new FileInputStream(path);
	    br = new BufferedReader(new InputStreamReader(fos,ConfigFile.rechercher("ENCODAGE_FICHIER") )); 
	    //br = new BufferedReader(new FileReader(new File(path)));
	    ensembles = new Hashtable();
	    noLigne = 0;
	    vide = false;
	    initEnsembles();
	}
	catch (FileNotFoundException e) {
	    System.out.println("SI_VOX WARNING [GenerateurRegle] :  Erreur lors du chargement du fichier de regles");
	}
	catch (AnalyseException e) {
	    System.out.println("SI_VOX WARNING [GenerateurRegle] : Une erreur d'analyse est survenue !");
	    System.out.println(e);
	}
	catch (UnsupportedEncodingException e) {
	    System.out.println("SI_VOX WARNING [GenerateurRegle] : Encodage inconnu");
	}
    }

    /** Pour savoir s'il reste encore des règles à lire dans le fichier
     * @return true si on n'a plus de règles à lire, false sinon.
     */
    public boolean vide() {
	return vide;
    }

    /** Femreture en lecture du fichier de règles.
     */
    public void close() {
	try {
	    br.close();
	}
	catch (Exception e) {
	    System.out.println("SI_VOX WARNING [GenerateurRegle.close] : Erreur lors de la fermeture du fichier de règles !");
	} 
    }

    /** Analyse d'une ligne du fichier (chargement dans le tampon et transformation)
     * @param br le lecteur bufferisé servant à faire la lecture du fichier.
     * @return une instance de <code>StringTokenizer</code> associé aux caractères <code>'\t','n'</code> et <code>'\r'</code>
     */
    public StringTokenizer tokensLine(BufferedReader br) throws AnalyseException {
	String linein = "";
	try {
	    while (linein!=null && (linein.equals("") || comment(linein))) {
		linein = br.readLine();
		noLigne++;
	    }
	}
	catch (IOException e) {
	    erreur(1);
	}
	if (linein == null) 
	    erreur(9);
	return new StringTokenizer(linein," \t\n\r");
    }


    /** Pour initialiser les classes de lettres (initialisation du générateur)
     * <p> <b>Remarque</b> : Modifie par effet de bord la table de hachage globale des ensembles de lettres </p>
     */
    public void initEnsembles() throws AnalyseException {
	StringTokenizer line = tokensLine(br);
	if (line.hasMoreTokens()) {
	    String first = line.nextToken();
	    if (classes(first)) 
		initClasses();
	    else 
		if (! rules(first)) 
		    erreur(2);
	}
	else 
	    erreur(1);
    }

    /** Pour créer l'ensemble des classes
     */
    private void initClasses() throws AnalyseException {
	String first = "";
	do {
	    StringTokenizer line = tokensLine(br);
	    if (line.hasMoreTokens()) {
		first = line.nextToken();
		if (classs(first)) 
		    initOneClass(line);
		else if (! rules(first)) 
		    erreur(2);
	    } 
	} while (!rules(first));
    }

    /** Pour créer une classe unique
     * Précondition : 
     *        On arrive ici APRES avoir reconnu le tag de classe dans line
     * @param line le <code>StringTokenizer</code> que l'on veut analyser
     */
    private void initOneClass(StringTokenizer line) throws AnalyseException{
	String name = "";
	String value = "";
	if (line.hasMoreTokens()) {
	    name = line.nextToken();
	    // on vérifie que l'identificateur est en majuscules
	    if (!majuscules(name)) 
		erreur(3);
	    if (ensembles.containsKey(name))
		erreur(4);
	}
	else 
	    erreur(5);

	if (line.hasMoreTokens()) {
	    value = line.nextToken();
	    if (comment(value)) 
		erreur(6);
	    value = analyseExpReg(value);
	}
	else erreur(6);
	// ici on a un nom et une expression de classe corrects
	ensembles.put(name,value);
    }

    /** Pour analyser une expression régulière
     * Postcondition : 
     *         On aura levé une exception si : 
     *              - La chaine ne correspond pas à une expression régulière de syntaxe correcte
     *              - Il y a des majuscules qui ne correspondent pas à un ident de classe
     * @return la chaine dans laquelle on a substitué les ident de classe par leurs valeurs
     */

    private String analyseExpReg(String value) throws AnalyseException {
	// vérifie la syntaxe de l'expression régulière
	try {
	    Pattern p = Pattern.compile(value);
	}
	catch (PatternSyntaxException pe) {
	    erreur(7);
	} 
	// vérifie que les majuscules correspondent à des identificateurs de classe connus
	String res = "";
	int lg = value.length();
	int i=0;
	    
	while (i < lg) {
	    char cour = value.charAt(i);
	    i++;
	    String ident = "";
	    if (!majuscule(cour)) {
		res += cour;
	    }
	    else {
		ident += cour;
		while (i < lg && majuscule(cour) && !ensembles.containsKey(ident)) {
		    cour = value.charAt(i);
		    i++;
		    if  (majuscule(cour)) 
			ident+=cour;
		}

		// on a un identificateur
		if (ensembles.containsKey(ident)) {
		    res = res + ensembles.get(ident);
		}
		else 
		    erreur(8);
	    }
	}
	return res;
    }
	      

    /** Fabrication d'une nouvelle règle à partir d'une ligne du fichier .
     * <p><b>Définition</b> : Une règle est de la forme suivante :
     * <p> <center> <code> pref [[ <racine> ]] suf -> phoneme </code> </center> </p>
     * <p>
     * <ul>
     *   <li> <code>pref</code> et <code>suf</code> sont des expressions régulières syntaxiquement correctes </li>
     *   <li> <code>racine</code> et <code>phoneme</code> sont des chaines de caractères standarts
     * </ul>
     *</p>
     * @return une nouvelle Regle construite à partir de ce qu'on vient de lire.
     * @throws AnalyseException
     */
    public Regle nouvelleRegle() throws  AnalyseException {
	StringTokenizer line = tokensLine(br);

	if (!line.hasMoreTokens())
	    erreur(9);
	String courant = line.nextToken();

	if (fin(courant)) {
	    vide = true; 
	    return null;
	}
	else {
	    String pref;
	    
	    if (ouvrant(courant))
		pref = "";
	    else {
		pref = analyseExpReg(courant);
		if (!line.hasMoreTokens())
		    erreur(10);
		courant = line.nextToken();
		if (!ouvrant(courant))
		    erreur(10);
	    }
	    String racine = analyseRacine(line);
	    
	    if (!line.hasMoreTokens()) 
		erreur(11);
	    courant = line.nextToken();
	    String suf;
	    if (fleche(courant)) 
		suf = "";
	    else {
		suf = analyseExpReg(courant);
		if (!line.hasMoreTokens()) 
		    erreur(11);
		courant = line.nextToken();
		if (!fleche(courant))
		    erreur(11);
	    }
	    String phoneme = analysePhoneme(line);
	    return new Regle(pref,racine,suf,phoneme);
	}
    }

    /** Pour analyser la racine
     * Précondition : 
     *      1. On vient de lire le tag '[['
     * Postcondition :
     *      1. si la chaine est correcte, line commence après le tag ']]'
     * @param line le tokenizer de la ligne que l'on analyse.
     * @return La chaine de caractères qui représente la racine.
     */
    private String analyseRacine(StringTokenizer line) throws AnalyseException {
	if (!line.hasMoreTokens()) 
	    erreur(12);
	String courant = line.nextToken();
	if (!minuscules(courant)) 
	    erreur(13);
	String racine  = courant;
	if (!line.hasMoreTokens()) 
	    erreur(14);
	courant = line.nextToken();
	if (!fermant(courant)) 
	    erreur(14);
	return racine;
    }

    /** Pour analyser le phonème
     * Précondition : 
     *       1. on vient de lire le tage de transition '->'
     * Postcondition : 
     *       1. si la chaine est correcte, 'line' est vide
     * @param line le tokenizer de la ligne que l'on analyse.
     * @return La chaine de caractères qui représente la racine.
     */
    private String analysePhoneme(StringTokenizer line) throws AnalyseException {
	String pho = "";
	String courant ="";
	while (line.hasMoreTokens() && ! comment(courant )) {
	    courant = line.nextToken();
	    if (!comment(courant)) 
		pho = pho + " " + courant;
	}
	return pho;
    }


    /** 
     * Méthodes pour identifier les unités lexicales
     */ 

    /** teste si une chaine est entièrement en majuscule
     * @param s la chaine en question
     * @return true si c'est le cas, false sinon
     */
    private static boolean majuscules(String s) {
	for (int i = 0; i < s.length();i++)
	    if (!majuscule(s.charAt(i))) 
		return false;
	return true;
    }

    /** Teste si une chaine est composée de lettre acceptée comme racine
     * Définition : 
     *       accpetée comme faisant partie de la racine = lettre minuscule, ' ou _
     * @param s la chaine de caractère à analyser
     * @return true si c'est bon, false sinon.
     */
    private static boolean minuscules(String s) {
	for (int i = 0; i < s.length();i++) {
	    char c = s.charAt(i);
	    if (c != '\'' && c !='_' && c != '~' && c != 'æ'  )
		if (!Character.isLowerCase(c)) 
		    return false;
	}
	return true;
    }

    /** Teste si un caractère est en majuscule
     * @param c le caractère en question
     * @return true si c'est bon, false sinon
     */
    private static boolean majuscule(char c) {
	return Character.isUpperCase(c);
    }


    /** Teste si une chaine est un commentaire
     * Définition : 
     *       commentaire = ligne commençant par #
     * @param s la chaine à tester
     * @return true si c'est un commentaire, false sinon
     */
    private boolean comment(String s) {
	if (s.length() != 0) {
	    int i;
	    for (i=0; i < s.length() && s.charAt(i)==' '; i++) {} // On dégage les espaces en début de chaine
	    if (i < s.length()) 
		return s.charAt(i)=='#';
	}
	return false;
    }

    /** Teste si une chaine est le tag de fin de fichier
     * Définition : 
     *       tag de fin de fichier = mot clé 'END'
     * @param s la chaine à tester
     * @return true si c'est le tag en question, false sinon
     */
    private boolean fin(String s) {
	return s.equals("END");
    }

    /** Teste si une chaine est le tag d'ouverture de racine 
     * Définition : 
     *       tag d'ouverture de racine = mot clé  '[['
     * @param s la chaine à tester
     * @return true si c'est le tag en question, false sinon
     */
    private boolean ouvrant(String s){
	return s.equals("[[");
    }

    /** Teste si une chaine est le tag de fermeture de racine
     * Définition : 
     *       tag de fermeture de racine = mot clé ']]'
     * @param s la chaine à tester
     * @return true si c'est le tag en question, false sinon
     */
    private boolean fermant(String s){
	return s.equals("]]");
    }

    /** Teste si une chaine est le tag de transition
     * Définition : 
     *       tag de transition = mot clé '->'
     * @param s la chaine à tester
     * @return true si c'est le tag en question, false sinon
     */
    private boolean fleche(String s) {
	return s.equals("->");
    }

    /** Teste si une chaine est le tag de début de définition des classes
     * Définition : 
     *       tag de définition des classes = mot clé 'CLASSES'
     * @param s la chaine à tester
     * @return true si c'est le tag en question, false sinon
     */
    private boolean classes(String s) {
	return s.equals("CLASSES");
    }

    /** teste si une chaine est le tag de classe
     * Définition : 
     *       tag de classe = mot clé 'CLASS'
     * @param s la chaine à tester
     * @return true si c'est le tag en question, false sinon
     */
    private boolean classs(String s) {
	return s.equals("CLASS");
    }

    /** teste si une chaine est le tag de règles
     * Définition : 
     *       tag de règles = mot clé 'RULES'
     * @param s la chaine à tester
     * @return true si c'est le tag en question, false sinon
     */
    private boolean rules(String s) {
	return s.equals("RULES");
    }
    

    /** Méthode pour transmettre les exceptions selon le type d'erreur
     * @param i l'entier correspondant au code d'erreur rencontrée
     */
    private void erreur(int i) throws AnalyseException {
	switch (i) {
	case 1 : 
	    throw new AnalyseException("Fin fichier de regles",noLigne);
	case 2 : 
	    throw new AnalyseException("Manque mot clef CLASSES ou RULES", noLigne);
	case 3 : 
	    throw new AnalyseException("Les mots clefs doivent etre en majuscules", noLigne);
	case 4 : 
	    throw new AnalyseException("Identificateur déjà utilisé", noLigne);
	case 5 : 
	    throw new AnalyseException("Manque nom de classe", noLigne);
	case 6 : 
	    throw new AnalyseException("Manque définition de classe", noLigne);
	case 7 : 
	    throw new AnalyseException("Mauvaise syntaxe d'expression régulière : ", noLigne);
	case 8 : 
	    throw new AnalyseException("Majuscules interdites en dehors des identificateurs d'ensembles", noLigne);
	case 9 : 
	    throw new AnalyseException("Tag END attendu",noLigne);
	case 10 : 
	    throw new AnalyseException("Tag [[ attendu",noLigne);
	case 11 : 
	    throw new AnalyseException("Tag -> attendu",noLigne);
	case 12 : 
	    throw new AnalyseException("Racine de règle attendue",noLigne);
	case 13 : 
	    throw new AnalyseException("La racine de règle doit etre en minuscules",noLigne);
	case 14 : 
	    throw new AnalyseException("Tag ]] attendu",noLigne);
	}
    }

}
