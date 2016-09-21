package cane.brothers.spring.dpd.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DpdCalculationException extends Exception {

	private static final long serialVersionUID = 3800222299886969036L;

	public DpdCalculationException(String message) {
        super(message);
    }
}
