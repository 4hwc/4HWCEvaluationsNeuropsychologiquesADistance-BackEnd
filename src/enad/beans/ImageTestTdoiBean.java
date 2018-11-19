package enad.beans;

import java.io.Serializable;
import java.sql.Timestamp;

public class ImageTestTdoiBean implements Serializable {

	private Long id_image_test_tdoi;
	private Long id_medecin;
	private Timestamp date_heure_creation_img_tdoi;
	private String nom_img_tdoi;
	private String url_img_tdoi;

	/**
	 * @return the id_image_test_tdoi
	 */
	public Long getId_image_test_tdoi() {
		return id_image_test_tdoi;
	}

	/**
	 * @param id_image_test_tdoi
	 *            the id_image_test_tdoi to set
	 */
	public void setId_image_test_tdoi(Long id_image_test_tdoi) {
		this.id_image_test_tdoi = id_image_test_tdoi;
	}

	/**
	 * @return the id_medecin
	 */
	public Long getId_medecin() {
		return id_medecin;
	}

	/**
	 * @param id_medecin
	 *            the id_medecin to set
	 */
	public void setId_medecin(Long id_medecin) {
		this.id_medecin = id_medecin;
	}

	/**
	 * @return the date_heure_creation_img_tdoi
	 */
	public Timestamp getDate_heure_creation_img_tdoi() {
		return date_heure_creation_img_tdoi;
	}

	/**
	 * @param date_heure_creation_img_tdoi
	 *            the date_heure_creation_img_tdoi to set
	 */
	public void setDate_heure_creation_img_tdoi(Timestamp date_heure_creation_img_tdoi) {
		this.date_heure_creation_img_tdoi = date_heure_creation_img_tdoi;
	}

	/**
	 * @return the nom_img_tdoi
	 */
	public String getNom_img_tdoi() {
		return nom_img_tdoi;
	}

	/**
	 * @param nom_img_tdoi
	 *            the nom_img_tdoi to set
	 */
	public void setNom_img_tdoi(String nom_img_tdoi) {
		this.nom_img_tdoi = nom_img_tdoi;
	}

	/**
	 * @return the url_img_tdoi
	 */
	public String getUrl_img_tdoi() {
		return url_img_tdoi;
	}

	/**
	 * @param url_img_tdoi
	 *            the url_img_tdoi to set
	 */
	public void setUrl_img_tdoi(String url_img_tdoi) {
		this.url_img_tdoi = url_img_tdoi;
	}

}
