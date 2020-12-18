package es.ulpgc.fitmanager.view.repository;

import es.ulpgc.fitmanager.controller.exceptions.EmptyListException;
import es.ulpgc.fitmanager.controller.exceptions.ReservationNotFoundException;
import es.ulpgc.fitmanager.model.Activity;
import es.ulpgc.fitmanager.model.Reservation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

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
        String sql = "SELECT * FROM Activity WHERE id IN (SELECT * FROM ClientActivity WHERE clientId=?)";
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
                        .duration(resultSet.getDouble("duration"))
                        .date(LocalDateTime.parse(resultSet.getString("date"),
                                DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")))
                        .weekly(resultSet.getBoolean("weekly"))
                        .monitorId(resultSet.getInt("monitorId"))
                        .build());
            }
            if (activities.isEmpty()) throw new EmptyListException("No se han encontrado actividades");
            return activities;
        } catch (SQLException ex) {
            log.error(ex.getMessage());
            return new ArrayList<>();
        }
    }
    public Reservation getReservation(Connection conn, Integer clientId, Integer activityId){
        String sql = "SELECT * FROM ClientActivity WHERE clientId = ? AND activityId = ?";
        try(PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1,clientId);
            statement.setInt(2,activityId);
            ResultSet resultSet = statement.executeQuery();
            return Reservation.builder()
                    .userId(resultSet.getInt("clientId"))
                    .activityId(resultSet.getInt("activityId"))
                    .build();
        } catch (SQLException ex) {
            throw new ReservationNotFoundException("No existe reserva del usuario con id "
                    + clientId + " para la actividad con id " + activityId);
        }
    }
    public void insertReservation(Connection conn, Integer clientId, Integer activityId) {
        String sql = "INSERT INTO ClientActivity (clientId, activityId)" +
                "values (?,?)";
        try (PreparedStatement preparedStatement = conn.prepareStatement(sql)){
            preparedStatement.setInt(1,clientId);
            preparedStatement.setInt(2,activityId);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) { log.error(ex.getMessage()); }
    }

    public void cancelReservation(Connection conn, Integer userId, Integer activityId){
        String sql = "DELETE FROM ClientActivity WHERE clientId=? AND activityId=?";
        try (PreparedStatement preparedStatement = conn.prepareStatement(sql)){
            preparedStatement.setInt(1,userId);
            preparedStatement.setInt(2,activityId);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) { log.error(ex.getMessage()); }
    }
}