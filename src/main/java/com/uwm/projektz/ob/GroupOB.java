package com.uwm.projektz.ob;

import javax.persistence.*;
/**
 * Created by wojni on 10.03.2016.
 */
@Entity
@Table(name = "groups")
@SequenceGenerator(initialValue = 1,name = "SEQ",sequenceName = "GEN_GROUPS_ID")
public class GroupOB extends BaseOB{
    String name;
    public GroupOB() {
    }

    public GroupOB(String Name, UserOB User)
    {
        this.name = Name;
    }
}
