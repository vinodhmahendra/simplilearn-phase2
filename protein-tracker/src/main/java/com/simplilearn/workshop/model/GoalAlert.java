package com.simplilearn.workshop.model;

public class GoalAlert {
	
	private int id;
	private String message;
	
	public GoalAlert() {
		super();
	}
	
	public GoalAlert(String message) {
		this.message = message;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
