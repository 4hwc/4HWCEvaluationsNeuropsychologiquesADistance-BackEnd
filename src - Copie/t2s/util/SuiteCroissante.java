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

package t2s.util;

/** Une classe pour générer des suites de nombre aléatoires croissants 
 */

public class SuiteCroissante {

    private static final int PAS = Integer.parseInt(ConfigFile.rechercher("PAS_SUITE")); // pas de variation de la suite
    private int min;                   // valeur min
    private int max;                   // valeur max
    private int longueur;              // nombre d'éléments de la suite
    private int etape;                 // le nombre d'étape 
    private int courant;               // la valeur courante

    /** Pour construire une suite croissante
     * @param m la valeur minimale
     * @param ma la valeur maximale
     * @param l la longueur de la suite
     */
    public SuiteCroissante(int m, int ma, int l){
	min = m;
	max = ma;
	longueur = l;
	courant = 0;
	etape = 1;
    }

    /** Constructeur par défaut : Utilise les valeurs du fichier de configuraiton
     * @param l la longueur de la suite
     */
    public SuiteCroissante(int l) {
	this(Integer.parseInt(ConfigFile.rechercher("MIN_SUITE")),Integer.parseInt(ConfigFile.rechercher("MAX_SUITE")),l);
    }

    
    /** Pour obtenir la prochaine valeur de la suite 
     * @return la valeur entière qui va bien !
     */
    public int next() {
	courant = Math.min(max, (int)(courant + Random.unsignedDelta(min,PAS*etape)));
	etape++;
	return courant;
    }
}
