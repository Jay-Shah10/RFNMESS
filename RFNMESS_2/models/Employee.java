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
	
	public String getPassword();
	public void setPassword(String password);
	
	public String getFirstName();
	public void setFirstName(String firstName);

	public String getLastName();
	public void setLastName(String lastName);
}
