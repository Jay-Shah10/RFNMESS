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
	private ArrayList<Table> 			tables;
	private ArrayList<Employee> 		employees;
	private ArrayList<MenuItem> 		drinksMenu,
										appetizersMenu,
										entreesMenu,
										dessertsMenu;
	private ArrayList<Ingredient> 		ingredients;
	private static Restaurant 			restaurant = null;
	
	public Restaurant() {
		tables = new ArrayList<>();
		employees = new ArrayList<>();
		
		drinksMenu = new ArrayList<>();
		appetizersMenu = new ArrayList<>();
		entreesMenu = new ArrayList<>();
		dessertsMenu = new ArrayList<>();
		
		ingredients = new ArrayList<>();
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
	
	public ArrayList<MenuItem> getDrinks() {
		return this.drinksMenu;
	}
	
	public ArrayList<MenuItem> getAppetizers() {
		return this.appetizersMenu;
	}
	
	public ArrayList<MenuItem> getEntrees() {
		return this.entreesMenu;
	}
	
	public ArrayList<MenuItem> getDesserts() {
		return this.dessertsMenu;
	}
	
	public ArrayList<Employee> getEmployees() {
		return this.employees;
	}
	
	public ArrayList<Ingredient> getIngredients() {
		return this.ingredients;
	}
	
	public static Restaurant getRestaurant() {
		// TODO: Load from file, remove test code
		if(Restaurant.restaurant==null) {
			Restaurant r = new Restaurant();
			
			// TEST CODE
			ArrayList<Table> testList = new ArrayList<>();
			for(int i = 1; i < 10; i++) {
				Table t = new Table(i);
				t.setName("Table " + String.valueOf(i));
				t.setStatus(TableStatus.Open);
				testList.add(t);
			}
			r.setTables(testList);
			
			
			r.drinksMenu.add(new MenuItem("Drink1", 1.50, "A drink."));
			r.drinksMenu.add(new MenuItem("Drink2", 1.75, "A drink."));
			r.drinksMenu.add(new MenuItem("Drink3", 1.50, "A drink."));
			
			r.appetizersMenu.add(new MenuItem("Appetizer1", 6.50, "An appetizer."));
			r.appetizersMenu.add(new MenuItem("Appetizer2", 5.50, "An appetizer."));
			r.appetizersMenu.add(new MenuItem("Appetizer2", 6.00, "An appetizer."));
			
			r.entreesMenu.add(new MenuItem("Entree1", 9.00, "An entree."));
			r.entreesMenu.add(new MenuItem("Entree2", 10.00, "An entree."));
			r.entreesMenu.add(new MenuItem("Entree3", 8.75, "An entree."));
			
			r.ingredients.add(new BasicIngredient("Bread", 0.10, "A loaf of bread."));
			r.ingredients.add(new BasicIngredient("Lettuce", 0.02, "A leaf of lettuce."));
			r.ingredients.add(new BasicIngredient("Burger patty", 0.75, "1/8 pound patty of beef"));
			
			r.employees.add(new EmployeeUser("Host1", AccessLevel.Host));
			r.employees.add(new EmployeeUser("Server1", AccessLevel.Server));
			r.employees.add(new EmployeeUser("Kitchen1", AccessLevel.Kitchen));
			EmployeeUser m = new EmployeeUser("Manager1", AccessLevel.Manager);
			m.setPassword("password");
			r.employees.add(m);
			
			Restaurant.restaurant = r;
		}
		
		return Restaurant.restaurant;
	}
}
