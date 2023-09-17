package com.spring.app.project.user.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.spring.app.project.recipe.dto.RecipeComent_DTO;
import com.spring.app.project.recipe.dto.Recipe_DTO;
import com.spring.app.project.user.dto.USER_DTO;
import com.spring.app.project.user.dto.USER_STATUS;

public interface IUSER_DAO {

	//회원추가
	void insertUser(USER_DTO dto);
	void insertUStatus(USER_STATUS dto);
	//이메일 인증 성공
	void updateUStatus(@Param("email") String email , @Param("status") String status);
	
	//로그인
	USER_DTO selectUser(String user_id);
	USER_DTO selectUserEmail(String email);
	
	// 검색 
	USER_STATUS selectUSEmail(String email);
	
	//비밀번호찾기
	USER_DTO selectUserEmailId(@Param("email") String email , @Param("user_id") String user_id);
		
	//임시 비밀번호
	void updateUserPw(@Param("user_id") String user_id , @Param("code") String code);
	
	// 회원정보 수정
	void updateUser(@Param("user") USER_DTO user ,@Param("user_id") String user_id);
	
	// 내 레시피 목록
	public List<Recipe_DTO> myRecipeList(@Param("first") int first,@Param("last") int last,@Param("user_id") String user_id);
	// 내 댓글 목록
	public List<RecipeComent_DTO> myRecipeComments(@Param("first") int first,@Param("last") int last,@Param("user_id") String user_id);
	// 내 모든 레시피 갯수
	public int myRecipeCnt(@Param("user_id") String user_id);
	// 내 모든 댓글 개수
	public int myRecipeCommentsCnt(@Param("user_id") String user_id);
	
	// 삭제
	public void deleteUStatus(@Param("email") String email );
	// 유저 삭제
	public void deleteUser(@Param("email") String email);
}
