package com.spring.app.project.customerService.Service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.spring.app.project.customerService.dto.BoardCustomerService_DTO;
import com.spring.app.project.customerService.dto.BoardQuestionToAdmin_DTO;
import com.spring.app.project.customerService.dto.QuestionComments_DTO;
import com.spring.app.project.recipe.dto.Recipe_DTO;


public interface IBoardCustomerService_SERVICE {
	public void csInsert(BoardCustomerService_DTO board);
	
	public BoardCustomerService_DTO selectCsAll();
	
	public int boardCSTotalCnt();

	public List<BoardCustomerService_DTO> boardCSList(int page);
	
	public BoardCustomerService_DTO selectCsByBno( int bNo);
	
	public void updateCs( BoardCustomerService_DTO board);
	
	public void deleteCs( int bNo );
	
	public List<BoardQuestionToAdmin_DTO> questionToAdminListByUserId( String user_id, int page);
	
	public List<BoardQuestionToAdmin_DTO> questionToAdminList(int page);
	
	public int questionTotalCntByUserId(String user_id);
	
	public void insertQuestion( BoardQuestionToAdmin_DTO board );
	
	public BoardQuestionToAdmin_DTO selectQuestionByBno( int bNo);
	
	public void deleteQuestion( int bNo );

	public void insertQuestionComment(QuestionComments_DTO dto);
	
	public QuestionComments_DTO selectQuestionCommentByBno( int bNo);
	
	public QuestionComments_DTO selectQuestionCommentByCno( int cNo);
	
	public void deleteQuestionComments( int cNo);

	public void updateQuestionToAdmin(BoardQuestionToAdmin_DTO dto );
	
	public int questionTotalCnt();
}
