/**
 * 
 */
package enad.dao;

/**
 * @author Admin
 *
 */
public class DAOConfigurationException extends RuntimeException {

	/* Constructeurs */
	public DAOConfigurationException(String message) {
		super(message);
	}

	public DAOConfigurationException(String message, Throwable cause) {
		super(message, cause);
	}

	public DAOConfigurationException(Throwable cause) {
		super(cause);
	}

}
