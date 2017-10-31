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
		if(username.equals("baduser")) { return null; }
		
		// TODO: Fetch Proper user
		Employee emp = new EmployeeUser();
		emp.setUsername("TestUser");
		emp.setAccessLevel(AccessLevel.MasterAdmin);	
		
		return emp;
	}
}
