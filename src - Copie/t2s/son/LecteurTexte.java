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

package t2s.son;


import java.io.*;
import t2s.prosodie.*;
import t2s.traitement.*;
import t2s.util.*;
import java.util.Vector;


/** Classe de lecture d'un texte
 */

public class LecteurTexte{

    // le path des fichiers de règles utilisé pour transformer les mots en phonèmes
    private final static String PATH_REGLE=ConfigFile.rechercher("CHEMIN_REGLES");
    // le fichier pour écrire les wav ou pho
    private final static String PHO_WAV=ConfigFile.rechercher("FICHIER_PHO_WAV");

    private String outFile ;    //le fichier pour écrire les fichiers son
    private String voix;        // la voix utilisée par MBROLA
    private Arbre arbre;        // l'arbre contenant les règles
    private Pretraitement pt;   // le texte après prétraitement 
    private boolean vide;       // vrai si l'on a traité complètement le texte
    private BufferedReader cin; // entree standard

    /** Constructeur complet de Lecteur de Texte 
     * @param s le texte à lire
     * @param path l'emplacement des fichiers de règles
     * @param of le fichier ou l'on écrit les phonèmes à prononcer
     * @param v la voix à utiliser pour lire ces phonèmes
     * @param isFile Lit - on depuis un fichier ou depuis l'entrée standart ?
     */
    public LecteurTexte(String s,String path,  String of, String v, boolean isFile) {
	outFile = of;
	vide= false;
	voix = v;
	boolean stdin; // vrai si il faut lire sur l'entree standard
	if(s.equals("-")) {
	    stdin = true;
	    cin = new BufferedReader(new InputStreamReader(System.in));
	} else {
	    stdin = false;
	    String texte = (isFile)? (new LecteurFichier(s)).toutLire() : s;
	    pt =  new Pretraitement(texte);
	}
	try {
	    arbre = new Arbre(path); 
	} catch (AnalyseException a) {
	    System.out.println(a);
	}
	if(stdin)
	    interactifMode();
    }

    /** Méthode d'affichage standart
     * @return une chaine de caractère ad'hoc
     */
    public String toString(){
	String s = "";
	s = "  Sortie :=" + outFile +"\n";
	return s;
    }
    
    /** Constructeur allégé utilisant des valeurs par défaut
     * @param s le texte à lire
     * @param isFile Lit-on depuis un fichier ?
     */
    public LecteurTexte(String s, boolean isFile) {
	this(s,PATH_REGLE,PHO_WAV,SynthetiseurMbrola.VOIX1,isFile);
    }

    /** Constructeur completement allégé
     * @param s le texte à lire
     */
    public LecteurTexte(String s) {
	this(s,PATH_REGLE,PHO_WAV,SynthetiseurMbrola.VOIX1,false);
    }

    /** Lecteur de fichier
     */
    public LecteurTexte(File f, String out){
	this(f.toString(),PATH_REGLE,out,SynthetiseurMbrola.VOIX1,true);

    }

    /** Constructeur de lecteur vide.
     */
    public LecteurTexte() {
	this("",false);
    }

    
    /** Pour lire du texte en mode interactif.
     */
    private void interactifMode() {
        try {
            String text = "";
	    String ligne;
	    Phrase p;
	    SynthetiseurMbrola s;
            while (true) {
                ligne = cin.readLine();
                if(ligne != null) {
                    if (ligne.equals("<QUIT>")) {
                        System.exit(0);
                    } else if(!ligne.equals("<END>")) {
                        text = text + ligne;
                    } else {
                        pt = new Pretraitement(text);
                        this.muet(SynthetiseurMbrola.MBROLAHOME);
			System.out.println(outFile + ".wav");
			vide = false;
			text = "";
                    }
                } else {
                    try {
			System.out.println("sleeping...");
                        Thread.sleep(200);
                    } catch(InterruptedException e) {
			System.out.println("InterruptedException in interactifMode()");
		    }
                }
            }
        } catch(IOException e) {
            System.out.println("<IOException>");
        }
    }
	
	
    /** Pour mettre à jour la voix utilisé par le synthétiseur
     * @param v le numéro de la voix (parmis 1,2 ou 3)
     */
    public void setVoix(int v) {
	switch (v) {
	case 1: 
	    voix = SynthetiseurMbrola.VOIX1;
	    break;
	case 2: 
	    voix = SynthetiseurMbrola.VOIX2;
	    break;
	case 3: 
	    voix = SynthetiseurMbrola.VOIX3;
	    break;
	}
    }
   
    /** Pour savoir si le texte est vide
     */
    public boolean vide() {
	return vide;
    }

    /** Pour changer le texte à lire 
     */
    public void setTexte(String s) {
	pt = new Pretraitement(s);
	vide = false;
    }

    /** Pour recharger les fichiers de règles (reconstruction de l'arbre)
     * @param pathRegle l'emplacement du repertoire contenant les règles
     * @param pathPrepo l'emplacement du repertoire contenant les prépositions (DEPRECATED)
     */
    private void reloadArbre(String pathRegle, String pathPrepo) throws AnalyseException {
	arbre = new Arbre(PATH_REGLE);
    }

    /** Pour metttre à jour les règles de prononciation
     */
    public void reloadArbre() throws AnalyseException {
	arbre = new Arbre(PATH_REGLE);
    }

    /** Pour lire le texte phrase par phrase avec Mbrola.
     * @return la chaine de caractère représenant la liste de phonèmes à prononcer.
     */
    public String play() {
	ListePhonemes l = new ListePhonemes();
	try {
	    Phrase p = pt.nouvellePhrase();
	    SynthetiseurMbrola s;
	    if (p != null) {
		l = new ListePhonemes(arbre.trouverPhoneme(p.getPhrase()),p.getProsodie());
		l.ecrirePhonemes(outFile + ".pho");
		s = new SynthetiseurMbrola(voix,outFile, "", l.nombrePhonemes());
		s.play();

		// on laisse le temps de prononcer la phrase
		Thread.sleep(l.dureePhonemes()+ 100);
	    }
	}
	catch (PlusDePhraseException e) {
	    vide = true;
	}
	catch (Exception e) {}
	return l.toString();
    }

    /** Pour lire la totalité d'un texte avec Mbrola
     * @return la chaine de caractères représentant la liste de phonèmes à prononcer.
     */
    public String playAll() {
	ListePhonemes l = new ListePhonemes();
	try {
	    Phrase p = pt.nouvellePhrase();
	    while (true) {
		l.ajouterPhonemes(arbre.trouverPhoneme(p.getPhrase()),p.getProsodie());
		p = pt.nouvellePhrase();
	    }
	}
	catch (PlusDePhraseException e) {
	    vide = true;
	    l.ecrirePhonemes(outFile + ".pho");
	    SynthetiseurMbrola s = new SynthetiseurMbrola(voix,outFile, "", l.nombrePhonemes());
	    s.play();
	    try {
		Thread.sleep(l.dureePhonemes()+ 100);
	    } catch (Exception ee ) {};
	}
	catch (Exception e) {}
	return l.toString();
    }

    /** Pour generer un fichier sonore en mode silencieux (ne rien prononcer).
     * <p><b>Remarque</b> : utilisé majoritairement (uniquement ?) par le serveur web de démonstration</p>
     */
    public String muet() {
	return this.muet(SynthetiseurMbrola.MBROLAHOME);
    }
  
    /** Pour generer un fichier de phonème en mode silencieux (ne rien prononcer)
     * @param mb l'emplacement de MBROLA.
     */
    private String muet(String mb) {
	ListePhonemes l = new ListePhonemes();
	try {
	    Phrase p = pt.nouvellePhrase();
	    while (true) {
		l.ajouterPhonemes(arbre.trouverPhoneme(p.getPhrase()),p.getProsodie());
		p = pt.nouvellePhrase();
		l.ecrirePhonemes(outFile + ".pho");
	    }
	}
	catch (PlusDePhraseException e) {
	    vide = true;
	    SynthetiseurMbrola s = new SynthetiseurMbrola(mb,voix,outFile, "", l.nombrePhonemes());
	    s.muet();
	}
	catch (Exception e) {}
	return l.toString();
    }


}
