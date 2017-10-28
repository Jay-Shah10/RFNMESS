package gui;

import javafx.application.*;
import javafx.collections.*;
import javafx.css.*;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Display_Page extends BorderPane {
	
	/*
	 * This is the main display page. 
	 * It holds a "menu area" on the top, which consists of a menu button and the user's name. 
	 *   Menu button will hold different menu items depending on who signs in. 
	 * The "menu area" will have a slight fade, so that it stands out from the main back ground, but still has its own 
	 * 	 background. 
	 * This page consists of a border pane, top is the "menu area" and below each scene will change. 
	 * 
	 */

	public HBox hb = new HBox();
	public MenuButton menubutton = new MenuButton();
	public Label name = new Label("Name");
	public Host_2_view h2 = new Host_2_view();
	
	// asdfadsfasds
	
	//////////////////////////////////////////////////////////
	public Display_Page(Host_2_view h){
		this.h2 = h;
	}
	
	//////////////////////////////////////////////////////////
	public Display_Page(String username, String password) {
		// asgasrgr
		Region r = new Region();
		this.hb.setHgrow(r, Priority.ALWAYS);
		Region r2 = new Region();
		r2.setPrefWidth(15);
		addMenuItems(this.menubutton);

		//setting background.
		BackgroundSize bgsize = new BackgroundSize(100, 100, true, true, true, true);
		BackgroundImage myBI = new BackgroundImage(new Image("RFNMESS_presentation_pic.png"), BackgroundRepeat.REPEAT,
				BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, bgsize);

		this.setBackground(new Background(myBI));
		
		
		this.hb.setStyle("-fx-background-color:#1e7b1e;"+"-fx-opacity: 0.8;");
		this.hb.setPrefHeight(50);
		this.hb.setAlignment(Pos.CENTER_LEFT);

		this.hb.getChildren().addAll(menubutton, r, name, r2);
		this.setTop(hb);
		
		LoginMiddle(username, password);
		
		
	}
	
	//////////////////////////////////////////////////////////
	
	public void addMenuItems(MenuButton mb){
		/*
		 * adds menu items to the menubutton. 
		 */
		MenuItem logout = new MenuItem("Logout");
		mb.getItems().add(logout);
		
	}
	
////////////////////////////////////////////////////////
	public void changeCenterDisplay(String username, String password){
		/*
		 * Method to set different scenes in the middle of the main border pane. 
		 */
		
		
	}
////////////////////////////////////////////////////////
	
	public void LoginMiddle(String username, String password){
		/*
		 * method to display just the host page in the center of the main borderpane. 
		 */
		if (username.equals("host") && password.equals("host")){
			this.setCenter(h2);
		}
	}

}
