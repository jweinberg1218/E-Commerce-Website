package weinberg.jason.jasonsbookstore.bean;

import java.io.*;
import java.util.*;

import javax.persistence.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.transaction.annotation.*;

import weinberg.jason.jasonsbookstore.model.*;

public class Account implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "jasonsbookstoreDB")
	private EntityManager entityManager;
	
	@Autowired
	private Cart cart;
	
	private User user;
	
	public Account() {}
	
	public void login(String emailAddress, String password) {
		TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User u WHERE u.emailAddress = :emailAddress AND u.password = :password", User.class);
		query.setParameter("emailAddress", emailAddress);
		query.setParameter("password", password);
		
		try {
			user = query.getSingleResult();
		} catch(NoResultException e) {
			user = null;
		}
	}
	
	public void logout() {
		user = null;
	}
	
	@Transactional
	public void register(String emailAddress, String password, String firstName, String lastName, String streetAddress, String city, String state, String zipCode) {
		user = new User();
		user.setEmailAddress(emailAddress);
		user.setPassword(password);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setStreetAddress(streetAddress);
		user.setCity(city);
		user.setState(state);
		user.setZipCode(zipCode);
		
		entityManager.persist(user);
	}
	
	@Transactional
	public void update(String firstName, String lastName, String streetAddress, String city, String state, String zipCode) {
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setStreetAddress(streetAddress);
		user.setCity(city);
		user.setState(state);
		user.setZipCode(zipCode);
		
		entityManager.merge(user);
	}
	
	public User getUser() {
		return user;
	}
	
	@Transactional
	public Order createOrder() {
		Order order = new Order();
		List<OrderItem> orderItems = new ArrayList<OrderItem>(cart.getItems());
		float totalPrice = 0;
		
		for(OrderItem orderItem : orderItems) {
			orderItem.setOrder(order);
			totalPrice += orderItem.getTotalPrice();
		}
		
		order.setUser(user);
		order.setOrderItems(orderItems);
		order.setTotalPrice(totalPrice);
		order.setDateOrdered(new Date());
		entityManager.persist(order);
		
		List<Order> orders = user.getOrders();
		if(orders == null)
			orders = new ArrayList<Order>();
		
		orders.add(order);
		user.setOrders(orders);
		cart.clearItems();
		
		return order;
	}
	
	public Order findOrder(int orderId) {
		List<Order> orders = user.getOrders();
		for(Order order : orders)
			if(order.getId() == orderId)
				return order;
		
		return null;
	}
	
	public List<Order> findAllOrders() {
		List<Order> orders = user.getOrders();
		
		return orders;
	}
}
