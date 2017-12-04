/**
 * 
 */
package models;

import java.io.Serializable;

/**
 * @author nryle
 *
 */
public interface Ingredient {
	String						getName();
	void						setName(String name);
	
	String						getDescription();
	void						setDescription(String desc);
	
	double						getPrice();
	void						setPrice(double p);
	
	Ingredient					createCopy();
	
	
	public static Ingredient createCopy(Ingredient i) {
		return i.createCopy();
	}
}
