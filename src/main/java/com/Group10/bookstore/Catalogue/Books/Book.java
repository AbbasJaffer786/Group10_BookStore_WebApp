package com.Group10.bookstore.Catalogue.Books;

import com.Group10.bookstore.Catalogue.Authors.Author;

import java.sql.ResultSet;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import java.util.List;


@Entity(name = "Books")

public class Book {

	@Id
    private String isbn;
    private String name;
    private String description;
    private Double price;
    private int authorID;
    private String genre;
    private Integer publishYR;
    private Integer salesCNT;

    /*
     * No argument constructor.
     */
    public Book(){

    }

    /*
     * Book constructor with standard parameters/arguments
     */



    public Book(String isbn, String name, String description, Double price, Integer authorID, String genre, Integer publishYR, Integer salesCNT) {
        this.isbn = isbn;
        this.name = name;
        this.description = description;
        this.price = price;
        this.authorID = authorID;
        this.genre = genre;
        this.publishYR = publishYR;
        this.salesCNT = salesCNT;
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

    public int getAuthorID() {
        return authorID;
    }

    public void setAuthorID(int authorID) {
        this.authorID = authorID;
    }
}
