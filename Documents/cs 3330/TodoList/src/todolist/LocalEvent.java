/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todolist;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author zhongyu
 */
import java.io.PrintWriter;
import java.io.StringWriter;
import java.time.LocalDate;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

public class LocalEvent {

    private String name = "";
    private String description = "";
    private String datetime = null;
    // private Boolean status = false;

    LocalEvent() {

    }

    public String getName() {
        return name;
    }

    public void setName(String Name) {
        this.name = Name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(LocalDate datetime) {
        this.datetime = DateUtil.format(datetime);
    }

    /*public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean Status) {
        this.status = Status;
    }*/
    @Override
    public String toString() {
        return this.getDatetime() + "  " + this.getName() + "  " + this.getDescription();

    }

    public LocalEvent(String name, String description, LocalDate datetime) {
        this.setName(name);
        this.setDescription(description);
        this.setDatetime(datetime);
        //this.setStatus(Status);
    }

    public JSONObject toJsonString() {
        JSONObject obj = new JSONObject();
        if (name != null) {
            obj.put("Name", name);
        }
        if (description != null) {
            obj.put("Description", description);
        }
        if (datetime != null) {
            obj.put("Datetime", datetime);
        }

        return obj;
    }

    /* public abstract void isMark();

    public abstract void notMark();*/
    
    void initFromJsonString(String jsonString) {
        name = "";
        description = "";
        datetime = "";

        if (jsonString == null || jsonString.equals("")) {
            return;
        }
        System.out.println("before parse" + jsonString);
        JSONObject jsonOBJ;
        try {
            jsonOBJ = (JSONObject) JSONValue.parse(jsonString);

        } catch (Exception ex) {
            return;
        }

        if (jsonOBJ == null) {
            return;
        }
        //System.out.println("After parse" + jsonOBJ);

        name = (String) jsonOBJ.getOrDefault("Name", "");
        description = (String) jsonOBJ.getOrDefault("Description", "");
        datetime = (String) jsonOBJ.getOrDefault("Datetime", "");

        System.out.println("initFromJsonString After parse" + jsonOBJ);
        System.out.println(name);
         System.out.println(description);
          System.out.println(datetime);
        

    }
}
