package gui;
import events.LoginEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import views.View;

public class Login implements View {
	
	private TextField username;
	private PasswordField password;
	private Button btnLogin;
	private Label error_label;
	private GridPane grid;
	
	public String getUsername() {
		return username.getText();
	}
	
	public String getPassword() {
		return password.getText();
	}
	
	public void disableLogin() {
		btnLogin.setDisable(true);
	}
	
	public void enableLogin() {
		btnLogin.setDisable(false);
	}
	
	public void postErrorMessage(String msg) {
		error_label.setText(msg);
		
		error_label.setVisible(true);
	}
	
	public void clearErrorMessage() {
		error_label.setText("");
		error_label.setVisible(false);
	}
	
	public Login(){
		//Initialized objects. 
		username = new TextField();
		password = new PasswordField();
		
		btnLogin = new Button("Login");
		
		Label title = new Label("Please Enter Username and Password");
		//title.setStyle("-fx-text-fill: #FFFFFF;"+"-fx-font-weight: bold;");
		title.getStyleClass().add("pane-title");
		error_label = new Label();
		error_label.setVisible(false);
		error_label.setTextFill(Color.RED);
		
		//Grid pane is located in the center of the border pane. 
		//holds the text field for user name, and password
		//holds a button to login. 
		grid = new GridPane();
		VBox holder = new VBox(15);
		holder.getStyleClass().add("pane");
		grid.setVgap(5);
		grid.setAlignment(Pos.CENTER);
		username.setPromptText("Username");
		password.setPromptText("Password");
		grid.add(holder, 0, 0);
		holder.getChildren().add(title);
		holder.getChildren().add(username);
		holder.getChildren().add(password);
		HBox h = new HBox();
		holder.getChildren().add(h);
		h.getChildren().add(btnLogin);
		h.setAlignment(Pos.BOTTOM_RIGHT);
		holder.getChildren().add(error_label);
		btnLogin.setAlignment(Pos.BASELINE_RIGHT);
//		grid.add(username, 0, 1);
//		grid.add(password, 0, 2);
//		grid.add(btnLogin, 0, 3);
//		grid.add(error_label, 0, 4);
		
		
		//login button's options on click. 
		btnLogin.setOnAction(
			(event)->{
				LoginEvent evt = new LoginEvent(LoginEvent.AUTHENTICATING);
				evt.setUsername(this.getUsername());
				evt.setPassword(this.getPassword());
				btnLogin.fireEvent(evt);
			}
		);
		
	}

	@Override
	public Node getCenter() {
		// TODO Auto-generated method stub
		return grid;
	}

	@Override
	public Node getRight() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node getLeft() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node getBottom() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	public void setOnLoggingIn(EventHandler<LoginEvent> eh) {
		this.btnLogin.addEventHandler(LoginEvent.AUTHENTICATING, eh);
	}
	public void setOnLoggedIn(EventHandler<LoginEvent> eh) {
		this.btnLogin.addEventHandler(LoginEvent.AUTHENTICATED, eh);
	}

	public void clear() {
		// TODO Auto-generated method stub
		this.clearErrorMessage();
		this.username.setText("");
		this.password.setText("");
	}
}
