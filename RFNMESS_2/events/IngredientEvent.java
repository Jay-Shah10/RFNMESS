/**
 * 
 */
package events;

import java.util.List;

import javafx.event.Event;
import javafx.event.EventTarget;
import javafx.event.EventType;
import models.AccessLevel;
import models.Employee;
import models.Ingredient;
import models.MenuItem;
import models.MenuItemType;

/**
 * @author nryle
 *
 */
public class IngredientEvent extends Event {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4535409219776423571L;

	private Ingredient 			ingredient;
	
	private String				name,
								description;
	
	private double				price;
	
	public static final EventType<IngredientEvent> CREATE_INGREDIENT = new EventType<>(Event.ANY, "CREATE_INGREDIENT");
	public static final EventType<IngredientEvent> UPDATE_INGREDIENT = new EventType<>(Event.ANY, "UPDATE_INGREDIENT");
	public static final EventType<IngredientEvent> DELETE_INGREDIENT = new EventType<>(Event.ANY, "DELETE_INGREDIENT");
	
	/**
	 * @param arg0
	 */
	public IngredientEvent(EventType<? extends Event> arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param arg0
	 * @param arg1
	 * @param arg2
	 */
	public IngredientEvent(Object arg0, EventTarget arg1, EventType<? extends Event> arg2) {
		super(arg0, arg1, arg2);
		// TODO Auto-generated constructor stub
	}
	
	public IngredientEvent(Ingredient ingredient, EventTarget arg1, EventType<? extends Event> arg2) {
		super(ingredient, arg1, arg2);
		// TODO Auto-generated constructor stub
		this.setIngredient(ingredient);
	}

	/**
	 * @return the ingredient
	 */
	public Ingredient getIngredient() {
		return ingredient;
	}

	/**
	 * @param ingredient the ingredient to set
	 */
	public void setIngredient(Ingredient ingredient) {
		this.ingredient = ingredient;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	

	
}

