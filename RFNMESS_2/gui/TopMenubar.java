/**
 * 
 */
package gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;

/**
 * @author jay_s
 *
 */
public class TopMenubar extends HBox {
	
	MenuButton menubutton = new MenuButton("...");
	Label namelabel = new Label("Name");

	public TopMenubar() {
		/*
		 * This Class only holds the top portion of the master borderpane.
		 * 
		 */
		Region r = new Region();

		// HBox property
		this.setHgrow(r, Priority.ALWAYS);
		this.setPadding(new Insets(10, 10, 10, 10));
		this.setAlignment(Pos.CENTER_LEFT);
		this.namelabel.setStyle("-fx-text-fill:#ffff;");
		
		BackgroundSize bgsize = new BackgroundSize(100, 100, true, true, true, true);
		BackgroundImage myBI = new BackgroundImage(new Image("RFNMESS_presentation_pic.png"), BackgroundRepeat.REPEAT,
				BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, bgsize);
		this.setBackground(new Background(myBI));
		
		this.setStyle("-fx-background-color: #2b2b2b;" + "-fx-border-color:#5b5b5b;" + "-fx-border-width:0px 0px 3px 0px;");
		this.setPrefHeight(50);

		// all the items that go into the HBox.
		addMenuItems(menubutton);
		// setName( person's name);

		// this adds everything to the HBox in order that it is placed in.
		this.getChildren().addAll(menubutton, r, namelabel);

	}
	
	public void setUserName(String n) {
		namelabel.setText(n);
	}

	///////////////////////////////////////////////
	public void addMenuItems(MenuButton mb) {
		/*
		 * Method to add all menu items to the menubutton.
		 */
		MenuItem logout_button = new MenuItem("Log out");
		mb.getItems().add(logout_button);
	}

	////////////////////////////////////////////////
	public void setName(String name) {
		/*
		 * this adds different names depending on who logs in.
		 */
		this.namelabel.setText(name);
	}


}
