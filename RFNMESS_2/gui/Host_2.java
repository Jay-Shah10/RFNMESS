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
		//this.setTop(topHBox);
		
		
		/*
		 * This section will hold the table icons. 
		 * Should grow when the window opens. 
		 * needs to have even space between buttons. 
		 * 4 columns for menu buttons. 
		 * 3 rows. 
		 */
		
		Host_Center_Grid gp = new Host_Center_Grid();
		this.setCenter(gp);
		
		/*
		 * this is for the right side of the border pane
		 */
		
		Host_Right vb = new Host_Right();
		this.setRight(vb);
		
		
	}

}
