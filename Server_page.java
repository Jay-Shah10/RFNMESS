package application;

import java.io.IOException;
import com.sun.javafx.text.TextLine;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Server_page {
	@FXML
	private TitledPane menu_bar; 
	@FXML
	private TextField party_name_textfield;
	@FXML
	private Button reserve_button;
	@FXML 
	private TextArea table_textfield;
	@FXML
	private Button to_go_button;
	@FXML
	private Button place_order_button;
	
	@FXML
	private Rectangle re_1,re_2,re_3,re_4,re_5,re_6,re_7,re_8,re_9,re_10,re_11,re_12;
	
/////////////////////////////////////////////////////////////////////////////
	
	public void titledpane(){
		/*
		 * method for the onclick section of the titledpane. 
		 * still needs some adjustments for how it shows up in the GUI
		 * needs to make sure that the gridpane is over the blue rectangles. 
		 * needs to have a white back ground with the name label on the right side. 
		 * and all of that needs to be in front of what is already on the page before its clicked. 
		 * 
		 * also expands over everything. maybe get it to expand only half way? need to find a way.
		 * 
		 * this method is tied to the on mouse click button in scene builder. 
		 */
		GridPane gp = new GridPane();
		Region r = new Region();
		gp.setHgrow(r, Priority.ALWAYS);
		gp.setVgap(5);
		gp.add(new Button("Menu option 1"), 0, 0);
		gp.add(new Button("Menu option 2"), 0, 1);
		gp.add(new Button("Menu option 3"), 0, 2);
		gp.add(new Button("Menu option 4"), 0, 3);
		gp.add(r, 1, 1);
		gp.add(new Label("Namead;lfkjal") , 2,1 );
		
		menu_bar.setContent(gp);
	}
	
/////////////////////////////////////////////////////////////////////////////
	public void close_titledpane(){
		/*
		 * tiny method to close the titled pane. 
		 * Tied to the on mouse exit button in scene builder .
		 */
		menu_bar.setExpanded(false);
	}
	
/////////////////////////////////////////////////////////////////////////////
	public void reserve_click(){
		/*
		 * method to display a table has been reserved.  *for demo purposes*
		 */
		party_name_textfield.setText("Table Reserved.");
	}
	
/////////////////////////////////////////////////////////////////////////////
	public void to_go_button_click(){
		/*
		 * method to display a order to go has been reserved.  *for demo purposes*
		 */
		table_textfield.setText("order placed to go");
	}
	
/////////////////////////////////////////////////////////////////////////////
	public void place_order_button_click(){
		/*
		 * method to display a in house order has been reserved.  *for demo purposes*
		 */
		table_textfield.setText("Order placed.");
		open_new_scene("Order.fxml",place_order_button,"Order Page");
	}
	
	
/////////////////////////////////////////////////////////////////////////////
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
