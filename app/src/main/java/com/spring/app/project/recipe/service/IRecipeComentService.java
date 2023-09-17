package com.spring.app.project.recipe.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.spring.app.project.recipe.dao.IRecipeComentDao;
import com.spring.app.project.recipe.dto.RecipeComent_DTO;

public interface IRecipeComentService {
	
	public void insert(RecipeComent_DTO dto);
	
	public List<RecipeComent_DTO> select(int rNo);	
	
	public List<RecipeComent_DTO> selelctAll();
	
	public RecipeComent_DTO selectRcno(@Param("rcNo") int rcNo);
	
	public void rcUpdate(@Param("rc") RecipeComent_DTO rc, @Param("rcNo") int rcNo);
	
	public void delete(@Param("rcNo") int rcNo);
	
	public void deleteRecipeCommentByRno(@Param("rNo") int rNo);
	
	public void deleteUserId(@Param("user_id") String user_id);
}
