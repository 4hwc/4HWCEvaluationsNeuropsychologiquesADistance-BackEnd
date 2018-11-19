/**
 * 
 */
package enad.trainings;

/**
 * @author Admin
 *
 */
public class Chronometre {

	static long chrono = 0;

	// Lancement du chrono
	static void Go_Chrono() {
		chrono = java.lang.System.currentTimeMillis();
	}

	// Arrêt du chrono
	static void Stop_Chrono() {
		long chrono2 = java.lang.System.currentTimeMillis();

		System.out.println("chrono2 : " + chrono2);
		long temps = chrono2 - chrono;

		System.out.println("Temps ecoule = " + temps + " ms");
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Go_Chrono();
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				for (int k = 0; k < 100; k++) {

					for (int g = 0; g < 1000000; g++) {

					}

				}
			}
		}
		Stop_Chrono();

	}

}
