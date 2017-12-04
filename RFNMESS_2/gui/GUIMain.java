package gui;

import java.util.ArrayList;
import java.util.Optional;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import controllers.*;
import events.*;
import javafx.application.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.stage.*;
import models.*;
import views.*;

public class GUIMain extends Application {

	private Stage applicationStage;
	private StageView currentView = null;
	private DisplayPage masterPane;

	/**
	 * List of controllers
	 */
	private LoginController loginController;
	private SeatingController seatingController;
	private OrderController orderController;
	private EmployeeController employeeController;
	
	/**
	 * List of views
	 */
	private Login lg;
	private HostView hostView;
	private OrderView orderView;
	private KitchenView kitchenView;
	private ManagerView managerView;

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		File yourFile = new File("flatFile.ser");
		yourFile.createNewFile(); 
		
		Rectangle2D visual = Screen.getPrimary().getVisualBounds();
		applicationStage = primaryStage;
		applicationStage.setMaximized(true);
		//applicationStage.setFullScreen(true);
		
		applicationStage.setOnCloseRequest(
			(event) ->{
				try {
					System.out.println("write on closing");
					try {
				         FileOutputStream fileOut =
				         new FileOutputStream("flatFile.ser");
				         ObjectOutputStream out = new ObjectOutputStream(fileOut);
				         out.writeObject(Restaurant.getRestaurant());
				         out.close();
				         fileOut.close();
				         System.out.printf("Serialized data is saved in flatFile.ser");
				      } catch (IOException i) {
				         i.printStackTrace();
				      }
				}
				catch (Exception ex) {
					Alert a = new Alert(
							AlertType.ERROR, 
							"An error has occured while attempting to save any changes from the current session.\n" + 
							"If you would like to proceed without saving, press OK, otherwise press Cancel and try closing again."
							, ButtonType.OK, ButtonType.CANCEL);
					a.setTitle("Error!");
					a.setHeaderText(null);
					Optional<ButtonType> result = a.showAndWait();
					if(result.get() == ButtonType.CANCEL) {
						event.consume();
					}
				}
			}
		);

		loginController = new LoginController();
		loginController.start();

		seatingController = new SeatingController();
		seatingController.start();
		
		orderController = new OrderController();
		orderController.start();
		
		employeeController = new EmployeeController();
		employeeController.start();

		masterPane = new DisplayPage();
		applicationStage.setScene(new Scene(masterPane, visual.getWidth(), visual.getHeight()));
		applicationStage.setTitle("RFNMESS | Restaurant Franchise Network Managment Enterpise Software System");

		applicationStage.getScene().getStylesheets().add("gui/CSS.css");
//		applicationStage.getScene().getStylesheets().add("gui/material-fx-v0_3.css");
		//applicationStage.getScene().getStylesheets().add("gui/materialfx-toggleswitch.css");

		lg = new Login();
		hostView = new HostView();
		orderView = new OrderView();
		kitchenView = new KitchenView();
		managerView = new ManagerView();
		managerView.populateEmployees(employeeController.getEmployees());
		managerView.populateMenu(orderController.getMenuItems(MenuItemType.ALL));
		managerView.populateIngredients(orderController.getIngredients());

		setView(StageView.Login);
		applicationStage.show();
		
		lg.setOnLoggingIn( 
			(event) -> {
				try {
					Employee user = loginController.AuthenticateUser(event.getUsername(), event.getPassword());
					if (user==null) {
						// Stay on Login Page
						lg.postErrorMessage("Username and password do not match.");
					} else {
						//User logged in proceed to other view.
						LoginEvent authenticatedEvent = new LoginEvent(user, lg.getCenter(), LoginEvent.AUTHENTICATED);
						lg.clear();
						((Node) event.getTarget()).fireEvent(authenticatedEvent);
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					loginController.logout();
					lg.postErrorMessage("Could not login, previous session in progress. Previous session has been terminated, please try again.");
					setView(StageView.Login);
				}
			}
		);
		
		lg.setOnLoggedIn(
			(event) -> {
				//TODO: make view based on current user
				setView(event.getDefaultView());
			}
		);
		
		masterPane.serverClick(
			(event)-> {
				setView(StageView.Order);
			}
		);

		lg.setOnLoggedIn((event) -> {
			// TODO: make view based on current user
			setView(event.getDefaultView());
		});

		// logs out.
		masterPane.setOnLogout((event) -> {
			loginController.logout();
			setView(StageView.Login);
		});
		// changes to host view.
		masterPane.hostClick((event) -> {
			setView(StageView.Host);
		});
		// changes to order page aka server view.
		masterPane.serverClick((event) -> {
			setView(StageView.Order);
		});

		// changes to kitchen view.
		masterPane.kitchenClick((event) -> {
			setView(StageView.Kitchen);
		});

		// changes to manager view.
		masterPane.managerClick((event) -> {
			setView(StageView.Manager);
		});

		orderView.setOnNewOrder(
			(event) -> {
				Order o = orderController.createNewOrder(event.getTable());
				orderView.refreshOrderMenuOrderList();
				if(o!=null) {
					orderView.setSelectedOrder(o);
					kitchenView.addNewOrder(o);
				}
			}
		);
		
		orderView.setOnItemAdded(
			(event) -> {
				orderController.addItemToOrder(event.getOrder(), event.getItem());
				orderView.populateOrderItemsList();
				orderView.setSelectedOrder(event.getOrder());
				if(!event.getOrder().isFulfilled()) {
					kitchenView.addNewOrder(event.getOrder());
				}
			}
		);

		orderView.setOnItemRemoved(
			(event) -> {
				orderController.removeItemFromOrder(event.getOrder(), event.getItem());
				orderView.setSelectedOrder(event.getOrder());
				if(event.getOrder().isFulfilled()) {
					kitchenView.removeOrder(event.getOrder());
				}
			}
		);
		
		orderView.setOnOrderBilled(
			(event) -> {
				orderController.billOrder(event.getOrder());
				orderView.populateOrderList();
				orderView.setSelectedOrder(event.getOrder());
				
				//TODO: Print Dialog
			}
		);
		
		kitchenView.setOnOrderFulfilled(
			(event) -> {
				orderController.fulfillOrder(event.getOrder());
			}
		);
		
		managerView.setOnEmployeeCreated(
			(event) -> {
				employeeController.createEmployee(
						event.getUsername(), 
						event.getPassword(),
						event.getAccess(),
						event.getFirstname(),
						event.getLastname()
				);
				managerView.populateEmployees(employeeController.getEmployees());
			}
		);
		
		managerView.setOnEmployeeUpdated(
			(event) -> {
				employeeController.updateEmployee(
						event.getEmployee(),
						event.getUsername(), 
						event.getPassword(),
						event.getAccess(),
						event.getFirstname(),
						event.getLastname()
				);
				Alert a = new Alert(AlertType.NONE, "Employee " + event.getEmployee().getUsername() + " successfully updated.", ButtonType.OK);
				a.setHeaderText(null);
				a.setTitle("Success!");
				Optional<ButtonType> result = a.showAndWait();
				if(result.get()==ButtonType.OK || result.get()==ButtonType.CLOSE) {
					a.close();
				}
			}
		);
		
		managerView.setOnEmployeeDeleted(
			(event) -> {
				String un = event.getEmployee().getUsername();
				employeeController.deleteEmployee(
						event.getEmployee()
				);
				managerView.populateEmployees(employeeController.getEmployees());
				Alert a = new Alert(AlertType.NONE, "Employee " + un + " successfully deleted.", ButtonType.OK);
				a.setHeaderText(null);
				a.setTitle("Success!");
				Optional<ButtonType> result = a.showAndWait();
				if(result.get()==ButtonType.OK || result.get()==ButtonType.CLOSE) {
					a.close();
				}
			}
		);
		
		managerView.setOnMenuItemDeleted(
			(event) -> {
				String n = event.getMenuItem().getName();
				orderController.deleteMenuItem(
						event.getMenuItem()
				);
				managerView.populateMenu(orderController.getMenuItems(MenuItemType.ALL));
				orderView.populateDrinks(orderController.getMenuItems(MenuItemType.DRINK));
				orderView.populateAppetizers(orderController.getMenuItems(MenuItemType.APPETIZER));
				orderView.populateEntrees(orderController.getMenuItems(MenuItemType.ENTREE));
				orderView.populateDesserts(orderController.getMenuItems(MenuItemType.DESSERT));
				Alert a = new Alert(AlertType.NONE, "Menu Item " + n + " successfully deleted.", ButtonType.OK);
				a.setHeaderText(null);
				a.setTitle("Success!");
				Optional<ButtonType> result = a.showAndWait();
				if(result.get()==ButtonType.OK || result.get()==ButtonType.CLOSE) {
					a.close();
				}
			}
		);
		
		managerView.setOnMenuItemUpdated(
			(event) -> {
				orderController.updateMenuItem(
					event.getMenuItem(), 
					event.getType(), 
					event.getName(), 
					event.getPrice(), 
					(ArrayList<Ingredient>) event.getIngredientList(), 
					event.getDescription()
				);
				managerView.populateMenu(orderController.getMenuItems(MenuItemType.ALL));
				orderView.populateDrinks(orderController.getMenuItems(MenuItemType.DRINK));
				orderView.populateAppetizers(orderController.getMenuItems(MenuItemType.APPETIZER));
				orderView.populateEntrees(orderController.getMenuItems(MenuItemType.ENTREE));
				orderView.populateDesserts(orderController.getMenuItems(MenuItemType.DESSERT));
				Alert a = new Alert(AlertType.NONE, "Menu Item " + event.getMenuItem().getName() + " successfully updated.", ButtonType.OK);
				a.setHeaderText(null);
				a.setTitle("Success!");
				Optional<ButtonType> result = a.showAndWait();
				if(result.get()==ButtonType.OK || result.get()==ButtonType.CLOSE) {
					a.close();
				}
			}
		);
		
		managerView.setOnMenuItemCreated(
			(event) -> {
				orderController.createMenuItem(
						event.getType(), 
						event.getName(), 
						event.getPrice(), 
						(ArrayList<Ingredient>) event.getIngredientList(), 
						event.getDescription()
				);
				managerView.populateMenu(orderController.getMenuItems(MenuItemType.ALL));
				orderView.populateDrinks(orderController.getMenuItems(MenuItemType.DRINK));
				orderView.populateAppetizers(orderController.getMenuItems(MenuItemType.APPETIZER));
				orderView.populateEntrees(orderController.getMenuItems(MenuItemType.ENTREE));
				orderView.populateDesserts(orderController.getMenuItems(MenuItemType.DESSERT));
			}
		);
		
		
		managerView.setOnIngredientDeleted(
			(event) -> {
				String n = event.getIngredient().getName();
				orderController.deleteIngredient(
						event.getIngredient()
				);
				managerView.populateIngredients(orderController.getIngredients());
				Alert a = new Alert(AlertType.NONE, "Ingredient " + n + " successfully deleted.", ButtonType.OK);
				a.setHeaderText(null);
				a.setTitle("Success!");
				Optional<ButtonType> result = a.showAndWait();
				if(result.get()==ButtonType.OK || result.get()==ButtonType.CLOSE) {
					a.close();
				}
			}
		);
		
		managerView.setOnIngredientUpdated(
			(event) -> {
				orderController.updateIngredient(
					event.getIngredient(),
					event.getName(), 
					event.getDescription(),
					event.getPrice()
				);
				managerView.populateIngredients(orderController.getIngredients());
				Alert a = new Alert(AlertType.NONE, "Ingredient " + event.getIngredient().getName() + " successfully updated.", ButtonType.OK);
				a.setHeaderText(null);
				a.setTitle("Success!");
				Optional<ButtonType> result = a.showAndWait();
				if(result.get()==ButtonType.OK || result.get()==ButtonType.CLOSE) {
					a.close();
				}
			}
		);
		
		managerView.setOnIngredientCreated(
			(event) -> {
				orderController.createIngredient(
						event.getName(), 
						event.getDescription(), 
						event.getPrice()
				);
				managerView.populateIngredients(orderController.getIngredients());
			}
		);
		
	}

	public void setView(StageView view) {
		if (currentView != view) {
			switch (view) {
			case Host:
				masterPane.setView(hostView);
				break;
			case Login:
				masterPane.setView(lg);
				break;
			case Order:
				masterPane.setView(orderView);
				break;
			case Kitchen:
				masterPane.setView(kitchenView);
				break;
			case Manager:
				masterPane.setView(managerView);
				break;
			default:
				break;
			}
			currentView = view;
		}
	}

	public static void main(String[] args) {
		GUIMain.launch(args);
	}
}