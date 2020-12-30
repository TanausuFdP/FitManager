package es.ulpgc.fitmanager.controller.action.video;

import es.ulpgc.fitmanager.model.Video;
import es.ulpgc.fitmanager.view.repository.VideoRepository;

import java.sql.Connection;

public class GetVideoByIdAction {
    public GetVideoByIdAction() {
        videoRepository = new VideoRepository();
    }

    private final VideoRepository videoRepository;

    public Video execute(Connection conn, Integer videoId) {
        return videoRepository.getVideoById(conn, videoId);
    }
}

