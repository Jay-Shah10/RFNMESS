/**
 * 
 */
package events;

import javafx.event.Event;
import javafx.event.EventTarget;
import javafx.event.EventType;
import models.AccessLevel;
import models.Employee;

/**
 * @author nryle
 *
 */
public class EmployeeEvent extends Event {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2757982907014401607L;

	private Employee 		employee;
	
	private String			username,
							firstname,
							lastname,
							password;
	
	private AccessLevel 	access;
	
	public static final EventType<EmployeeEvent> CREATE_EMPLOYEE = new EventType<>(Event.ANY, "CREATE_EMPLOYEE");
	public static final EventType<EmployeeEvent> UPDATE_EMPLOYEE = new EventType<>(Event.ANY, "UPDATE_EMPLOYEE");
	public static final EventType<EmployeeEvent> DELETE_EMPLOYEE = new EventType<>(Event.ANY, "DELETE_EMPLOYEE");
	
	/**
	 * @param arg0
	 */
	public EmployeeEvent(EventType<? extends Event> arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param arg0
	 * @param arg1
	 * @param arg2
	 */
	public EmployeeEvent(Object arg0, EventTarget arg1, EventType<? extends Event> arg2) {
		super(arg0, arg1, arg2);
		// TODO Auto-generated constructor stub
	}
	
	public EmployeeEvent(Employee employee, EventTarget arg1, EventType<? extends Event> arg2) {
		super(employee, arg1, arg2);
		// TODO Auto-generated constructor stub
		this.setEmployee(employee);
	}

	/**
	 * @return the employee
	 */
	public Employee getEmployee() {
		return employee;
	}

	/**
	 * @param employee the employee to set
	 */
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * @param firstname the firstname to set
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/**
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * @param lastname the lastname to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the access
	 */
	public AccessLevel getAccess() {
		return access;
	}

	/**
	 * @param access the access to set
	 */
	public void setAccess(AccessLevel access) {
		this.access = access;
	}

}

