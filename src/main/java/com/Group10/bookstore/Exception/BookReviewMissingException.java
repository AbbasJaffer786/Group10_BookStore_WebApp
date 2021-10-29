package com.Group10.bookstore.Exception;

public class DuplicateBookReviewException extends RuntimeException {

    public DuplicateBookReviewException(String message) {
        super(message);
    }

    public DuplicateBookReviewException(String message, Throwable cause) {
        super(message, cause);
    }
}
