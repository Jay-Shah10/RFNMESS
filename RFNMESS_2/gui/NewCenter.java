package gui;

import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class NewCenter extends StackPane {

	public Rectangle table1;
	private Rectangle table2;
	private Rectangle table3;
	private Rectangle table4;
	private Rectangle table5;
	private Rectangle table6;
	private Rectangle table7;
	private Rectangle table8;
	private Rectangle table9;

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
		Button b = new Button();
		
		
		//first top row.
		table1 = new TableImageButtons(200, 100);
		table1.setTranslateX(-300);
		table1.setTranslateY(-300);
		b.setGraphic(table1);
		
		table2 = new TableImageButtons(200, 100);
		table2.setTranslateX(-600);
		table2.setTranslateY(-300);
		
		table3 = new TableImageButtons(200,100);
		table3.setTranslateY(-300);
		
		//middle row. 
		table4 = new TableImageButtons(200,100);
		table4.setTranslateX(-600);
		
		table5 = new TableImageButtons(200,100);
		table5.setTranslateX(-300);
		
		table6 = new TableImageButtons(200,100);
		
		//bottom row.
		table7 = new TableImageButtons(200,100);
		table7.setTranslateY(300);
		table7.setTranslateX(-600);
		
		table8 = new TableImageButtons(200,100);
		table8.setTranslateY(300);
		table8.setTranslateX(-300);
		
		table9 = new TableImageButtons(200,100);
		table9.setTranslateY(300);
		
		//table9.setTranslateX(600);
		//table9.setOnMouseClicked(new EventHandler<moustClicked>);
		
		
		this.getChildren().addAll(b, table2, table3, table4, table5, table6, table7, table8, table9);

	}

}
