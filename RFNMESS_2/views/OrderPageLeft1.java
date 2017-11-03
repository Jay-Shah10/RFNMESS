package views;

import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

class OrderPageLeft1 extends GridPane {
	private TextField search;
	private TextArea CurrentIngredient;
	private TextArea AddIngredient;
	//private Button add;
	public OrderPageLeft1() {
		
		search = new TextField();
		add(search, 0, 0);
		
		CurrentIngredient = new TextArea();
		add(CurrentIngredient, 0, 1);
		
		AddIngredient = new TextArea();
		add(AddIngredient, 0 , 2);
		
	}
}
