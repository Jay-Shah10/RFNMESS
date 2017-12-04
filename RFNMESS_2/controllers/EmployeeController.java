/**
 * 
 */
package controllers;

import java.util.List;

import models.AccessLevel;
import models.Employee;
import models.EmployeeUser;
import models.Restaurant;

/**
 * @author nryle
 *
 */
public class EmployeeController implements Controller {
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

	public List<Employee> getEmployees() {
		return model.getEmployees();
	}
	
	public Employee createEmployee(String username, String password, AccessLevel access) {
		Employee e = new EmployeeUser(username, access);
		e.setPassword(password);
		model.getEmployees().add(e);
		return e;
	}
	
	public Employee createEmployee(String username, String password, AccessLevel access, String firstName, String lastName) {
		Employee e = createEmployee(username, password, access);
		e.setFirstName(firstName);
		e.setLastName(lastName);
		return e;
	}
	
	public void updateEmployee(Employee e, String username, String password, AccessLevel access, String firstName, String lastName) {
		e.setUsername(username);
		if (password != null && !password.trim().isEmpty()) {
			e.setPassword(password);
		}
		e.setAccessLevel(access);
		e.setFirstName(firstName);
		e.setLastName(lastName);
	}
	
	public boolean deleteEmployee(Employee e) {
		return model.getEmployees().remove(e);
	}
}
