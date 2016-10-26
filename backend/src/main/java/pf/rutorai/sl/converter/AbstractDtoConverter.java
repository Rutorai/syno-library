package pf.rutorai.sl.converter;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pf.rutorai.sl.converter.ifaces.IDtoConverter;
import pf.rutorai.sl.converter.ifaces.IModelConverter;
import pf.rutorai.sl.exception.impl.DefaultException;

/**
 * Abstract class allowing generic implementation of conversion of list.
 *
 * @version 1.0.0
 *
 * @see IModelConverter
 *
 * @param <DTO> DTO type
 * @param <VO>  VO type
 */
public abstract class AbstractDtoConverter<DTO, VO> implements IDtoConverter<DTO, VO> {

    // ************************************************************************************************************
    // Static properties
    // ************************************************************************************************************
    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractDtoConverter.class);

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
     * Convert a list of VO objects into a list of DTO ones.
     *
     * @param vos List of VO items to convert.
     *
     * @return A list of DTO objects from the list of VO ones.
     *
     * @throws DefaultException
     */
    @Override
    public List<DTO> toDto(List<VO> vos) throws DefaultException {
	List<DTO> dtos = null;

	if (CollectionUtils.isNotEmpty(vos)) {
	    dtos = new ArrayList<>(vos.size());

	    for (VO vo : vos) {
		dtos.add(toDto(vo));
	    }
	}

	return dtos;
    }

    /**
     * Convert a list of DTO objects into a list of VO ones.
     *
     * @param dtos List of DTO items to convert.
     *
     * @return A list of VO objects from the list of DTO ones.
     *
     * @throws DefaultException
     */
    @Override
    public List<VO> toVo(List<DTO> dtos) throws DefaultException {
	List<VO> vos = null;

	if (CollectionUtils.isNotEmpty(dtos)) {
	    vos = new ArrayList<>(dtos.size());

	    for (DTO dto : dtos) {
		vos.add(toVo(dto));
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
