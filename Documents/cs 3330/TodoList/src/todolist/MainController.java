/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todolist;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URL;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.json.simple.JSONArray;
import org.json.simple.ItemList;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * FXML Controller class
 *
 * @author zhongyu
 */
public class MainController implements Initializable {

    private Stage stage;

    @FXML
    private DatePicker DatePicker;
    @FXML
    private TextField NameText;
    @FXML
    private TextArea DetailText;

    @FXML
    private Button Save;
    @FXML
    private Button Clear;
    @FXML
    private ListView<LocalEvent> Tablelist;
    @FXML
    private Button Delete;

    @FXML
    private Menu MenuOpen;
    @FXML
    private MenuItem MenuAbout;

    //LocalEventFirst localevent;
    @FXML
    private Menu MenuHelp;
    @FXML
    private MenuItem Json;
    @FXML
    private RadioButton Mark;
    @FXML
    private MenuItem Open;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        /*  if (DatePicker == null) {
            System.out.println("Date picker is null");
        } else {
            DatePicker.setValue(LocalDate.now());
        }*/
        //  localevent=new LocalEvent();
    }

    ObservableList<LocalEvent> list = FXCollections.observableArrayList();

    JSONObject Entries = new JSONObject();

    @FXML
    private void saveEvent(ActionEvent event) {

        if (list == null || NameText.getText() == null || DetailText.getText() == null || DatePicker.getValue() == null) {
            System.out.println("The list is null");
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Please fill all the imformation!");
            alert.showAndWait();

        } else {
            list.add(new LocalEvent(NameText.getText(), DetailText.getText(), DatePicker.getValue()) {
            });

            Tablelist.setItems(list);

        }

        refresh();
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

    @FXML
    private void deleteEvent(ActionEvent event) {
        final int selected = Tablelist.getSelectionModel().getSelectedIndex();
        if (selected != -1) {
            Tablelist.getItems().remove(selected);

        }

    }

    @FXML
    public void handleAbout(ActionEvent event) {

        System.out.println("About method be called");

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About");
        alert.setHeaderText("CS3300 Final Project");
        alert.setContentText("This application was developed by Zhongyu Li for CS3330 at the University of Missouri.");

        TextArea textArea = new TextArea("This is a To-do List app ");
        textArea.setEditable(false);
        textArea.setWrapText(false);
        textArea.setMaxWidth(Double.MAX_VALUE);
        textArea.setMaxHeight(Double.MAX_VALUE);

        GridPane expContent = new GridPane();
        expContent.setMaxWidth(Double.MAX_VALUE);
        expContent.add(textArea, 0, 0);
        alert.getDialogPane().setExpandableContent(expContent);

        alert.showAndWait();
    }

    @FXML
    private void JsonEvent(ActionEvent event) throws IOException {

        JSONArray Jlist = new JSONArray();
        JSONObject jsonOBJ;
        //  System.out.println("print list here" + list);
        for (LocalEvent e : list) {
            jsonOBJ = e.toJsonString();
            Jlist.add(jsonOBJ);
            //   System.out.println("print each jsonOBJ" + jsonOBJ);
        }

        FileWriter file = new FileWriter("test.json");
        if (file != null) {

            // System.out.println(jsonString);
            file.write(Jlist.toJSONString());
            file.flush();
            file.close();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Json file Saved");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Failed to save");
            alert.showAndWait();
        }

    }

    @FXML
    private void MarkAction(ActionEvent event
    ) {
    }

    @FXML
    private void OpenJson(ActionEvent event
    ) {

    }

    @FXML
    private void OpenEvent(ActionEvent event) throws IOException, ParseException, Exception {

        String jsonString = new String();

        FileReader fileReader = new FileReader("test.json");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        //System.out.println("Check open event here");

        String inputLine;
        while ((inputLine = bufferedReader.readLine()) != null) {
            jsonString += inputLine;
        }
        bufferedReader.close();

        System.out.println("jsonString"+jsonString);

        //GOOD HERE
        JSONArray jlist;
        try {
            jlist = parseJsonArray(jsonString);
            System.out.println("check parsed list" + jlist);
        } catch (Exception ex) {
            throw ex;
        }
        
       // System.out.println("Successed parsed");
        ObservableList<LocalEvent> list = FXCollections.observableArrayList();
        //good here
        for (Object e : jlist) {
            try {
                JSONObject jentryParsed = (JSONObject) e;
                LocalEvent entry = new LocalEvent();
                
                entry.initFromJsonString(jentryParsed.toJSONString());
                
                System.out.println("entry" + entry);
                //problem shows only name pass to entry
                list.add(entry);

            } catch (Exception ex) {
                throw ex;
            }

        }
        Tablelist.setItems(list);
    }

    public JSONArray parseJsonArray(String jsonString) throws Exception {
        JSONArray jlist;
        JSONParser parser = new JSONParser();
        System.out.println("Check parse here");
        System.out.println(jsonString);

        try {
            jlist = (JSONArray) parser.parse(jsonString);
        } catch (Exception ex) {
            throw ex;
        }

        System.out.println("parsed finished");

        if (jlist == null) {
            System.out.println("jlist is null");
            return null;
        } else {
            return jlist;
        }
    }
}
