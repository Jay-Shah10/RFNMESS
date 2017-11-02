package gui;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class NewCenter extends StackPane {
	
	public TableImageButtons tib; 
	
	public NewCenter() {
		
		this.setStyle("-fx-background-color: #ffff");
		tib = new TableImageButtons(150, 100);
		
		
		tib.setTranslateX(60);
		this.getChildren().add(tib);
		
		
	}

}
