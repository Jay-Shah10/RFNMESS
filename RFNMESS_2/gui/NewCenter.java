 package gui;

import java.util.ArrayList;

import events.HostEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import models.Table;

public class NewCenter extends TilePane {

	private ArrayList<TableImageButton> tableButtons;
	
	public TableImageButton getButtonForTable(Table t) {
		for (TableImageButton tableImageButton : tableButtons) {
			if(tableImageButton.isForTable(t)) return tableImageButton;
		}
		return null;
	}

	public NewCenter() {
		/*
		 * This class is the new center view of the master pane. It is a stack pane,
		 * which holds bunch of tables. 
		 * set translate x changes the x values in the direction you want to move the table.
		 * set translate y changes the y values in the direction you want to move the table.
		 * 
		 * These "tables" could also just be buttons with effects on them. 
		 * Clicking would be easier. 
		 */

		//this.setStyle("-fx-background-color: rgba(52, 52, 49, 0.83);");
		this.getStyleClass().add("pane");
		
		this.setHgap(300);
		this.setVgap(50);
		//this.setPadding(new Insets(100,100,100,100));
		
		
		this.setPrefColumns(3);
		this.setPrefRows(3);
		
		tableButtons = new ArrayList<>();
		
	}
	
	public void populateTables(ArrayList<Table> tables) {
		for (Table table : tables) {
			TableImageButton tib = new TableImageButton(table, 200, 100);
			tableButtons.add(tib);
			this.getChildren().add(tib);
			tib.setOnMouseClicked(
				(event)->{
					tib.toggleReserved();
				});
		}
	}
}
