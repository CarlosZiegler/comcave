package gui;

import gui.util.Alerts;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;

public class ViewController {

	@FXML
	private Button btTest;

	@FXML
	public void onBtTestAction() {
	Alerts.showAlert("Titulo", "Alert Header", "Merda de JAVAFX", AlertType.INFORMATION);
		
	}

}
