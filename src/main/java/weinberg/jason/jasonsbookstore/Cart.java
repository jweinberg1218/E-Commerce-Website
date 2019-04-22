package weinberg.jason.jasonsbookstore;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import org.springframework.beans.factory.annotation.*;

import weinberg.jason.jasonsbookstore.model.*;

/**
 * Servlet implementation class Cart
 */
@WebServlet("/cart")
public class Cart extends AbstractServlet {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private weinberg.jason.jasonsbookstore.bean.Cart cart;
	
    /**
     * @see AbstractServlet#AbstractServlet()
     */
    public Cart() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<OrderItem> items = cart.getItems();
		request.setAttribute("items", items);
		
		int totalItems = 0;
		float totalPrice = 0;
		
		for(OrderItem item : items) {
			totalItems += item.getQty();
			totalPrice += item.getItemPrice() * item.getQty();
		}
		
		request.setAttribute("totalItems", totalItems);
		request.setAttribute("totalPrice", totalPrice);
		
		request.getRequestDispatcher("/WEB-INF/cart.xhtml").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("addBook") != null) {
			int bookId = Integer.parseInt(request.getParameter("addBook"));
			cart.addBook(bookId);
		}
		
		if(request.getParameter("remove") != null) {
			String[] booksToRemove = request.getParameterValues("booksToRemove");
			for(int i = 0; i < booksToRemove.length; i++) {
				cart.removeBook(Integer.parseInt(booksToRemove[i]));
			}
		}
		
		if(request.getParameter("update") != null) {
			for(OrderItem item : cart.getItems()) {
				int qty = Integer.parseInt(request.getParameter("qty:" + item.getBook().getId()));
				cart.updateBookQty(item.getBook().getId(), qty);
			}
		}
		
		doGet(request, response);
	}

}
