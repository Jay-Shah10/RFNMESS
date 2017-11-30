/**
 * 
 */
package views;

import events.OrderEvent;
import gui.SearchBox;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import models.MenuItem;
import models.Ingredient;
import models.Employee;
import models.MenuItem;

/**
 * @author Zaheer Tajani
 *
 */
public class InventoryView implements View {
	
	private VBox itemToOrderInventoryMenu;
	
	private HBox center;
	
	private ListView<Employee>  employeeList;
	private ListView<MenuItem>		menuList;
	private ListView<Ingredient> ingredientList;

	/* (non-Javadoc)
	 * @see views.View#getCenter()
	 */
	@Override
	public Node getCenter() {
		// TODO Auto-generated method stub
		return center;
	}

	/* (non-Javadoc)
	 * @see views.View#getRight()
	 */
	@Override
	public Node getRight() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see views.View#getLeft()
	 */
	@Override
	public Node getLeft() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see views.View#getBottom()
	 */
	@Override
	public Node getBottom() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public InventoryView() {
		initItemToInventoryMenu();
		
		center = new HBox();
		center.setSpacing(20);
		
		setCenterToInventory();
	}
	
	private void setCenterToInventory() {
		center.getChildren().clear();
		center.getChildren().add(itemToOrderInventoryMenu);
	}
	
	@SuppressWarnings("unchecked")
	private void initItemToInventoryMenu() {
		itemToOrderInventoryMenu = new VBox(15);
		itemToOrderInventoryMenu.getStyleClass().add("pane");
		HBox.setHgrow(itemToOrderInventoryMenu, Priority.ALWAYS);
		
		SearchBox searchBox = new SearchBox();
		itemToOrderInventoryMenu.getChildren().add(searchBox);
		
		TabPane tabs = new TabPane();
		tabs.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
		
		Tab		tabEmployee = new Tab("Employee"),
				tabMenu = new Tab("Menu"),
				tabIngredient = new Tab("Ingredient");
		
		tabs.getTabs().add(tabEmployee);
		tabs.getTabs().add(tabMenu);
		tabs.getTabs().add(tabIngredient);
		
		employeeList = new ListView<>();
		menuList = new ListView<>();
		ingredientList = new ListView<>();
		
		tabEmployee.setContent(employeeList);
		tabMenu.setContent(menuList);
		tabIngredient.setContent(ingredientList);
		
		itemToOrderInventoryMenu.getChildren().add(tabs);
		
		HBox button = new HBox();
		button.setAlignment(Pos.CENTER);
		{
			Button btnAdd = new Button("Add Inventory Item");
			button.getChildren().add(btnAdd);
		}
		
		itemToOrderInventoryMenu.getChildren().add(button);
		
		VBox.setVgrow(tabs, Priority.ALWAYS);
				
	}

}
