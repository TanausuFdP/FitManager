package es.ulpgc.fitmanager.view.repository;

import es.ulpgc.fitmanager.controller.exceptions.ActivityNotFoundException;
import es.ulpgc.fitmanager.controller.exceptions.EmptyListException;
import es.ulpgc.fitmanager.controller.exceptions.ReservationNotFoundException;
import es.ulpgc.fitmanager.controller.exceptions.UserNotFoundException;
import es.ulpgc.fitmanager.model.Activity;
import es.ulpgc.fitmanager.model.Reservation;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ReservationRepository {
    public List<Activity> getActivities(Connection conn, Integer clientId) {
        String sql = "SELECT * FROM Activity WHERE Activity.id IN " +
                "(SELECT ca.activityId FROM Reservation ca WHERE ca.clientId=?)";
        List<Activity> activities = new ArrayList<>();
        try (PreparedStatement statement = conn.prepareStatement(sql)){
            statement.setInt(1, clientId);
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()){
                activities.add(Activity.builder()
                        .id(resultSet.getInt("id"))
                        .name(resultSet.getString("name"))
                        .description(resultSet.getString("description"))
                        .capacity(resultSet.getInt("capacity"))
                        .duration(resultSet.getInt("duration"))
                        .date(LocalDateTime.parse(resultSet.getString("date"),
                                DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")))
                        .weekly(resultSet.getBoolean("weekly"))
                        .monitorId(resultSet.getInt("monitorId"))
                        .build());
            }
            if (activities.isEmpty()) throw new EmptyListException("No se han encontrado actividades");
            return activities;
        } catch (SQLException ex) { throw new UserNotFoundException(""); }
    }
    public Reservation getReservationByIds(Connection conn, Integer clientId, Integer activityId){
        String sql = "SELECT * FROM Reservation WHERE clientId = ? AND activityId = ?";
        try(PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1,clientId);
            statement.setInt(2,activityId);
            ResultSet resultSet = statement.executeQuery();
            return Reservation.builder()
                    .clientId(resultSet.getInt("clientId"))
                    .activityId(resultSet.getInt("activityId"))
                    .build();
        } catch (SQLException ex) {
            throw new ReservationNotFoundException("No existe reserva del usuario con id "
                    + clientId + " para la actividad con id " + activityId);
        }
    }
    public void insertReservation(Connection conn, Reservation reservation) {
        String sql = "INSERT INTO Reservation (clientId, activityId)" +
                "values (?,?)";
        try (PreparedStatement preparedStatement = conn.prepareStatement(sql)){
            preparedStatement.setInt(1,reservation.getClientId());
            preparedStatement.setInt(2,reservation.getActivityId());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) { log.error(ex.getLocalizedMessage()); }
    }

    public void cancelReservation(Connection conn, Integer userId, Integer activityId){
        String sql = "DELETE FROM Reservation WHERE clientId=? AND activityId=?";
        try (PreparedStatement preparedStatement = conn.prepareStatement(sql)){
            preparedStatement.setInt(1,userId);
            preparedStatement.setInt(2,activityId);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) { log.error(ex.getLocalizedMessage()); }
    }

    public Integer getReservationsOfActivity(Connection conn, Integer activityId) {
        String sql = "Select COUNT (*) FROM Reservation WHERE activityId=?";
        try (PreparedStatement preparedStatement = conn.prepareStatement(sql)){
            preparedStatement.setInt(1,activityId);
            return preparedStatement.executeQuery().getInt(1);
        } catch (SQLException ex) {
            log.error(ex.getLocalizedMessage());
            return 0;
        }
    }
}