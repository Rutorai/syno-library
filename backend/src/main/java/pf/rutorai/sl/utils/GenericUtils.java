package pf.rutorai.sl.utils;

import java.lang.reflect.ParameterizedType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Return the super class of a paramterized object.
 *
 * @version 1.0.0
 */
public class GenericUtils {

    // **************************************************************************************************
    // Static properties
    // **************************************************************************************************
    private static final Logger LOGGER = LoggerFactory.getLogger(GenericUtils.class);

    // **************************************************************************************************
    // Properties
    // **************************************************************************************************
    // **************************************************************************************************
    // Constructors
    // **************************************************************************************************
    // **************************************************************************************************
    // Business methods
    // **************************************************************************************************
    /**
     * Return the class type of the n-ieme parameter type.
     *
     * @param instance       Object for which the class type is looked.
     * @param parameterIndex Index of the parameter for which the class type is looked
     *
     * @return The class type of the n-ieme parameter type
     */
    public static Class<?> findSuperClassParameterType(Object instance, int parameterIndex) {
	ParameterizedType genericSuperclass = (ParameterizedType) instance.getClass().getGenericSuperclass();
	return (Class<?>) genericSuperclass.getActualTypeArguments()[parameterIndex];
    }

    // **************************************************************************************************
    // Getters & Setters
    // **************************************************************************************************
}
