package es.ulpgc.fitmanager.view.repository;

import es.ulpgc.fitmanager.controller.exceptions.ActivityNotFoundException;
import es.ulpgc.fitmanager.model.Activity;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
public class ActivityRepository {

    public Activity getActivityById(Connection conn, Integer activityId) {
        String sql = "SELECT * FROM Activity WHERE id=?";
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, activityId);
            ResultSet resultSet = statement.executeQuery();
            return getActivity(resultSet);
        } catch (SQLException ex) {
            throw new ActivityNotFoundException("No se ha encontrado ninguna actividad" +
                    " con id " + activityId + ".");
        }
    }

    private Activity getActivity(ResultSet resultSet) throws SQLException {
        return Activity.builder()
                .id(resultSet.getInt("id"))
                .name(resultSet.getString("name"))
                .description(resultSet.getString("description"))
                .capacity(resultSet.getInt("capacity"))
                .duration(resultSet.getDouble("duration"))
                .date(LocalDateTime.parse(resultSet.getString("date"),
                        DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")))
                .weekly(resultSet.getBoolean("weekly"))
                .monitorId(resultSet.getInt("monitorId"))
                .build();
    }

    public void insertActivity(Connection conn, Activity activity){
        String sql = "INSERT INTO Activity " +
                "(name, description, capacity, duration, date, weekly, monitorId)"
                + "VALUES (?,?,?,?,?,?,?)";
        try (PreparedStatement preparedStatement = conn.prepareStatement(sql)){
            preparedStatement.setString(1,activity.getName());
            preparedStatement.setString(2, activity.getDescription());
            preparedStatement.setInt(3, activity.getCapacity());
            preparedStatement.setDouble(4,activity.getDuration());
            preparedStatement.setString(5, activity.getDate()
                    .format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")));
            preparedStatement.setBoolean(6,activity.getWeekly());
            preparedStatement.setInt(7,activity.getMonitorId());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) { log.error(ex.getMessage()); }
    }

    public Activity getActivityByName(Connection conn, String name) {
        String sql = "SELECT * FROM Activity WHERE name=?";
        try (PreparedStatement statement = conn.prepareStatement(sql)){
            statement.setString(1,name);
            ResultSet resultSet = statement.executeQuery();
            return getActivity(resultSet);
        } catch (SQLException ex) {
            throw new ActivityNotFoundException("No se ha encontrado ninguna actividad "
                    + "de nombre" + name + ".");
        }
    }
}