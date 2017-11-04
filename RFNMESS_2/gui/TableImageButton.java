package gui;

import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class TableImageButton extends Rectangle {

	public Rectangle rec;
	public double height, length;
	public double YPosition, XPosition;
	public Color c;

	public TableImageButton(double width, double height) {
		/*
		 * This class creates tables and gives them properties. This class.
		 * 
		 * For future, add border and make it look more 3-d. try to get rounded corners.
		 */
		
		this.setWidth(width);
		this.setHeight(height);
		this.setStyle("-fx-fill: rgba(242,242,242,1);");
		this.setArcHeight(15);
		this.setArcWidth(15);
		
		DropShadow shadow = new DropShadow();
		shadow.setColor(Color.color(0, 0, 0));
		shadow.setRadius(7.0);
		shadow.setOffsetX(5.0);
		shadow.setOffsetY(5.0);
		
		this.setEffect(shadow);

	}

	public TableImageButton getReserved() {
		
		DropShadow shadow = new DropShadow();
		shadow.setColor(Color.color(0, 0, 0));
		shadow.setRadius(7.0);
		shadow.setOffsetX(5.0);
		shadow.setOffsetY(5.0);
		
		this.setArcHeight(15);
		this.setArcWidth(15);
		this.setStyle("-fx-fill: rgba(255, 0, 0, 1)");
		this.setEffect(shadow);
		
		
		return this;
	}

	public TableImageButton getBusy() {
		
		DropShadow shadow = new DropShadow();
		shadow.setColor(Color.color(0, 0, 0));
		shadow.setRadius(7.0);
		shadow.setOffsetX(5.0);
		shadow.setOffsetY(5.0);
		
		this.setArcHeight(15);
		this.setArcWidth(15);
		this.setStyle("-fx-fill: rgba(255, 255, 0, 1)");
		this.setEffect(shadow);
		
		
		return this;
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
