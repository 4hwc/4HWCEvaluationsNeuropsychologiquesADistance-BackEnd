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
package t2s;
import t2s.ihm.*;
import t2s.son.*;
import t2s.util.*;
import java.io.*;

/** La classe éxécutable appelée par le manifeste de l'archive auto éxécutable
 */
public class Main{
    
    /** La méthode principale
     */
    public static void main (String[] args){
	try{
	    if (args.length == 0)
		ihm();
	    else{
		if (args[0].equals("-ihm"))
		    ihm();
		else if (args[0].equals("-config"))
		    ConfigFile.lister();
		else if (args[0].equals("-f") && args.length == 2)
		    lireFichier(args[1]);
		else if (args[0].equals("-f") && args.length == 3)
		    genererFichier(args[1],args[2]);
		else {
		    usage();
		    System.exit(0);
		}
	    }
	}
	catch(Exception e){
	    System.out.println("Une erreur est survenue !");
	    e.printStackTrace();
	    System.exit(0);
	}
    }


    /** Pour afficher l'aide
     */
    private static void usage(){
	System.out.println("S.I. VOX : utilisation en ligne de commande");
	System.out.println("  java -jar SI_VOX.jar OPTION [FICHIERS]");
	System.out.println("  Options : ");
	System.out.println("     -ihm             : lance l'interface graphique");
	System.out.println("     -f FICHIER       : Lit FICHIER a haute voix");
	System.out.println("     -f ENTREE SORTIE : génère un fichier SORTIE.wav");
	System.out.println("     -config          : liste la configuration actuelle");
    }


    /** Pour lancer l'interface graphique
     */
    private static void ihm() throws Exception {
	Lecture l = new Lecture();
    }

    /** Pour lire un fichier 
     * @param f le fichier texte à lire
     */
    private static void lireFichier(String f) throws Exception{
	Lecture l = new Lecture(f);
    }

    /** Pout generer le fichier wav sans le lire ...
     * @param in le nom du fichier a lire
     * @param out le nom souhaité pour le fichier de sortie (sans extension, le .wav ext rajouté)
     */

    private static void genererFichier(String in, String out) throws Exception {
	LecteurTexte lt = new LecteurTexte(new File(in),out);
	String pho = "";
	while (!lt.vide()) {
	    // lit une phrase et renvoie sa représentation en phonèmes
	    pho += lt.muet(); 
	}
	System.out.println(pho);
	System.exit(0);
    }
    

}
