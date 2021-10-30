package com.Group10.bookstore.Catalogue.BookReviews;

import com.Group10.bookstore.Exception.BookReviewMissingException;
import com.Group10.bookstore.Exception.DuplicateBookReviewException;
import com.Group10.bookstore.Exception.InvalidBookRatingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
public class ReviewRatingController {

    @Autowired
    private ReviewRatingService reviewRatingService;
    private ObjectMapper objectMapper;

    @RequestMapping("/catalogue/roulette/review")
    public List<BookReview> getReviewArchive() {
        return reviewRatingService.getReviewArchive();
    }

/*
    @RequestMapping(value = "/catalogue/{reviewISBN}/reviewAll")
    public Map<BookReview, Double> searchReviewISBN(@PathVariable String reviewISBN){
        return reviewRatingService.searchReviewISBN(reviewISBN);
    }
*/


    @RequestMapping("/catalogue/{reviewISBN}/reviewAll")
    public List<BookReview> searchReviewISBN(@PathVariable String reviewISBN){
        return reviewRatingService.searchReviewISBN(reviewISBN);
    }

    @RequestMapping("/catalogue/{reviewISBN}/reviewAll/Asc")
    public List<BookReview> searchReviewISBNAsc(@PathVariable String reviewISBN){
        return reviewRatingService.searchReviewISBNAsc(reviewISBN);
    }

    @RequestMapping("/catalogue/{reviewISBN}/reviewAll/Desc")
    public List<BookReview> searchReviewISBNDesc(@PathVariable String reviewISBN){
        return reviewRatingService.searchReviewISBNDesc(reviewISBN);
    }

    @RequestMapping("/catalogue/{reviewUser}")
    public List<BookReview> searchReviewUser(@PathVariable String reviewUser){
        return reviewRatingService.searchReviewUser(reviewUser);
    }

    @RequestMapping("/catalogue/{reviewISBN}/{reviewUser}")
    public BookReview searchReviewISBNUser(@PathVariable("reviewISBN") String reviewISBN, @PathVariable("reviewUser") String reviewUser)
    {
        return reviewRatingService.searchReviewISBNUser(reviewISBN, reviewUser);
    }

    //You assume the front end has a button or form that users fill and that he front end takes those user inputs and formats it appropriately before sending it via the request package.
    @RequestMapping(method = RequestMethod.POST, value = "/catalogue/{reviewISBN}/{reviewUser}")
    public void addBookReview(@RequestBody BookReview newReview) throws InvalidBookRatingException, DuplicateBookReviewException, BookReviewMissingException {

        String reviewISBN = newReview.getReviewISBN();
        String reviewUser = newReview.getReviewer();

        if (newReview.getBookRating() < 0 || newReview.getBookRating() > 5)
            throw new InvalidBookRatingException("Book Rating " + newReview.getBookRating() + " is out of acceptable bounds");
        //if (reviewRatingService.searchReviewISBNUser(reviewISBN, reviewUser)
        try {
            if ((reviewRatingService.searchReviewISBNUser(reviewISBN, reviewUser)).getReviewISBN().equals(newReview.getReviewISBN()) && (reviewRatingService.searchReviewISBNUser(reviewISBN, reviewUser)).getReviewer().equals(newReview.getReviewer()))
                throw new DuplicateBookReviewException("Cannot add this review it already exists, please use update instead");
            //throw new InvalidBookRatingException("Cannot add this review it already exists, please use update instead");
        }
        catch (NullPointerException e) {

        }

        reviewRatingService.addReview(reviewISBN, newReview);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/catalogue/{reviewISBN}/{reviewUser}")
    public void updateBookReview(@RequestBody BookReview newReview, @PathVariable String reviewISBN){
        reviewRatingService.updateReview(reviewISBN, newReview);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/catalogue/{reviewISBN}")
    public void deleteBookReview(@RequestBody BookReview newReview, @PathVariable String reviewISBN){
        reviewRatingService.deleteReview(reviewISBN, newReview);
    }
}
