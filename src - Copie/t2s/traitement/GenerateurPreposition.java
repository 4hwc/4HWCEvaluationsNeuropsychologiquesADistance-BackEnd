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
import t2s.util.ConfigFile;

/** Classe d'analyse du fichier qui contient la liste des prépositions.
 * <p> <b> Remarque </b>: selon la préposition, on fera une pause longue ou courte. </p>
 */
public class GenerateurPreposition {

    /* constantes pour définir la durée de la pause */

    /** Une pause courte */
    public static final int COURT = 1;
    /** Une pause longue */
    public static final int LONG = 0;
    /** Absence de pause */
    public static final int VIDE = -1;
    
    // le buffer qui est lu
    private BufferedReader br;
    // le numéro de ligne courante dans le fichier
    private  int noLigne ; 
    // pour savoir si l'on est en train d'analyser une règle longue ou courte
    private int duree;
    // pour savoir s'il reste encore des règles
    private boolean vide;


    /** Construit un generateur de regle a partir d'un fichier de préposition (encodage <code>ISO-8859-1</code>)
     * @param path le chemin d'accès au fichier de prépositions
     */
    public GenerateurPreposition(String path) {
	try {
	    // pour avoir le jeu de caractères ISO
	    FileInputStream fos = new FileInputStream(path);
	    br = new BufferedReader(new InputStreamReader(fos,ConfigFile.rechercher("ENCODAGE_FICHIER"))); 
	    noLigne = 0;
	    vide = false;
	    duree = VIDE;
	}
	catch (FileNotFoundException e) {
	    System.out.println("SI_VOX WARNING [GenerateurPreposition] : Erreur lors du chargement du fichier de regles");
	    System.out.println(e);
	}
	catch (UnsupportedEncodingException e) {
	    System.out.println("SI_VOX WARNING [GenerateurPreposition] : Encodage inconnu");
	    System.out.println(e);
	}
    }

    /** Pour savoir s'il reste encore des règles à lire
     * @return false s'il reste encore des règles à lire, true sinon.
     */
    public boolean vide() {
	return vide;
    }

    /** Pour fermer en lecture le fichier de préposition spécifié dans le constructeur.
     */
    public void close() {
	try {
	    br.close();
	}
	catch (Exception e) {
	    System.out.println("SI_VOX WARNING [GenerateurPreposition.close] : Erreur lors de la fermeture du fichier de regles");	    
	}
    }

    /** Pour lire une ligne à notre manière dans un lecteur bufferisé
     * @param br le lecteur bufferisé en question
     * @return une instance de <code>StringTokenizer</code>, référencé par les caractères <code>'\t', '\n'</code> et <code>'\r'</code>
     */
    public StringTokenizer tokensLine(BufferedReader br) throws AnalyseException {
	String linein = "";
	try {
	    while (linein!=null && (linein.equals("")|| comment(linein))) {
		linein = br.readLine();
		noLigne++;
	    }
	}
	catch (IOException e) {
	    erreur(1);
	}
	if (linein == null) 
	    erreur(4);
	return new StringTokenizer(linein," \t\n\r");
    }



    /** Pour analyser une ligne du fichier, et en produire une instance de Règle.
     * <p> <b>Définition</b> : une preposition est de la forme suivante </p>
     * <p> <center> <code>préposition -> phonème </code></center> </p>
     * <p>
     * <ul> 
     *   <li> <code>'préposition'</code> et <code>'phonème'</code> sont des chaines de caractères.</li>
     *   <li> <code>'préposition'</code> est en minuscules et les <code>' '</code> ont été remplacés par <code>'_'</code>.</li>
     * </ul>
     * </p>
     * @return une nouvelle Regle sur une preposition
     * @throws  AnalyseException
     */
    public Regle nouvellePreposition() throws AnalyseException {
	StringTokenizer line = tokensLine(br);

	if (!line.hasMoreTokens()) 
	    erreur(4);
	String courant = line.nextToken();

	if (fin(courant)) {
	    vide = true; 
	    return null;
	}
	else {
	    if (pause(courant)) {
		// on est sur un mot clef pour indiquer la durée de la pause
		line = tokensLine(br);
		if (!line.hasMoreTokens()) 
		    erreur(6);
		courant = line.nextToken();
		if (pauseLongue(courant)) 
		    duree = LONG;
		else 
		    duree = COURT;
	    }
	    else if (duree == VIDE) 
		erreur(2);
	    // on est en début de règle de préposition
	    // analyse de la préposition
	    if (!minuscules(courant)) 
		erreur(3);
	    String preposition = courant;
	    if (!line.hasMoreTokens()) 
		erreur(5);
	    courant = line.nextToken();
	    if (!fleche(courant)) 
		erreur(5);
	    // analyse du phonème
	    String phoneme = analysePhoneme(line);
	    if (phoneme.equals("")) 
		erreur(7);
	    preposition = "_".concat(preposition);
	    if (!preposition.endsWith("qu'")) 
		preposition = preposition.concat("_");
	    String debut =  (duree == COURT) ? " % " : " %% ";
	    phoneme = debut.concat(phoneme);
	    return new Regle(preposition,phoneme);
	}
    }


    /** Analyse et renvoie le phoneme associé à la ligne courante
     * Précondition : 
     *        on vient de lire la chaine '->'
     * Postcondition : 
     *        Si la chaine est correcte, line est vide
     * @param line le StringTokenizer de la ligne courante
     * @return une String contenant la liste des phonème de la préposition
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

    /** Teste si une chaine est  acceptée comme préposition
     * Définition : 
     *       Chaine acceptée = contient des lettres minuscules, ' ou _
     * @return true si c'est bon, false sinon
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

 
    /** Teste si une chaine est un commentaire
     * Définition : 
     *       commentaire = ligne commençant par #
     * @param s la chaine de caractère représentant la ligne à analyser
     */
    private boolean comment(String s) {
	if (s.length() != 0) {
	    int i;
	    for (i=0; i < s.length() && s.charAt(i)==' '; i++) {} // Pour avancer dans la chaine tant qu'on rencontre des espaces
	    if (i < s.length()) 
		return s.charAt(i)=='#';
	}
	return false;
    }

    /** Teste si une chaine est le tag de fin de fichier
     * Définition : 
     *       tag de fin de fichier = moté clé END
     * @return true si on est la fin, false sinon
     */
    private boolean fin(String s) {
	return s.equals("END");
    }

 
    /** Teste si une chaine est le tag de transition.
     * Définition : 
     *       tag de transition : La flèche '->'
     * @param s la chaine à analyser
     * @return true si c'est le bon tag, false sinon
     */
    private boolean fleche(String s) {
	return s.equals("->");
    }


    /** Teste si une chaine est le tag de pause courte.
     * Définition : 
     *       tag de pause courte = mot clé "PAUSE_COURTE"
     * @param s la chaine à analyser
     * @return true si c'est le bon tag, false sinon
     */
    private boolean pauseCourte(String s) {
	return s.equals("PAUSE_COURTE");
    }

    /** Teste si une chaine est le tag de pause longue
     * Définition : 
     *       tag de pause longue = mot clé "PAUSE_LONGUE"
     * @param s la chaine à analyser
     * @return true si c'est le bon tag, false sinon
     */
    private boolean pauseLongue(String s) {
	return s.equals("PAUSE_LONGUE");
    }

    /** teste si une chaine est un tag de pause (courte ou longue)
     * @param s la chaine à analyser
     * @return true si c'est un tag de pause, false sinon
     */
    private boolean pause(String s) {
	return pauseCourte(s) || pauseLongue(s);
    }

    /** Méthode pour transmettre les exceptions
     */
    private void erreur(int i) throws AnalyseException {
	switch (i) {
	case 1 : 
	    throw new AnalyseException("Fin fichier de regles",noLigne);
	case 2 : 
	    throw new AnalyseException("Manque mot clef PAUSE_COURTE ou PAUSE_LONGUE", noLigne);
	case 3 : 
	    throw new AnalyseException("Les prépositions doivent etre en minuscules, les espaces doivent etre remplacés par des _", noLigne);
	case 4 : 
	    throw new AnalyseException("tag END attendu",noLigne);
	case 5 : 
	    throw new AnalyseException("tag '->' attendu",noLigne);
	case 6 : 
	    throw new AnalyseException("Préposition attendue",noLigne);
	case 7 : 
	    throw new AnalyseException("Phonèmes de la préposition attendue",noLigne);
	}
    }

    /** Une méthode éxécutable pour les tests directs de cette classe.
     */

    public static void main(String[] s) {
	GenerateurPreposition p = new GenerateurPreposition("donnees/rules/preposition.txt");
	try {
	    Regle r = p.nouvellePreposition();
	    while (!p.vide()) {
		System.out.println("regle : " + r);
		r = p.nouvellePreposition();
	    }
	} catch (AnalyseException e) {
	    System.out.println(e);
	}
    }
}
