package com.spring.app.project.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.app.project.recipe.dto.RecipeComent_DTO;
import com.spring.app.project.recipe.dto.Recipe_DTO;
import com.spring.app.project.recipe.service.IRecipeService;
import com.spring.app.project.user.dao.IUSER_DAO;
import com.spring.app.project.user.dto.USER_DTO;
import com.spring.app.project.user.dto.USER_STATUS;

@Service
public class UserService implements IUserService{

	@Autowired
	IUSER_DAO udao;

	@Autowired
	IRecipeService rDao;
	
	@Override
	public void insertUser(USER_DTO dto) {
		udao.insertUser(dto);
	}

	@Override
	public USER_DTO selectUser(String user_id) {
		return udao.selectUser(user_id);
	}
	
	@Override
	public USER_DTO selectUserEmail(String email) {
		return udao.selectUserEmail(email);
	}

	@Override
	public void insertUStatus(USER_STATUS dto) {
		udao.insertUStatus(dto);
	}


	@Override
	public USER_STATUS selectUSEmail(String email) {
		return udao.selectUSEmail(email);
	}

	@Override
	public USER_DTO selectUserEmailId(String email, String user_id) {
		return udao.selectUserEmailId(email, user_id);
	}

	@Override
	public void updateUserPw(String user_id, String code) {
		udao.updateUserPw(user_id, code);
	}

	@Override
	public void updateUStatus(String email, String status) {
		udao.updateUStatus(email, status);
	}

	@Override
	public void updateUser(USER_DTO user, String user_id) {
		udao.updateUser(user, user_id);
	}

	@Override
	public List<Recipe_DTO> myRecipeList(String user_id , int page) {
		int last = page*10;
		int first = last -9;
		return udao.myRecipeList(first, last, user_id);
	}

	@Override
	public int myRecipeCnt(String user_id) {
		return udao.myRecipeCnt(user_id);
	}

	@Override
	public List<RecipeComent_DTO> myRecipeComments(String user_id , int page) {
		int last = page*10;
		int first = last -9;
		return udao.myRecipeComments(first, last, user_id);
	}

	@Override
	public int myRecipeCommentsCnt(String user_id) {
		return udao.myRecipeCommentsCnt(user_id);
	}

	@Override
	public void deleteUStatus(String email) {
		udao.deleteUStatus(email);
	}

	@Override
	public void deleteUser(String email) {
		udao.deleteUser(email);
	}


}
