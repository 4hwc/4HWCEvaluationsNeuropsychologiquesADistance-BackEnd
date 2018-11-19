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

package t2s.traitement;

import t2s.util.*;

/** Pour traiter un texte et le transformer en phrases
 */
public class Pretraitement {

    // constantes pour les nombres
    private static final int MILLIARD = 1000000000;
    private static final int MILLION = 1000000;
    private static final int MILLE = 1000;
    private static final int CENT = 100;
    private static final String[] nombre = {
	"", "un", "deux", "trois",
	"quatre", "cinq", "six", "sept", "huit", "neuf",
	"dix", "onze", "douze", "treize", "quatorze",
	"quinze", "seize", "dix_sept", "dix_huit",
	"dix_neuf"};
    private static final String[] dizaine = {
	"", "", "vingt", "trente", "quarante", "cinquante",
	"soixante", "", "quatre_vingt",
	""};

    private String texte; //texte a lire

    /** Constructeur par défaut de pré-traitement.
     * <p> <b>Remarque</b> : Si la chaine <code>txt</code> ne finit pas par un caractère de coupure (<i>ponctuation</i>), on rajoute un <code>'.'</code>
     * de chaine.</p>
     * @param txt la chaine de caractères à pré - traiter
     */
    public Pretraitement(String txt) {
	this.texte = txt;
	if(!texte.equals("") && !estCoupure(texte.charAt(texte.length()-1)))
	    texte+=".";
    }

    /** Pour prendre une nouvelle <code>Phrase</code> dans le texte présent dans <code>this</code>
     * <p><b>Remarque</b> : Par effet de bord, on avance (sans espoir de retour) dans le texte pré-traité.</p>
     * @return une instance de <code>Phrase</code> contenant les informations lue dans le texte.
     * @throws PlusDePhraseException
     */
    public Phrase nouvellePhrase() throws PlusDePhraseException {

	if (texte.equals(""))
	    throw new PlusDePhraseException();

	Phrase p = traiter();

	if (p == null)
	    throw new PlusDePhraseException();
	return p;
    }
    

    /**
     * Méthodes privées ... (ménage effectué dans les scopes ^_^)
     */

    /** Pour pré-traiter le texte présent dans this.
     * <p><b>Pré-traitement</b> : il faut rajouter le traitement des symboles bizarres...
     * <p><ul>
     *   <li> on enleve les majuscules </li>
     *   <li> on transforme les nombres</li>
     *   <li> On transforme les <code>' '</code> en <code>'_'</code>.
     * </ul></p>
     *  @return   Une instance de <code>Phrase</code> relative au texte pré-traité (texte + type de prosodie a appliquer), 
     *            ou <code>null</code> si on ne peut rien faire.
     */
    private Phrase traiter() {
	int i = 0;
	String res = "";
	char tete = texte.charAt(i);
	while (i < texte.length() && !estCoupure(tete)) {

	    if (Character.isUpperCase(tete)) { //on traite les majuscules
		Indice in = new Indice(i);
		String a = abbrev(texte,in);
		if (a.length()>0) {
		    // abbréviation, a contient le nombre de caractères
		    res+= a;
		    i = in.val();
		} 
		else {
		    res += Character.toLowerCase(tete);
		    i++;
		}
	    }
	    else if ((tete == ' ') || (tete == '\n')) { // espace --> '_'
		if (!res.equals("") && res.charAt(res.length() - 1) != '_')
		    res += '_';
		i++;
	    }
	    else if (tete == '-') {
		res += '_';
		i++;
	    }
	    else if (estSpecial(tete)) { // caractère spécial
		res += special(tete);
		i++;
	    }
	    else if (estChiffre(tete)) { // les chiffres
		Indice ind = new Indice(i);
		res += traiterLesChiffres(texte,ind);
		i = ind.val();
		if (i < texte.length()) 
		    tete = texte.charAt(i);
	    }
	    else if (estLettre(tete)) { // on copie la lettre 
		res += tete;
		i++;
	    }
	    else { // on est sur un caractère non traité
		res += '_';
		System.out.println("SI_VOX WARNING [Pretraitement.traiter] : le caractère '" + tete + "' à été ignoré !");
		i++;
	    }
	    if (i < texte.length())
		tete = texte.charAt(i);
	}
	//on arrive ici pour chaque caractère de coupure ou quand on est a la fin du texte
	if (estCoupure(tete)) {
	    while(i < texte.length() && estCoupure(texte.charAt(i)))
		i++;

	    if (!res.equals("")) {
		if (res.charAt(0) != '_')
		    res = "_" + res;
		if (res.charAt(res.length() - 1) != '_')
		    res += "_"; 
		if (i < texte.length())
		    texte = texte.substring(i);
		else
		    texte = "";
		return new Phrase(res, prosodie(tete));
	    }
	    if (i < texte.length())
		texte = texte.substring(i);
	    else
		texte = "";
	    return new Phrase("_", prosodie(tete));
	}
	return null;
    }

    /** Lit une suite de chiffres éventuellement séparés par une virgule
     * Précondition :
     *        texte[i.val()] est un chiffre
     * Postcondition : 
     *        texte[i.val()] n'est pas un chiffre 
     */
    private String traiterLesChiffres(String texte,  Indice ind) {
	int lg = texte.length();
	// on traite la partie entière
	String nbr = lireNombre(texte,ind);
	String res = traiterNombre(nbr, false);
	String ordinal = ordinal(texte, ind);
	if (ordinal.length() > 0) 
	    if (ordinal.charAt(1) == 'p') 
		res = ordinal; // premier et première
	    else res += ordinal;
	else {
	    if (ind.val() < lg) {
		char tete = texte.charAt(ind.val());
		// on regarde s'il y a une virgule
		if (estVirgule(tete)|| estHeure(tete)) {
		    int iSuiv = ind.val() + 1;
		    if (iSuiv < lg && estChiffre(texte.charAt(iSuiv))) {
			res += estVirgule(tete) ? "_virgule_" : "_heure_";
			ind.inc();
			nbr = lireNombre(texte,ind);
			res += traiterNombre(nbr, true);
		    }
		}
	    }
	}
	return res;
    }

    /** Lit tous les caractères du nombre jusqu'à la virgule ou un autre caractère
     * Précondition :
     *        texte[i.val()] est un chiffre
     * Postcondition : 
     *        texte[i.val()] n'est pas un chiffre
     */
    private String lireNombre(String texte,  Indice i) {
	String nbr = "";
	int lg = texte.length();
	char tete = texte.charAt(i.val());
	while (i.val() < lg && estChiffre(tete)) {
	    nbr += tete;
	    i.inc();
	    if (i.val() < lg) tete = texte.charAt(i.val());
        }
	return nbr;
    }


    /**Pour traiter un nombre.
     * <p><center><code>12 |--> douze</code></center></p>
     * <p><b>Remarque</b>: On ne gère pas le féminin (et puis quoi encore ??) </p>
     * @param nbr une chaine de caractère représentant un nombre
     * @param decimal un booléen pour savoir si l'on doit prononcer les '0'.
     * @return une chaine de caractère contenant le nombre sous sa forme textuelle.
     */
    private String traiterNombre(String nbr, boolean decimal) {
	String res = "";
	if (decimal) {
	    //on doit dire les zeros
	    while (nbr.charAt(0) == '0') {
		res += "zéro_";
		nbr = nbr.substring(1);
	    }
	}
	try {
	    int nombre = (new Integer(nbr)).intValue();
	    if (nombre == 0)
		return "zéro";
	    int milliard = nombre / MILLIARD;
	    nombre = nombre % MILLIARD;
	    int million = nombre / MILLION;
	    nombre = nombre % MILLION;
	    int mille = nombre / MILLE;
	    nombre = nombre % MILLE; //le reste

	    if (milliard != 0)
		res += traiterNombre(milliard) + "_milliard_";
	    if (million != 0)
		res += traiterNombre(million) + "_million_";
	    if (mille != 0) {
		if (mille != 1)
		    res += traiterNombre(mille) + "_mille_";
		else
		    res += "_mille_";
	    }
	    res += traiterNombre(nombre);

	    return res;
	}
	catch (Exception e) {
	    System.out.println("SI_VOX WARNING [Pretraitement.traiterNombre] : Erreur !");
	    System.out.println(e);
	}

	return res += pasTraiterNombre(nbr);
    }

    /** Pour ne pas traiter un nombre
     * @param nbr la chaine de caractère représentant le nombre à ne pas traiter
     */

    private String pasTraiterNombre(String nbr){
	String res="";
	int i=0;
	int n;
	while(i<nbr.length()){
	    n=(new Integer(""+nbr.charAt(i))).intValue();
	    res+=nombre[n]+"_";
	    i++;
	}
	return res;
    }
    

    /** Pour transformer un nombre en chaine de caractère.
     * @param n l'entier que l'on veut transformer
     * @return la chaine de caractère qui va bien.
     */
    private String traiterNombre(int n) {
	String res = "";
	int cent = n / CENT;
	if (cent != 0) {
	    if (cent != 1)
		res += nombre[cent] + "_cent_";
	    else
		res += "_cent_";
	}
	n = n % CENT; //le reste entre 0 et 99
	if (n >= 0 && n <= 19)
	    res += nombre[n];
	else { //entre 20 et 99
	    if ( (n >= 70 && n <= 79) || (n >= 90 && n <= 99)) {
		res += dizaine[n / 10 - 1];
		res += "_";
		res += nombre[n % 10 + 10];
	    }
	    else {
		res += dizaine[n / 10];
		if (n % 10 != 0)
		    res += "_";
		res += nombre[n % 10];
	    }
	}
	return res;
    }

    /** Pour traiter le cas des ordinaux 
     * Précondition :
     *       i est le 1er caractère de s qui n'est pas un chiffre
     * Remarque : 
     *       On effectue les tests sur une chaine en UTF-8 [ Transposition ISO-8859-1 --> UTF-8 ].
     * @param s la chaine à transformer
     * @param i un Indice
     * @return renvoi le texte '_premier', '_iaime', '_premiaire' ou la chaine vide
     */
    private String ordinal(String s, Indice i) {
	String fin = encode(s.substring(i.val()),ConfigFile.rechercher("ENCODAGE_FICHIER"),"UTF-8");
	if (fin.length() >= 2) {
	    if (fin.substring(0,2).equals("er")){
		i.inc(2);
		return "_premier";
	    }
	    if (fin.substring(0,3).equals("ème")){
		i.inc(3);
		return "_iaime";
	    }
	    if (fin.substring(0,3).equals("ère")){
		i.inc(3);
		return "_premiaire";
	    }
	}
	return "";
    }
	
    /** Pour determiner si un caractère est la chaine vide
     * @param c le caractère à tester.
     * @return true si c est un c est un caractère de coupure {, . ; : ! ? parenthèses}
     */
    private boolean estCoupure(char c) {
	return c == ',' || c == '.' || c == ';' || c == ':' || c == '!' || c == '?' 
	    || estParenthese(c);
    }

    /** Pour determiner si un caractère est un caractère spécial
     * @param c le caractère à tester
     * @return true si c est un caractère spécial {% " @ © monnaie}
     */
    private boolean estSpecial(char c) {
	return c == '%' || c == '&' ||  c == '"' || c == '@'|| c == '©'
	    || estMonnaie(c) ;
    }

    /** Pour déterminer si un caractère est une parenthèse 
     * @param c le caractère à tester
     * @return true si c est un caractère de parenthésage, ie (, ), {, }, [, ] ou "
     */
    private boolean estParenthese(char c) {
	return c == '(' || c == ')' ||  c == '{' ||  c == '}' 
	    ||  c == '[' ||  c == ']' || c == '"';
    }

    /** Pour déterminer si un caractère est une virgule
     * @param c le charactère à tester
     * @return true si c est un caractère de 'virgule' {, .}
     */
    private boolean estVirgule(char c) {
	return c == ',' || c == '.';
    }

    /** Pour determiner si on est sur le tag de représentation usuel des heures ('h')
     * @param c le caractère à tester
     * @return true si <code>c == 'h'</code>, false sinon.
     */
    private boolean estHeure(char c) {
	return c == 'h' ;
    }

    /** Pour transformer un caractère spécial en chaine de caractère
     * @param c le caractère à transformer
     * @return la chaine de caractère qui va bien ^_^
     */
    private String special(char c){
	if (estMonnaie(c)) return monnaie(c);
	switch(c){
	case '&': return "_et_";
	case '%': return "_pour_cent_";
	case '@': return "_arobase_"; 
	case '©': return "_copirailt_";
	}
	return "";
    }
  
    /** Pour determiner si un caractère est un tag de monnaie
     * @param c le caractère à tester
     * @return true si c est un caractère de monnaie {$, £ ou \200} (\200 == euros)
     */
    private boolean estMonnaie(char c) {
	return c == '$' || c == '€' || c == '£';
    }

    /** Pour prononcer un carcatère de monnaie
     * @param c le caractère à prononcer
     * @return la chaine de caractère correspondant au symbole de la monnaie.
     */
    private String monnaie(char c){
	switch(c){
	case '$':return "_dollar_";
	case '£':return "_livre_sterling_";
	default:  return "";
	}
    }

    /** Pour determiner si un caractère est une lettre
     * @param c le caractère à tester
     * @return true si c est une lettre au sens de <code>Character.isLetter(char)</code> ou si c == '
     */
    private boolean estLettre(char c) {
	return (Character.isLetter(c) || c == '\'');
    }

    /** Renvoie une chaine contenant la traduction des abréviations qui commencent sur texte[i]
     * renvoie "" si pas d'abréviation
     * Précondition :  : texte[i] est une majuscule
     */
    private String abbrev(String texte, Indice i) {
	int l = texte.length();
	String res = "";
	String s = "";
	int ii = i.val();
	// on a au moins 3 caractères
	if (l-ii>=2) {
	    s = texte.substring(ii,ii+2);
	    if (s.equals("M.")) {res = "_monsieur_";i.inc(2);}
	}
	if (l-ii>=4) {
	    s = texte.substring(ii,ii+4);
	    if (s.equals("Mme.")) {res = "_madame_";i.inc(4);}
	}
	if (l-i.val()>=5) {
	    s = texte.substring(ii,ii+5);
	    if (s.equals("Mlle.")) {res = "_mademoiselle_";i.inc(5);}
	}
	return res;
    }


 
    /** Pour récuperer la prosodie à appliquer à cette phrase
     * @param c un caractère de ponctuation
     * @return l'entier correspondant, a la prosodie liée au caractère de coupure.
     */
    private int prosodie(char c) {
	if (estParenthese(c)) 
	    return Phrase.VIRGULE; 
	else 
	    switch (c) {
	    case ',':
		return Phrase.VIRGULE;
	    case ';':
		return Phrase.VIRGULE;
	    case '.':
		return Phrase.POINT;
	    case '!':
		return Phrase.EXCLAMATION;
	    case '?':
		return Phrase.INTERROGATION;
	    default:
		return Phrase.DEFAUT;
	    }
    }

    /** Pour savoir si un caractère est un chiffre
     * @param c le caractère à tester
     * @returntrue si c est un chiffre, false sinon
     */
    private boolean estChiffre(char c) {
	return c >= 48 && c <= 57;
    }

    /** Transcodage d'une chaine de caractère d'un charset vers un autre
     * @param s la chaine de caractère a transcoder
     * @param cs1 le charset initial
     * @param cs2 le charset voulu
     * @return une chaine de caractère contenant <code>s<code> transcodée selon <code>cs2</code>
     */
    private static String encode(String s, String cs1, String cs2) {
	String res = "";
	try {
	    byte[] b = s.getBytes(cs1);
	    res = new String(b,cs2);
	}
	catch (Exception e) { 
	    System.out.println("SI_VOX WARNING [Pretraitement.encode] : Erreur d'encodage pour la chaine \n" + s);
	}
	return res;
    }

}
