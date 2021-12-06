package com.Group10.bookstore.Catalogue.Books;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
	
	public List<Book> getBooksByGenre(String genre){
		return repository.findByGenre(genre);
	}
	
	public List<Book> getBooksByTopSellers() {
		return repository.findTop10ByOrderBySalesCNTDesc();
	}
	
	public List<Book> getBooksByRating() {
		return repository.findTop10ByOrderByRatingCNTDesc();
		
	}
	
	public Book getBookByIsbn(String Isbn) {
		return repository.findByIsbn(Isbn);
	}
	
	public List<Book> getBooksByAuthor(String author){
		return repository.findByAuthor(author);
	}
	
	
	public Book saveBook(Book book) {
		return repository.save(book);	
	}
	
	
	public String createBooks() {
		repository.saveAll(Arrays.asList(new Book("1781974710027", "Dave Pollier", "The First 90 Days", 25.99, "Aege Akutami", "Comedy", 2019, 30000000, 5)
				, new Book("2781974710027", "Stephen Guru", "That Will Never Work", 24.99, "Bege Akutami", "Comedy", 2019, 70000000, 4)
				, new Book("3781974710027", "Peter Morgan", "Rich Dad, Poor Dad", 27.99, "Cege Akutami", "Comedy", 2019, 20000000, 3)
				, new Book("4781974710027", "Alice Kelluy", "Loopholes of the rich", 22.99, "Dege Akutami", "Fantasy", 2019, 60000000, 5)
				, new Book("5781974710027", "Josh Truman", "The millionaire next door", 25.99, "Eege Akutami", "Fantasy", 2019, 90000000, 4)
				, new Book("6781974710027", "Adam Haven", "Seen at the right time", 26.99, "Eege Akutami", "Fantasy", 2019, 50000000, 1)));
		return "Books are created";
	}



}
