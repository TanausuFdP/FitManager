package es.ulpgc.fitmanager.controller.action;

import es.ulpgc.fitmanager.model.Video;
import es.ulpgc.fitmanager.view.repository.VideoRepository;
import java.sql.Connection;


public class GetVideoByURLAction {
    public GetVideoByURLAction() {
        videoRepository = new VideoRepository();
    }

    private final VideoRepository videoRepository;

    public Video execute(Connection conn, String videoUrl) {
        return videoRepository.getVideoByURL(conn, videoUrl);
    }
}
