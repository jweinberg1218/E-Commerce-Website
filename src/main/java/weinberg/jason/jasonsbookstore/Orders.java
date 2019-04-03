package weinberg.jason.jasonsbookstore;

import java.io.*;
import java.util.*;

import javax.inject.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import weinberg.jason.jasonsbookstore.bean.*;
import weinberg.jason.jasonsbookstore.model.*;

/**
 * Servlet implementation class Orders
 */
@WebServlet("/orders")
public class Orders extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private Account account;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Orders() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Order> orders = account.getAllOrders();
		
		request.setAttribute("orders", orders);
		
		request.getRequestDispatcher("/WEB-INF/orders.xhtml").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
