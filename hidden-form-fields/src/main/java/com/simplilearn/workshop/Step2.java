package com.simplilearn.workshop;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Step2")
public class Step2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		//read the guest name
		String guestName = request.getParameter("guestName");
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Greetings</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h3> Welcome " + guestName + "</h3>");
		out.println("<form action='Preview' method='post'>");
		out.println("<input type='hidden' name='guestName' value='"+guestName+"'/>"); // hidden element
		out.println("<p>Enter Email Id : </p>");
		out.println("<p><input type='email' name='email'/></p>");
		out.println("<p><input type='submit' value='Preview' /> </p>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
		
	}//end of doPost

}
