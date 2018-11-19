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

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import t2s.prosodie.*;
import t2s.traitement.*;

/**
 * <p>Fenetre classique de l'apropos</p>
 */
public class Cadre_AboutBox extends JDialog implements ActionListener {

    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel insetsPanel1 = new JPanel();
    JButton button1 = new JButton();
    BorderLayout borderLayout1 = new BorderLayout();
    BorderLayout borderLayout2 = new BorderLayout();
    String product = "S.I. VOX";
    String version = "1.0";
    String copyright = "Copyright (c) 2004-2005";
    String comments = "";
    JPanel jPanel1 = new JPanel();
    JLabel jLabel1 = new JLabel();
    JPanel jPanel2 = new JPanel();
    JPanel jPanel3 = new JPanel();
    JLabel jLabel3 = new JLabel();
    BorderLayout borderLayout3 = new BorderLayout();
    JLabel label3 = new JLabel();
    JLabel jLabel2 = new JLabel();
    public Cadre_AboutBox(Frame parent) {
	super(parent);
	enableEvents(AWTEvent.WINDOW_EVENT_MASK);
	try {
	    jbInit();
	}
	catch(Exception e) {
	    e.printStackTrace();
	}
    }
    /**
     * <p>Initialise la JDialog.</p>
     * @throws java.lang.Exception
     */
    private void jbInit() throws Exception  {
	this.setTitle("A propos");
	panel1.setLayout(borderLayout1);
	panel2.setLayout(borderLayout2);
	button1.setText("Ok");
	button1.addActionListener(this);
	jLabel1.setText("Entrez votre texte à gauche, la traduction phonétique apparait à droite.");

	jLabel3.setFont(new java.awt.Font("SansSerif", 1, 24));
	jLabel3.setText("S.I. VOX");
	jLabel2.setText("                       ");
	panel2.add(jPanel1,  BorderLayout.CENTER);
	jPanel1.add(jLabel1, null);
	panel2.add(jPanel2,  BorderLayout.SOUTH);
	panel1.add(insetsPanel1, BorderLayout.SOUTH);
	insetsPanel1.add(jLabel2, null);
	insetsPanel1.add(button1,  BorderLayout.CENTER);
	panel1.add(panel2, BorderLayout.NORTH);
	this.getContentPane().add(panel1, BorderLayout.CENTER);
	panel2.add(jPanel3, BorderLayout.NORTH);
	jPanel3.add(jLabel3, null);
	insetsPanel1.add(label3,  BorderLayout.EAST);
	setResizable(true);
    }

    /**
     * <p> Redéfini, ainsi nous pouvons sortir quand la fenêtre est fermée.</p>
     * @param e
     */
    protected void processWindowEvent(WindowEvent e) {
	if (e.getID() == WindowEvent.WINDOW_CLOSING) {
	    cancel();
	}
	super.processWindowEvent(e);
    }

    /**
     * <p>Ferme la JDialog</p>
     */
    void cancel() {
	dispose();
    }

    /**
     * <p>Ferme la JDialog en clickant sur OK</p>
     */
    public void actionPerformed(ActionEvent e) {
	if (e.getSource() == button1) {
	    cancel();
	}
    }
}
