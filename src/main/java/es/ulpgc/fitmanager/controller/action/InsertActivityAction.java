package es.ulpgc.fitmanager.controller.action;

import es.ulpgc.fitmanager.controller.exceptions.ActivityAlreadyExistsException;
import es.ulpgc.fitmanager.controller.exceptions.ActivityNotFoundException;
import es.ulpgc.fitmanager.View.repository.ActivityRepository;
import es.ulpgc.fitmanager.model.Activity;

import java.sql.Connection;

public class InsertActivityAction {

    public InsertActivityAction() {
        activityRepository = new ActivityRepository();
    }

    private final ActivityRepository activityRepository;

    public Activity execute(Connection conn, Activity activity) {
        try {
            activityRepository.getActivityByName(conn, activity.getName());
            throw new ActivityAlreadyExistsException("Ya existe una actividad con nombre "
                    + activity.getName());
        } catch (ActivityNotFoundException ex){
            activityRepository.insertActivity(conn, activity);
            return activityRepository.getActivityByName(conn, activity.getName());
        }
    }
}
