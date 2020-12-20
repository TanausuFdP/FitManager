package es.ulpgc.fitmanager.controller.dbcontroller;

import es.ulpgc.fitmanager.controller.action.*;
import es.ulpgc.fitmanager.controller.exceptions.VideoAlreadyExistsException;
import es.ulpgc.fitmanager.controller.exceptions.VideoListAlreadyExistsException;
import es.ulpgc.fitmanager.controller.exceptions.VideoListNotFoundException;
import es.ulpgc.fitmanager.controller.exceptions.VideoNotFoundException;
import es.ulpgc.fitmanager.model.Video;
import es.ulpgc.fitmanager.model.VideoList;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;

@Slf4j
public class VideoController extends Controller {
    public VideoController(){
        getVideoByIdAction = new GetVideoByIdAction();
        insertVideoAction = new InsertVideoAction();
        getVideoListByIdAction = new GetVideoListByIdAction();
        getVideoListByTitleAction = new GetVideoListByTitleAction();
        insertVideoListAction = new InsertVideoListAction();
    }

    private final GetVideoByIdAction getVideoByIdAction;

    private final InsertVideoAction insertVideoAction;

    private final GetVideoListByIdAction getVideoListByIdAction;

    private final GetVideoListByTitleAction getVideoListByTitleAction;

    private final InsertVideoListAction insertVideoListAction;


    public Video getVideoById(Integer videoId){
        Connection conn = connectToDB();
        try{
            return getVideoByIdAction.execute(conn, videoId);
        } catch (VideoNotFoundException ex) {
            log.error(ex.getLocalizedMessage());
            return null;
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
