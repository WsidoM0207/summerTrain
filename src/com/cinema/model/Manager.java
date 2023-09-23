package com.cinema.model;

public class Manager {
	private int id;
	private String manageName;
	private String password;
	
	
	public Manager(String manageName, String password) {
		super();
		this.manageName = manageName;
		this.password = password;
	}
	public Manager() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getManageName() {
		return manageName;
	}
	public void setManageName(String manageName) {
		this.manageName = manageName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
