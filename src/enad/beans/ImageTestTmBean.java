package enad.beans;

import java.io.Serializable;
import java.sql.Timestamp;

public class ImageTestTmBean implements Serializable {

	private Long id_image_test_tm;
	private Long id_seance;
	private Timestamp date_heure_creation_img_tm;
	private String nom_img_tm;
	private String version_tm;
	private String url_img_tm;

	/**
	 * @return the url_img_tm
	 */
	public String getUrl_img_tm() {
		return url_img_tm;
	}

	/**
	 * @param url_img_tm
	 *            the url_img_tm to set
	 */
	public void setUrl_img_tm(String url_img_tm) {
		this.url_img_tm = url_img_tm;
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
	 * @return the version_tm
	 */
	public String getVersion_tm() {
		return version_tm;
	}

	/**
	 * @param version_tm
	 *            the version_tm to set
	 */
	public void setVersion_tm(String version_tm) {
		this.version_tm = version_tm;
	}

	/**
	 * @return the id_image_test_tm
	 */
	public Long getId_image_test_tm() {
		return id_image_test_tm;
	}

	/**
	 * @param id_image_test_tm
	 *            the id_image_test_tm to set
	 */
	public void setId_image_test_tm(Long id_image_test_tm) {
		this.id_image_test_tm = id_image_test_tm;
	}

	/**
	 * @return the date_heure_creation_img_tm
	 */
	public Timestamp getDate_heure_creation_img_tm() {
		return date_heure_creation_img_tm;
	}

	/**
	 * @param date_heure_creation_img_tm
	 *            the date_heure_creation_img_tm to set
	 */
	public void setDate_heure_creation_img_tm(Timestamp date_heure_creation_img_tm) {
		this.date_heure_creation_img_tm = date_heure_creation_img_tm;
	}

	/**
	 * @return the nom_img_tm
	 */
	public String getNom_img_tm() {
		return nom_img_tm;
	}

	/**
	 * @param nom_img_tm
	 *            the nom_img_tm to set
	 */
	public void setNom_img_tm(String nom_img_tm) {
		this.nom_img_tm = nom_img_tm;
	}

}
