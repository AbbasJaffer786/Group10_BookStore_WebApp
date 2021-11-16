package com.Group10.bookstore;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {
	
	@Autowired
	private AuthorRepository repository;
	
	public Author saveAuthor(Author author) {
		return repository.save(author);	
	}
}
