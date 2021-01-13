package es.ulpgc.fitmanager.controller.action.user;

import es.ulpgc.fitmanager.model.User;
import es.ulpgc.fitmanager.view.repository.UserRepository;
import java.sql.Connection;
import java.util.List;

public class GetUsersByRoleAction {
    public GetUsersByRoleAction(){
        userRepository = new UserRepository();
    }
    
    private final UserRepository userRepository;
    
    public List<User> execute(Connection conn, int role){
        return userRepository.getUsersByRole(conn, role);
    }
}