/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todolist;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author zhongyu
 */
public class Logcontroller implements Initializable {

    @FXML
    private TextArea LogName;
    @FXML
    private TextArea LogPass;
    @FXML
    private Button Submit;
    @FXML
    private Label information;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void submitAction(ActionEvent event) throws IOException {
        if (LogName.getText().equals("test") && LogPass.getText().equals("pass")) {
            ((Node)(event.getSource())).getScene().getWindow().hide();
            System.out.println("Right passoword");
            information.setText("Welcome " + LogName.getText());

            Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(root);

            stage.setScene(scene);
            stage.show();

        } else {
            information.setText("Wrong passoword");
            System.out.println("Wrong passoword");
        }

    }
}
