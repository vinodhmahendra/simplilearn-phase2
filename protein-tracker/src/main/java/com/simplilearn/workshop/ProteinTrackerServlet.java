package com.simplilearn.workshop;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import com.simplilearn.workshop.model.User;
import com.simplilearn.workshop.model.UserHistory;
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
		user.addHistory(new UserHistory(new Date(), "setting a name as 'vinodh mahendra'"));
		user.getProteinData().setGoal(250);
		user.addHistory(new UserHistory(new Date(), "setting a goal for 250"));
		
		// save a user history
		//execute database operations
		session.save(user);
		
		//commit the transaction
		session.getTransaction().commit();
		
		
		// open a transaction
		session.beginTransaction();
		
		//retrieve the User
		User loadedUser = (User) session.get(User.class, 1);
		
		//manipulate the object
		loadedUser.getProteinData().setTotal(loadedUser.getProteinData().getTotal() + 50);
		loadedUser.addHistory(new UserHistory(new Date(), "setting a total for 50"));
		
		session.getTransaction().commit();  // auto update
		//flush and close session
		session.close();
		
		HibernateUtils.getSessionFactory().close(); // destroy
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("Protein Tracker Application <br/>");
		
		out.println("Name : " + loadedUser.getName() + "<br/>");
		out.println("Goal : " + loadedUser.getProteinData().getGoal()+ "<br/>");
		
	}

	
}
