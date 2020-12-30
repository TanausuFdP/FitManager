package es.ulpgc.fitmanager.controller.action;

import es.ulpgc.fitmanager.controller.dbcontroller.VideoController;
import es.ulpgc.fitmanager.view.repository.VideoRepository;
import java.sql.Connection;

public class GetVideoCategoryIdByNameAction {

    public GetVideoCategoryIdByNameAction() {
        videoRepository = new VideoRepository();
    }
    
    private final VideoRepository videoRepository;
    
    public Integer execute(Connection conn, String name){
        return videoRepository.getVideoCategoryIdByName(conn, name);
    }
}
