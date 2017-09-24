package gui;
import java.io.IOException;

import javafx.application.*;
import javafx.collections.*;
import javafx.css.*;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.layout.*;

public class Login extends BorderPane {
	
	public Login(){
		//Initialized objects. 
		TextField username = new TextField();
		TextField password = new TextField();
		Button Login = new Button("Login");
		Label title = new Label("Please Username and Password");
		Label error_label = new Label();
		error_label.setVisible(false);
		
		//Gride pane is located in the center of the border pane. 
		//holds the text field for user name, and password
		//holds a button to login. 
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(100,20,10,110));//top,right,bottom,left
		grid.setVgap(5);
		grid.add(username, 0, 0);
		username.setPromptText("Username");
		password.setPromptText("Password");
		grid.add(password, 0, 1);
		grid.add(Login, 0, 2);
		
		
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
		
		//sets the style for this page. 
		this.setStyle("-fx-background-color:#c6ecd9;");
		this.setTop(vbox);
		this.setCenter(grid);
		this.setBottom(box);
		
		//login button's options on click. 
		Login.setOnAction(
				(event)->{
					if ((username.getText().equals("host")) && (password.getText().equals("host"))) {
						//opens up a new page which displays what hosts see. 
						open_host_scene(Login, "Host Page");

					} else if ((username.getText().equals("manager")) && (password.getText().equals("manager"))) {
						// open_new_scene("Manager.fxml", login_button, "Manager Page");

					} else if ((username.getText().equals("server")) && (password.getText().equals("server"))) {
						// open_new_scene("Server.fxml", login_button, "Server Page");
					} else {
						error_label.setTextFill(Color.RED);
						error_label.setText("Username or Password is incorrect.");
						error_label.setVisible(true);
					}
				});
		
	}
	
	
/////////////////////////////////////////////////////////////////////
	public void open_host_scene(Button button, String title){
		/*
		 * This method takes in button name and title for the page. 
		 * This is for host page. 
		 * 
		 */
		// starts a new scene from button click and sets the title.
		Host_page hp = new Host_page();
		Stage stage = (Stage) button.getScene().getWindow();
		stage.setTitle(title);
		stage.setScene(new Scene(hp,900,500));
		stage.show();
	}
	
/////////////////////////////////////////////////////////////////////

	public void open_manager_scene(Button button, String title){
		/*
		 * This method takes in button name and title for the page. 
		 * This is for manager page. 
		 * 
		 */
		// starts a new scene from button click and sets the title.
		
		Stage stage = (Stage) button.getScene().getWindow();
		stage.setTitle(title);
		//stage.setScene(new Scene(hp,900,500));
		stage.show();
	}
/////////////////////////////////////////////////////////////////////
	
	public void open_server_scene(Button button, String title){
		/*
		 * This method takes in button name and title for the page. 
		 * This is for server page. 
		 * 
		 */
		// starts a new scene from button click and sets the title.
		
		Stage stage = (Stage) button.getScene().getWindow();
		stage.setTitle(title);
		//stage.setScene(new Scene(hp,900,500));
		stage.show();
	}
	
	

}
