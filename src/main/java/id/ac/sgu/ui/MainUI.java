package id.ac.sgu.ui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class MainUI extends Application {
	
	static Stage window;
	
	public static Stage getStage() {
		return window;
	}
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Scene startScreen, homeScreen;
		window = primaryStage;
	
		//Layout 1 - Start Screen
		Parent root = FXMLLoader.load(getClass().getResource("view/MainUI.fxml"));
		
		startScreen = new Scene(root, 960, 480);
		
		window.setTitle("Arkent Dave Home Controller");
		window.setScene(startScreen);
		window.show();
		
		window.setOnCloseRequest(e -> {
			e.consume();
			closeWindowAffirmation();
		});

	}
	
	public Stage getWindow() {
		return this.window;
	}
	
	private void closeWindowAffirmation() {
		Boolean result = ConfirmationBox.display("Exit Application?", "Do you want to exit the application?");
		if(result) {
			window.close();
		}
	}



}
