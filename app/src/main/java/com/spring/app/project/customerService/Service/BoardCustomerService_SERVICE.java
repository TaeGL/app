package com.spring.app.project.customerService.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.app.project.customerService.dao.IBoardCustomerService_DAO;
import com.spring.app.project.customerService.dto.BoardCustomerService_DTO;
import com.spring.app.project.customerService.dto.BoardQuestionToAdmin_DTO;
import com.spring.app.project.customerService.dto.QuestionComments_DTO;
import com.spring.app.project.recipe.dto.Recipe_DTO;


@Service
public class BoardCustomerService_SERVICE implements IBoardCustomerService_SERVICE{

	@Autowired
	IBoardCustomerService_DAO csDao;
	
	@Override
	public void csInsert(BoardCustomerService_DTO board) {
		csDao.csInsert(board);
	}

	@Override
	public BoardCustomerService_DTO selectCsAll() {
		return csDao.selectCsAll();
	}

	@Override
	public int boardCSTotalCnt() {
		return csDao.boardCSTotalCnt();
	}


	@Override
	public List<BoardCustomerService_DTO> boardCSList(int page) {
		int recipe_total_cnt;
		int last = page*10;
		int first = last -9;
		
		
		return csDao.boardCSList(first,last);
	}

	@Override
	public BoardCustomerService_DTO selectCsByBno(int bNo) {
		return csDao.selectCsByBno(bNo);
	}

	@Override
	public void updateCs(BoardCustomerService_DTO board) {
		csDao.updateCs(board);
	}

	@Override
	public void deleteCs(int bNo) {
		csDao.deleteCs(bNo);
	}

	@Override
	public List<BoardQuestionToAdmin_DTO> questionToAdminListByUserId( String user_id , int page) {
		int recipe_total_cnt;
		int last = page*10;
		int first = last -9;
		return csDao.questionToAdminListByUserId(first, last,user_id);
	}

	@Override
	public int questionTotalCntByUserId(String user_id) {
		return csDao.questionTotalCntByUserId(user_id);
	}

	@Override
	public void insertQuestion(BoardQuestionToAdmin_DTO board) {
		csDao.insertQuestion(board);
	}

	@Override
	public BoardQuestionToAdmin_DTO selectQuestionByBno(int bNo) {
		
		return csDao.selectQuestionByBno(bNo);
	}

	@Override
	public void deleteQuestion(int bNo) {
		csDao.deleteQuestion(bNo);
	}

	@Override
	public void insertQuestionComment(QuestionComments_DTO dto) {
		System.out.println("1111");
		csDao.insertQuestionComment(dto);
	}

	@Override
	public QuestionComments_DTO selectQuestionCommentByBno(int bNo) {
		
		return csDao.selectQuestionCommentByBno(bNo);
		
	}

	@Override
	public void deleteQuestionComments(int cNo) {
		csDao.deleteQuestionComments(cNo);
	}

	@Override
	public QuestionComments_DTO selectQuestionCommentByCno(int cNo) {
		return csDao.selectQuestionCommentByCno(cNo);
	}


	@Override
	public int questionTotalCnt() {
		return csDao.questionTotalCnt();
	}

	@Override
	public List<BoardQuestionToAdmin_DTO> questionToAdminList(int page) {
		int last = page*10;
		int first = last -9;
		return csDao.questionToAdminList(first, last);
	}

	@Override
	public void updateQuestionToAdmin(BoardQuestionToAdmin_DTO dto) {
		csDao.updateQuestionToAdmin(dto);
	}
	

}
