/**
 * 
 */
package models;

import java.util.ArrayList;

/**
 * @author nryle
 *
 */
public interface Order {
	int						getUid();
	void					setUid(int uid);
	
	String					getName();
	void					setName(String n);
	
	boolean					getBilled();
	void					setBilled(boolean b);
	
	boolean					isFulfilled();
	void					setFulfilled(boolean b);
	
	ArrayList<MenuItem>		getMenuItems();
}
