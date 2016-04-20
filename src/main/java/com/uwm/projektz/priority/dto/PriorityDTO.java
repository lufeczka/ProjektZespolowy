package com.uwm.projektz.priority.dto;

import com.uwm.projektz.base.dto.BaseDTO;
import io.swagger.annotations.ApiModel;

import java.util.Date;

/**
 * Created by wojni on 10.03.2016.
 */

@ApiModel
public class PriorityDTO extends BaseDTO {
    String name;
    String responseTime;


    public PriorityDTO(Long id, Date techdate, String name, String responseTime)
    {
        super(id,techdate);
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
