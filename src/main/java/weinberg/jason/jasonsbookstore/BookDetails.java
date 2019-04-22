package weinberg.jason.jasonsbookstore;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import org.springframework.beans.factory.annotation.*;

import weinberg.jason.jasonsbookstore.bean.*;
import weinberg.jason.jasonsbookstore.model.*;

/**
 * Servlet implementation class BookDetails
 */
@WebServlet("/bookDetails")
public class BookDetails extends AbstractServlet {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private Catalog catalog;
	
    /**
     * @see AbstractServlet#AbstractServlet()
     */
    public BookDetails() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("id") != null) {
			int bookId = Integer.parseInt(request.getParameter("id"));
			
			Book book = catalog.find(bookId);
			
			request.setAttribute("book", book);
		}
		
		request.getRequestDispatcher("/WEB-INF/book-details.xhtml").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
