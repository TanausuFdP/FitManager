package es.ulpgc.fitmanager.controller.action.video;

import es.ulpgc.fitmanager.model.VideoCategory;
import es.ulpgc.fitmanager.view.repository.VideoRepository;

import java.sql.Connection;

public class GetVideoCategoryByNameAction {
    public GetVideoCategoryByNameAction() {
        videoRepository = new VideoRepository();
    }
    
    private final VideoRepository videoRepository;
    
    public VideoCategory execute(Connection conn, String name){
        return videoRepository.getVideoCategoryByName(conn, name);
    }
}
