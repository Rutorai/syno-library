package pf.rutorai.sl.dao;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.collections4.CollectionUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import pf.rutorai.sl.converter.ifaces.IModelConverter;
import pf.rutorai.eel.exception.ifaces.IException;
import pf.rutorai.sl.dao.ifaces.IDao;
import pf.rutorai.sl.exception.impl.DefaultException;
import pf.rutorai.sl.utils.GenericUtils;
import pf.rutorai.sl.vo.Filter;

/**
 * This class is the basic of any DAO object.
 *
 * @version 1.0.0
 *
 * @param <VO>
 * @param <M>
 */
public abstract class AbstractDao<VO, M> implements IDao<VO, M> {

    // ************************************************************************************************************
    // Static properties
    // ************************************************************************************************************
    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractDao.class);

    // ************************************************************************************************************
    // Properties
    // ************************************************************************************************************
    @Autowired
    private SessionFactory sessionFactory;

    // ************************************************************************************************************
    // Constructors
    // ************************************************************************************************************
    // ************************************************************************************************************
    // Business methods
    // ************************************************************************************************************
    /**
     * Retrieve the converter.
     *
     * @return The converter.
     *
     * @throws DefaultException
     */
    public abstract IModelConverter<VO, M> getConverter() throws DefaultException;

    protected final Session getCurrentSession() throws DefaultException {
	return sessionFactory.getCurrentSession();
    }

    @Override
    public int count(List<Filter> filters) throws DefaultException {
	int count = 0;

	Criteria criteria = getCurrentSession().createCriteria(GenericUtils.findSuperClassParameterType(this, 1));

	if (CollectionUtils.isNotEmpty(filters)) {
	    applyFilter(filters, criteria);
	}

	Number number = (Number) criteria.setProjection(Projections.rowCount()).uniqueResult();

	if (number != null) {
	    count = number.intValue();
	}

	return count;
    }

    @Override
    public List<VO> find(List<Filter> filters, int offset, int limit) throws DefaultException {
	List<VO> vos = new ArrayList<>(0);

	if (getConverter() != null) {
	    Criteria criteria = getCurrentSession().createCriteria(GenericUtils.findSuperClassParameterType(this, 1));

	    if (CollectionUtils.isNotEmpty(filters)) {
		applyFilter(filters, criteria);
	    }

	    criteria.setFirstResult(offset);
	    criteria.setMaxResults(limit);

	    vos = getConverter().toVo(criteria.list());
	} else {
	    DefaultException de = new DefaultException(IException.UNDEFINED_ERROR_CODE,
		    IException.UNDEFINED_ERROR_MESSAGE);
	    throw de;
	}

	return vos;
    }

    /**
     *
     * @return
     */
    private void applyFilter(List<Filter> filters, Criteria criteria) {
	if (CollectionUtils.isNotEmpty(filters) && (criteria != null)) {
	    List<Criterion> criterionList = new ArrayList<>(filters.size());
	    for (Filter filter : filters) {
		if (filter != null) {
		    switch (filter.getComparator()) {
			case EQUALS:
			    criterionList.add(Restrictions.eq(filter.getPropertyName(), filter.getPropertyValue()));
			    break;
			case LIKE:
			    criterionList.add(Restrictions.ilike(filter.getPropertyName(), "%" + filter.getPropertyValue() + "%"));
			    break;
		    }
		}
	    }

	    if (criterionList.size() == 1) {
		criteria.add(criterionList.get(0));
	    } else if (criterionList.size() > 1) {
		criteria.add(Restrictions.or(criterionList.toArray(new Criterion[0])));
	    }
	}
    }

    // ************************************************************************************************************
    // Getters & Setters
    // ************************************************************************************************************
    public SessionFactory getSessionFactory() {
	return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
	this.sessionFactory = sessionFactory;
    }
}
