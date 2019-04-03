package weinberg.jason.jasonsbookstore.bean;

import java.io.*;
import java.util.*;

import javax.enterprise.context.*;
import javax.persistence.*;

import weinberg.jason.jasonsbookstore.model.*;

@SessionScoped
public class Cart implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "jasonsbookstoreDB")
	private EntityManager entityManager;
	
	private List<OrderItem> items = new ArrayList<OrderItem>();
	
	public Cart() {}
	
	public void addBook(int bookId) {
		items.forEach(i -> {
			if(i.getBook().getId() == bookId) {
				i.setQty(i.getQty() + 1);
				i.setTotalPrice(i.getTotalPrice() + i.getItemPrice());
				return;
			}
		});
		
		Book book = entityManager.find(Book.class, bookId);
		OrderItem item = new OrderItem();
		item.setBook(book);
		item.setQty(1);
		item.setItemPrice(book.getPrice());
		item.setTotalPrice(item.getItemPrice());
		items.add(item);
	}
	
	public void removeBook(int bookId) {
		items.removeIf(i -> i.getBook().getId() == bookId);
	}
	
	public void updateBookQty(int bookId, int qty) {
		if(qty > 0) {
			items.forEach(i -> {
				if(i.getBook().getId() == bookId) {
					i.setQty(qty);
					i.setTotalPrice(i.getItemPrice() * qty);
				}
			});
		} else {
			removeBook(bookId);
		}
	}
	
	public List<OrderItem> getItems() {
		return items;
	}
	
	public void clearItems() {
		items.clear();
	}
}
