package com.simplilearn.workshop;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import com.simplilearn.workshop.model.User;
import com.simplilearn.workshop.utils.HibernateUtils;


@WebServlet("/protein-traker")
public class ProteinTrackerServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		Session session = HibernateUtils.getSessionFactory().openSession();
		
		// begin a transaction
		session.beginTransaction();
		
		User user = new User();
		user.setName("vinodh  mahendra");
		user.setGoal(250);
		
		//execute database operations
		session.save(user);
		
		//commit the transaction
		session.getTransaction().commit();
		
		
		// open a transaction
		session.beginTransaction();
		
		//retrieve the User
		User loadedUser = (User) session.get(User.class, 1);
		
		//manipulate the object
		loadedUser.setTotal(loadedUser.getTotal() + 50);
		
		
		session.getTransaction().commit();  // auto update
		//flush and close session
		session.close();
		
		HibernateUtils.getSessionFactory().close();
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("Protein Tracker Application <br/>");
		
		out.println("Name : " + loadedUser.getName() + "<br/>");
		out.println("Goal : " + loadedUser.getGoal()+ "<br/>");
		
	}

	
}
