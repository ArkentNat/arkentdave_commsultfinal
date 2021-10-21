package id.ac.sgu.ui;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToolBar;
import javafx.scene.text.Font;

public class AppBar extends ToolBar {
	public AppBar() {
		Label label2 = new Label("Arkent Dave Home Controller - Home");
		label2.setFont(new Font("Arial", 20));
		
		this.getItems().addAll(label2);

	}
}
