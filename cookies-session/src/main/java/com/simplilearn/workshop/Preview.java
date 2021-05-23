package com.simplilearn.workshop;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Preview")
public class Preview extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//read the email
		String email = request.getParameter("email");		
		//read cookie from a browser
		Cookie[] userData = request.getCookies();
		String guestName = userData[0].getValue();
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Preview</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h3>Please confirm your information</h3>");
		out.println("<p>Guest Name : " + guestName + "</p>");
		out.println("<p>Email id : " + email + "</p>");
		//save the email in cookie object
		Cookie emailData = new Cookie("email", email);
		response.addCookie(emailData);
		out.println("<form action='SaveData' method='post'>");
		out.println("<p><input type='submit' value='Save Data' /> </p>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");	
	}

}
