package pf.rutorai.sl.converter.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import pf.rutorai.sl.converter.AbstractDtoConverter;
import pf.rutorai.sl.converter.ifaces.IMagazineDtoConverter;
import pf.rutorai.sl.dto.MagazineDto;
import pf.rutorai.sl.exception.impl.DefaultException;
import pf.rutorai.sl.vo.Magazine;

/**
 * Mapping of specific field of Magazine items.
 *
 * @version 1.0.0
 */
@Component
public class MagazineDtoConverter extends AbstractDtoConverter<MagazineDto, Magazine> implements IMagazineDtoConverter {
    // **************************************************************************************************
    // Static properties
    // **************************************************************************************************

    private static final Logger LOGGER = LoggerFactory.getLogger(MagazineDtoConverter.class);

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
     * Update DTO object with VO vo.
     *
     * @param vo Source object
     *
     * @throws DefaultException
     */
    @Override
    public MagazineDto toDto(Magazine vo) throws DefaultException {
	MagazineDto dto = null;

	if (vo != null) {
	    dto = new MagazineDto();

	    dto.setIdentifier(vo.getIdentifier());
	    dto.setTitle(vo.getTitle());
	    dto.setDescription(vo.getDescription());
	}

	return dto;
    }

    /**
     * Update VO object with DTO vo.
     *
     * @param dto Source object
     *
     * @throws DefaultException
     */
    @Override
    public Magazine toVo(MagazineDto dto) throws DefaultException {
	Magazine vo = null;

	if (dto != null) {
	    vo = new Magazine();

	    vo.setIdentifier(dto.getIdentifier());
	    vo.setTitle(dto.getTitle());
	    vo.setDescription(dto.getDescription());
	}

	return vo;
    }

    // **************************************************************************************************
    // Getters & Setters
    // **************************************************************************************************
}
