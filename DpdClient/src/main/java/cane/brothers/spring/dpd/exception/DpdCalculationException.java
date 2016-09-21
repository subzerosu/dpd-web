package cane.brothers.spring.dpd.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;
import org.springframework.validation.Errors;

@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class DpdCalculationException extends RuntimeException {

	private static final long serialVersionUID = 3800222299886969036L;

	private Errors errors;

    public DpdCalculationException(String message, Errors errors) {
        super(message);
        this.errors = errors;
    }

    public Errors getErrors() { return errors; }
}
