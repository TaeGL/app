package com.spring.app.project.customerService.dto;

// 1:1문의
public class BoardQuestionToAdmin_DTO{
		
		private int board_no;
		private String board_title;
		private String board_type;
		private String board_content;
		private String board_state;
		private String user_id;
		private String board_date;
		
		public BoardQuestionToAdmin_DTO() {	}
		
		public BoardQuestionToAdmin_DTO(int board_no, String board_title, String board_type, String board_content,
				String board_state, String user_id, String board_date) {
			super();
			this.board_no = board_no;
			this.board_title = board_title;
			this.board_type = board_type;
			this.board_content = board_content;
			this.board_state = board_state;
			this.user_id = user_id;
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

		public String getBoard_state() {
			return board_state;
		}

		public void setBoard_state(String board_state) {
			this.board_state = board_state;
		}

		public String getUser_id() {
			return user_id;
		}

		public void setUser_id(String user_id) {
			this.user_id = user_id;
		}

		public String getBoard_date() {
			return board_date;
		}

		public void setBoard_date(String board_date) {
			this.board_date = board_date;
		}

		
}