/**
 * 
 */
package models;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author nryle
 *
 */
public class MenuItem implements Serializable{

	private String 						name, 
										description;
	
	private double						price;
	
	private ArrayList<Ingredient>		ingredients;
	
	/**
	 * 
	 */
	public MenuItem() {
		// TODO Auto-generated constructor stub
		this.ingredients = new ArrayList<>();
	}
	
	public MenuItem(String name) {
		this();
		this.name = name;
	}
	
	public MenuItem(String name, double price) {
		this(name);
		this.price = price;
	}
	
	public MenuItem(String name, double price, String desc) {
		this(name, price);
		this.setDescription(desc);
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

	/**
	 * @return the ingredients
	 */
	public ArrayList<Ingredient> getIngredients() {
		return ingredients;
	}

	/**
	 * @param ingredients the ingredients to set
	 */
	public void setIngredients(ArrayList<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}
	
	public MenuItem createCopy() {
		MenuItem m = new MenuItem(this.name, this.price, this.description);
		for (Ingredient ingredient : this.ingredients) {
			m.ingredients.add(ingredient.createCopy());
		}
		return m;
	}

	@Override
	public String toString() {
		return name;
	}
	
	public static MenuItem createCopy(MenuItem m) {
		return m.createCopy();
	}

}
