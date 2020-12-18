package es.ulpgc.fitmanager.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class User {
    public static final Integer ADMIN_ROLE = 1;
    public static final Integer MONITOR_ROLE = 2;
    public static final Integer CLIENT_ROLE = 3;

    private Integer id;
    private String name;
    private String surname;
    private String username;
    private String password;
    private Integer phoneNumber;
    private Integer role;
    /** Only used if role == MONITOR_ROLE*/
    private Integer VideoRepositoryId;

}
