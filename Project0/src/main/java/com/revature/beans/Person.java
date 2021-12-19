package com.revature.beans;

import java.util.ArrayList;
import java.util.List;

public class Person {
	private int id;
	private String fullName;
	private String username;
	private String password;
	private List<Bicycle> bicycles;
	
	public Person() {
		id = 0; 
		fullName = "First Last";
		username = "username";
		password = "password";
		bicycles = new ArrayList<>();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<Bicycle> getBicycles() {
		return bicycles;
	}
	public void setBicycles(List<Bicycle> bicycles) {
		this.bicycles = bicycles;
	}
}
