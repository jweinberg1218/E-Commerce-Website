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
 * Servlet implementation class SearchResults
 */
@WebServlet("/searchResults")
public class SearchResults extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private Catalog catalog;
	
    /**
     * @see HttpServlet#HttpServlet()
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
		
		List<Book> results = catalog.search(searchQuery, filterCriteria, sortOrder);
		
		HttpSession httpSession = request.getSession();
		httpSession.setAttribute("results", results);
		
		request.getRequestDispatcher("/WEB-INF/search-results.xhtml").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		doGet(request, response);
	}

}
