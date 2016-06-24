/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emailchecker;

import com.sun.prism.impl.Disposer.Record;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
        


import org.apache.commons.net.smtp.SMTPClient;
import org.apache.commons.net.smtp.SMTPReply;
import org.xbill.DNS.Lookup;
import org.xbill.DNS.Type;

/**
 *
 * @author zhongyu
 */
public class FXMLDocumentController implements Initializable {
    
    private Label label;
    @FXML
    private TextField inputemail;
    @FXML
    private Button checkbtn;
    @FXML
    private Text addressarea;
    @FXML
    private Text resultarea;
    
    
     String EmailAdd;
    Boolean result;
    
   CheckEmailObj EmailObj = new CheckEmailObj();
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
       /* System.out.println("You clicked me!");
        resultarea.setText("Hello World!");*/
       EmailAdd= inputemail.getText();
      addressarea.setText(EmailAdd);
     result = EmailObj.checkEmail(EmailAdd);
       resultarea.setText(result.toString());
       
       
    }
    
   






    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
