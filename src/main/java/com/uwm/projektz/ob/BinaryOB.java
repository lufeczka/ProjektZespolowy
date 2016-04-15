package com.uwm.projektz.ob;

import javax.persistence.*;

/**
 * Created by wojni on 11.03.2016.
 */
@Entity
@Table(name = "binaries")
@SequenceGenerator(initialValue = 1,name = "SEQ",sequenceName = "GEN_BINARY_ID")
public class BinaryOB extends BaseOB{
    byte binary;
    public BinaryOB() {
    }

    public BinaryOB(byte binary){
        this.binary = binary;
    }
}

