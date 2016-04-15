package com.uwm.projektz.ob;


import javax.persistence.*;

/**
 * Created by Tomasz Komoszeski on 2016-04-15.
 */
@Entity
@Table(name = "outside_ticets")
@SequenceGenerator(initialValue = 1,name = "SEQ",sequenceName = "GEN_OUTSIDE_TICKET_ID")
public class OutsideTicetOB extends TicketOB {

}
