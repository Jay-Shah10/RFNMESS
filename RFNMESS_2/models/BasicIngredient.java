/**
 * 
 */
package models;

import java.io.Serializable;

/**
 * @author nryle
 *
 */
public class BasicIngredient implements Ingredient, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7326780363329134768L;

	private String					name,
									description;
									
	private double					price;
	
	/**
	 * @param string
	 * @param d
	 * @param string2
	 */
	public BasicIngredient(String name, double price, String desc) {
		this.name = name;
		this.price = price;
		this.description = desc;
	}

	/* (non-Javadoc)
	 * @see models.Ingredient#getName()
	 */
	@Override
	public String getName() {
		return name;
	}

	/* (non-Javadoc)
	 * @see models.Ingredient#setName(java.lang.String)
	 */
	@Override
	public void setName(String name) {
		this.name = name;
	}

	/* (non-Javadoc)
	 * @see models.Ingredient#getDescription()
	 */
	@Override
	public String getDescription() {
		return description;
	}

	/* (non-Javadoc)
	 * @see models.Ingredient#setDescription(java.lang.String)
	 */
	@Override
	public void setDescription(String desc) {
		this.description = desc;
	}

	/* (non-Javadoc)
	 * @see models.Ingredient#getPrice()
	 */
	@Override
	public double getPrice() {
		return price;
	}

	/* (non-Javadoc)
	 * @see models.Ingredient#setPrice(double)
	 */
	@Override
	public void setPrice(double p) {
		this.price = p;
	}

	/* (non-Javadoc)
	 * @see models.Ingredient#createCopy()
	 */
	@Override
	public Ingredient createCopy() {
		// TODO Auto-generated method stub
		try {
			return (Ingredient)(this.clone());
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
