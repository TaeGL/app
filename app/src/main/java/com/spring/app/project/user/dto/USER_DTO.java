package com.spring.app.project.user.dto;

public class USER_DTO {
	//[1]id, [2]nick, [3]pw, [4]name, [5]age, [6]email, [7]phone, [8]addr, [9]"BRONZE"

	private String user_id;
	private String user_nick;
	private String user_pw;
	private String user_name;
	private String user_email;
	private String user_addr;
	private String user_grade;
	
	public USER_DTO(String user_id, String user_nick, String user_pw, String user_name, String user_email,
			String user_addr, String user_grade) {
		super();
		this.user_id = user_id;
		this.user_nick = user_nick;
		this.user_pw = user_pw;
		this.user_name = user_name;
		this.user_email = user_email;
		this.user_addr = user_addr;
		this.user_grade = user_grade;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_nick() {
		return user_nick;
	}
	public void setUser_nick(String user_nick) {
		this.user_nick = user_nick;
	}
	public String getUser_pw() {
		return user_pw;
	}
	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getUser_addr() {
		return user_addr;
	}
	public void setUser_addr(String user_addr) {
		this.user_addr = user_addr;
	}
	public String getUser_grade() {
		return user_grade;
	}
	public void setUser_grade(String user_grade) {
		this.user_grade = user_grade;
	}
		
	//	private String user_regdate;
	
	
	////////////////
	
	
}
