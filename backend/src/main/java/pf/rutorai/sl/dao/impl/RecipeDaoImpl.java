package pf.rutorai.sl.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pf.rutorai.sl.converter.ifaces.IRecipeEntityConverter;
import pf.rutorai.sl.dao.AbstractDao;
import pf.rutorai.sl.dao.ifaces.IRecipeDao;
import pf.rutorai.sl.model.RecipeModel;
import pf.rutorai.sl.vo.Recipe;

/**
 * Implementation of the Recipe DAO.
 *
 * @version 1.0.0
 */
@Repository
public class RecipeDaoImpl extends AbstractDao<Recipe, RecipeModel> implements IRecipeDao {

    // ************************************************************************************************************
    // Static properties
    // ************************************************************************************************************
    private static final Logger LOGGER = LoggerFactory.getLogger(RecipeDaoImpl.class);

    // ************************************************************************************************************
    // Properties
    // ************************************************************************************************************
    @Autowired
    private IRecipeEntityConverter recipeConverter;

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
    public IRecipeEntityConverter getConverter() {
	return recipeConverter;
    }

    public void setConverter(IRecipeEntityConverter recipeConverter) {
	this.recipeConverter = recipeConverter;
    }
}
