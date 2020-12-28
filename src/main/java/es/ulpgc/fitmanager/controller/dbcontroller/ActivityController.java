package es.ulpgc.fitmanager.controller.dbcontroller;

import es.ulpgc.fitmanager.controller.action.*;
import es.ulpgc.fitmanager.controller.exceptions.ActivityNotFoundException;
import es.ulpgc.fitmanager.controller.exceptions.EmptyListException;
import es.ulpgc.fitmanager.controller.exceptions.MonitorNotAvailableException;
import es.ulpgc.fitmanager.model.Activity;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ActivityController extends Controller {

    public ActivityController() {
        deleteActivityByIdAction = new DeleteActivityByIdAction();
        getActivityByIdAction = new GetActivityByIdAction();
        getActivityByKeyAction = new GetActivityByKeyAction();
        getActivitiesByMonitorIdAction = new GetActivitiesByMonitorIdAction();
        getActivitiesByTypeAction = new GetActivityByTypeAction();
        getCountOfActivitiesByMonitorIdAction = new GetCountOfActivitiesByMonitorIdAction();
        insertActivityAction = new InsertActivityAction();
    }
    private final DeleteActivityByIdAction deleteActivityByIdAction;
    
    private final GetActivityByIdAction getActivityByIdAction;

    private final GetActivityByKeyAction getActivityByKeyAction;

    private final GetActivitiesByMonitorIdAction getActivitiesByMonitorIdAction;

    private final GetActivityByTypeAction getActivitiesByTypeAction;
    
    private final GetCountOfActivitiesByMonitorIdAction getCountOfActivitiesByMonitorIdAction;

    private final InsertActivityAction insertActivityAction;

    public void deleteActivityById(Integer activityId){
        Connection conn = connectToDB();
        deleteActivityByIdAction.execute(conn, activityId);
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

    public Activity getActivityByKey(String activityName,
                                     LocalDateTime date, Integer monitorId) {
        Connection conn = connectToDB();
        try {
            return getActivityByKeyAction.execute(conn, activityName, date, monitorId);
        } catch (ActivityNotFoundException ex) {
            log.error(ex.getLocalizedMessage());
            return null;
        }
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
    
    public Integer getCountOfActivitiesByMonitorId(Integer monitorId, boolean room){
        Connection conn = connectToDB();
        return getCountOfActivitiesByMonitorIdAction.execute(conn, monitorId,room);
    }


    public Activity insertActivity(Activity activity) {
        Connection conn = connectToDB();
        try {
            return insertActivityAction.execute(conn, activity);
        } catch (MonitorNotAvailableException ex) {
            log.error(ex.getLocalizedMessage());
            return null;
        }
    }
}
