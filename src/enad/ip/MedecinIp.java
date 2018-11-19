/**
 * 
 */
package enad.ip;

import enad.dao.MedecinDao;

/**
 * @author Admin
 *
 */
public class MedecinIp {

	private MedecinDao medecinDao;

	public MedecinIp(MedecinDao medecinDao) {

		this.medecinDao = medecinDao;
	}

	public String genererIpMedecin() {

		/*
		 * Si ip utilisé alors capteur_ip_utilise = 1 sinon capteur_ip_utilise
		 * =0
		 */

		int capteur_ip_utilise = 1;

		String ip_final = new String();

		// Supposons capteur_ip_utilise=1

		while (capteur_ip_utilise == 1) {

			int a = (int) (Math.random() * 256); // 0<= a <= 255

			int b = (int) (Math.random() * 256); // 0<= b <= 255

			int c = 1 + (int) (Math.random() * 254); // 1<= c <= 254

			String ip = "127." + a + "." + b + "." + c;

			ip_final = ip;

			// Pour éviter de donner l'ip à au moins 2 utilisateurs connectés

			if (medecinDao.chercher(ip) == null) {

				capteur_ip_utilise = 0;

			}

		}

		return ip_final;

	}

}
