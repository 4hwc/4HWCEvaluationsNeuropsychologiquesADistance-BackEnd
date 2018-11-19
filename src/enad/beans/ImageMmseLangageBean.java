package enad.beans;

import java.io.Serializable;
import java.sql.Timestamp;

public class ImageMmseLangageBean implements Serializable {

	private Long id_mmse_langage;
	private Long id_image_langage_aleatoire_mmse;

	private Timestamp date_heure_creation_image_langage_mmse;
	private String nom_image_langage_mmse;
	private String url_image_langage_mmse;

	/**
	 * @return the id_mmse_langage
	 */
	public Long getId_mmse_langage() {
		return id_mmse_langage;
	}

	/**
	 * @param id_mmse_langage
	 *            the id_mmse_langage to set
	 */
	public void setId_mmse_langage(Long id_mmse_langage) {
		this.id_mmse_langage = id_mmse_langage;
	}

	/**
	 * @return the id_image_langage_aleatoire_mmse
	 */
	public Long getId_image_langage_aleatoire_mmse() {
		return id_image_langage_aleatoire_mmse;
	}

	/**
	 * @param id_image_langage_aleatoire_mmse
	 *            the id_image_langage_aleatoire_mmse to set
	 */
	public void setId_image_langage_aleatoire_mmse(Long id_image_langage_aleatoire_mmse) {
		this.id_image_langage_aleatoire_mmse = id_image_langage_aleatoire_mmse;
	}

	/**
	 * @return the date_heure_creation_image_langage_mmse
	 */
	public Timestamp getDate_heure_creation_image_langage_mmse() {
		return date_heure_creation_image_langage_mmse;
	}

	/**
	 * @param date_heure_creation_image_langage_mmse
	 *            the date_heure_creation_image_langage_mmse to set
	 */
	public void setDate_heure_creation_image_langage_mmse(Timestamp date_heure_creation_image_langage_mmse) {
		this.date_heure_creation_image_langage_mmse = date_heure_creation_image_langage_mmse;
	}

	/**
	 * @return the nom_image_langage_mmse
	 */
	public String getNom_image_langage_mmse() {
		return nom_image_langage_mmse;
	}

	/**
	 * @param nom_image_langage_mmse
	 *            the nom_image_langage_mmse to set
	 */
	public void setNom_image_langage_mmse(String nom_image_langage_mmse) {
		this.nom_image_langage_mmse = nom_image_langage_mmse;
	}

	/**
	 * @return the url_image_langage_mmse
	 */
	public String getUrl_image_langage_mmse() {
		return url_image_langage_mmse;
	}

	/**
	 * @param url_image_langage_mmse
	 *            the url_image_langage_mmse to set
	 */
	public void setUrl_image_langage_mmse(String url_image_langage_mmse) {
		this.url_image_langage_mmse = url_image_langage_mmse;
	}

}
