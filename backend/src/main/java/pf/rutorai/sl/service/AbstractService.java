package pf.rutorai.sl.service;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import pf.rutorai.sl.dao.ifaces.IDao;
import pf.rutorai.eel.exception.ifaces.IException;
import pf.rutorai.sl.exception.impl.DefaultException;
import pf.rutorai.sl.service.ifaces.IService;
import pf.rutorai.sl.vo.Filter;

/**
 * This class is the basic of any Service object.
 *
 * @see IService
 *
 * @param <VO> Business object.
 */
@Transactional
public abstract class AbstractService<VO> implements IService<VO> {
    // ************************************************************************************************************
    // Static properties
    // ************************************************************************************************************

    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractService.class);

    // ************************************************************************************************************
    // Properties
    // ************************************************************************************************************
    // ************************************************************************************************************
    // Constructors
    // ************************************************************************************************************
    // ************************************************************************************************************
    // Business methods
    // ************************************************************************************************************
    /**
     * Each service must have at least DAO, as it can have different name, this method insure
     * a common method to get it.
     *
     * @return The main DAO of the service.
     */
    public abstract IDao<VO, ?> getDao();

    /**
     * Return the number of items matching the criteria.
     *
     * @param filters The filter to apply on database rows.
     *
     * @return The number of occurrences in the database that match the filter.
     *
     * @throws DefaultException
     */
    @Override
    @Transactional(readOnly = true)
    public int count(List<Filter> filters) throws DefaultException {
	int total = 0;

	if (getDao() != null) {
	    total = getDao().count(filters);
	} else {
	    DefaultException de = new DefaultException(IException.UNDEFINED_ERROR_CODE,
		    IException.UNDEFINED_ERROR_MESSAGE);
	    throw de;
	}

	return total;
    }

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
    @Override
    @Transactional(readOnly = true)
    public List<VO> find(List<Filter> filters, int offset, int limit) throws DefaultException {
	List<VO> vos = null;

	if (getDao() != null) {
	    vos = getDao().find(filters, offset, limit);
	} else {
	    DefaultException de = new DefaultException(IException.UNDEFINED_ERROR_CODE,
		    IException.UNDEFINED_ERROR_MESSAGE);
	    throw de;
	}

	return vos;
    }
}
