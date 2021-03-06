package es.ulpgc.fitmanager.controller.action.activity;

import es.ulpgc.fitmanager.model.Activity;
import es.ulpgc.fitmanager.view.repository.ActivityRepository;
import java.sql.Connection;
import java.util.List;

public class GetActivitiesByTypeAction {
    public GetActivitiesByTypeAction() { activityRepository = new ActivityRepository(); }
    
    private final ActivityRepository activityRepository;
    
    public List<Activity> execute(Connection conn, boolean type){
        return activityRepository.getActivitiesByType(conn, type);
    }
}