package gui;

import javafx.application.*;
import javafx.collections.*;
import javafx.css.*;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class GUI_Main extends Application {


	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
		
		Login lg = new Login();
		Host_2 h = new Host_2();
		
		Rectangle2D visual = Screen.getPrimary().getVisualBounds();
		
		//lg.setAlignment(Pos.CENTER);
		
		primaryStage.setTitle("test login");
		primaryStage.setScene(new Scene(h, visual.getWidth(), visual.getHeight()));
		primaryStage.show();
		
	}

}
