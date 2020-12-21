package es.ulpgc.fitmanager.controller.dbcontroller;

import es.ulpgc.fitmanager.controller.action.*;
import es.ulpgc.fitmanager.controller.exceptions.EmptyListException;
import es.ulpgc.fitmanager.controller.exceptions.VideoAlreadyExistsException;
import es.ulpgc.fitmanager.controller.exceptions.VideoListAlreadyExistsException;
import es.ulpgc.fitmanager.controller.exceptions.VideoListNotFoundException;
import es.ulpgc.fitmanager.controller.exceptions.VideoNotFoundException;
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
        getVideoByIdAction = new GetVideoByIdAction();
        insertVideoAction = new InsertVideoAction();
        getVideoListByIdAction = new GetVideoListByIdAction();
        getVideoListByTitleAction = new GetVideoListByTitleAction();
        insertVideoListAction = new InsertVideoListAction();
        getVideoCategoriesAction = new GetVideoCategoriesAction();
        getVideosAction = new GetVideosAction();
        getVideosByVideoListIdAction = new GetVideosByVideoListIdAction();
        deleteVideoAction = new DeleteVideoAction();
        getVideoByURLAction = new GetVideoByURLAction();
    }

    private final GetVideoByIdAction getVideoByIdAction;

    private final InsertVideoAction insertVideoAction;

    private final GetVideoListByIdAction getVideoListByIdAction;

    private final GetVideoListByTitleAction getVideoListByTitleAction;

    private final InsertVideoListAction insertVideoListAction;

    private final GetVideoCategoriesAction getVideoCategoriesAction;
    
    private final GetVideosAction getVideosAction;
    
    private final GetVideosByVideoListIdAction getVideosByVideoListIdAction;
    
    private final DeleteVideoAction deleteVideoAction;
    
    private final GetVideoByURLAction getVideoByURLAction;
    
    public Video getVideoByURL(String videoUrl){
        Connection conn = connectToDB();
        return getVideoByURLAction.execute(conn, videoUrl);
    }
    
    public Video getVideoById(Integer videoId){
        Connection conn = connectToDB();
        try{
            return getVideoByIdAction.execute(conn, videoId);
        } catch (VideoNotFoundException ex) {
            log.error(ex.getLocalizedMessage());
            return null;
        }
    }
    
    public List<Video> getVideos(){
        try{
            Connection conn = connectToDB();
            return getVideosAction.execute(conn);
        }catch(EmptyListException ex){
            log.error(ex.getLocalizedMessage());
            return new ArrayList<>();
        }
    }
    
    public void deleteVideo(Integer videoId){
        Connection conn = connectToDB();
        deleteVideoAction.execute(conn, videoId);
    }
    
    public List<Video> getVideosByVideoListId(Integer videoListId){
        Connection conn = connectToDB();
        return getVideosByVideoListIdAction.execute(conn, videoListId);
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
    
    public Video insertVideo(Video video){
        Connection conn = connectToDB();
        try{
            return insertVideoAction.execute(conn, video);
        } catch (VideoAlreadyExistsException ex) {
            log.error(ex.getLocalizedMessage());
            return null;
        }
    }

    public VideoList getVideoListById(Integer videoListId){
        Connection conn = connectToDB();
        try{
            return getVideoListByIdAction.execute(conn, videoListId);
        } catch (VideoListNotFoundException ex) {
            log.error(ex.getLocalizedMessage());
            return null;
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

    public VideoList insertVideoList(VideoList videoList){
        Connection conn = connectToDB();
        try{
            return insertVideoListAction.execute(conn, videoList);
        } catch (VideoListAlreadyExistsException ex) {
            log.error(ex.getLocalizedMessage());
            return null;
        }
    }
}
