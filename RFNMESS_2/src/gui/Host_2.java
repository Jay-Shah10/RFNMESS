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
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.layout.*;

public class Host_2 extends BorderPane {
	
	public Host_2(){
		
		/*
		 * top of the border pane. 
		 * Needs a menu button on the left side and a name tag on the right side. 
		 * Menu button will have a log-out button and something else. 
		 * Consists of Hbox
		 */
		
		HBox topHBox = new HBox();
		
		//Items to be in the HBox
		MenuButton menu_button = new MenuButton("...");
		Region r = new Region();
		Region r2 = new Region();
		Label name = new Label("Name");
		
		//setting properties to the HBox
		topHBox.setAlignment(Pos.CENTER_LEFT);
		topHBox.setPrefHeight(50);
		topHBox.setHgrow(r, Priority.ALWAYS);
		r2.setPrefWidth(15);
		topHBox.setStyle("-fx-background-color: #0052cc");
		
		//adding elements to HBox
		topHBox.getChildren().add(0, menu_button);
		topHBox.getChildren().add(1, r);
		topHBox.getChildren().add(2, name);
		topHBox.getChildren().add(3, r2);
		
		
		
		this.setTop(topHBox);
		
		/*
		 * This section will hold the table icons. 
		 * Should grow when the window opens. 
		 * needs to have even space between buttons. 
		 * 4 columns for menu buttons. 
		 * 3 rows. 
		 */
		
		GridPane gp = new GridPane();
		MenuButton mb1 = new MenuButton();
		MenuButton mb2 = new MenuButton();
		MenuButton mb3 = new MenuButton();
		MenuButton mb4 = new MenuButton();
		MenuButton mb5 = new MenuButton();
		MenuButton mb6 = new MenuButton();
		MenuButton mb7 = new MenuButton();
		MenuButton mb8 = new MenuButton();
		MenuButton mb9 = new MenuButton();
		MenuButton mb10 = new MenuButton();
		MenuButton mb11 = new MenuButton();
		MenuButton mb12 = new MenuButton();
		
		Region r_1 = new Region();
		gp.setHgrow(r_1, Priority.ALWAYS);
		Region r_2 = new Region();
		gp.setHgrow(r_2, Priority.ALWAYS);
		Region r_3 = new Region();
		gp.setHgrow(r_3, Priority.ALWAYS);
		Region r_4 = new Region();
		gp.setHgrow(r_4, Priority.ALWAYS);
		Region r_5 = new Region();
		gp.setHgrow(r_5, Priority.ALWAYS);
		Region r_6 = new Region();
		gp.setHgrow(r_6, Priority.ALWAYS);
		Region r_7 = new Region();
		gp.setHgrow(r_7, Priority.ALWAYS);
		Region r_8 = new Region();
		gp.setHgrow(r_8, Priority.ALWAYS);
		Region r_9 = new Region();
		gp.setHgrow(r_9, Priority.ALWAYS);
		Region r_10 = new Region();
		gp.setHgrow(r_10, Priority.ALWAYS);
		Region r_11 = new Region();
		gp.setHgrow(r_11, Priority.ALWAYS);
		Region r_12 = new Region();
		gp.setHgrow(r_12, Priority.ALWAYS);
		Region r_13 = new Region();
		gp.setHgrow(r_13, Priority.ALWAYS);
		
		//row1
		gp.add(mb1, 0, 0);
		gp.add(r_1, 1, 0);
		gp.add(mb2, 2, 0);
		gp.add(r_2, 3, 0);
		gp.add(mb3, 4, 0);
		
		gp.add(r_9, 0, 1);
		gp.setVgrow(r_9, Priority.ALWAYS);
		
		//row2
		gp.add(mb4, 0, 2);
		gp.add(r_3, 1, 2);
		gp.add(mb5, 2, 2);
		gp.add(r_4, 3, 2);
		gp.add(mb6, 4, 2);
		
		gp.add(r_10, 0, 3);
		gp.setVgrow(r_10, Priority.ALWAYS);
		
		//row3
		gp.add(mb7, 0, 4);
		gp.add(r_5, 1, 4);
		gp.add(mb8, 2, 4);
		gp.add(r_6, 3, 4);
		gp.add(mb9, 4, 4);
		
		gp.add(r_11, 0, 5);
		gp.setVgrow(r_11, Priority.ALWAYS);
		
		//row4
		gp.add(mb10, 0,6);
		gp.add(r_7, 1, 6);
		gp.add(mb11, 2,6);
		gp.add(r_8, 3, 6);
		gp.add(mb12, 4,6);
		
		gp.add(r_12, 0, 7);
		gp.setVgrow(r_12, Priority.ALWAYS);
		
		
		this.setCenter(gp);
		
		/*
		 * this is for the right side of the border pane
		 */
		
		VBox vb = new VBox();
		
		vb.setStyle("-fx-background-color:#ff8c1a");
		TextField tf = new TextField();
		vb.getChildren().add(tf);
		
		this.setRight(vb);
		
	}

}
