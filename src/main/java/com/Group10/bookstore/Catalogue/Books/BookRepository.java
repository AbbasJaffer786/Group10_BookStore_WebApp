package com.Group10.bookstore.Catalogue.Books;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{
	Book findByIsbn(String isbn);
	List<Book> findByAuthor(String Author);
	List<Book> findByGenre(String genre);
	List<Book> findTop10ByOrderBySalesCNTDesc();
	List<Book> findTop10ByOrderByRatingCNTDesc();

}
