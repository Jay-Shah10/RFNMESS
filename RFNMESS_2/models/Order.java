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
	
	ArrayList<MenuItem>		getMenuItems();
}
