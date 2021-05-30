package com.simplilearn.workshop.model;

import java.util.ArrayList;
import java.util.List;

public class User {

	private int id;
	private String name;
	
	// one way
	private ProteinData proteinData = new ProteinData();
	
	public ProteinData getProteinData() {
		return proteinData;
	}
	public void setProteinData(ProteinData proteinData) {
		this.proteinData = proteinData;
	}
	
	// one to many
	private List<UserHistory> history = new ArrayList<UserHistory>();
	
	public List<UserHistory> getHistory() {
		return history;
	}
	
	public void setHistory(List<UserHistory> history) {
		this.history = history;
	}
	
	//Business method to define it is two-way relationship
	public void addHistory(UserHistory historyItem) {
		historyItem.setUser(this);
		history.add(historyItem);
	}
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

	
}
