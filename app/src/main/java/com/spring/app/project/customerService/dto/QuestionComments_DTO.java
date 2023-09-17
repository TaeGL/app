package com.spring.app.project.customerService.dto;

public class QuestionComments_DTO {
	private int comment_no;
	private int board_no;
	private String user_id;
	private String question_comment;
	private String comment_date;
	
	public QuestionComments_DTO() {}
	
	public QuestionComments_DTO(int comment_no, int board_no, String user_id, String question_comment,
			String comment_date) {
		super();
		this.comment_no = comment_no;
		this.board_no = board_no;
		this.user_id = user_id;
		this.question_comment = question_comment;
		this.comment_date = comment_date;
	}
	public int getComment_no() {
		return comment_no;
	}
	public void setComment_no(int comment_no) {
		this.comment_no = comment_no;
	}
	public int getBoard_no() {
		return board_no;
	}
	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getQuestion_comment() {
		return question_comment;
	}
	public void setQuestion_comment(String question_comment) {
		this.question_comment = question_comment;
	}
	public String getComment_date() {
		return comment_date;
	}
	public void setComment_date(String comment_date) {
		this.comment_date = comment_date;
	}
	@Override
	public String toString() {
		return "QuestionComments_DTO [comment_no=" + comment_no + ", board_no=" + board_no + ", user_id=" + user_id
				+ ", question_comment=" + question_comment + ", comment_date=" + comment_date + "]";
	}

	
	
}
