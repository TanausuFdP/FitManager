package es.ulpgc.fitmanager.view.repository;

import es.ulpgc.fitmanager.controller.exceptions.VideoListNotFoundException;
import es.ulpgc.fitmanager.controller.exceptions.VideoNotFoundException;
import es.ulpgc.fitmanager.model.Video;
import es.ulpgc.fitmanager.model.VideoList;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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

    public VideoList getVideoListById (Connection conn, Integer videoListId) {
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

    private VideoList getVideoList(ResultSet resultSet) throws SQLException {
        return VideoList.builder()
                .id(resultSet.getInt("id"))
                .title(resultSet.getString("title"))
                .build();
    }

    public void insertVideoList (Connection conn, VideoList videoList) {
        String sql = "INSERT INTO VideoList (title) values (?)";
        try (PreparedStatement preparedStatement = conn.prepareStatement(sql)){
            preparedStatement.setString(1,videoList.getTitle());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            log.error(ex.getLocalizedMessage());
        }
    }
}
