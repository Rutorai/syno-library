package pf.rutorai.sl.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pf.rutorai.sl.converter.ifaces.IMagazineEntityConverter;
import pf.rutorai.sl.dao.AbstractDao;
import pf.rutorai.sl.dao.ifaces.IMagazineDao;
import pf.rutorai.sl.model.MagazineModel;
import pf.rutorai.sl.vo.Magazine;

/**
 * Implementation of the Magazine DAO.
 *
 * @version 1.0.0
 */
@Repository
public class MagazineDaoImpl extends AbstractDao<Magazine, MagazineModel> implements IMagazineDao {

    // ************************************************************************************************************
    // Static properties
    // ************************************************************************************************************
    private static final Logger LOGGER = LoggerFactory.getLogger(MagazineDaoImpl.class);

    // ************************************************************************************************************
    // Properties
    // ************************************************************************************************************
    @Autowired
    private IMagazineEntityConverter magazineConverter;

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
    public IMagazineEntityConverter getConverter() {
	return magazineConverter;
    }

    public void setConverter(IMagazineEntityConverter magazineConverter) {
	this.magazineConverter = magazineConverter;
    }
}
