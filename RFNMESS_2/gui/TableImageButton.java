package gui;

import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import models.Table;

public class TableImageButton extends Rectangle {
	private Table table;
	public double height, length;
	public double YPosition, XPosition;

	public TableImageButton(double width, double height) {
		/*
		 * This class creates tables and gives them properties. This class.
		 * 
		 * For future, add border and make it look more 3-d. try to get rounded corners.
		 */
		
		this.setWidth(width);
		this.setHeight(height);
		this.addClass("table");
		this.setArcHeight(15);
		this.setArcWidth(15);
		
		DropShadow shadow = new DropShadow();
		shadow.setColor(Color.color(0, 0, 0));
		shadow.setRadius(7.0);
		shadow.setOffsetX(5.0);
		shadow.setOffsetY(5.0);
		
		this.setEffect(shadow);

	}
	
	public boolean isForTable(Table t) {
		return this.table == t;
	}
	
	public TableImageButton(Table t, double width, double height) {
		this(width, height);
		this.table = t;
	}
	
	private void toggleClass(String c) {
		if(this.getStyleClass().contains(c))
			this.getStyleClass().remove(c);
		else
			this.getStyleClass().add(c);
	}
	
	private void addClass(String c) {
		if(!this.getStyleClass().contains(c))
			this.getStyleClass().add(c);
	}
	
	private void removeClass(String c) {
		if(this.getStyleClass().contains(c))
			this.getStyleClass().remove(c);
	}

	public void setReserved() {
		this.addClass("reserved");
		
	}
	public void removeReserved() {
		this.removeClass("reserved");	
	}
	
	
	public void toggleReserved() {
		this.toggleClass("reserved");
	}

	public Rectangle getBusy() {
		
		DropShadow shadow = new DropShadow();
		shadow.setColor(Color.color(0, 0, 0));
		shadow.setRadius(7.0);
		shadow.setOffsetX(5.0);
		shadow.setOffsetY(5.0);
		
		this.setArcHeight(15);
		this.setArcWidth(15);
		this.setEffect(shadow);
		
		
		return this;
	}

	public double getHeight(double height) {
		return this.height = height;
	}

	public double getLength(double length) {
		return this.length = length;
	}

	public double getYPosistion(double yposition) {
		return this.YPosition = yposition;
	}

	public double getXPosition(double xposition) {
		return this.XPosition = xposition;
	}

}
