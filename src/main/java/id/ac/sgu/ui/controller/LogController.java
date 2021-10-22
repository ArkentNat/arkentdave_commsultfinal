package id.ac.sgu.ui.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import id.ac.sgu.ui.AlertBox;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class LogController implements Initializable {
	
	@FXML
	private TextArea logTextArea;
	
	public void handleButtonClick(ActionEvent event) throws IOException {
		final Node source = (Node) event.getSource();
		String buttonID = source.getId();
		switch(buttonID) {
		
		case "NavigationBackButton":
			Parent homeView = FXMLLoader.load(getClass().getResource("../view/HomeUI.fxml"));
			Scene homeViewScene = new Scene(homeView);
			
			Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
			
			window.setScene(homeViewScene);
			window.show();
			break;
		default:
			break;
		}

	}

	@Override
	public void initialize(URL location, ResourceBundle arg1) {
		//Initialize Log Read
		
	}
}
