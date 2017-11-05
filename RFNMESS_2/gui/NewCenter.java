 package gui;

import events.HostEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class NewCenter extends TilePane {

	private Rectangle table1;
	private Rectangle table2;
	private Rectangle table3;
	private Rectangle table4;
	private Rectangle table5;
	private Rectangle table6;
	private Rectangle table7;
	private Rectangle table8;
	private Rectangle table9;
	
	public TableImageButton tib;
	
	public TableImageButton getTabel() {
		return tib;
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

		this.setStyle("-fx-background-color: rgba(52, 52, 49, 0.83);");
		
		this.setHgap(300);
		this.setVgap(50);
		this.setPadding(new Insets(100,100,100,100));
		
		
		this.setPrefColumns(3);
		this.setPrefRows(3);
		
		
		table1 = new TableImageButton(200,100);
		table1.setOnMouseClicked(
				(event)->{
					this.table1.setStyle("-fx-fill: rgba(255, 0 , 0, 1);");
				});
		
		table2 = new TableImageButton(200,100);
		table3 = new TableImageButton(200,100);
		table4 = new TableImageButton(200,100);
		table5 = new TableImageButton(200,100);
		table6 = new TableImageButton(200,100);
		table7 = new TableImageButton(200,100);
		table8 = new TableImageButton(200,100);
		table9 = new TableImageButton(200,100);
		
		
		this.getChildren().add(table1);
		this.getChildren().add(table2);
		this.getChildren().add(table3);
		this.getChildren().add(table4);
		this.getChildren().add(table5);
		this.getChildren().add(table6);
		this.getChildren().add(table7);
		this.getChildren().add(table8);
		this.getChildren().add(table9);
	}
	
	
	public Rectangle getTable1() {
		return this.table1;
	}
	public Rectangle getTable2() {
		return this.table2;
	}
	public Rectangle getTable3() {
		return this.table3;
	}
	public Rectangle getTable4() {
		return this.table4;
	}
	public Rectangle getTable5() {
		return this.table5;
	}
	public Rectangle getTable6() {
		return this.table6;
	}
	public Rectangle getTable7() {
		return this.table7;
	}
	public Rectangle getTable8() {
		return this.table8;
	}
	public Rectangle getTable9() {
		return this.table9;
	}
	
	public void setTable1(Rectangle r) {
		r.setStyle("-fx-fill: rgba(255, 0, 0);");
	}
	
	

}
