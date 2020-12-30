
package es.ulpgc.fitmanager.controller.action.activity;

import es.ulpgc.fitmanager.view.repository.ActivityRepository;
import java.sql.Connection;

public class GetCountOfActivitiesByMonitorIdAction {
    public GetCountOfActivitiesByMonitorIdAction() {
        activityRepository = new ActivityRepository();
    }

    private final ActivityRepository activityRepository;

    public Integer execute(Connection conn, Integer monitorId, boolean room) {
        return activityRepository.getCountOfActivitiesByMonitorId(conn,monitorId, room);
    }
}
