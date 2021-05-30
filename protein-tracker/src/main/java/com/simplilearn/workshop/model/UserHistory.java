package com.simplilearn.workshop.model;

import java.util.Date;

public class UserHistory {
	
	private int id; // entity
	
	private Date entryTime;
	private String entry;
	
	// relationship (many user_history is associated with one user)
	private User user;
	
	public UserHistory() {
		super();
	}

	public UserHistory(Date entryTime,String entry) {
		this.entryTime = entryTime;
		this.entry = entry;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getEntryTime() {
		return entryTime;
	}

	public void setEntryTime(Date entryTime) {
		this.entryTime = entryTime;
	}

	public String getEntry() {
		return entry;
	}

	public void setEntry(String entry) {
		this.entry = entry;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
