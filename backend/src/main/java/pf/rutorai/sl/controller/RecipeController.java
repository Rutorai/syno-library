package pf.rutorai.sl.controller;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import static pf.rutorai.sl.controller.AbstractController.REQUEST_QUERY;
import pf.rutorai.sl.converter.ifaces.IRecipeDtoConverter;
import pf.rutorai.sl.exception.impl.DefaultException;
import pf.rutorai.sl.service.ifaces.IRecipeService;
import pf.rutorai.sl.dto.RecipeDto;
import pf.rutorai.sl.dto.ResponseDto;
import pf.rutorai.sl.vo.Filter;
import pf.rutorai.sl.vo.Recipe;

/**
 * Implementation of the Recipe Controller.
 *
 * @version 1.0.0
 * @see AbstractController
 */
@Controller
public class RecipeController extends AbstractController<RecipeDto, Recipe> {
    // **************************************************************************************************
    // Static properties
    // **************************************************************************************************

    private static final Logger LOGGER = LoggerFactory.getLogger(RecipeController.class);

    // **************************************************************************************************
    // Properties
    // **************************************************************************************************
    @Autowired
    private IRecipeService service;

    @Autowired
    private IRecipeDtoConverter converter;

    // **************************************************************************************************
    // Constructors
    // **************************************************************************************************
    // **************************************************************************************************
    // Business methods
    // **************************************************************************************************
    //-------------------Retrieve All Recipes--------------------------------------------------------
    @RequestMapping(value = "/data/recipe/list", method = RequestMethod.GET)
    @ResponseBody
    public MappingJacksonValue onList(@RequestParam(defaultValue = "0") int offset, @RequestParam(defaultValue = "20") int limit,
	    @RequestParam(defaultValue = "enum") String action, @RequestParam(defaultValue = "") String query, @RequestParam(defaultValue = "") String callback) {
	ResponseDto<List<RecipeDto>> message = new ResponseDto<>();
	MappingJacksonValue response = new MappingJacksonValue(message);

	try {
	    List<Filter> filters = new ArrayList<>(0);
	    List<RecipeDto> recipes = new ArrayList<>(0);

	    if (REQUEST_QUERY.equals(action)) {
		filters.add(new Filter("title", query, Filter.COMPARATOR.LIKE));
		filters.add(new Filter("description", query, Filter.COMPARATOR.LIKE));
	    }

	    int total = count(filters);

	    if (total > 0) {
		recipes = find(filters, offset, Math.min(total, limit));
	    }

	    message.setTotal(total);
	    message.setResult(recipes);

	    if (StringUtils.isNotBlank(callback)) {
		response.setJsonpFunction(callback);
	    }
	} catch (DefaultException de) {
	    LOGGER.error(de.toString());
	    message.addError(de.getErrorCode(), de.getErrorMessage());
	}

	return response;
    }

    // **************************************************************************************************
    // Getters & Setters
    // **************************************************************************************************
    @Override
    public IRecipeService getService() {
	return service;
    }

    public void setService(IRecipeService service) {
	this.service = service;
    }

    @Override
    public IRecipeDtoConverter getConverter() {
	return converter;
    }

    public void setConverter(IRecipeDtoConverter converter) {
	this.converter = converter;
    }
}
