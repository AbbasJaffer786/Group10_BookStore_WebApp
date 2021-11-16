package com.Group10.bookstore.Catalogue.Authors;

import java.sql.ResultSet;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="author")
public class Author {

	@Id
	private String firstName;
    private String lastName;
    private String bio;
    private String publisher;
    
    public Author() {
    	
    }
    
    public Author(String firstName, String lastName, String bio, String publisher) {
    	this.firstName = firstName;
    	this.lastName = lastName;
    	this.bio = bio;
    	this.publisher = publisher;
    }
    
    public String getFirstName() {return firstName;}
    
    public void setFirstName(String firstName) {this.firstName = firstName;}
    
    public String getLastName() {return lastName;}
    
    public void setLastName(String lastName) {this.lastName = lastName;}
    
    public String getBio() {return bio;}
    
    public void setBio(String bio) {this.bio = bio;}
    
    public String getPublisher() {return publisher;}
    
    public void setPublisher(String publisher) {this.publisher = publisher;}
    
}
