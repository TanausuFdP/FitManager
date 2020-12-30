package es.ulpgc.fitmanager.controller.action.video;

import es.ulpgc.fitmanager.view.repository.VideoRepository;
import java.sql.Connection;

public class GetVideoListIdByMonitorIdAction {
    public GetVideoListIdByMonitorIdAction(){
        videoRepository = new VideoRepository();
    }
    
    private final VideoRepository videoRepository;
    
    public Integer execute(Connection conn, Integer monitorId) {
        return videoRepository.getVideoListIdByMonitorId(conn, monitorId);
    }
    
}
