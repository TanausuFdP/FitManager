package es.ulpgc.fitmanager.controller.action;

import es.ulpgc.fitmanager.view.repository.VideoRepository;
import java.sql.Connection;

public class DeleteVideoAction {
    
    public DeleteVideoAction() {
        videoRepository = new VideoRepository();
    }

    private final VideoRepository videoRepository;

    public void execute(Connection conn, Integer videoId) {
        videoRepository.deleteVideo(conn, videoId);
    }
}
