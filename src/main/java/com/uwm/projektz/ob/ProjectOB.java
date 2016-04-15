package com.uwm.projektz.ob;

import javax.persistence.*;
import java.util.List;


/**
 * Created by wojni on 10.03.2016.
 */
@Entity
@Table(name = "projects")
@SequenceGenerator(initialValue = 1,name = "SEQ",sequenceName = "GEN_PROJECT_ID")
public class ProjectOB extends BaseOB{
    String name;
    String descritpion;
    String version;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="PRIORITY_ID", referencedColumnName = "ID")
    PriorityOB priority;

    public ProjectOB() {
    }

    public ProjectOB(String name, String desc, String version, PriorityOB priority)
    {
        this.name = name;
        this.descritpion = desc;
        this.version = version;
        this.priority = priority;
    }

    
}
