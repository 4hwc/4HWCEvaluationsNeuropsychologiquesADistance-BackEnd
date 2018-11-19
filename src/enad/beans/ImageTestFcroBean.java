package enad.beans;

import java.io.Serializable;
import java.sql.Timestamp;

public class ImageTestFcroBean implements Serializable {

	private Long id_image_test_fcro;
	private Long id_seance;

	private Timestamp date_heure_creation_img_fcro;
	private String nom_img_fcro;
	private String url_img_fcro;

	/**
	 * @return the url_img_fcro
	 */
	public String getUrl_img_fcro() {
		return url_img_fcro;
	}

	/**
	 * @param url_img_fcro
	 *            the url_img_fcro to set
	 */
	public void setUrl_img_fcro(String url_img_fcro) {
		this.url_img_fcro = url_img_fcro;
	}

	/**
	 * @return the id_seance
	 */
	public Long getId_seance() {
		return id_seance;
	}

	/**
	 * @param id_seance
	 *            the id_seance to set
	 */
	public void setId_seance(Long id_seance) {
		this.id_seance = id_seance;
	}

	/**
	 * @return the id_image_test_fcro
	 */
	public Long getId_image_test_fcro() {
		return id_image_test_fcro;
	}

	/**
	 * @param id_image_test_fcro
	 *            the id_image_test_fcro to set
	 */
	public void setId_image_test_fcro(Long id_image_test_fcro) {
		this.id_image_test_fcro = id_image_test_fcro;
	}

	/**
	 * @return the date_heure_creation_img_fcro
	 */
	public Timestamp getDate_heure_creation_img_fcro() {
		return date_heure_creation_img_fcro;
	}

	/**
	 * @param date_heure_creation_img_fcro
	 *            the date_heure_creation_img_fcro to set
	 */
	public void setDate_heure_creation_img_fcro(Timestamp date_heure_creation_img_fcro) {
		this.date_heure_creation_img_fcro = date_heure_creation_img_fcro;
	}

	/**
	 * @return the nom_img_fcro
	 */
	public String getNom_img_fcro() {
		return nom_img_fcro;
	}

	/**
	 * @param nom_img_fcro
	 *            the nom_img_fcro to set
	 */
	public void setNom_img_fcro(String nom_img_fcro) {
		this.nom_img_fcro = nom_img_fcro;
	}

}
