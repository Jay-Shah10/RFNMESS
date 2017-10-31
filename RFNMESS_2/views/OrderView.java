/**
 * 
 */
package views;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

/**
 * @author Zaheer Tajani
 *
 */
public class OrderView implements View {
	private VBox right;
	private VBox left;
	private TextArea drinks;
	private TextArea menuImage;
	private TextField search;
	private TextArea food;
	private Button inHouse;
	private Button ToGo;
	private Region region;
	/* (non-Javadoc)
	 * @see views.View#getCenter()
	 */
	@Override
	public Node getCenter() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see views.View#getRight()
	 */
	@Override
	public Node getRight() {
		// TODO Auto-generated method stub
		return right;
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
	
	public OrderView() {
		search = new TextField();
		left.getChildren().add(search);
		search.setPromptText("Search for all Menu Items");
		search.setEditable(true);
		
		drinks = new TextArea();
		drinks.setPrefSize(300, 500);
		drinks.setPromptText("Premium Drinks!");
		left.getChildren().add(drinks);
		drinks.setEditable(false);
		
		menuImage = new TextArea();
		left.getChildren().add(menuImage);
		menuImage.setPrefSize(300, 300);
		menuImage.setEditable(false);
		menuImage.setPromptText("MENU!");
		
		inHouse = new Button("In House");
		right.getChildren().add(inHouse);
		inHouse.setAlignment(Pos.CENTER_LEFT);
		
		ToGo = new Button("To Go");
		right.getChildren().add(ToGo);
		ToGo.setAlignment(Pos.CENTER_RIGHT);

		food = new TextArea();
		right.getChildren().add(food);
		food.setPrefSize(300, 500);
		food.setEditable(false);
		food.setPromptText("Food List!");
	}

}
