/**
 * 
 */
package views;

import gui.SearchBox;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import models.Party;
import models.Table;

/**
 * @author nryle
 *
 */
public class OrderView implements View {
	private VBox 		itemToOrderMenu,
						orderMenu;
	
	private HBox 		center;

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
	
	public OrderView() {
		initItemToOrderMenu();
		initOrderMenu();
		
		center = new HBox();
		center.setSpacing(20);
		
		setCenterToOrdering();
	}
	
	private void setCenterToOrdering() {
		center.getChildren().clear();
		center.getChildren().add(itemToOrderMenu);
		center.getChildren().add(orderMenu);
	}
	
	
	private void initItemToOrderMenu() {
		itemToOrderMenu = new VBox();
		itemToOrderMenu.getStyleClass().add("pane");
		HBox.setHgrow(itemToOrderMenu, Priority.ALWAYS);
		
		SearchBox searchBox = new SearchBox();
		itemToOrderMenu.getChildren().add(searchBox);
		
		TabPane tabs = new TabPane();
		tabs.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);
		
		Tab 	tabDrinks = new Tab("Drinks"),
				tabAppetizers = new Tab("Appetizers"),
				tabEntrees = new Tab("Entrees"),
				tabDesserts = new Tab("Desserts");
		tabs.getTabs().add(tabDrinks);
		tabs.getTabs().add(tabAppetizers);
		tabs.getTabs().add(tabEntrees);
		tabs.getTabs().add(tabDesserts);
		
		ListView<MenuItem> 	drinksList = new ListView<>(),
							appetizersList = new ListView<>(),
							entreesList = new ListView<>(),
							dessertsList = new ListView<>();
		
		tabDrinks.setContent(drinksList);
		tabAppetizers.setContent(appetizersList);
		tabEntrees.setContent(entreesList);
		tabDesserts.setContent(dessertsList);
		
		itemToOrderMenu.getChildren().add(tabs);
		
		HBox buttons = new HBox();
		buttons.setAlignment(Pos.CENTER);
		Button btnAdd = new Button("Add Item");
		buttons.getChildren().add(btnAdd);
		itemToOrderMenu.getChildren().add(buttons);
		
		VBox.setVgrow(tabs, Priority.ALWAYS);
	}
	
	private void initOrderMenu() {
		orderMenu = new VBox();
		orderMenu.getStyleClass().add("pane");
		HBox.setHgrow(orderMenu, Priority.ALWAYS);
		
		HBox topControls = new HBox();
		topControls.setAlignment(Pos.CENTER);
		{
			ComboBox<Table> tableList = new ComboBox<>();
			topControls.getChildren().add(tableList);
			
			ComboBox<Party> partyList = new ComboBox<>();
			topControls.getChildren().add(partyList);
		}
		orderMenu.getChildren().add(topControls);
		
		ListView<MenuItem> itemList = new ListView<>();
		orderMenu.getChildren().add(itemList);
		VBox.setVgrow(itemList, Priority.ALWAYS);
		
		HBox bottomControls = new HBox();
		{
			Button btnRemoveItem = new Button("Remove");
			bottomControls.getChildren().add(btnRemoveItem);
			
			Button btnGenerateBill = new Button("Generate Bill");
			bottomControls.getChildren().add(btnGenerateBill);
		}
		orderMenu.getChildren().add(bottomControls);
		
	}

}
