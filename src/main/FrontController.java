package main;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontController extends HttpServlet {

	static Dial dialer = new Dial();
	ServletContext servletContext;
	private static final long serialVersionUID = 1L;

	@Override
	public void init(ServletConfig config) throws ServletException {

		servletContext = config.getServletContext();
		servletContext.setAttribute("dialer", dialer);

	}

	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String mobile = request.getParameter("mobile");
		boolean isError = false;
		if (mobile == null || mobile.trim().isEmpty()) {
			request.setAttribute("msg", "please enter mobile number");
			isError = true;
		}
		if (isError) {
			request.getRequestDispatcher("index.jsp")
					.forward(request, response);

		} else {
			String language = request.getParameter("group1");
			User user = new User(mobile, language);
			servletContext = request.getServletContext();
			Dial checkDialer = (Dial) servletContext.getAttribute("dialer");
			checkDialer.addCall(user);
			checkDialer.operatorAllocator();
			servletContext.setAttribute("dialer", checkDialer);
			response.sendRedirect("index.jsp");
		}

	}
}
