package pf.rutorai.sl.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Represents an error object with its code and label.
 *
 * @version 1.0.0
 */
public class ErrorDto {

    // **************************************************************************************************
    // Static properties
    // **************************************************************************************************
    private static final Logger LOGGER = LoggerFactory.getLogger(ErrorDto.class);

    // **************************************************************************************************
    // Properties
    // **************************************************************************************************
    private String code;
    private String message;

    // **************************************************************************************************
    // Constructors
    // **************************************************************************************************
    public ErrorDto() {
    }

    public ErrorDto(String code, String message) {
	this.code = code;
	this.message = message;
    }

    // **************************************************************************************************
    // Business methods
    // **************************************************************************************************
    // **************************************************************************************************
    // Getters & Setters
    // **************************************************************************************************
    public String getCode() {
	return code;
    }

    public void setCode(String code) {
	this.code = code;
    }

    public String getMessage() {
	return message;
    }

    public void setMessage(String message) {
	this.message = message;
    }
}
