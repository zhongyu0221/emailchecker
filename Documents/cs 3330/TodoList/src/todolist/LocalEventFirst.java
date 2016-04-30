/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todolist;

import java.time.LocalDate;
import org.json.simple.JSONObject;

/**
 *
 * @author zhongyu
 */
public class LocalEventFirst extends LocalEvent {

    private Boolean taskstatus = false;

    public LocalEventFirst(String name, String description, LocalDate datetime,Boolean status) {
       //super(name, description, datetime, true);
    }

    public void isMark() {
        taskstatus = true;

    }

    public void notMark() {

        taskstatus = false;
    }

   
}
