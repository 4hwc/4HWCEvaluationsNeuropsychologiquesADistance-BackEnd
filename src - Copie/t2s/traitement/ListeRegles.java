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

import java.util.regex.*;


/** Une implémentation d'une liste simplement chainée pour des instances de <code>Regle</code>.
 * <p><b>Remarque</b> : les règles sont classées par taille de <code>(suffixe + prefixe)</code>.On applique ainsi la règle la plus grande possible en premier</p>
 */
public class ListeRegles {

    /** Le tag correpsondant à la situation où il n'y a pas de règles */
    public static final String PAS_DE_REGLE = "vide";

    ListeRegles suivant;
    Regle tete;

    /** Constructeur de liste vide.
     * <p><b>Remarque</b> : Une liste de règles vide n'a ni suivant ni tête (mis à <code>null</code>).</p>
     */
    public ListeRegles() {
	suivant = null;
	tete = null;
    }

    /** Construit une liste de Regle.
     * @param regle la regle a rajouter en tête dans la liste
     * @param suivant la liste de règles qui suivra <code>regle</code>
     */
    private ListeRegles(Regle regle, ListeRegles suivant) {
	this.suivant = suivant;
	this.tete = regle;
    }

    /** Pour récuperer l'élément suivant dans la liste (une liste de règles, privé de la tête de <code>this<code>)
     * @return l'élément suivant.
     */
    public ListeRegles getListeSuivante() {
	return suivant;
    }

    /** Pour recuperer la regle présente en tête de liste
     * @return l'élément présent en tête.
     */
    public Regle getRegle() {
	return  tete;
    }

    /** Pour ajouter une règle à la liste.
     * <p><b>Remarque</b> : On respecte un ordre décroissant sur la taille du suffixe et du préfixe</p>
     * @param t la regle que l'on veut ajouter dans la liste courante
     */
    public void ajouter(Regle t) {
	if (estVide()||t.priorite() > tete.priorite()) {
	    suivant = new ListeRegles(tete,suivant);
	    tete = t;
	}
	else 
	    suivant.ajouter(t);
    }

    /** Pour savoir si la liste est vide.
     * @return true si c'est le cas, false sinon.
     */
    public boolean estVide(){
	return tete == null;
    }

    /** Pour trouver les phonèmes associé à un mot.
     * <p><b>Remarque</b> : On applique la première règle qui s'unifie à la sous-chaine du <code>mot</code> se terminant sur <code>indice</code></p>
     * @param mot le mot que l'on veut transformer
     * @param indice l'entier représentant l'indice sur lequel on finit l'analyse.
     * @return  le phonème correspondant à la partie du mot unifiée
     */
    public String trouverPhoneme(String mot, int indice) {
	//System.out.println("finit sur : " + mot.charAt(indice-1));

	if (estVide()) 
	    return PAS_DE_REGLE;
	else {
	    String corps = getRegle().getRacine();
	    int debutRacine = indice - corps.length();
	    String prefixe = getRegle().getPrefix();
	    String suffixe = getRegle().getSuffix();

	    // on regarde si un suffixe s'unifie
	    // il faut que l'unification commence sur debutRacine
	    Pattern p = Pattern.compile(corps + suffixe);
	    Matcher m = p.matcher(mot);
	    if (m.find(debutRacine) && m.start() == debutRacine ) {
		// on regarde si un préfixe s'unifie
		// il faut que l'unification se termine sur indice
		p = Pattern.compile(prefixe + corps);
		m = p.matcher(mot);
		boolean prefixeOK = false;
		while (!prefixeOK && m.find()) {
		    if (m.end() == indice) 
			prefixeOK =true;
		}
		if (prefixeOK) {
		    return getRegle().getPhoneme();
		}
	    }
	    // cette règle ne s'applique pas, 
	    // on cherche une autre règle
	    return getListeSuivante().trouverPhoneme(mot,indice);
	}
    }

    /** Méthode d'affichage standart d'une liste de règles.
     * @return la chaine de caractères qui va bien ^_^.
     */
    public String toString()  {
	if (estVide()) 
	    return "";
	else 
	    return getRegle().toString() + getListeSuivante().toString();
    }

}
