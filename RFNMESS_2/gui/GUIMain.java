package gui;

import controllers.*;
import events.*;
import javafx.application.*;
import javafx.collections.*;
import javafx.css.*;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;
import models.*;
import views.HostView;

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
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		Rectangle2D visual = Screen.getPrimary().getVisualBounds();
		applicationStage = primaryStage;

		loginController = new LoginController();
		loginController.start();
		
		seatingController = new SeatingController();
		seatingController.start(/* TODO: Insert Restaurant model*/);
		
		masterPane = new DisplayPage();
		applicationStage.setScene(new Scene(masterPane,visual.getWidth(), visual.getHeight()));
		applicationStage.setTitle("RFNMESS | Restaurant Franchise Network Managment Enterpise Software System");
		
		lg = new Login();
		hostView = new HostView();
		
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
						lg.clearErrorMessage();
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
				masterPane.setView(lg);
			}
		);

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
					break;
				default:
					break;
			}
			currentView = view;
		}
	}

}
