package net.javaguides.springboot.backend.exception;

public class BookingException extends RuntimeException {

    public BookingException(String message) {
        super(message);
    }
}
