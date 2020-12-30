package es.ulpgc.fitmanager.controller.action.activity;

import es.ulpgc.fitmanager.controller.exceptions.EmptyListException;
import es.ulpgc.fitmanager.controller.exceptions.MonitorNotAvailableException;
import es.ulpgc.fitmanager.model.Activity;
import es.ulpgc.fitmanager.view.repository.ActivityRepository;

import java.sql.Connection;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class InsertActivityAction {
    public InsertActivityAction() { activityRepository = new ActivityRepository(); }

    private final ActivityRepository activityRepository;

    public Activity execute(Connection conn, Activity activity) {
        if (isMonitorAvailable(conn, activity)) {
            activityRepository.insertActivity(conn, activity);
            return activityRepository.getActivityByKey(conn, activity.getName(),
                    activity.getDate(), activity.getMonitorId());
        }
        throw new MonitorNotAvailableException("El monitor con id "
                + activity.getMonitorId() + " tiene actividades en el mismo periodo de tiempo");
    }

    private boolean isMonitorAvailable(Connection conn, Activity activity) {
        List<Activity> activitiesByMonitorId;
        try{
            activitiesByMonitorId = activityRepository.getActivitiesByMonitorId(conn, activity.getMonitorId());
        } catch (EmptyListException ex) {
            return true;
        }
        if (activity.getRoom()) {
            activitiesByMonitorId = activitiesByMonitorId.stream().filter(activity1 -> !activity1.getRoom()).collect(Collectors.toList());
        }
        for (Activity activityInDB : activitiesByMonitorId) {
            LocalDateTime activityBeginningDate = activity.getDate();
            LocalDateTime activityEndingDate = activityBeginningDate.plusMinutes(activity.getDuration());
            LocalDateTime activityInDBBeginningDate = activityInDB.getDate();
            LocalDateTime activityInDBEndingDate = activityInDBBeginningDate.plusMinutes(activityInDB.getDuration());

            if (activityBeginningDate.isBefore(activityInDBEndingDate) && activityBeginningDate.isAfter(activityInDBBeginningDate)
            || activityEndingDate.isBefore(activityInDBEndingDate) && activityEndingDate.isAfter(activityInDBBeginningDate)
            || activityBeginningDate.isBefore(activityInDBBeginningDate) && activityEndingDate.isAfter(activityInDBEndingDate)) {
                return false;
            }
        }
        return true;
    }
}
