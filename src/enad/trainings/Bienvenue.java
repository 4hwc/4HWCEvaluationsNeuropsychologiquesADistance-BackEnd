/**
 * 
 */
package enad.trainings;

import java.util.Locale;

import javax.speech.Central;
import javax.speech.synthesis.Synthesizer;
import javax.speech.synthesis.SynthesizerModeDesc;

/**
 * @author Admin
 *
 */
public class Bienvenue {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String texteASynthetiser;
		texteASynthetiser = "Bonjour";
		texteASynthetiser += "<EMP LEVEL=\"strong\">" + "mon nom est" + "</EMP>";
		texteASynthetiser += "<EMP LEVEL=\"reduced\">" + "Ordinateur" + "</EMP>";

		try {
			Synthesizer synth = Central.createSynthesizer(new SynthesizerModeDesc(Locale.FRENCH));
			synth.allocate();
			synth.speak(texteASynthetiser, null);
			synth.speak("fin du message", null);
			synth.deallocate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
