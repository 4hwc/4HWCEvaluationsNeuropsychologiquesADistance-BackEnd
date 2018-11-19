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

/** Exception liée a la classe Pretraitement, quand a partir d'un texte, on ne peut plus obtenir de Phrase
 */

public class RegleException extends Exception{
    
    // Le message a afficher
    private String message;
    // La ligne ou est apparue l'erreur
    private int line;

    /** Le constructeur d'Exception de Règle
     * @param m le message de l'exception
     * @param l la ligne ou est apparue l'erreur
     */
    public RegleException(String m, int l) {
	super();
	message = m;
	line = l;
    }
    /** La méthode d'affichage standart de l'exception
     * @return une chaine de caractères de la forme "Erreur ligne XX : type de l'erreur"
     */
    public String toString() {
	return "Erreur Ligne " + line + " : " + message;
    }
}
