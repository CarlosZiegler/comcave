package gui;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import gui.util.Alerts;
import gui.util.Constrains;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class ViewController implements Initializable{

	@FXML
	private Button btSum;
	@FXML
	private TextField txtNumber1;
	@FXML
	private TextField txtNumber2;
	
	@FXML
	private Label labelResult;
	

	@FXML
	public void onBtSumAction() {
		
		try {
			Locale.setDefault(Locale.US);
			double nummer1 = Double.parseDouble(txtNumber1.getText());
			double nummer2 = Double.parseDouble(txtNumber2.getText());
			double sum = nummer1+nummer2;
			labelResult.setText(String.format("%.2f", sum));
		} catch (Exception e) {
			Alerts.showAlert("Error", "Parse Error", e.getMessage(), AlertType.ERROR);
		}
		
		
	}


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Constrains.setTextFieldDouble(txtNumber1);
		Constrains.setTextFieldDouble(txtNumber2);
		Constrains.setTextFieldMaxLength(txtNumber1, 5);
		Constrains.setTextFieldMaxLength(txtNumber2, 5);
		
	}
	
	

}
