package weinberg.jason.jasonsbookstore;

import javax.servlet.*;
import javax.servlet.http.*;

import org.springframework.web.context.*;
import org.springframework.web.context.support.*;

public abstract class AbstractServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AbstractServlet() {
		super();
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		WebApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		ctx.getAutowireCapableBeanFactory().autowireBean(this);
	}

}
