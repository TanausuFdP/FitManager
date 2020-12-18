package es.ulpgc.fitmanager.controller.action;

import es.ulpgc.fitmanager.view.repository.UserRepository;
import es.ulpgc.fitmanager.model.User;

import java.sql.Connection;

public class GetUserByUsernameAndPasswordAction {

    public GetUserByUsernameAndPasswordAction() {
        userRepository = new UserRepository();
    }

    private final UserRepository userRepository;

    public User execute(Connection conn, String username, String password) {
        return userRepository.getUserByUsernameAndPassword(conn, username, password);
    }
}
