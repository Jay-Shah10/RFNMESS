package gui;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class TableImageButtons extends Rectangle {
	
	public Rectangle rec; 
	public double height, length; 
	public double YPosition, XPosition;
	public Color c; 
	
	public TableImageButtons(double width, double height)  {
		/*
		 * This class creates tables and gives them properties. 
		 * This class. 
		 * 
		 * For future, add border and make it look more 3-d. try to get rounded corners. 
		 */
		
		this.setWidth(width);
		this.setHeight(height);
		this.setStyle("-fx-fill: rgba(166,166,166,1);");
		
		
	}
	
	public double getHeight(double height) {
		return this.height = height; 
	}
	public double getLength(double lenght) {
		return this.length = length; 
	}
	
	public double getYPosistion(double yposition) {
		return this.YPosition = yposition;
	}
	public double getXPosition(double xposition) {
		return this.XPosition = xposition;
	}
	
	
	

}
