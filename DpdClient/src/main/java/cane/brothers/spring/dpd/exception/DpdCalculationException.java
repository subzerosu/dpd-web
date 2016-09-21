package cane.brothers.spring.dpd.exception;

import org.springframework.validation.Errors;

public class DpdCalculationException extends RuntimeException {

	private static final long serialVersionUID = 3800222299886969036L;

	private Errors errors;

    public DpdCalculationException(String message, Errors errors) {
        super(message);
        this.errors = errors;
    }

    public Errors getErrors() { return errors; }
}
