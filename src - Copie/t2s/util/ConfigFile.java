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

/** Une classe pour utiliser un fichier de configuration aisément.
 * <p><b>Remarque</b> : Le fichier de configuration utilise la syntaxe suivante (pas d'espace !) : </p>
 * <p><center><code> MOT_CLE=VALEUR</code></center></p>
 */

public class ConfigFile {

    // Constantes
    private static final String DEFAULT_FILE = "donnees/si_vox.conf";

    // Variables privées : 
    private File f;

    // Le constructeur
    private ConfigFile(File f){
	this.f = f;
    }

    // Pour effectuer une recherche
    private String search(String keyword) {
	try{
	    BufferedReader in = new BufferedReader(new FileReader(f));
	    String line = "";
	    while ((line = in.readLine()) != null){
		String res = analyser(line, keyword);
		if (res != null)
		    return res;
	    }
	    in.close();
	    return null;
	}
	catch(IOException ioe){
	    System.out.println("Erreur d'entrée sortie pour le fichier de configuration !");
	    return null;
	}
    }

    // Pour analyser une chaine de caractère enb fonction d'une clé : 
    private String analyser(String line, String key){
	int size = line.length();
	int i = 0;
	while (i < size && line.charAt(i) != '=')
	    i++;

	if (i == size) // Arrivé en bout de chaine sans rencontrer le signe égal
	    return null;

	String keyword = line.substring(0,i);
	String value = line.substring(i+1);

	if (key.equals(keyword))
	    return value;
	return null;
    }

    // Pour analyser une chaine de caractère, et la séparer en fonction du signe égal
    private void analyser(String line){
	int size = line.length();
	int i = 0;
	while (i < size && line.charAt(i) != '=')
	    i++;

	if (i == size) // Arrivé en bout de chaine sans rencontrer le signe égal
	    return;
	String keyword = line.substring(0,i);
	String value = line.substring(i+1);
	String result = "| " + keyword ;
	while (result.length() < 21)
	    result += " ";
	result += " | \"" + value+"\"";
	while(result.length() < 78)
	    result += " ";
	System.out.println(result+" |");
	afficherLigne();
    }

    // Pour lister le contenu du fichier de configuration : 
    private void toutLister(){
	try{
	    System.out.println();
	    System.out.println("Chargement du fichier de configuration ...");
	    System.out.println("  " + f.getAbsoluteFile());
	    System.out.println();
	    BufferedReader in = new BufferedReader(new FileReader(f));
	    String line = "";
	    while((line = in.readLine()) != null){
		if (!line.equals("") && line.charAt(0) == '^'){
		    System.out.println();
		    System.out.println("   " + line.substring(1));
		    System.out.println();
		    afficherLigne();
		}
		else
		    analyser(line);
	    }
	    System.out.println();
	}
	catch(IOException ioe){
	    System.out.println("Erreur d'entrée sortie pour le fichier de configuration !");
	}
    }

    
    /** Pour lister le contenu du fichier de configuration
     */
    public static void lister(){
	ConfigFile cf = new ConfigFile(new File(DEFAULT_FILE));
	cf.toutLister();
    }
    
    /** Pour afficher n fois le caractère '*'
     */
    private static void afficherLigne(){
	System.out.print("+");
	for (int i = 0; i < 21; i++)
	    System.out.print("-");
	System.out.print("+");
	for (int i = 22; i < 78; i++)
	    System.out.print("-");
	System.out.println("+");
    }

    /** Pour effectuer une recherche dans le fichier de configuration
     * @param key la clé recherchée
     * @return <code> null </code> si on n'a rien trouvé, la chaine de caractère contenue dans le fichier de configuration sinon.
     */
    public static String rechercher(String key){
	ConfigFile cf = new ConfigFile(new File(DEFAULT_FILE));
	return cf.search(key);
    }

    /** Une méthode de tests */
    public static void main(String[] args){
	System.out.println(rechercher(args[0]));
    }
    
    


}
