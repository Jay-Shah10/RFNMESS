/**
 * 
 */
package controllers;

import models.AccessLevel;
import models.Employee;
import models.Restaurant;

/**
 * @author nryle
 *
 */
public class LoginController implements Controller {
	private Employee 					currentUser;
	private Restaurant					model;
	
	/* (non-Javadoc)
	 * @see controllers.Controller#start()
	 */
	@Override
	public void start() {
		// TODO Auto-generated method stub
		start(Restaurant.getRestaurant());
		currentUser = null;
	}
	public void start(Restaurant r) {
		model = r;
	}
	
	public Employee AuthenticateUser(String username, String password) throws Exception {
		if(currentUser!=null)
			throw new Exception("User already logged in.");
		
		for (Employee e : model.getEmployees()) {
			if(e.getUsername().equalsIgnoreCase(username) && (e.getPassword()==null || e.getPassword().equals(password))) {
				currentUser = e;
				return currentUser;
			}
		}
		return currentUser;
	}
	
	public void logout() {
		this.currentUser = null;
	}
	
	public AccessLevel getCurrentAccessLevel() throws Exception {
		if(currentUser == null)
			throw new Exception("No current user.");
		return currentUser.getAccessLevel();
	}

}
