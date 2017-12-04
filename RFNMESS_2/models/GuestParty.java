/**
 * 
 */
package models;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author nryle
 *
 */
public class GuestParty implements Party, Serializable {

	private String 					name;
	private ArrayList<Order> 		orders;
	
	public GuestParty() {
		orders = new ArrayList<>();
	}
	
	public GuestParty(String name) {
		this();
		this.setName(name);
	}
	/* (non-Javadoc)
	 * @see models.Party#getUid()
	 */
	@Override
	public int getUid() {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see models.Party#setUid(int)
	 */
	@Override
	public void setUid(int uid) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see models.Party#getName()
	 */
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	/* (non-Javadoc)
	 * @see models.Party#setName(java.lang.String)
	 */
	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		this.name = name;
	}

	/* (non-Javadoc)
	 * @see models.Party#getOrders()
	 */
	@Override
	public ArrayList<Order> getOrders() {
		// TODO Auto-generated method stub
		return orders;
	}

}
