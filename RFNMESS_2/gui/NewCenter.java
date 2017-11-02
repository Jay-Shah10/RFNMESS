package gui;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class NewCenter extends StackPane {
	
	public TableImageButtons tib; 
	
	public NewCenter() {
		/*
		 * This class is the new center view of the master pane. 
		 * It is a stack pane, which holds bunch of tables. 
		 * 
		 */
		
		this.setStyle("-fx-background-color: #ffff");
		tib = new TableImageButtons(150, 100);
		
		// set translatex changes the x values in the direction you want to move the table. 
		// set translate y changes the y values in the direction you want to move the table. 
		
		tib.setTranslateX(60);
		this.getChildren().add(tib);
		
		
	}

}
