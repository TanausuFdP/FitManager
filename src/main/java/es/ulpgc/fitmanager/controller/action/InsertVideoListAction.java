package es.ulpgc.fitmanager.controller.action;

import es.ulpgc.fitmanager.controller.exceptions.VideoListAlreadyExistsException;
import es.ulpgc.fitmanager.controller.exceptions.VideoListNotFoundException;
import es.ulpgc.fitmanager.model.VideoList;
import es.ulpgc.fitmanager.view.repository.VideoRepository;

import java.sql.Connection;

public class InsertVideoListAction {
    public InsertVideoListAction() {
        videoRepository = new VideoRepository();
    }

    private final VideoRepository videoRepository;

    public VideoList execute(Connection conn, VideoList videoList) {
        try {
            videoRepository.getVideoListByTitle(conn, videoList.getTitle());
            throw new VideoListAlreadyExistsException("Ya existe una lista de vídeos con el título "
                    + videoList.getTitle());
        } catch (VideoListNotFoundException ex) {
            videoRepository.insertVideoList(conn, videoList);
            return videoRepository.getVideoListByTitle(conn, videoList.getTitle());

        }
    }
}
