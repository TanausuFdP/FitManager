package es.ulpgc.fitmanager.controller.dbcontroller;

import es.ulpgc.fitmanager.controller.action.GetUserByIdAction;
import es.ulpgc.fitmanager.controller.action.GetUserByUsernameAndPasswordAction;
import es.ulpgc.fitmanager.controller.action.InsertUserAction;
import es.ulpgc.fitmanager.controller.action.UpdateUserAction;
import es.ulpgc.fitmanager.controller.action.GetUsersByRoleAction;
import es.ulpgc.fitmanager.controller.exceptions.EmptyListException;
import es.ulpgc.fitmanager.controller.exceptions.NonMatchingPasswordException;
import es.ulpgc.fitmanager.controller.exceptions.UserAlreadyExistsException;
import es.ulpgc.fitmanager.controller.exceptions.UserNotFoundException;
import es.ulpgc.fitmanager.model.User;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class UserController extends Controller {
    public UserController() {
        getUserByIdAction = new GetUserByIdAction();
        getUserByUsernameAndPasswordAction = new GetUserByUsernameAndPasswordAction();
        getUsersByRoleAction = new GetUsersByRoleAction();
        insertUserAction = new InsertUserAction();
        updateUserAction = new UpdateUserAction();
    }

    private final GetUserByIdAction getUserByIdAction;

    private final GetUserByUsernameAndPasswordAction getUserByUsernameAndPasswordAction;

    private final GetUsersByRoleAction getUsersByRoleAction;

    private final InsertUserAction insertUserAction;

    private final UpdateUserAction updateUserAction;

    public User getUserById(Integer id){
        Connection conn = connectToDB();
        try {
            return getUserByIdAction.execute(conn, id);
        } catch (UserNotFoundException ex) {
            log.error(ex.getLocalizedMessage());
            return null;
        }
    }

    public User getUserByUsernameAndPassword(String username, String password){
        Connection conn = connectToDB();
        try {
            return getUserByUsernameAndPasswordAction.execute(conn, username, password);
        } catch (UserNotFoundException | NonMatchingPasswordException ex) {
            log.error(ex.getLocalizedMessage());
            return null;
        }
    }

    public List<User> getUsersByRole(int role){
        Connection conn = connectToDB();
        try{
            return getUsersByRoleAction.execute(conn, role);
        } catch (EmptyListException |UserNotFoundException ex) {
            log.error(ex.getLocalizedMessage());
            return new ArrayList<>();
        }
    }

    public User insertUser(User user){
        Connection conn = connectToDB();
        try {
            return insertUserAction.execute(conn, user);
        } catch (UserAlreadyExistsException ex) {
            log.error(ex.getLocalizedMessage());
            return null;
        }
    }

    public User updateUser(User user){
        Connection conn = connectToDB();
        try {
            return updateUserAction.execute(conn, user);
        }catch (UserNotFoundException ex){
            log.error(ex.getLocalizedMessage());
            return null;
        }
    }
}
