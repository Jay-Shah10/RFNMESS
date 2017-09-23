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
		TextField username = new TextField();
		TextField password = new TextField();
		Button Login = new Button("Login");
		Label title = new Label("Please Username and Password");
		Label error_label = new Label();
		error_label.setVisible(false);
		
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(100,20,10,110));//top,right,bottom,left
		grid.setVgap(5);
		grid.add(username, 0, 0);
		username.setPromptText("Username");
		password.setPromptText("Password");
		grid.add(password, 0, 1);
		grid.add(Login, 0, 2);
		
		
		
		VBox vbox = new VBox();
		vbox.setPadding(new Insets(50,5,5,5)); //top,right,bottom,left
		vbox.getChildren().add(title);
		vbox.setAlignment(Pos.CENTER);
		
		VBox box = new VBox();
		box.setPadding(new Insets(5,5,5,5));
		box.getChildren().add(error_label);
		box.setAlignment(Pos.TOP_CENTER);
		
		this.setStyle("-fx-background-color:#8FBC8F;");
		this.setTop(vbox);
		this.setCenter(grid);
		this.setBottom(box);
		
		
		Login.setOnAction(
				(event)->{
					if ((username.getText().equals("host")) && (password.getText().equals("host"))) {
						open_new_scene("Host.fxml", Login, "Host Page");

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
	
	
	
	public void open_new_scene(String fxml_filename, Button button, String title){
		/*
		 * This method takes in fxml filename in string format, button name, and
		 * the title of the new scene in string format.
		 * 
		 */

		// starts a new scene from button click and sets the title.
		Stage stage = (Stage) button.getScene().getWindow();
		stage.setTitle(title);
		Parent root = null;
		try {
			// loads another fxml page.
			root = FXMLLoader.load(getClass().getResource("/application/" + fxml_filename));

			Scene scene = new Scene(root);
			stage.setScene(scene);

		} catch (IOException e) {
			e.printStackTrace();
		}
		// show the new stage.
		stage.show();
	}

}
