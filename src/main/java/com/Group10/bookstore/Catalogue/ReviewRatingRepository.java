package com.Group10.bookstore.Catalogue;

import com.Group10.bookstore.BookReview;
import com.Group10.bookstore.BookReviewKey;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface ReviewRatingRepository extends CrudRepository<BookReview, BookReviewKey> {

    //@Query annotation indicates the query to run for the following abstract method...
    @Query("select r from BookReviews r where r.reviewISBN = :reviewISBN")
    List<BookReview> findAllByreviewISBN(String reviewISBN);

    //List<BookReview> findByreviewISBN(@Param("reviewISBN") String name);

    //@Query annotation indicates the query to run for the following abstract method...
    @Query("select r from BookReviews r where r.reviewer = :reviewer")
    List<BookReview> findAllByreviewer(String reviewer);

    @Query("select r from BookReviews r where r.reviewISBN = :reviewISBN AND r.reviewer = :reviewer")
    BookReview findByISBNUser(String reviewISBN, String reviewer);

    //List<BookReview> findAllByreviewer(@Param("reviewISBN") String name);

}




