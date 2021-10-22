package id.ac.sgu.ui.controller;


import id.ac.sgu.ui.MainUI;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainUIController {
	public void handleButtonClick(ActionEvent event) throws Exception {
		Parent homeUIView = FXMLLoader.load(getClass().getResource("../view/HomeUI.fxml"));
		Scene homeUIScene = new Scene(homeUIView);
		
		Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
		
		
		window.setScene(homeUIScene);
		window.show();
	}
}
