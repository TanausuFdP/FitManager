package es.ulpgc.fitmanager.controller.action;

import es.ulpgc.fitmanager.model.Video;
import es.ulpgc.fitmanager.view.repository.VideoRepository;
import java.sql.Connection;
import java.util.List;

public class GetVideosAction {
    
    public GetVideosAction() {
        videoRepository = new VideoRepository();
    }

    private final VideoRepository videoRepository;

    public List<Video> execute(Connection conn) {
        return videoRepository.getVideos(conn);
    }
    
}
