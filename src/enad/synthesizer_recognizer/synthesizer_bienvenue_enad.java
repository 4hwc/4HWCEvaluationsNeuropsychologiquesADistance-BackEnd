/**
 * 
 */
package enad.synthesizer_recognizer;

import t2s.son.LecteurTexte;

/**
 * @author Admin
 *
 */
public class synthesizer_bienvenue_enad {

	public void parle() {
		// TODO Auto-generated method stub

		LecteurTexte lecteur = new LecteurTexte(
				"Bienvenue, je m'appelle E N A D : Évaluations Neuropsychologiques A Distance. J'aimerai savoir si vous êtes un patient ou un médecin pour mieux vous servir. Si vous n'êtes ni un médecin ou un patient, veuillez consulter les rubriques informations du site pour en savoir plus à mon sujet. Merci pour votre compréhension.");
		lecteur.playAll();

		// lecteur.setTexte("je suis un synthétiseur vocal, qui êtes vous ?");
		// lecteur.playAll();

	}

}
