package cane.brothers.spring.dpd.exception;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by cane on 21.09.16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ErrorResource {
	private String code;
    private String message;
    private List<FieldErrorResource> fieldErrors;

    /**
     * Default constructor
     */
    public ErrorResource() { }

    public ErrorResource(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() { return code; }

    public void setCode(String code) { this.code = code; }

    public String getMessage() { return message; }

    public void setMessage(String message) { this.message = message; }

    public List<FieldErrorResource> getFieldErrors() { return fieldErrors; }

    public void setFieldErrors(List<FieldErrorResource> fieldErrors) {
        this.fieldErrors = fieldErrors;
    }
}
