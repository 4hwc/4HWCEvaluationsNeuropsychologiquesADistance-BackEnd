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

package t2s.ihm;

import java.util.regex.Pattern;
import java.util.Vector;
import javax.swing.UIManager;
import java.awt.*;
import t2s.son.*;
import t2s.traitement.*;
import java.io.*;

/** Classe gérant les différents types de Lecture possibles.
 */
public class Lecture {

    /** Une lecture vide : lance l'IHM.
     */
    public Lecture() throws AnalyseException {
	lancerIHM();
    }

    /** Pour créer une instance de lecture
     * @param file le fichier à lire ('-' pour lire depuis <code>stdin</code>)
     */
    public Lecture( String file) throws AnalyseException{
	LecteurTexte lt = new LecteurTexte(file,true);
	if (file != null && !file.equals("-")) {
	    String pho = "";
	    while (!lt.vide()) {
		// lit une phrase et renvoie sa représentation en phonèmes
		pho += lt.play(); 
	    }
	}
    }


    /** méthode privée pour lancer l'IHM
     */
    private void lancerIHM() {
	Cadre frame;
	boolean packFrame = false;

	frame = new Cadre();
	//Valider les cadres ayant des tailles prédéfinies
	//Compacter les cadres ayant des infos de taille préférées 
	if (packFrame) {
	    frame.pack();
	}
	else {
	    frame.validate();
	}
	//Centrer la fenêtre
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	Dimension frameSize = frame.getSize();
	if (frameSize.height > screenSize.height) {
	    frameSize.height = screenSize.height;
	}
	if (frameSize.width > screenSize.width) {
	    frameSize.width = screenSize.width;
	}
	frame.setLocation( (screenSize.width - frameSize.width) / 2,
			   (screenSize.height - frameSize.height) / 2);
	frame.setVisible(true);
    }

    
    /** La méthode éxécutable qui fait ce qu'il faut ... */
    public static void main(String[] args){
	try {
	    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	}
	catch (Exception e) {
	    e.printStackTrace();
	}
	try {
	    if (args.length == 0) {
		// mode graphique
		Lecture l = new Lecture();
	    }
	    else {
		// lit le fichier passé en paramètre 
		Lecture l = new Lecture(args[0]);
		System.exit(0);
	    }
	}
	catch (AnalyseException e) {
	    System.out.println(e);
	}

    }
}  
