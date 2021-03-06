package com.uwm.projektz.priority.dto;

import com.uwm.projektz.base.dto.BaseDTO;
import io.swagger.annotations.ApiModel;

import java.util.Date;

/**
 * Created by wojni on 10.03.2016.
 */

@ApiModel
public class PriorityDTO extends BaseDTO {
   private String name;
   private String responseTime;

    public PriorityDTO(Long id, Date techDate, String name, String responseTime) {
        super(id, techDate);
        this.name = name;
        this.responseTime = responseTime;
    }

    public PriorityDTO(String name, String responseTime) {
        this.name = name;
        this.responseTime = responseTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(String responseTime) {
        this.responseTime = responseTime;
    }
}
