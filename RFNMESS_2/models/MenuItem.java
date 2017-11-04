/**
 * 
 */
package models;

/**
 * @author nryle
 *
 */
public class MenuItem {

	private String 		name, 
						description;
	
	/**
	 * 
	 */
	public MenuItem() {
		// TODO Auto-generated constructor stub
	}
	
	public MenuItem(String name) {
		this();
		this.name = name;
	}
	
	public MenuItem(String name, String desc) {
		this(name);
		this.description = desc;
	}
	
	@Override
	public String toString() {
		return name;
	}

}
