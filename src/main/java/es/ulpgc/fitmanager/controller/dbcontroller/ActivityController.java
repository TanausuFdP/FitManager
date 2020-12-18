package es.ulpgc.fitmanager.controller.dbcontroller;

import es.ulpgc.fitmanager.controller.action.GetActivityByIdAction;
import es.ulpgc.fitmanager.controller.action.GetActivityByNameAction;
import es.ulpgc.fitmanager.controller.action.InsertActivityAction;
import es.ulpgc.fitmanager.controller.exceptions.ActivityAlreadyExistsException;
import es.ulpgc.fitmanager.controller.exceptions.ActivityNotFoundException;
import es.ulpgc.fitmanager.model.Activity;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;

@Slf4j
public class ActivityController extends Controller {

    public ActivityController() {
        getActivityByIdAction = new GetActivityByIdAction();
        getActivityByNameAction = new GetActivityByNameAction();
        insertActivityAction = new InsertActivityAction();
    }

    private final GetActivityByIdAction getActivityByIdAction;

    private final GetActivityByNameAction getActivityByNameAction;

    private final InsertActivityAction insertActivityAction;

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
}
