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
public class Mbrola {

	// private static String path = System.getenv("MBOLA_HOME");
	// System.out.println(path);

	public Mbrola() {
		System.setProperty("freetts.voices", "de.dfki.lt.freetts.en.us.MbrolaVoiceDirectory");
		listAllVoices();

		/*
		 * System.setProperty("mbrola.base",
		 * "C.Users.Admin.OneDrive.Documents.Formation personnelle.BIBLIOTHEQUE PERSONNELLE.APPLICATIONS.freetts.freetts-1.2.mbrola.mbrola.base"
		 * ); listAllVoices();
		 */
	}

	/**
	 * Comment afficher toutes les voix
	 */

	public static void listAllVoices() {
		System.out.println("All voices available: ");

		VoiceManager voiceManager = VoiceManager.getInstance();

		Voice[] voices = voiceManager.getVoices();

		for (int i = 0; i < voices.length; i++) {
			System.out.println(" " + voices[i].getName() + " (" + voices[i].getDomain() + " domain)");
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		listAllVoices();

	}

}
