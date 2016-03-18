/**
 * Created by wojni on 10.03.2016.
 */
public class RoleOB {
    Long id;
    String name;
    UserOB user;

    public RoleOB(Long id, String Name, UserOB User)
    {
        this.id = id;
        this.name = Name;
        this.user = User;
    }
}
