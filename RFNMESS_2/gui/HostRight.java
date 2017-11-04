package gui;

import javafx.scene.control.Button;

import java.util.*;

import dataCollection.HostRightData;
import events.HostEvent;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class HostRight extends VBox {

	private ArrayList<?> tables = new ArrayList<Object>();
	private HBox hb;
	private Button to_go, in_house, reserve, finished;
	private ComboBox<Integer> cb, finishedTable;
	private Label party_name, table_reservation_label, up_next;
	private TextField tf;
	private TextArea ta;
	private ArrayList textAreaList = new ArrayList();
	private ListView lv;

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

		cb = new ComboBox<Integer>();
		cb.getItems().add(null);
		// adds items to the combo box.
		for (int i = 1; i < 10; i++) {
			cb.getItems().add(i);
		}

		reserve = new Button("Reserve");
		up_next = new Label("Next Table:");
		up_next.setStyle("-fx-text-fill: #fff");
		ta = new TextArea();

		lv = new ListView();

		finishedTable = new ComboBox<Integer>();
		finishedTable.getItems().add(null);
		for (int j = 1; j < 10; j++) {
			finishedTable.getItems().add(j);
		}
		finished = new Button("Delete");
		// adds property to the region.
		VBox.setVgrow(r, Priority.ALWAYS);
		to_go = new Button("To-Go!");
		in_house = new Button("In-House");

		hb = new HBox();
		HBox.setHgrow(hr, Priority.ALWAYS);
		hb.getChildren().addAll(to_go, hr, in_house);
		/*
		 * First the cb box allows them to click which table they want to reserve.
		 * reserve button allows the user to store that and pops up in the text area.
		 * finished button allows user to delete any table in there.
		 * 
		 * these table numbers need to stored in one place.
		 */

		// adds all items to the vbox to display.
		getChildren().addAll(party_name, tf, table_reservation_label, cb, reserve, up_next, ta, lv, finishedTable,
				finished, r, hb);

		this.reserve.setOnAction((event) -> {
			this.fireEvent(new HostEvent(reserve, this, HostEvent.reserveClicked));
		});
		
		int deleteItem = this.lv.getSelectionModel().getSelectedIndex();
		this.finished.setOnAction((event) -> {
			
			
		});

	}

	public String getPartyText() {
		return this.tf.getText();
	}

	public int getComboBox() {
		return (int) this.cb.getValue();
	}

	public int getCancelComboBox() {
		return (int) this.finishedTable.getValue();
	}

	public Button getReserve() {
		return this.reserve;
	}

	public Button getDelet() {
		return this.finished;
	}

	public Button getInHouse() {
		return this.in_house;
	}

	public Button getToGo() {
		return this.to_go;
	}

	@SuppressWarnings("unchecked")
	public void setTextArea() {
		String waitList = this.cb.getValue() + ": " + tf.getText() + "\n";

		this.lv.getItems().add(waitList);
	}

	public HostRightData getText() {
		return new HostRightData(this.tf.getText());
	}

}
