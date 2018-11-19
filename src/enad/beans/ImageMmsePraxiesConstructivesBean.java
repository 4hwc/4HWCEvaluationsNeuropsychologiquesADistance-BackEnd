package enad.beans;

import java.io.Serializable;
import java.sql.Timestamp;

public class ImageMmsePraxiesConstructivesBean implements Serializable {

	private Long id_mmse_PraxiesConstructives;
	private Long id_image_PraxiesConstructives_aleatoire_mmse;

	private Timestamp date_heure_creation_image_PraxiesConstructives_mmse;
	private String nom_image_PraxiesConstructives_mmse;
	private String url_image_PraxiesConstructives_mmse;

	/**
	 * @return the id_mmse_PraxiesConstructives
	 */
	public Long getId_mmse_PraxiesConstructives() {
		return id_mmse_PraxiesConstructives;
	}

	/**
	 * @param id_mmse_PraxiesConstructives
	 *            the id_mmse_PraxiesConstructives to set
	 */
	public void setId_mmse_PraxiesConstructives(Long id_mmse_PraxiesConstructives) {
		this.id_mmse_PraxiesConstructives = id_mmse_PraxiesConstructives;
	}

	/**
	 * @return the id_image_PraxiesConstructives_aleatoire_mmse
	 */
	public Long getId_image_PraxiesConstructives_aleatoire_mmse() {
		return id_image_PraxiesConstructives_aleatoire_mmse;
	}

	/**
	 * @param id_image_PraxiesConstructives_aleatoire_mmse
	 *            the id_image_PraxiesConstructives_aleatoire_mmse to set
	 */
	public void setId_image_PraxiesConstructives_aleatoire_mmse(Long id_image_PraxiesConstructives_aleatoire_mmse) {
		this.id_image_PraxiesConstructives_aleatoire_mmse = id_image_PraxiesConstructives_aleatoire_mmse;
	}

	/**
	 * @return the date_heure_creation_image_PraxiesConstructives_mmse
	 */
	public Timestamp getDate_heure_creation_image_PraxiesConstructives_mmse() {
		return date_heure_creation_image_PraxiesConstructives_mmse;
	}

	/**
	 * @param date_heure_creation_image_PraxiesConstructives_mmse
	 *            the date_heure_creation_image_PraxiesConstructives_mmse to set
	 */
	public void setDate_heure_creation_image_PraxiesConstructives_mmse(
			Timestamp date_heure_creation_image_PraxiesConstructives_mmse) {
		this.date_heure_creation_image_PraxiesConstructives_mmse = date_heure_creation_image_PraxiesConstructives_mmse;
	}

	/**
	 * @return the nom_image_PraxiesConstructives_mmse
	 */
	public String getNom_image_PraxiesConstructives_mmse() {
		return nom_image_PraxiesConstructives_mmse;
	}

	/**
	 * @param nom_image_PraxiesConstructives_mmse
	 *            the nom_image_PraxiesConstructives_mmse to set
	 */
	public void setNom_image_PraxiesConstructives_mmse(String nom_image_PraxiesConstructives_mmse) {
		this.nom_image_PraxiesConstructives_mmse = nom_image_PraxiesConstructives_mmse;
	}

	/**
	 * @return the url_image_PraxiesConstructives_mmse
	 */
	public String getUrl_image_PraxiesConstructives_mmse() {
		return url_image_PraxiesConstructives_mmse;
	}

	/**
	 * @param url_image_PraxiesConstructives_mmse
	 *            the url_image_PraxiesConstructives_mmse to set
	 */
	public void setUrl_image_PraxiesConstructives_mmse(String url_image_PraxiesConstructives_mmse) {
		this.url_image_PraxiesConstructives_mmse = url_image_PraxiesConstructives_mmse;
	}

}
