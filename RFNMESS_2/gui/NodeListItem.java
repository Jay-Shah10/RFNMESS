/**
 * 
 */
package gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

/**
 * @author nryle
 *
 */
public class NodeListItem<T> extends VBox {

	private T 				model;
	private HBox 			main,
							textHolder;
	private Node			expand;
	private Button 			addButton,
							removeButton,
							editButton;
	
	private Text			txtMain;
	
	private boolean			showAdd,
							showRemove,
							showEdit,
							isExpandable;
	
	public NodeListItem(T model, boolean add, boolean remove, boolean edit, boolean expandable) {
		this.getStyleClass().add("node-list-item");
		this.model = model;
		this.showAdd = add;
		this.showRemove = remove;
		this.showEdit = edit;
		this.isExpandable = expandable;
		
		this.addButton = new Button("+");
		this.removeButton = new Button("-");
		this.editButton = new Button("E");
		
		this.txtMain = new Text(model.toString());
		
		textHolder = new HBox();
		textHolder.getChildren().add(txtMain);
		textHolder.getStyleClass().add("node-list-main");
		HBox.setHgrow(textHolder, Priority.ALWAYS);
		
		updateLayout();
	}
	
	public NodeListItem(T model) {
		this(model, false, false, false, false);
	}
	
	public void setShowAdd(boolean b) {
		this.showAdd = b;
	}
	
	public void setShowRemove(boolean b) {
		this.showRemove = b;
	}
	
	public void setShowEdit(boolean b) {
		this.showEdit = b;
	}
	
	public void setExpandable(boolean b) {
		this.isExpandable = b;
	}
	
	public void setExpandableNode(Node n) {
		this.expand = n;
	}
	
	public T getItem() {
		return this.model;
	}
	
	private void updateLayout() {
		this.getChildren().clear();
		main = new HBox();
		main.setAlignment(Pos.CENTER_LEFT);
		main.getChildren().add(textHolder);
		
		
		if(this.showEdit) {
			main.getChildren().add(editButton);
		}
		
		if(this.showRemove) {
			main.getChildren().add(removeButton);
		}
		
		if(this.showAdd) {
			main.getChildren().add(addButton);
		}
		
		this.getChildren().add(main);
		
		if(this.isExpandable) {
			this.getChildren().add(expand);
			expand.setVisible(false);
			txtMain.setOnMouseClicked(expandHandler);
		} else {
			txtMain.setOnMouseClicked(null);
		}
	}
	
	private EventHandler<MouseEvent> expandHandler = (event) -> {
		expand.setVisible(!expand.isVisible());
	};

}
