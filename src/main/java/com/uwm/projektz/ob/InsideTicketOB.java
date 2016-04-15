package com.uwm.projektz.ob;

import com.uwm.projektz.enums.TicketType;

import javax.persistence.*;


/**
 * Created by wojni on 11.03.2016.
 */
@Entity
@Table(name = "inside_ticets")
@SequenceGenerator(initialValue = 1,name = "SEQ",sequenceName = "GEN_INSIDE_TICKET_ID")
public class InsideTicketOB extends TicketOB {

    public InsideTicketOB() {
    }


}
