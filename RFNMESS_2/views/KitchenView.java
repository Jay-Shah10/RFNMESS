/**
 * 
 */
package views;

import gui.HostCenterGrid;
import gui.HostRight;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.util.Callback;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;

/**
 * Shena Cao
 *
 */
public class KitchenView implements View {

	private Node left, right, bottom;


	public KitchenView(){


		//GridPane kitchenCenterGrid = new GridPane();
		//GridPane kitchenLabelGrid = new GridPane();
		//GridPane kitchenOrders = new GridPane();
		VBox vboxLeft = new VBox(8);
		VBox vboxRight = new VBox(8);
		//kitchenCenterGrid.setHgap(10);
		//kitchenCenterGrid.setVgap(10);
		
		 //Label for Kitchen View
	    Label label = new Label("ORDERS:");
	    //label.setStyle("-fx-text-fill: #FFFFFF");
	    label.setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
	    label.setStyle("-fx-background-color: rgba(255, 255, 255, 0.8)");
	    label.setFont(new javafx.scene.text.Font ("Verdana", 30));
	    //kitchenCenterGrid.add(label, 0, 1);
	    /*
	    ListView list = new ListView();
	    VBox.setVgrow(list, Priority.ALWAYS);
	    vbox.getChildren().addAll(new Label("Names:"), list);
		*/
		
		//Buttons for KitchenView
		Button buttonCurrent = new Button("Edit Order");
		buttonCurrent.setFont(new javafx.scene.text.Font ("Verdana", 20));
		buttonCurrent.setPrefSize(200, 100);
		buttonCurrent.setMaxSize(200, 100);
	    //kitchenCenterGrid.add(buttonCurrent, 1,3);

	    Button buttonProjected = new Button("Remove Order");
	    buttonProjected.setFont(new javafx.scene.text.Font ("Verdana", 20));
	    buttonProjected.setPrefSize(200,100);	    
	    buttonProjected.setMaxSize(200,100);
	    //kitchenCenterGrid.add(buttonProjected, 0,3);
	    
	    System.setProperty("glass.accessible.force", "false");

	    //ComboBox 
	    ComboBox<Color> cmb = new ComboBox<Color>();
	    cmb.getItems().addAll(
	        Color.RED,
	        Color.GREEN,
	        Color.BLUE);

	    cmb.setCellFactory(new Callback<ListView<Color>, ListCell<Color>>() {
	        @Override public ListCell<Color> call(ListView<Color> p) {
	            return new ListCell<Color>() {
	                private final Rectangle rectangle;
	                { 
	                    setContentDisplay(ContentDisplay.GRAPHIC_ONLY); 
	                    rectangle = new Rectangle(10, 10);
	                }
	                
	                @Override protected void updateItem(Color item, boolean empty) {
	                    super.updateItem(item, empty);
	                    
	                    if (item == null || empty) {
	                        setGraphic(null);
	                    } else {
	                        rectangle.setFill(item);
	                        setGraphic(rectangle);
	                    }
	               }
	          };
	      }
	   });
	    //kitchenCenterGrid.add(cmb, 0, 0);

		//kitchenCenterGrid.add(label, 3,7);
	    
		ObservableList<String> names = FXCollections.observableArrayList("Jay", "Nathan");
		ListView<String> listView = new ListView<String>(names);
		//kitchenCenterGrid.add(listView, 0, 2);
		
		left = vboxLeft;
		right =vboxRight;
		//right = kitchenLabelGrid;
		
		//Set Label Order in gridpane center
		GridPane.setHalignment(label, HPos.CENTER);
	    label.setAlignment(Pos.CENTER_LEFT);
	    
	    //Set ComboBox center
	    //GridPane.setHalignment(cmb, HPos.CENTER);
	   // cmb.setParent(Pos.CENTER_LEFT);

		//bottom = kitchenOrders;
	    //right = kitchenLabel;
	    /*
		 * this is for the  of the border pane
		 */
		//kitchenOrders vb = new kitchenOrders();
		//bottom = vb;


	}
	/* (non-Javadoc)
	 * @see views.View#getCenter()
	 */

	@Override
	public Node getCenter() {
		// TODO Auto-generated method stub
		Pane canvas = new Pane();

		return null;
	}

	/* (non-Javadoc)
	 * @see views.View#getRight()
	 */
	@Override
	public Node getRight() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see views.View#getLeft()
	 */
	@Override
	public Node getLeft() {
		// TODO Auto-generated method stub
		return left;
	}

	/* (non-Javadoc)
	 * @see views.View#getBottom()
	 */
	@Override
	public Node getBottom() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see views.View#addEventHandler(javafx.event.EventType, javafx.event.EventHandler)
	 */
	@Override
	public <T extends Event> void addEventHandler(EventType<T> eventType, EventHandler<? super T> eventHandler) {
		// TODO Auto-generated method stub

	}

}
