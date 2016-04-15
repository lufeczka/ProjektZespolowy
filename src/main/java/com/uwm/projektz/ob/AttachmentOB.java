package com.uwm.projektz.ob;


import javax.persistence.*;

/**
 * Created by wojni on 11.03.2016.
 */
@Entity
@Table(name = "attachments")
@SequenceGenerator(initialValue = 1,name = "SEQ",sequenceName = "GEN_ATTACHMENT_ID")
public class AttachmentOB extends BaseOB {
    String name;
    String file_name;
    String mine_type;
    @ManyToOne(fetch = FetchType.LAZY ,cascade = CascadeType.ALL)
    @JoinColumn(name = "BINARY_ID", referencedColumnName = "ID")
    BinaryOB binary;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID" , referencedColumnName = "ID")
    UserOB user;

    public AttachmentOB() {
    }

    public AttachmentOB(TicketOB ticketOB, String name, String file_name, String mine_type, BinaryOB binaryOB)
    {
        this.name=name;
        this.file_name=file_name;
        this.mine_type=mine_type;
        this.binary = binaryOB;
    }
}
