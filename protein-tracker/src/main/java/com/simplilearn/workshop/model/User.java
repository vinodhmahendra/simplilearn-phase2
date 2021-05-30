package com.simplilearn.workshop.model;

public class User {

	private int id;
	private String name;
	private int total;
	private int goal;
	
	//define a constructor
	public User() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getGoal() {
		return goal;
	}

	public void setGoal(int goal) {
		this.goal = goal;
	}

	@Override
	public String toString() {
		return String.format("User [id=%s, name=%s, total=%s, goal=%s]", id, name, total, goal);
	}
}
