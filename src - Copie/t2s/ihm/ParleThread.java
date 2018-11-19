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

import t2s.son.LecteurTexte;
import t2s.traitement.Arbre;


/**
 * classe qui permet de lancer un lecteur de texte dans une thread
 */

public class ParleThread extends Thread {
    private LecteurTexte lt;  // le lecteur de texte
    private boolean stop;  // pour savoir si le thread est  actif

    public ParleThread(){
	stop = false;
    }

    public ParleThread(LecteurTexte lt){
	stop = false;
	this.lt = lt;
    }

    public void stopIt(){
	stop = true;
    }

    public boolean estInterrompue() {
	return stop == true;
    }

    public void run()  {
	stop = false;
	String pho = "";
	while (!stop & !lt.vide()) {
	    // lit une phrase et renvoie sa représentation en phonèmes
	    pho += lt.play(); 
	}
	Cadre.phonemes.setText(pho);
	Cadre.phonemes.repaint();
    }
}
