package id.ac.sgu.ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HomeUI extends Application {
	
	private static Stage window;
	Scene homeScreen;
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		
		AppBar appbar = new AppBar();
		
		VBox layout2 = new VBox(20);
		layout2.getChildren().addAll(appbar);
		homeScreen = new Scene(layout2, 960, 480);
		
		window.setScene(homeScreen);
		window.show();
		
		window.setOnCloseRequest(e -> {
			e.consume();
			closeWindowAffirmation();
		});
		
	}
	
	private void closeWindowAffirmation() {
		Boolean result = ConfirmationBox.display("Exit Application?", "Do you want to exit the application?");
		if(result) {
			window.close();
		}
	}
	
}
