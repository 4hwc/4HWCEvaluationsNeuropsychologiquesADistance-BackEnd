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
import java.util.Vector; /* Confusion entre le t2s.util.Random et le java.util.Random ... no comment ... */


/** Classe représentant un Phonème.
 * <p><b>Définition</b> : Un phonème est constitué : </p>
 * <p><ul>
 *   <li> d'une chaine de caractère le représentant </li>
 *   <li> d'une <i>suite</i> de couple de prosodie </li>
 *   <li> de sa durée </li>
 * </ul></p>
 * <p><b>Exemple de Phonèmes</b> : (mot <i>bonjour</i>)</p>
 * <p><code>
 * b 187  8 163 16 160 <br>
 * o~ 123  14 148 29 149 44 151 49 148<br>
 * Z 88  11 139 25 137<br>
 * u 95  8 122 15 122<br>
 * R 163  8 109 16 108<br>
 * _ 130 <br>
 * </code></p>
 * <p> Le phonème <code>'b'</code> à une durée de 187. 
 * <ul><li>Durant 8% de sa durée, il est prononcé à la fréquence 163 Hz</li>
 * <li>puis, à partir de 16%, il est prononcé à la fréquence 160 Hz </li></ul>
 */
public class Phoneme {

    private String pho;       //Chaine de caractères représentant le phoneme
    private Vector prosodie;  //tableau contenant la prosodie du phoneme
    private int longueur;     //durée du phoneme

    /** Pour créer un phoneme à partir d'une chaine de caractère.
     * <p><b>Remarque</b> : la suite de couple de prosodie est vide </p>
     * @param pho la chaine de caractère représentant le phonème.
     */
    public Phoneme(String pho) {
	this.pho = pho;
	this.prosodie = new Vector();
	longueur = duree(pho);
    }

    /** Pour créer un phoneme à partir d'une chaine de caractère, en spécifiant sa durée.
     * <p><b>Remarque</b> : la suite de couple de prosodie est vide </p>
     * @param pho la chaine de caractère représentant le phonème.
     * @param l la durée du phonème
     */
    public Phoneme(String pho, int l) {
	this.pho = pho;
	this.prosodie = new Vector();
	longueur=l;
    }


    /** Un constructeur qui est un peu comme le H de Hawaï (... il sert à rien !)
     * @param pho la chaine de caractère du phonème
     * @param prosodie le <code>Vector</code> contenant les couples de prosodies a appliquer à ce phonème.
     */
    private Phoneme(String pho, Vector prosodie) {
	this.pho = pho;
	this.prosodie = prosodie;
    }

    /** Pour retrouver la chaine de caractère du phonème
     * @return la chaine de caractères représentant le phonème.
     */
    public String getPho() {
	return pho;
    }

    /** Pour récuperer la suite de couples de prosodies du phonème
     * @return le <code>Vector</code> qui va bien ^_^.
     */
    public Vector getProsodie() {
	return prosodie;
    }

    /** Pour récuperer la longueur (durée) du phonème
     * @return la durée du phoneme.
     */
    public int getLongueur() {
	return longueur;
    }

    /** Pour modifier la chaine de caractères du phonème
     * @param pho la nouvelle chaine de caractère.
     */
    public void setPho(String pho) {
	this.pho = pho;
    }

    /** Pour modifier la durée du phonème
     * @param longueur la nouvelle durée
     */
    public void setLongueur(int longueur) {
	this.longueur = longueur;
    }

    /** Pour allonger un Phonème en fonction du type de syntagme
     * @param s le syntagme dont fait partie le phonème.
     */
    public void allonge(Syntagme s) {
	int l = (s.court()) ? 50 : 100;
	this.longueur = longueur + l;
    }

    /** Pour savoir si le phonème est une pause
     * @return true si c'est le cas, false sinon.
     */
    public boolean estPause() {
	return pho.equals("_");
    }

    /** Pour savoir s'il s'agit d'une d'une occlusive voisée.
     * <p><b>Besoin d'aide ?</b> : <i>cf.</i> <a href="http://fr.wikipedia.org/wiki/Occlusive"><code>WikiPédia</code></a></p>
     * @return true si c'est le cas, false sinon.
     */
    public boolean occlusiveVoisee() {
	String p = pho;
	return p == "b" || p == "d" || p == "g";
    }


    /** Pour Calculer automatiquement la durée d'un phonème
     * @param s une String représentant un phonème
     * @return int : la durée associée
     * <p>Fonction qui détermine la durée à appliquer au phoneme s.</p>
     */
    private int duree(String s) {
	// groupes de phonèmes ayant les mêmes durées (classification prise dans le script PERL).
	String[][] groupe = {{"R", "l", "H"},                     //       d < 70
			     {"d", "n", "j", "w"},                //  70 < d < 80
			     {"b", "v", "Z", "m", "N", "i", "y"}, //  80 < d < 90
			     {"t", "k", "z", "e", "a", "o", "u"}, //  90 < d < 100
			     {"p", "O", "E"},                     // 100 < d < 110
			     {"f", "S", "s", "2"}};               // 110 < d

	//Facteur permettant de faire fluctuer la durée aléatoirement
	//        - 4 <= facteur <= 4 
	int sign = (Math.random() > 0.5) ? 1 : -1;
	int facteur = (int) (sign * 4 * Math.random()) ;

	//les phonemes "a~,e~,..." sont longs 
	if (s.endsWith("~"))  
	    return 120+facteur;

	// on applique une durée en fonction du groupe
	for (int i = 0; i < groupe.length; i++)
	    for (int j = 0; j < groupe[i].length; j++)
		if (s.equals(groupe[i][j])) {
		    return 65 + 10 * i + facteur;
		}
    
	//sinon la durée est : 70 - facteur <= d <= 70 + facteur
	return 70 + facteur;
    }

    /** Pour affecter une prosodie (suite de couple de Prosodie) au phonème
     * @param f la fréquence autour de laquelle on fait varier les phonèmes longs
     */
    protected void setProsodie(int f) {
	int l = longueur;
	// nb de variations du pitch entre 1 et 5 si la durée est d'au moins 95
	int nbVariations = (l<95) ? 1: Random.unsignedDelta(1,Integer.parseInt(ConfigFile.rechercher("NB_VARIATIONS_PITCH")));
	SuiteCroissante pourcentage = new SuiteCroissante(nbVariations);
	Vector v = new Vector();
	// les occlusives voisées abaissent la fréquence
	if (occlusiveVoisee()) 
	    f -= 10;

	for (int i = 0; i <= nbVariations; i++) {
	    CoupleProsodie cp = new CoupleProsodie(pourcentage.next(),Random.delta(f,4));
	    v.add(cp);
	}
	prosodie = new Vector(v);
    }


    /** Méthode standart d'affichage d'un phonème (conformité au format MBROLA)
     * @return la représentation du phoneme au format MBROLA
     */
    public String toString() {
	String s = getPho() + " " + getLongueur() + " ";
	for (int i = 0; i < prosodie.size(); i++) {
	    CoupleProsodie couple = (CoupleProsodie) prosodie.get(i);
	    s += " " + couple.getPourcentage() + " " + couple.getFrequence();
	}
	return s;
    }
}

