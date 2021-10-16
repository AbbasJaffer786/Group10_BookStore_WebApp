package com.Group10.bookstore.Catalogue;

import com.Group10.bookstore.BookReview;
import com.Group10.bookstore.Exception.DuplicateBookReviewException;
import com.Group10.bookstore.Exception.InvalidBookRatingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;


@RestController
public class ReviewRating {

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


    @RequestMapping("/catalogue/{reviewUser}")
    public List<BookReview> searchReviewUser(@PathVariable String reviewUser){
        return reviewRatingService.searchReviewUser(reviewUser);
    }

    @RequestMapping("/catalogue/{reviewISBN}/{reviewUser}")
    public List<BookReview> searchReviewISBNUser(@PathVariable("reviewISBN") String reviewISBN, @PathVariable("reviewUser") String reviewUser)
    {
        return reviewRatingService.searchReviewISBNUser(reviewISBN, reviewUser);
    }

    //You assume the front end has a button or form that users fill and that he front end takes those user inputs and formats it appropriately before sending it via the request package.
    @RequestMapping(method = RequestMethod.POST, value = "/catalogue/{reviewISBN}/{reviewUser}")
    public void addBookReview(@RequestBody BookReview newReview, @PathVariable String reviewISBN, @PathVariable("reviewUser") String reviewUser) throws InvalidBookRatingException, DuplicateBookReviewException {

        if (newReview.getBookRating() < 0 || newReview.getBookRating() > 5)
            throw new InvalidBookRatingException("Book Rating " + newReview.getBookRating() + " is out of acceptable bounds");
        //if ((reviewRatingService.searchReviewISBNUser(reviewISBN, reviewUser) == newReview))
            //throw new InvalidBookRatingException("This review already exists");
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
