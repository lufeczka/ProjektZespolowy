/**
 * Created by wojni on 11.03.2016.
 */
public class AttachmentOB {
    Long id;
    TicketOB ticket;
    String name;
    String file_name;
    String mine_type;
    BinaryOB binary;

    public AttachmentOB(Long id, TicketOB ticketOB, String name, String file_name, String mine_type, BinaryOB binaryOB)
    {
        this.id = id;
        this.ticket = ticketOB;
        this.name=name;
        this.file_name=file_name;
        this.mine_type=mine_type;
        this.binary = binaryOB;
    }
}
