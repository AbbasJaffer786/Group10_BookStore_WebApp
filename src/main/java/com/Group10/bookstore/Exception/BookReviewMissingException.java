package com.Group10.bookstore.Exception;

public class BookReviewMissingException extends RuntimeException {

    public BookReviewMissingException(String message) {
        super(message);
    }

    public BookReviewMissingException(String message, Throwable cause) {
        super(message, cause);
    }
}
