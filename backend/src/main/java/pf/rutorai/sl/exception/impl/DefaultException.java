package pf.rutorai.sl.exception.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pf.rutorai.eel.exception.ifaces.IException;

/**
 * Abstract definition of an exception.
 *
 */
public class DefaultException extends Exception implements IException {

    // **************************************************************************************************
    // Static properties
    // **************************************************************************************************
    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultException.class);

    // **************************************************************************************************
    // Properties
    // **************************************************************************************************
    /**
     * Code of the error.
     */
    private String errorCode;

    /**
     * Message that belongs to the error.
     */
    private String errorMessage;

    // **************************************************************************************************
    // Constructors
    // **************************************************************************************************
    public DefaultException() {
	this(UNDEFINED_ERROR_CODE, UNDEFINED_ERROR_MESSAGE);
    }

    public DefaultException(String errorCode, String errorMessage) {
	super();

	setErrorCode(errorCode);
	setErrorMessage(errorMessage);
    }

    public DefaultException(String errorCode, String errorMessage, Throwable throwable) {
	super(throwable);

	setErrorCode(errorCode);
	setErrorMessage(errorMessage);
    }

    public DefaultException(Throwable throwable) {
	this(UNDEFINED_ERROR_CODE, UNDEFINED_ERROR_MESSAGE, throwable);
    }

    // **************************************************************************************************
    // Business methods
    // **************************************************************************************************
    /**
     * Return the string expression of this object.
     *
     * @return The string expression of this object.
     */
    public String toString() {
	StringBuilder sb = new StringBuilder();

	sb.append("[").append(getErrorCode()).append("] - ").append(getErrorMessage());

	return sb.toString();
    }

    // **************************************************************************************************
    // Getters & Setters
    // **************************************************************************************************
    public String getErrorCode() {
	return errorCode;
    }

    public final void setErrorCode(String errorCode) {
	this.errorCode = errorCode;
    }

    public String getErrorMessage() {
	return errorMessage;
    }

    public final void setErrorMessage(String errorMessage) {
	this.errorMessage = errorMessage;
    }
}
