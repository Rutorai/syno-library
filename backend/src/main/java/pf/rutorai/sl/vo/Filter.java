package pf.rutorai.sl.vo;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Define a filter to select item from the database.
 *
 * @version 1.0.0
 */
public class Filter {

    // **************************************************************************************************
    // Static properties
    // **************************************************************************************************
    private static final Logger LOGGER = LoggerFactory.getLogger(Filter.class);

    public static enum COMPARATOR {
	EQUALS, LIKE
    };

    // **************************************************************************************************
    // Properties
    // **************************************************************************************************
    /**
     * Name of the property on which to filter.
     */
    private String propertyName;

    /**
     * Value of the property on which to filter.
     */
    private Object propertyValue;

    /**
     * Comparison criteria.
     */
    private COMPARATOR comparator;

    // **************************************************************************************************
    // Constructors
    // **************************************************************************************************
    public Filter() {
    }

    public Filter(String propertyName, Object propertyValue, COMPARATOR comparator) {
	this.propertyName = propertyName;
	this.propertyValue = propertyValue;
	this.comparator = comparator;
    }

    // **************************************************************************************************
    // Business methods
    // **************************************************************************************************
    public static boolean isValid(Filter filter) {
	return ((filter != null) && StringUtils.isNotBlank(filter.getPropertyName()) && (filter.getPropertyValue() != null));
    }

    // **************************************************************************************************
    // Getters & Setters
    // **************************************************************************************************
    public String getPropertyName() {
	return propertyName;
    }

    public void setPropertyName(String propertyName) {
	this.propertyName = propertyName;
    }

    public Object getPropertyValue() {
	return propertyValue;
    }

    public void setPropertyValue(Object propertyValue) {
	this.propertyValue = propertyValue;
    }

    public COMPARATOR getComparator() {
	return comparator;
    }

    public void setComparator(COMPARATOR comparator) {
	this.comparator = comparator;
    }
}
