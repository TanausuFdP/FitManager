package es.ulpgc.fitmanager.controller.action;

import es.ulpgc.fitmanager.View.repository.UserRepository;
import es.ulpgc.fitmanager.model.User;

import java.sql.Connection;

public class UpdateUserAction {

    public UpdateUserAction() {
        userRepository = new UserRepository();
    }

    private final UserRepository userRepository;

    public User execute(Connection conn, User user) {
        userRepository.updateUser(conn, user);
        return userRepository.getUserById(conn, user.getId());
    }
}