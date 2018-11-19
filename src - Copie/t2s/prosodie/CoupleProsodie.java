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

/** Classe définissant les couples de prosodie.
 * <p><b>Définition</b> : un <i>Couple de Prosodie</i> est un couple <code>[f,%]</code> </p>
 * <p>On utilise les conventions de format de <code>MBROLA</code><ul>
 *   <li> <code>f</code> : une valeur de fréquence pour faire varier le pitch du signal synthétisé </li>
 *   <li> <code>%</code> : le pourcentage de temps consacré à cette fréquence</li>
 * </ul></p>
 *<p> <b>Plus d'informations</b> : <i>cf. </i> la documentation de <code>MBROLA</code>.
 */

public class CoupleProsodie {
  
    private int pourcentage;
    private int freq;

    /** Constructeur de couple de prosodie par défaut.
     * <p><b>Remarque</b> : Créé un couple (0,0).</p>
     */
    public CoupleProsodie() {
	pourcentage=0;
	freq=0;
    }

    /** Constructeur de couple de prosodie évolué
     * @param p le pourcentage associé à ce couple
     * @param f la fréquence associée à ce couple
     */
    public CoupleProsodie( int p, int f) {
	pourcentage=p;
	freq=f;
    }

    /** Pour obtenir le pourcentage de ce couple
     * @return le pourcentage ad'hoc.
     */
    public int getPourcentage(){
	return pourcentage;
    }

    /** Pour obtenir la fréquence de ce couple
     * @return la fréquence du couple.
     */
    public int getFrequence(){
	return freq;
    }

    /** Pour modifier le pourcentage du couple
     * @param p le nouveau pourcentage
     */
    public void setPourcentage( int p){
	pourcentage=p;
    }

    /** Pour modifier la fréquence du couple
     * @param f le nouvelle fréquence
     */
    public void setFrequence(int f){
	freq = f;
    }

    /** Méthode standart d'affichage
     * @return une chaine de caractères représentant le couple.
     */
    public String toString(){
	return getPourcentage()+" "+getFrequence() + " " ;
    }

}
