package gui;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import models.Ingredient;

public class NodeList<T> extends ScrollPane {
	private NodeListItem<T> selected = null;
	private VBox main = new VBox();
	
	public NodeList() {
		main.getStyleClass().add("node-list");
		this.setContent(main);
		this.setFitToHeight(true);
		this.setFitToWidth(true);
	}
	
	public void clear() {
		main.getChildren().clear();
	}

	public void add(NodeListItem<T> item) {
		main.getChildren().add(item);
		if(this.selected == null) {
			this.selected = item;
		}
	}
	
	public NodeListItem<T> add(T model, boolean add, boolean remove, boolean edit, Node expand) {
		NodeListItem<T> item = new NodeListItem<T>(model, add, remove, edit, expand!=null);
		if(expand!=null) {
			item.setExpandableNode(expand);
		}
		
		this.add(item);
		return item;
	}
	
	public NodeListItem<T> add(T model) {
		return this.add(model, false, false, false, null);
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

	/**
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<T> getList() {
		// TODO Auto-generated method stub
		List<T> list = new ArrayList<T>();
		for (Node item : main.getChildren()) {
			list.add(((NodeListItem<T>)item).getItem());
		}
		return list;
	}

	/**
	 * @param item
	 */
	public void remove(NodeListItem<T> item) {
		main.getChildren().remove(item);
	}
}
