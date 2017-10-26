/**
 * 
 */
package models;

/**
 * @author nryle
 *
 */
public interface Employee {
	String getUsername();
	void setUsername(String un);
	
	AccessLevel getAccessLevel();
	void setAccessLevel(AccessLevel access);
	
	public static Employee getUserByLogin(String username, String login) {
		// TODO: Fetch Proper user
		Employee emp = new EmployeeUser();
		emp.setUsername("TestUser");
		emp.setAccessLevel(AccessLevel.MasterAdmin);
		
		if(username=="baduser") emp = null;
		
		return emp;
	}
}
