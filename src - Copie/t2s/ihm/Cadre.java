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

import java.util.Vector;
import java.util.EventListener;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

import t2s.son.*;
import t2s.util.*;
import t2s.traitement.*;

/** Interface graphique de SI VOX.
 */

public class Cadre extends JFrame {

    /**
     * classe interne qui permet de lancer un lecteur de texte dans une thread
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


    // le lecteur de texet qui contient les règles de transformation mots -> phonèmes
    static private LecteurTexte lt;

    // Le thread qui permet de lire le texte à voix haute 
    static private ParleThread parle ;


    // les composants graphiques
    JPanel contentPane;
    // les menus
    // fichiers
    JMenuBar jMenuBar1 = new JMenuBar();
    JMenu jMenuFile = new JMenu();
    JMenuItem jMenuFileExit = new JMenuItem();
    JMenuItem jMenuFileOpen = new JMenuItem();
    JMenuItem jMenuFileSave = new JMenuItem();
    // help
    JMenu jMenuHelp = new JMenu();
    JMenuItem jMenuHelpAbout = new JMenuItem();
    // les voix
    JMenu jMenuVoix = new JMenu();
    JMenuItem jMenuVoix1 = new JMenuItem();
    JMenuItem jMenuVoix2 = new JMenuItem();
    JMenuItem jMenuVoix3 = new JMenuItem();
    // le boutons
    JToolBar jToolBar = new JToolBar();
    JButton play = new JButton();
    JButton stop = new JButton();
    JButton clear = new JButton();
    JButton reload = new JButton();
    ImageIcon image1, image2, image3, image4;

    BorderLayout borderLayout1 = new BorderLayout();
    JFileChooser openChooser = new JFileChooser("~/");
    JFileChooser saveChooser = new JFileChooser("~/");
    JPanel jPanel1 = new JPanel();
    GridLayout gridLayout1 = new GridLayout();
    JScrollPane jScrollPane1 = new JScrollPane();
    JScrollPane jScrollPane2 = new JScrollPane();

    // les champs de texte de départ et d'affichage des phonèmes
    static JTextArea text = new JTextArea();
    static JTextArea phonemes = new JTextArea();


    /**
     * <p>Construit le Cadre.</p>
     */
    public Cadre() {
	enableEvents(AWTEvent.WINDOW_EVENT_MASK);
	try {
	    jbInit();
	    lt = new LecteurTexte();
	    parle = new ParleThread(lt);
	}
	catch (Exception e) {
	    e.printStackTrace();
	}
    }

    /**
     * <p>Initialise le Cadre.</p>
     * @throws java.lang.Exception
     */
    private void jbInit() throws Exception {
	menuInit();
	buttonInit();
	textInit();
    }

  
    /**
     * <p>Initialise les panels et menus.</p>
     * @throws java.lang.Exception
     */
    private void menuInit() throws Exception {

	// le cadre
	contentPane = (JPanel)this.getContentPane();
	contentPane.setLayout(borderLayout1);
	this.setSize(new Dimension(800, 600));
	this.setResizable(false);
	this.setTitle("S.I. VOX Version 1.0");

	// les menus
	jMenuFile.setText("Fichier");
	jMenuFileExit.setText("Quitter");
	jMenuFileOpen.setText("Ouvrir");
	jMenuFileSave.setText("Enregistrer");
	jMenuFileExit.addActionListener(new Cadre_jMenuFileExit_ActionAdapter(this));
	jMenuFileOpen.addActionListener(new Cadre_jMenuFileOpen_ActionAdapter(this));
	jMenuFileSave.addActionListener(new Cadre_jMenuFileSave_ActionAdapter(this));
	jMenuVoix.setText("Voix");
	jMenuVoix1.setText("FR1 : homme");
	jMenuVoix2.setText("FR2 : femme");
	jMenuVoix3.setText("FR5 : Fabrice");
	jMenuVoix1.addActionListener(new Cadre_jMenuVoix1_ActionAdapter(this));
	jMenuVoix2.addActionListener(new Cadre_jMenuVoix2_ActionAdapter(this));
	jMenuVoix3.addActionListener(new Cadre_jMenuVoix3_ActionAdapter(this));
	jMenuHelp.setText("Aide");
	jMenuHelpAbout.setText("A propos");
	jMenuHelpAbout.addActionListener(new Cadre_jMenuHelpAbout_ActionAdapter(this));

	jMenuFile.add(jMenuFileOpen);
	jMenuFile.add(jMenuFileSave);
	jMenuFile.add(jMenuFileExit);
	jMenuVoix.add(jMenuVoix1);
	//jMenuVoix.add(jMenuVoix2);
	//jMenuVoix.add(jMenuVoix3);
	jMenuHelp.add(jMenuHelpAbout);
	jMenuBar1.add(jMenuFile);
	jMenuBar1.add(jMenuVoix);
	jMenuBar1.add(jMenuHelp);
	setJMenuBar(jMenuBar1);
    }

    /**
     * <p>Initialise les boutons.</p>
     * @throws java.lang.Exception
     */
    private void buttonInit() throws Exception {

	// bouton play
	image1 = new ImageIcon(ConfigFile.rechercher("IMG_PATH")+"play.png");
	play.setActionCommand("play");
	play.setIcon(image1);
	play.addActionListener(new Cadre_play_ActionAdapter(this));
	jToolBar.add(play, null);

	// bouton stop
	image2 = new ImageIcon(ConfigFile.rechercher("IMG_PATH") + "stop.png");
	stop.setIcon(image2);
	stop.addActionListener(new Cadre_stop_ActionAdapter(this));
	stop.setActionCommand("stop");
	jToolBar.add(stop, null);

	// bouton clear
	image3 = new ImageIcon(ConfigFile.rechercher("IMG_PATH") + "disc.png");
	clear.setIcon(image3);
	clear.addActionListener(new Cadre_clear_ActionAdapter(this));
	clear.setActionCommand("reload");
	jToolBar.add(clear, null);

	// bouton reload
	image4 = new ImageIcon(ConfigFile.rechercher("IMG_PATH") + "reload.png");
	reload.setIcon(image4);
	reload.addActionListener(new Cadre_reload_ActionAdapter(this));
	reload.setActionCommand("reload");
	jToolBar.add(reload, null);
    }


    /**
     * <p>Initialise les champs de texte et les panels qui les contiennent</p>
     * @throws java.lang.Exception
     */
    private void textInit() throws Exception {
	// le panel
	jPanel1.setLayout(gridLayout1);
	gridLayout1.setColumns(2);
	gridLayout1.setHgap(2);
	gridLayout1.setRows(1);
	gridLayout1.setVgap(0);
	borderLayout1.setHgap(0);
	borderLayout1.setVgap(0);

	jPanel1.setBackground(Color.black);
	jPanel1.setForeground(Color.black);
	contentPane.add(jPanel1, BorderLayout.CENTER);
    
	// le texte à lire
	text.setText("");
	text.setLineWrap(true);
	jPanel1.add(jScrollPane2, null);
	jScrollPane2.getViewport().add(text, null);

	// les phonèmes correspondants
	phonemes.setText("");
	phonemes.setLineWrap(true);
	jPanel1.add(jScrollPane1, null);
	jScrollPane1.getViewport().add(phonemes, null);

	// fin des initialisations

	jToolBar.setForeground(Color.black);
	contentPane.add(jToolBar, BorderLayout.NORTH);

	text.add(new JScrollBar(JScrollBar.VERTICAL));
    }

    /**
     * @return le texte tapé par l'utilisateur.
     */
    public static String getTexte() {
	return text.getText(); 
    }

    /**
     * @return le texte des phonèmes affichés.
     */
    public static String getPhoTexte() {
	return phonemes.getText();
    }

    // actions associées aux boutons

    /** Opération Fichier | Quitter effectuée
     */
    public void jMenuFileExit_actionPerformed(ActionEvent e) {
	System.exit(0);
    }

    /**Opération Aide | A propos effectuée
     */
    public void jMenuHelpAbout_actionPerformed(ActionEvent e) {
	Cadre_AboutBox dlg = new Cadre_AboutBox(this);
	Dimension dlgSize = dlg.getPreferredSize();
	Dimension frmSize = getSize();
	Point loc = getLocation();
	dlg.setLocation( (frmSize.width - dlgSize.width) / 2 + loc.x,
			 (frmSize.height - dlgSize.height) / 2 + loc.y);
	dlg.setModal(true);
	dlg.pack();
	dlg.show();
    }


    /** sortir quand la fenêtre est fermée
     * méthode redéfinie
     */
    protected void processWindowEvent(WindowEvent e) {
	super.processWindowEvent(e);
	if (e.getID() == WindowEvent.WINDOW_CLOSING) {
	    jMenuFileExit_actionPerformed(null);
	}
    }


    /** ouvrir un fichier de texte
     */
    public void jMenuFileOpen_actionPerformed(ActionEvent e) {
	int returnVal = openChooser.showOpenDialog(this);
	if (returnVal == JFileChooser.APPROVE_OPTION) {
	    try {
		loadFile(openChooser.getSelectedFile().getAbsolutePath());
	    }
	    catch (Exception eio) {
		eio.printStackTrace();
	    }
	}
    }

    /**
     * <p>Lit un fichier texte et l'affiche dans le JTexteArea text.</p>
     * @param filename String
     * @throws java.lang.Exception
     */
    private void loadFile(String filename) throws Exception {
	text.setText((new LecteurFichier(filename)).toutLire());
    }


    /** sauver le fichier de phonèmes
     */
    public void jMenuFileSave_actionPerformed(ActionEvent e) {
	int returnVal = saveChooser.showSaveDialog(this);
	if (returnVal == JFileChooser.APPROVE_OPTION) {
	    try {
		saveFile(saveChooser.getSelectedFile().getPath(), getPhoTexte());
	    }
	    catch (Exception ea) {
		System.out.println(ea);
	    }
	}
    }

    /**
     * <p>écrit les phonémes dans un fichier de texte.</p>
     * @param filename String
     * @throws java.lang.Exception
     */
    public void saveFile(String filename, String texte) throws Exception {
	FileWriter fr = new FileWriter(filename);
	try {
	    fr.write(texte);
	}
	catch (Exception e) {
	    System.out.println("erreur sauvegarde");
	}
	fr.close();
    }

    // menu de voix
    /** voix 1 */
    public void jMenuVoix1_actionPerformed(ActionEvent e) {
	lt.setVoix(1);
    }
  
    /** voix 2 */
    public void jMenuVoix2_actionPerformed(ActionEvent e) {
	lt.setVoix(2);
    }

    /** voix 3 */
    public void jMenuVoix3_actionPerformed(ActionEvent e) {
	lt.setVoix(3);
    }
    /**
     * <p>Pour lire à voix haute le texte que l'utilisateur a tapé. </p>
     */
    public  void play() {
	lt.setTexte(getTexte());
	parle = new ParleThread(lt);
	parle.start();
    }

    /** pour réagir à la fermeture et au bouton stop
     * arrete le lecteur de texte
     */
    public void stop () {
        parle.stopIt();
    }

    /** pour réinitialiser les fenetres
     */
    public void clear () {
        text.setText(" ");
	phonemes.setText(" ");
    }

    /** pour recharger la base de règles
     * arrete le lecteur de texte
     */
    public void reload() {
	try {
	    lt.reloadArbre();
	} catch (AnalyseException e) {
	    System.out.println(e);
	}
    }

}

// classes internes
// menu File
class Cadre_jMenuFileExit_ActionAdapter
    implements ActionListener {
    Cadre adaptee;

    Cadre_jMenuFileExit_ActionAdapter(Cadre adaptee) {
	this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
	adaptee.jMenuFileExit_actionPerformed(e);
    }
}

class Cadre_jMenuFileOpen_ActionAdapter
    implements ActionListener {
    Cadre adaptee;

    Cadre_jMenuFileOpen_ActionAdapter(Cadre adaptee) {
	this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
	adaptee.jMenuFileOpen_actionPerformed(e);
    }
}

class Cadre_jMenuFileSave_ActionAdapter
    implements ActionListener {
    Cadre adaptee;

    Cadre_jMenuFileSave_ActionAdapter(Cadre adaptee) {
	this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
	adaptee.jMenuFileSave_actionPerformed(e);
    }
}

// menu voix
class Cadre_jMenuVoix1_ActionAdapter implements ActionListener {
    Cadre adaptee;

    Cadre_jMenuVoix1_ActionAdapter(Cadre adaptee) {
	this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
	adaptee.jMenuVoix1_actionPerformed(e);
    }
}

class Cadre_jMenuVoix2_ActionAdapter   implements ActionListener {
    Cadre adaptee;

    Cadre_jMenuVoix2_ActionAdapter(Cadre adaptee) {
	this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
	adaptee.jMenuVoix2_actionPerformed(e);
    }
}

class Cadre_jMenuVoix3_ActionAdapter  implements ActionListener {
    Cadre adaptee;

    Cadre_jMenuVoix3_ActionAdapter(Cadre adaptee) {
	this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
	adaptee.jMenuVoix3_actionPerformed(e);
    }
}

class Cadre_jMenuHelpAbout_ActionAdapter
    implements ActionListener {
    Cadre adaptee;

    Cadre_jMenuHelpAbout_ActionAdapter(Cadre adaptee) {
	this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
	adaptee.jMenuHelpAbout_actionPerformed(e);
    }
}

class Cadre_play_ActionAdapter
    implements ActionListener {
    Cadre adaptee;

    Cadre_play_ActionAdapter(Cadre adaptee) {
	this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
	adaptee.play();
    }
}

class Cadre_stop_ActionAdapter 
    implements ActionListener {
    Cadre adaptee;

    Cadre_stop_ActionAdapter(Cadre adaptee) {
	this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
	adaptee.stop();
    }
}

class Cadre_clear_ActionAdapter 
    implements ActionListener {
    Cadre adaptee;

    Cadre_clear_ActionAdapter(Cadre adaptee) {
	this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
	adaptee.clear();
    }
}

class Cadre_reload_ActionAdapter 
    implements ActionListener {
    Cadre adaptee;

    Cadre_reload_ActionAdapter(Cadre adaptee) {
	this.adaptee = adaptee;
    }

    public void actionPerformed(ActionEvent e) {
	adaptee.reload();
    }
}



