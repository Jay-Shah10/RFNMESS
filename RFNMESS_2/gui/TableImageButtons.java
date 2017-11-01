package gui;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class TableImageButtons {
	
	public Rectangle table;
	public double height, length; 
	
	public TableImageButtons() {
		table = new Rectangle();
		table.setHeight(this.getHeight(10));
		table.setWidth(this.getLength(15));
		defaultView(this.table);
	}
	
	public double getHeight(double height) {
		return this.height = height; 
	}
	public double getLength(double lenght) {
		return this.length = length; 
	}
	
	
	public Rectangle getTable() {
		return this.table;
	}
	
	
	public void defaultView(Rectangle r) {
		this.table = r; 
		r.setFill(Color.GRAY);
		//r.setFill(Color.rgb(red, green, blue, opacity));
	}
	public void newView(Rectangle nr) {
		this.table = nr; 
		nr.setFill(Color.RED);
		//nr.setFill(Color.rgb(red, green, blue, opacity));
	}
}
