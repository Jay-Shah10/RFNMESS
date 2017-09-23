package gui;

import javafx.application.*;
import javafx.collections.*;
import javafx.css.*;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GUI_Main extends Application {


	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
		
		Login lg = new Login();
		
		//lg.setAlignment(Pos.CENTER);
		
		primaryStage.setTitle("test login");
		primaryStage.setScene(new Scene(lg, 400,400));
		primaryStage.show();
		
	}

}
