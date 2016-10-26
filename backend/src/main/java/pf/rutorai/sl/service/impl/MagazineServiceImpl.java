package pf.rutorai.sl.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pf.rutorai.sl.dao.ifaces.IMagazineDao;
import pf.rutorai.sl.service.AbstractService;
import pf.rutorai.sl.service.ifaces.IMagazineService;
import pf.rutorai.sl.vo.Magazine;

/**
 * Implementation of the Magazine Service.
 *
 * @version 1.0.0
 */
@Service
public class MagazineServiceImpl extends AbstractService<Magazine> implements IMagazineService {
    // ************************************************************************************************************
    // Static properties
    // ************************************************************************************************************

    private static final Logger LOGGER = LoggerFactory.getLogger(MagazineServiceImpl.class);

    // ************************************************************************************************************
    // Properties
    // ************************************************************************************************************
    @Autowired
    private IMagazineDao magazineDao;

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
    public IMagazineDao getDao() {
	return magazineDao;
    }

    public void setDao(IMagazineDao magazineDao) {
	this.magazineDao = magazineDao;
    }
}
