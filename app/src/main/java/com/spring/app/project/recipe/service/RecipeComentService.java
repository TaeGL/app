package com.spring.app.project.recipe.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.app.project.recipe.dao.IRecipeComentDao;
import com.spring.app.project.recipe.dto.RecipeComent_DTO;

@Service
public class RecipeComentService implements IRecipeComentService{
	
	@Autowired
	IRecipeComentDao rcDao;
	
	@Override
	public void insert(RecipeComent_DTO dto) {
		rcDao.insert(dto);
	}

	@Override
	public List<RecipeComent_DTO> select(int rNo) {
		return rcDao.select(rNo);
	}

	@Override
	public void rcUpdate(RecipeComent_DTO rc, int rcNo) {
		rcDao.rcUpdate(rc, rcNo);
	}

	@Override
	public List<RecipeComent_DTO> selelctAll() {
		return rcDao.selelctAll();
	}

	@Override
	public RecipeComent_DTO selectRcno(int rcNo) {
		return rcDao.selectRcno(rcNo);
	}

	@Override
	public void delete(int rcNo) {
		rcDao.delete(rcNo);
	}

	@Override
	public void deleteUserId(String user_id) {
		rcDao.deleteUserId(user_id);
	}

	@Override
	public void deleteRecipeCommentByRno(int rNo) {
		rcDao.deleteRecipeCommentByRno(rNo);
	}


	
	
}
