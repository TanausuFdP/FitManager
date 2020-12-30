package es.ulpgc.fitmanager.controller.action.user;

import es.ulpgc.fitmanager.view.repository.UserRepository;
import es.ulpgc.fitmanager.model.User;

import java.sql.Connection;

public class GetUserByIdAction {
    public GetUserByIdAction() {
        userRepository = new UserRepository();
    }

    private final UserRepository userRepository;

    public User execute(Connection conn, Integer userId) {
        return userRepository.getUserById(conn, userId);
    }
}
