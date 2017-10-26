package gui;
import java.io.IOException;

import controllers.LoginController;
import events.LoginEvent;
import javafx.application.*;
import javafx.collections.*;
import javafx.css.*;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
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
import javafx.scene.layout.*;

public class Login extends BorderPane {
	
	private TextField username;
	private PasswordField password;
	private Button btnLogin;
	private Label error_label;
	
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
		
		//Gride pane is located in the center of the border pane. 
		//holds the text field for user name, and password
		//holds a button to login. 
		GridPane grid = new GridPane();
		//grid.setPadding(new Insets(100,20,10,110));//top,right,bottom,left
		grid.setVgap(5);
		grid.setAlignment(Pos.CENTER);
		grid.add(title, 0, 0);
		grid.add(username, 0, 1);
		username.setPromptText("Username");
		password.setPromptText("Password");
		grid.add(password, 0, 2);
		grid.add(btnLogin, 0, 3);
		grid.add(error_label, 0, 4);
		
		/*
		//vbox that is set on top of the users and password. 
		//displays instructions. 
		VBox vbox = new VBox();
		vbox.setPadding(new Insets(50,5,5,5)); //top,right,bottom,left
		vbox.getChildren().add(title);
		vbox.setAlignment(Pos.CENTER);
		
		//vabox pane that is attached to the bottom of the page.
		//shows the error message if the inputs are wrong. 
		VBox box = new VBox();
		box.setPadding(new Insets(5,5,100,5));
		box.getChildren().add(error_label);
		box.setAlignment(Pos.TOP_CENTER);
		*/
		
		//sets the style for this page.
		BackgroundSize bgsize = new BackgroundSize(100,100,true,true,true,true);
		BackgroundImage myBI= new BackgroundImage(new Image("RFNMESS_presentation_pic.png"),
		        BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
		          bgsize);
		
		this.setBackground(new Background(myBI));
		//this.getStylesheets().addAll(this.getClass().getResource("CSS.css").toExternalForm());
		
		//this.setStyle("-fx-background-color:#c6ecd9;");
		//this.setTop(vbox);
		this.setCenter(grid);
		//this.setBottom(box);
		
		//login button's options on click. 
		btnLogin.setOnAction(
			(event)->{
				LoginEvent evt = new LoginEvent(LoginEvent.AUTHENTICATING);
				evt.setUsername(this.getUsername());
				evt.setPassword(this.getPassword());
				this.fireEvent(evt);
			}
		);
		
	}
	
	

}
