package com.Group10.bookstore.Catalogue.BookReviews;

import java.io.Serializable;
import java.util.Objects;

public class BookReviewKey implements Serializable {

    private String reviewISBN;
    private String reviewer;

    public BookReviewKey() {
    }

    public BookReviewKey(String reviewISBN, String reviewer) {
        this.reviewISBN = reviewISBN;
        this.reviewer = reviewer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookReviewKey reviewKey = (BookReviewKey) o;
        return reviewISBN.equals(reviewKey.reviewISBN) &&
                reviewer.equals(reviewKey.reviewer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reviewISBN, reviewer);
    }
}