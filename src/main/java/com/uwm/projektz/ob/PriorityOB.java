package com.uwm.projektz.ob;
import javax.persistence.*;
/**
 * Created by wojni on 10.03.2016.
 */
@Entity
@Table(name = "priorities")
@SequenceGenerator(initialValue = 1,name = "SEQ",sequenceName = "GEN_PRIORITY_ID")
public class PriorityOB extends BaseOB{
    String name;
    String responseTime;


    public PriorityOB(String name, String responseTime)
    {
        this.name = name;
        this.responseTime = responseTime;
    }

    //getters
    public String getPriorityName () {return name;}
    public String getPriorityResponseTime () {return responseTime;}

    //setters
    public void setPriorityName (String name) {this.name = name;}
    public void setPriorityResponseTime (String response) {this.responseTime = response;}
}
