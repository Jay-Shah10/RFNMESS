package gui;

import java.io.IOException;
import javafx.application.*;
import javafx.collections.*;
import javafx.css.*;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.layout.*;

public class Host_page extends BorderPane {
	public String reserved_text = "";
	

	public Host_page() {
		// bunch of panes.
		AnchorPane ap = new AnchorPane();
		GridPane gp = new GridPane();
		GridPane right_gp = new GridPane();
		HBox titlehbox = new HBox();
		VBox vbox = new VBox();
		FlowPane fp = new FlowPane();

////////////////////////////////////////////////

		// title pan to have the options buttons. allowing the user to log out.
		titlehbox.setPadding(new Insets(15, 12, 15, 12));
		titlehbox.setSpacing(10);
		titlehbox.setStyle("-fx-background-color: #0052cc");
		// menu button for the option with an option to logout.
		MenuButton options_button = new MenuButton("Options");
		titlehbox.setAlignment(Pos.CENTER_RIGHT);
		titlehbox.getChildren().add(options_button);
		MenuItem logout = new MenuItem("logout");
		options_button.getItems().addAll(logout);

		logout.setOnAction((event) -> {
			options_button.getScene().getWindow().hide();
			
		});

////////////////////////////////////////////////

		TextField reserve_table = new TextField();
		reserve_table.setPromptText("Enter party name and select table number.");

		Button reserve_button = new Button("Reserve");

		TextField reserve_confirmation = new TextField();

////////////////////////////////////////////////

		// creates a list of tables in a drop down format.
		ComboBox<String> table_numbers = new ComboBox<String>();
		for (int i = 1; i < 16; i++) {
			table_numbers.getItems().add(Integer.toString(i));
		}

		// combo box property to get the value of which table is selected.
		table_numbers.valueProperty().addListener((observable, old_var, new_var) -> {
			reserved_text = new_var;
		});


////////////////////////////////////////////////

		// v box to set up the right side of the page.
		vbox.setPadding(new Insets(5, 50, 5, 50));
		vbox.setSpacing(10);
		vbox.setStyle("-fx-background-color:#1a75ff");
		TextArea table_list = new TextArea();

		////////////////////////////////////////////////

		// reserve button's actions
		reserve_button.setOnAction((event) -> {

			reserve_confirmation.setText("Table number: " + reserved_text + " is reserved.");
			table_list.appendText(reserve_table.getText() + " for table: " + reserved_text + "\n");

		});

		vbox.getChildren().addAll(reserve_table, table_numbers, reserve_button, reserve_confirmation, table_list);

////////////////////////////////////////////////

		// flow pane to set up all the tables.
		fp.setPadding(new Insets(10, 10, 10, 10));
		fp.setVgap(20);
		fp.setHgap(6);
		fp.setPrefWrapLength(210);

		// all this for tables. allows the user to change their status.
		for (int k = 1; k < 16; k++) {
			MenuButton table_icon = new MenuButton("Table: "+Integer.toString(k));
			table_icon.setPrefSize(100, 20);
			MenuItem cancel_mi = new MenuItem("Cancel Res.");
			MenuItem free = new MenuItem("Open");
			MenuItem busy = new MenuItem("busy");
			MenuItem reserve = new MenuItem("Reserve");
			table_icon.getItems().addAll(free, cancel_mi, busy, reserve);
			// changes color when a particular option is selected.
			free.setOnAction((event) -> {
				// turns it green. code gotten from
				// https://www.w3schools.com/colors/colors_picker.asp?colorhex=228B22
				table_icon.setStyle("-fx-background-color: #00b300");

			});
			busy.setOnAction((event) -> {
				// turns it yellow.
				// https://www.w3schools.com/colors/colors_picker.asp?colorhex=228B22
				table_icon.setStyle("-fx-background-color: #ffff00");

			});
			cancel_mi.setOnAction((event) -> {
				// turns it gray.
				// https://www.w3schools.com/colors/colors_picker.asp?colorhex=228B22
				table_icon.setStyle("-fx-background-color: #d9d9d9");
			});
			reserve.setOnAction((event) -> {
				// turns it gray.
				// https://www.w3schools.com/colors/colors_picker.asp?colorhex=228B22
				table_icon.setStyle("-fx-background-color: #ff3300");
			});
			
			fp.getChildren().add(table_icon);
		}

		

////////////////////////////////////////////////

		// This puts each pane in their particular places.
		this.setCenter(gp);
		this.setRight(vbox);
		this.setTop(titlehbox);
		this.setLeft(fp);

	}
	/*
	 * right_gp.setPadding(new Insets(5,5,5,5)); right_gp.setVgap(5);
	 * right_gp.setHgap(5);
	 * right_gp.setStyle("-fx-background-color:#84e184");
	 * right_gp.add(reverse_table, 1, 0); right_gp.add(table_numbers, 2, 0);
	 * right_gp.add(reserve_button, 2, 1);
	 * 
	 * TextArea table_list = new TextArea(); String tables = ""; for(int
	 * j=1; j<3; j++){ tables = "Table "+Integer.toString(j)+ " is next.\n";
	 * table_list.appendText(tables); }
	 * 
	 */

}
