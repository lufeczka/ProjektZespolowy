/**
 * Created by wojni on 11.03.2016.
 */
public class TicketOB {
    Long id;
    TicketType typ;
    String description;
    PriorityOB priority;
    ProjectOB project;



    public TicketOB(Long id, TicketType typ, String description, PriorityOB priority, ProjectOB project)
    {
        this.id = id;
        this.typ = typ;
        this.description = description;
        this.priority = priority;
        this.project = project;
    }
}


