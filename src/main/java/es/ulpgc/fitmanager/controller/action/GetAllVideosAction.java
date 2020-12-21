package es.ulpgc.fitmanager.controller.action;

import es.ulpgc.fitmanager.model.Video;
import es.ulpgc.fitmanager.view.repository.VideoRepository;
import java.sql.Connection;
import java.util.List;

public class GetAllVideosAction {
    
    public GetAllVideosAction() {
        videoRepository = new VideoRepository();
    }

    private final VideoRepository videoRepository;

    public List<Video> execute(Connection conn) {
        return videoRepository.getAllVideos(conn);
    }
    
}
