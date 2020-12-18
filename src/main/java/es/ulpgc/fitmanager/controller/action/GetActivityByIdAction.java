package es.ulpgc.fitmanager.controller.action;

import es.ulpgc.fitmanager.view.repository.ActivityRepository;
import es.ulpgc.fitmanager.model.Activity;
import org.springframework.stereotype.Service;

import java.sql.Connection;

@Service
public class GetActivityByIdAction {

    public GetActivityByIdAction() {
        activityRepository = new ActivityRepository();
    }

    private final ActivityRepository activityRepository;

    public Activity execute(Connection conn, Integer activityId) {
        return activityRepository.getActivityById(conn, activityId);
    }
}
