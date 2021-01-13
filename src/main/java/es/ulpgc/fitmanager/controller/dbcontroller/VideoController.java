package es.ulpgc.fitmanager.controller.dbcontroller;

import es.ulpgc.fitmanager.controller.action.video.*;
import es.ulpgc.fitmanager.controller.exceptions.*;
import es.ulpgc.fitmanager.model.Video;
import es.ulpgc.fitmanager.model.VideoCategory;
import es.ulpgc.fitmanager.model.VideoList;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class VideoController extends Controller {
    public VideoController(){
        getAllVideosAction = new GetAllVideosAction();
        getVideosByVideoListIdAction = new GetVideosByVideoListIdAction();
        getVideosByCategoryIdAction = new GetVideosByCategoryIdAction();
        getVideoListByTitleAction = new GetVideoListByTitleAction();
        getVideoListByMonitorIdAction = new GetVideoListByMonitorIdAction();
        getVideoCategoriesAction = new GetVideoCategoriesAction();
        insertVideoAction = new InsertVideoAction();
        deleteVideoAction = new DeleteVideoAction();
    }

    private final GetAllVideosAction getAllVideosAction;

    private final GetVideosByVideoListIdAction getVideosByVideoListIdAction;
    
    private final GetVideosByCategoryIdAction getVideosByCategoryIdAction;

    private final GetVideoListByTitleAction getVideoListByTitleAction;

    private final GetVideoListByMonitorIdAction getVideoListByMonitorIdAction;

    private final GetVideoCategoriesAction getVideoCategoriesAction;

    private final InsertVideoAction insertVideoAction;

    private final DeleteVideoAction deleteVideoAction;
    
    public List<Video> getAllVideos(){
        try{
            Connection conn = connectToDB();
            return getAllVideosAction.execute(conn);
        }catch(EmptyListException ex){
            log.error(ex.getLocalizedMessage());
            return new ArrayList<>();
        }
    }
    
    public List<Video> getVideosByVideoListId(Integer videoListId){
        try{
            if (videoListId.equals(0))
                throw new VideoListNotFoundException("No se ha encontrado ninguna lista" +
                    " de vídeos con el id 0.");
            Connection conn = connectToDB();
            return getVideosByVideoListIdAction.execute(conn, videoListId);

        }catch(EmptyListException|VideoListNotFoundException ex){
            log.error(ex.getLocalizedMessage());
            return new ArrayList<>();
        }
    }

    public List<Video> getVideosByCategoryId(Integer categoryId){
        try{
            Connection conn = connectToDB();
            return getVideosByCategoryIdAction.execute(conn, categoryId);
        }catch (VideoNotFoundException ex){
            log.error(ex.getLocalizedMessage());
            return new ArrayList<>();
        }
        
    }

    public VideoList getVideoListByTitle(String title){
        Connection conn = connectToDB();
        try{
            return getVideoListByTitleAction.execute(conn, title);
        } catch (VideoListNotFoundException ex) {
            log.error(ex.getLocalizedMessage());
            return null;
        }
    }

    public VideoList getVideoListByMonitorId(Integer monitorId){
        try{
            Connection conn = connectToDB();
            return getVideoListByMonitorIdAction.execute(conn,monitorId);
        } catch (UserNotFoundException ex) {
            log.error(ex.getLocalizedMessage());
            return null;
        }
    }

    public List<VideoCategory> getVideoCategories(){
        Connection conn = connectToDB();
        try{
            return getVideoCategoriesAction.execute(conn);

        }catch(EmptyListException ex){
            log.error(ex.getLocalizedMessage());
            return new ArrayList<>();
        }
    }
    
    public void insertVideo(Video video){
        Connection conn = connectToDB();
        try{
            insertVideoAction.execute(conn, video);
        } catch (VideoAlreadyExistsException ex) {
            log.error(ex.getLocalizedMessage());
        }
    }

    public void deleteVideo(Integer videoId){
        Connection conn = connectToDB();
        deleteVideoAction.execute(conn, videoId);
    }
}