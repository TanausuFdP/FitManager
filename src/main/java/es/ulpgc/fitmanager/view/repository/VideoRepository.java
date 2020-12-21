package es.ulpgc.fitmanager.view.repository;

import es.ulpgc.fitmanager.controller.exceptions.EmptyListException;
import es.ulpgc.fitmanager.controller.exceptions.VideoListNotFoundException;
import es.ulpgc.fitmanager.controller.exceptions.VideoNotFoundException;
import es.ulpgc.fitmanager.model.Video;
import es.ulpgc.fitmanager.model.VideoCategory;
import es.ulpgc.fitmanager.model.VideoList;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class VideoRepository {
    public Video getVideoById(Connection conn, Integer videoId) {
        String sql = "SELECT * FROM Video WHERE id=?";
        try (PreparedStatement statement = conn.prepareStatement(sql)){
            statement.setInt(1,videoId);
            ResultSet resultSet = statement.executeQuery();
            return getVideo(resultSet);
        } catch (SQLException ex) {
            throw new VideoNotFoundException("No se ha encontrado ningún vídeo con el id " + videoId + ".");
        }
    }

    private Video getVideo(ResultSet resultSet) throws SQLException {
        return Video.builder()
                .id(resultSet.getInt("id"))
                .title(resultSet.getString("title"))
                .length(resultSet.getDouble("length"))
                .url(resultSet.getString("url"))
                .categoryId(resultSet.getInt("categoryId"))
                .videoListId(resultSet.getInt("videoListId"))
                .build();
    }

    public Video getVideoByUrl(Connection conn, String videoUrl) {
        String sql = "SELECT * FROM Video WHERE url=?";
        try (PreparedStatement statement = conn.prepareStatement(sql)){
            statement.setString(1,videoUrl);
            ResultSet resultSet = statement.executeQuery();
            return getVideo(resultSet);
        } catch (SQLException ex) {
            throw new VideoNotFoundException("No se ha encontrado ningún vídeo con la url "+ videoUrl + ".");
        }
    }

    public List<Video> getAllVideos(Connection conn) {
        String sql = "SELECT * FROM Video";
        List<Video>videos = new ArrayList<>();
        try (PreparedStatement statement = conn.prepareStatement(sql)){
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()) videos.add(getVideo(resultSet));
            if (videos.isEmpty()) throw new EmptyListException("No se han encontrado vídeos");
            return videos;
        } catch (SQLException ex) {
            log.error(ex.getLocalizedMessage());
            return new ArrayList<>();
        }
    }

    public List<Video> getVideosByVideoListId(Connection conn, Integer videoListId){
        String sql = "SELECT * FROM Video WHERE videoListId=?";
        List<Video>videos = new ArrayList<>();
        try (PreparedStatement preparedStatement = conn.prepareStatement(sql)){
            preparedStatement.setInt(1, videoListId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) videos.add(getVideo(resultSet));
            if (videos.isEmpty()) throw new EmptyListException("No se han encontrado categorías");
            return videos;
        } catch (SQLException ex) {
            log.error(ex.getLocalizedMessage());
            return new ArrayList<>();
        }
    }

    public VideoList getVideoListById(Connection conn, Integer videoListId) {
        String sql = "SELECT * FROM VideoList WHERE id=?";
        try (PreparedStatement statement = conn.prepareStatement(sql)){
            statement.setInt(1,videoListId);
            ResultSet resultSet = statement.executeQuery();
            return getVideoList(resultSet);
        } catch (SQLException ex) {
            throw new VideoListNotFoundException("No se ha encontrado ninguna lista de vídeos con el id "
                    + videoListId + ".");
        }
    }

    private VideoList getVideoList(ResultSet resultSet) throws SQLException {
        return VideoList.builder()
                .id(resultSet.getInt("id"))
                .title(resultSet.getString("title"))
                .build();
    }

    public VideoList getVideoListByTitle(Connection conn, String title) {
        String sql = "SELECT * FROM VideoList WHERE title=?";
        try (PreparedStatement statement = conn.prepareStatement(sql)){
            statement.setString(1,title);
            ResultSet resultSet = statement.executeQuery();
            return getVideoList(resultSet);
        } catch (SQLException ex) {
            throw new VideoListNotFoundException("No se ha encontrado ninguna lista de vídeos con el título "
                    + title + ".");
        }
    }

    public List<VideoCategory> getVideoCategories(Connection conn){
        String sql = "SELECT * FROM VideoCategory";
        List<VideoCategory>categories = new ArrayList<>();
        try (PreparedStatement statement = conn.prepareStatement(sql)){
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()) categories.add(getVideoCategory(resultSet));
            if (categories.isEmpty()) throw new EmptyListException("No se han encontrado categorías");
            return categories;
        } catch (SQLException ex) { 
            log.error(ex.getLocalizedMessage());
            return new ArrayList<>();
        }
    }

    private VideoCategory getVideoCategory(ResultSet resultSet) throws SQLException {
        return VideoCategory.builder()
                .id(resultSet.getInt("id"))
                .name(resultSet.getString("name"))
                .build();
    }
    
    public void insertVideo(Connection conn, Video video) {
        String sql = "INSERT INTO Video (title, length, url, categoryId, videoListId)" +
                "values (?,?,?,?,?)";
        try (PreparedStatement preparedStatement = conn.prepareStatement(sql)){
            preparedStatement.setString(1,video.getTitle());
            preparedStatement.setDouble(2,video.getLength());
            preparedStatement.setString(3,video.getUrl());
            preparedStatement.setInt(4,video.getCategoryId());
            preparedStatement.setInt(5,video.getVideoListId());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            log.error(ex.getLocalizedMessage());
        }
    }

    public void insertVideoList(Connection conn, VideoList videoList) {
        String sql = "INSERT INTO VideoList (title) values (?)";
        try (PreparedStatement preparedStatement = conn.prepareStatement(sql)){
            preparedStatement.setString(1,videoList.getTitle());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            log.error(ex.getLocalizedMessage());
        }
    }

    public void deleteVideo (Connection conn, Integer videoId) {
        String sql = "DELETE FROM Video WHERE id=?";
        try (PreparedStatement preparedStatement = conn.prepareStatement(sql)){
            preparedStatement.setInt(1,videoId);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) { log.error(ex.getLocalizedMessage()); }
    }
}
