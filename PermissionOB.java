/**
 * Created by wojni on 11.03.2016.
 */
public class PermissionOB {
    Long id;
    String name;
    RoleOB role;


    public PermissionOB(Long id, String name, RoleOB role)
    {
        this.id = id;
        this.name = name;
        this.role = role;
    }

    //getters
    public Long getPermissionID () { return id;}
    public String getPermissionName () { return name;}
    public RoleOB getPermissionRole () {return role;}

    //setters
    public void setPermissionID (Long id) {this.id = id;}
    public void setPermissionName (String name) {this.name = name;}
    public void setPermissionRole (RoleOB role) {this.role = role;}
}
