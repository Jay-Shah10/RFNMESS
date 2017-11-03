package views;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;

class OrderPageRight extends GridPane {
	private TextArea list;
	private Button bill;
	private Button closeout;
	//private Button edit;
	//private Button delete;
	private ComboBox<String> table;
	private ComboBox<String> party;
	
	public OrderPageRight() {
		this.setHgap(10);
		this.setVgap(10);
		
		table = new ComboBox<String>();
		table.getItems().addAll("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");
		add(table, 0, 0);
		
		party = new ComboBox<String>();
		party.getItems().addAll("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");
		add(party, 1, 0);
		
		list = new TextArea();
		add(list, 0, 2);
		list.setPrefSize(900, 800);
		
		bill = new Button("Generate Bill");
		add(bill, 0, 4);
		//bill.setAlignment(Pos.CENTER_LEFT);
		
		closeout = new Button("Close Out Table");
		add(closeout, 1, 4);
		//this.setAlignment(Pos.CENTER);
	}
}
