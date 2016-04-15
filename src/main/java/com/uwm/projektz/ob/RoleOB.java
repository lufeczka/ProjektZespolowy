package com.uwm.projektz.ob;

import javax.persistence.*;

/**
 * Created by Tomasz Komoszeski on 2016-04-15.
 */
@Entity
@Table(name = "roles")
@SequenceGenerator(initialValue = 1,name = "SEQ",sequenceName = "GEN_ROLE_ID")
public class RoleOB extends BaseOB {
    String name;

    public RoleOB() {
    }
}
