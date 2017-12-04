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
public class MenuItemEvent extends Event {

	/**
	 * 
	 */
	private static final long serialVersionUID = -867987826581604617L;

	private MenuItem 			menuItem;
	
	private String				name,
								description;
		
	private MenuItemType 		type;
	
	private List<Ingredient>	ingredientList;
	
	public static final EventType<MenuItemEvent> CREATE_MENUITEM = new EventType<>(Event.ANY, "CREATE_MENUITEM");
	public static final EventType<MenuItemEvent> UPDATE_MENUITEM = new EventType<>(Event.ANY, "UPDATE_MENUITEM");
	public static final EventType<MenuItemEvent> DELETE_MENUITEM = new EventType<>(Event.ANY, "DELETE_MENUITEM");
	
	/**
	 * @param arg0
	 */
	public MenuItemEvent(EventType<? extends Event> arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param arg0
	 * @param arg1
	 * @param arg2
	 */
	public MenuItemEvent(Object arg0, EventTarget arg1, EventType<? extends Event> arg2) {
		super(arg0, arg1, arg2);
		// TODO Auto-generated constructor stub
	}
	
	public MenuItemEvent(MenuItem menuItem, EventTarget arg1, EventType<? extends Event> arg2) {
		super(menuItem, arg1, arg2);
		// TODO Auto-generated constructor stub
		this.setMenuItem(menuItem);
	}

	/**
	 * @return the menuItem
	 */
	public MenuItem getMenuItem() {
		return menuItem;
	}

	/**
	 * @param menuItem the menuItem to set
	 */
	public void setMenuItem(MenuItem menuItem) {
		this.menuItem = menuItem;
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
	 * @return the type
	 */
	public MenuItemType getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(MenuItemType type) {
		this.type = type;
	}

	/**
	 * @return the ingredientList
	 */
	public List<Ingredient> getIngredientList() {
		return ingredientList;
	}

	/**
	 * @param ingredientList the ingredientList to set
	 */
	public void setIngredientList(List<Ingredient> ingredientList) {
		this.ingredientList = ingredientList;
	}

	
}

