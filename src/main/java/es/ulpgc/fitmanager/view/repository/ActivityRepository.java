package es.ulpgc.fitmanager.view.repository;

import es.ulpgc.fitmanager.controller.exceptions.ActivityNotFoundException;
import es.ulpgc.fitmanager.controller.exceptions.EmptyListException;
import es.ulpgc.fitmanager.model.Activity;
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
public class ActivityRepository {
    public void deleteActivityById(Connection conn, Integer activityId){
        String sql = "DELETE FROM Activity WHERE id=?";
        try (PreparedStatement preparedStatement = conn.prepareStatement(sql)){
            preparedStatement.setInt(1,activityId);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) { log.error(ex.getLocalizedMessage()); }
    }
    
    public Activity getActivityById(Connection conn, Integer activityId) {
        String sql = "SELECT * FROM Activity WHERE id=?";
        try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setInt(1, activityId);
            ResultSet resultSet = preparedStatement.executeQuery();
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
                .duration(resultSet.getInt("duration"))
                .date(LocalDateTime.parse(resultSet.getString("date"),
                        DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")))
                .weekly(resultSet.getBoolean("weekly"))
                .room(resultSet.getBoolean("room"))
                .monitorId(resultSet.getInt("monitorId"))
                .build();
    }
    
    public Activity getActivityByName(Connection conn, String name) {
        String sql = "SELECT * FROM Activity WHERE name=?";
        try (PreparedStatement preparedStatement = conn.prepareStatement(sql)){
            preparedStatement.setString(1,name);
            ResultSet resultSet = preparedStatement.executeQuery();
            return getActivity(resultSet);
        } catch (SQLException ex) {
            throw new ActivityNotFoundException("No se ha encontrado ninguna actividad "
                    + "de nombre" + name + ".");
        }
    }

    public List<Activity> getActivitiesByMonitorId(Connection conn, Integer monitorId) {
        String sql = "SELECT * FROM Activity WHERE monitorId=?";
        List<Activity> activities = new ArrayList<>();
        try (PreparedStatement preparedStatement = conn.prepareStatement(sql)){
            preparedStatement.setInt(1, monitorId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) activities.add(getActivity(resultSet));
            if (activities.isEmpty()) throw new EmptyListException("No se han encontrado actividades");
            return activities;
        } catch (SQLException ex) {
            log.error(ex.getLocalizedMessage());
            return new ArrayList<>();
        }
    }

    public List<Activity> getActivitiesByType(Connection conn, boolean type) {
        String sql = "SELECT * FROM Activity WHERE room=?";
        List<Activity> activities = new ArrayList<>();
        try (PreparedStatement preparedStatement = conn.prepareStatement(sql)){
            preparedStatement.setBoolean(1, type);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) activities.add(getActivity(resultSet));
            if (activities.isEmpty()) throw new EmptyListException("No se han encontrado actividades");
            return activities;
        } catch (SQLException ex) {
            log.error(ex.getLocalizedMessage());
            return new ArrayList<>();
        }
    }
    
    public Integer getCountOfActivitiesByMonitorId(Connection conn, Integer monitorId, boolean room) {
        String sql = "SELECT COUNT (*) FROM Activity WHERE monitorId=? AND room=?";
        try (PreparedStatement preparedStatement = conn.prepareStatement(sql)){
            preparedStatement.setInt(1,monitorId);
            preparedStatement.setBoolean(2,room);
            return preparedStatement.executeQuery().getInt(1);
        } catch (SQLException ex) {
            log.error(ex.getLocalizedMessage());
            return 0;
        }
    }
    
    public void insertActivity(Connection conn, Activity activity){
        String sql = "INSERT INTO Activity " +
                "(name, description, capacity, duration, date, weekly, room, monitorId)"
                + "VALUES (?,?,?,?,?,?,?,?)";
        try (PreparedStatement preparedStatement = conn.prepareStatement(sql)){
            preparedStatement.setString(1,activity.getName());
            preparedStatement.setString(2, activity.getDescription());
            preparedStatement.setInt(3, activity.getCapacity());
            preparedStatement.setDouble(4,activity.getDuration());
            preparedStatement.setString(5, activity.getDate()
                    .format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")));
            preparedStatement.setBoolean(6,activity.getWeekly());
            preparedStatement.setBoolean(7,activity.getRoom());
            preparedStatement.setInt(8,activity.getMonitorId());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) { log.error(ex.getMessage()); }
    }
}