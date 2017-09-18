package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Login_class {
	@FXML
	private Button login_button;
	
	@FXML
	private TextField username_id;
	@FXML
	private TextField password_id;
	
///////////////////////////////////////////////////////////////////////////////////////////////	
	public void login_clicked(){
		/*
		 * Method for click event of the login button. 
		 * This calls another method that opens another scene.
		 *  
		 */
		
		//condition to determine if the username and password is correct. 
		//if it is then it calls open new scene method. 
		if((username_id.getText().equals("user")) && (password_id.getText().equals("pass"))){
			open_new_scene("Server.fxml",login_button,"Server Page");
			
			
			//else it prints on the console. 
		}else{
			System.out.println("wrong inputs.");
		}
	}
	
///////////////////////////////////////////////////////////////////////////////////////////////
	public void open_new_scene(String fxml_filename, Button button, String title){
		/*
		 * This method takes in fxml filename in string format, button name, and the title of the new 
		 * scene in string format.
		 * 
		 */
		
		//starts a new scene from button click and sets the title.
		Stage stage = (Stage)button.getScene().getWindow();
		stage.setTitle(title);
		Parent root = null;
		try{
			//loads another fxml page. 
			root = FXMLLoader.load(getClass().getResource("/application/"+fxml_filename));
			
			Scene scene = new Scene(root);
			stage.setScene(scene);
			
		}catch(IOException e){
			e.printStackTrace();
		}
		//show the new stage. 
		stage.show();
	}
}
