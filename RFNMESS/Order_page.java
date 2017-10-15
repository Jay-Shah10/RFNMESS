package application;

import java.io.IOException;
import java.util.*;

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

/////////////////////////////////////////////////////////////////
public class Order_page {
	
	@FXML
	private TextField search_textfield;
	@FXML
	private TextArea drink_menu_textarea;
	@FXML
	private TextArea items_textarea;
	@FXML
	private TextArea meneu_display_textarea;
	
	@FXML
	private TitledPane titled_menu_bar;
	
	@FXML
	private Button inhouse_button;
	@FXML
	private Button to_go_button;
	
	private ArrayList<String> menu_items = new ArrayList <String>();
	
/////////////////////////////////////////////////////////////////
	
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
		
		titled_menu_bar.setContent(gp);
	}
/////////////////////////////////////////////////////////////////
	
	public void close_titledpane(){
		/*
		 * tiny method to close the titled pane. 
		 * Tied to the on mouse exit button in scene builder .
		 */
		titled_menu_bar.setExpanded(false);
	}
	
/////////////////////////////////////////////////////////////////
	public void inhouse_button_click(){
		search_textfield.setText("inhouse order placed.");
		
	}
	
/////////////////////////////////////////////////////////////////
	public void to_go_button_click(){
		search_textfield.setText("to go order placed.");
		
	}
	
/////////////////////////////////////////////////////////////////
	public void drink_menu(){
		menu_items.add("items");
		menu_items.add("items");
		menu_items.add("items");
		menu_items.add("items");
		
		for(String list: menu_items){
			drink_menu_textarea.setPromptText(list);
		}
	}
	
/////////////////////////////////////////////////////////////////
	
	
}
