/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zlqtdtodolist;

import java.awt.Button;
import java.awt.TextArea;
import java.awt.TextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import java.time.LocalDate;

/**
 * FXML Controller class
 *
 * @author zhongyu
 */
public class MainController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    Button save;
    @FXML
    Button clear;
    @FXML
    Button delete;
    @FXML
    TextField name;
    @FXML
    TextField date;
    @FXML
    TextArea details;
    @FXML
    ListView list;
    
    
    
    
    
    
    
    
    
    
    
    
    
}
