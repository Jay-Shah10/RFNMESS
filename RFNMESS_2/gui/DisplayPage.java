	package gui;

import javafx.application.*;
import javafx.collections.*;
import javafx.css.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Screen;
import javafx.stage.Stage;
import views.View;

public class DisplayPage extends BorderPane {
	
	/*
	 * This is the main display page. 
	 * It holds a "menu area" on the top, which consists of a menu button and the user's name. 
	 *   Menu button will hold different menu items depending on who signs in. 
	 * The "menu area" will have a slight fade, so that it stands out from the main back ground, but still has its own 
	 * 	 background. 
	 * This page consists of a border pane, top is the "menu area" and below each scene will change. 
	 * 
	 */
	
	private TopMenubar tmb;
	
	public void setView(View v) {
		this.setLeft(v.getLeft());
		
		this.setRight(v.getRight());
		if(v.getRight() != null)	
			setMargin(v.getRight(), new Insets(20,20,20,20));
		
		this.setCenter(v.getCenter());
		if(v.getCenter() != null)
			setMargin(v.getCenter(), new Insets(20,20,20,20));
		//this.setCenter(h2.getCenter());
		this.setBottom(v.getBottom());
	}
	
	public DisplayPage() {
		initialize();
	}
	
	private void initialize() {
		BackgroundSize bgsize = new BackgroundSize(100,100,true,true,true,true);
		BackgroundImage myBI= new BackgroundImage(new Image("RFNMESS_presentation_pic.png"),
		        BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
		          bgsize);
		this.setBackground(new Background(myBI));
		
		
		//sets the top of the border pane to be menu
		tmb = new TopMenubar();
		tmb.setUserName("Name");
		this.setTop(tmb);		
	}
	
	//////////////////////////////////////////////////////////
	
	public void addMenuItems(MenuButton mb){
		/*
		 * adds menu items to the menubutton. 
		 */
		MenuItem logout = new MenuItem("Logout");
		mb.getItems().add(logout);
		
	}
	
	public void setOnLogout(EventHandler<ActionEvent> eh) {
		tmb.setOnLogout(eh);
	}
}
