package com.simplilearn.workshop.filters;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;


@WebFilter("/secured-servlet")
public class AuthenticationFilter implements Filter {

  
	public void destroy() {
		System.out.println("destroy method is called in " +this.getClass().getName());
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
			throws IOException, ServletException {
		System.out.println("doFilter method is called in " +this.getClass().getName());
		
		//read the parameters
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		//obtain the client ip address
		String ipAddress = request.getRemoteAddr();
		
		if(username.equals("simplilearn") && password.equals("simplilearn")) {
			System.out.println("User logged in " + ipAddress + " at " + new Date().toString());
			// pass the request along the filter chain
			chain.doFilter(request, response); // invoke a secured servlet
		}else {
			PrintWriter out = response.getWriter();
			out.println("<h3>sorry, you are not authorized to access this resource. </h3>");
		}

		
	}


	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("init method is called in " +this.getClass().getName());
	}

}
