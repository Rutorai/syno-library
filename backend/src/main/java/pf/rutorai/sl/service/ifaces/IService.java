package pf.rutorai.sl.service.ifaces;

import java.util.List;
import pf.rutorai.sl.exception.impl.DefaultException;
import pf.rutorai.sl.vo.Filter;

/**
 * This is the contract to which the Service class must subscribe to offer standard services.
 *
 * @version 1.0.0
 *
 * @param <VO> Business object type.
 */
public interface IService<VO> {

    // ************************************************************************************************************
    // Static properties
    // ************************************************************************************************************
    // ************************************************************************************************************
    // Business methods
    // ************************************************************************************************************
    /**
     * Return the number of items matching the criteria.
     *
     * @param filters The filter to apply on database rows.
     *
     * @return The number of occurrences in the database that match the filter.
     *
     * @throws DefaultException
     */
    public abstract int count(List<Filter> filters) throws DefaultException;

    /**
     * Return items matching the criteria.
     *
     * @param filters List of key-value pair.
     * @param offset  First item
     * @param limit   Number of items to return
     *
     * @return Items matching the criteria.
     *
     * @throws DefaultException
     */
    public abstract List<VO> find(List<Filter> filters, int offset, int limit) throws DefaultException;
}
