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


/** Une classe permettant la gestion des indices dans les chaines de caractères
 */
public class Indice {
    // L'indice courant
    private int indice;

    /** Construit une instance d'Indice suivant le paramètre fourni
     * @param i le numéro de l'indice voulu
     */
    public Indice(int i) {
	indice = i;
    }

    /** Construit une instance d'indice initialisé à 0
     */
    public Indice() {
	this(0);
    }

    /** Incrémente l'indice d'un facteur donné
     * @param i le facteur en question
     */
    public void inc(int i) {
	indice+=i;
    }

    /** Incrémente l'indice d'un facteur 1
     */
    public void inc() {
	indice++;
    }

    /** Pour avoir la valeur courante de l'indice
     * @return la valeur courante stocké dans l'instance
     */
    public int val() {
	return indice;
    }
    
    /** Pour mettre à jour la valeur stockée dans l'Indice
     * @param i la nouvelle valeur
     */
    public void val(int i) {
	indice = i;
    }

    /** Teste l'égalité entre l'indice courant et le paramètre
     * @param i la valeur à tester
     * @return true si égalité, false sinon
     */
    public boolean egal(int i) {
	return indice == i;
    }

    /** Teste la supériorité stricte pour l'indice courant et le paramètre
     * @param i le paramètree à tester
     * @return true si <code>courant > i</code>, false sinon
     */
    public boolean plusGrand(int i) {
	return indice > i;
    }

    /** Teste la supériorité au sens large pour l'indice courant et le paramètre
     * @param i le paramètree à tester
     * @return true si <code>courant >= i</code>, false sinon
     */
    public boolean grandOuEgal(int i) {
	return indice >= i;
    }

    /** Pour afficher une instance d'indice
     * @return une chaine de caractères représentant l'indice
     */
    public String toString() {
	return " " + indice + " ";
    }
}
