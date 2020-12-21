package es.ulpgc.fitmanager.controller.dbcontroller;

import es.ulpgc.fitmanager.controller.action.GetActivityByTypeAction;
import es.ulpgc.fitmanager.controller.action.GetActivityByIdAction;
import es.ulpgc.fitmanager.controller.action.GetActivitiesByMonitorIdAction;
import es.ulpgc.fitmanager.controller.action.GetActivityByNameAction;
import es.ulpgc.fitmanager.controller.action.InsertActivityAction;
import es.ulpgc.fitmanager.controller.exceptions.ActivityAlreadyExistsException;
import es.ulpgc.fitmanager.controller.exceptions.ActivityNotFoundException;
import es.ulpgc.fitmanager.controller.exceptions.EmptyListException;
import es.ulpgc.fitmanager.model.Activity;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ActivityController extends Controller {

    public ActivityController() {
        getActivityByIdAction = new GetActivityByIdAction();
        getActivityByNameAction = new GetActivityByNameAction();
        insertActivityAction = new InsertActivityAction();
        getActivitiesByTypeAction = new GetActivityByTypeAction();
        getActivitiesByMonitorIdAction = new GetActivitiesByMonitorIdAction();
        
    }
    private final GetActivityByTypeAction getActivitiesByTypeAction;
    
    private final GetActivityByIdAction getActivityByIdAction;

    private final GetActivityByNameAction getActivityByNameAction;

    private final InsertActivityAction insertActivityAction;
    
    private final GetActivitiesByMonitorIdAction getActivitiesByMonitorIdAction;

    public List<Activity> getActivityByMonitorId(Integer monitorId){
        Connection conn = connectToDB();
        try{
            return getActivitiesByMonitorIdAction.execute(conn, monitorId);
        } catch (EmptyListException ex) {
            log.error(ex.getLocalizedMessage());
            return new ArrayList<>();
        }
    }
    
    public Activity getActivityById(Integer activityId) {
        Connection conn = connectToDB();
        try {
            return getActivityByIdAction.execute(conn, activityId);
        } catch (ActivityNotFoundException ex) {
            log.error(ex.getLocalizedMessage());
            return null;
        }
    }

    public Activity getActivityByName(String activityName) {
        Connection conn = connectToDB();
        try {
            return getActivityByNameAction.execute(conn, activityName);
        } catch (ActivityNotFoundException ex) {
            log.error(ex.getLocalizedMessage());
            return null;
        }
    }

    public Activity insertActivity(Activity activity) {
        Connection conn = connectToDB();
        try {
            return insertActivityAction.execute(conn, activity);
        } catch (ActivityAlreadyExistsException ex) {
            log.error(ex.getLocalizedMessage());
            return null;
        }
    }
    
    public List<Activity> getActivitiesByType(boolean type){
        Connection conn = connectToDB();
        try{
            return getActivitiesByTypeAction.execute(conn, type);
        } catch (EmptyListException ex) {
            log.error(ex.getLocalizedMessage());
            return new ArrayList<>();
        }
    }
}
