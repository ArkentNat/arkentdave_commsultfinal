package id.ac.sgu.ui.controller;

import java.io.IOException;
import java.net.URL;
import java.time.LocalTime;
import java.util.ResourceBundle;

import id.ac.sgu.core.Controller;
import id.ac.sgu.core.Runner;
import id.ac.sgu.core.World;
import id.ac.sgu.core.Sensor.TimerSensor;
import id.ac.sgu.ui.AlertBox;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class HomeUIController implements Initializable {
	
	@FXML
	Label currentTime;
	
	public void handleButtonClick(ActionEvent event) throws IOException {
		final Node source = (Node) event.getSource();
		String buttonID = source.getId();
		
		switch(buttonID) {
		case "checkSensorButton":
			Parent sensorStatusView = FXMLLoader.load(getClass().getResource("../view/SensorStatus.fxml"));
			Scene sensorStatusScene = new Scene(sensorStatusView);
			
			Stage sensorWindow = (Stage)((Node) event.getSource()).getScene().getWindow();
			
			sensorWindow.setScene(sensorStatusScene);
			sensorWindow.show();
			break;
		case "checkAppliancesButton":
			Parent appliancesStatusView = FXMLLoader.load(getClass().getResource("../view/AppliancesStatus.fxml"));
			Scene appliancesStatusScene = new Scene(appliancesStatusView);
			
			Stage appliancesWindow = (Stage)((Node) event.getSource()).getScene().getWindow();
			
			appliancesWindow.setScene(appliancesStatusScene);
			appliancesWindow.show();
			break;
		case "showLogButton":
			Parent logView = FXMLLoader.load(getClass().getResource("../view/Log.fxml"));
			Scene logViewScene = new Scene(logView);
			
			Stage logWindow = (Stage)((Node) event.getSource()).getScene().getWindow();
			
			logWindow.setScene(logViewScene);
			logWindow.show();
			break;
		case "settingsButton":
			AlertBox ab = new AlertBox();
			ab.display("Feature WIP", "This Feature is still WIP");
			break;
		default:
			break;
		}

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		currentTime.setText("Current Time");	
	}
	
	public Label getCurrentTimeLabel() {
		return currentTime;
	}
	
	public void setText(String text) {
		this.currentTime.setText(text);
	}
}
