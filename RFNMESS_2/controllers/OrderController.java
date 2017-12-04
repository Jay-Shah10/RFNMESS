/**
 * 
 */
package controllers;

import java.util.ArrayList;
import java.util.List;

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
	
	public MenuItem createMenuItem(MenuItemType type, String name, double price, ArrayList<Ingredient> ingredients, String description) {
		MenuItem m = new MenuItem(name, price, description, type);
		m.setIngredients(ingredients);
		switch (type) {
		case DRINK:
			model.getDrinks().add(m);
			break;
		case APPETIZER:
			model.getAppetizers().add(m);
			break;
		case ENTREE:
			model.getEntrees().add(m);
			break;
		case DESSERT:
			model.getDesserts().add(m);
			break;
		default:
			break;
		}
		return m;
	}
	
	public void updateMenuItem(MenuItem m, MenuItemType type, String name, double price, ArrayList<Ingredient> ingredients, String description) {
		m.setName(name);
		m.setPrice(price);
		m.setDescription(description);
		m.setIngredients(ingredients);
		
		if(m.getType() == null || !m.getType().equals(type)) {
			model.getDrinks().remove(m);
			model.getAppetizers().remove(m);
			model.getEntrees().remove(m);
			model.getDesserts().remove(m);
			switch (type) {
			case DRINK:
				model.getDrinks().add(m);
				break;
			case APPETIZER:
				model.getAppetizers().add(m);
				break;
			case ENTREE:
				model.getEntrees().add(m);
				break;
			case DESSERT:
				model.getDesserts().add(m);
				break;
			default:
				break;
			}
			m.setType(type);
		}
	}
	
	public boolean deleteMenuItem(MenuItem m) {
		switch(m.getType()) {
		case DRINK:
			return model.getDrinks().remove(m);
		case APPETIZER:
			return model.getAppetizers().remove(m);
		case ENTREE:
			return model.getEntrees().remove(m);
		case DESSERT:
			return model.getDesserts().remove(m);
			default:
				return 
						model.getDrinks().remove(m) ||
						model.getAppetizers().remove(m) ||
						model.getEntrees().remove(m) ||
						model.getDesserts().remove(m);
		}
	}
	
}
