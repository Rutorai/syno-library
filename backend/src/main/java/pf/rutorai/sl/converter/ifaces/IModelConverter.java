package pf.rutorai.sl.converter.ifaces;

import java.util.List;
import pf.rutorai.sl.exception.impl.DefaultException;

/**
 * Default converter interface.
 * Define basic converter from VO to ENTITY for single or list of items.
 *
 * @param <VO>     VO type
 * @param <ENTITY> ENTITY type
 */
public interface IModelConverter<VO, ENTITY> {
    // **************************************************************************************************
    // Static properties
    // **************************************************************************************************

    // **************************************************************************************************
    // Business methods
    // **************************************************************************************************
    /**
     * Convert a simple ENTITY object into a VO one.
     *
     * @param entity ENTITY item to convert.
     *
     * @return A simple VO object from the ENTITY one.
     *
     * @throws DefaultException
     */
    public abstract VO toVo(ENTITY entity) throws DefaultException;

    /**
     * Convert a list of ENTITY objects into a list of VO ones.
     *
     * @param entities List of ENTITY items to convert.
     *
     * @return A list of VO objects from the list of ENTITY ones.
     *
     * @throws DefaultException
     */
    public abstract List<VO> toVo(List<ENTITY> entities) throws DefaultException;

    /**
     * Convert a simple VO object into a ENTITY one.
     *
     * @param vo VO item to convert.
     *
     * @return A simple ENTITY object from the VO one.
     *
     * @throws DefaultException
     */
    public abstract ENTITY toEntity(VO vo) throws DefaultException;

    /**
     * Convert a list of VO objects into a list of ENTITY ones.
     *
     * @param vos List of VO items to convert.
     *
     * @return A list of ENTITY objects from the list of VO ones.
     *
     * @throws DefaultException
     */
    public abstract List<ENTITY> toEntity(List<VO> vos) throws DefaultException;
}
