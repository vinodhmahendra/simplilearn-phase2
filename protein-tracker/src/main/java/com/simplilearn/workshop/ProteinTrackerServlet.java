package com.simplilearn.workshop;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import com.simplilearn.workshop.utils.HibernateUtils;


@WebServlet("/protein-traker")
public class ProteinTrackerServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		Session session = HibernateUtils.getSessionFactory().openSession();
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("Protein Tracker Application");
		session.close();
	}

}
