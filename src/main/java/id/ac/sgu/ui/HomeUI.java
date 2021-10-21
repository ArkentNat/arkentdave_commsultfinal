package id.ac.sgu.ui;

import java.time.LocalTime;

import id.ac.sgu.core.Runner;
import id.ac.sgu.core.Sensor.TimerSensor;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HomeUI extends Application {
	
	private Stage window;

	@FXML
	private static Label currentTime;
	
	public Stage getStage() {
		return this.window;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		
		Parent root = FXMLLoader.load(getClass().getResource("view/HomeUI.fxml"));
		window.setTitle("HomeUI");
		window.setScene(new Scene(root, 960, 480));
		window.show();
		
		window.setOnCloseRequest(e -> closeWindowAffirmation());
	}
	
	private void closeWindowAffirmation() {
		Boolean result = ConfirmationBox.display("Exit Application?", "Do you want to exit the application?");
		if(result) {
			window.close();
		}
	}
	
}
