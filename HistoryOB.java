import java.util.Date;

/**
 * Created by wojni on 10.03.2016.
 */
public class HistoryOB {
    Long id;
    HistoryType typ;
    TicketOB ticket;
    UserOB user;
    String description;
    Date date;


    public HistoryOB(Long id, HistoryType typ, TicketOB ticket, UserOB user, String description, Date date)
    {
        this.id = id;
        this.typ = typ;
        this.ticket = ticket;
        this.user = user;
        this.description = description;
        this.date = date;

    }
}
