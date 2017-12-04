/**
 * 
 */
package views;

import java.util.ArrayList;

import events.OrderEvent;
import gui.NodeList;
import gui.NodeListItem;
import gui.SearchBox;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.*;
import models.*;
import models.MenuItem;

/**
 * @author nryle
 *
 */
public class OrderView implements View {
	private VBox 						itemToOrderMenu,
										orderMenu;
	
	private HBox 						center;
	
	private ComboBox<Order> 			orderList;
	private ComboBox<Table> 			tableList;
	private NodeList<MenuItem> 			itemList;
	private NodeList<MenuItem> 			drinksList,
										appetizersList,
										entreesList,
										dessertsList;

	private SearchBox 					searchBox;
	
	

	/* (non-Javadoc)
	 * @see views.View#getCenter()
	 */
	@Override
	public Node getCenter() {
		// TODO Auto-generated method stub
		refreshCenter();
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
	
	
	@SuppressWarnings("unchecked")
	private void initItemToOrderMenu() {
		itemToOrderMenu = new VBox(15);
		itemToOrderMenu.getStyleClass().add("pane");
		HBox.setHgrow(itemToOrderMenu, Priority.ALWAYS);
		
		searchBox = new SearchBox();
		// TODO: Make Search work
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
		
		drinksList = new NodeList<>();
		appetizersList = new NodeList<>();
		entreesList = new NodeList<>();
		dessertsList = new NodeList<>();
		
		populateDrinks(Restaurant.getRestaurant().getDrinks());
		populateAppetizers(Restaurant.getRestaurant().getAppetizers());
		populateEntrees(Restaurant.getRestaurant().getEntrees());
		populateDesserts(Restaurant.getRestaurant().getDesserts());
		
		tabDrinks.setContent(drinksList);
		tabAppetizers.setContent(appetizersList);
		tabEntrees.setContent(entreesList);
		tabDesserts.setContent(dessertsList);
		
		itemToOrderMenu.getChildren().add(tabs);
		
//		HBox buttons = new HBox();
//		buttons.setAlignment(Pos.CENTER);
//		{
//			Button btnAdd = new Button("Add Item");
//			buttons.getChildren().add(btnAdd);
//			btnAdd.setOnAction(
//				(event) -> {
//					OrderEvent evt = new OrderEvent(null, btnAdd, OrderEvent.ITEM_ADDED);
//					
//					evt.setItem(((NodeList<MenuItem>)tabs.getSelectionModel().getSelectedItem().getContent()).getSelectedItem());
//					evt.setTable(this.tableList.getSelectionModel().getSelectedItem());
//					evt.setOrder(this.orderList.getSelectionModel().getSelectedItem());
//					this.orderMenu.fireEvent(evt);
//				}
//			);
//		}
//		itemToOrderMenu.getChildren().add(buttons);
		
		VBox.setVgrow(tabs, Priority.ALWAYS);
	}
	
	private void initOrderMenu() {
		orderMenu = new VBox(15);
		orderMenu.getStyleClass().add("pane");
		HBox.setHgrow(orderMenu, Priority.ALWAYS);
		
		HBox topControls = new HBox(30);
		topControls.setAlignment(Pos.CENTER);
		{
			tableList = new ComboBox<>();
			tableList.setPromptText("Select Table");
			topControls.getChildren().add(tableList);
			tableList.setOnAction(
				(event) -> {
					this.populateOrderList();
					this.orderList.getSelectionModel().select(0);
					this.populateOrderItemsList();
				}
			);
			
			orderList = new ComboBox<>();
			orderList.setPromptText("Select Order");
			topControls.getChildren().add(orderList);
			orderList.setOnAction(
				(event) -> {
					this.populateOrderItemsList();
				}
			);
			
			HBox.setHgrow(tableList, Priority.ALWAYS);
			HBox.setHgrow(orderList, Priority.ALWAYS);
		}
		orderMenu.getChildren().add(topControls);
		
		itemList = new NodeList<>();
		orderMenu.getChildren().add(itemList);
		VBox.setVgrow(itemList, Priority.ALWAYS);
		
		HBox bottomControls = new HBox();
		{
			/*Button btnRemoveItem = new Button("Remove");
			bottomControls.getChildren().add(btnRemoveItem);
			btnRemoveItem.setOnAction(
				(event) -> {
					OrderEvent evt = new OrderEvent(null, btnRemoveItem, OrderEvent.ITEM_REMOVED);
					evt.setItem(this.itemList.getSelectionModel().getSelectedItem());
					evt.setTable(this.tableList.getSelectionModel().getSelectedItem());
					evt.setOrder(this.orderList.getSelectionModel().getSelectedItem());
					this.orderMenu.fireEvent(evt);
				}
			);*/
			
			Button btnGenerateBill = new Button("Generate Bill");
			bottomControls.getChildren().add(btnGenerateBill);
			btnGenerateBill.setOnAction(
				(event) -> {
					Order selectedOrder = this.orderList.getSelectionModel().getSelectedItem();
					if(selectedOrder != null) {
						OrderEvent evt = new OrderEvent(null, btnGenerateBill, OrderEvent.ORDER_BILLED);
						evt.setTable(this.tableList.getSelectionModel().getSelectedItem());
						evt.setOrder(selectedOrder);
						this.orderMenu.fireEvent(evt);						
					} else {
						Alert a = new Alert(AlertType.ERROR, "Must Select Order", ButtonType.OK);
						a.show();
					}
				}
			);
			
			Button btnCreateNewOrder = new Button("Create New Order");
			bottomControls.getChildren().add(btnCreateNewOrder);
			btnCreateNewOrder.setOnAction(
				(event) -> {
					Table selectedTable = this.tableList.getSelectionModel().getSelectedItem();
					if(selectedTable != null) {
						OrderEvent evt = new OrderEvent(null, btnCreateNewOrder, OrderEvent.NEW_ORDER);
						evt.setTable(selectedTable);
						this.orderMenu.fireEvent(evt);						
					} else {
						Alert a = new Alert(AlertType.ERROR, "Must Select Table", ButtonType.OK);
						a.show();
					}
					
				}
			);
		}
		bottomControls.setAlignment(Pos.CENTER);
		orderMenu.getChildren().add(bottomControls);
		
	}
	
	private void refreshCenter() {
		populateTableList(Restaurant.getRestaurant().getTables());
	}
	
	public void refreshOrderMenuOrderList() {
		Table t = tableList.getSelectionModel().getSelectedItem();
		if(t != null) {
			if(t.getAssignedParty() != null) {
				populateOrderList(t.getAssignedParty().getOrders());				
			} else {
				Alert a = new Alert(AlertType.ERROR, "Table must have assigned party.", ButtonType.OK);
				a.show();
			}
		} else {
			Alert a = new Alert(AlertType.ERROR, "Must have table selected.", ButtonType.OK);
			a.show();
		}
	}
	
	public void setSelectedOrder(Order o) {
		orderList.getSelectionModel().select(o);
		populateOrderItemsList();
	}
	
	public void populateTableList(ArrayList<Table> tables) {
		tableList.getItems().clear();
		if(tables != null) {
			for (Table table : tables) {
				tableList.getItems().add(table);
			}			
		}
	}
	
	public void populateOrderList(ArrayList<Order> orders) {
		orderList.getItems().clear();
		if(orders != null) {
			for (Order order : orders) {
				orderList.getItems().add(order);
			}			
		}
	}
	
	public void populateOrderList() {
		Table t = tableList.getValue();
		if(t == null) {
			populateOrderList(null);
		} else {
			Party p = t.getAssignedParty();
			if(p == null) {
				populateOrderList(null);
			} else {
				ArrayList<Order> orders = p.getOrders();
				populateOrderList(orders);				
			}
		}
	}
	
	public void populateDrinks(ArrayList<MenuItem> items ) {
		drinksList.clear();
		for (MenuItem menuItem : items) {
			NodeListItem<MenuItem> a = drinksList.add(menuItem, true, false, false, null);
			a.setOnAdd((event) -> {
				OrderEvent evt = new OrderEvent(menuItem, this.orderMenu, OrderEvent.ITEM_ADDED);
				evt.setItem(menuItem);
				evt.setTable(this.tableList.getSelectionModel().getSelectedItem());
				evt.setOrder(this.orderList.getSelectionModel().getSelectedItem());
				this.orderMenu.fireEvent(evt);
			});
		}
	}
	
	public void populateAppetizers(ArrayList<MenuItem> items ) {
		appetizersList.clear();
		for (MenuItem menuItem : items) {
			NodeListItem<MenuItem> a = appetizersList.add(menuItem, true, false, false, null);
			a.setOnAdd((event) -> {
				OrderEvent evt = new OrderEvent(menuItem, this.orderMenu, OrderEvent.ITEM_ADDED);
				evt.setItem(menuItem);
				evt.setTable(this.tableList.getSelectionModel().getSelectedItem());
				evt.setOrder(this.orderList.getSelectionModel().getSelectedItem());
				this.orderMenu.fireEvent(evt);
			});
		}
	}
	
	public void populateEntrees(ArrayList<MenuItem> items ) {
		entreesList.clear();
		for (MenuItem menuItem : items) {
			NodeListItem<MenuItem> a = entreesList.add(menuItem, true, false, false, null);
			a.setOnAdd((event) -> {
				OrderEvent evt = new OrderEvent(menuItem, this.orderMenu, OrderEvent.ITEM_ADDED);
				evt.setItem(menuItem);
				evt.setTable(this.tableList.getSelectionModel().getSelectedItem());
				evt.setOrder(this.orderList.getSelectionModel().getSelectedItem());
				this.orderMenu.fireEvent(evt);
			});
		}
	}
	
	public void populateDesserts(ArrayList<MenuItem> items ) {
		dessertsList.clear();
		for (MenuItem menuItem : items) {
			NodeListItem<MenuItem> a = dessertsList.add(menuItem, true, false, false, null);
			a.setOnAdd((event) -> {
				OrderEvent evt = new OrderEvent(menuItem, this.orderMenu, OrderEvent.ITEM_ADDED);
				evt.setItem(menuItem);
				evt.setTable(this.tableList.getSelectionModel().getSelectedItem());
				evt.setOrder(this.orderList.getSelectionModel().getSelectedItem());
				this.orderMenu.fireEvent(evt);
			});
		}
	}
	
	public void populateOrderItemsList(ArrayList<MenuItem> items) {
		itemList.clear();
		if(items != null) {
			for (MenuItem menuItem : items) {
				NodeListItem<MenuItem> a = itemList.add(menuItem, false, true, false, null);
				a.setOnRemove((event) -> {
					OrderEvent evt = new OrderEvent(menuItem, this.orderMenu, OrderEvent.ITEM_REMOVED);
					evt.setItem(menuItem);
					evt.setTable(this.tableList.getSelectionModel().getSelectedItem());
					evt.setOrder(this.orderList.getSelectionModel().getSelectedItem());
					this.orderMenu.fireEvent(evt);
				});
			}			
		}
	}
	
	public void populateOrderItemsList() {
		if (orderList.getValue()==null) {
			populateOrderItemsList(null);
		} else {
			ArrayList<MenuItem> items = orderList.getValue().getMenuItems();
			populateOrderItemsList(items);			
		}
	}
	
	public void setOnNewOrder(EventHandler<OrderEvent> e) {
		this.orderMenu.addEventHandler(OrderEvent.NEW_ORDER, e);
	}
	
	public void setOnItemAdded(EventHandler<OrderEvent> e) {
		this.orderMenu.addEventHandler(OrderEvent.ITEM_ADDED, e);
	}
	
	public void setOnItemRemoved(EventHandler<OrderEvent> e) {
		this.orderMenu.addEventHandler(OrderEvent.ITEM_REMOVED, e);
	}
	
	public void setOnOrderBilled(EventHandler<OrderEvent> e) {
		this.orderMenu.addEventHandler(OrderEvent.ORDER_BILLED, e);
	}
	
	public void setOnSearch(EventHandler<ActionEvent> eh) {
		searchBox.setOnSearch(eh);
	}
	public String getSearchText() {
		return searchBox.getText();
	}

}
