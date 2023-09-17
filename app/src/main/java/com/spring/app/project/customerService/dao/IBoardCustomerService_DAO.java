package com.spring.app.project.customerService.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.spring.app.project.customerService.dto.BoardCustomerService_DTO;
import com.spring.app.project.customerService.dto.BoardQuestionToAdmin_DTO;
import com.spring.app.project.customerService.dto.QuestionComments_DTO;
import com.spring.app.project.recipe.dto.Recipe_DTO;

public interface IBoardCustomerService_DAO {
	// 공지사항 등록
	public void csInsert( BoardCustomerService_DTO board);
	// 공지사항 조회
	public BoardCustomerService_DTO selectCsAll();
	// 모든 공지사항 갯수
	public int boardCSTotalCnt();
	// 공지사항 first 부터 last까지 조회
	public List<BoardCustomerService_DTO> boardCSList(@Param("first") int first,@Param("last") int last);
	// 공지사항 조회(board_no)
	public BoardCustomerService_DTO selectCsByBno(@Param("bNo") int bNo);
	// 공지사항 수정
	public void updateCs( BoardCustomerService_DTO board);
	// 공지사항 삭제(board_no)
	public void deleteCs(@Param("bNo") int bNo );
	// 1:1문의 first부터 last까지 조회 where user_id
	public List<BoardQuestionToAdmin_DTO> questionToAdminListByUserId( @Param("first") int first,@Param("last") int last,@Param("user_id") String user_id);
	// 1:1문의 first부터 last까지 조회
	public List<BoardQuestionToAdmin_DTO> questionToAdminList( @Param("first") int first,@Param("last") int last);
	// user_id로 등록한 모든 1:1 문의 조회
	public int questionTotalCntByUserId(@Param("user_id") String user_id);
	// 1:1문의 등록
	public void insertQuestion(BoardQuestionToAdmin_DTO board);
	// 1:1문의 조회 (board_no)
	public BoardQuestionToAdmin_DTO selectQuestionByBno(@Param("bNo") int bNo);
	// 1:1문의 삭제 (board_no)
	public void deleteQuestion(@Param("bNo") int bNo);
	// 1:1 문의 댓글 등록
	public void insertQuestionComment(QuestionComments_DTO dto);
	// 1:1 문의 댓글 조회 
	public QuestionComments_DTO selectQuestionCommentByBno(@Param("bNo") int bNo);
	public QuestionComments_DTO selectQuestionCommentByCno(@Param("cNo") int cNo);
	// 1:1 문의 댓글 삭제
	public void deleteQuestionComments(@Param("cNo") int cNo);
	// 1:1 문의 댓글 수정
	public void updateQuestionToAdmin(BoardQuestionToAdmin_DTO dto );
	// 모든 1:1 문의 갯수
	public int questionTotalCnt();
}
	
