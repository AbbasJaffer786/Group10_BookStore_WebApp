package com.Group10.bookstore.Catalogue.Authors;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class AuthorKey implements Serializable{
    private String firstName;
    private String lastName;
    private Date dateOfBirth;

    public AuthorKey() {
    }

    public AuthorKey(String firstName, String lastName, Date dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthorKey authorKey = (AuthorKey) o;
        return firstName.equals(authorKey.firstName) && lastName.equals(authorKey.lastName) && dateOfBirth.equals(dateOfBirth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, dateOfBirth);
    }
}
