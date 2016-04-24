/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zlqtdtodolist;


/**
 *
 * @author zhongyu
 */

import java.time.LocalDate;

public class Event {
    
    private String description;
    private LocalDate datetime;

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the datetime
     */
    public LocalDate getDatetime() {
        return datetime;
    }

    /**
     * @param datetime the datetime to set
     */
    public void setDatetime(LocalDate datetime) {
        this.datetime = datetime;
    }
    
    public void event(LocalDate datetime,String description)
    {
       this.setDatetime(date);
       
       
    }
    
}
