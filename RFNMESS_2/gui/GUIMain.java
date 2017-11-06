package gui;

import controllers.*;
import events.*;
import javafx.application.*;
import javafx.geometry.*;
import javafx.scene.*;
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
	
	/**
	 * List of views
	 */
	private Login lg;
	private HostView hostView;
	private OrderView orderView;
	private KitchenView kitchenView;

	@Override
	public void start(Stage primaryStage) throws Exception {
		Rectangle2D visual = Screen.getPrimary().getVisualBounds();
		applicationStage = primaryStage;
		applicationStage.setMaximized(true);
		applicationStage.setFullScreen(true);

		loginController = new LoginController();
		loginController.start();

		seatingController = new SeatingController();
		seatingController.start();
		
		orderController = new OrderController();
		orderController.start();
		
		seatingController.start(/* TODO: Insert Restaurant model */);

		masterPane = new DisplayPage();
		applicationStage.setScene(new Scene(masterPane, visual.getWidth(), visual.getHeight()));
		applicationStage.setTitle("RFNMESS | Restaurant Franchise Network Managment Enterpise Software System");

		applicationStage.getScene().getStylesheets().add("gui/CSS.css");
		// applicationStage.getScene().getStylesheets().add("gui/material-fx-v0_3.css");
		// applicationStage.getScene().getStylesheets().add("gui/materialfx-toggleswitch.css");

		lg = new Login();
		hostView = new HostView();
		orderView = new OrderView();
		kitchenView = new KitchenView();

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

		// changes to manger view.
		// masterPane.managerClick(
		// (event)->{
		//
		// setView(StageView.Manager);
		// });

		orderView.setOnNewOrder(
			(event) -> {
				Order o = orderController.createNewOrder(event.getTable());
				orderView.refreshOrderMenuOrderList();
				if(o!=null) {
					orderView.setSelectedOrder(o);
				}
			}
		);
		
		orderView.setOnItemAdded(
			(event) -> {
				orderController.addItemToOrder(event.getOrder(), event.getItem());
				orderView.populateOrderItemsList();
				orderView.setSelectedOrder(event.getOrder());
			}
		);

		orderView.setOnItemRemoved(
			(event) -> {
				orderController.removeItemFromOrder(event.getOrder(), event.getItem());
				orderView.setSelectedOrder(event.getOrder());
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
			default:
				break;
			}
			currentView = view;
		}
	}

}
