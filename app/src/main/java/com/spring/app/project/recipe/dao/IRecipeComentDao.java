package com.spring.app.project.recipe.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.spring.app.project.recipe.dto.RecipeComent_DTO;

public interface IRecipeComentDao {
	// 레시피 댓글 등록
	public void insert(RecipeComent_DTO dto);
	// 레시피 댓글 조회
	public List<RecipeComent_DTO> select(@Param("rNo") int rNo);
	public List<RecipeComent_DTO> selelctAll();
	public RecipeComent_DTO selectRcno(@Param("rcNo") int rcNo);
	// 레시피 댓글 삭제
	public void delete(@Param("rcNo") int rcNo);
	public void deleteUserId(@Param("user_id") String user_id);
	public void deleteRecipeCommentByRno(@Param("rNo") int rNo);
	// 레시피 댓글 수정
	public void rcUpdate(@Param("rc") RecipeComent_DTO rc, @Param("rcNo") int rcNo);
}
