package pf.rutorai.sl.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * All recipe metadata will be represented by this class.
 *
 * @version 1.0.0
 */
@Entity
@Table(name = "T_RECIPE")
public class RecipeModel {

    // **************************************************************************************************
    // Static properties
    // **************************************************************************************************
    private static final Logger LOGGER = LoggerFactory.getLogger(RecipeModel.class);

    // **************************************************************************************************
    // Properties
    // **************************************************************************************************
    /**
     * Identifier of the recipe.
     */
    @Id
    @Column(name = "identifier")
    private Long identifier;

    /**
     * Title of the recipe.
     */
    @Column(name = "title", length = 128, nullable = false)
    private String title;

    /**
     * Description of the recipe.
     */
    @Column(name = "description", length = 512, nullable = false)
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
