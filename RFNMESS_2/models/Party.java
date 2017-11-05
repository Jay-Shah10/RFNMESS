/**
 * 
 */
package models;

import java.util.ArrayList;

/**
 * @author nryle
 *
 */
public interface Party {
	int						getUid();
	void					setUid(int uid);
	
	String 					getName();
	void 					setName(String name);
	
	ArrayList<Order> 		getOrders();
	
}
