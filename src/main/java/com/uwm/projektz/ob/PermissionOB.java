package com.uwm.projektz.ob;

import javax.persistence.*;
/**
 * Created by wojni on 11.03.2016.
 */
@Entity
@Table(name = "permissions")
@SequenceGenerator(initialValue = 1,name = "SEQ",sequenceName = "GEN_PERMISSION_ID")
public class PermissionOB extends BaseOB{
    String name;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="ROLE_ID",referencedColumnName = "ID")
    RoleOB role;

    public PermissionOB() {
    }

    public PermissionOB(String name, RoleOB role)
    {
        this.name = name;
        this.role = role;
    }

    //getters
    public String getPermissionName () { return name;}
    public RoleOB getPermissionRole () {return role;}

    //setters
    public void setPermissionName (String name) {this.name = name;}
    public void setPermissionRole (RoleOB role) {this.role = role;}
}
