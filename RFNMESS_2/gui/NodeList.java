package gui;

import java.util.ArrayList;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.layout.VBox;

public class NodeList<T> extends VBox {
	private NodeListItem<T> selected = null;
	
	public NodeList() {
		
	}
	
	public void clear() {
		this.getChildren().clear();
	}

	public void add(NodeListItem<T> item) {
		this.getChildren().add(item);
		if(this.selected == null) {
			this.selected = item;
		}
	}
	
	public void add(T model, boolean add, boolean remove, boolean edit, Node expand) {
		NodeListItem<T> item = new NodeListItem<T>(model, add, remove, edit, expand!=null);
		if(expand!=null) {
			item.setExpandableNode(expand);
		}
		
		this.add(item);
	}
	
	public void add(T model) {
		this.add(model, false, false, false, null);
	}
	
	public NodeListItem<T> getSelectedNode() {
		return this.selected;
	}
	
	public T getSelectedItem() {
		if(this.selected==null) {
			return null;			
		}
		else {
			return this.selected.getItem();			
		}
	}
}
