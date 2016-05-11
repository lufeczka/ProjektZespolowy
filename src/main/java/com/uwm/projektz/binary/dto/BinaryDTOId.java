package com.uwm.projektz.binary.dto;

import io.swagger.annotations.ApiModel;

import java.io.Serializable;

/**
 * Created by Tomasz Komoszeski on 2016-05-11.
 */
@ApiModel
public class BinaryDTOId implements Serializable {
    private Long id;



    public BinaryDTOId() {
    }

    public BinaryDTOId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
