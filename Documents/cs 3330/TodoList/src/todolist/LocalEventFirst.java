/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todolist;

import org.json.simple.JSONObject;

/**
 *
 * @author zhongyu
 */
public class LocalEventFirst extends LocalEvent {

    private Boolean taskstatus = false;

    public void isDone() {
        taskstatus = true;

    }

    public void notDone() {

        taskstatus = false;
    }

}
