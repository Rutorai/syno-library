package pf.rutorai.sl.converter;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pf.rutorai.sl.converter.ifaces.IModelConverter;
import pf.rutorai.sl.exception.impl.DefaultException;

/**
 * Abstract class allowing generic implementation of conversion of list.
 *
 * @see IModelConverter
 *
 * @param <VO>     VO type
 * @param <ENTITY> ENTITY type
 */
public abstract class AbstractModelConverter<VO, ENTITY> implements IModelConverter<VO, ENTITY> {

    // ************************************************************************************************************
    // Static properties
    // ************************************************************************************************************
    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractModelConverter.class);

    // ************************************************************************************************************
    // Properties
    // ************************************************************************************************************
    private String dateFormat = "yyyy-MM-dd";

    // ************************************************************************************************************
    // Constructors
    // ************************************************************************************************************
    // ************************************************************************************************************
    // Business methods
    // ************************************************************************************************************
    /**
     * Convert a list of VO objects into a list of ENTITY ones.
     *
     * @param vos List of VO items to convert.
     *
     * @return A list of ENTITY objects from the list of VO ones.
     *
     * @throws DefaultException
     */
    @Override
    public List<ENTITY> toEntity(List<VO> vos) throws DefaultException {
	List<ENTITY> entities = null;

	if (CollectionUtils.isNotEmpty(vos)) {
	    entities = new ArrayList<>(vos.size());

	    for (VO vo : vos) {
		entities.add(toEntity(vo));
	    }
	}

	return entities;
    }

    /**
     * Convert a list of ENTITY objects into a list of VO ones.
     *
     * @param entities List of ENTITY items to convert.
     *
     * @return A list of VO objects from the list of ENTITY ones.
     *
     * @throws DefaultException
     */
    @Override
    public List<VO> toVo(List<ENTITY> entities) throws DefaultException {
	List<VO> vos = null;

	if (CollectionUtils.isNotEmpty(entities)) {
	    vos = new ArrayList<>(entities.size());

	    for (ENTITY entity : entities) {
		vos.add(toVo(entity));
	    }
	}

	return vos;
    }

    // ************************************************************************************************************
    // Getters & Setters
    // ************************************************************************************************************
    public String getDateFormat() {
	return dateFormat;
    }

    public void setDateFormat(String dateFormat) {
	this.dateFormat = dateFormat;
    }
}
