package id.ac.sgu.ui.controller;

import java.io.IOException;

import id.ac.sgu.ui.AlertBox;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppliancesStatusController {
	public void handleButtonClick(ActionEvent event) throws IOException {
		final Node source = (Node) event.getSource();
		String buttonID = source.getId();
		switch(buttonID) {
		case "AddAppliancesButton":
			AlertBox ab = new AlertBox();
			ab.display("Feature WIP", "This Feature is still WIP");
			
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
