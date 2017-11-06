/**
 * 
 */
package controllers;

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

}
