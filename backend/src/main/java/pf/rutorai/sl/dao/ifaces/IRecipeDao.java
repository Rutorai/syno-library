package pf.rutorai.sl.dao.ifaces;

import pf.rutorai.sl.model.RecipeModel;
import pf.rutorai.sl.vo.Recipe;

/**
 * Specific extension of the contract to which the Recipe DAO class must subscribe to manipulate
 * Recipe items.
 *
 * @version 1.0.0
 */
public interface IRecipeDao extends IDao<Recipe, RecipeModel> {
    /* ************************************************************************************************** */
 /* Static properties */
 /* ************************************************************************************************** */

 /* ************************************************************************************************** */
 /* Business methods */
 /* ************************************************************************************************** */
}
