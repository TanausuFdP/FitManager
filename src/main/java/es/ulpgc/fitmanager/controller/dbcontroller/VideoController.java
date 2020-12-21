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
        getVideoByURLAction = new GetVideoByUrlAction();
        getAllVideosAction = new GetAllVideosAction();
        getVideosByVideoListIdAction = new GetVideosByVideoListIdAction();
        getVideoListByIdAction = new GetVideoListByIdAction();
        getVideoListByTitleAction = new GetVideoListByTitleAction();
        getVideoCategoriesAction = new GetVideoCategoriesAction();
        insertVideoAction = new InsertVideoAction();
        insertVideoListAction = new InsertVideoListAction();
        deleteVideoAction = new DeleteVideoAction();
    }

    private final GetVideoByIdAction getVideoByIdAction;

    private final GetVideoByUrlAction getVideoByURLAction;

    private final GetAllVideosAction getAllVideosAction;

    private final GetVideosByVideoListIdAction getVideosByVideoListIdAction;

    private final GetVideoListByIdAction getVideoListByIdAction;

    private final GetVideoListByTitleAction getVideoListByTitleAction;

    private final GetVideoCategoriesAction getVideoCategoriesAction;

    private final InsertVideoAction insertVideoAction;

    private final InsertVideoListAction insertVideoListAction;

    private final DeleteVideoAction deleteVideoAction;

    public Video getVideoById(Integer videoId){
        Connection conn = connectToDB();
        try{
            return getVideoByIdAction.execute(conn, videoId);
        } catch (VideoNotFoundException ex) {
            log.error(ex.getLocalizedMessage());
            return null;
        }
    }

    public Video getVideoByURL(String videoUrl){
        Connection conn = connectToDB();
        try{
            return getVideoByURLAction.execute(conn, videoUrl);
        } catch (VideoNotFoundException ex) {
            log.error(ex.getLocalizedMessage());
            return null;
        }
    }
    
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
        Connection conn = connectToDB();
        return getVideosByVideoListIdAction.execute(conn, videoListId);
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

    public VideoList insertVideoList(VideoList videoList){
        Connection conn = connectToDB();
        try{
            return insertVideoListAction.execute(conn, videoList);
        } catch (VideoListAlreadyExistsException ex) {
            log.error(ex.getLocalizedMessage());
            return null;
        }
    }

    public void deleteVideo(Integer videoId){
        Connection conn = connectToDB();
        deleteVideoAction.execute(conn, videoId);
    }
}
