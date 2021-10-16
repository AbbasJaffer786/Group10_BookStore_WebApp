package com.Group10.bookstore.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZonedDateTime;

//ControllerAdvice tag indicates that this handler class will handle multiple exceptions
@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = {InvalidBookRatingException.class, DuplicateBookReviewException.class})
    public ResponseEntity<Object> handleApiRequestException(InvalidBookRatingException e){
        ApiException apiException = new ApiException(e.getMessage(), HttpStatus.BAD_REQUEST, ZonedDateTime.now());

        return new ResponseEntity<>(apiException, HttpStatus.BAD_REQUEST);
    }
}
