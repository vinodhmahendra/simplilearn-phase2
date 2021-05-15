package com.simplilearn.workshop;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/userinfo")
public class UserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		//set the MIME 
		response.setContentType("text/html");

		//Obtain a PrintWriter object from HttpServletResponse
		PrintWriter out = response.getWriter();
		
		//Read the Query Parameter
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		
		out.println("<h3>Reading QueryString data using 'String getParameter(String name)' method: </h3>");
		out.println("<div>");
		out.println("<p> First Name : " + firstName + "</p>");
		out.println("<p> Last Name : " + lastName + "</p>");
		out.println("</div>");
		
		//use case  : i don't know the parameter names ? how do i read it ?
		out.println("<h3>Reading QueryString data using 'Enumeration getParameterNames()' method: </h3> ");
		Enumeration<String> paramNames = request.getParameterNames();
		out.println("<div>");
		while( paramNames.hasMoreElements()) {
			String paramName = paramNames.nextElement();
			String paramValue = request.getParameter(paramName);
			out.println("<p>"+ paramName + " : " +paramValue + "</p>");
		}
		out.println("</div>");
		
		out.println("<h3>Read QueryString data using 'Map getParameterMap()' method </h3>");
		
		Map<String, String[]> paramMap = request.getParameterMap();
		Set<String> paramNamesSet = paramMap.keySet();
		out.println("<div>");
		for(String paramName : paramNamesSet) {
			String[] paramValues = paramMap.get(paramName);
			out.println("<p>" + paramName + " : ");
			for (int i = 0; i < paramValues.length;i++ ) {
				out.println(paramValues[i] + "</p>");
			}
		}
		out.println("</div>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
	
	}

}
