package com.Group10.bookstore.Exception;

public class InvalidBookRatingException extends RuntimeException{

    public InvalidBookRatingException(String message) {
        super(message);
    }

    public InvalidBookRatingException(String message, Throwable cause) {
        super(message, cause);
    }
}
