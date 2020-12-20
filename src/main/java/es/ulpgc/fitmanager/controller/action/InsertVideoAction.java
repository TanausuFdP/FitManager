package es.ulpgc.fitmanager.controller.action;

import es.ulpgc.fitmanager.controller.exceptions.VideoAlreadyExistsException;
import es.ulpgc.fitmanager.controller.exceptions.VideoNotFoundException;
import es.ulpgc.fitmanager.model.Video;
import es.ulpgc.fitmanager.view.repository.VideoRepository;

import java.sql.Connection;

public class InsertVideoAction {
    public InsertVideoAction() {
        videoRepository = new VideoRepository();
    }

    private final VideoRepository videoRepository;

    public Video execute(Connection conn, Video video) {
        try {
            videoRepository.getVideoById(conn, video.getId());
            throw new VideoAlreadyExistsException("Ya existe un vídeo con el id " + video.getId());
        } catch (VideoNotFoundException ex) {
            videoRepository.insertVideo(conn, video);
            return videoRepository.getVideoById(conn, video.getId());
        }
    }
}
