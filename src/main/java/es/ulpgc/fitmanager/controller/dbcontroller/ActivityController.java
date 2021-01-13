package es.ulpgc.fitmanager.controller.dbcontroller;

import es.ulpgc.fitmanager.controller.action.activity.*;
import es.ulpgc.fitmanager.controller.exceptions.EmptyListException;
import es.ulpgc.fitmanager.controller.exceptions.MonitorNotAvailableException;
import es.ulpgc.fitmanager.model.Activity;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ActivityController extends Controller {

    public ActivityController() {
        deleteActivityByIdAction = new DeleteActivityByIdAction();
        getActivitiesByMonitorIdAction = new GetActivitiesByMonitorIdAction();
        getActivitiesByTypeAction = new GetActivitiesByTypeAction();
        insertActivityAction = new InsertActivityAction();
    }
    private final DeleteActivityByIdAction deleteActivityByIdAction;
    
    private final GetActivitiesByMonitorIdAction getActivitiesByMonitorIdAction;

    private final GetActivitiesByTypeAction getActivitiesByTypeAction;
    
    private final InsertActivityAction insertActivityAction;

    public void deleteActivityById(Integer activityId){
        Connection conn = connectToDB();
        deleteActivityByIdAction.execute(conn, activityId);
    }

    public List<Activity> getActivitiesByMonitorId(Integer monitorId){
        Connection conn = connectToDB();
        try{
            return getActivitiesByMonitorIdAction.execute(conn, monitorId);
        } catch (EmptyListException ex) {
            log.error(ex.getLocalizedMessage());
            return new ArrayList<>();
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

    public void insertActivity(Activity activity) {
        Connection conn = connectToDB();
        try {
            insertActivityAction.execute(conn, activity);
        } catch (MonitorNotAvailableException ex) {
            log.error(ex.getLocalizedMessage());
        }
    }
}
