/**
 * 
 */
package models;

/**
 * @author nryle
 *
 */
public class EmployeeUser implements Employee {

	private String 					username,
									password,
									firstName,
									lastName;
	
	private AccessLevel 			access;
	
	public EmployeeUser() {
		username = null;
	}
	
	/**
	 * @param string
	 */
	public EmployeeUser(String username, AccessLevel access) {
		// TODO Auto-generated constructor stub
		this.username = username;
		this.access = access;
	}

	/* (non-Javadoc)
	 * @see models.Employee#getUsername()
	 */
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}

	/* (non-Javadoc)
	 * @see models.Employee#setUsername(java.lang.String)
	 */
	@Override
	public void setUsername(String un) {
		// TODO Auto-generated method stub
		username = un;
	}

	@Override
	public AccessLevel getAccessLevel() {
		// TODO Auto-generated method stub
		return access;
	}

	@Override
	public void setAccessLevel(AccessLevel access) {
		// TODO Auto-generated method stub
		this.access = access;
	}
	
	@Override
	public String toString() {
		return username;
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
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
