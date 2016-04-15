package com.uwm.projektz.ob;

import javax.persistence.*;
import java.util.List;

/**
 * Created by wojni on 11.03.2016.
 */
@Entity
@Table(name = "permissions")
@SequenceGenerator(initialValue = 1,name = "SEQ",sequenceName = "GEN_PERMISSION_ID")
public class PermissionOB extends BaseOB{
    String name;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name ="ROLE_ID",referencedColumnName = "ID")
    List<RoleOB> role;

    public PermissionOB() {
    }

}
