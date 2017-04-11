package main;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OperatorController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
			String name=request.getParameter("operatorName");
			String language=request.getParameter("group1");
			Operator operator=new Operator(language,name);
			ServletContext context=request.getServletContext();
			Dial dial=(Dial)context.getAttribute("dialer");
			dial.getListOfAllOperators().addOperator(operator);
			response.sendRedirect("index.jsp");
			
					
	}
}
