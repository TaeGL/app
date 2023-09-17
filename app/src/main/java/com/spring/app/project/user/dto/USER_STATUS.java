package com.spring.app.project.user.dto;

public class USER_STATUS {
	String user_email; 
	String user_id; 
	String user_status;
	public USER_STATUS(String user_email, String user_id, String user_status) {
		super();
		this.user_email = user_email;
		this.user_id = user_id;
		this.user_status = user_status;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_status() {
		return user_status;
	}
	public void setUser_status(String user_status) {
		this.user_status = user_status;
	}
	
	
	
	
}
