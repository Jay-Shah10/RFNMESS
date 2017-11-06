package gui;

import javafx.scene.control.Button;

import java.util.*;

import dataCollection.HostRightData;
import events.HostEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import models.Table;

public class HostRight extends VBox {
	
	
	private HBox hb;
	private static Button order;
	private Button reserve;
	private Button delete;
	private ComboBox<Table> cb, finishedTable;
	private Label party_name, table_reservation_label, up_next;
	private TextField tf;
	private ListView<Table> lv;
	private NewCenter centerReference;

	
	public HostRight() {

		// adds CSS to the Pane and properties to the pane.
		setStyle("-fx-background-color: rgba(52, 52, 49, 0.83)");
		this.setSpacing(10);
		this.setPadding(new Insets(10, 10, 10, 10));
		this.setMaxWidth(300);
		Region r = new Region();
		Region hr = new Region();

		// From top to bottom:
		// party name label
		// text field
		// combo box
		// reserve button
		// text area
		// combo box
		// delete button
		// to go button
		// and in house button

		party_name = new Label("Enter Party Name:");
		party_name.setStyle("-fx-text-fill: #fff");
		tf = new TextField();

		table_reservation_label = new Label("Pick a table form below: ");
		table_reservation_label.setStyle("-fx-text-fill: #fff");

		cb = new ComboBox<Table>();

		reserve = new Button("Reserve");
		reserve.setOnAction(
			(event) -> {
				HostEvent h = new HostEvent(getComboBox(), event.getTarget(), HostEvent.RESERVE_CLICKED);
				h.setPartyName(tf.getText());
				this.fireEvent(h);
			}
		);
		
		up_next = new Label("Next Table:");
		up_next.setStyle("-fx-text-fill: #fff");

		lv = new ListView<>();

		finishedTable = new ComboBox<Table>();
		
		
		delete = new Button("Delete");
		delete.setOnAction(
			(event) -> {
				HostEvent h = new HostEvent(lv.getSelectionModel().getSelectedItem(), event.getTarget(), HostEvent.DELETE_CLICKED);
				this.fireEvent(h);
			}
		);
		// adds property to the region.
		VBox.setVgrow(r, Priority.ALWAYS);
		
		order = new Button("Order");
		

		hb = new HBox();
		HBox.setHgrow(hr, Priority.ALWAYS);
		hb.setAlignment(Pos.CENTER);
		hb.getChildren().addAll(order);

		// adds all items to the vbox to display.
		getChildren().addAll(party_name, tf, table_reservation_label, cb, reserve, up_next, lv, delete, r);

	}
	
	public void populateTables(ArrayList<Table> tables) {
		cb.getItems().clear();
		finishedTable.getItems().clear();
		for (Table table : tables) {
			cb.getItems().add(table);
			finishedTable.getItems().add(table);
		}
	}

	public String getPartyText() {
		return this.tf.getText();
	}

	public Table getComboBox() {
		return this.cb.getValue();
	}

	public String getCancelComboBox() {
		return this.finishedTable.getValue().toString();
	}

	public Button getReserve() {
		return this.reserve;
	}

	public Button getDelete() {
		return this.delete;
	}

	public Button getOrder() {
		return this.order;
	}

	
	public void setCenterReference(NewCenter nc) {
		this.centerReference = nc;
	}

	@SuppressWarnings("unchecked")
	public void addToTextArea(Table t) {
		this.lv.getItems().add(t);
	}
	
	public void removeFromTextArea(Table t) {
		lv.getItems().remove(t);
	}

	public HostRightData getText() {
		return new HostRightData(this.tf.getText());
	}

	/**
	 * @param eh
	 */
	

}
