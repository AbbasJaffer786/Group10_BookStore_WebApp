package com.Group10.bookstore.Catalogue.Authors;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.util.Date;

@Entity(name="Authors")
//@IdClass(AuthorKey.class)
public class Author {

	@Id
    private int authorID;
	private String firstName;
    private String lastName;
    private String bio;
    private String publisher;
    private Date dateOfBirth;
    
    public Author() {
    	
    }
    
    public Author(String firstName, String lastName, String bio, String publisher, Date dateOfBirth) {
    	this.firstName = firstName;
    	this.lastName = lastName;
    	this.bio = bio;
    	this.publisher = publisher;
    	this.dateOfBirth = dateOfBirth;
    }
    
    public String getFirstName() {return firstName;}
    
    public void setFirstName(String firstName) {this.firstName = firstName;}
    
    public String getLastName() {return lastName;}
    
    public void setLastName(String lastName) {this.lastName = lastName;}
    
    public String getBio() {return bio;}
    
    public void setBio(String bio) {this.bio = bio;}
    
    public String getPublisher() {return publisher;}
    
    public void setPublisher(String publisher) {this.publisher = publisher;}

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
