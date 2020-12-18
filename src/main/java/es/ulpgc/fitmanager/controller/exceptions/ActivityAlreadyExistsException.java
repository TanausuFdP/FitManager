package es.ulpgc.fitmanager.controller.exceptions;

public class ActivityAlreadyExistsException extends RuntimeException {
    public ActivityAlreadyExistsException(String message) { super(message); }
}
