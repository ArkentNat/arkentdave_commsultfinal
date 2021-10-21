package id.ac.sgu.ui.controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class SensorStatusController {
	public void handleButtonClick(ActionEvent event) throws IOException {
		final Node source = (Node) event.getSource();
		String buttonID = source.getId();
		
		switch(buttonID) {
		case "AnenometerSwitchButton":
			System.out.println("Switch anenometer");
			break;
		case "ThermometerSwitchButton":
			System.out.println("Switcch thermometer");
			break;
		case "TimerSwitchButton":
			System.out.println("Switch Timer");
			break;
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
}
