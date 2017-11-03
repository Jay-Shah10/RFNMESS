package views;

import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

class OrderPageLeft extends GridPane {
	private TextField search;
	private Button go;
	private TabPane tab;
	private Tab drinks;
	private Tab appetizers;
	private Tab entrees;
	private Tab desserts;
	private TextArea list1;
	private TextArea list2;
	private TextArea list3;
	private TextArea list4;
	
	public OrderPageLeft() {
		this.setHgap(10);
		this.setVgap(10);
		
		search = new TextField();
		add(search, 0, 0);
		search.setPromptText("Search all Menu Items");
		
		go = new Button("Search");
		add(go, 1, 0);
		
		tab = new TabPane();
		add(tab, 0, 1);
		this.setVgrow(tab, Priority.ALWAYS);
		
		drinks = new Tab("Drinks");
		/*
		 * create nodes to add in this tab (pane1) add it to the tab(pane1). repeat for each tab. 		
		 */
		VBox d = new VBox();
		list1 = new TextArea();
		d.getChildren().add(list1);
		drinks.setContent(d);
		list1.setPrefSize(500, 800);
		
		VBox a = new VBox();
		appetizers = new Tab("Appetizers");
		list2 = new TextArea();
		a.getChildren().add(list2);
		appetizers.setContent(a);
		list2.setPrefSize(500, 800);
		
		VBox e = new VBox();
		entrees = new Tab("Entrees");
		list3 = new TextArea();
		e.getChildren().add(list3);
		entrees.setContent(e);
		list3.setPrefSize(500, 800);
		
		VBox ds = new VBox();
		desserts = new Tab("Desserts");
		list4 = new TextArea();
		ds.getChildren().add(list4);
		desserts.setContent(ds);
		list4.setPrefSize(500, 800);
		
		tab.getTabs().addAll(drinks, appetizers, entrees, desserts);
			
		
	}
}
