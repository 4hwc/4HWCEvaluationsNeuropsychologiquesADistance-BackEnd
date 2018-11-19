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
public class Test {

	private static final String VOICENAME = "kevin16";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Voice voice;
		VoiceManager voiceManager = VoiceManager.getInstance();

		voice = voiceManager.getVoice(VOICENAME);
		voice.allocate();
		voice.speak("test");

	}

}
