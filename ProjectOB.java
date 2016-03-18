/**
 * Created by wojni on 10.03.2016.
 */
public class ProjectOB {
    Long id;
    String name;
    String descritpion;
    String version;
    PriorityOB priority;


    public ProjectOB(Long id, String name, String desc, String version, PriorityOB priority)
    {
        this.id = id;
        this.name = name;
        this.descritpion = desc;
        this.version = version;
        this.priority = priority;
    }
}
