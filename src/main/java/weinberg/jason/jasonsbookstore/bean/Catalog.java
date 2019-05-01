package weinberg.jason.jasonsbookstore.bean;

import java.io.*;
import java.util.*;
import java.util.stream.*;

import javax.persistence.*;

import weinberg.jason.jasonsbookstore.model.*;

public class Catalog implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "jasonsbookstoreDB")
	private EntityManager entityManager;
	
	public Catalog() {}
	
	public Book findBook(int bookId) {
		Book book = entityManager.find(Book.class, bookId);
		
		return book;
	}
	
	public List<Book> findAllBooks() {
		List<Book> books = entityManager.createQuery("SELECT b FROM Book b", Book.class).getResultList();
		
		return books;
	}
	
	public List<Book> search(String searchQuery, String filterCriteria, String sortOrder) {
		List<Book> books = findAllBooks();
		books = filter(books, searchQuery, filterCriteria);
		books = sort(books, sortOrder);
		
		return books;
	}
	
	private List<Book> filter(List<Book> books, String searchQuery, String filterCriteria) {
		switch(filterCriteria) {
			case "title":
				books = books.stream().filter(b -> b.getTitle().toLowerCase().contains(searchQuery.toLowerCase())).collect(Collectors.toList());
				break;
			case "author":
				books = books.stream().filter(b -> b.getAuthor().toLowerCase().contains(searchQuery.toLowerCase())).collect(Collectors.toList());
				break;
			case "isbn":
				books = books.stream().filter(b -> b.getIsbn().toLowerCase().contains(searchQuery.toLowerCase())).collect(Collectors.toList());
		}
		
		return books;
	}
	
	private List<Book> sort(List<Book> books, String sortOrder) {
		switch(sortOrder) {
			case "asc":
				books = books.stream().sorted((Book b1, Book b2) -> b1.getTitle().compareTo(b2.getTitle())).collect(Collectors.toList());
				break;
			case "desc":
				books = books.stream().sorted((Book b1, Book b2) -> b2.getTitle().compareTo(b1.getTitle())).collect(Collectors.toList());
		}
		
		return books;
	}
}
