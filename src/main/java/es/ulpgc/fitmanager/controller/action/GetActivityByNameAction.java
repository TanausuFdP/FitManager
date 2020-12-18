package es.ulpgc.fitmanager.controller.action;

import es.ulpgc.fitmanager.View.repository.ActivityRepository;
import es.ulpgc.fitmanager.model.Activity;

import java.sql.Connection;

public class GetActivityByNameAction {

    public GetActivityByNameAction(){
        activityRepository = new ActivityRepository();
    }

    private final ActivityRepository activityRepository;

    public Activity execute(Connection conn, String activityName) {
        return activityRepository.getActivityByName(conn, activityName);
    }
}
