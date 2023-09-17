package com.spring.app.project.recipe.dto;

public class RecipeLike_DTO {

	private int rl_no;
	private int recipe_no;
	private String user_id;
	
	public RecipeLike_DTO() { ; }

	public RecipeLike_DTO(int rl_no, int recipe_no, String user_id) {
		super();
		this.rl_no = rl_no;
		this.recipe_no = recipe_no;
		this.user_id = user_id;
	}

	public int getRl_no() {
		return rl_no;
	}

	public void setRl_no(int rl_no) {
		this.rl_no = rl_no;
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

	
}
