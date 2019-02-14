package gui;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;
import model.endities.Person;

public class ViewController implements Initializable {

	@FXML
	private ComboBox<Person> comBoxPerson;
	private ObservableList<Person> obsList;
	@FXML
	private Button btAll;
	
	
	@FXML
	public void onBtAllAction() {
		
		for (Person person : comBoxPerson.getItems()) {
			System.out.println(person);
		}
		
	}
	
	@FXML
	private void onComboBoxPersonAction() {
		Person person= comBoxPerson.getSelectionModel().getSelectedItem();
		System.out.println(person);
		
		
		
	}
	
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		List<Person> list= new ArrayList<>();
		list.add(new Person(1,"Maria","maria@gmail.com"));
		list.add(new Person(1,"Carlos","carlos@gmail.com"));
		list.add(new Person(1,"Jose","jose@gmail.com"));
		list.add(new Person(1,"Ricardo","Ricardo@gmail.com"));
		list.add(new Person(1,"Nuno","nuno@gmail.com"));
		
		obsList = FXCollections.observableArrayList(list);
		comBoxPerson.setItems(obsList);
				
		Callback<ListView<Person>, ListCell<Person>> factory = lv->new ListCell<Person>() {
		@Override
		protected void updateItem(Person item, boolean empty) {
			super.updateItem(item,empty);
			setText(empty ? "": item.getName());
		}};
		comBoxPerson.setCellFactory(factory);
		comBoxPerson.setButtonCell(factory.call(null));
		
		
		
	}

}
