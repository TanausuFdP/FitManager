package es.ulpgc.fitmanager.controller.action.activity;

import es.ulpgc.fitmanager.view.repository.ActivityRepository;
import java.sql.Connection;

public class DeleteActivityByIdAction {
    public DeleteActivityByIdAction() { activityRepository = new ActivityRepository(); }

    private final ActivityRepository activityRepository;

    public void execute(Connection conn, Integer activityId) {
        activityRepository.deleteActivityById(conn, activityId);
    }
}
