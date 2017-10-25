package gui;

import javafx.scene.control.Button;

import java.util.*;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;

public class Host_Right extends VBox {
	
	private ArrayList tables = new ArrayList();

	public Host_Right() {

		// adds CSS to the Pane and properties to the pane.
		setStyle("-fx-background-color:#ff8c1a");
		this.setSpacing(10);
		this.setPadding(new Insets(5, 5, 5, 5));
		this.setMaxWidth(300);

		// adds all the items to the Pane.
		TextField tf = new TextField();
		Region r = new Region();
		ComboBox<Integer> cb = new ComboBox();
		TextArea ta = new TextArea();
		Button reserve = new Button("Reserve");
		Button to_go = new Button("To-Go!");
		Button in_house = new Button("In-House");
		Label party_name = new Label("Enter Party Name:");
		Label table_reservation_label = new Label("Pick a table form below: ");
		Label up_next = new Label("Next Table:");
		Button finished = new Button("Delete");
		ComboBox finished_table = new ComboBox();

		// adds items to the combo box.
		for (int i = 0; i < 13; i++) {
			cb.getItems().add(i);
		}
		// addes property to the region.
		this.setVgrow(r, Priority.ALWAYS);
		
		for (int j=0; j<13; j++){
			finished_table.getItems().add(j);
		}
		/*
		 * First the cb box allows them to click which table they want to reserve. 
		 * reserve button allows the user to store that and pops up in the text area. 
		 * finished button allows user to delete any table in there. 
		 * 
		 * these table numbers need to stored in one place. 
		 */

		// adds all items to the vbox to display.
		getChildren().addAll(party_name, tf, table_reservation_label, cb, reserve, up_next, ta,finished_table, finished, r, to_go, in_house);

	}
}
