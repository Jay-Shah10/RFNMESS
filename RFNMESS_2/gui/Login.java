package gui;
import java.io.IOException;

import controllers.LoginController;
import events.LoginEvent;
import javafx.application.*;
import javafx.collections.*;
import javafx.css.*;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;
import models.Employee;
import views.View;
import javafx.scene.layout.*;

public class Login implements View {
	
	private TextField username;
	private PasswordField password;
	private Button btnLogin;
	private Label error_label;
	private GridPane grid;
	
	public String getUsername() {
		return username.getText();
	}
	
	public String getPassword() {
		return password.getText();
	}
	
	public void disableLogin() {
		btnLogin.setDisable(true);
	}
	
	public void enableLogin() {
		btnLogin.setDisable(false);
	}
	
	public void postErrorMessage(String msg) {
		error_label.setText(msg);
		
		error_label.setVisible(true);
	}
	
	public void clearErrorMessage() {
		error_label.setText("");
		error_label.setVisible(false);
	}
	
	public Login(){
		//Initialized objects. 
		username = new TextField();
		password = new PasswordField();
		
		btnLogin = new Button("Login");
		
		Label title = new Label("Please Username and Password");
		title.setStyle("-fx-text-fill: #ffffff");
		error_label = new Label();
		error_label.setVisible(false);
		error_label.setTextFill(Color.RED);
		
		//Grid pane is located in the center of the border pane. 
		//holds the text field for user name, and password
		//holds a button to login. 
		grid = new GridPane();
		grid.setVgap(5);
		grid.setAlignment(Pos.CENTER);
		grid.add(title, 0, 0);
		grid.add(username, 0, 1);
		username.setPromptText("Username");
		password.setPromptText("Password");
		grid.add(password, 0, 2);
		grid.add(btnLogin, 0, 3);
		grid.add(error_label, 0, 4);
		
		
		//login button's options on click. 
		btnLogin.setOnAction(
			(event)->{
				LoginEvent evt = new LoginEvent(LoginEvent.AUTHENTICATING);
				evt.setUsername(this.getUsername());
				evt.setPassword(this.getPassword());
				grid.fireEvent(evt);
			}
		);
		
	}

	@Override
	public Node getCenter() {
		// TODO Auto-generated method stub
		return grid;
	}

	@Override
	public Node getRight() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node getLeft() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node getBottom() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T extends Event> void addEventHandler(EventType<T> eventType, EventHandler<? super T> eventHandler) {
		this.grid.addEventHandler(eventType, eventHandler);
	}
	
	

}
