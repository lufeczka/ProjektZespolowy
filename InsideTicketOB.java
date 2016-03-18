/**
 * Created by wojni on 11.03.2016.
 */
public class InsideTicketOB {
    Long id;
    TicketType typ;
    String description;
    PriorityOB priority;
    ProjectOB project;
    TicketOB Ticket;



    public InsideTicketOB(Long id, TicketType typ, String description, PriorityOB priority, ProjectOB project, TicketOB Ticket)
    {
        this.id = id;
        this.typ = typ;
        this.description = description;
        this.priority = priority;
        this.project = project;
        this.Ticket = Ticket;
    }
}
