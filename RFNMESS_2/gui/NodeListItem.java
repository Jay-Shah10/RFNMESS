/**
 * 
 */
package gui;

import events.OrderEvent;
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
public class NodeListItem<T> extends HBox {

	private T 				model;
	private VBox			mainVertical;
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
		VBox.setVgrow(addButton, Priority.ALWAYS);
		this.addButton.getStyleClass().add("node-list-btn");
		
		this.removeButton = new Button("-");
		VBox.setVgrow(removeButton, Priority.ALWAYS);
		this.removeButton.getStyleClass().add("node-list-btn");
		
		this.editButton = new Button("E");
		VBox.setVgrow(editButton, Priority.ALWAYS);
		this.editButton.getStyleClass().add("node-list-btn");
		
		this.txtMain = new Text(model.toString());
		this.txtMain.getStyleClass().add("node-list-txt");
		
		textHolder = new HBox();
		textHolder.getChildren().add(txtMain);
		textHolder.getStyleClass().add("node-list-main");
		HBox.setHgrow(textHolder, Priority.ALWAYS);
		
		mainVertical = new VBox();
		this.getChildren().add(mainVertical);
		HBox.setHgrow(mainVertical, Priority.ALWAYS);
		
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
		
		mainVertical.getChildren().clear();
		mainVertical.getChildren().add(main);
		//this.getChildren().add(main);
		
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
	
	public void setOnAdd(EventHandler<ActionEvent> hndlr) {
		if(this.addButton != null) {
			this.addButton.setOnAction(hndlr);
		}
	}
	
	public void setOnRemove(EventHandler<ActionEvent> hndlr) {
		if(this.removeButton != null) {
			this.removeButton.setOnAction(hndlr);
		}
	}
	
	public void setOnEdit(EventHandler<ActionEvent> hndlr) {
		if(this.editButton != null) {
			this.editButton.setOnAction(hndlr);
		}
	}

}
