package weinberg.jason.jasonsbookstore;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import org.springframework.beans.factory.annotation.*;

import weinberg.jason.jasonsbookstore.bean.*;
import weinberg.jason.jasonsbookstore.model.*;

/**
 * Servlet implementation class Register
 */
@WebServlet("/register")
public class Register extends AbstractServlet {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private Account account;
	
    /**
     * @see AbstractServlet#AbstractServlet()
     */
    public Register() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/register.xhtml").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String emailAddress = request.getParameter("emailAddress");
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("confirmPassword");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String streetAddress = request.getParameter("streetAddress");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String zipCode = request.getParameter("zipCode");
		
		if(emailAddress.isEmpty()) {
			request.setAttribute("error", "Please enter an email address.");
		} else if(password.isEmpty()) {
			request.setAttribute("error", "Please enter a password.");
		} else if(!password.equals(confirmPassword)) {
			request.setAttribute("error", "Passwords do not match. Please try again.");
		}
		
		account.register(emailAddress, password, firstName, lastName, streetAddress, city, state, zipCode);
		User user = account.getUser();
		
		request.getSession().setAttribute("user", user);
		response.sendRedirect("index");
	}

}
