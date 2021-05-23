package com.simplilearn.workshop;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Preview")
public class Preview extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//read the email
		String email = request.getParameter("email");		
		
		HttpSession session = request.getSession();
		String guestName = (String)session.getAttribute("guestName");
		
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
		//save the email in session object
		session.setAttribute("email", email);
		out.println("<form action='SaveData' method='post'>");
		out.println("<p><input type='submit' value='Save Data' /> </p>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");	
	}

}
