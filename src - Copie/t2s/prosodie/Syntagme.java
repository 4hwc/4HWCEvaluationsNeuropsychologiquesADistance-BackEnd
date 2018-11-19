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

package t2s.prosodie;

import t2s.traitement.*;
import t2s.util.*;

/** Classe représentant les différentes catégories de syntagme.
 * <p><b>Définition</b> : [ cf. <code><a href="http://fr.wikipedia.org/wiki/Syntagme">WikiPédia</a></code> ]<p>
 * <p> Un syntagme est un ensemble de mots formant une seule unité catégorielle et fonctionnelle, mais dont chaque constituant, parce que dissociable (contrairement au mot composé), conserve sa signification et sa syntaxe propres. Un syntagme constitue donc une association occasionnelle, libre, alors que le mot composé est une association permanente (lorsqu'un syntagme se fige, il devient bien sûr un composé détaché, soit une locution).
 * <ul>
 * <li>Les éléments constitutifs d'un syntagme donné peuvent être de nouveaux syntagmes de niveau inférieur (des sous-syntagmes), structurés à l'instar du syntagme qui les englobe. À son tour, chacun de ces sous-syntagmes pourra le cas échéant, contenir d'autres syntagmes hiérarchiquement subalternes (des sous-sous-syntagmes, en somme), et ainsi de suite.</li>
 * <li>En conséquence, quel que soit le niveau d'un syntagme donné, celui-ci peut virtuellement être inclus dans un syntagme de niveau supérieur (principe de regroupement), mais peut aussi bien inclure un syntagme de niveau inférieur (principe de division) :</li>
 * <ul><li><i>Il a acheté une modeste maison de briques rouges.</i></li>
 * <li>Le syntagme « une modeste maison de briques rouges » est englobé dans le syntagme supérieur, c'est-à-dire, la phrase complète. Mais ce même syntagme « une modeste maison de briques rouges » inclut parmi ses éléments, le syntagme inférieur « de briques rouges », complément du nom « maison ».</li></ul>
 * <li> Ce double principe de regroupement et de division (soit, le principe d'inclusion) et cette identité de structure font du syntagme le véritable constituant syntaxique de la phrase.</li>
 * <li>Le syntagme possède l'unité catégorielle et fonctionnelle du mot indivisible.</li>
 * </ul></p>
 * <p> <b>En clair</b> : un syntagme est une 'partie de phrase'</p>
 */

public class Syntagme {

    /**
     * Les différents types de syntagmes  
     */

    /** Syntagme mineur : début ou milieu de phrase mineure */
    protected static final int MINEUR = 1;      // <==> courbe A
    /** Syntagme majeur : début ou milieu de phrase majeure*/
    protected static final int MAJEUR = 2;      // <==> courbe B
    /** Syntagme intérogatif : fin de phrase interrogative */
    protected static final int FIN_INTERRO = 3; // <==> courbe C
    /** Syntagme final : fin de phrase */
    protected static final int FIN = 4;         // <==> courbe D
    /** Syntagme exclamatif : fin de phrase exclamative */
    protected static final int FIN_EXCLAM = 5;  // <==> courbe E

    /**
     * Les durées des pauses a effectuer
     */
    /** Une pause courte : conjonction de coordination */
    protected static final int PAUSE_COURTE = Integer.parseInt(ConfigFile.rechercher("PAUSE_COURTE")); 
    /** Une pause longue : conjonction de subordination */
    protected static final int PAUSE_LONGUE = Integer.parseInt(ConfigFile.rechercher("PAUSE_LONGUE"));
    /** La pause finale : pour le <i>'point final'</i> */
    protected static final int PAUSE_FIN = Integer.parseInt(ConfigFile.rechercher("PAUSE_FIN"));

    /**
     * Variables privées à l'objet
     */
    private int synt;            // le type de la phrase
    private int pause;           // la durée de la pause associée

    /** Constructeur de syntagme
     * @param s le type de syntagme que l'on souhaite créer (a choisir parmis les constantes)
     * @param d la durée de la pause associée (a choisir parmis les constantes)
     */
    public Syntagme(int s, int d) {
	synt =  s;
	pause = d;
    }

    /** Constructeur de Syntagme par défaut.
     * <p><b>Remarque</b> : cré un <code>Syntagme</code> au sens de <code>this(0,0)</code></p>
     */
    protected Syntagme() {
	this(0,0);
    }

    /** Pour récuperer le code représentant la durée de la pause
     * @return l'entier ad'hoc
     */
    protected int dureePause() {
	return pause;
    }

    /** Pour déterminer le type de syntagme final d'une phrase
     * @param ponctuation la ponctuation de cette phrase
     * @return le Syntagme qui va bien ^_^.
     */
    protected static Syntagme typeFin(int ponctuation) {
	Syntagme synt = new Syntagme();
	switch (ponctuation) {
	case (Phrase.VIRGULE ) : 
	    if (Random.negatif()) 
		synt =  new Syntagme(MINEUR, PAUSE_COURTE);
	    else  
		synt =  new Syntagme(MAJEUR, PAUSE_COURTE); 
	    break;
	case (Phrase.POINT): 
	    synt = new Syntagme(FIN, PAUSE_FIN);
	    break;
	case (Phrase.DEFAUT): 
	    synt = new Syntagme(FIN, PAUSE_FIN);
	    break;
	case (Phrase.INTERROGATION):
	    synt = new Syntagme(FIN_INTERRO, PAUSE_FIN);
	    break;
	case (Phrase.EXCLAMATION):
	    synt = new Syntagme(FIN_EXCLAM, PAUSE_FIN);
	    break;
	}
	return synt;
    }

    /** Pour déterminer le type de syntagme de coupure en fonction du type de coupure % ou %%.
     * <p><b>Précondition</b> : ph contient au moins un % </p>
     * @param ph : une phrase 
     * @param coupure : l'indice dans ph du premier %
     * @return le Syntagme qui va bien ^_^.
     */
    protected static Syntagme type(String ph, int coupure) {
	if (ph.charAt(coupure+1) == '%') 
	    return new Syntagme(MINEUR,PAUSE_COURTE) ;
	else 
	    return new Syntagme(MAJEUR,PAUSE_LONGUE);
    }	


    /**
     * Méthode protégées (aucune raison d'être à l'exterieur du package de prosodie) pour déterminer les types de syntagme
     */
    
    /** Est-ce un syntagme final ?
     * @return true si c'est le cas, false sinon
     */
    protected boolean fin() {
	return (FIN_INTERRO <= synt ) && (synt <= FIN_EXCLAM);
    }

    /** Est-ce un syntagme de fin d'exclamation ?
     * @return true si c'est le cas, false sinon
     */
    protected boolean finExclam() {
	return  (synt == FIN_EXCLAM);
    }

    /** Est-ce un syntagme de fin d'interrogation ?
     * @return true si c'est le cas, false sinon
     */
    protected boolean finInterro(){
	return  (synt == FIN_INTERRO);
    }

    /** Est-ce un syntagme de pause longue?
     * @return true si c'est le cas, false sinon
     */
    protected boolean longb() {
	return (pause == PAUSE_LONGUE);
    }

    /** Est-ce un syntagme de pause courte ?
     * @return true si c'est le cas, false sinon
     */
    protected boolean court() {
	return (pause == PAUSE_COURTE);
    }

    /** Est-ce un syntagme mineur ?
     * @return true si c'est le cas, false sinon
     */
    protected boolean mineur() {
	return (synt == MINEUR);
    }

    /** Est-ce un syntagme majeur ?
     * @return true si c'est le cas, false sinon
     */
    protected boolean majeur() {
	return (synt == MAJEUR);
    }

}
