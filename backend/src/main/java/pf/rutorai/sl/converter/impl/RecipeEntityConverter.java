package pf.rutorai.sl.converter.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import pf.rutorai.sl.converter.AbstractModelConverter;
import pf.rutorai.sl.converter.ifaces.IRecipeEntityConverter;
import pf.rutorai.sl.exception.impl.DefaultException;
import pf.rutorai.sl.model.RecipeModel;
import pf.rutorai.sl.vo.Recipe;

/**
 * Mapping of specific field of Recipe items.
 *
 * @version 1.0.0
 */
@Component
public class RecipeEntityConverter extends AbstractModelConverter<Recipe, RecipeModel> implements IRecipeEntityConverter {
    // **************************************************************************************************
    // Static properties
    // **************************************************************************************************

    private static final Logger LOGGER = LoggerFactory.getLogger(RecipeEntityConverter.class);

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
    public Recipe toVo(RecipeModel entity) throws DefaultException {
	Recipe vo = null;

	if (entity != null) {
	    vo = new Recipe();

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
    public RecipeModel toEntity(Recipe vo) throws DefaultException {
	RecipeModel model = null;

	if (vo != null) {
	    model = new RecipeModel();

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
