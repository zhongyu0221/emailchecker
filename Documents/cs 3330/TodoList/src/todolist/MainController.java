/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todolist;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URL;
import java.time.LocalDate;
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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

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
    private Button Edit;
   
    @FXML
    private Menu MenuOpen;
    @FXML
    private MenuItem MenuAbout;
    
    
    
    LocalEvent localevent;
    @FXML
    private Menu MenuHelp;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        if (DatePicker == null) {
            System.out.println("Date picker is null");
        } else {
            DatePicker.setValue(LocalDate.now());
        }
      //  localevent=new LocalEvent();
        
    }

    ObservableList<LocalEvent> list = FXCollections.observableArrayList();

    @FXML
    private void saveEvent(ActionEvent event) {

        if (list == null) {
            System.out.println("The list is null");
        } else {

            list.add(new LocalEvent(NameText.getText(), DetailText.getText(), DatePicker.getValue()) {});
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
    private void EditEvent(ActionEvent event) {
       // NameText.setText(value);
        
    }
    
    
    /*@FXML
    public void handleSave(ActionEvent event) {
        
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showSaveDialog(stage);
        if (file != null) {
            try
            {
               String jsonString =list .toJsonString();
               PrintWriter out = new PrintWriter(file.getPath());
               out.print(jsonString);
               out.close();
            }catch(IOException ioex)
            {
                String message = "Exception occurred while saving to " + file.getPath();
                displayExceptionAlert(message, ioex);
            } 
        }        
    }*/
    
    /*@FXML
    public void handleSave(ActionEvent event) {
          
       LocalEvent p = new LocalEvent();
        
        p.setName(NameText.getText());
        p.setDescription(DetailText.getText());
        p.setDatetime(DatePicker.getValue());
        
     
        
        
        
 
        if (NameText.getText() != null && DetailText.getText()!=null &&  DatePicker.getValue()!=null) {
            p.setGender(genderComboBox.getValue().toString());
        } else {
            p.setGender(null);
        }

        return p;
    }*/
    
    
    
    
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
    
    
    
    private void displayExceptionAlert(String message, Exception ex) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Exception Dialog");
        alert.setHeaderText("Exception!");
        alert.setContentText(message);

        // Create expandable Exception.
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        ex.printStackTrace(pw);
        String exceptionText = sw.toString();

        Label label = new Label("The exception stacktrace was:");

        TextArea textArea = new TextArea(exceptionText);
        textArea.setEditable(false);
        textArea.setWrapText(true);

        textArea.setMaxWidth(Double.MAX_VALUE);
        textArea.setMaxHeight(Double.MAX_VALUE);
        GridPane.setVgrow(textArea, Priority.ALWAYS);
        GridPane.setHgrow(textArea, Priority.ALWAYS);

        GridPane expContent = new GridPane();
        expContent.setMaxWidth(Double.MAX_VALUE);
        expContent.add(label, 0, 0);
        expContent.add(textArea, 0, 1);

        // Set expandable Exception into the dialog pane.
        alert.getDialogPane().setExpandableContent(expContent);

        alert.showAndWait();
    }
}
