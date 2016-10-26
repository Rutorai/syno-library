package pf.rutorai.sl.converter.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import pf.rutorai.sl.converter.AbstractModelConverter;
import pf.rutorai.sl.converter.ifaces.IMagazineEntityConverter;
import pf.rutorai.sl.exception.impl.DefaultException;
import pf.rutorai.sl.model.MagazineModel;
import pf.rutorai.sl.vo.Magazine;

/**
 * Mapping of specific field of Magazine items.
 *
 * @version 1.0.0
 */
@Component
public class MagazineEntityConverter extends AbstractModelConverter<Magazine, MagazineModel> implements IMagazineEntityConverter {
    // **************************************************************************************************
    // Static properties
    // **************************************************************************************************

    private static final Logger LOGGER = LoggerFactory.getLogger(MagazineEntityConverter.class);

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
     * Update VO object with ENTITY vo.
     *
     * @param entity Source object
     *
     * @throws DefaultException
     */
    @Override
    public Magazine toVo(MagazineModel entity) throws DefaultException {
	Magazine vo = null;

	if (entity != null) {
	    vo = new Magazine();

	    vo.setIdentifier(entity.getIdentifier());
	    vo.setTitle(entity.getTitle());
	    vo.setDescription(entity.getDescription());
	}

	return vo;
    }

    /**
     * Update ENTITY object with VO vo.
     *
     * @param vo Source object
     *
     * @throws DefaultException
     */
    @Override
    public MagazineModel toEntity(Magazine vo) throws DefaultException {
	MagazineModel model = null;

	if (vo != null) {
	    model = new MagazineModel();

	    model.setIdentifier(vo.getIdentifier());
	    model.setTitle(vo.getTitle());
	    model.setDescription(vo.getDescription());
	}

	return model;
    }

    // **************************************************************************************************
    // Getters & Setters
    // **************************************************************************************************
}
