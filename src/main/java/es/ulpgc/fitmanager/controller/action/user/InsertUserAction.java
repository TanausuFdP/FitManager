package es.ulpgc.fitmanager.controller.action.user;

import es.ulpgc.fitmanager.controller.exceptions.UserAlreadyExistsException;
import es.ulpgc.fitmanager.controller.exceptions.UserNotFoundException;
import es.ulpgc.fitmanager.view.repository.UserRepository;
import es.ulpgc.fitmanager.model.User;

import java.sql.Connection;

public class InsertUserAction {
    public InsertUserAction() {
        userRepository = new UserRepository();
    }

    private final UserRepository userRepository;

    public User execute(Connection conn, User user) {
        try {
            userRepository.getUserByUsernameAndPassword(conn, user.getUsername(), user.getPassword());
            throw new UserAlreadyExistsException("Ya existe un usuario con el nombre de usuario "
                    + user.getUsername());
        } catch (UserNotFoundException ex){
            userRepository.insertUser(conn, user);
            return userRepository.getUserByUsernameAndPassword(conn, user.getUsername(), user.getPassword());
        }
    }
}