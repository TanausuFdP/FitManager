package es.ulpgc.fitmanager.controller.action.video;

import es.ulpgc.fitmanager.model.Video;
import es.ulpgc.fitmanager.view.repository.VideoRepository;
import java.sql.Connection;
import java.util.List;

public class GetVideosByCategoryIdAction {
    public GetVideosByCategoryIdAction() {
        videoRepository = new VideoRepository();
    }

    private final VideoRepository videoRepository;

    public List<Video> execute(Connection conn, Integer categoryId) {
        return videoRepository.getVideosByCategoryId(conn, categoryId);
    }
    
}
