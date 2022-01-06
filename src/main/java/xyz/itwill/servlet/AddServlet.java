package xyz.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/add.itwill")
public class AddServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;utf-8");
		
		String x = request.getParameter("x");
		int x_ = Integer.parseInt(x);
		String y = request.getParameter("y");
		int y_ = Integer.parseInt(y);
		
		PrintWriter out = response.getWriter();

		out.print(x_+y_);
		
	
	}

}
