package gui;

import controllers.LoginController;
import events.LoginEvent;
import javafx.application.*;
import javafx.collections.*;
import javafx.css.*;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;
import models.Employee;

public class GUI_Main extends Application {
	
	private Stage applicationStage;
	private StageView currentView = null;
	
	/**
	 * List of controllers
	 */
	LoginController loginController;
	
	/**
	 * List of views
	 */
	Login lg;
	Display_Page dp;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		applicationStage = primaryStage;

		loginController = new LoginController();
		loginController.start();
		
		lg = new Login();
		dp = new Display_Page("host", "host");
		
		setView(StageView.Login);
		applicationStage.show();
		
		lg.addEventHandler(LoginEvent.AUTHENTICATING, 
			(event) -> {
				try {
					Employee user = loginController.AuthenticateUser(event.getUsername(), event.getPassword());
					if (user==null) {
						// Stay on Login Page
						lg.postErrorMessage("Username and password do not match.");
					} else {
						//User logged in proceed to other view.
						LoginEvent authenticatedEvent = new LoginEvent(LoginEvent.AUTHENTICATED);
						authenticatedEvent.setUsername(user.getUsername());
						authenticatedEvent.setAuthenticated(true);
						lg.clearErrorMessage();
						lg.fireEvent(authenticatedEvent);
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					loginController.Logout();
					lg.postErrorMessage("Could not login, previous session in progress. Previous session has been terminated, please try again.");
					setView(StageView.Login);
				}
			}
		);
		
		lg.addEventHandler(LoginEvent.AUTHENTICATED, 
			(event) -> {
				//TODO: make view based on current user
				setView(StageView.Host);
				//open_host_scene(btnLogin, "Host Page", username.getText(), password.getText());
			}
		);

		

	}
	
	public void setView(StageView view) {
		if(currentView != view) {
			Rectangle2D visual = Screen.getPrimary().getVisualBounds();
			switch(view) {
				case Host:
					applicationStage.setTitle("Host Page");
					applicationStage.setScene(new Scene(dp,visual.getWidth(), visual.getHeight()));
					break;
				case Login:
					applicationStage.setTitle("Login Page");
					applicationStage.setScene(new Scene(lg, visual.getWidth(), visual.getHeight()));
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
