/**
 * 
 */
package views;

import java.util.Queue;

import javafx.scene.Node;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import models.MenuItem;
import models.Order;

/**
 * @author nryle
 *
 */
public class KitchenView implements View {

	private Queue<Order> 	listOrders;
	private VBox 			currentOrder,
							nextOrder;
	private HBox 			center;
	
	/**
	 * 
	 */
	public KitchenView() {
		
		center = new HBox();
		center.setSpacing(20);
		
		currentOrder = createBox("Current Order");
		nextOrder = createBox("Next Order");
		
		center.getChildren().add(currentOrder);
		center.getChildren().add(nextOrder);
	}

	/* (non-Javadoc)
	 * @see views.View#getCenter()
	 */
	@Override
	public Node getCenter() {
		// TODO Auto-generated method stub
		return center;
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
		return null;
	}

	/* (non-Javadoc)
	 * @see views.View#getBottom()
	 */
	@Override
	public Node getBottom() {
		// TODO Auto-generated method stub
		return null;
	}
	
	private static VBox createBox(String title) {
		VBox box = new VBox();
		box.getStyleClass().add("pane");
		
		box.getStyleClass().add("kitchen-order");
		HBox.setHgrow(box, Priority.ALWAYS);
		
		Text txtTitle = new Text(title);
		box.getChildren().add(txtTitle);
		
		ListView<MenuItem> itemList = new ListView<MenuItem>();
		box.getChildren().add(itemList);
		VBox.setVgrow(itemList, Priority.ALWAYS);
		
		return box;
	}

}
