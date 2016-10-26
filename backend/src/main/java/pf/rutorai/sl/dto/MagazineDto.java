package pf.rutorai.sl.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * All magazine metadata will be represented by this class.
 *
 * @version 1.0.0
 */
public class MagazineDto {

    // **************************************************************************************************
    // Static properties
    // **************************************************************************************************
    private static final Logger LOGGER = LoggerFactory.getLogger(MagazineDto.class);

    // **************************************************************************************************
    // Properties
    // **************************************************************************************************
    /**
     * Identifier of the magazine.
     */
    private Long identifier;

    /**
     * Title of the magazine.
     */
    private String title;

    /**
     * Description of the magazine.
     */
    private String description;

    // **************************************************************************************************
    // Constructors
    // **************************************************************************************************
    // **************************************************************************************************
    // Business methods
    // **************************************************************************************************
    // **************************************************************************************************
    // Getters & Setters
    // **************************************************************************************************
    public Long getIdentifier() {
	return identifier;
    }

    public void setIdentifier(Long identifier) {
	this.identifier = identifier;
    }

    public String getTitle() {
	return title;
    }

    public void setTitle(String title) {
	this.title = title;
    }

    public String getDescription() {
	return description;
    }

    public void setDescription(String description) {
	this.description = description;
    }
}
