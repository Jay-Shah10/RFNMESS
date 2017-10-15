package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class RFNMESS_Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		
		try {
			Rectangle2D visual = Screen.getPrimary().getVisualBounds();
			
			Parent root1 = FXMLLoader.load(getClass().getResource("/application/Login.fxml"));
			BorderPane root = new BorderPane();
			
			Scene scene = new Scene(root1,visual.getWidth(),visual.getHeight());
			scene.getStylesheets().add(getClass().getResource("Login.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
