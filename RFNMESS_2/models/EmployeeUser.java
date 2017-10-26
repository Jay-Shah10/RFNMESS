/**
 * 
 */
package models;

/**
 * @author nryle
 *
 */
public class EmployeeUser implements Employee {

	private String username;
	private AccessLevel access;
	
	public EmployeeUser() {
		username = null;
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

}
