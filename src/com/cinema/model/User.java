package com.cinema.model;

/**
 * 用户实体
 */
public class User {

	private int id;
	private String userName;
	private String password;
	private String userLevel;
	private String registrationTime;
	private int costTotal;
	private int costNum;
	private String telNumber;
	private String mailNumber;
	
	
	public User(String userName, String userLevel, int costTotal, int costNum, String telNumber, String mailNumber) {
		super();
		this.userName = userName;
		this.userLevel = userLevel;
		this.costTotal = costTotal;
		this.costNum = costNum;
		this.telNumber = telNumber;
		this.mailNumber = mailNumber;
	}


	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public User(int id, String userName) {
		super();
		this.id = id;
		this.userName = userName;
	}


	public User(int id, String userName, String password, String userLevel, String registrationTime, int costTotal, int costNum,
			String telNumber, String mailNumber) {
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.userLevel = userLevel;
		this.registrationTime = registrationTime;
		this.costTotal = costTotal;
		this.costNum = costNum;
		this.telNumber = telNumber;
		this.mailNumber = mailNumber;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserLevel() {
		return userLevel;
	}
	public void setUserLevel(String userLevel) {
		this.userLevel = userLevel;
	}
	public String getRegistrationTime() {
		return registrationTime;
	}
	public void setRegistrationTime(String registrationTime) {
		this.registrationTime = registrationTime;
	}
	public int getCostTotal() {
		return costTotal;
	}
	public void setCostTotal(int costTotal) {
		this.costTotal = costTotal;
	}
	public int getCostNum() {
		return costNum;
	}
	public void setCostNum(int costNum) {
		this.costNum = costNum;
	}
	public String getTelNumber() {
		return telNumber;
	}
	public void setTelNumber(String telNumber) {
		this.telNumber = telNumber;
	}
	public String getMailNumber() {
		return mailNumber;
	}
	public void setMailNumber(String mailNumber) {
		this.mailNumber = mailNumber;
	}
}
