package pf.rutorai.sl.converter.ifaces;

import java.util.List;
import pf.rutorai.sl.exception.impl.DefaultException;

/**
 * Default DTO converter interface.
 * Define basic converter from/to DTO to/from VO for a single item or a list of items.
 *
 * @param <DTO> DTO type
 * @param <VO>  VO type
 */
public interface IDtoConverter<DTO, VO> {
    // **************************************************************************************************
    // Static properties
    // **************************************************************************************************

    // **************************************************************************************************
    // Business methods
    // **************************************************************************************************
    /**
     * Convert a simple DTO object into a VO one.
     *
     * @param dto DTO item to convert.
     *
     * @return A simple VO object from the DTO one.
     *
     * @throws DefaultException
     */
    public abstract VO toVo(DTO dto) throws DefaultException;

    /**
     * Convert a list of DTO objects into a list of VO ones.
     *
     * @param dtos List of DTO items to convert.
     *
     * @return A list of VO objects from the list of DTO ones.
     *
     * @throws DefaultException
     */
    public abstract List<VO> toVo(List<DTO> dtos) throws DefaultException;

    /**
     * Convert a simple VO object into a DTO one.
     *
     * @param vo VO item to convert.
     *
     * @return A simple DTO object from the VO one.
     *
     * @throws DefaultException
     */
    public abstract DTO toDto(VO vo) throws DefaultException;

    /**
     * Convert a list of VO objects into a list of DTO ones.
     *
     * @param vos List of VO items to convert.
     *
     * @return A list of DTO objects from the list of VO ones.
     *
     * @throws DefaultException
     */
    public abstract List<DTO> toDto(List<VO> vos) throws DefaultException;
}
