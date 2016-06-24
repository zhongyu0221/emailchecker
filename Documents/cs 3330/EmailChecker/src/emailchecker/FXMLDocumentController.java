/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emailchecker;

import com.sun.prism.impl.Disposer.Record;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
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

    private final String appName = "Threaded Verify Email";
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
    File file = new File("test");

    @FXML
    private TextField outputresult;
    @FXML
    private Button inputbtn;
    @FXML
    private Button outputbtn;
    @FXML
    private TextArea details;

    @FXML
    private void handleButtonAction(ActionEvent event) {
        /* System.out.println("You clicked me!");
        resultarea.setText("Hello World!");*/

        EmailAdd = inputemail.getText();
        addressarea.setText(EmailAdd);
        result = EmailObj.checkEmail(EmailAdd);
        resultarea.setText(result.toString());
        details.setText(EmailObj.log);

        new thread(EmailAdd).start();

        //new thread("B").start();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void openfile(ActionEvent event) {
        String pathname = "/Users/zhongyu/Documents/cs 3330/EmailChecker/test.txt";
        File file = new File(pathname);
        BufferedReader reader = null;

        try {
            System.out.println("以行为单位读取文件内容，一次读一整行：" + file);

            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            //System.out.println("test here");
            int line = 1;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                // 显示行号
                System.out.println("line " + line + ": " + tempString);
                result = EmailObj.checkEmail(tempString);
                resultarea.setText(result.toString());
                details.setText(EmailObj.log);

                line++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
    }

}
