/**
 * 
 */
package models;

import java.util.ArrayList;

/**
 * @author nryle
 *
 */
public class Restaurant {
	private ArrayList<Table> tables;
	private ArrayList<Employee> employees;
	private ArrayList<MenuItem> menu;
	private ArrayList<Ingredient> ingredients;
	
	public Restaurant() {
		tables = new ArrayList<>();
		employees = new ArrayList<>();
		
	}
	/**
	 * @return the tables
	 */
	public ArrayList<Table> getTables() {
		return tables;
	}

	/**
	 * @param tables the tables to set
	 */
	public void setTables(ArrayList<Table> tables) {
		this.tables = tables;
	}
	
	public static Restaurant getRestaurant() {
		// TODO: Load from file, remove test code
		
		Restaurant r = new Restaurant();
		
		// TEST CODE
		ArrayList<Table> testList = new ArrayList<Table>();
		for(int i = 1; i < 12; i++) {
			Table t = new Table(i);
			t.setName("Table " + String.valueOf(i));
			t.setStatus(TableStatus.Open);
			testList.add(t);
		}
		r.setTables(testList);
		
		
		
		return r;
	}
}
