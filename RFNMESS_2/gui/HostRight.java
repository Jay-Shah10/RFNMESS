package gui;

import javafx.scene.control.Button;

import java.util.*;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class HostRight extends VBox {
	
	private ArrayList tables = new ArrayList();
	private HBox hb;
	private Button to_go, in_house, reserve, finished;
	private ComboBox<Integer> cb;
	private ComboBox finishedTable;
	private TextArea ta;
	public HostRight() {

		// adds CSS to the Pane and properties to the pane.
		setStyle("-fx-background-color: rgba(52, 52, 49, 0.83)");
		this.setSpacing(10);
		this.setPadding(new Insets(5, 5, 5, 5));
		this.setMaxWidth(300);
		

		// adds all the items to the Pane.
		TextField tf = new TextField();
		Region r = new Region();
		
		cb = new ComboBox();
		ta = new TextArea();
		
		reserve = new Button("Reserve");
	
		
		
		Label party_name = new Label("Enter Party Name:");
		party_name.setStyle("-fx-text-fill: #fff");
		
		Label table_reservation_label = new Label("Pick a table form below: ");
		table_reservation_label.setStyle("-fx-text-fill: #fff");
		
		Label up_next = new Label("Next Table:");
		up_next.setStyle("-fx-text-fill: #fff");
		
		finished = new Button("Delete");
		finishedTable = new ComboBox();

		// adds items to the combo box.
		for (int i = 0; i < 13; i++) {
			cb.getItems().add(i);
		}
		// adds property to the region.
		this.setVgrow(r, Priority.ALWAYS);
		
		for (int j=0; j<13; j++){
			finishedTable.getItems().add(j);
		}
		
		
		to_go = new Button("To-Go!");
		in_house = new Button("In-House");
		hb = new HBox();
		Region hr = new Region();
		hb.setHgrow(hr, Priority.ALWAYS);
		hb.getChildren().addAll(to_go, hr, in_house);
		/*
		 * First the cb box allows them to click which table they want to reserve. 
		 * reserve button allows the user to store that and pops up in the text area. 
		 * finished button allows user to delete any table in there. 
		 * 
		 * these table numbers need to stored in one place. 
		 */

		// adds all items to the vbox to display.
		getChildren().addAll(party_name, tf, table_reservation_label, cb, reserve, up_next, ta, finishedTable, finished, r, hb);

	}
}
