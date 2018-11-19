package enad.trainings;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;

public class rty {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Time debut = new Time(0, 0, 0);

		String motInitial = "All All All All";

		int minDebut_int = Integer.parseInt("-1");

		Calendar cal = Calendar.getInstance();

		// Calendar calendar = new GregorianCalendar(2013,0,31);

		String test = new String();

		test = "00.0014";

		if (test.matches("^[0-9]+[.,][0-9]+$") || test.matches("^[0-9]+$")) {

			System.out.println("YES");

			System.out.println(Double.parseDouble(test));

		} else {
			System.out.println("NO");
		}

		System.out.println("mois ");

		System.out.println(cal.get(Calendar.YEAR));

	}

	/*
	 * Fonction retournant une liste de mots (sans espaces) issus d'un mot
	 * initial contenant des espaces ou non
	 */

	public static void MotAMot(String recherche) {

		ArrayList<String> DecoupeMot = new ArrayList<String>();

		String mot = null;

		String recherche_trim = recherche.trim();

		int occurences;

		for (int i = 0; i < recherche_trim.length(); i++) {

			if (recherche_trim.charAt(i) != ' ') {

				mot = mot + recherche_trim.charAt(i);

				if (i == recherche_trim.length() - 1) {

					DecoupeMot.add(mot);

				}

			} else {

				if (recherche_trim.charAt(i - 1) != ' ') {

					DecoupeMot.add(mot);

					mot = null;
				}

			}

		}

		// ***************eliminer doublons
		for (int a = 0; a < DecoupeMot.size(); a++) {

			occurences = 0;

			for (int b = 0; b < DecoupeMot.size(); b++) {

				if (DecoupeMot.get(a).equals(DecoupeMot.get(b))) {

					occurences++;
					if (occurences > 1) {

						DecoupeMot.remove(b);

					}

				}

			}

		}

		// ***************

		System.out.println(DecoupeMot.size() + " mot(s) trouvé(s) :");

		for (int j = 0; j < DecoupeMot.size(); j++) {

			System.out.println(DecoupeMot.get(j).substring(4)); // substring 4
																// pour enlever
																// le null
		}

	}

}
