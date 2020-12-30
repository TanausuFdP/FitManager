package es.ulpgc.fitmanager.controller.action.video;

import es.ulpgc.fitmanager.model.VideoList;
import es.ulpgc.fitmanager.view.repository.VideoRepository;

import java.sql.Connection;

public class GetVideoListByIdAction {
    public GetVideoListByIdAction() {
        videoRepository = new VideoRepository();
    }

    private final VideoRepository videoRepository;

    public VideoList execute(Connection conn, Integer videoListId) {
        return videoRepository.getVideoListById(conn, videoListId);
    }
}
