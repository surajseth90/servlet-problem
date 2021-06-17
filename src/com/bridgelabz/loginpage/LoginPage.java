package com.bridgelabz.loginpage;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.*;

@WebServlet(
		description = "Login Servlet Testing",
		urlPatterns = {"/LoginServlet"}
)		
		
public class LoginPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("user");
		String pwd = request.getParameter("pwd");
		if(user.matches("[A-Z]{1}[a-z]{2,}")) {
			request.setAttribute("user", user);
			request.getRequestDispatcher("LoginSuccess.jsp").forward(request, response);
			
		}else {
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/Login.html");
			PrintWriter out = response.getWriter();
			out.println("<font color=red>Incorrect Name , Please Enter The Correct Name</font>");
			rd.include(request, response);
		}
		
		
		
		
	}

}