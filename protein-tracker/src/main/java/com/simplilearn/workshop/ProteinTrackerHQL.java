package com.simplilearn.workshop;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.simplilearn.workshop.model.GoalAlert;
import com.simplilearn.workshop.model.User;
import com.simplilearn.workshop.model.UserHistory;
import com.simplilearn.workshop.utils.HibernateUtils;


@WebServlet("/ProteinTrackerHQL")
public class ProteinTrackerHQL extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		populateSampleData();
		
		Session session = HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
		
//		Query<User> query = session.createQuery("from User");
		
		// WHERE
//		Query<User> query = session.createQuery("from User user where user.name = 'vinodh'");
		
//		Query<User> query = session.createQuery("from User user where user.name = 'vinodh' "
//				+ "and user.proteinData.total > 0");
		@SuppressWarnings("unchecked")
		Query<User> query = session.createQuery("select user from User as user where user.name = :name");
		query.setParameter("name", "clarence");
		
		List<User> users = query.list();
		
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		for (User user : users) {
			out.println(user.getName() + "<br/>");
		}
		
		session.getTransaction().commit();
		session.close();
	}


	private void populateSampleData() {
		Session session = HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();;
		User vinodh = createUser("vinodh",500,50,"Good Job","You made it");
		session.save(vinodh);
		
		User clarence = createUser("clarence", 300, 20, "Taco Time");
		session.save(clarence);
		
		User dennis = createUser("Dennis", 250, 200, "Yes!!");
		session.save(dennis);
		
		session.getTransaction().commit();
		session.close();
		
	}


	private User createUser(String name, int goal, int total, String...alerts) {
		User user = new User();
		user.setName(name);
		user.getProteinData().setGoal(goal);
		user.addHistory(new UserHistory(new Date(), "set goal to " +goal));
		user.getProteinData().setTotal(total);
		user.addHistory(new UserHistory(new Date(), "set total to " + total));
		
		for (String alert: alerts) {
			user.getGoalAlerts().add(new GoalAlert(alert));
		}
		return user;
	}

	
}
