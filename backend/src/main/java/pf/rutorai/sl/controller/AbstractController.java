package pf.rutorai.sl.controller;

import java.util.List;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pf.rutorai.sl.converter.ifaces.IDtoConverter;
import pf.rutorai.eel.exception.ifaces.IException;
import pf.rutorai.sl.exception.impl.DefaultException;
import pf.rutorai.sl.service.ifaces.IService;
import pf.rutorai.sl.vo.Filter;

/**
 * Abstract class allowing generic implementation of controllers.
 *
 * @version 1.0.0
 *
 * @param <DTO> DTO type
 * @param <VO>  VO type
 */
public abstract class AbstractController<DTO, VO> {
    // **************************************************************************************************
    // Static properties
    // **************************************************************************************************

    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractController.class);

    /**
     * Request for all item, without any filter.
     */
    public static final String REQUEST_ENUM = "enum";

    /**
     * Request for all item matching the given filter.
     */
    public static final String REQUEST_QUERY = "find";

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
     * Return the main service on which the controller depends.
     *
     * @return The main service on which the controller depends.
     */
    protected abstract IService<VO> getService();

    /**
     * Return the main converter on which the controller depends.
     *
     * @return The main converter on which the controller depends.
     */
    protected abstract IDtoConverter<DTO, VO> getConverter();

    /**
     * Return the number of items matching the criteria.
     *
     * @param filters The filter to apply on database rows.
     *
     * @return The number of occurrences in the database that match the filter.
     *
     * @throws DefaultException
     */
    protected int count(List<Filter> filters) throws DefaultException {
	int count = 0;

	if (getService() != null) {
	    count = getService().count(filters);
	} else {
	    DefaultException de = new DefaultException(IException.UNDEFINED_ERROR_CODE,
		    IException.UNDEFINED_ERROR_MESSAGE);
	    throw de;
	}

	return count;
    }

    /**
     * Return all item from the data source.
     *
     * @param filters The filter to apply on database rows.
     * @param offset  First item
     * @param limit   Number of items to return
     *
     * @return All item from the data source.
     *
     * @throws DefaultException
     */
    protected List<DTO> find(List<Filter> filters, int offset, int limit) throws DefaultException {
	List<DTO> dtos = null;

	if ((getService() != null) && (getConverter() != null)) {
	    List<VO> vos = getService().find(filters, offset, limit);

	    if (CollectionUtils.isNotEmpty(vos)) {
		dtos = getConverter().toDto(vos);
	    }
	} else {
	    DefaultException de = new DefaultException(IException.UNDEFINED_ERROR_CODE,
		    IException.UNDEFINED_ERROR_MESSAGE);
	    throw de;
	}

	return dtos;
    }

    // **************************************************************************************************
    // Getters & Setters
    // **************************************************************************************************
}
