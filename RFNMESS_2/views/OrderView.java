/**
 * 
 */
package views;

import gui.SearchBox;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.*;

/**
 * @author nryle
 *
 */
public class OrderView implements View {
	

	/* (non-Javadoc)
	 * @see views.View#getCenter()
	 */
	@Override
	public Node getCenter() {
		// TODO Auto-generated method stub
		return left;
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
	
	public OrderView() {
		initLeft();
	}
	
	private VBox left;
	
	private void initLeft() {
		left = new VBox();
		left.getStyleClass().add("pane");
		
		SearchBox searchBox = new SearchBox();
		left.getChildren().add(searchBox);
	}

}
