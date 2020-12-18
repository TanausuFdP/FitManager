package es.ulpgc.fitmanager.controller.exceptions;

public class NonMatchingPasswordException extends RuntimeException {
        public NonMatchingPasswordException (String message) { super(message); }
}