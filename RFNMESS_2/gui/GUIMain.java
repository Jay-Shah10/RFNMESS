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
		seatingController.start(/* TODO: Insert Restaurant model*/);
		
		masterPane = new DisplayPage();
		applicationStage.setScene(new Scene(masterPane,visual.getWidth(), visual.getHeight()));
		applicationStage.setTitle("RFNMESS | Restaurant Franchise Network Managment Enterpise Software System");
		
		applicationStage.getScene().getStylesheets().add("gui/CSS.css");
//		applicationStage.getScene().getStylesheets().add("gui/material-fx-v0_3.css");
//		applicationStage.getScene().getStylesheets().add("gui/materialfx-toggleswitch.css");
		
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

		masterPane.setOnLogout(
			(event) -> {
				loginController.logout();
				setView(StageView.Login);
			}
		);
		masterPane.setOnOrderClick(
				(event)->{
					
					setView(StageView.Order);
				});

	}
	
	public void setView(StageView view) {
		if(currentView != view) {
			switch(view) {
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
