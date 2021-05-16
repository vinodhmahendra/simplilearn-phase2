package com.simplilearn.workshop;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/lifecycle")
public class LifeCycleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	@Override
	public void init() throws ServletException {
		System.out.println("intializiation code");
	}


	@Override
	public void destroy() {
		System.out.println("Releasing the resources.");
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("service(doGet) method invoked!");
	}
}
