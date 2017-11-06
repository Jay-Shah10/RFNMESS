/**
 * 
 */
package events;

import javafx.event.Event;
import javafx.event.EventTarget;
import javafx.event.EventType;
import models.*;

/**
 * @author nryle
 *
 */
public class OrderEvent extends Event {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2284781170081650717L;
	
	private Table table;
	private Order order;
	private MenuItem item;
	private Ingredient ingredient;
	
	public static final EventType<OrderEvent> NEW_ORDER = new EventType<>(Event.ANY, "NEW_ORDER");
	public static final EventType<OrderEvent> ITEM_ADDED = new EventType<>(Event.ANY, "ITEM_ADDED");
	public static final EventType<OrderEvent> ITEM_REMOVED = new EventType<>(Event.ANY, "ITEM_REMOVED");
	public static final EventType<OrderEvent> ORDER_BILLED = new EventType<>(Event.ANY, "ORDER_BILLED");
	public static final EventType<OrderEvent> ORDER_FULFILLED = new EventType<>(Event.ANY, "ORDER_FULFILLED");
	
	/**
	 * @param source
	 * @param target
	 * @param eventType
	 */
	public OrderEvent(Object source, EventTarget target, EventType<? extends Event> eventType) {
		super(source, target, eventType);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the table
	 */
	public Table getTable() {
		return table;
	}

	/**
	 * @param table the table to set
	 */
	public void setTable(Table table) {
		this.table = table;
	}

	/**
	 * @return the order
	 */
	public Order getOrder() {
		return order;
	}

	/**
	 * @param order the order to set
	 */
	public void setOrder(Order order) {
		this.order = order;
	}

	/**
	 * @return the item
	 */
	public MenuItem getItem() {
		return item;
	}

	/**
	 * @param item the item to set
	 */
	public void setItem(MenuItem item) {
		this.item = item;
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
}
