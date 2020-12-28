package es.ulpgc.fitmanager.controller.action;

import es.ulpgc.fitmanager.view.repository.ActivityRepository;
import es.ulpgc.fitmanager.model.Activity;

import java.sql.Connection;
import java.time.LocalDateTime;

public class GetActivityByKeyAction {

    public GetActivityByKeyAction(){
        activityRepository = new ActivityRepository();
    }

    private final ActivityRepository activityRepository;

    public Activity execute(Connection conn, String name, LocalDateTime date, Integer monitorId) {
        return activityRepository.getActivityByKey(conn, name, date, monitorId);
    }
}
