package com.spring.app.project.recipe.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.spring.app.project.recipe.dto.RecipeLike_DTO;
import com.spring.app.project.recipe.dto.Recipe_DTO;

public interface IRECIPE_DAO {
	// 레시피 등록
	public void insertRecipe(Recipe_DTO recipe);
	// 모든 레시피 갯수
	public int recipeTotalCnt();
	// first부터 last까지 레시피 조회
	public List<Recipe_DTO> recipeList(@Param("first") int first,@Param("last") int last);
	// 레시피 조회 ( recipe_no)
	public Recipe_DTO getRecipe(@Param("rNo") int rNo);
	public Recipe_DTO selectRecipeRno(@Param("rNo") int rNo);
	// 해당 유저가 가장 최근에 등록한 레시피 조회
	public int rnMax(@Param("userId") String userId);
	// 레시피 조회 (recipe_no, user_id)
	public Recipe_DTO selectRecipe(@Param("rNo") int rNo , @Param("userId") String userId );
	// 레시피 좋아요 등록
	public void insertRecipeLike(@Param("rNo") int rNo , @Param("userId") String userId);
	public void addRecipeLike(@Param("rNo") int rNo);
	// 레시피 좋아요 삭제
	public void deleteRecipeLike(@Param("rNo") int rNo , @Param("userId") String userId);
	public void removeRecipeLike(@Param("rNo") int rNo);
	public void deleteRecipeLikeByUserId(@Param("user_id") String user_id);
	public void deleteRecipeLikeByRno(@Param("rNo") int rNo);

	// 레시피 좋아요 조회(recipe_no , user_id)
	public RecipeLike_DTO selectRecipeLike(@Param("rNo") int rNo , @Param("userId") String userId);
	// 레시피 수정
	public void updateRecipe(Recipe_DTO recipe );
	// 레시피 삭제
	public void deleteRecipe(int rNo);
	public void deleteUserId(@Param("user_id") String user_id);
	
	// 레시피 조회
	public List<Recipe_DTO> seletReciepeUser(String user_id);
	// 레시피 검색
	public List<Recipe_DTO> searchRecipe(@Param("first") int first,@Param("last") int last ,@Param("search") String search);
	
	public int searchRecipeTotalCnt(String search);
}
