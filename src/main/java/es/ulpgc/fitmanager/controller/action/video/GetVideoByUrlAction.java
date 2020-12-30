package es.ulpgc.fitmanager.controller.action.video;

import es.ulpgc.fitmanager.model.Video;
import es.ulpgc.fitmanager.view.repository.VideoRepository;
import java.sql.Connection;

public class GetVideoByUrlAction {
    public GetVideoByUrlAction() {
        videoRepository = new VideoRepository();
    }

    private final VideoRepository videoRepository;

    public Video execute(Connection conn, String videoUrl) {
        return videoRepository.getVideoByUrl(conn, videoUrl);
    }
}
