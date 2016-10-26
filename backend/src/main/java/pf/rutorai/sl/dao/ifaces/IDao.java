package pf.rutorai.sl.dao.ifaces;

import java.util.List;
import pf.rutorai.sl.exception.impl.DefaultException;
import pf.rutorai.sl.vo.Filter;

/**
 * This is the contract to which the DAO class must subscribe to manipulate all
 * database tables.
 *
 * @version 1.0.0
 *
 * @param <VO> Type of the value object item.
 * @param <M>  Type of the database item.
 */
public interface IDao<VO, M> {

    // **************************************************************************************************
    // Static properties */
    // **************************************************************************************************
    // **************************************************************************************************
    // Business methods */
    // **************************************************************************************************
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
