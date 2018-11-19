/*  
 * SI VOX Copyright (C) 2004 - 2005
 *
 * Author :
 *   ESSI2 school project (2004) : Affouard, Lemonnier, Fournols ,Lizzul
 *   Tutor                (2004) : H�l�ne Collavizza   [ helen@essi.fr    ] 
 *                                 Jean-Paul Stromboni [ strombon@essi.fr ]
 *
 * Contributor :
 *   (2004) : Louis Parisot [ parisot@essi.fr ]
 *   (2005) : S�bastien Mosser  [ mosser@essi.fr ]
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
import t2s.util.ConfigFile;

/** Class permetant de synth�tiser un fichier sonore a partir d'un fichier de phon�me
 */
public class SynthetiseurMbrola{

    /** Le chemin vers l'ex�cutable <code>MBROLA<code>*/
    protected final static String MBROLAHOME = ConfigFile.rechercher("MBROLA_HOME"); 
    /**
     * Les base vocales utilis�e par MBROLA
     */
    /** La voix par d�faut */
    protected final static String VOIX1 = ConfigFile.rechercher("VOIX_1");
    /** La seconde voix utilisable  */
    protected final static String VOIX2 = ConfigFile.rechercher("VOIX_1");
    /** La troisi�me voix utilisable */
    protected final static String VOIX3 = ConfigFile.rechercher("VOIX_1");

    private String exe;         // l'ex�cutable
    private String home;        // l'home de mbrola
    private String voix;        // la librairie de voix
    private String pathFichier; // le r�pertoire des fichiers
    private String fichier;     // le nom de fichier de phoneme (sans extension)
    private int taille; 

    /** Constructeur complet
     * @param mb le repertoire ou se trouve MBROLA (racine des 2 versions)
     * @param v la voix � utiliser pour synth�tiser le fichier sonore
     * @param pf le chemin d'acc�s au repertoire contenant les fichiers a traiter
     * @param f Le nom du fichier de phon�me � traiter, sans l'extension '.pho'
     * @param n la taille
     */
    public SynthetiseurMbrola(String mb, String v, String pf, String f, int n) {
	if(System.getProperties().getProperty("os.name").equals("Linux")){
	    exe = ConfigFile.rechercher("EXE_LINUX");
	}
	else{
	    exe = ConfigFile.rechercher("EXE_WINDOWS");
	}
	home = mb;
	voix = v;
	pathFichier =  pf;
	fichier = f;
	taille = n;
    }

    /** Constructeur un peu all�g� (utilisation des valeur par d�faut)
     * @param v la voix � utiliser pour synth�tiser le fichier sonore
     * @param pf le chemin d'acc�s au repertoire contenant les fichiers a traiter
     * @param f Le nom du fichier de phon�me � traiter, sans l'extension '.pho'
     * @param n la taille
     */
    public SynthetiseurMbrola(String v, String pf, String f, int n) {
	this(MBROLAHOME,v,pf,f,n);
    }

    /** Constructeur completement all�g�
     * @param pf le chemin d'acc�s au repertoire contenant les fichiers a traiter
     * @param f Le nom du fichier de phon�me � traiter, sans l'extension '.pho'
     * @param n la taille
     */
    public SynthetiseurMbrola(String pf, String f, int n) {
	this(MBROLAHOME,VOIX1,pf,f,n);
    }

    /** Pour cr�er le fichier wav et le lire dans un JuxeBox
     */
    public void play(){
	Runtime r = Runtime.getRuntime();
	String cmd = home + exe + " " + home + voix + " " + pathFichier + fichier + ".pho "  + pathFichier + fichier + ".wav";
	try {
	    r.exec(cmd);
	    // on laisse le temps au process r de transformer tous les phon�mes
	    int zzz = (taille > 10) ? 10*taille : 100;
	    Thread.sleep(zzz);
	}
	catch (Exception e) {
	    System.out.println("SI_VOX WARNING [SynthetiseurMbrola].play : Une erreur est survenue !");
	    System.out.println(e);
	} 
	JukeBox j = new JukeBox(pathFichier + fichier + ".wav");
	j.playSound();
    }

    /** Pour seulement cr�er le fichier wav, mais sans le lire.
     */
    public void muet(){
	Runtime r = Runtime.getRuntime();
	String cmd = home + exe + " " + home + voix + " " + pathFichier + fichier + ".pho "  + pathFichier + fichier + ".wav";
	try {
	    r.exec(cmd);
	    // on laisse le temps au process r de transformer tous les phon�mes
	    int zzz = (taille > 10) ? 10*taille : 100;
	    Thread.sleep(zzz);
	}
	catch (Exception e) {
	    System.out.println("SI_VOX WARNING [SynthetiseurMbrola].muet : Une erreur est survenue !");
	    System.out.println(e);
	}
    }

}
