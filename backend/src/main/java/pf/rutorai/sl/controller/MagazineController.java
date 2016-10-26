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
import pf.rutorai.sl.converter.ifaces.IMagazineDtoConverter;
import pf.rutorai.sl.exception.impl.DefaultException;
import pf.rutorai.sl.service.ifaces.IMagazineService;
import pf.rutorai.sl.dto.MagazineDto;
import pf.rutorai.sl.dto.ResponseDto;
import pf.rutorai.sl.vo.Filter;
import pf.rutorai.sl.vo.Magazine;

/**
 * Implementation of the Magazine Controller.
 *
 * @version 1.0.0
 * @see AbstractController
 */
@Controller
public class MagazineController extends AbstractController<MagazineDto, Magazine> {
    // **************************************************************************************************
    // Static properties
    // **************************************************************************************************

    private static final Logger LOGGER = LoggerFactory.getLogger(MagazineController.class);

    // **************************************************************************************************
    // Properties
    // **************************************************************************************************
    @Autowired
    private IMagazineService service;

    @Autowired
    private IMagazineDtoConverter converter;

    // **************************************************************************************************
    // Constructors
    // **************************************************************************************************
    // **************************************************************************************************
    // Business methods
    // **************************************************************************************************
    //-------------------Retrieve All Magazines--------------------------------------------------------
    @RequestMapping(value = "/data/magazine/list", method = RequestMethod.GET)
    @ResponseBody
    public MappingJacksonValue onList(@RequestParam(defaultValue = "0") int offset, @RequestParam(defaultValue = "20") int limit,
	    @RequestParam(defaultValue = "enum") String action, @RequestParam(defaultValue = "") String query, @RequestParam(defaultValue = "") String callback) {
	ResponseDto<List<MagazineDto>> message = new ResponseDto<>();
	MappingJacksonValue response = new MappingJacksonValue(message);

	try {
	    List<Filter> filters = new ArrayList<>(0);
	    List<MagazineDto> magazines = new ArrayList<>(0);

	    if (REQUEST_QUERY.equals(action)) {
		filters.add(new Filter("title", query, Filter.COMPARATOR.LIKE));
		filters.add(new Filter("description", query, Filter.COMPARATOR.LIKE));
	    }

	    int total = count(filters);

	    if (total > 0) {
		magazines = find(filters, offset, Math.min(total, limit));
	    }

	    message.setTotal(total);
	    message.setResult(magazines);

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
    public IMagazineService getService() {
	return service;
    }

    public void setService(IMagazineService service) {
	this.service = service;
    }

    @Override
    public IMagazineDtoConverter getConverter() {
	return converter;
    }

    public void setConverter(IMagazineDtoConverter converter) {
	this.converter = converter;
    }
}
