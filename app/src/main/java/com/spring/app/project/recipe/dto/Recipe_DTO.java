package com.spring.app.project.recipe.dto;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class Recipe_DTO {

	private int recipe_no;

	private	String recipe_name;
				
	private	String recipe_image;

	private	String user_id;

	private	String recipe_category;

	private	String cook_ingredient;

	private	String recipe_contents;
	
	private	int recipe_like;

	private int review_like;
	
	private	String recipe_date;
	
	public Recipe_DTO() {}

	public Recipe_DTO(int recipe_no, String recipe_name, String recipe_image, String user_id, String recipe_category,
			String cook_ingredient, String recipe_contents, int recipe_like, int review_like, String recipe_date) {
		super();
		this.recipe_no = recipe_no;
		this.recipe_name = recipe_name;
		this.recipe_image = recipe_image;
		this.user_id = user_id;
		this.recipe_category = recipe_category;
		this.cook_ingredient = cook_ingredient;
		this.recipe_contents = recipe_contents;
		this.recipe_like = recipe_like;
		this.review_like = review_like;
		this.recipe_date = recipe_date;
	}

	public int getRecipe_no() {
		return recipe_no;
	}

	public void setRecipe_no(int recipe_no) {
		this.recipe_no = recipe_no;
	}

	public String getRecipe_name() {
		return recipe_name;
	}

	public void setRecipe_name(String recipe_name) {
		this.recipe_name = recipe_name;
	}

	public String getRecipe_image() {
		return recipe_image;
	}

	public void setRecipe_image(String recipe_image) {
		this.recipe_image = recipe_image;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getRecipe_category() {
		return recipe_category;
	}

	public void setRecipe_category(String recipe_category) {
		this.recipe_category = recipe_category;
	}

	public String getCook_ingredient() {
		return cook_ingredient;
	}

	public void setCook_ingredient(String cook_ingredient) {
		this.cook_ingredient = cook_ingredient;
	}

	public String getRecipe_contents() {
		return recipe_contents;
	}

	public void setRecipe_contents(String recipe_contents) {
		this.recipe_contents = recipe_contents;
	}

	public int getRecipe_like() {
		return recipe_like;
	}

	public void setRecipe_like(int recipe_like) {
		this.recipe_like = recipe_like;
	}

	public int getReview_like() {
		return review_like;
	}

	public void setReview_like(int review_like) {
		this.review_like = review_like;
	}

//	public String getRecipe_date() {
//		SimpleDateFormat format = new SimpleDateFormat("yyyy년 MM월 dd일");
//		if(recipe_date == null) {
//			return null;
//		}
//		return format.format(recipe_date);
//	}

	public String getRecipe_date() {
		return recipe_date;
	}
	
	public void setRecipe_date(String recipe_date) {
		this.recipe_date = recipe_date;
	}

	@Override
	public String toString() {
		return "Recipe_DTO [recipe_no=" + recipe_no + ", recipe_name=" + recipe_name + ", recipe_image=" + recipe_image
				+ ", user_id=" + user_id + ", recipe_category=" + recipe_category + ", cook_ingredient="
				+ cook_ingredient + ", recipe_contents=" + recipe_contents + ", recipe_like=" + recipe_like
				+ ", review_like=" + review_like + ", recipe_date=" + recipe_date + "]";
	}


	
}
