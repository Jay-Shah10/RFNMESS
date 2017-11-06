/**
 * 
 */
package views;

import java.util.LinkedList;

import events.OrderEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
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

	private LinkedList<Order> 	listOrders;
	private VBox 				currentOrder,
								nextOrder;
	private HBox 				center,
								bottom;
	
	private Button 				btnMarkComplete;
	
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
		
		bottom = new HBox();
		bottom.setAlignment(Pos.CENTER);
		
		btnMarkComplete = new Button("Order Complete");
		bottom.getChildren().add(btnMarkComplete);
		btnMarkComplete.setMinWidth(300);
		btnMarkComplete.setDisable(true);
		btnMarkComplete.setOnAction(
			(event) -> {
				OrderEvent evt = new OrderEvent(null, btnMarkComplete, OrderEvent.ORDER_FULFILLED);
				evt.setOrder(listOrders.poll());
				this.bottom.fireEvent(evt);
				refresh();
				if(listOrders.isEmpty())
					btnMarkComplete.setDisable(true);
			}
		);
		
		listOrders = new LinkedList<>();				
	}

	/* (non-Javadoc)
	 * @see views.View#getCenter()
	 */
	@Override
	public Node getCenter() {
		// TODO Auto-generated method stub
		refresh();
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
		return bottom;
	}
	
	/**
	 * @param order
	 */
	public void addNewOrder(Order order) {
		if(!listOrders.contains(order)) {
			listOrders.add(order);	
			btnMarkComplete.setDisable(false);
		}
	}

	/**
	 * @param order
	 */
	public void removeOrder(Order order) {
		listOrders.remove(order);
		if(listOrders.isEmpty())
			btnMarkComplete.setDisable(true);
	}
	
	public void setOnOrderFulfilled(EventHandler<OrderEvent> e) {
		this.bottom.addEventHandler(OrderEvent.ORDER_FULFILLED, e);
	}
	
	@SuppressWarnings("unchecked")
	private static void refreshOrderBox(VBox vb, Order o) {
		ListView<MenuItem> lv = (ListView<MenuItem>) vb.getChildren().get(1);
		lv.getItems().clear();
		if(o != null) {
			for (MenuItem i : o.getMenuItems()) {
				lv.getItems().add(i);
			}
		}
	}
	
	public void refresh() {
		if(listOrders.size()>0) {
			refreshOrderBox(currentOrder, listOrders.get(0));			
		} else {
			refreshOrderBox(currentOrder, null);
		}
		
		if(listOrders.size()>1) {
			refreshOrderBox(nextOrder, listOrders.get(1));			
		} else {
			refreshOrderBox(nextOrder, null);
		}
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
