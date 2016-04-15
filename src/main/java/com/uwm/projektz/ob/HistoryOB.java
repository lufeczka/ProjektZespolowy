package com.uwm.projektz.ob;
import com.uwm.projektz.enums.HistoryType;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by wojni on 10.03.2016.
 */
@Entity
@Table(name = "histories")
@SequenceGenerator(initialValue = 1,name = "SEQ",sequenceName = "GEN_HISTORY_ID")
public class HistoryOB extends BaseOB {
    HistoryType typ;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID" , referencedColumnName = "ID")
    UserOB user;
    String description;
    Date date;

    public HistoryOB() {
    }

    public HistoryOB(HistoryType typ, UserOB user, String description, Date date)
    {
        this.typ = typ;
        this.user = user;
        this.description = description;
        this.date = date;

    }
}
