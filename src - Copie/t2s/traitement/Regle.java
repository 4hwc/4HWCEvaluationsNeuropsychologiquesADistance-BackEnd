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
import t2s.util.*;

/** Règle de la langue francaise et des exceptions sur les phonemes.
 * <p> Une instance de Regle est composée  : <p>
 * <ul>
 *  <li> D'un préfixe (expression régulière) </li>
 *  <li> D'un suffixe (expression régulière) </li>
 *  <li> D'une racine </li>
 *  <li> D'une chaine courante contenant les phonèmes de la règle </li>
 * </ul
 * <p> A toute règle, on associe automatiquement une priorité, calculé par le poid de chacune des expréssions régulières présente en suffixe et en préfixe.</p>
 */
public class Regle{

    private String prefix;  // le préfixe
    private String suffix;  // le suffixe
    private String racine;  // la racine du mot
    private String phoneme; // la String contenant les phonèmes
    private int priorite;   // la priorité de la règle

    /** Pour construire une Règle vide.
     * <p> Tous les paramètres sont initialisé à la chaine vide.
     */
    public Regle() {
	this("","","","");
    }

    /** Pour construire une Règle sans suffixe ni prefixe.
     * <p> <b> Remarque </b> : utilisé pour les règles sur les prépositions </p>
     * @param r la racine de la règle
     * @param ph la chaine contenant les phonèmes
     */
    public Regle(String r,String ph) {
	this("",r, "", ph);
    }

    /** Pour construire une Règle complète.
     * @param p le préfixe
     * @param r la racine
     * @param s le suffixe
     * @param ph la chaine contenant les phonèmes
     */
    public Regle(String p, String r, String s, String ph) {
	prefix = p;
	suffix = s;
	racine = r;
	phoneme = ph;
	priorite = poids(p) + poids(s);
    }

    /** Pour récuperer le préfixe de la règle
     * @return l'expression reguliere de l'élément prefix.
     */
    public String getPrefix() {
	return prefix;
    }

    /** Pour récuperer le suffixe de la règle
     * @return l'expression reguliere de l'élément suffix.
     */
    public String getSuffix() {
	return suffix;
    }

    /** Pour récuperer la racine de la règle
     * @return  la racine de la règle.
     */
    public String getRacine() {
	return racine;
    }

    /** Pour récuperer le phonème de la règle
     * @return le phoneme associé a l'élément courant.
     */
    public String getPhoneme() {
	return phoneme;
    }

    /** Pour récuperer la priorité de la règle.
     * <p> <b>Remarque</b> : La priorité est la somme du poid de chacune des E.R. présente dans la règle </p>
     * <p> <center> { <code>priorité <-- poid(prefixe) + poid(suffixe)</code> } </center> </p>
     * <p> <b> Calcul du poid </b> : Il s'agit de la longueur maximale de la chaine définie par l'E.R. <br>En cas de choix (<code>'|'</code>),
     *     on prend la longueur de la plus grande chaine.</p>
     * @return la priorité associée a l'élément courant.
     */
    public int priorite() {
	return priorite;
    }

    /** Pour modifier la chaine de phonèmes
     * @param ph la nouvelle chaine à mettre dans la Règle
     */
    public void setPhoneme(String ph) {
	phoneme = ph;
    }

    /* 
     * Méthodes pour calculer la priorité de la règle
     */

    /* Pour calculer le poid d'une E.R.
     */

    private static int poids(String s) {
	return poids(s,new Indice());
    }

    /** Renvoie le poids de l'expression régulière s
     * Définition : 
     *       poids = longueur max de la chaine définie par l'expression régulière s.
     *               { Quand il  y a un choix '|', on prend la longueur de la plus grande chaine. }
     * Précondition : 
     *       1. s est une expression régulière syntaxiquement correcte 
     *       2. On a calculé le poids jusqu'à l'indice ind
     */
    private static int poids(String s, Indice ind) {
	if (fin(s,ind)) 
	    return 0;
	else {
	    int max = poidsTerme(s,ind);
	    while (!fin(s,ind)) {
		char cour = s.charAt(ind.val());
		ind.inc();
		if (cour == '|') {
		    int lgCour = poidsTerme(s,ind);
		    if (lgCour > max) max = lgCour;
		}
	    }	
	    return max ;
	}
    }

    /** Renvoie le poids d'un sous-terme.
     * Définition : 
     *       les sous-termes sont séparés pas des '|'
     * Précondition : 
     *       1. s est une expression régulière syntaxiquement correcte 
     *       2. on a calculé le poids jusqu'à l'indice ind
     * Postcondition : 
     *       1. ind désigne  '|', ')' ou la fin de s
     */
    private static int poidsTerme(String s, Indice ind) {
	if (finTerme(s,ind)) return 0;
	else {
	    char cour = s.charAt(ind.val());
	    if (cour == '[') {
		// on ajoute un caractère à la chaine
		// on continue l'analyse sur ']'
		ind.val(s.indexOf("]", ind.val()));
		//System.out.println("ind : " + ind);
		ind.inc();
		return 1 + poidsTerme(s,ind);
	    }
	    else {
		if (cour == '(') {
		    ind.inc();
		    int lg = poids(s,ind);
		    // on saute la ')'
		    ind.inc();
		    return lg + poidsTerme(s,ind);
		}
		else { // on est sur une lettre
		    ind.inc();
		    return 1 + poidsTerme(s,ind);
		}
	    }
	}
    }	    

    /** Détermine si s[ind] est la fin d'un terme de s
     * Définition : 
     *       fin d'un terme = vide ou égal à ')' ou '|'
     */ 
    private static boolean finTerme(String s, Indice ind) {
	if (ind.egal(s.length())) 
	    return true;
	else {
	    char c = s.charAt(ind.val());
	    return (c==')') || (c=='|');
	}
    }

    /** Détermine si ind est la fin de s
     * Définition : 
     *       fin de la chaine = s[ind] est vide ou égal à ')'
     */
    private static boolean fin(String s, Indice ind) {
	if( ind.egal(s.length())) 
	    return true;
	else {
	    char c = s.charAt(ind.val());
	    return (c==')');
	}
    }


    /**Pour afficher une Règle de manière lisible
     * @return la chaine de caractères qui va bien ^_^.
     */
    public String toString() {
	return ("pref : " + prefix + " racine : " + racine 
		+ " suff :  " + suffix + " pho :  " + phoneme + "\n");
    }

    /** Une méthode éxécutable pour faire des tests
     */
    public static void main(String[] s) {
	System.out.println(poids("(a|[ab][ef])(a|b)|ab[cbfe]a|a[ab](de|abc)dfe", new Indice(0)));
	System.out.println(poids("a",new Indice(0)));
    }
}
