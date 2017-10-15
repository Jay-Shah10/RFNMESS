package application;


import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Login_class {
	@FXML
	private Button login_button;

	@FXML
	private TextField username_id;
	@FXML
	private TextField password_id;

	@FXML
	private Label error_label;
	
	@FXML
	private HBox hbox;
	
	@FXML
	private Pane cover;
	 
	

	///////////////////////////////////////////////////////////////////////////////////////////////
	public void login_clicked() throws InterruptedException {
		/*
		 * Method for click event of the login button. This calls another method
		 * that opens another scene.
		 * 
		 */

		button_action();
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
	public void button_action() throws InterruptedException {
		/*
		 * This method determines if the username and passwords match. 
		 * if they do it opens up to their rightful pages. 
		 * if not it displays a red text that says wrong username or password.
		 * 
		 * This method calls another method. "open_new_scene" method. 
		 */

		if ((username_id.getText().equals("host")) && (password_id.getText().equals("host"))) {
			open_new_scene("Host.fxml", login_button, "Host Page");

		} else if ((username_id.getText().equals("manager")) && (password_id.getText().equals("manager"))) {
			// open_new_scene("Manager.fxml", login_button, "Manager Page");

		} else if ((username_id.getText().equals("server")) && (password_id.getText().equals("server"))) {
			// open_new_scene("Server.fxml", login_button, "Server Page");
		} else {
			error_label.setTextFill(Color.RED);
			error_label.setText("Username or Password is incorrect.");
			error_label.setVisible(true);
		}

	}

	public void open_new_scene(String fxml_filename, Button button, String title) {
		/*
		 * This method takes in fxml filename in string format, button name, and
		 * the title of the new scene in string format.
		 * 
		 */

		// starts a new scene from button click and sets the title.
		Stage stage = (Stage) button.getScene().getWindow();
		stage.setTitle(title);
		Parent root = null;
		Rectangle2D visual = Screen.getPrimary().getVisualBounds();
		try {
			// loads another fxml page.
			root = FXMLLoader.load(getClass().getResource("/application/" + fxml_filename));

			Scene scene = new Scene(root,visual.getWidth(),visual.getHeight());
			stage.setScene(scene);

		} catch (IOException e) {
			e.printStackTrace();
		}
		// show the new stage.
		stage.show();
	}
	///////////////////////////////////////////////////////////////////////////////////////////////

}
