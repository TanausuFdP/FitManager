package es.ulpgc.fitmanager.controller;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class VideoPlayController {
    private final JFXPanel jfxPanel;
    private static MediaPlayer oracleVid;
    private final String path;
    private MediaView mediaView;
    
    private final int height;
    private final int width;

    public VideoPlayController(String path, JFXPanel jfxPanel, int height, int width){
        this.path = path;
        this.jfxPanel = jfxPanel;
        this.width = width;
        this.height = height;
        
        Media media = new Media(path);
        oracleVid = new MediaPlayer(media);
        mediaView = new MediaView(oracleVid);
    }

    public MediaPlayer getMediaPlayer() { return oracleVid; }

    public void start(){
        createScene();
    }
    
    private void createScene(){
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                //se añade video al jfxPanel
                mediaView.setFitHeight(height);
                mediaView.setFitWidth(width);
                jfxPanel.setScene(new Scene(new Group(mediaView)));
               
                oracleVid.setVolume(0.5);//volumen
                oracleVid.setCycleCount(MediaPlayer.INDEFINITE);//repite video
                oracleVid.play();//play video
            }
        });
    }
    
    public void play(){
        oracleVid.play();
    }
    
    public void pause(){
        oracleVid.pause();
    }
    
    public void close(){
        oracleVid.stop();
        oracleVid.dispose();
        Thread.currentThread().interrupt();
    }
}
