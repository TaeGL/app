package com.spring.app.project.customerService.Controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.resource.CssLinkResourceTransformer;

import com.spring.app.project.customerService.Service.IBoardCustomerService_SERVICE;
import com.spring.app.project.customerService.dto.BoardCustomerService_DTO;
import com.spring.app.project.customerService.dto.BoardQuestionToAdmin_DTO;
import com.spring.app.project.customerService.dto.QuestionComments_DTO;
import com.spring.app.project.recipe.dto.Recipe_DTO;
import com.spring.app.project.recipe.service.IRecipeService;
import com.spring.app.project.user.dto.USER_DTO;

@Controller
public class BoardCustomerService_Controller {

	@Autowired
	IBoardCustomerService_SERVICE csbService;
	@Autowired
	IRecipeService rService;
	
	// 고객센터 홈 공지사항
	@GetMapping(value = "/customerManage/customerService")
	public String customerService(Model model,@RequestParam(required = false, defaultValue = "1") int page) {
		
			List<BoardCustomerService_DTO> list =  csbService.boardCSList(page);
			
			int pageSize = 10;
			int firstPage = ((page-1)/pageSize+1);
			int lastPage = firstPage+pageSize-1;
			int totalPage = (csbService.boardCSTotalCnt()/(pageSize+1))+1;
			lastPage = lastPage>totalPage?totalPage:lastPage;
			
			model.addAttribute("totalPage" , totalPage);
			model.addAttribute("list" ,list ); 
			model.addAttribute("page" , page );
			model.addAttribute("firstPage" , firstPage);
			model.addAttribute("lastPage" , lastPage);
		return "/customerManage/customerService";
		
	}
	// 공지사항 등록
	@GetMapping(value = "/customerManage/csInsertView")
	public String csInsertView(Model model,@RequestParam(required = false, defaultValue = "1") int page) {
		
		return "/customerManage/csInsertView";
	}
	
	@PostMapping(value = "/customerManage/csInsert")
	public String csInsert(Model model , BoardCustomerService_DTO board) {
		csbService.csInsert(board);
		return "redirect:/customerManage/customerService";
	}
	// 공지사항 정보
	@GetMapping(value = "/customerManage/customerServiceInfo/{bNo}")
	public String customerServiceInfo(Model model ,@PathVariable int bNo ){
		model.addAttribute("board", csbService.selectCsByBno(bNo));
		
		
		return "/customerManage/customerServiceInfo";
	}
	
	// 공지사항 수정
	@PostMapping(value = "/customerManage/customerServiceInfoEditView")
	public String csInfoEditView(Model model , BoardCustomerService_DTO board ) {
		model.addAttribute("board", board);
		return "/customerManage/customerServiceInfoEdit";
	}
	
	@PostMapping(value = "/customerManage/customerServiceInfoEdit")
	public String csInfoEdit(Model model , BoardCustomerService_DTO board ) {
		csbService.updateCs(board);
		return "redirect:/customerManage/customerServiceInfo/"+board.getBoard_no();
	}
	
	// 공지사항 삭제
	@GetMapping(value = "/customerManage/deleteCSView")
	public String deleteCSView(Model model, int bNo) {
		model.addAttribute("bNo", bNo );
		return "/customerManage/deleteCSView";
		
	}
	
	@ResponseBody
	@PostMapping(value = "/customerManage/deleteCSLogic")
	public Map<String,Object> deleteCS(Model model, @RequestParam Map<String, Object> data ) {
		
		int bNo = Integer.parseInt((String)data.get("bNo"));
		if(csbService.selectCsByBno(bNo) ==null) {
			data.put("result", "존재하지않는 게시글입니다");
		}else {
			csbService.deleteCs(bNo);
			if(csbService.selectCsByBno(bNo) !=null) {
				data.put("result", "게시글 삭제에 실패하엿습니다!");
			}else {
				data.put("result", "게시글이 성공적으로 삭제되었습니다!");
			}
		}
		return data;
	}
	
	// 1:1질문 게시판
	@GetMapping(value = "/customerManage/questionToAdmin")
	public String questionToAdmin(Model model,@RequestParam(required = false, defaultValue = "1") int page, HttpSession session) {
			
			if(session.getAttribute("login") !=null) {
				USER_DTO login = (USER_DTO)session.getAttribute("login");
				List<BoardQuestionToAdmin_DTO> list =  csbService.questionToAdminListByUserId(login.getUser_id(),page);
				
				int pageSize = 10;
				int firstPage = ((page-1)/pageSize+1);
				int lastPage = firstPage+pageSize-1;
				int totalPage = (csbService.questionTotalCntByUserId(login.getUser_id())/(pageSize+1))+1;
				lastPage = lastPage>totalPage?totalPage:lastPage;
				
				model.addAttribute("list" ,list );
				model.addAttribute("totalPage" , totalPage);
				model.addAttribute("page" , page );
				model.addAttribute("firstPage" , firstPage);
				model.addAttribute("lastPage" , lastPage);
				return "/customerManage/questionToAdmin";
			}else {
				model.addAttribute("result", false);
				return "/member/login/loginView";
			}
		
	}
	// 1:1 문의등록
	@GetMapping(value = "/customerManage/questionInsert")
	public String questionInsertView(Model model , HttpSession session) {
		
		
		if(session.getAttribute("login") !=null) {
			USER_DTO login = (USER_DTO)session.getAttribute("login");
			
				//로그인한 유저가 글쓰기를 누른경우
			model.addAttribute("user_id", login.getUser_id());
			return "/customerManage/questionInsertView";
			
		}else {
			model.addAttribute("result", false);
			return "/member/login/loginView";
		}
		
	}
	
	@PostMapping(value = "/customerManage/questionInsert")
	public String questionInsert(Model model , HttpSession session , BoardQuestionToAdmin_DTO board){

		if(session.getAttribute("login") !=null) {
			USER_DTO login = (USER_DTO)session.getAttribute("login");
			
			if(login.getUser_id().equals(board.getUser_id())) {
				//로그인한 유저가 글쓰기를 누른경우
				csbService.insertQuestion(board);
				return "redirect:/customerManage/questionToAdmin";
			}else {
				session.removeAttribute("login");
				model.addAttribute("result", false);
				return "/member/login/loginView";
			}
			
		}else {
			model.addAttribute("result", false);
			return "/member/login/loginView";
		}
		
	}
	// 1:1 문의 정보
	@GetMapping(value = "/customerManage/questionToAdminInfo/{bNo}")
	public String questionToAdminInfo(Model model ,@PathVariable("bNo")  int bNo, HttpSession session) {
		model.addAttribute("board", csbService.selectQuestionByBno(bNo));
		model.addAttribute("bNo",  bNo);
		
		if(session.getAttribute("login") !=null) {
			if(csbService.selectQuestionCommentByBno(bNo)!=null) {
				// 문의글에 답글이 등록되어잇음
				model.addAttribute("questionCommentsOn", "false");
				model.addAttribute("comments", csbService.selectQuestionCommentByBno(bNo)); 
				
			}else {
				model.addAttribute("questionCommentsOn", "true");
			}
			
		}else {
			model.addAttribute("result", false);
			return "/member/login/loginView";
		}
		return "/customerManage/questionToAdminInfo";
	}
	// 1:1 문의 삭제
	@GetMapping(value = "/customerManage/deleteQuestionView")
	public String deleteQuestionView(Model model, int bNo, HttpSession session) {
		if(session.getAttribute("login") !=null) {
			USER_DTO login = (USER_DTO)session.getAttribute("login");
			model.addAttribute("bNo", bNo );
			return "/customerManage/deleteQuestionView";
		}else {
			model.addAttribute("result", false);
			return "/member/login/loginView";
		}
		
	}
	
	@ResponseBody
	@PostMapping(value = "/customerManage/deleteQuestionLogic")
	public Map<String,Object> deleteQuestionLogic(Model model , @RequestParam Map<String, Object> data , HttpSession session) {
		int bNo = Integer.parseInt((String)data.get("bNo"));
		
		
		
		if(session.getAttribute("login") !=null) {
			USER_DTO login = (USER_DTO)session.getAttribute("login");
			BoardQuestionToAdmin_DTO board =  csbService.selectQuestionByBno(bNo);
			if(login.getUser_id().equals(board.getUser_id())) {
				//로그인한 유저가 문의철회(삭제)를 누른경우
				csbService.deleteQuestion(bNo);
				data.put("nextUrl" , "/customerManage/questionToAdmin");
			}else {
				session.removeAttribute("login");
				model.addAttribute("result", false);
				data.put("nextUrl" ,  "/member/login/loginView");
			}
			
		}else {
			model.addAttribute("result", false);
			data.put("nextUrl" , "/member/login/loginView");
		}
		return data;
	}
	// 1:1 질문 답글 등록
	@PostMapping(value = "/customerManage/insertQuestionComments")
	public String insertQuestion(Model model , QuestionComments_DTO dto) {
		csbService.insertQuestionComment(dto);
		
		// 문의글에 답변이 달렷다면 문의글의 상태를 답변완료로 만들어야함
		// 등록된 질문 답글의 게시글 번호를 불러와서 ready 상태로 만듬
		BoardQuestionToAdmin_DTO board = csbService.selectQuestionByBno(dto.getBoard_no());
		board.setBoard_state("ready");
		csbService.updateQuestionToAdmin(board);
		
		model.addAttribute("comments",  csbService.selectQuestionCommentByBno(dto.getBoard_no()));
		model.addAttribute("bNo", dto.getBoard_no());
		return "redirect:/customerManage/questionToAdminInfo/{bNo}";
	}
	// 1:1 질문 답글 삭제
	@GetMapping(value ="/customerManage/deleteQuestionCommentsView")
	public String deleteQuestionComments(Model model , int cNo , HttpSession session) {
		if(session.getAttribute("login") !=null) {
			model.addAttribute("cNo", cNo);
			return "/customerManage/deleteQuestionCommentsView";
		}else {
			model.addAttribute("result", false);
			return "/member/login/loginView";
		}
	}
	
	@ResponseBody
	@PostMapping(value = "/customerManage/deleteQuestionCommentsLogic")
	public Map<String,Object> deleteQuestionCommentsLogic(Model model , @RequestParam Map<String, Object> data , HttpSession session) {
		int cNo = Integer.parseInt((String)data.get("cNo")); 
		
		if(session.getAttribute("login") !=null) {
			USER_DTO login = (USER_DTO)session.getAttribute("login");
			if(login.getUser_grade().equals("운영자")) {
				//로그인한 유저가 운영자일 경우에만 삭제진행
				
				QuestionComments_DTO comment= csbService.selectQuestionCommentByCno(cNo);
				BoardQuestionToAdmin_DTO board = csbService.selectQuestionByBno(comment.getBoard_no());
				data.put("nextUrl" , "/customerManage/questionToAdminInfo/"+comment.getBoard_no());
				csbService.deleteQuestionComments(cNo);
				
				// 문의글에 답변이 삭제되었다면 문의글 상태를 none으로 만들어야함
				board.setBoard_state("none");
				csbService.updateQuestionToAdmin(board);
			}else {
				session.removeAttribute("login");
				model.addAttribute("result", false);
				data.put("nextUrl" ,  "/member/login/loginView");
			}
			
		}else {
			model.addAttribute("result", false);
			data.put("nextUrl" , "/member/login/loginView");
		}
		return data;
	}
	// 관리자 페이지 -> 1:1 문의 목록
	@GetMapping(value = "/admin/questionManage")
	public String questionManage(Model model, HttpSession session ) {
		if(session.getAttribute("login") !=null) {
			USER_DTO login = (USER_DTO)session.getAttribute("login");
			if(login.getUser_grade().equals("운영자")) {
				
				return "redirect:/admin/questionList";
			}else {
				session.removeAttribute("login");
				model.addAttribute("result", false);
				return "/member/login/loginView";
			}
			
		}else {
			model.addAttribute("result", false);
			return "/member/login/loginView";
		}
	}
	
	@GetMapping(value = "/admin/questionList")
	public String questionList(Model model,@RequestParam(required = false, defaultValue = "1") int page, HttpSession session ) {
		if(session.getAttribute("login") !=null) {
			USER_DTO login = (USER_DTO)session.getAttribute("login");
			if(login.getUser_grade().equals("운영자")) {
				
				List<BoardQuestionToAdmin_DTO> list =  csbService.questionToAdminList(page);
				
				int pageSize = 10;
				int firstPage = ((page-1)/pageSize+1);
				int lastPage = firstPage+pageSize-1;
				int totalPage = (csbService.questionTotalCnt()/(pageSize+1))+1;
				lastPage = lastPage>totalPage?totalPage:lastPage;
				
				model.addAttribute("list" ,list );
				model.addAttribute("totalPage" , totalPage);
				model.addAttribute("page" , page );
				model.addAttribute("firstPage" , firstPage);
				model.addAttribute("lastPage" , lastPage);
				
				return "/admin/questionList";
			}else {
				session.removeAttribute("login");
				model.addAttribute("result", false);
				return "/member/login/loginView";
			}
			
		}else {
			model.addAttribute("result", false);
			return "/member/login/loginView";
		}
	}
	
	
}
