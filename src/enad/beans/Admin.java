/**
 * 
 */
package enad.beans;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;

import org.joda.time.DateTime;

/**
 * @author Admin
 *
 */
public class Admin implements Serializable {

	private Long id_admin;
	private String identifiant_admin;
	private String noms_admin;
	private String prenoms_admin;
	private String mdp_admin;
	private Timestamp date_heure_adhesion_medecin;
	private String photo_admin;

	private ArrayList<DateTime> dates_heures_connexion_admin = new ArrayList<DateTime>();

	private ArrayList<DateTime> dates_heures_deconnexion_admin = new ArrayList<DateTime>();

	/**
	 * @return the id_admin
	 */
	public Long getId_admin() {
		return id_admin;
	}

	/**
	 * @param id_admin
	 *            the id_admin to set
	 */
	public void setId_admin(Long id_admin) {
		this.id_admin = id_admin;
	}

	/**
	 * @return the identifiant_admin
	 */
	public String getIdentifiant_admin() {
		return identifiant_admin;
	}

	/**
	 * @param identifiant_admin
	 *            the identifiant_admin to set
	 */
	public void setIdentifiant_admin(String identifiant_admin) {
		this.identifiant_admin = identifiant_admin;
	}

	/**
	 * @return the noms_admin
	 */
	public String getNoms_admin() {
		return noms_admin;
	}

	/**
	 * @param noms_admin
	 *            the noms_admin to set
	 */
	public void setNoms_admin(String noms_admin) {
		this.noms_admin = noms_admin;
	}

	/**
	 * @return the prenoms_admin
	 */
	public String getPrenoms_admin() {
		return prenoms_admin;
	}

	/**
	 * @param prenoms_admin
	 *            the prenoms_admin to set
	 */
	public void setPrenoms_admin(String prenoms_admin) {
		this.prenoms_admin = prenoms_admin;
	}

	/**
	 * @return the mdp_admin
	 */
	public String getMdp_admin() {
		return mdp_admin;
	}

	/**
	 * @param mdp_admin
	 *            the mdp_admin to set
	 */
	public void setMdp_admin(String mdp_admin) {
		this.mdp_admin = mdp_admin;
	}

	/**
	 * @return the date_heure_adhesion_medecin
	 */
	public Timestamp getDate_heure_adhesion_medecin() {
		return date_heure_adhesion_medecin;
	}

	/**
	 * @param date_heure_adhesion_medecin
	 *            the date_heure_adhesion_medecin to set
	 */
	public void setDate_heure_adhesion_medecin(Timestamp date_heure_adhesion_medecin) {
		this.date_heure_adhesion_medecin = date_heure_adhesion_medecin;
	}

	/**
	 * @return the photo_admin
	 */
	public String getPhoto_admin() {
		return photo_admin;
	}

	/**
	 * @param photo_admin
	 *            the photo_admin to set
	 */
	public void setPhoto_admin(String photo_admin) {
		this.photo_admin = photo_admin;
	}

	/**
	 * @return the dates_heures_connexion_admin
	 */
	public ArrayList<DateTime> getDates_heures_connexion_admin() {
		return dates_heures_connexion_admin;
	}

	/**
	 * @param dates_heures_connexion_admin
	 *            the dates_heures_connexion_admin to set
	 */
	public void setDates_heures_connexion_admin(ArrayList<DateTime> dates_heures_connexion_admin) {
		this.dates_heures_connexion_admin = dates_heures_connexion_admin;
	}

	/**
	 * @return the dates_heures_deconnexion_admin
	 */
	public ArrayList<DateTime> getDates_heures_deconnexion_admin() {
		return dates_heures_deconnexion_admin;
	}

	/**
	 * @param dates_heures_deconnexion_admin
	 *            the dates_heures_deconnexion_admin to set
	 */
	public void setDates_heures_deconnexion_admin(ArrayList<DateTime> dates_heures_deconnexion_admin) {
		this.dates_heures_deconnexion_admin = dates_heures_deconnexion_admin;
	}

}
