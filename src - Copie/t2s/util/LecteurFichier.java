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

import java.io.*;

/** Une classe pour lire la totalité d' un fichier
 */

public class LecteurFichier{

    // un lecteur 'tamponné' ^_^
    private BufferedReader br;

    /** Le codage utilisé dans les fichiers, une constante !
     */

    public static final String CODAGE = ConfigFile.rechercher("ENCODAGE_FICHIER");//"ISO-8859-1"; 
    
    /** construit un lecteur de fichier (encodé selon CODAGE)
     * @param name le nom du fichier que l'on voudra lire
     */

    public LecteurFichier(String name) {
	try {
	    FileInputStream fos = new FileInputStream(name);
	    br = new BufferedReader(new InputStreamReader(fos,CODAGE)); 
	} 
	catch (UnsupportedEncodingException ue) {
	    System.err.println("SI_VOX WARNING [LecteurTexte] : Problème de codage du fichier !");
	}
	catch (FileNotFoundException fe) {
	    System.err.println("SI_VOX WARNING [LecteurTexte] : Fichier '"+ name +"' introuvable !");
	}
    }
    
    /** Pour lire effectivement la totalité du fichier
     * @return une chaine de caractères contenant la totalité du fichier
     */
    public String toutLire() {
	int lecture = 0;
	String s = "";
	try {
	    while ( (lecture = br.read()) != -1) {
		s += (char) lecture;
	    }
	    br.close();
	}
	catch (Exception e) {
	    System.err.println("SI_VOX WARNING [LecteurTexte.toutLire] : Une erreur est survenue !");
	    e.printStackTrace();
	}
	return s;

    }
}

