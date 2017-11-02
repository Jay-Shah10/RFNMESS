/**
 * 
 */
package gui;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

/**
 * @author nryle
 *
 */
public class SearchBox extends HBox {
	private TextField 	textBox;
	private Button		searchButton;
	/**
	 * 
	 */
	public SearchBox() {
		// TODO Auto-generated constructor stub
		this.getStyleClass().add("searchBox");
		
		textBox = new TextField();
		textBox.getStyleClass().add("tbox");
		this.getChildren().add(textBox);
		
		searchButton = new Button();
		searchButton.getStyleClass().add("btn");
		this.getChildren().add(searchButton);
	}

}
