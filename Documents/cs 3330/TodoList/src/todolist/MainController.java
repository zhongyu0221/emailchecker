/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todolist;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author zhongyu
 */
public class MainController implements Initializable {

    @FXML
    private DatePicker DatePicker;
    @FXML
    private TextArea NameText;
    @FXML
    private TextArea DetailText;
    @FXML
    private ListView<LocalEvent> EventList;
    @FXML
    private Button Save;
    @FXML
    private Button Clear;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        if (DatePicker == null) {
            System.out.println("Date picker is null");
        } else {
            DatePicker.setValue(LocalDate.now());
        }
    }

    ObservableList<LocalEvent> list = FXCollections.observableArrayList();

    @FXML
    private void saveEvent(ActionEvent event) {

        if (list == null) {
            System.out.println("The list is null");
        } else {

            list.add(new LocalEvent(NameText.getText(), DetailText.getText(), DatePicker.getValue()));
            System.out.println("Add to list success!");
            System.out.println(list);

           EventList.setItems(list);

        }
    }
    
    @FXML
     private void clearEvent() {
        refresh();
    }

    private void refresh() {
       DatePicker.setValue(null);
        DetailText.setText(null);
       NameText.setText(null);
    }
}
