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

public class HomeUIController {
	public void handleButtonClick(ActionEvent event) throws IOException {
		final Node source = (Node) event.getSource();
		String buttonID = source.getId();
		
		switch(buttonID) {
		case "checkSensorButton":
			System.out.println("Go to sensor page!");
			break;
		case "checkAppliancesButton":
			System.out.println("Go to appliances page!");
			break;
		case "showLogButton":
			System.out.println("Go to show log page!");
			break;
		case "settingsButton":
			System.out.println("Go to settings page!");
			break;
		default:
			break;
		}

	}
}
