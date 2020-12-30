package es.ulpgc.fitmanager.controller.action.video;

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
            videoRepository.getVideoByUrl(conn, video.getUrl());
            throw new VideoAlreadyExistsException("Ya existe un vídeo con la url " + video.getUrl());
        } catch (VideoNotFoundException ex) {
            videoRepository.insertVideo(conn, video);
            return videoRepository.getVideoByUrl(conn, video.getUrl());
        }
    }
}
