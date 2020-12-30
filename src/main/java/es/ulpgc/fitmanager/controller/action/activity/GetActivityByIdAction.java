package es.ulpgc.fitmanager.controller.action.activity;

import es.ulpgc.fitmanager.model.Activity;
import es.ulpgc.fitmanager.view.repository.ActivityRepository;

import java.sql.Connection;

public class GetActivityByIdAction {
    public GetActivityByIdAction() {
        activityRepository = new ActivityRepository();
    }

    private final ActivityRepository activityRepository;

    public Activity execute(Connection conn, Integer activityId) {
        return activityRepository.getActivityById(conn, activityId);
    }
}
