package es.ulpgc.fitmanager.controller.exceptions;

public class VideoAlreadyExistsException extends RuntimeException {
    public VideoAlreadyExistsException(String message) { super(message); }
}
