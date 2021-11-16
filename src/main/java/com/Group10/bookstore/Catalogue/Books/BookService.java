package com.Group10.bookstore.Catalogue.Books;
import java.util.Arrays;
import java.util.Collections;
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
	
	public List<Book> getBooksByAuthor(String author){
		return repository.findByAuthor(author);
	}
	
	public List<Book> getBooksByGenre(String genre){
		return repository.findByGenre(genre);
	}
	
	public Book saveBook(Book book) {
		return repository.save(book);	
	}
	
	public String createBooks() {
		repository.saveAll(Arrays.asList(new Book("1781974710027", "Jujutsu Kaisen", "Demon Man Eats Fingers", 29.99, "Aege Akutami", "Fantasy", 2019, 30000000)
				, new Book("2781974710027", "Jujutsu Kaisen", "Demon Man Eats Fingers", 29.99, "Bege Akutami", "Fantasy", 2019, 70000000)
				, new Book("3781974710027", "Jujutsu Kaisen", "Demon Man Eats Fingers", 29.99, "Cege Akutami", "Fantasy", 2019, 20000000)
				, new Book("4781974710027", "Jujutsu Kaisen", "Demon Man Eats Fingers", 29.99, "Dege Akutami", "Fantasy", 2019, 60000000)
				, new Book("5781974710027", "Jujutsu Kaisen", "Demon Man Eats Fingers", 29.99, "Eege Akutami", "Fantasy", 2019, 90000000)
				, new Book("6781974710027", "Author Copy", "Demon Man Eats Fingers", 29.99, "Eege Akutami", "Fantasy", 2019, 50000000)));
		return "Books are created";
	}
}
