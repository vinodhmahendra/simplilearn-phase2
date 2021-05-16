package com.simplilearn.workshop;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/content-type")
public class ResponseContentType extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
//		response.setContentType("text/html");
		
		response.setContentType("application/vnd.ms-excel");
		
		PrintWriter out = response.getWriter();
		
		out.println("Rno\tName\tMaths\tPhys\tComputer Sc\tTotal");
		out.println("101\tVinodh\t90\t90\t90\t=SUM(B2:D2)");
		out.println("102\tMahendra\t95\t95\t90\t=SUM(B2:D2)");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
