package com.spring.app.project.recipe.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.spring.app.project.recipe.dto.RecipeLike_DTO;
import com.spring.app.project.recipe.dto.Recipe_DTO;

public interface IRecipeService {

	
	
	public void makeRecipe( MultipartFile file,Recipe_DTO recipe,HttpServletRequest request) throws Exception;


	public void editRecipe(MultipartFile file, Recipe_DTO recipe, HttpServletRequest request)  throws Exception;
	
	public int recipeTotalCnt();

	public List<Recipe_DTO> recipeList(int page);

	public Recipe_DTO getRecipe(int rNo);
	
	public int rnMax(String userId);
	
	public Recipe_DTO selectRecipe(@Param("rNo") int rNo , @Param("userId") String userId );
	
	public Recipe_DTO selectRecipeRno(@Param("rNo") int rNo);
	
	public void insertRecipeLike(@Param("rNo") int rNo , @Param("userId") String userId);
	
	public void deleteRecipeLike(@Param("rNo") int rNo , @Param("userId") String userId);
	
	public RecipeLike_DTO selectRecipeLike(@Param("rNo") int rNo , @Param("userId") String userId);
	
	public void deleteRecipe(int rNo);
	
	public void deleteRecipeLikeByUserId(@Param("user_id") String user_id);
	
	public void deleteUserId(String user_id);
	
	public void deleteRecipeLikeByRno( int rNo);
	
	public List<Recipe_DTO> seletReciepeUser(String user_id);

	public List<Recipe_DTO> searchRecipe(int page, String search) ;
	public int searchRecipeTotalCnt(String search);
}
