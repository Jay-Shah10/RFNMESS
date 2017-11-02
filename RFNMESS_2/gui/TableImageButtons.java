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
		 * This calss 
		 */
		this.setWidth(width);
		this.setHeight(height);
		this.setFill(Color.GRAY);
		
		
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
