package com.Group10.bookstore.Catalogue.Books;

import java.sql.ResultSet;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import java.util.List;


@Entity
@Table(name = "book")
public class Book {

	@Id
    private String isbn;
    private String name;
    private String description;
    private Double price;
    private String author;
    private String genre;
    private Integer publishYR;
    private Integer salesCNT;
    private Integer ratingCNT;
    /*
     * No argument constructor.
     */
    public Book(){

    }

    /*
     * Book constructor with standard parameters/arguments
     */



    public Book(String isbn, String name, String description, Double price, String author, String genre, Integer publishYR, Integer salesCNT, Integer ratingCNT) {
        this.isbn = isbn;
        this.name = name;
        this.description = description;
        this.price = price;
        this.author = author;
        this.genre = genre;
        this.publishYR = publishYR;
        this.salesCNT = salesCNT;
        this.ratingCNT = ratingCNT;

    }

    public String getIsbn() { return isbn; }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Integer getPublishYR() {
        return publishYR;
    }

    public void setPublishYR(Integer publishYR) {
        this.publishYR = publishYR;
    }

    public Integer getSalesCNT() {
        return salesCNT;
    }

    public void setSalesCNT(Integer salesCNT) {
        this.salesCNT = salesCNT;
    }

	public Integer getRating() {
		return ratingCNT;
	}

	public void setRatingCNT(Integer ratingCNT) {
		this.ratingCNT = ratingCNT;
	}

}
