/**
 * 
 */
package controllers;

import models.AccessLevel;
import models.Employee;

/**
 * @author nryle
 *
 */
public class LoginController implements Controller {
	private Employee 					currentUser;
	
	/* (non-Javadoc)
	 * @see controllers.Controller#start()
	 */
	@Override
	public void start() {
		// TODO Auto-generated method stub
		currentUser = null;
	}
	
	public Employee AuthenticateUser(String username, String password) throws Exception {
		if(currentUser!=null)
			throw new Exception("User already logged in.");
		
		currentUser = Employee.getUserByLogin(username, password);
		
		return currentUser;
	}
	
	public void Logout() {
		currentUser = null;
	}
	
	public AccessLevel getCurrentAccessLevel() throws Exception {
		if(currentUser == null)
			throw new Exception("No current user.");
		return currentUser.getAccessLevel();
	}

}
