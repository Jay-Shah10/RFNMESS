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
		
		switch(username.toLowerCase()) {
			case "kitchen":
				emp.setAccessLevel(AccessLevel.Kitchen);
				break;
			case "order":
			case "server":
				emp.setAccessLevel(AccessLevel.Server);
				break;
			case "host":
				emp.setAccessLevel(AccessLevel.Host);
				break;
			default: 
				emp.setAccessLevel(AccessLevel.MasterAdmin);
				break;
		}
		
		return emp;
	}
}
