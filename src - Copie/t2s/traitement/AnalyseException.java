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

public class AnalyseException extends Exception{
    
    // Le message associé à l'erreur
    private String message;
    // La ligne ou est apparue l'erreur
    private int line;

    /** Le constructeur standart d'execption d'analyse
     * @param m le message associé à l'exception levée
     * @param l la ligne ou l'on à levé l'exception
     */
    public AnalyseException(String m, int l) {
	super();
	message = m;
	line = l;
    }

    /** Méthode standart d'affichage
     * @return une chaine de caractères de la forme Erreur Ligne XX : type de l'erreur
     */
    public String toString() {
	return "Erreur Ligne " + line + " : " + message;
    }
}
