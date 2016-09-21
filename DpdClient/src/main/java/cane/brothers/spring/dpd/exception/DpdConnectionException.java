package cane.brothers.spring.dpd.exception;

/**
 * Created by cane on 14.09.16.
 */
public class DpdConnectionException extends RuntimeException {

	private static final long serialVersionUID = 4516253435978900032L;

	public DpdConnectionException(String message) {
        super(message);
    }
}
