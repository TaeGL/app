package com.spring.app.project.customerService.dto;

// 공지사항
public class BoardCustomerService_DTO {
	private int board_no;
	private String board_title;
	private String board_type;
	private String board_content;
	private String board_date;
	
	public BoardCustomerService_DTO() {}
	
	public BoardCustomerService_DTO(int board_no, String board_title, String board_type, String board_content,
			String board_date) {
		super();
		this.board_no = board_no;
		this.board_title = board_title;
		this.board_type = board_type;
		this.board_content = board_content;
		this.board_date = board_date;
	}
	public int getBoard_no() {
		return board_no;
	}
	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}
	public String getBoard_title() {
		return board_title;
	}
	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}
	public String getBoard_type() {
		return board_type;
	}
	public void setBoard_type(String board_type) {
		this.board_type = board_type;
	}
	public String getBoard_content() {
		return board_content;
	}
	public void setBoard_content(String board_content) {
		this.board_content = board_content;
	}
	public String getBoard_date() {
		return board_date;
	}
	public void setBoard_date(String board_date) {
		this.board_date = board_date;
	}

	@Override
	public String toString() {
		return "BoardCustomerService_DTO [board_no=" + board_no + ", board_title=" + board_title + ", board_type="
				+ board_type + ", board_content=" + board_content + ", board_date=" + board_date + "]";
	}
	
}