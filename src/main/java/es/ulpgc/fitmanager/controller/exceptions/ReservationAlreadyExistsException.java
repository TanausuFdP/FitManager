package es.ulpgc.fitmanager.controller.exceptions;

public class ReservationAlreadyExistsException extends RuntimeException {
    public ReservationAlreadyExistsException(String message) { super(message); }
}
