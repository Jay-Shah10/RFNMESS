/**
 * 
 */
package controllers;

import java.util.ArrayList;

import models.*;

/**
 * @author nryle
 *
 */
public class OrderController implements Controller {
	private Restaurant			model;

	/* (non-Javadoc)
	 * @see controllers.Controller#start()
	 */
	@Override
	public void start() {
		// TODO Auto-generated method stub
		start(Restaurant.getRestaurant());
	}
	
	public void start(Restaurant r) {
		model = r;
	}
	
	public Order createNewOrder(Table t) {
		if(t.getAssignedParty()!=null) {
			Order o = new PartyOrder();
			t.getAssignedParty().getOrders().add(o);
			o.setName("Order " + (t.getAssignedParty().getOrders().indexOf(o)+1));
			return o;
		}
		return null;
	}
	
	public void addItemToOrder(Order o, MenuItem i) {
		if(o!= null && i !=null) {
			o.getMenuItems().add(i.createCopy());
			o.setBilled(false);
			o.setFulfilled(false);
		}
	}
	
	public void removeItemFromOrder(Order o, MenuItem i) {
		if(o != null && i != null) {
			o.getMenuItems().remove(i);
		}
	}
	
	public void billOrder(Order o) {
		if(o != null) {
			o.setBilled(true);			
		}
	}

	/**
	 * @param order
	 */
	public void fulfillOrder(Order order) {
		if(order != null) {
			order.setFulfilled(true);
		}
	}
	
	public ArrayList<MenuItem> getMenuItems(MenuItemType type) {
		switch (type) {
		case DRINK:
			return model.getDrinks();
		case APPETIZER:
			return model.getAppetizers();
		case ENTREE:
			return model.getEntrees();
		case DESSERT:
			return model.getDesserts();
		case ALL:
		default:
			ArrayList<MenuItem> items = new ArrayList<>();
			items.addAll(model.getDrinks());
			items.addAll(model.getAppetizers());
			items.addAll(model.getEntrees());
			items.addAll(model.getDesserts());			
			return items;
		}
	}

	public ArrayList<Ingredient> getIngredients() {
		return model.getIngredients();
	}
}
