package es.ulpgc.fitmanager.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class User {
    public static final int ADMIN_ROLE = 1;
    public static final int MONITOR_ROLE = 2;
    public static final int CLIENT_ROLE = 3;

    private Integer id;
    private String name;
    private String surname;
    private String username;
    private String password;
    private Integer phoneNumber;
    private Integer role;
    /** Only used if role == MONITOR_ROLE*/
    private Integer videoListId;
    
    @Override
    public String toString(){
        return name + " " + surname + " " + phoneNumber;
    }
}
