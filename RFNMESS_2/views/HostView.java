package views;

import java.io.IOException;

import gui.HostCenterGrid;
import gui.HostRight;
import gui.NewCenter;
import gui.TableImageButtons;
import javafx.application.*;
import javafx.collections.*;
import javafx.css.*;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.layout.*;

public class HostView implements views.View {

	private Node left, right, center, bottom;
	private String selectTable;
	public TableImageButtons t;
	public HostCenterGrid gp;
	public HostRight vb;
	public NewCenter nc;

	public HostView() {

		gp = new HostCenterGrid();
		nc = new NewCenter();
		this.center = nc;

		/*
		 * this is for the right side of the border pane
		 */

		vb = new HostRight();
		this.right = vb;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see views.View#getLeft()
	 */
	public Node getLeft() {
		// TODO Auto-generated method stub

		return this.left;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see views.View#getRight()
	 */
	public Node getRight() {
		// TODO Auto-generated method stub
		return this.right;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see views.View#getCenter()
	 */
	public Node getCenter() {
		// TODO Auto-generated method stub
		return this.center;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see views.View#getBottom()
	 */
	public Node getBottom() {
		// TODO Auto-generated method stub
		return this.bottom;
	}

	public void setOnReserve() {
		/*
		 * This method will set the table image to reserve. 
		 */
		
	}

	public void refreshRight() {
		/*
		 * display the new updated info to the right side of the gridPane. this new
		 * updated info is from the table(number) clicked, party name, and may time.
		 */

	}

}
