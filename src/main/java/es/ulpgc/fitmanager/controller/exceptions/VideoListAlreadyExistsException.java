package es.ulpgc.fitmanager.controller.exceptions;

public class VideoListAlreadyExistsException extends RuntimeException {
    public VideoListAlreadyExistsException(String message) { super(message); }
}
