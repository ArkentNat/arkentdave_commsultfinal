package id.ac.sgu.ui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
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
	
	Stage window;
	Scene startScreen, homeScreen;
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;

			
		//Layout 1 - Start Screen
		ImageView home = new ImageView(getClass().getResource("./assets/home.png").toExternalForm());
		home.setFitHeight(50);
		home.setPreserveRatio(true);
		Label label1= new Label("Arkent Dave Home Controller");
		label1.setFont(new Font("Arial", 40));
		
		Button button1 = new Button("Start Application");
		button1.setFont(new Font("Arial", 30));
		button1.setOnAction(e -> {
			window.setScene(homeScreen);
		});
		
		VBox outerContainer = new VBox(40);
		VBox columnContainer = new VBox(10);
		columnContainer.getChildren().addAll(home, label1);
		
		outerContainer.getChildren().addAll(columnContainer, button1);
		columnContainer.setAlignment(Pos.CENTER);
		outerContainer.setAlignment(Pos.CENTER);
		startScreen = new Scene(outerContainer, 960, 480);
		
		//Layout 2 - Home Scene
		AppBar appbar = new AppBar();
		
		BorderPane homeUILayout = new BorderPane();
		homeUILayout.setTop(appbar);
		
		Label title = new Label("DASHBOARD");
		title.setFont(new Font("Verdana", 30));
		
		Font buttonTextFont = new Font("Arial", 20);
		
		Button checkSensorButton = new Button();
		checkSensorButton.setText("Check Sensors Status");
		checkSensorButton.setFont(buttonTextFont);
		checkSensorButton.setWrapText(true);
		checkSensorButton.setMinWidth(270);
		checkSensorButton.setMaxSize(500, 300);
		checkSensorButton.setMinHeight(70);
		
		Button checkAppliancesButton = new Button();
		checkAppliancesButton.setText("Check Appliances Status");
		checkAppliancesButton.setFont(buttonTextFont);
		checkAppliancesButton.setWrapText(true);
		checkAppliancesButton.setMinWidth(270);
		checkAppliancesButton.setMaxSize(500, 300);
		checkAppliancesButton.setMinHeight(100);
		
		Button checkLogButton = new Button();
		checkLogButton.setText("Check Log");
		checkLogButton.setFont(buttonTextFont);
		checkLogButton.setWrapText(true);
		checkLogButton.setMinWidth(150);
		checkLogButton.setMaxSize(500, 300);
		checkLogButton.setMinHeight(100);
		
		Button settings = new Button();
		ImageView view = new ImageView(getClass().getResource("./assets/settings.png").toExternalForm());
		view.setFitHeight(50);
		view.setPreserveRatio(true);
		settings.setGraphic(view);
		settings.setFont(buttonTextFont);
		settings.setWrapText(true);
		settings.setMinWidth(150);
		settings.setMaxSize(500, 300);
		settings.setMinHeight(100);
		
		
		VBox buttonMenuContainer = new VBox(40);
		buttonMenuContainer.setAlignment(Pos.CENTER);
		
		HBox buttonMenuRow1 = new HBox(30);
		HBox buttonMenuRow2 = new HBox(30);
		
		buttonMenuRow1.setAlignment(Pos.CENTER);
		buttonMenuRow2.setAlignment(Pos.CENTER);
		
		buttonMenuRow1.getChildren().addAll(checkSensorButton, checkAppliancesButton);
		buttonMenuRow2.getChildren().addAll(checkLogButton, settings);
		buttonMenuContainer.getChildren().addAll(title, buttonMenuRow1, buttonMenuRow2);
		
		homeUILayout.setCenter(buttonMenuContainer);
		homeScreen = new Scene(homeUILayout, 960, 480);
		
		window.setTitle("Arkent Dave Home Controller");
		window.setScene(startScreen);
		window.show();
		
		window.setOnCloseRequest(e -> {
			e.consume();
			closeWindowAffirmation();
		})
;
	}
	
	private void closeWindowAffirmation() {
		Boolean result = ConfirmationBox.display("Exit Application?", "Do you want to exit the application?");
		if(result) {
			window.close();
		}
	}



}
