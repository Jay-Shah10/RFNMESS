/**
 * 
 */
package views;

import java.util.List;
import java.util.Optional;

import events.EmployeeEvent;
import events.MenuItemEvent;
import events.OrderEvent;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import models.AccessLevel;
import models.Employee;
import models.Ingredient;
import models.MenuItem;
import models.MenuItemType;
import gui.NodeList;
import gui.NodeListItem;

/**
 * @author Zaheer Tajani
 *
 */
public class ManagerView implements View {
	private TabPane					center;
	
	private Tab						menuItemTab,
									ingredientTab,
									employeeTab;
	
	private HBox					menuItemPane,
									ingredientPane,
									employeePane;
	
	private ListView<Employee>		employeeList;
	
	private ChoiceBox<AccessLevel> 	employeeAccessLevel;
	private TextField				employeeUsername,
									employeeFirstName,
									employeeLastName,
									employeePassword;
	
	private Button					employeeSave,
									employeeUpdate,
									employeeDelete;
	
	private ListView<MenuItem>		menuItemList;
	private NodeList<Ingredient>	menuItemAllIngredientsList,
									menuItemIngredientsList;
	
	private ChoiceBox<MenuItemType> menuItemMenuType;
	private TextField				menuItemName,
									menuItemDescription,
									menuItemPrice;
	
	private Button					menuItemSave,
									menuItemUpdate,
									menuItemDelete;


	
								

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
	
	public ManagerView() {
		center = new TabPane();
		center.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
		
		initEmployeeTab();
		initMenuItemTab();
		initIngredientTab();
	}
	
	private void initEmployeeTab() {
		employeeTab = new Tab("Employees");
		employeePane = new HBox();
		initTab(employeeTab, employeePane);
		
		VBox left = new VBox();
		employeePane.getChildren().add(left);
		HBox.setHgrow(left, Priority.ALWAYS);
		employeeList = new ListView<>();
		left.getChildren().add(employeeList);
		VBox.setVgrow(employeeList, Priority.ALWAYS);
		
		VBox right = new VBox();
		employeePane.getChildren().add(right);
		HBox.setHgrow(right, Priority.ALWAYS);
		
		HBox accessContainer = new HBox();
		Text accessLabel = new Text("Access Level");
		accessContainer.getChildren().add(accessLabel);
		employeeAccessLevel = new ChoiceBox<AccessLevel>();
		employeeAccessLevel.getItems().addAll(AccessLevel.values());
		accessContainer.getChildren().add(employeeAccessLevel);
		right.getChildren().add(accessContainer);
		
		Text usernameLabel = new Text("Username");
		right.getChildren().add(usernameLabel);
		employeeUsername = new TextField();
		employeeUsername.getStyleClass().add("form-control");
		right.getChildren().add(employeeUsername);
		
		Text firstNameLabel = new Text("First Name");
		right.getChildren().add(firstNameLabel);
		employeeFirstName = new TextField();
		employeeFirstName.getStyleClass().add("form-control");
		right.getChildren().add(employeeFirstName);
		
		Text lastNameLabel = new Text("Last Name");
		right.getChildren().add(lastNameLabel);
		employeeLastName = new TextField();
		employeeLastName.getStyleClass().add("form-control");
		right.getChildren().add(employeeLastName);
		
		Text passwordLabel = new Text("Password");
		right.getChildren().add(passwordLabel);
		employeePassword = new TextField();
		employeePassword.getStyleClass().add("form-control");
		right.getChildren().add(employeePassword);
		
		HBox buttons = new HBox();
		right.getChildren().add(buttons);
		
		employeeSave = new Button("Create New Employee");
		employeeSave.setAlignment(Pos.CENTER_RIGHT);
		employeeSave.getStyleClass().add("form-control");
		buttons.getChildren().add(employeeSave);
		
		Region spacer1 = new Region();
		spacer1.setPrefWidth(15);
		buttons.getChildren().add(spacer1);
		
		employeeUpdate = new Button("Update");
		employeeUpdate.setAlignment(Pos.CENTER_RIGHT);
		employeeUpdate.getStyleClass().add("form-control");
		employeeUpdate.setVisible(false);
		buttons.getChildren().add(employeeUpdate);
		
		Region spacer2 = new Region();
		spacer2.setPrefWidth(15);
		buttons.getChildren().add(spacer2);
		
		employeeDelete = new Button("Delete");
		employeeDelete.setAlignment(Pos.CENTER_RIGHT);
		employeeDelete.getStyleClass().add("form-control");
		employeeDelete.setVisible(false);
		buttons.getChildren().add(employeeDelete);
		
		employeeList.setOnMousePressed(
			(event) -> {
				Employee e = employeeList.getSelectionModel().getSelectedItem();
				if (e == null) {
					employeeUpdate.setVisible(false);
					employeeDelete.setVisible(false);
				} else {
					employeeUpdate.setVisible(true);
					employeeDelete.setVisible(true);
					employeeUsername.setText(e.getUsername());
					employeeFirstName.setText(e.getFirstName());
					employeeLastName.setText(e.getLastName());
					employeePassword.setText("");
					employeeAccessLevel.setValue(e.getAccessLevel());
				}
			}
		);
		
		employeeDelete.setOnAction(
			(event) -> {
				Employee e = employeeList.getSelectionModel().getSelectedItem();
				if (e == null) {
					Alert a = new Alert(AlertType.ERROR, "You have not selected an employee.", ButtonType.CLOSE);
					a.setHeaderText(null);
					a.show();
				}
				else {
					Alert a = new Alert(AlertType.CONFIRMATION, "Are you sure you wish to delete this employee?", ButtonType.YES, ButtonType.NO);
					a.setHeaderText(null);
					Optional<ButtonType> result = a.showAndWait();
					if (result.get() == ButtonType.YES) {
						EmployeeEvent evt = new EmployeeEvent(e, employeeList, EmployeeEvent.DELETE_EMPLOYEE);
						employeeList.fireEvent(evt);
					}
				}
			}
		);
		
		employeeUpdate.setOnAction(
			(event) -> {
				Employee e = employeeList.getSelectionModel().getSelectedItem();
				if (e == null) {
					Alert a = new Alert(AlertType.ERROR, "You have not selected an employee.", ButtonType.CLOSE);
					a.setHeaderText(null);
					a.show();
				}
				else {
					Alert a = new Alert(AlertType.CONFIRMATION, "You are about to overwrite this employee's information.\nDo you wish to proceed?", ButtonType.YES, ButtonType.NO);
					a.setHeaderText(null);
					Optional<ButtonType> result = a.showAndWait();
					if (result.get() == ButtonType.YES) {
						EmployeeEvent evt = new EmployeeEvent(e, employeeList, EmployeeEvent.UPDATE_EMPLOYEE);
						evt.setUsername(employeeUsername.getText());
						evt.setFirstname(employeeFirstName.getText());
						evt.setLastname(employeeLastName.getText());
						evt.setAccess(employeeAccessLevel.getValue());
						evt.setPassword(employeePassword.getText());
						employeeList.fireEvent(evt);
					}
				}
			}
		);
		
		employeeSave.setOnAction(
			(event) -> {
				if (employeeUsername.getText() == null || employeeUsername.getText().trim().isEmpty()) {
					Alert a = new Alert(AlertType.ERROR, "Username is required.", ButtonType.CLOSE);
					a.setHeaderText(null);
					a.show();
				}
				else if (employeePassword.getText() == null || employeePassword.getText().trim().isEmpty()) {
					Alert a = new Alert(AlertType.ERROR, "Password is required.", ButtonType.CLOSE);
					a.setHeaderText(null);
					a.show();
				}
				else {
					EmployeeEvent evt = new EmployeeEvent(null, employeeList, EmployeeEvent.CREATE_EMPLOYEE);
					evt.setUsername(employeeUsername.getText());
					evt.setFirstname(employeeFirstName.getText());
					evt.setLastname(employeeLastName.getText());
					evt.setPassword(employeePassword.getText());
					evt.setAccess(employeeAccessLevel.getValue());
					employeeList.fireEvent(evt);
				}
			}
		);
		
		
	}
	private void initMenuItemTab() {
		menuItemTab = new Tab("Menu Items");
		menuItemPane = new HBox();
		initTab(menuItemTab, menuItemPane);
		
		VBox left = new VBox();
		menuItemPane.getChildren().add(left);
		HBox.setHgrow(left, Priority.ALWAYS);
		menuItemList = new ListView<>();
		left.getChildren().add(menuItemList);
		VBox.setVgrow(menuItemList, Priority.ALWAYS);
		
		VBox right = new VBox();
		menuItemPane.getChildren().add(right);
		HBox.setHgrow(right, Priority.ALWAYS);
		
		HBox menuTypeContainer = new HBox();
		Text menuTypeLabel = new Text("Menu Type");
		menuTypeContainer.getChildren().add(menuTypeLabel);
		menuItemMenuType = new ChoiceBox<MenuItemType>();
		menuItemMenuType.getItems().addAll(MenuItemType.values());
		menuTypeContainer.getChildren().add(menuItemMenuType);
		right.getChildren().add(menuTypeContainer);
		
		Text menuItemNameLabel = new Text("Item Name");
		right.getChildren().add(menuItemNameLabel);
		menuItemName = new TextField();
		menuItemName.getStyleClass().add("form-control");
		right.getChildren().add(menuItemName);
		
		Text menuItemPriceLabel = new Text("Price");
		right.getChildren().add(menuItemPriceLabel);
		menuItemPrice = new TextField();
		menuItemPrice.getStyleClass().add("form-control");
		menuItemPrice.textProperty().addListener(new ChangeListener<String>() {
		    @Override
		    public void changed(ObservableValue<? extends String> observable, String oldValue, 
		        String newValue) {
		        if (!newValue.matches("\\d*\\.?\\d?\\d?")) {
		        	menuItemPrice.setText(oldValue);
		        }
		    }
		});
		right.getChildren().add(menuItemPrice);
		
		Text menuItemDescriptionLabel = new Text("Description");
		right.getChildren().add(menuItemDescriptionLabel);
		menuItemDescription = new TextField();
		menuItemDescription.getStyleClass().add("form-control");
		right.getChildren().add(menuItemDescription);
		
		HBox ingredientLists = new HBox();
		right.getChildren().add(ingredientLists);
		VBox allIngredientsHolder = new VBox();
		VBox currentIngredientsHolder = new VBox();
		ingredientLists.getChildren().add(allIngredientsHolder);
		ingredientLists.getChildren().add(currentIngredientsHolder);
		Text allIng = new Text("Restaurant Inventory");
		Text currIng = new Text("Item Ingredient List");
		allIngredientsHolder.getChildren().add(allIng);
		currentIngredientsHolder.getChildren().add(currIng);
		menuItemIngredientsList = new NodeList<>();
		menuItemAllIngredientsList = new NodeList<Ingredient>();
		allIngredientsHolder.getChildren().add(menuItemAllIngredientsList);
		currentIngredientsHolder.getChildren().add(menuItemIngredientsList);
		
		HBox buttons = new HBox();
		right.getChildren().add(buttons);
		
		menuItemSave = new Button("Create New Item");
		menuItemSave.setAlignment(Pos.CENTER_RIGHT);
		menuItemSave.getStyleClass().add("form-control");
		buttons.getChildren().add(menuItemSave);
		
		Region spacer1 = new Region();
		spacer1.setPrefWidth(15);
		buttons.getChildren().add(spacer1);
		
		menuItemUpdate = new Button("Update");
		menuItemUpdate.setAlignment(Pos.CENTER_RIGHT);
		menuItemUpdate.getStyleClass().add("form-control");
		menuItemUpdate.setVisible(false);
		buttons.getChildren().add(menuItemUpdate);
		
		Region spacer2 = new Region();
		spacer2.setPrefWidth(15);
		buttons.getChildren().add(spacer2);
		
		menuItemDelete = new Button("Delete");
		menuItemDelete.setAlignment(Pos.CENTER_RIGHT);
		menuItemDelete.getStyleClass().add("form-control");
		menuItemDelete.setVisible(false);
		buttons.getChildren().add(menuItemDelete);
		
		menuItemList.setOnMousePressed(
			(event) -> {
				MenuItem i = menuItemList.getSelectionModel().getSelectedItem();
				if (i == null) {
					menuItemUpdate.setVisible(false);
					menuItemDelete.setVisible(false);
				} else {
					menuItemUpdate.setVisible(true);
					menuItemDelete.setVisible(true);
					menuItemName.setText(i.getName());
					menuItemPrice.setText(String.valueOf(i.getPrice()));
					menuItemDescription.setText(i.getDescription());
					menuItemMenuType.setValue(i.getType());
					menuItemIngredientsList.clear();
					for (Ingredient ing : i.getIngredients()) {
						menuItemIngredientsList.add(ing, false, true, false, null);
					}
				}
			}
		);
		
		menuItemDelete.setOnAction(
				(event) -> {
					MenuItem e = menuItemList.getSelectionModel().getSelectedItem();
					if (e == null) {
						Alert a = new Alert(AlertType.ERROR, "You have not selected a menu item.", ButtonType.CLOSE);
						a.setHeaderText(null);
						a.show();
					}
					else {
						Alert a = new Alert(AlertType.CONFIRMATION, "Are you sure you wish to delete this menu item?", ButtonType.YES, ButtonType.NO);
						a.setHeaderText(null);
						Optional<ButtonType> result = a.showAndWait();
						if (result.get() == ButtonType.YES) {
							MenuItemEvent evt = new MenuItemEvent(e, menuItemList, MenuItemEvent.DELETE_MENUITEM);
							menuItemList.fireEvent(evt);
						}
					}
				}
			);
			
			menuItemUpdate.setOnAction(
				(event) -> {
					MenuItem e = menuItemList.getSelectionModel().getSelectedItem();
					if (e == null) {
						Alert a = new Alert(AlertType.ERROR, "You have not selected a menu item.", ButtonType.CLOSE);
						a.setHeaderText(null);
						a.show();
					}
					else {
						Alert a = new Alert(AlertType.CONFIRMATION, "You are about to overwrite this menu item's information.\nDo you wish to proceed?", ButtonType.YES, ButtonType.NO);
						a.setHeaderText(null);
						Optional<ButtonType> result = a.showAndWait();
						if (result.get() == ButtonType.YES) {
							MenuItemEvent evt = new MenuItemEvent(e, menuItemList, MenuItemEvent.UPDATE_MENUITEM);
							evt.setType(menuItemMenuType.getValue());
							evt.setName(menuItemName.getText());
							evt.setDescription(menuItemDescription.getText());
							evt.setIngredientList(menuItemIngredientsList.getList());
							evt.setPrice(Double.parseDouble(menuItemPrice.getText()));
							menuItemList.fireEvent(evt);
						}
					}
				}
			);
			
			menuItemSave.setOnAction(
				(event) -> {
					if (menuItemName.getText() == null || menuItemName.getText().trim().isEmpty()) {
						Alert a = new Alert(AlertType.ERROR, "Username is required.", ButtonType.CLOSE);
						a.setHeaderText(null);
						a.show();
					}
					else {
						MenuItemEvent evt = new MenuItemEvent(null, menuItemList, MenuItemEvent.CREATE_MENUITEM);
						evt.setType(menuItemMenuType.getValue());
						evt.setName(menuItemName.getText());
						evt.setDescription(menuItemDescription.getText());
						evt.setIngredientList(menuItemIngredientsList.getList());
						evt.setPrice(Double.parseDouble(menuItemPrice.getText()));
						menuItemList.fireEvent(evt);
					}
				}
			);
	}
	private void initIngredientTab() {
		ingredientTab = new Tab("Ingredients");
		ingredientPane = new HBox();
		initTab(ingredientTab, ingredientPane);
	}
	
	private void initTab(Tab t, HBox h) {
		h.getStyleClass().add("pane");
		h.setSpacing(20);
		t.setContent(h);
		center.getTabs().add(t);
	}
	
	public void populateEmployees(List<Employee> list) {
		populateEmployeeList(list);
	}
	
	private void populateEmployeeList(List<Employee> list) {
		employeeList.getItems().clear();
		for (Employee employee : list) {
			employeeList.getItems().add(employee);
		}
	}
	
	public void populateMenu(List<MenuItem> list) {
		populateMenuItemList(list);
	}
	
	/**
	 * @param list
	 */
	private void populateMenuItemList(List<MenuItem> list) {
		menuItemList.getItems().clear();
		for(MenuItem item : list) {
			menuItemList.getItems().add(item);
		}
	}
	
	public void populateIngredients(List<Ingredient> list) {
		populateMenuItemAllIngredientsList(list);
	}

	/**
	 * @param list
	 */
	private void populateMenuItemAllIngredientsList(List<Ingredient> list) {
		menuItemAllIngredientsList.clear();
		for(Ingredient i : list) {
			menuItemAllIngredientsList.add(i, true, false, false, null);
		}
	}

	public void setOnEmployeeCreated(EventHandler<EmployeeEvent> e) {
		this.employeeList.addEventHandler(EmployeeEvent.CREATE_EMPLOYEE, e);
	}
	
	public void setOnEmployeeUpdated(EventHandler<EmployeeEvent> e) {
		this.employeeList.addEventHandler(EmployeeEvent.UPDATE_EMPLOYEE, e);
	}
	
	public void setOnEmployeeDeleted(EventHandler<EmployeeEvent> e) {
		this.employeeList.addEventHandler(EmployeeEvent.DELETE_EMPLOYEE, e);
	}
	
	public void setOnMenuItemCreated(EventHandler<MenuItemEvent> e) {
		this.menuItemList.addEventHandler(MenuItemEvent.CREATE_MENUITEM, e);
	}
	
	public void setOnMenuItemUpdated(EventHandler<MenuItemEvent> e) {
		this.menuItemList.addEventHandler(MenuItemEvent.UPDATE_MENUITEM, e);
	}
	
	public void setOnMenuItemDeleted(EventHandler<MenuItemEvent> e) {
		this.menuItemList.addEventHandler(MenuItemEvent.DELETE_MENUITEM, e);
	}

}
