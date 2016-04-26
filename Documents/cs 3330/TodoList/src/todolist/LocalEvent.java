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
import java.time.LocalDate;

public class LocalEvent {

    private String name = "";
    private String description = "";
    private LocalDate datetime=null;

    LocalEvent() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

    public LocalDate getDatetime() {
        return datetime;
    }

    public void setDatetime(LocalDate datetime) {
        this.datetime = datetime;
    }

    @Override
    public String toString() {
        return "Name: "+this.getName()+" " + this.getDatetime()+" " + this.getDescription();

    }

     public LocalEvent(String name, String description, LocalDate datetime) {
       this.setName(name);
       this.setDescription(description);
       this.setDatetime(datetime);
    }
     
}
