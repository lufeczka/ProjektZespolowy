package com.uwm.projektz.ob;


import javax.persistence.*;
import java.util.List;

/**
 * Created by Tomasz Komoszeski on 2016-04-15.
 */
@Entity
@Table(name = "outside_ticets")
@SequenceGenerator(initialValue = 1,name = "SEQ",sequenceName = "GEN_OUTSIDE_TICKET_ID")
public class OutsideTicetOB extends TicketOB {
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "OUTSIDE_TICKET_ID",referencedColumnName = "ID")
    List<InsideTicketOB> insideTickets;

}
