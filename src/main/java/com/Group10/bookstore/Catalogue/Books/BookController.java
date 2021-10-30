package com.Group10.bookstore.Catalogue.Books;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
	
	@Autowired
	private BookService service;
	
	@GetMapping("/bulkCreate")
	public String bulkCreate() {
		return service.createBooks();
	}
	
	@GetMapping("/retrieveBooksByTopSellers")
	public List<Book> retrieveBooksByTopSellers() {
		return service.getBooksByTopSellers();
	}
	
	@GetMapping("/retrieveBookByIsbn/{isbn}")
	public Book retrieveBookByIsbn(@PathVariable String isbn) {
		return service.getBookByIsbn(isbn);
	}
	
	@GetMapping("/retrieveBooksByAuthor/{authorID}")
	public List<Book> retrieveBooksByAuthor(@PathVariable Integer authorID){
		return service.getBooksByAuthor(authorID);
	}
	
	@GetMapping("/retrieveBooksByGenre/{genre}")
	public List<Book> retrieveBooksByGenre(@PathVariable String genre){
		return service.getBooksByGenre(genre);
	}
	
	@PostMapping(path = "/createBook", consumes = MediaType.APPLICATION_JSON_VALUE, 
	        produces = MediaType.APPLICATION_JSON_VALUE)
	public Book createBook(@RequestBody Book book) {
		return service.saveBook(book);
	}
}
