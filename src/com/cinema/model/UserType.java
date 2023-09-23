package com.cinema.model;

/**
 * 用户类别实体类
 */
public class UserType {
	private int id;
	private String userTypeName;  //用户类别名称
	private String userTypeDesc;  //备注
	
	
	public UserType() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public UserType(String userTypeName, String userTypeDesc) {
		super();
		this.userTypeName = userTypeName;
		this.userTypeDesc = userTypeDesc;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserTypeName() {
		return userTypeName;
	}
	public void setUserTypeName(String userTypeName) {
		this.userTypeName = userTypeName;
	}
	public String getUserTypeDesc() {
		return userTypeDesc;
	}
	public void setUserTypeDesc(String userTypeDesc) {
		this.userTypeDesc = userTypeDesc;
	}
	
}
