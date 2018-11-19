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

import java.util.Vector;
import java.util.StringTokenizer;
import t2s.traitement.*;
import t2s.util.*;
import java.io.*;

/** Une Classe pour décrire une courbe intonative selon le rapport <code>ENST D76003 [1976]</code>.
 * <p> On dispose de  4 niveaux d'intonation, et de 5 courbes prédéfinies : 
 * <ul>
 *      <li>courbe A : du niveau 2 au niveau 3 (début phrase)</li>
 *      <li>courbe B : du niveau 2 au niveau 4 convexe (milieu de phrase)</li>
 *      <li>courbe C : du niveau 2 au niveau 4 concave (question)</li>
 *      <li>courbe D : du niveau 2 au niveau 1 (fin de phrase)</li>
 *      <li>courbe E : du niveau 4 au niveau 1 (fin de phrase exclamative)</li>
 * </ul></p>
 * <p><code>Rapport ENST D76003 [1976]</code> : <i>Programme de transcription phonétique en langue française</i>
 * <ul>
 *   <li> H. Fervers </li>
 *   <li> J. Leroux  </li>
 *   <li> L. Miclet </li>
 * </ul></p>
 */

public class Courbe {

    private Syntagme synt;          // le type de la phrase
    private int frequenceInit;      // valeur de y1
    private int nbPoint;            // nb de points à traiter
    private int hauteurNiveau;      // hauteur entre les 4 niveaux
    private double coeffk;          // coefficient K pour les courbes A et B
    private int xn;                 // le point courant

    /**
     * Constructeur
     */

    /** Constructeur complet
     * @param s le syntagme associé à la courbe
     * @param f la fréquence initiale de la courbe
     * @param n le nombre de points utilisé par la courbe
     * @param h la hauteur entre les 4 niveaux des courbes
     */
    public Courbe(Syntagme s, int f, int n, int h) {
	synt =  s;
	frequenceInit = f;
	nbPoint = n;      
	hauteurNiveau = h;
	if (s.mineur()) 
	    coeffk = - (Integer.parseInt(ConfigFile.rechercher("COEFF_K_MINEUR")) * h)/Math.pow(1-n,2) ;
	else 
	    if (s.majeur()) 
		coeffk = - (Integer.parseInt(ConfigFile.rechercher("COEFF_K_MAJEUR"))*h)/Math.pow(1-n,2);
	else 
	    coeffk = 0;
	xn = 0;
    }

    /** Constructeur de courbe plus facile d'accès (valeur par défaut)
     * @param s le type de syntagme
     * @param n le nombre de points de la courbe
     */
    public Courbe(Syntagme s,  int n) {
	this(s,Integer.parseInt(ConfigFile.rechercher("FREQUENCE_INIT")),n,Integer.parseInt(ConfigFile.rechercher("HAUTEUR_PALIER"))); 
    }

    /** Pour construire une courbe constante
     * @param s le syntagme associé
     */
    public Courbe(Syntagme s) {
	this(s,Integer.parseInt(ConfigFile.rechercher("FREQUENCE_INIT")),-1,Integer.parseInt(ConfigFile.rechercher("HAUTEUR_PALIER")));
    }
    
    /** Pour obtenir la prochaine valeur de la courbe (itérateur)
     * @return l'entier correspondant
     */
    public int nextValue() {
	if (xn == -1) {
	    if (synt.finExclam()) 
		return frequenceInit + Integer.parseInt(ConfigFile.rechercher("COEFF_EXCLAMATION"))  * hauteurNiveau;
	    else 
		return frequenceInit + hauteurNiveau;
	} else {
	    xn++;
	    if (synt.mineur()) 
		return valueA();
	    if (synt.majeur()) 
		return valueB();
	    if (synt.finInterro())
		return valueC();
	    if (synt.finExclam()) 
		return valueE();
	    return valueD();
	}
    }

    /** Méthode permettant de savoir s'il reste des points à calculer sur la courbe
     * @return true s'il reste des points, false sinon
     */
    public boolean hasMoreValue(){
	return xn < nbPoint;
    }

    
    /**
     * méthodes privées qui calculent la fréquence selon le type de courbe
     */

    /** Calcul du point suivant, pour une courbe de type A
     * @return la valeur ad'hoc
     */
    private int valueA() {
	double d = (double)(xn-nbPoint);
	return (int)(frequenceInit + Integer.parseInt(ConfigFile.rechercher("COEFF_HAUTEUR_A")) * hauteurNiveau + 
		     coeffk * Math.pow(d,Integer.parseInt(ConfigFile.rechercher("PUISSANCE_A"))));
    }


    /** Calcul du point suivant, pour une courbe de type B
     * @return la valeur ad'hoc
     */
    private int valueB() {
	double d = (double)(xn-nbPoint);
	return (int)(frequenceInit + Integer.parseInt(ConfigFile.rechercher("COEFF_HAUTEUR_B")) * hauteurNiveau + 
		     coeffk * Math.pow(d,Integer.parseInt(ConfigFile.rechercher("PUISSANCE_B"))));
    }


    /** Calcul du point suivant, pour une courbe de type C
     * @return la valeur ad'hoc
     */
    private int valueC() {
	double r = Math.pow((double)(xn-1)/(nbPoint-1),Integer.parseInt(ConfigFile.rechercher("PUISSANCE_C")));
	return (int)(frequenceInit + Integer.parseInt(ConfigFile.rechercher("COEFF_HAUTEUR_C"))*hauteurNiveau - 
		     Integer.parseInt(ConfigFile.rechercher("COEFF_H_SQRT_C")) * hauteurNiveau * Math.sqrt(1 -r));
    }


    /** Calcul du point suivant, pour une courbe de type D
     * @return la valeur ad'hoc
     */
    private int valueD() {
	return (int) (frequenceInit + Integer.parseInt(ConfigFile.rechercher("COEFF_HAUTEUR_D")) * hauteurNiveau -
		      Integer.parseInt(ConfigFile.rechercher("COEFF_H_N-1_D")) * hauteurNiveau*(xn-1)/(nbPoint-1));
    }


    /** Calcul du point suivant, pour une courbe de type E
     * @return la valeur ad'hoc
     */
    private int valueE() {
	return (int) (frequenceInit + Integer.parseInt(ConfigFile.rechercher("COEFF_HAUTEUR_E"))*hauteurNiveau - 
		      Integer.parseInt(ConfigFile.rechercher("COEFF_H_N-1_E")) * hauteurNiveau*(xn-1)/(nbPoint-1));
    }


    /** Une méthode de test éxécutable
     */
    public static void main(String[] s) {
	Courbe c = new Courbe(new Syntagme(Syntagme.MINEUR, Syntagme.PAUSE_COURTE),4);
	System.out.println(c.coeffk);
	while (c.hasMoreValue()) 
	    System.out.println(c.nextValue());
    }

}
