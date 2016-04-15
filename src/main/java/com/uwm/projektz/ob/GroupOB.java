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
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID" , referencedColumnName = "ID")
    UserOB user;
    public GroupOB() {
    }

    public GroupOB(String Name, UserOB User)
    {
        this.name = Name;
        this.user = User;
    }
}
