/**
 * 
 */
package models;

import java.util.ArrayList;

/**
 * @author nryle
 *
 */
public class PartyOrder implements Order {
	private String					name;
	private int						uid;
	private ArrayList<MenuItem>		items;
	private boolean					isBilled,
									isFulfilled;
	
	/**
	 * 
	 */
	public PartyOrder() {
		items = new ArrayList<>();
		isBilled = false;
		setFulfilled(false);
	}
	
	/* (non-Javadoc)
	 * @see models.Order#getUid()
	 */
	@Override
	public int getUid() {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see models.Order#setUid(int)
	 */
	@Override
	public void setUid(int uid) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see models.Order#getMenuItems()
	 */
	@Override
	public ArrayList<MenuItem> getMenuItems() {
		// TODO Auto-generated method stub
		return items;
	}

	/* (non-Javadoc)
	 * @see models.Order#getName()
	 */
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	/* (non-Javadoc)
	 * @see models.Order#setName(java.lang.String)
	 */
	@Override
	public void setName(String n) {
		// TODO Auto-generated method stub
		this.name = n;
	}
	
	@Override
	public String toString() {
		if(this.getBilled()) {
			return this.getName() + " - Billed";
		}
		if(this.isFulfilled()) {
			return this.getName() + " - Fulfilled";
		}
		return this.getName();
	}

	/* (non-Javadoc)
	 * @see models.Order#getBilled()
	 */
	@Override
	public boolean getBilled() {
		// TODO Auto-generated method stub
		return isBilled;
	}

	/* (non-Javadoc)
	 * @see models.Order#setBilled(boolean)
	 */
	@Override
	public void setBilled(boolean b) {
		isBilled = b;
	}

	/**
	 * @return the isFulfilled
	 */
	public boolean isFulfilled() {
		return isFulfilled;
	}

	/**
	 * @param isFulfilled the isFulfilled to set
	 */
	public void setFulfilled(boolean isFulfilled) {
		this.isFulfilled = isFulfilled;
	}

}
