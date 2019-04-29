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
@WebServlet("/browseAll")
public class BrowseAll extends AbstractServlet {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private Catalog catalog;
	
	@Autowired
	private Result result;
	
    /**
     * @see AbstractServlet#AbstractServlet()
     */
    public BrowseAll() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		result.setBooks(catalog.search("", "", "asc"));
		
		request.getRequestDispatcher("/WEB-INF/search-results.xhtml").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		doGet(request, response);
	}

}
