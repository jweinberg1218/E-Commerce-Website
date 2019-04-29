package weinberg.jason.jasonsbookstore;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import org.springframework.beans.factory.annotation.*;

import weinberg.jason.jasonsbookstore.bean.*;

/**
 * Servlet implementation class SearchResults
 */
@WebServlet("/searchResults")
public class SearchResults extends AbstractServlet {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private Catalog catalog;
	
	@Autowired
	private Result result;
	
    /**
     * @see AbstractServlet#AbstractServlet()
     */
    public SearchResults() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String searchQuery = request.getParameter("searchQuery");
		String filterCriteria = request.getParameter("filterCriteria");
		String sortOrder = request.getParameter("sortOrder");
		
		result.setBooks(catalog.search(searchQuery, filterCriteria, sortOrder));
		
		request.getRequestDispatcher("/WEB-INF/search-results.xhtml").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		doGet(request, response);
	}

}
