package es.ulpgc.fitmanager.view.repository;

import es.ulpgc.fitmanager.controller.exceptions.InvalidRoleException;
import es.ulpgc.fitmanager.controller.exceptions.NonMatchingPasswordException;
import es.ulpgc.fitmanager.controller.exceptions.UserNotFoundException;
import es.ulpgc.fitmanager.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Slf4j
public class UserRepository {

    private final PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

    public User getUserById(Connection conn, Integer id) {
        String sql = "SELECT * FROM User WHERE id=?";
        try (PreparedStatement statement = conn.prepareStatement(sql)){
            statement.setInt(1,id);
            ResultSet resultSet = statement.executeQuery();
            return getUser(resultSet);
        } catch (SQLException ex) {
            throw new UserNotFoundException("No se ha encontrado ningún usuario con el id "+id+".");
        }
    }

    public User getUserByUsernameAndPassword(Connection conn, String username, String password) {
        String sql = "SELECT * FROM User WHERE username=?";
        User user;
        try (PreparedStatement statement = conn.prepareStatement(sql)){
            statement.setString(1,username);
            ResultSet resultSet = statement.executeQuery();
            user = getUser(resultSet);
        } catch (SQLException ex) {
            throw new UserNotFoundException("No se ha encontrado ningún usuario con el nombre" +
                    " de usuario " + username + " .");
        }
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new NonMatchingPasswordException("La contraseña introducida " +
                    "no coincide con la base de datos");
        }
        return user;
    }

    private User getUser(ResultSet resultSet) throws SQLException {
        return User.builder()
                .id(resultSet.getInt("id"))
                .name(resultSet.getString("name"))
                .surname(resultSet.getString("surname"))
                .username(resultSet.getString("username"))
                .password(resultSet.getString("password"))
                .phoneNumber(resultSet.getInt("phoneNumber"))
                .role(resultSet.getInt("role"))
                .build();
    }

    public void insertUser(Connection conn, User user){
        String sql = "INSERT INTO User (name, surname, username, password, phoneNumber, role)" +
                "values (?,?,?,?,?,?)";
        try (PreparedStatement preparedStatement = conn.prepareStatement(sql)){
            preparedStatement.setString(1,user.getName());
            preparedStatement.setString(2,user.getSurname());
            preparedStatement.setString(3,user.getUsername());
            preparedStatement.setString(4,passwordEncoder.encode(user.getPassword()));
            preparedStatement.setLong(5,user.getPhoneNumber());
            preparedStatement.setInt(6,user.getRole());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            log.error(ex.getLocalizedMessage());
        }
    }

    public void insertUserRole(Connection conn, User userInDB) {
        String sql = getSQL(userInDB.getRole());
        try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
            preparedStatement.setInt(1,userInDB.getId());
            if (userInDB.getRole() == 2)
                preparedStatement.setInt(2,userInDB.getVideoRepositoryId());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) { log.error(ex.getMessage()); }
    }

    private String getSQL(Integer userRole) {
        switch (userRole) {
            case 1:
                return "INSERT INTO Admin (id) values (?)";
            case 2:
                return "INSERT INTO Monitor (id, videoRepositoryId) values (?,?)";
            case 3:
                return "INSERT INTO Client (id) values (?)";
            default:
                throw new InvalidRoleException("El rol indicado no es válido");
        }
    }

    public void updateUser(Connection conn, User user) {
        String sql = "UPDATE User SET name=?," +
                " surname=?, username=?, password=?, phoneNumber=? WHERE id=?";
        try(PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setString(1,user.getName());
            preparedStatement.setString(2,user.getSurname());
            preparedStatement.setString(3,user.getUsername());
            preparedStatement.setString(4,passwordEncoder.encode(user.getPassword()));
            preparedStatement.setInt(5, user.getPhoneNumber());
            preparedStatement.setInt(6, user.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            throw new UserNotFoundException("No se pudo encontrar ningún usuario con id "
                    + user.getId() + ".");
        }
    }
}