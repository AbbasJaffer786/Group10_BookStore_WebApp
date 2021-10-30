package com.Group10.bookstore.Catalogue.BookReviews;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Transient;
import java.io.Serializable;
import java.time.ZonedDateTime;

@Entity(name = "BookReviews")
@IdClass(BookReviewKey.class)
public class BookReview implements Serializable {

    @Id
    private String reviewISBN;

    @Id
    private String reviewer;

    private String bookReview;
    private ZonedDateTime reviewTimeStamp;
    private int bookRating;
    private ZonedDateTime ratingTimeStamp;
    @Transient
    private Double avgBookRating;


    /*
     * No argument constructor.
     */
    public BookReview(){

    }



    public BookReview(String reviewISBN, String reviewer, String bookReview, ZonedDateTime reviewTimeStamp, int bookRating, ZonedDateTime ratingTimeStamp ){
        this.reviewISBN = reviewISBN;
        this.reviewer = reviewer;
        this.bookReview = bookReview;
        this.reviewTimeStamp = reviewTimeStamp;
        this.bookRating = bookRating;
        this.ratingTimeStamp = ratingTimeStamp;
    }

    public String getBookReview() {
        return bookReview;
    }

    public void setBookReview(String bookReview) {
        this.bookReview = bookReview;
    }

    public int getBookRating() {
        return bookRating;
    }

    public void setBookRating(int bookRating) {
        this.bookRating = bookRating;
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }

    public String getReviewISBN() {
        return reviewISBN;
    }

    public void setReviewISBN(String reviewISBN) {
        this.reviewISBN = reviewISBN;
    }

    public ZonedDateTime getReviewTimeStamp() { return reviewTimeStamp; }

    public void setReviewTimeStamp(ZonedDateTime reviewTimeStamp) { this.reviewTimeStamp = reviewTimeStamp; }

    public ZonedDateTime getRatingTimeStamp() { return ratingTimeStamp; }

    public void setRatingTimeStamp(ZonedDateTime ratingTimeStamp) { this.ratingTimeStamp = ratingTimeStamp; }

    public Double getAvgBookRating() {
        return avgBookRating;
    }
/*
    public void setAvgBookRating(Double avgBookRating) {
        this.avgBookRating = avgBookRating;
    }
*/
    public void setAvgBookRating(Double avgRating) {
        this.avgBookRating = avgRating;
    }

    public boolean equals(BookReview testBook)
    {
        if (this.reviewISBN == testBook.getReviewISBN() && this.reviewer == testBook.reviewer)
            return true;
        else
            return false;
    }
}


