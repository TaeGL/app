package com.spring.app.project.recipe.dto;

public class RecipeComent_DTO {
	private int comment_no;
	private int recipe_no;
	private String user_id;
	private String user_grade;
	private String recipe_comment;
	private String comment_date;
	private String recipe_name;
	
	public RecipeComent_DTO() {}

	public RecipeComent_DTO(int comment_no, int recipe_no, String user_id, String user_grade, String recipe_comment,
			String comment_date, String recipe_name) {
		super();
		this.comment_no = comment_no;
		this.recipe_no = recipe_no;
		this.user_id = user_id;
		this.user_grade = user_grade;
		this.recipe_comment = recipe_comment;
		this.comment_date = comment_date;
		this.recipe_name = recipe_name;
	}

	public int getComment_no() {
		return comment_no;
	}

	public void setComment_no(int comment_no) {
		this.comment_no = comment_no;
	}

	public int getRecipe_no() {
		return recipe_no;
	}

	public void setRecipe_no(int recipe_no) {
		this.recipe_no = recipe_no;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_grade() {
		return user_grade;
	}

	public void setUser_grade(String user_grade) {
		this.user_grade = user_grade;
	}

	public String getRecipe_comment() {
		return recipe_comment;
	}

	public void setRecipe_comment(String recipe_comment) {
		this.recipe_comment = recipe_comment;
	}

	public String getComment_date() {
		return comment_date;
	}

	public void setComment_date(String comment_date) {
		this.comment_date = comment_date;
	}

	public String getRecipe_name() {
		return recipe_name;
	}

	public void setRecipe_name(String recipe_name) {
		this.recipe_name = recipe_name;
	}

	@Override
	public String toString() {
		return "RecipeComent_DTO [comment_no=" + comment_no + ", recipe_no=" + recipe_no + ", user_id=" + user_id
				+ ", user_grade=" + user_grade + ", recipe_comment=" + recipe_comment + ", comment_date=" + comment_date
				+ ", recipe_name=" + recipe_name + "]";
	}


	
}
