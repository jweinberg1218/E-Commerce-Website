package weinberg.jason.jasonsbookstore.bean;

import java.io.*;
import java.util.*;

import javax.persistence.*;

import weinberg.jason.jasonsbookstore.model.*;

public class Catalog implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "jasonsbookstoreDB")
	private EntityManager entityManager;
	
	public Catalog() {}
	
	public Book find(int bookId) {
		Book book = entityManager.find(Book.class, bookId);
		
		return book;
	}
	
	public List<Book> findAll() {
		List<Book> books = entityManager.createQuery("SELECT b FROM Book b", Book.class).getResultList();
		
		return books;
	}
	
	public List<Book> search(String searchQuery, String filterCriteria, String sortOrder) {
		List<Book> books = entityManager.createQuery("SELECT b FROM Book b", Book.class).getResultList();
		filter(books, searchQuery, filterCriteria);
		sort(books, sortOrder);
		
		return books;
	}
	
	private void filter(List<Book> books, String searchQuery, String filterCriteria) {
		switch(filterCriteria) {
			case "author":
				books.stream().filter(b -> b.getAuthorLName().toLowerCase().contains(searchQuery));
				break;
			case "volumeTitle":
				books.stream().filter(b -> b.getTitle().toLowerCase().contains(searchQuery));
				break;
			case "isbn":
				books.stream().filter(b -> b.getIsbn().toLowerCase().contains(searchQuery));
		}
	}
	
	private void sort(List<Book> books, String sortOrder) {
		switch(sortOrder) {
			case "asc":
				books.sort((Book b1, Book b2) -> b1.getTitle().compareTo(b2.getTitle()));
				break;
			case "desc":
				books.sort((Book b1, Book b2) -> b2.getTitle().compareTo(b1.getTitle()));
		}
	}
}
