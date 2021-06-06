package com.simplilearn.workshop;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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


@WebServlet("/ProteinTrackerCriteria")
public class ProteinTrackerCriteriaQuery extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		populateSampleData();
		
		Session session = HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
	
//		CriteriaBuilder builder = session.getCriteriaBuilder();
//		CriteriaQuery<User> query = builder.createQuery(User.class);
//		Root<User> root = query.from(User.class);
//		query.select(root);
//		
//		Query<User> q = session.createQuery(query);
//		List<User> users = q.getResultList();
//		for (User user : users) {
//		out.println(user.getName() + "<br/>");
//	 }
		
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<User> query = builder.createQuery(User.class);
		Root<User> root = query.from(User.class);
		query.select(root).where(builder.equal(root.get("name"), "Dennis"));
		
		Query<User> q = session.createQuery(query);
//		List<User> users = q.getResultList();
		User user = q.getSingleResult();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println(user.getName());
		

		
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
