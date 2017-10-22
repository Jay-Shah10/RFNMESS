package gui;

import javafx.application.*;
import javafx.collections.*;
import javafx.css.*;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class GUI_Main extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		Rectangle2D visual = Screen.getPrimary().getVisualBounds();

		Login lg = new Login();

		primaryStage.setTitle("test login");
		primaryStage.setScene(new Scene(lg, visual.getWidth(), visual.getHeight()));
		primaryStage.show();

	}

}
