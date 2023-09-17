package com.spring.app.project.user.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.app.project.recipe.dto.RecipeComent_DTO;
import com.spring.app.project.recipe.dto.Recipe_DTO;
import com.spring.app.project.user.dao.IUSER_DAO;
import com.spring.app.project.user.dto.USER_DTO;
import com.spring.app.project.user.dto.USER_STATUS;

public interface IUserService {

	//회원추가
	void insertUser(USER_DTO dto);
	//이메일 인증완료된 이메일 추가
	void insertUStatus(USER_STATUS dto);
	
	//이메일 인증 성공
	void updateUStatus(String email ,  String status);
	
	//로그인
	USER_DTO selectUser(String user_id);
	
	USER_DTO selectUserEmail(String email);

	//검색
	USER_STATUS selectUSEmail(String email);
	
	//비밀번호 찾기
	USER_DTO selectUserEmailId(String email , String user_id);
	//임시비밀번호
	void updateUserPw(@Param("user_id") String user_id , @Param("code") String code);
	
	//회원정보 수정
	void updateUser(USER_DTO user , String user_id);

	public List<Recipe_DTO> myRecipeList(String user_id ,int page);
	
	public int myRecipeCnt(String user_id);
	public List<RecipeComent_DTO> myRecipeComments(String user_id, int page);

	public int myRecipeCommentsCnt(@Param("user_id") String user_id);
	
	//삭제
	public void deleteUStatus( String email );
	
	public void deleteUser( String email);
}
