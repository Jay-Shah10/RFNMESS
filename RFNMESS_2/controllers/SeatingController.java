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
public class SeatingController implements Controller {
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
	
	public ArrayList<Table> getTables() {
		return model.getTables();
	}
	
	public void assignPartyToTable(Table t, Party p) {
		t.setAssignedParty(p);
	}
	
	public void updateTableStatus(Table t, TableStatus s) {
		t.setStatus(s);
	}

}
