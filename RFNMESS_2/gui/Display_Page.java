package gui;

import javafx.application.*;
import javafx.collections.*;
import javafx.css.*;
import javafx.geometry.Insets;
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

	
	private Host_2_view h2 = new Host_2_view();
	
	
	//////////////////////////////////////////////////////////
	public Display_Page(Host_2_view h){
		this.h2 = h;
	}
	
	//////////////////////////////////////////////////////////
	public Display_Page(String username, String password) {
		// asgasrgr
		BackgroundSize bgsize = new BackgroundSize(100,100,true,true,true,true);
		BackgroundImage myBI= new BackgroundImage(new Image("RFNMESS_presentation_pic.png"),
		        BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
		          bgsize);
		this.setBackground(new Background(myBI));
		
		
		//sets the top of the border pane to be menu
		Top_Menu_bar tmb = new Top_Menu_bar();
		this.setTop(tmb);		
		
		setCenterScene(username, password);
		setRightScene(username, password);
		
		
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
	
	private void setRightScene(String username, String password) {
		// TODO Auto-generated method stub
		if(username.equals("host")&&(password.equals("host"))){
			this.setMargin(h2.getRight(), new Insets(10,10,10,10));
			this.setRight(h2.getRight());
		}
		
	}
////////////////////////////////////////////////////////
	
	public void setCenterScene(String username, String password){
		/*
		 * method to display just the host page in the center of the main borderpane. 
		 */
		if (username.equals("host") && password.equals("host")){
			this.setMargin(h2.getCenter(), new Insets(10,10,10,10));
			this.setCenter(h2.getCenter());
		}
	}

}
