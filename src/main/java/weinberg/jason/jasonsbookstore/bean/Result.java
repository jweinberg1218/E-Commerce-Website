package weinberg.jason.jasonsbookstore.bean;

import java.io.*;
import java.util.*;

import weinberg.jason.jasonsbookstore.model.*;

public class Result implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Book book;
	private List<Book> books;
	private Order order;
	private List<Order> orders;
	private OrderItem orderItem;
	private List<OrderItem> orderItems;
	
	public Book getBook() {
		return book;
	}
	
	public void setBook(Book book) {
		this.book = book;
	}
	
	public List<Book> getBooks() {
		return books;
	}
	
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
	public Order getOrder() {
		return order;
	}
	
	public void setOrder(Order order) {
		this.order = order;
	}
	
	public List<Order> getOrders() {
		return orders;
	}
	
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public OrderItem getOrderItem() {
		return orderItem;
	}

	public void setOrderItem(OrderItem orderItem) {
		this.orderItem = orderItem;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
}
