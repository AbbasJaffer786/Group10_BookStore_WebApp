package com.Group10.bookstore.Catalogue.Authors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorController {

	@Autowired
	private AuthorService service;
	
	@PostMapping(path = "/createAuthor", consumes = MediaType.APPLICATION_JSON_VALUE, 
	        produces = MediaType.APPLICATION_JSON_VALUE)
	public Author createAuthor(@RequestBody Author author) {
		return service.saveAuthor(author);
	}
}
