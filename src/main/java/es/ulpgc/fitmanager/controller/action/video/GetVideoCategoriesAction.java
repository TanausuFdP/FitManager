package es.ulpgc.fitmanager.controller.action.video;

import es.ulpgc.fitmanager.model.VideoCategory;
import es.ulpgc.fitmanager.view.repository.VideoRepository;
import java.sql.Connection;
import java.util.List;

public class GetVideoCategoriesAction {
    public GetVideoCategoriesAction() { videoRepository = new VideoRepository(); }

    private final VideoRepository videoRepository;

    public List<VideoCategory> execute(Connection conn){
        return videoRepository.getVideoCategories(conn);
    }
}