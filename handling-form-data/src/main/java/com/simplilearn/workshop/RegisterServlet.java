package com.simplilearn.workshop;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/register.do")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String customerName = request.getParameter("CUSTOMER_NAME");
		String password = request.getParameter("PASSWORD");
		String gender = request.getParameter("GENDER");
		
		// read the checkbox
		String[] hobbies = request.getParameterValues("HOBBIES");
		
		String country = request.getParameter("COUNTRY");
		String[] languages = request.getParameterValues("LANGUAGES");
		
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<div>");
		out.println("<p> Customer Name : " + customerName + "</p>");
		out.println("<p> Passwword : " + password + "</p>");
		out.println("<p> Gender :" + gender + "</p>");
		out.println("<p>Hobbies : <br>");
		for(int i = 0 ; i < hobbies.length ; i++) {
			out.println(hobbies[i] + "<br>");
		}
		out.println("</p>");
		out.println("<p> country : " + country + "</p>");
		out.println("<p> Languages Known : <br>");
		for(int i = 0 ; i < languages.length ; i++) {
			out.println(languages[i] + "<br>");
		}
		out.println("</p>");
		out.println("</div>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request,response);
		
	}

}
