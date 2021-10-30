package com.Group10.bookstore.Catalogue.Books;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
	
	@Autowired
	private BookRepository repository;
	
	/*
	public List<Book> getBooksByTopSellers() {
		List<Book> topSellers = repository.findAll();
		Collections.sort(topSellers, Collections.reverseOrder());
		return topSellers;
	}
	*/
	
	public List<Book> getBooksByTopSellers() {
		return repository.findTop10ByOrderBySalesCNTDesc();
	}
	
	public Book getBookByIsbn(String Isbn) {
		return repository.findByIsbn(Isbn);
	}
	
	public List<Book> getBooksByAuthor(Integer authorID){
		return repository.findByAuthor(authorID);
	}
	
	public List<Book> getBooksByGenre(String genre){
		return repository.findByGenre(genre);
	}
	
	public Book saveBook(Book book) {
		return repository.save(book);	
	}
	
	//public String createBooks() {
		
	//}
}
