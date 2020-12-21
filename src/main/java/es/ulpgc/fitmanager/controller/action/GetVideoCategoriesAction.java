package es.ulpgc.fitmanager.controller.action;

import es.ulpgc.fitmanager.model.VideoCategory;
import es.ulpgc.fitmanager.view.repository.VideoRepository;
import java.sql.Connection;
import java.util.List;


public class GetVideoCategoriesAction {
    private final VideoRepository videoRepository;

    public GetVideoCategoriesAction() {
        videoRepository = new VideoRepository();
    }
    
    public List<VideoCategory> execute(Connection conn){
        return videoRepository.getCategories(conn);
    }
}
