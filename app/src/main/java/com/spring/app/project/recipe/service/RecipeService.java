package com.spring.app.project.recipe.service;

import java.io.File;
import java.net.URLEncoder;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.PageContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.spring.app.project.recipe.dao.IRECIPE_DAO;
import com.spring.app.project.recipe.dao.IRecipeComentDao;
import com.spring.app.project.recipe.dto.RecipeLike_DTO;
import com.spring.app.project.recipe.dto.Recipe_DTO;
import com.spring.app.project.user.dto.USER_DTO;

@Service
public class RecipeService implements IRecipeService{

	@Autowired
	IRECIPE_DAO rdao;
	@Autowired
	IRecipeComentDao rcdao;

	public void makeRecipe( MultipartFile file,Recipe_DTO recipe,HttpServletRequest request) throws Exception{
		String imagePath = request.getSession().getServletContext().getRealPath("\\resources\\images\\userRecipeImage");
		UUID uuid = UUID.randomUUID();
		String fileName = uuid+ file.getOriginalFilename();
		File saveFile = new File(imagePath, fileName); 
		file.transferTo(saveFile);
		recipe.setRecipe_image(fileName);
		rdao.insertRecipe(recipe);
		
		
	}



	@Override
	public int recipeTotalCnt() {
		
		return rdao.recipeTotalCnt();
		
	}


	@Override
	public List<Recipe_DTO> recipeList(int page) {
		
		int last = page*10;
		int first = last -9;
		
		return rdao.recipeList(first,last);
	}


	@Override
	public Recipe_DTO getRecipe(int rNo) {
		return rdao.getRecipe(rNo);
	}


	@Override
	public int rnMax(String userId) {
		return rdao.rnMax(userId);
	}


	@Override
	public Recipe_DTO selectRecipe(int rNo, String userId) {
		
		return rdao.selectRecipe(rNo, userId);
	}


	@Override
	public void insertRecipeLike(int rNo, String userId) {
		rdao.insertRecipeLike(rNo, userId);
		rdao.addRecipeLike(rNo);
	}


	@Override
	public void deleteRecipeLike(int rNo, String userId) {
		rdao.deleteRecipeLike(rNo, userId);
		rdao.removeRecipeLike(rNo);
	}

	@Override
	public RecipeLike_DTO selectRecipeLike(int rNo, String userId) {
		return rdao.selectRecipeLike(rNo, userId);
	}


	@Override
	public Recipe_DTO selectRecipeRno(int rNo) {
		return rdao.selectRecipeRno(rNo);
	}



	@Override
	public void editRecipe(MultipartFile file, Recipe_DTO recipe, HttpServletRequest request) throws Exception {
		
		if(!file.isEmpty()) {
			String imagePath = request.getSession().getServletContext().getRealPath("\\resources\\images\\userRecipeImage");
			UUID uuid = UUID.randomUUID();
			String fileName = uuid+ file.getOriginalFilename();
			File saveFile = new File(imagePath, fileName); 
			file.transferTo(saveFile);
			recipe.setRecipe_image(fileName);
		}
		rdao.updateRecipe(recipe);
		
	}


	@Override
	public void deleteRecipe(int rNo) {
		// 레시피 댓글 삭제
		rcdao.deleteRecipeCommentByRno(rNo);
		// 레시피 좋아요 삭제
		rdao.deleteRecipeLikeByRno(rNo);
		// 레시피 삭제
		rdao.deleteRecipe(rNo);
		
	}


	@Override
	public List<Recipe_DTO> seletReciepeUser(String user_id) {
		return rdao.seletReciepeUser(user_id);
	}


	@Override
	public List<Recipe_DTO> searchRecipe(int page, String search) {
		int last = page*10;
		int first = last -9;
		return rdao.searchRecipe(first, last, search);
	}


	@Override
	public int searchRecipeTotalCnt(String search) {
		return rdao.searchRecipeTotalCnt(search);
	}


	@Override
	public void deleteUserId(String user_id) {
		// 해당 유저 아이디로 등록된 레시피 모두 로드
		List<Recipe_DTO> recipeList = rdao.seletReciepeUser(user_id);
		
		for( Recipe_DTO recipe : recipeList) {
			// 레시피에 등록된 좋아요, 댓글 삭제
			int rNo = recipe.getRecipe_no();
			rcdao.deleteRecipeCommentByRno(rNo);
			rdao.deleteRecipeLikeByRno(rNo);
		}
		//레시피삭제
		rdao.deleteUserId(user_id);
	}


	@Override
	public void deleteRecipeLikeByUserId(String user_id) {
		rdao.deleteRecipeLikeByUserId(user_id);
	}


	@Override
	public void deleteRecipeLikeByRno(int rNo) {
		rdao.deleteRecipeLikeByRno(rNo);
	}


}
