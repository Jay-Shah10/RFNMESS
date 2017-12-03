/**
 * 
 */
package gui;

import events.LoginEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
	private MenuItem logoutButton, hostButton, serverButton, kitchenButton, managerButton;
	private Login lg;

	public TopMenubar() {
		/*
		 * This Class only holds the top portion of the master borderpane.
		 * 
		 */
		Region r = new Region();

		// HBox property
		setHgrow(r, Priority.ALWAYS);
		this.setPadding(new Insets(10, 10, 10, 10));
		this.setAlignment(Pos.CENTER_LEFT);
		this.namelabel.setStyle("-fx-text-fill:#ffff;");
		
		BackgroundSize bgsize = new BackgroundSize(100, 100, true, true, true, true);
		BackgroundImage myBI = new BackgroundImage(new Image("RFNMESS_presentation_pic.png"), BackgroundRepeat.REPEAT,
				BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, bgsize);
		this.setBackground(new Background(myBI));
		
		this.setStyle(
			"-fx-background-color: #2b2b2b;" + 
			"-fx-border-color:#5b5b5b;" + 
			"-fx-border-width:0px 0px 3px 0px;"
		);
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
		logoutButton = new MenuItem("Log out");
		hostButton = new MenuItem("Host");
		serverButton = new MenuItem("Server" );
		kitchenButton = new MenuItem("Kitchen");
		managerButton = new MenuItem("Manager");
		mb.getItems().addAll(hostButton, serverButton, kitchenButton, managerButton, logoutButton);
			
	}

////////////////////////////////////////////////
	public void setName(String name) {
		/*
		 * this adds different names depending on who logs in.
		 */
		this.namelabel.setText(name);
	}
	
////////////////////////////////////////////////
	public void setOnLogout(EventHandler<ActionEvent> eh) {
		/*
		 * Needs to close the current view and then show the login page. 
		 */
		logoutButton.setOnAction(eh);
		
		
	}
	public void hostViewClick(EventHandler<ActionEvent> eh) {
		hostButton.setOnAction(eh);
	}
	public void serverViewClick(EventHandler<ActionEvent> eh) {
		serverButton.setOnAction(eh);
	}
	public void kitchenViewClick(EventHandler<ActionEvent> eh) {
		kitchenButton.setOnAction(eh);
	}
	public void managerViewClick(EventHandler<ActionEvent> eh) {
		managerButton.setOnAction(eh);
	}

	

}
