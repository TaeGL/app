package com.spring.app.project.user.controller;

import java.lang.ProcessBuilder.Redirect;
import java.lang.reflect.Method;
import java.net.http.HttpRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.app.project.recipe.dto.RecipeComent_DTO;
import com.spring.app.project.recipe.dto.Recipe_DTO;
import com.spring.app.project.recipe.service.IRecipeComentService;
import com.spring.app.project.recipe.service.IRecipeService;
import com.spring.app.project.tool.Ran;
import com.spring.app.project.user.dao.IUSER_DAO;
import com.spring.app.project.user.dto.USER_DTO;
import com.spring.app.project.user.dto.USER_STATUS;
import com.spring.app.project.user.service.IUserService;

import oracle.net.aso.u;
import oracle.sql.ARRAY;

@Controller
public class UserController {

	@Autowired
	IUserService uService;
	@Autowired
	IRecipeService rService;
	@Autowired
	IRecipeComentService rcService;
	
	@Autowired
	private JavaMailSender mailSender;
	
//	회원가입
	@RequestMapping(value = "/member/joinView", method = RequestMethod.GET)
	public String joinView(Locale local , Model model){
		return "/member/join/emailCheck";
	}
	
	@RequestMapping(value = "/member/joinViewGo", method = RequestMethod.POST)
	public String joinView(USER_DTO dto, Locale local , Model model){
		uService.insertUser(dto);
		return "redirect:/member/joinOk";
	}
	
	@GetMapping(value = "/member/joinOk")
	public String joinOk(Model model) {
		
		return "/member/joinOk";
	}
	
	// 회원가입시 이메일 체크
	
	@ResponseBody
	@PostMapping(value = "/member/join/checkEmailLogic")
	public String joinCheckEmail( @RequestParam Map<String, Object> data, Model model, HttpServletRequest request)  {
		String email = (String)data.get("email");
		
		
		if(uService.selectUserEmail(email)!=null) {
			// 해당 이메일로 등록된 아이디가 잇다면
			
			return "true";
		}else {
			// 해당 이메일로 등록된 아이디가 없다면
			certifyEmail(model, email, request);
			return "false";
		}
		
	}
	
	
	
	// 회원가입시 인증 이메일 보내기
	@GetMapping(value = "/member/join/certifyEmail")
	public void certifyEmail(Model model, String email ,  HttpServletRequest request) {
		Ran ran = new Ran();
		String code =  ran.getKey(false, 4);
		MimeMessage mail =  mailSender.createMimeMessage();
		USER_STATUS dto = new USER_STATUS(email, null, code);
		if(uService.selectUSEmail(email) == null) {
			// 해당 이메일로 인증 진행이 안되엇다면
			uService.insertUStatus(dto);
		}else {
			// 해당 이메일로 인증 메일이 한번이라도 보내진 경우
			// 해당 이메일로 등록된 user_status의 status 업데이트
			uService.updateUStatus(email, code);
			
		}
		// 이후 무조건 USER_STATUS 테이블에 해당 이메일로 등록된 데이터가 잇으므로
		// update문을 사용하여 해당 이메일로 등록된 상태를 on(사용가능)으로 변경해주어야함
		
		String htmlStr = "<h2>안녕하세요 : RECIPE 입니다!</h2><br><br>" 
				+ "<h3> 이메일 인증 </h3>" + "<p>인증하기 버튼을 누르시면 로그인을 하실 수 있습니다 : " 
				+ "<a href='http://localhost:9030" + request.getContextPath() + "/member/join/successEmail?email="+ email +"&code="+code+ "'>인증하기</a></p>"
				+ "(잘못 전달된 메일이라면 무시하셔도 됩니다)";
		try {
			mail.setSubject("[본인인증] 회원가입 인증메일입니다", "utf-8");
			mail.setText(htmlStr, "utf-8", "html");
			mail.addRecipient(RecipientType.TO, new InternetAddress(email));
			mailSender.send(mail);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
	}
	
	//이메일 인증 완료
	@GetMapping(value ="/member/join/successEmail")
	public String successEmail( Model model , String email,String code) {
		// 사용자에게 회원가입 인증 메일을 보낼 때 만들엇던 임의의 값 4개가 일치하는지 확인
		if(uService.selectUSEmail(email).getUser_status().equals(code)) {
			// 저장된 값과 GET방식으로 불러온 code값이 일치한다면 정상 인증이므로 회원가입 페이지로 이동 
			if(uService.selectUSEmail(email)!=null) {
				// 이메일 정상 인증
				uService.updateUStatus(email,"y");
				
			}
			model.addAttribute("email",email);
			return "/member/joinView";
		}else {
			// 정상 인증이 아니므로 홈 으로 이동
			if( uService.selectUserEmail(email)!=null){
				// 해당 이메일로 회원가입이 되어잇다면
				model.addAttribute("result" , "userReady");
				return "/member/joinView";
			}else if(uService.selectUSEmail(email)!=null){
				// 사용자가 이메일 인증버튼을 새로 누른경우
				// 기존의 인증 메일은 유통기한 만료이므로
				model.addAttribute("result", "emailExpires");
				return "/member/joinView";
			}else {
				return "redirect:/";
			}
		}
	}
	
	
//	로그인 
	@RequestMapping(value = "/member/login/loginView",method = RequestMethod.GET)
	public String loginView(HttpSession session, Locale local , Model model){
		
		if(session.getAttribute("login") !=null) {
			return "redirect:/";
		}else {
			session.removeAttribute("login");
			return "/member/login/loginView";
		}
	}
	
// 아이디 체크
	@GetMapping(value = "member/join/checkIdView")
	public String checkId(Model model, @RequestParam String inputId) {
		model.addAttribute("inputId" , inputId);
		if(uService.selectUser(inputId) !=null){
			//아이디가 존재한다면
			model.addAttribute("result" , "false");
			return "member/join/checkIdView";
		}else {
			model.addAttribute("result" , "true");
			return "member/join/checkIdView";
		}
		
	}
	
	@PostMapping("/member/join/checkIdLogic")
	public String checkIdLogic(Model model,  String inputId2) {
		String id =  inputId2.trim();
		USER_DTO user = uService.selectUser(id);
		if(user !=null) {
			model.addAttribute("result", "false");
			model.addAttribute("inputId" , id);
		}else {
			model.addAttribute("result", "true");
			model.addAttribute("inputId" , id);
		}
		return "member/join/checkIdView";
	}
	
	// 아이디 찾기
	@GetMapping(value = "/member/login/findId")
	public String findId(Model model) {
		
		return "/member/login/findId";
	}
	
	
	
	@ResponseBody
	@PostMapping(value = "/member/login/findId")
	public Map<String, Object> findId(Model model, @RequestParam Map<String, Object> data) {
		
		String email = (String)data.get("email");
		USER_DTO user = uService.selectUserEmail(email);
		if(user !=null) {
			// 사용자가 입력한 이메일로 등록한 아이디가 존재한다면
			data.put("id",user.getUser_id());
		}
		return data;
	}
	
	// 비밀번호 찾기
	@GetMapping(value = "/member/login/findPw")
	public String findPw(Model model) {
		return "/member/login/findPw";
	}
	
	@ResponseBody
	@PostMapping(value = "/member/login/findPw")
	public Map<String,Object> findPw(Model model , @RequestParam Map<String, Object> data, HttpServletRequest request){
		MimeMessage mail = mailSender.createMimeMessage();
		Ran ran = new Ran();
		String code = ran.getKey(false, 4);
		
		String email = (String)data.get("email");
		String user_id = (String)data.get("user_id");
		USER_DTO user = uService.selectUserEmailId(email, user_id);
		if(user !=null) {
			// 사용자가 입력한 이메일 아이디로 검색한 회원정보가 존재한다면
			String htmlStr = "<h2>안녕하세요 :p RECIPE~ 입니다!</h2><br><br>" 
					+ "<h3> 임시 비밀번호 코드  </h3>"  
					+ "<p>"+code+ "</p>"
					+ "(잘못 전달된 메일이라면 이메일을 무시하셔도 됩니다)";
			try {
				mail.setSubject("RECIPE 임시 비밀번호", "utf-8");
				mail.setText(htmlStr, "utf-8", "html");
				mail.addRecipient(RecipientType.TO, new InternetAddress(email));
				mailSender.send(mail);
			} catch (MessagingException e) {
				e.printStackTrace();
			}
			
			uService.updateUserPw(user_id, code);
			data.put("result" , "true");
			
		}
		return data;
	}
	
	
	
	
	// 로그인 뷰
	@RequestMapping(value = "/member/login/loginView",method = RequestMethod.POST)
	public String login(String user_id,String user_pw, HttpSession session, Model model) {
		USER_DTO dto = uService.selectUser(user_id);
		if(dto!=null) {
			if(dto.getUser_pw().equals(user_pw)) {
				// 로그인 성공 아이디
				session.setAttribute("login", dto);
				return "redirect:/";
			}else { 
				// 로그인 실패시 (비밀번호)
				model.addAttribute("login_fail", "pw");
				return "/member/login/loginView";
			}
			
		}else {//아이디가 존재하지 않는다면
			model.addAttribute("login_fail", "id");
			return "/member/login/loginView";
		}
	}

	
	
	@RequestMapping(value = "/member/logout" , method = RequestMethod.GET)
	public String logout(Locale local, HttpSession session) {
		
		session.invalidate();
		return "redirect:/";
	}
	
		
	//	마이레시피
		@RequestMapping(value = "/member/myPage/myRecipe")
		public String myPage(Model model,HttpSession session,@RequestParam(required = false, defaultValue = "1") int page){
			if(session.getAttribute("login") !=null) {
				USER_DTO user = (USER_DTO)session.getAttribute("login");
				List<Recipe_DTO> list =  uService.myRecipeList(user.getUser_id(), page);
				
				int pageSize = 10;
				int firstPage = ((page-1)/pageSize+1);
				int lastPage = firstPage+pageSize-1;
				int totalPage = (uService.myRecipeCnt(user.getUser_id())/(pageSize+1))+1;
				lastPage = lastPage>totalPage?totalPage:lastPage;
				
				model.addAttribute("totalPage" , totalPage);
				model.addAttribute("recipes" ,list ); 
				model.addAttribute("page" , page );
				model.addAttribute("firstPage" , firstPage);
				model.addAttribute("lastPage" , lastPage);
				return "/member/myPage/myRecipe";
			}else {
				return "redirect:/";
			}
		}
		
		
//		마이리뷰
		@RequestMapping(value = "/member/myPage/myReview")
		public String myReview(Model model,HttpSession session){
			
			if(session.getAttribute("login") !=null) {
				return "/member/myPage/myReview";
			}else {
				return "redirect:/";
			}
		}
		
		

//		내댓글
		@RequestMapping(value = "/member/myPage/myComments")
		public String myComments(Model model,HttpSession session,@RequestParam(required = false, defaultValue = "1") int page){
			if(session.getAttribute("login") !=null) {
				USER_DTO user = (USER_DTO)session.getAttribute("login");
				List<RecipeComent_DTO> list =  uService.myRecipeComments(user.getUser_id(), page);
				
				int pageSize = 10;
				int firstPage = ((page-1)/pageSize+1);
				int lastPage = firstPage+pageSize-1;
				int totalPage = (uService.myRecipeCommentsCnt(user.getUser_id())/(pageSize+1))+1;
				lastPage = lastPage>totalPage?totalPage:lastPage;
				
				int listCnt = list.size();
				model.addAttribute("totalPage" , totalPage);
				model.addAttribute("recipes" ,list ); 
				model.addAttribute("page" , page );
				model.addAttribute("firstPage" , firstPage);
				model.addAttribute("lastPage" , lastPage);
				return "/member/myPage/myComments";
			}else {
				return "redirect:/";
			}
		}

//		내정보 수정
		@GetMapping(value = "/member/myPage/myInfoEdit")
		public String myInfoEdit(Model model,HttpSession session){
			
			if( (USER_DTO)session.getAttribute("login") !=null) {
				model.addAttribute("user", (USER_DTO)session.getAttribute("login"));
				return "/member/myPage/myInfoEdit";
			}else {
				model.addAttribute("result", false);
				return "/member/login/loginView";
			}
		}
		@PostMapping(value = "/member/myPage/myInfoEdit")
		public String myInfoEditDo(Model model, USER_DTO dto,HttpSession session){
			USER_DTO user = uService.selectUser(dto.getUser_id()); //			System.out.println("dto : " + dto); System.out.println("user_id : " + dto.getUser_id()); System.out.println("user_pw : " + dto.getUser_pw()); System.out.println("회원정보 : " + user);
			if(user !=null) {
				// 전달된 회원정보가 DB에 존재하는 경우
				uService.updateUser(dto, user.getUser_id());
				
				session.setAttribute("login", dto);
				model.addAttribute("result" , "true");
			}else {
				model.addAttribute("result" , "false");
			}
			
			if( (USER_DTO)session.getAttribute("login") !=null) {
				model.addAttribute("user", (USER_DTO)session.getAttribute("login"));
				return "/member/myPage/myInfoEdit";
			}else {
				model.addAttribute("result", false);
				return "/member/login/loginView";
			}
			
		}
		
		// 회원탈퇴 
		@GetMapping(value = "/member/myPage/myAccDeleteView")
		public String myAccDeleteView(Model model ,  HttpServletRequest request ,HttpSession session) {
			
			if( (USER_DTO)session.getAttribute("login") !=null) {
				USER_DTO login = (USER_DTO)session.getAttribute("login");	
				String email = login.getUser_email();
				MimeMessage mail =  mailSender.createMimeMessage();
				Ran ran = new Ran();
				String code = ran.getKey(false, 6);
				
				String id = uService.selectUserEmail(email).getUser_id();
				
				if(uService.selectUSEmail(email)==null) {
					USER_STATUS dto = new USER_STATUS(email, id, code);
					uService.insertUStatus(dto);
				}
				uService.updateUStatus(email, code);
				String htmlStr = "<h2>안녕하세요 : RECIPE 입니다!</h2><br><br>" 
						+ "<h3> 회원탈퇴 이메일 인증 </h3>" + "<p>회원탈퇴 인증번호 입니다 "
						+ "<h5>"+code+"</h5>" 
						+ "(잘못 전달된 메일이라면 무시하셔도 됩니다)";
				try {
					mail.setSubject("[본인인증] 회원탈퇴 인증 메일입니다", "utf-8");
					mail.setText(htmlStr, "utf-8", "html");
					mail.addRecipient(RecipientType.TO, new InternetAddress(email));
					mailSender.send(mail);
				} catch (MessagingException e) {
					e.printStackTrace();
				}
				model.addAttribute("email", email);
				
				return "/member/myPage/myAccDeleteView";
				
				
			}else {
				model.addAttribute("result", false);
				return "/member/login/loginView";
			}
			
		}
		
		
		@ResponseBody
		@PostMapping(value = "/member/myPage/myAccDeleteLogic")
		public  Map<String,Object> myAccDeleteLogic(Model model , @RequestParam Map<String, Object> data, HttpSession session){
			
			String email = ""+data.get("email");
			String input_code = ""+data.get("input_code");
			
			USER_STATUS us = uService.selectUSEmail(email);
			USER_DTO user = uService.selectUserEmail(email);
			String user_id = user.getUser_id();
			if(us.getUser_status().equals(input_code)) {
				// 인증번호와 사용자가 입력한 코드가 같다면 삭제 실행
				rcService.deleteUserId(user_id); // 댓글삭제
				rService.deleteRecipeLikeByUserId(user_id); // 좋아요삭제
				rService.deleteUserId(user_id); // 레시피삭제
				
				uService.deleteUStatus(email); // 유저상태 삭제
				
				uService.deleteUser(email); // 유저 삭제
				session.removeAttribute("login");
				data.put("result", "true");
			}else {
				data.put("result", "code_fail");
			}
			return data;
			
		}
		
		
}
