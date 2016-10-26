package pf.rutorai.sl.converter.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import pf.rutorai.sl.converter.AbstractDtoConverter;
import pf.rutorai.sl.converter.ifaces.IRecipeDtoConverter;
import pf.rutorai.sl.dto.RecipeDto;
import pf.rutorai.sl.exception.impl.DefaultException;
import pf.rutorai.sl.vo.Recipe;

/**
 * Mapping of specific field of Recipe items.
 *
 * @version 1.0.0
 */
@Component
public class RecipeDtoConverter extends AbstractDtoConverter<RecipeDto, Recipe> implements IRecipeDtoConverter {
    // **************************************************************************************************
    // Static properties
    // **************************************************************************************************

    private static final Logger LOGGER = LoggerFactory.getLogger(RecipeDtoConverter.class);

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
    public RecipeDto toDto(Recipe vo) throws DefaultException {
	RecipeDto dto = null;

	if (vo != null) {
	    dto = new RecipeDto();

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
    public Recipe toVo(RecipeDto dto) throws DefaultException {
	Recipe vo = null;

	if (dto != null) {
	    vo = new Recipe();

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
