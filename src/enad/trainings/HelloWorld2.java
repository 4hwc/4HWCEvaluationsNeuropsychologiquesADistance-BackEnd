/**
 * 
 */
package enad.trainings;

import java.util.Locale;

import javax.speech.Central;
import javax.speech.synthesis.Synthesizer;
import javax.speech.synthesis.SynthesizerModeDesc;
import javax.speech.synthesis.Voice;

/**
 * @author Admin
 *
 */
public class HelloWorld2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {

			System.setProperty("freetts.voices", "de.dfki.It.freetts.mbrola.MbrolaVoiceDirectory");

			Central.registerEngineCentral("com.sun.speech.freetts.jsapi.FreeTTSEngineCentral");
			// récupérer le synthétiseur français
			Synthesizer synth = Central.createSynthesizer(new SynthesizerModeDesc(Locale.FRENCH));

			// Prépare le synthétiseur prêt à parler
			synth.allocate();
			synth.resume();

			SynthesizerModeDesc smd = (SynthesizerModeDesc) synth.getEngineModeDesc();

			Voice[] voices = smd.getVoices();
			Voice voice = null;

			for (int i = 0; i < voices.length; i++) {
				if (voices[i].getName().equals("kevin")) {
					voice = voices[i];
					break;
				}
			}

			synth.getSynthesizerProperties().setVoice(voice);

			// Prononce une phrase
			String phraseAPrononcer = "J'aime Sonni";

			for (int i = 0; i < args.length; i++)
				phraseAPrononcer += args[i] + " ";
			synth.speakPlainText(phraseAPrononcer, null);

			// Attend jusqu'à la fin de la lecture
			synth.waitEngineState(Synthesizer.QUEUE_EMPTY);

			// Désaloue le synthétiseur
			synth.deallocate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
