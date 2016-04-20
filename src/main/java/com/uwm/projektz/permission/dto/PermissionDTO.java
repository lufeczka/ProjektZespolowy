package com.uwm.projektz.permission.dto;

import com.uwm.projektz.base.dto.BaseDTO;
import io.swagger.annotations.ApiModel;

import java.util.Date;

@ApiModel
public class PermissionDTO extends BaseDTO {
    String name;


    public PermissionDTO(Long id, Date techdate, String name)
    {
        super(id,techdate);
        this.name = name;
    }

    //getters
    public String getPermissionName () { return name;}

    //setters
    public void setPermissionName (String name) {this.name = name;}
}
