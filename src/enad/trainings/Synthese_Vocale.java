/**
 * 
 */
package enad.trainings;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

/**
 * @author Admin
 *
 */
public class Synthese_Vocale {

	/**
	 * Comment afficher toutes les voix
	 */

	public static void listedesvoix() {
		System.out.println("Toutes les voix disponibles : ");
		VoiceManager voiceManager = VoiceManager.getInstance();
		Voice[] voix = voiceManager.getVoices();
		for (int i = 0; i < voix.length; i++) {
			System.out.println(" " + voix[i].getName() + " (" + voix[i].getDomain() + " domain)");
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Méthode qui permet l'affichage de toutes les voix disponibles
		listedesvoix();

		String nomVoix = "kevin";
		System.out.println("\nVoix utilisée: " + nomVoix);

		// Le VoiceManager manage toutes les voix pour FreeTTS

		VoiceManager voiceManager = VoiceManager.getInstance();

		// Charger la voix

		Voice voix = voiceManager.getVoice(nomVoix);

		// Si le nom de voix n'existe pas alors erreur

		if (voix == null) {
			System.err.println("La voix " + nomVoix + ". n'est pas reconnue svp essayez un autre nom.");

			System.exit(1);
		}

		// Charger les ressources dont la voix utilise
		voix.allocate();

		// Synthétiser le discours
		voix.speak("Hello World");
		voix.speak("How are you today ?");
		voix.speak("I am a programmer");

		// désalouer
		voix.deallocate();

		// programme terminé avec succès
		System.exit(0);

	}

}
