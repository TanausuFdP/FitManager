package es.ulpgc.fitmanager.controller.exceptions;

public class VideoNotFoundException extends RuntimeException {
    public VideoNotFoundException(String message) { super(message); }
}