package weinberg.jason.jasonsbookstore.model;

import java.io.*;

import javax.persistence.*;

@Entity
@Table(name = "OrderItems")
public class OrderItem implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn
	private Order order;
	
	@ManyToOne
	@JoinColumn
	private Book book;
	
	private int qty;
	private float itemPrice;
	private float totalPrice;
	
	public OrderItem() {}

	public int getId() {
		return id;
	}

	public Order getOrder() {
		return order;
	}

	public Book getBook() {
		return book;
	}

	public int getQty() {
		return qty;
	}

	public float getItemPrice() {
		return itemPrice;
	}

	public float getTotalPrice() {
		return totalPrice;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public void setItemPrice(float itemPrice) {
		this.itemPrice = itemPrice;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}
}
