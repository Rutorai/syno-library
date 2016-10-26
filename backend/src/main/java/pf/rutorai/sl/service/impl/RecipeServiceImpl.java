package pf.rutorai.sl.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pf.rutorai.sl.dao.ifaces.IRecipeDao;
import pf.rutorai.sl.service.AbstractService;
import pf.rutorai.sl.service.ifaces.IRecipeService;
import pf.rutorai.sl.vo.Recipe;

/**
 * Implementation of the Recipe Service.
 *
 * @version 1.0.0
 */
@Service
public class RecipeServiceImpl extends AbstractService<Recipe> implements IRecipeService {
    // ************************************************************************************************************
    // Static properties
    // ************************************************************************************************************

    private static final Logger LOGGER = LoggerFactory.getLogger(RecipeServiceImpl.class);

    // ************************************************************************************************************
    // Properties
    // ************************************************************************************************************
    @Autowired
    private IRecipeDao recipeDao;

    // ************************************************************************************************************
    // Constructors
    // ************************************************************************************************************
    // ************************************************************************************************************
    // Business methods
    // ************************************************************************************************************
    // ************************************************************************************************************
    // Getters & Setters
    // ************************************************************************************************************
    @Override
    public IRecipeDao getDao() {
	return recipeDao;
    }

    public void setDao(IRecipeDao recipeDao) {
	this.recipeDao = recipeDao;
    }
}
