/**
 * 
 */
package models;

import java.io.Serializable;
import java.util.Random;

/**
 * @author nryle
 *
 */
public class Table implements Serializable {
	private int uid;
	private String				name;
	private TableStatus			status;
	private Party				currentParty;
	private Integer				x, y;

	/**
	 * @return the uid
	 */
	public int getUid() {
		return uid;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the status
	 */
	public TableStatus getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(TableStatus status) {
		this.status = status;
	}

	/**
	 * @return the currentParty
	 */
	public Party getAssignedParty() {
		return currentParty;
	}

	/**
	 * @param currentParty the currentParty to set
	 */
	public void setAssignedParty(Party currentParty) {
		this.currentParty = currentParty;
	}

	/**
	 * @return the x
	 */
	public Integer getXPosition() {
		return x;
	}

	/**
	 * @param x the x to set
	 */
	public void setXPosition(Integer x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public Integer getYPosition() {
		return y;
	}

	/**
	 * @param y the y to set
	 */
	public void setYPosition(Integer y) {
		this.y = y;
	}

	public Table() {
		Random r = new Random();
		uid = r.nextInt();
	}
	
	public Table(int uid) {
		this.uid = uid;
	}
	
	@Override
	public int hashCode() {
		return uid;
	}
	
	@Override
	public String toString() {
		if(this.currentParty==null)
			return this.name;
		return this.name + ": " + this.currentParty.getName();
	}
}
