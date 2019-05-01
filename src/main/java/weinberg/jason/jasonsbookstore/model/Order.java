package weinberg.jason.jasonsbookstore.model;

import java.io.*;
import java.util.*;

import javax.persistence.*;

@Entity
@Table(name = "Orders")
public class Order implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn
	private User user;
	
	@OneToMany(mappedBy = "order", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<OrderItem> orderItems;
	
	private float totalPrice;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateOrdered;
	
	public Order() {}

	public int getId() {
		return id;
	}

	public User getUser() {
		return user;
	}

	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	public float getTotalPrice() {
		return totalPrice;
	}

	public Date getDateOrdered() {
		return dateOrdered;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}

	public void setDateOrdered(Date orderDate) {
		this.dateOrdered = orderDate;
	}
}
