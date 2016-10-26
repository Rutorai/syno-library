package pf.rutorai.sl.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Response object.
 * Contains a list of errors, and/or the object.
 *
 * @version 1.0.0
 *
 * @param <T> Main Type of the response object.
 */
public class ResponseDto<T> {

    // **************************************************************************************************
    // Static properties
    // **************************************************************************************************
    private static final Logger LOGGER = LoggerFactory.getLogger(ResponseDto.class);

    // **************************************************************************************************
    // Properties
    // **************************************************************************************************
    /**
     * Result(s).
     */
    private T result;

    /**
     * Total number of items.
     * This total is the number of items that can be retrieve, not the number of item that the request
     * will send back to the client.
     */
    private long total;

    /**
     * In case of error.
     */
    private List<ErrorDto> errors;

    // **************************************************************************************************
    // Constructors
    // **************************************************************************************************
    // **************************************************************************************************
    // Business methods
    // **************************************************************************************************
    /**
     * Create a new error and add it to the list of errors.
     *
     * @param code    The error code.
     * @param message The error label.
     */
    public void addError(String code, String message) {
	getErrors().add(new ErrorDto(code, message));
    }

    /**
     * Return true is there's no error in the response message, false otherwise.
     *
     * @return True is there's no error in the response message, false otherwise.
     */
    public boolean isSuccess() {
	return CollectionUtils.isEmpty(errors);
    }

    /**
     * Return the number of element in the response.
     *
     * @return The number of element in the response.
     */
    public long count() {
	if ((getResult() != null) && (getResult() instanceof Collection<?>)) {
	    return ((Collection<?>) getResult()).size();
	} else if (getResult() != null) {
	    return 1l;
	} else {
	    return 0;
	}
    }

    // **************************************************************************************************
    // Getters & Setters
    // **************************************************************************************************
    public T getResult() {
	return result;
    }

    public void setResult(T result) {
	this.result = result;
    }

    public List<ErrorDto> getErrors() {
	if (errors == null) {
	    errors = new ArrayList<>();
	}
	return errors;
    }

    public void setErrors(List<ErrorDto> errors) {
	this.errors = errors;
    }

    public long getTotal() {
	return total;
    }

    public void setTotal(long total) {
	this.total = total;
    }
}
